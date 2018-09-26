package kodkod.engine.satlab;

import com.microsoft.z3.*;
import kodkod.ast.*;
import kodkod.ast.operator.FormulaOperator;
import kodkod.instance.Bounds;
import kodkod.instance.Instance;
import kodkod.instance.Tuple;
import kodkod.util.z3.Z3EliminatedFormulaConverter;
import kodkod.util.z3.Z3FormulaConverter;
import kodkod.util.z3.Z3FormulaConverterWithBV;
import kodkod.util.z3.Z3FormulaConverterWithInt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Z3Solver implements SATSolver {
    // Formula with (quantifier size >= 'ELIMINATION_THRESHOLD') will be applied to quantifier elimination.
    private static final int ELIMINATION_THRESHOLD = 4;

    private final ConverterType converterType = ConverterType.BV;

    private int BIT_SIZE = 8;
    private Sort UNIV;
    private Context ctx;
    Solver solver;
    private Goal goal;

    private Map<Expression, FuncDecl> funcDeclMap = new HashMap<>();

    private Status status = Status.SATISFIABLE;
    private Instance instance = null;

    private Set<Formula> unsatFormulaSet = new HashSet<>();
    private Set<Map.Entry<Relation, Tuple>> unsatTupleSet = new HashSet<>();

    private Set<Expr> possibleExprs = new HashSet<>();
    private Map<Expr, Map.Entry<Relation, Tuple>> exprTupleMap = new HashMap<>();
    private Map<BoolExpr, Formula> boolExprFormulaMap = new HashMap<>();
    private Map<BoolExpr, BoolExpr> assertionMap = new HashMap<>();

    private long solvingTime = 0;

    private Map<Integer, Object> integerObjectMap = new HashMap<>();

    enum ConverterType { ELIMINATED_BV, INTEGER, BV }

    public Z3Solver() {
        Global.setParameter("model.compact", "true");
        Global.setParameter("smt.mbqi", "true");
        Global.setParameter("smt.pull-nested-quantifiers", "true");
        Global.setParameter("smt.mbqi.trace", "true");
        Global.setParameter("smt.core.minimize", "true");

        HashMap<String, String> cfg = new HashMap<>();
        cfg.put("proof", "true");
        cfg.put("model", "true");

        ctx = new Context(cfg);
        goal = ctx.mkGoal(true, false, false);
    }

    private void makeAssertions(Formula formula, Bounds bounds) {
        System.out.println();
        System.out.println("----- z3 -----");
        System.out.println();

        Map<String, Object> objectMap = new HashMap<>();
        Map<Object, Expr> objectExprMap = new HashMap<>();

        for (int i = 0; i < bounds.universe().size(); i++) {
            Object object = bounds.universe().atom(i);
            objectMap.put("|" + object.toString() + "|", object);

            try {
                int x = Integer.parseInt(object.toString());
                integerObjectMap.put(x, object);
            }
            catch (NumberFormatException ignored) { }
        }

        UNIV = ctx.mkEnumSort("univ", objectMap.keySet().toArray(new String[0]));

        for (Expr expr : ((EnumSort) UNIV).getConsts()) {
            Object object = objectMap.get(expr.toString());
            if (object == null)
                object = objectMap.get(expr.toString().substring(1, expr.toString().length() - 1));
            objectExprMap.put(object, expr);
        }


        bounds.relations().forEach(relation -> {
            Sort[] sorts = new Sort[relation.arity()];
            for (int i = 0; i < sorts.length; i++) {
                sorts[i] = UNIV;
            }

            FuncDecl funcDecl;

            if (relation.name().isEmpty() || funcDeclMap.values().stream().anyMatch(f -> f.getSExpr().equals(relation.name()))) {
                int uniqueCount = 0;

                while (true) {
                    int finalUniqueCount = uniqueCount;

                    if (funcDeclMap.values().stream().anyMatch(f -> f.getSExpr().equals(relation.name() + finalUniqueCount))) {
                        uniqueCount++;
                    }
                    else
                        break;
                }

                funcDecl = ctx.mkFuncDecl(relation.name() + uniqueCount, sorts, ctx.mkBoolSort());
            }
            else {
                funcDecl = ctx.mkFuncDecl(relation.name(), sorts, ctx.mkBoolSort());
            }

            funcDeclMap.put(relation, funcDecl);

            bounds.lowerBounds().get(relation).forEach(tuple -> {
                Expr[] exprs = new Expr[tuple.arity()];
                for (int i = 0; i < exprs.length; i++) {
                    exprs[i] = objectExprMap.get(tuple.atom(i));
                }
                goal.add((BoolExpr) ctx.mkApp(funcDecl, exprs));
            });

            bounds.universe().factory().allOf(relation.arity()).forEach(tuple -> {
                Expr[] exprs = new Expr[tuple.arity()];
                for (int i = 0; i < exprs.length; i++) {
                    exprs[i] = objectExprMap.get(tuple.atom(i));
                }
                BoolExpr expr = (BoolExpr) ctx.mkApp(funcDecl, exprs);
                possibleExprs.add(expr);
                exprTupleMap.put(expr, new AbstractMap.SimpleEntry<>(relation, tuple));
                if (!bounds.upperBound(relation).contains(tuple))
                    goal.add(ctx.mkNot(expr));
            });
        });

        Goal goalSNF = ctx.mkGoal(true, false, false);

        Z3FormulaConverter<?> converter;

        switch (converterType) {
            case BV:
                converter = new Z3FormulaConverterWithBV(ctx, UNIV, funcDeclMap, objectExprMap, BIT_SIZE);
                break;
            case INTEGER:
                converter = new Z3FormulaConverterWithInt(ctx, UNIV, funcDeclMap, objectExprMap, BIT_SIZE);
                break;
            case ELIMINATED_BV:
            default:
                converter = new Z3EliminatedFormulaConverter(ctx, UNIV, funcDeclMap, objectExprMap, bounds, BIT_SIZE);
                break;
        }

        long cur = System.currentTimeMillis();
        boolExprFormulaMap = separateFormula(formula).stream()
                .collect(Collectors.toMap(
                        converter::convert
                        , f -> f
                        , (a, b) -> a));
        cur = System.currentTimeMillis() - cur;

        System.out.println("Visitor time: " + cur + " ms");
        System.out.println();

        boolExprFormulaMap.keySet().forEach(goalSNF::add);
        converter.getCreatedBoolExpressions().forEach(goalSNF::add);

        Solver mySolver = ctx.mkSolver();
        mySolver.add(goal.getFormulas());
        mySolver.add(goalSNF.getFormulas());

        StringBuilder sb = new StringBuilder();
        sb.append(mySolver.toString().replaceFirst("[(]univ 0[)]", "")).append(System.lineSeparator());
        sb.append("(check-sat)").append(System.lineSeparator());
        sb.append("(get-info :all-statistics)").append(System.lineSeparator());
        sb.append("(get-model)");

        String mainClass = System.getProperty("sun.java.command");
        String[] subs = mainClass.split("[.]");
        String shortMainClass = subs[subs.length - 1].toLowerCase();

        File dirSMT = new File("SMT/");
        if (!dirSMT.exists())
            dirSMT.mkdir();
        try (PrintWriter out = new PrintWriter("SMT/" + shortMainClass + ".smt")) {
            out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*System.out.println("*********************** SMTLIB BEGIN ***********************");
        System.out.println();
        System.out.println(sb);
        System.out.println();
        System.out.println("*********************** SMTLIB END ***********************");*/

        //Tactics
        Tactic t_qe = ctx.mkTactic("qe");
        Tactic t_default = ctx.mkTactic("snf");
        solver = ctx.mkSolver();
        Params p = ctx.mkParams();
        p.add("mbqi", true);
        p.add("pull-nested-quantifiers", true);
        solver.setParameters(p);

        for (BoolExpr original : goal.getFormulas()) {
            BoolExpr boolExpr = ctx.mkBoolConst("! " + original.toString());
            try {
                solver.assertAndTrack(original, boolExpr);
                assertionMap.put(boolExpr, original);
            }
            catch (Exception ignored) { }
        }

        // Pattern to find all quantifiers
        Pattern pattern = Pattern.compile("([(][a-zA-Z0-9!]+( univ)[)])");

        for (BoolExpr original : goalSNF.getFormulas()) {
            Goal singletonGoal = ctx.mkGoal(true, false, false);
            singletonGoal.add(original);
            ApplyResult qe_ar = t_default.apply(singletonGoal);

            BoolExpr[] newOnes = qe_ar.getSubgoals()[0].getFormulas();
            Formula f = boolExprFormulaMap.get(original);
            if (f != null) {
                //System.out.println("kodkod: " + f);
            }

            //System.out.println("z3:");
            //System.out.println(original);

            for (int i = 0; i < newOnes.length; i++) {
                BoolExpr e = newOnes[i];
                int forallCount = 0;
                Matcher matcher = pattern.matcher(e.getSExpr());

                while (matcher.find())
                    forallCount++;

                //System.out.println("snf z3:");
                //System.out.println(newOnes[i]);
                //System.out.println();
                //System.out.println("Quantifiers: " + forallCount);
                //System.out.println();
                if (forallCount < ELIMINATION_THRESHOLD) {
                    BoolExpr boolExpr = ctx.mkBoolConst("! " + e.toString());
                    try {
                        solver.assertAndTrack(e, boolExpr);
                        assertionMap.put(boolExpr, original);
                    }
                    catch (Exception ignored) {
                    }

                } else {
                    Goal ge_goal = ctx.mkGoal(true, false, false);

                    ge_goal.add(e);

                    ApplyResult ar = t_qe.apply(ge_goal);

                    for (BoolExpr b : ar.getSubgoals()[0].getFormulas()) {
                        BoolExpr boolExpr = ctx.mkBoolConst("! " + b.toString());
                        try {
                            solver.assertAndTrack(b, boolExpr);
                            assertionMap.put(boolExpr, original);
                        }
                        catch (Exception ignored) {
                        }
                    }
                }
            }

        }
        //end of tactics application

        System.out.println("----------------After Tactics----------------------");
        System.out.println(solver);
        System.out.println("---------------------------------------------------");

        System.out.println();
        System.out.println();
    }

    public Iterator<Instance> solveAll(Formula formula, Bounds bounds) {
        makeAssertions(formula, bounds);

        return new Iterator<Instance>() {
            @Override
            public boolean hasNext() {
                return status.equals(Status.SATISFIABLE);
            }

            @Override
            public Instance next() {

                System.out.println(solver);
                System.out.println("---------------------------------------------------");

                solveThis(bounds);

                if (status.equals(Status.SATISFIABLE)) {
                    solver.add(ctx.mkNot(ctx.mkAnd(possibleExprs.stream()
                            .filter(expr -> expr instanceof BoolExpr && solver.getModel().eval(expr, true).equals(ctx.mkTrue()))
                            .map(expr -> (BoolExpr) expr).toArray(BoolExpr[]::new))));
                }

                return instance;
            }
        };
    }

    public boolean solve(Formula formula, Bounds bounds) {
        makeAssertions(formula, bounds);

        solveThis(bounds);

        //return true;

        return status == Status.SATISFIABLE;
    }

    private void solveThis(Bounds bounds) {

        System.out.println("Solving...");
        System.out.println();

        long beginningTime = System.currentTimeMillis();
        status = solver.check();
        solvingTime = System.currentTimeMillis() - beginningTime;

        System.out.println(solvingTime + " ms");

        switch (status) {
            case SATISFIABLE:
                Set<Expr> reasonedExprs = possibleExprs.stream()
                        .filter(expr -> {
                            return solver.getModel().eval(expr, true).equals(ctx.mkTrue());
                        })
                        .collect(Collectors.toSet());

                System.out.println("Sat");
                reasonedExprs.forEach(System.out::println);
                System.out.println();
                possibleExprs.forEach(e -> System.out.println(e + " = " + solver.getModel().eval(e, true)));
                System.out.println();
                System.out.println(solver.getModel());

                this.instance = new Instance(bounds.universe());

                Map<Relation, Set<Tuple>> relationTuplesMap = new HashMap<>();

                reasonedExprs.forEach(expr -> {
                    Map.Entry<Relation, Tuple> entry = exprTupleMap.get(expr);
                    relationTuplesMap.computeIfAbsent(entry.getKey(), r -> new HashSet<>()).add(entry.getValue());
                });

                relationTuplesMap.forEach((relation, tuples) -> {
                    instance.add(relation, bounds.universe().factory().setOf(tuples));
                });

                for (int i : bounds.ints().toArray()) {
                    instance.add(i, bounds.universe().factory().setOf(integerObjectMap.get(i)));
                }

                System.out.println(instance);
                break;
            case UNSATISFIABLE:
                System.out.println("Unsat core:");
                Arrays.stream(solver.getUnsatCore()).forEach(System.out::println);

                Map<String, Formula> boolExprStrToFormula = new HashMap<>();
                boolExprFormulaMap.forEach((b, f) -> boolExprStrToFormula.put(b.toString(), f));

                unsatFormulaSet.clear();
                unsatFormulaSet.clear();

                Arrays.stream(solver.getUnsatCore()).forEach(boolExpr -> {
                    BoolExpr assertion = assertionMap.get(boolExpr);
                    if (exprTupleMap.containsKey(assertion)) {
                        unsatTupleSet.add(exprTupleMap.get(assertion));
                    } else if (boolExprFormulaMap.containsKey(assertion)) {
                        unsatFormulaSet.add(boolExprFormulaMap.get(assertion));
                    }
                });

                this.instance = null;
                break;
            case UNKNOWN:
                System.out.println("Unknown");
                break;
        }
    }

    private Set<Formula> separateFormula(Formula formula) {
        if (formula instanceof BinaryFormula && ((BinaryFormula) formula).op().equals(FormulaOperator.AND)) {
            Set<Formula> formulaSet = new HashSet<>();
            formulaSet.addAll(separateFormula(((BinaryFormula) formula).left()));
            formulaSet.addAll(separateFormula(((BinaryFormula) formula).right()));
            return formulaSet;
        }
        if (formula instanceof NaryFormula && ((NaryFormula) formula).op().equals(FormulaOperator.AND)) {
            Set<Formula> formulaSet = new HashSet<>();
            ((NaryFormula) formula).iterator().forEachRemaining(f -> {
                formulaSet.addAll(separateFormula(f));
            });
            return formulaSet;
        }
        return Collections.singleton(formula);
    }


    /**
     * GETTERS / SETTERS
     */

    public void setBitSize(int bitSize) {
        this.BIT_SIZE = bitSize;
    }

    public Status getStatus() {
        return status;
    }

    public long getSolvingTimeInMilis() {
        return solvingTime;
    }

    public Instance getInstance() {
        return instance;
    }

    public Set<Map.Entry<Relation, Tuple>> getUnsatTupleSet() {
        return unsatTupleSet;
    }

    public Set<Formula> getUnsatFormulaSet() {
        return unsatFormulaSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Formulas:").append(System.lineSeparator()).append(System.lineSeparator());
        Arrays.stream(goal.getFormulas()).forEach(boolExpr -> {
            sb.append(boolExpr).append(System.lineSeparator());
        });
        sb.append(System.lineSeparator()).append(System.lineSeparator());
        sb.append("All input:").append(System.lineSeparator()).append(System.lineSeparator());
        sb.append(solver);
        return sb.toString();
    }


    /**
     * NO USE
     */

    @Override
    public int numberOfVariables() {
        return 0;
    }

    @Override
    public int numberOfClauses() {
        return 0;
    }

    @Override
    public void addVariables(int numVars) {

    }

    @Override
    public boolean addClause(int[] lits) {
        return false;
    }

    @Override
    public boolean solve() throws SATAbortedException {
        return false;
    }

    @Override
    public boolean valueOf(int variable) {
        return false;
    }

    @Override
    public void free() {

    }
}
