/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore;

import com.microsoft.z3.*;
import kodkod.ast.*;
import kodkod.ast.operator.FormulaOperator;
import kodkod.instance.Bounds;
import kodkod.instance.Instance;
import kodkod.instance.Tuple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by harun on 5/12/18.
 */
public class KodkodZ3Solver {

    private Context ctx;
    private EnumSort UNIV;

    private Map<Expression, FuncDecl> funcDeclMap = new HashMap<>();
    private Map<Variable, Expr> variableExprMap = new HashMap<>();

    public KodkodZ3Solver() {
        Global.setParameter("model.compact", "true");
        Global.setParameter("smt.mbqi", "true");

        HashMap<String, String> cfg = new HashMap<>();
        cfg.put("proof", "true");
        cfg.put("model", "true");
        ctx = new Context(cfg);
    }

    public void solve(Formula formula, Bounds bounds) {
        System.out.println();
        System.out.println("----- z3 -----");
        System.out.println();

        Solver solver = ctx.mkSolver();

        Map<String, Object> objectMap = new HashMap<>();
        Map<Object, Expr> objectExprMap = new HashMap<>();

        for (int i = 0; i < bounds.universe().size(); i++) {
            Object object = bounds.universe().atom(i);
            objectMap.put(object.toString(), object);
        }

        UNIV = ctx.mkEnumSort("Univ", objectMap.keySet().toArray(new String[objectMap.keySet().size()]));

        for (Expr expr : UNIV.getConsts()) {
            Object object = objectMap.get(expr.toString());
            if (object == null)
                object = objectMap.get(expr.toString().substring(1, expr.toString().length() - 1));
            objectExprMap.put(object, expr);
        }

        FuncDecl univFuncDecl = ctx.mkFuncDecl("univ", new Sort[] {UNIV}, ctx.mkBoolSort());
        FuncDecl idenFuncDecl = ctx.mkFuncDecl("iden", new Sort[] {UNIV, UNIV}, ctx.mkBoolSort());
        FuncDecl noneFuncDecl = ctx.mkFuncDecl("None", new Sort[] {UNIV}, ctx.mkBoolSort());

        funcDeclMap.put(Relation.UNIV, univFuncDecl);
        funcDeclMap.put(Relation.IDEN, idenFuncDecl);
        funcDeclMap.put(Relation.NONE, noneFuncDecl);
        // funcDeclMap.put(Relation.INTS, ctx.mkFuncDecl("Ints", new Sort[] {INT}, ctx.mkBoolSort()));

        Set<Expr> possibleExprs = new HashSet<>();
        Map<Expr, Map.Entry<Relation, Tuple>> exprTupleMap = new HashMap<>();

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

                solver.add((BoolExpr) ctx.mkApp(funcDecl, exprs));
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

        objectExprMap.values().forEach(expr1 -> {
            solver.add((BoolExpr) ctx.mkApp(univFuncDecl, new Expr[] {expr1}));
            solver.add((BoolExpr) ctx.mkApp(idenFuncDecl, new Expr[] {expr1, expr1}));
            solver.add(ctx.mkNot((BoolExpr) ctx.mkApp(noneFuncDecl, new Expr[] {expr1})));
            objectExprMap.values().forEach(expr2 -> {
                if (expr1 != expr2) {
                    solver.add(ctx.mkNot((BoolExpr) ctx.mkApp(idenFuncDecl, new Expr[] {expr1, expr2})));
                    solver.add(ctx.mkNot((BoolExpr) ctx.mkApp(idenFuncDecl, new Expr[] {expr2, expr1})));
                }
            });
        });

        Map<Formula, BoolExpr> boolExprMap = separateFormula(formula).stream()
                .collect(Collectors.toMap(f -> f, f -> visit(f, 0, new Expr[] {})));

        boolExprMap.forEach((f, boolExpr) -> {
            System.out.println("kodkod: " + f);
            System.out.println("z3:");
            System.out.println(boolExpr);
            System.out.println();
        });

        boolExprMap.values().forEach(solver::add);

        System.out.println();
        System.out.println();

        Status status = printForConsole(solver, possibleExprs);

        switch (status) {
            case SATISFIABLE:
                Set<Expr> reasonedExprs = possibleExprs.stream()
                        .filter(expr -> solver.getModel().eval(expr, true).equals(ctx.mkTrue()))
                        .collect(Collectors.toSet());

                Instance instance = new Instance(bounds.universe());

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
                break;
            case UNKNOWN:
                break;
        }
    }

