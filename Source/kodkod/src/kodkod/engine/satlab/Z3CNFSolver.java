package kodkod.engine.satlab;

import com.microsoft.z3.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Z3CNFSolver implements SATSolver {

    private Context ctx;
    private Solver solver;

    private int variables = 0;

    private List<int[]> clauses;
    private Map<Integer, Expr> variableExprMap;

    private FuncDecl isTrue;

    private Status status = Status.UNKNOWN;

    public Z3CNFSolver() {
        //Global.setParameter("model.compact", "true");
        //Global.setParameter("smt.mbqi", "true");
        //Global.setParameter("smt.pull-nested-quantifiers", "true");
        //Global.setParameter("smt.mbqi.trace", "true");

        HashMap<String, String> cfg = new HashMap<>();
        //cfg.put("proof", "true");
        cfg.put("model", "true");

        ctx = new Context(cfg);
        solver = ctx.mkSolver();

        clauses = new ArrayList<>();
        variableExprMap = new HashMap<>();
    }

    @Override
    public int numberOfVariables() {
        return variables;
    }

    @Override
    public int numberOfClauses() {
        return clauses.size();
    }

    @Override
    public void addVariables(int numVars) {
        variables += numVars;
    }

    @Override
    public boolean addClause(int[] lits) {
        clauses.add(lits);
        return true;
    }

    @Override
    public boolean solve() throws SATAbortedException {

        Map<Integer, String> varStringMap = new HashMap<>();
        for (int i = 0; i < variables; i++) {
            varStringMap.put(i + 1, "" + (i + 1));
        }

        EnumSort UNIV = ctx.mkEnumSort("univ", varStringMap.values().toArray(new String[varStringMap.values().size()]));

        for (Expr expr : UNIV.getConsts()) {
            variableExprMap.put(Integer.parseInt(expr.toString().substring(1, expr.toString().length() - 1)), expr);
        }

        isTrue = ctx.mkFuncDecl("univ", new Sort[]{UNIV}, ctx.mkBoolSort());

        clauses.forEach(clause -> {
            BoolExpr[] exprs = new BoolExpr[clause.length];
            for (int i = 0; i < exprs.length; i++) {
                exprs[i] = (BoolExpr) ctx.mkApp(isTrue, variableExprMap.get(Math.abs(clause[i])));
                if (clause[i] < 0) {
                    exprs[i] = ctx.mkNot(exprs[i]);
                }
            }
            solver.add(ctx.mkOr(exprs));
        });

        status =  solver.check();
        return status.equals(Status.SATISFIABLE);
    }

    @Override
    public boolean valueOf(int variable) {
        if (!status.equals(Status.SATISFIABLE))
            return false;
        return solver.getModel().eval(isTrue.apply(variableExprMap.get(variable)), true).equals(ctx.mkTrue());
    }

    @Override
    public void free() {
        ctx = null;
        solver = null;
        clauses.clear();
        variableExprMap.clear();
        isTrue = null;
    }

    public static void main(String[] args) {
        Z3CNFSolver solver = new Z3CNFSolver();
        solver.addVariables(2);
        solver.addClause(new int[] {1, -2});
        solver.addClause(new int[] {-1, 2});
        solver.addClause(new int[] {1});
        solver.solve();
        for (int i = 0; i < solver.numberOfVariables(); i++) {
            System.out.println((i + 1) + ": " + solver.valueOf(i + 1));
        }
        solver.free();
    }
}
