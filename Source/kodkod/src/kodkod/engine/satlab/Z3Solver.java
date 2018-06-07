package kodkod.engine.satlab;

import com.microsoft.z3.*;
import kodkod.ast.*;
import kodkod.ast.operator.ExprOperator;
import kodkod.ast.operator.FormulaOperator;
import kodkod.ast.visitor.AbstractDetector;
import kodkod.instance.Bounds;
import kodkod.instance.Instance;
import kodkod.instance.Tuple;
import kodkod.instance.TupleSet;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Z3Solver implements SATSolver {

    private Context ctx;

    private Solver solver;

    private EnumSort UNIV;

    private Map<Expression, FuncDecl> funcDeclMap = new HashMap<>();
    private Map<Variable, Expr> variableExprMap = new HashMap<>();

    private Status status = Status.SATISFIABLE;
    private Bounds bounds = null;
    private Instance instance = null;

    private int quantifierID;
    private int skolemID;

    private Set<Formula> unsatFormulaSet = new HashSet<>();
    private Set<Map.Entry<Relation, Tuple>> unsatTupleSet = new HashSet<>();

    private long solvingTime = 0;

    //default goal
    private Goal goal = null;
    //qe goal
    private Goal qeGoal = null;

    private Set<Expr> possibleExprs = new HashSet<>();
    private Map<Expr, Map.Entry<Relation, Tuple>> exprTupleMap = new HashMap<>();
    private Map<BoolExpr, Formula> boolExprFormulaMap = new HashMap<>();

    private Map<BoolExpr, BoolExpr> assertionMap = new HashMap<>();

    public Z3Solver() {
        Global.setParameter("model.compact", "true");
        Global.setParameter("smt.mbqi", "true");
        Global.setParameter("smt.pull-nested-quantifiers", "true");
        Global.setParameter("smt.mbqi.trace", "true");

        HashMap<String, String> cfg = new HashMap<>();
        cfg.put("proof", "true");
        cfg.put("model", "true");

        ctx = new Context(cfg);
        goal = ctx.mkGoal(true, false, false);
        qeGoal = ctx.mkGoal(true, false, false);
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

    private void makeAssertions(Formula formula, Bounds bounds) {
        System.out.println();
        System.out.println("----- z3 -----");
        System.out.println();

        this.bounds = bounds;

        Map<String, Object> objectMap = new HashMap<>();
        Map<Object, Expr> objectExprMap = new HashMap<>();

        for (int i = 0; i < bounds.universe().size(); i++) {
            Object object = bounds.universe().atom(i);
            objectMap.put(object.toString(), object);
        }

        UNIV = ctx.mkEnumSort("univ", objectMap.keySet().toArray(new String[objectMap.keySet().size()]));

        for (Expr expr : UNIV.getConsts()) {
            Object object = objectMap.get(expr.toString());
            if (object == null)
                object = objectMap.get(expr.toString().substring(1, expr.toString().length() - 1));
            objectExprMap.put(object, expr);
        }

        //AbstractDetector detector = new AbstractDetector(Collections.emptySet()) {};

        FuncDecl univFuncDecl = null;
        //if (detector.visit((ConstantExpression) Relation.UNIV)) {
            univFuncDecl = ctx.mkFuncDecl("univ", new Sort[]{UNIV}, ctx.mkBoolSort());
            funcDeclMap.put(Relation.UNIV, univFuncDecl);
        //}
        /*FuncDecl idenFuncDecl = null;
        //if (detector.visit((ConstantExpression) Relation.IDEN)) {
            idenFuncDecl = ctx.mkFuncDecl("iden", new Sort[]{UNIV, UNIV}, ctx.mkBoolSort());
            funcDeclMap.put(Relation.IDEN, idenFuncDecl);
        //}*/
        FuncDecl noneFuncDecl = null;
        //if (detector.visit((ConstantExpression) Relation.NONE)) {
            noneFuncDecl = ctx.mkFuncDecl("none", new Sort[]{UNIV}, ctx.mkBoolSort());
            funcDeclMap.put(Relation.NONE, noneFuncDecl);
        //}
        /*FuncDecl intsFuncDecl = null;
        if (detector.visit((ConstantExpression) Relation.INTS)) {
            intsFuncDecl = funcDeclMap.put(Relation.INTS, ctx.mkFuncDecl("Ints", new Sort[] {ctx.mkIntSort()}, ctx.mkBoolSort()));
            funcDeclMap.put(Relation.INTS, intsFuncDecl);
        }*/

        bounds.relations().forEach(relation -> {
            Sort[] sorts = new Sort[relation.arity()];
            for (int i = 0; i < sorts.length; i++) {
                sorts[i] = UNIV;
            }
            FuncDecl funcDecl = ctx.mkFuncDecl(relation.name(), sorts, ctx.mkBoolSort());
            funcDeclMap.put(relation, funcDecl);

            bounds.lowerBounds().get(relation).forEach(tuple -> {
                Expr[] exprs = new Expr[tuple.arity()];
                for (int i = 0; i < exprs.length; i++) {
                    exprs[i] = objectExprMap.get(tuple.atom(i));
                }
                goal.add((BoolExpr) ctx.mkApp(funcDecl, exprs));
            });

            bounds.upperBounds().get(relation).forEach(tuple -> {
                Expr[] exprs = new Expr[tuple.arity()];
                for (int i = 0; i < exprs.length; i++) {
                    exprs[i] = objectExprMap.get(tuple.atom(i));
                }

                Expr expr = ctx.mkApp(funcDecl, exprs);
                possibleExprs.add(expr);

                exprTupleMap.put(expr, new AbstractMap.SimpleEntry<>(relation, tuple));
            });
        });

        for (Expr expr1 : objectExprMap.values()) {
            if (univFuncDecl != null)
                goal.add((BoolExpr) ctx.mkApp(univFuncDecl, new Expr[] {expr1}));
            if (noneFuncDecl != null)
                goal.add(ctx.mkNot((BoolExpr) ctx.mkApp(noneFuncDecl, new Expr[] {expr1})));
            /*if (idenFuncDecl != null) {
                goal.add((BoolExpr) ctx.mkApp(idenFuncDecl, new Expr[]{expr1, expr1}));
                for (Expr expr2 : objectExprMap.values()) {
                    if (expr1 != expr2) {
                        goal.add(ctx.mkNot((BoolExpr) ctx.mkApp(idenFuncDecl, new Expr[] {expr1, expr2})));
                        goal.add(ctx.mkNot((BoolExpr) ctx.mkApp(idenFuncDecl, new Expr[] {expr2, expr1})));
                    }
                }
            }*/
        }

        boolExprFormulaMap = separateFormula(formula).stream()
                .collect(Collectors.toMap(f -> visit(f, 0, new Expr[] {})
                        , f -> f
                        , (a, b) -> a));

        /*boolExprMap.forEach((boolExpr, f) -> {
            System.out.println("kodkod: " + f);
            System.out.println("z3:");
            System.out.println(boolExpr);
            System.out.println();
        });*/

        /*boolExprMap.keySet().forEach(boolExpr -> {
            if (quantifierSizeMap.getOrDefault(boolExpr, 0) < 3) {
                // TODO: Normal operation
                goal.add(boolExpr);
            }
            else {
                // TODO: Apply quantifier elimination tactic
                qeGoal.add(boolExpr);
            }
        });*/

        boolExprFormulaMap.keySet().forEach(goal::add);

        //Tactics
        Tactic t_qe = ctx.mkTactic("qe");//ctx.andThen(ctx.mkTactic("snf"), ctx.mkTactic("qe") );
        Tactic t_default = ctx.mkTactic("snf");
        solver = ctx.mkSolver();
        Params p = ctx.mkParams();
        p.add("mbqi", true);
        p.add("pull-nested-quantifiers", true);
        solver.setParameters(p);

        ApplyResult qe_ar = t_default.apply(goal);

        BoolExpr[] originals = goal.getFormulas();
        BoolExpr[] newOnes = qe_ar.getSubgoals()[0].getFormulas();

        // Pattern to find all quantifiers
        Pattern pattern = Pattern.compile("([(][a-zA-Z0-9!]+( univ)[)])");

        for (int i = 0; i < originals.length; i++) {
            Formula f = boolExprFormulaMap.get(originals[i]);
            BoolExpr e = newOnes[i];
            int forallCount = 0;//e.getSExpr().split("forall").length - 1;
            Matcher matcher = pattern.matcher(e.getSExpr());
            while (matcher.find())
                forallCount++;
            if (f != null) {
                System.out.println("kodkod: " + f);
                System.out.println("z3:");
                System.out.println(originals[i]);
                /*System.out.println("snf z3:");
                System.out.println(newOnes[i]);*/
                System.out.println();
                System.out.println("Quantifiers: " + forallCount);
                System.out.println();
            }
            if (forallCount < 5) {
                BoolExpr boolExpr = ctx.mkBoolConst("! " + e.toString());
                assertionMap.put(boolExpr, originals[i]);
                solver.assertAndTrack(e, boolExpr);
            }
            else {
                Goal ge_goal = ctx.mkGoal(true, false, false);

                ge_goal.add(e);

                ApplyResult ar = t_qe.apply(ge_goal);

                for (BoolExpr b : ar.getSubgoals()[0].getFormulas()) {
                    BoolExpr boolExpr = ctx.mkBoolConst("! " + b.toString());
                    assertionMap.put(boolExpr, originals[i]);
                    solver.assertAndTrack(b, boolExpr);
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

        return status == Status.SATISFIABLE;
    }

    private void solveThis(Bounds bounds){

        long beginningTime = System.currentTimeMillis();
        status = solver.check();
        solvingTime = System.currentTimeMillis() - beginningTime;

        System.out.println(solvingTime + " ms");

        switch (status) {
            case SATISFIABLE:
                Set<Expr> reasonedExprs = possibleExprs.stream()
                        .filter(expr -> solver.getModel().eval(expr, true).equals(ctx.mkTrue()))
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
                    }
                    else if (boolExprFormulaMap.containsKey(assertion)) {
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

    private BoolExpr visit(Node node, int depth, Expr[] exprs) {
        String quantifierPrefix = "q!";
        String skolemPrefix = "s!";

        if (node instanceof Relation) {
            return (BoolExpr) ctx.mkApp(funcDeclMap.get(node), exprs);
        }
        else if (node instanceof ConstantExpression) {
            if (node.equals(Relation.IDEN)) {
                return ctx.mkEq(exprs[0], exprs[1]);
            }
            return (BoolExpr) ctx.mkApp(funcDeclMap.get(node), exprs);
        }
        else if (node instanceof Variable) {
            return ctx.mkEq(variableExprMap.get(node), exprs[0]);
        }
        else if (node instanceof UnaryExpression) {
            UnaryExpression unaryExpression = (UnaryExpression) node;
            switch (unaryExpression.op()) {
                case TRANSPOSE:
                    return visit(unaryExpression.expression(), depth, new Expr[] {exprs[1], exprs[0]});
                case REFLEXIVE_CLOSURE:
                    Expression ex = unaryExpression.expression();
                    while (ex instanceof BinaryExpression && ((BinaryExpression) ex).op().equals(ExprOperator.JOIN)) {
                        ex = ((BinaryExpression) ex).right();
                    }

                    int loopCount =  UNIV.getConsts().length - 1;

                    if (ex.equals(Relation.NONE)) {
                        loopCount = 0;
                    }
                    else if (ex instanceof Relation) {
                        loopCount = (int) (bounds.upperBound((Relation) ex).stream()
                                .map(t -> t.atom(t.arity() - 1))
                                .distinct().count()) - 1;
                    }

                    /*List<Expression> expressions = new ArrayList<>();
                    expressions.add(Relation.IDEN);
                    for (int i = 0; i < loopCount; i++) {
                        Expression expression = unaryExpression.expression();
                        for (int j = 0; j < i; j++) {
                            expression = expression.join(unaryExpression.expression());
                        }
                        expressions.add(expression);
                    }*/

                    Expression unionExpr = Relation.IDEN;
                    for (int i = 0; i < loopCount - 1; i++) {
                        unionExpr = Relation.IDEN.union(unaryExpression.expression().join(unionExpr));
                    }

                    //return visit(Expression.union(expressions), depth, exprs);
                    return visit(unionExpr, depth, exprs);
                case CLOSURE:
                    ex = unaryExpression.expression();
                    while (ex instanceof BinaryExpression && ((BinaryExpression) ex).op().equals(ExprOperator.JOIN)) {
                        ex = ((BinaryExpression) ex).right();
                    }

                    loopCount =  UNIV.getConsts().length - 1;

                    if (ex.equals(Relation.NONE)) {
                        loopCount = 0;
                    }
                    else if (ex instanceof Relation) {
                        loopCount = (int) (bounds.upperBound((Relation) ex).stream()
                                .map(t -> t.atom(t.arity() - 1))
                                .distinct().count()) - 1;
                    }

                    /*expressions = new ArrayList<>();
                    for (int i = 0; i < loopCount; i++) {
                        Expression expression = unaryExpression.expression();
                        for (int j = 0; j < i; j++) {
                            expression = expression.join(unaryExpression.expression());
                        }
                        expressions.add(expression);
                    }
                    return visit(Expression.union(expressions), depth, exprs);*/

                    unionExpr = Relation.IDEN;
                    for (int i = 0; i < loopCount - 1; i++) {
                        unionExpr = Relation.IDEN.union(unaryExpression.expression().join(unionExpr));
                    }

                    if (unionExpr instanceof BinaryExpression && ((BinaryExpression) unionExpr).op().equals(ExprOperator.UNION))
                        return visit(((BinaryExpression) unionExpr).right(), depth, exprs);
                    else {
                        return ctx.mkFalse();
                    }
            }
        }
        else if (node instanceof BinaryExpression) {
            BinaryExpression binaryExpression = (BinaryExpression) node;
            switch (binaryExpression.op()) {
                case JOIN:
                    Expr expr = ctx.mkConst("x!" + depth, UNIV);

                    Expression leftExpression = binaryExpression.left();
                    Expression rightExpression = binaryExpression.right();

                    Expr[] leftExprs = new Expr[leftExpression.arity()];

                    System.arraycopy(exprs, 0, leftExprs, 0, leftExprs.length - 1);
                    leftExprs[leftExprs.length - 1] = expr;

                    Expr[] rightExprs = new Expr[rightExpression.arity()];

                    rightExprs[0] = expr;
                    System.arraycopy(exprs, exprs.length - rightExprs.length + 1, rightExprs, 1, rightExprs.length - 1);

                    if (leftExpression instanceof Variable) {
                        rightExprs[0] = variableExprMap.get(leftExpression);
                        return visit(rightExpression, depth + 1, rightExprs);
                    }
                    else if (rightExpression instanceof Variable) {
                        rightExprs[rightExprs.length - 1] = variableExprMap.get(rightExpression);
                        return visit(leftExpression, depth + 1, leftExprs);
                    }

                    return ctx.mkExists(new Expr[] {expr}
                            , ctx.mkAnd(visit(leftExpression, depth + 1, leftExprs)
                                    , visit(rightExpression, depth + 1, rightExprs))
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));
                case UNION:
                    return ctx.mkOr(visit(binaryExpression.left(), depth, exprs), visit(binaryExpression.right(), depth, exprs));
                case INTERSECTION:
                    return ctx.mkAnd(visit(binaryExpression.left(), depth, exprs), visit(binaryExpression.right(), depth, exprs));
                case PRODUCT:
                    leftExpression = binaryExpression.left();
                    rightExpression = binaryExpression.right();

                    leftExprs = new Expr[leftExpression.arity()];
                    System.arraycopy(exprs, 0, leftExprs, 0, leftExprs.length);

                    rightExprs = new Expr[rightExpression.arity()];
                    System.arraycopy(exprs, leftExpression.arity(), rightExprs, 0, rightExprs.length);

                    return ctx.mkAnd(visit(leftExpression, depth, leftExprs), visit(rightExpression, depth, rightExprs));
                case DIFFERENCE:
                    return ctx.mkAnd(visit(binaryExpression.left(), depth, exprs), ctx.mkNot(visit(binaryExpression.right(), depth, exprs)));
                case OVERRIDE:
                    // TODO: Implement this.
                    break;
            }
        }
        else if (node instanceof NaryExpression) {
            NaryExpression naryExpression = (NaryExpression) node;

            switch (naryExpression.op()) {
                case UNION:
                    BoolExpr[] boolExprs = new BoolExpr[naryExpression.size()];
                    for (int i = 0; i < boolExprs.length; i++) {
                        boolExprs[i] = visit(naryExpression.child(i), depth, exprs);
                    }
                    return ctx.mkOr(boolExprs);
                case PRODUCT:
                    boolExprs = new BoolExpr[naryExpression.size()];
                    for (int i = 0; i < boolExprs.length; i++) {
                        int start = 0;

                        for (int j = 0; j < i; j++)
                            start += naryExpression.child(i - 1).arity();

                        Expression expression = naryExpression.child(i);
                        Expr[] exprs1 = new Expr[expression.arity()];

                        System.arraycopy(exprs, start, exprs1, 0, exprs1.length);

                        boolExprs[i] = visit(expression, depth, exprs1);
                    }
                    return ctx.mkAnd(boolExprs);
                case INTERSECTION:
                    boolExprs = new BoolExpr[naryExpression.size()];
                    for (int i = 0; i < boolExprs.length; i++) {
                        boolExprs[i] = visit(naryExpression.child(i), depth, exprs);
                    }
                    return ctx.mkAnd(boolExprs);
                case OVERRIDE:
                    // TODO: Implement this.
                    break;
            }
        }
        else if (node instanceof NotFormula) {
            NotFormula notFormula = (NotFormula) node;
            return ctx.mkNot(visit(notFormula.formula(), depth, exprs));
        }
        else if (node instanceof ComparisonFormula) {
            ComparisonFormula comparisonFormula = (ComparisonFormula) node;
            switch (comparisonFormula.op()) {
                case EQUALS:
                    Expr[] exprs1;
                    if (comparisonFormula.left() instanceof Variable) {
                        if (comparisonFormula.right() instanceof Variable) {
                            return ctx.mkEq(variableExprMap.get(comparisonFormula.left()), variableExprMap.get(comparisonFormula.right()));
                        }
                        else {
                            exprs1 = new Expr[comparisonFormula.left().arity()];
                            exprs1[0] = variableExprMap.get(comparisonFormula.left());
                            return visit(comparisonFormula.right(), depth, exprs1);
                        }
                    }
                    else if (comparisonFormula.right() instanceof Variable) {
                        exprs1 = new Expr[comparisonFormula.right().arity()];
                        exprs1[0] = variableExprMap.get(comparisonFormula.right());
                        return visit(comparisonFormula.left(), depth, exprs1);
                    }

                    exprs1 = new Expr[comparisonFormula.left().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x!" + (depth + i), UNIV);
                    }

                    BoolExpr left = visit(comparisonFormula.left(), exprs1.length + depth, exprs1);
                    BoolExpr right = visit(comparisonFormula.right(), exprs1.length + depth, exprs1);

                    return ctx.mkForall(exprs1
                            , ctx.mkAnd(ctx.mkImplies(left, right), ctx.mkImplies(right, left))
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

                    /*return ctx.mkForall(exprs1
                            , ctx.mkEq(visit(comparisonFormula.left(), exprs1.length + depth, exprs1)
                                    , visit(comparisonFormula.right(), exprs1.length + depth, exprs1))
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);*/
                case SUBSET:
                    if (comparisonFormula.left() instanceof Variable) {
                        if (comparisonFormula.right() instanceof Variable) {
                            return ctx.mkEq(variableExprMap.get(comparisonFormula.left()), variableExprMap.get(comparisonFormula.right()));
                        }
                        else {
                            exprs1 = new Expr[comparisonFormula.left().arity()];
                            exprs1[0] = variableExprMap.get(comparisonFormula.left());
                            return visit(comparisonFormula.right(), depth, exprs1);
                        }
                    }
                    else if (comparisonFormula.right() instanceof Variable) {
                        exprs1 = new Expr[comparisonFormula.right().arity()];
                        exprs1[0] = variableExprMap.get(comparisonFormula.right());
                        return visit(comparisonFormula.left(), depth, exprs1);
                    }

                    exprs1 = new Expr[comparisonFormula.left().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x!" + (i + depth), UNIV);
                    }
                    return ctx.mkForall(exprs1
                            , ctx.mkImplies(visit(comparisonFormula.left(), exprs1.length + depth, exprs1)
                                    , visit(comparisonFormula.right(), exprs1.length + depth, exprs1))
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
            }
        }
        else if (node instanceof BinaryFormula) {
            BinaryFormula binaryFormula = (BinaryFormula) node;
            switch (binaryFormula.op()) {
                case IMPLIES:
                    return ctx.mkImplies(visit(binaryFormula.left(), depth, exprs), visit(binaryFormula.right(), depth, exprs));
                case IFF:
                    BoolExpr left = visit(binaryFormula.left(), depth, exprs);
                    BoolExpr right = visit(binaryFormula.right(), depth, exprs);
                    return ctx.mkAnd(ctx.mkImplies(left, right), ctx.mkImplies(right, left));
                    //return ctx.mkEq(visit(binaryFormula.left(), depth, exprs), visit(binaryFormula.right(), depth, exprs));
                case OR:
                    return ctx.mkOr(visit(binaryFormula.left(), depth, exprs), visit(binaryFormula.right(), depth, exprs));
                case AND:
                    return ctx.mkAnd(visit(binaryFormula.left(), depth, exprs), visit(binaryFormula.right(), depth, exprs));
            }
        }
        else if (node instanceof NaryFormula) {
            NaryFormula naryFormula = (NaryFormula) node;
            switch (naryFormula.op()) {
                case AND:
                    BoolExpr[] boolExprs = new BoolExpr[naryFormula.size()];
                    for (int i = 0; i < boolExprs.length; i++) {
                        boolExprs[i] = visit(naryFormula.child(i), depth, exprs);
                    }
                    return ctx.mkAnd(boolExprs);
                case OR:
                    boolExprs = new BoolExpr[naryFormula.size()];
                    for (int i = 0; i < boolExprs.length; i++) {
                        boolExprs[i] = visit(naryFormula.child(i), depth, exprs);
                    }
                    return ctx.mkOr(boolExprs);
            }
        }
        else if (node instanceof MultiplicityFormula) {
            MultiplicityFormula multiplicityFormula = (MultiplicityFormula) node;
            switch (multiplicityFormula.multiplicity()) {
                case SOME:
                    Expr[] exprs1 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x!" + (i + depth), UNIV);
                    }
                    return ctx.mkExists(exprs1
                            , visit(multiplicityFormula.expression(), exprs1.length + depth, exprs1)
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));
                case NO:
                    exprs1 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x!" + (i + depth), UNIV);
                    }
                    return ctx.mkNot(ctx.mkExists(exprs1
                            , visit(multiplicityFormula.expression(), exprs1.length + depth, exprs1)
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++)));
                case ONE:
                    exprs1 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("y!" + (i + depth), UNIV);
                    }
                    Expr[] exprs2 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs2.length; i++) {
                        exprs2[i] = ctx.mkConst("z!" + (i + depth), UNIV);
                    }
                    BoolExpr[] eqs = new BoolExpr[exprs1.length];
                    for (int i = 0; i < eqs.length; i++) {
                        eqs[i] = ctx.mkEq(exprs1[i], exprs2[i]);
                    }

                    Expr[] allExprs = new Expr[exprs1.length + exprs2.length];
                    System.arraycopy(exprs1, 0, allExprs, 0, exprs1.length);
                    System.arraycopy(exprs2, 0, allExprs, exprs1.length, exprs2.length);

                    Quantifier lone = ctx.mkForall(allExprs
                            , ctx.mkImplies(
                                    ctx.mkAnd(visit(multiplicityFormula.expression(), depth, exprs1)
                                            , visit(multiplicityFormula.expression(), depth, exprs2))
                                    , ctx.mkAnd(eqs))
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
                    Quantifier some = ctx.mkExists(exprs1, visit(multiplicityFormula.expression(), depth, exprs1)
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));

                    return ctx.mkAnd(some, lone);
                case LONE:
                    exprs1 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("y!" + (i + depth), UNIV);
                    }
                    exprs2 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs2[i] = ctx.mkConst("z!" + (i + depth), UNIV);
                    }
                    eqs = new BoolExpr[exprs1.length];
                    for (int i = 0; i < eqs.length; i++) {
                        eqs[i] = ctx.mkEq(exprs1[i], exprs2[i]);
                    }

                    allExprs = new Expr[exprs1.length + exprs2.length];
                    System.arraycopy(exprs1, 0, allExprs, 0, exprs1.length);
                    System.arraycopy(exprs2, 0, allExprs, exprs1.length, exprs2.length);

                    return ctx.mkForall(allExprs
                            , ctx.mkImplies(
                                    ctx.mkAnd(visit(multiplicityFormula.expression(), depth, exprs1)
                                            , visit(multiplicityFormula.expression(), depth, exprs2))
                                    , ctx.mkAnd(eqs))
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
            }
        }
        else if (node instanceof QuantifiedFormula) {
            QuantifiedFormula quantifiedFormula = (QuantifiedFormula) node;
            int exprsSize = quantifiedFormula.decls().size();

            Expr[] exprs1 = new Expr[exprsSize];
            BoolExpr[] ands = new BoolExpr[exprsSize];

            for (int i = 0; i < exprsSize; i++) {
                Decl decl = quantifiedFormula.decls().get(i);
                exprs1[i] = ctx.mkConst(decl.variable().name()/*"x" + (i + depth)*/, UNIV);
                variableExprMap.put(decl.variable(), exprs1[i]);
                ands[i] = visit(decl.variable().in(decl.expression()), depth + exprsSize, exprs);
            }

            switch (quantifiedFormula.quantifier()) {
                case ALL:
                    return ctx.mkForall(exprs1
                            , ctx.mkImplies(ctx.mkAnd(ands)
                                    , visit(quantifiedFormula.formula(), depth + exprs1.length, exprs1))
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
                case SOME:
                    return ctx.mkExists(exprs1
                            , ctx.mkImplies(ctx.mkAnd(ands)
                                    , visit(quantifiedFormula.formula(), depth + exprs1.length, exprs1))
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));
            }
        }
        if (node instanceof ConstantFormula) {
            ConstantFormula constantFormula = (ConstantFormula) node;
            if (constantFormula.booleanValue()) {
                return ctx.mkTrue();
            }
            else {
                return ctx.mkFalse();
            }
        }
        else if (node instanceof RelationPredicate) {
            RelationPredicate relationPredicate = (RelationPredicate) node;
            return visit(relationPredicate.toConstraints(), depth, exprs);
        }

        return ctx.mkTrue();
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