    private Status printForConsole(Solver solver, Collection<Expr> possibleExprs){
        System.out.println(solver);
        System.out.println("---------------------------------------------------");

        long beginningTime = System.currentTimeMillis();
        Status status = solver.check();
        long solvingTime = System.currentTimeMillis() - beginningTime;

        System.out.println(solvingTime + " ms");

        switch (status) {
            case SATISFIABLE:
                System.out.println("Sat");
                List<Expr> reasonedExprs = possibleExprs.stream()
                        .filter(expr -> solver.getModel().eval(expr, true).equals(ctx.mkTrue()))
                        .collect(Collectors.toList());
                reasonedExprs.forEach(System.out::println);
                System.out.println();
                possibleExprs.forEach(e -> System.out.println(e + " = " + solver.getModel().eval(e, true)));
                System.out.println();
                System.out.println(solver.getModel());
                break;
            case UNSATISFIABLE:
                System.out.println("Unsat");
                Arrays.stream(solver.getUnsatCore()).forEach(System.out::println);
                break;
            case UNKNOWN:
                System.out.println("Unknown");
                break;
        }

        return status;
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
        if (node instanceof Relation) {
            return (BoolExpr) ctx.mkApp(funcDeclMap.get(node), exprs);
        }
        else if (node instanceof ConstantExpression) {
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
                    List<Expression> expressions = new ArrayList<>();
                    expressions.add(Relation.IDEN);
                    for (int i = 0; i < UNIV.getConsts().length - 1; i++) {
                        Expression expression = unaryExpression.expression();
                        for (int j = 0; j < i; j++) {
                            expression = expression.join(unaryExpression.expression());
                        }
                        expressions.add(expression);
                    }
                    return visit(Expression.union(expressions), depth, exprs);
                case CLOSURE:
                    expressions = new ArrayList<>();
                    for (int i = 0; i < UNIV.getConsts().length - 1; i++) {
                        Expression expression = unaryExpression.expression();
                        for (int j = 0; j < i; j++) {
                            expression = expression.join(unaryExpression.expression());
                        }
                        expressions.add(expression);
                    }
                    return visit(Expression.union(expressions), depth, exprs);
            }
        }
        else if (node instanceof BinaryExpression) {
            BinaryExpression binaryExpression = (BinaryExpression) node;
            switch (binaryExpression.op()) {
                case JOIN:
                    Expr expr = ctx.mkConst("x" + depth, UNIV);

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
                            , 0, null, null, null, null);
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
                        exprs1[i] = ctx.mkConst("x" + (depth + i), UNIV);
                    }
                    return ctx.mkForall(exprs1
                            , ctx.mkIff(visit(comparisonFormula.left(), exprs1.length + depth, exprs1)
                                    , visit(comparisonFormula.right(), exprs1.length + depth, exprs1))
                            , 0, null, null, null, null);
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
                        exprs1[i] = ctx.mkConst("x" + (i + depth), UNIV);
                    }
                    return ctx.mkForall(exprs1
                            , ctx.mkImplies(visit(comparisonFormula.left(), exprs1.length + depth, exprs1)
                                    , visit(comparisonFormula.right(), exprs1.length + depth, exprs1))
                            , 0, null, null, null, null);
            }
        }
        else if (node instanceof BinaryFormula) {
            BinaryFormula binaryFormula = (BinaryFormula) node;
            switch (binaryFormula.op()) {
                case IMPLIES:
                    return ctx.mkImplies(visit(binaryFormula.left(), depth, exprs), visit(binaryFormula.right(), depth, exprs));
                case IFF:
                    return ctx.mkIff(visit(binaryFormula.left(), depth, exprs), visit(binaryFormula.right(), depth, exprs));
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
                        exprs1[i] = ctx.mkConst("x" + (i + depth), UNIV);
                    }
                    return ctx.mkExists(exprs1
                            , visit(multiplicityFormula.expression(), exprs1.length + depth, exprs1)
                            , 0, null, null, null, null);
                case NO:
                    exprs1 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x" + (i + depth), UNIV);
                    }
                    return ctx.mkNot(ctx.mkExists(exprs1
                            , visit(multiplicityFormula.expression(), exprs1.length + depth, exprs1)
                            , 0, null, null, null, null));
                case ONE:
                    exprs1 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("a" + (i + depth), UNIV);
                    }
                    Expr[] exprs2 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs2.length; i++) {
                        exprs2[i] = ctx.mkConst("b" + (i + depth), UNIV);
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
                            , 0, null, null, null, null);
                    Quantifier some = ctx.mkExists(exprs1, visit(multiplicityFormula.expression(), depth, exprs1)
                            , 0, null, null, null, null);

                    return ctx.mkAnd(some, lone);
                case LONE:
                    exprs1 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("a" + (i + depth), UNIV);
                    }
                    exprs2 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs2[i] = ctx.mkConst("b" + (i + depth), UNIV);
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
                            , 0, null, null, null, null);
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
                                    , visit(quantifiedFormula.formula(), depth + exprs1.length, exprs))
                            , 0, null, null, null, null);
                case SOME:
                    return ctx.mkExists(exprs1
                            , ctx.mkImplies(ctx.mkAnd(ands)
                                    , visit(quantifiedFormula.formula(), depth + exprs1.length, exprs))
                            , 0, null, null, null, null);
            }
        }
        return ctx.mkTrue();
    }

}
