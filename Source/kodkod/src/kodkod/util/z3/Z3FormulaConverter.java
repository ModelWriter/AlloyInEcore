package kodkod.util.z3;

import com.microsoft.z3.*;
import kodkod.ast.*;
import kodkod.ast.operator.Multiplicity;
import kodkod.ast.visitor.ReturnVisitor;
import kodkod.engine.fol2sat.HigherOrderDeclException;
import kodkod.instance.Bounds;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Z3FormulaConverter<T extends Expr> implements ReturnVisitor<BoolExpr, BoolExpr, BoolExpr, T> {

    static final String quantifierPrefix = "q!";
    static final String skolemPrefix = "s!";

    int BIT_SIZE;

    int quantifierID;
    int skolemID;

    Context ctx;
    Map<Expression, FuncDecl> funcDeclMap;
    Sort UNIV;
    FuncDecl univToInt;

    Map<String, FuncDecl> intExprFuncMap;

    Map<Variable, Expr> variableExprMap;
    Expr[] exprs;
    int varCount;

    Set<BoolExpr> goal;

    Map<String, Expression> createdRelations;

    public Z3FormulaConverter(Context ctx, Sort UNIV, Map<Expression, FuncDecl> funcDeclMap
            , Map<Object, Expr> objectExprMap, int BIT_SIZE) {
        this.ctx = ctx;
        this.funcDeclMap = funcDeclMap;
        this.UNIV = UNIV;
        this.BIT_SIZE = BIT_SIZE;

        this.variableExprMap = new HashMap<>();
        this.exprs = null;
        this.varCount = 0;
        this.quantifierID = 0;
        this.skolemID = 0;

        intExprFuncMap = new HashMap<>();

        this.goal = new HashSet<>();
        createdRelations = new HashMap<>();
    }

    public BoolExpr convert(Formula formula) {
        this.exprs = new Expr[0];
        this.varCount = 0;
        this.variableExprMap.clear();
        return formula.accept(this);
    }

    public Set<BoolExpr> getCreatedBoolExpressions() {
        return goal;
    }

    @Override
    public BoolExpr visit(Decls decls) {
        BoolExpr[] boolExprs = new BoolExpr[decls.size()];
        for (int i = 0; i < decls.size(); i++) {
            boolExprs[i] = decls.get(i).accept(this);
        }
        return ctx.mkAnd(boolExprs);
    }

    @Override
    public BoolExpr visit(Decl decl) {
        if (!decl.multiplicity().equals(Multiplicity.ONE))
            throw new HigherOrderDeclException(decl);
        if (decl.expression().arity() != 1)
            throw new RuntimeException(decl + ": decl.expression.arity != 1");
        return decl.variable().in(decl.expression()).accept(this);
    }

    @Override
    public BoolExpr visit(Relation relation) {
        return (BoolExpr) ctx.mkApp(funcDeclMap.get(relation), exprs);
    }

    @Override
    public BoolExpr visit(Variable variable) {
        return ctx.mkEq(variableExprMap.get(variable), exprs[0]);
    }

    @Override
    public BoolExpr visit(ConstantExpression constExpr) {
        if (constExpr == Relation.IDEN) {
            return exprs.length == 2 ? ctx.mkEq(exprs[0], exprs[1]) : ctx.mkFalse();
        }
        if (constExpr == Relation.NONE) {
            return exprs.length == 0 ? ctx.mkTrue() : ctx.mkFalse();
        }
        if (constExpr == Relation.UNIV) {
            return exprs.length == 1 ? ctx.mkTrue() : ctx.mkFalse();
        }

        FuncDecl funcDecl = funcDeclMap.get(constExpr);
        return funcDecl == null ? ctx.mkFalse() : (BoolExpr) ctx.mkApp(funcDecl, exprs);
    }

    @Override
    public BoolExpr visit(UnaryExpression unaryExpr) {
        switch (unaryExpr.op()) {
            case TRANSPOSE:
                Expr[] temp = exprs;
                exprs = new Expr[] {exprs[1], exprs[0]};
                BoolExpr boolExpr = unaryExpr.expression().accept(this);
                exprs = temp;
                return boolExpr;
            case REFLEXIVE_CLOSURE:
                FuncDecl funcDecl = funcDeclMap.computeIfAbsent(createdRelations.computeIfAbsent(unaryExpr.toString(), s -> unaryExpr), e -> {
                    FuncDecl fd = ctx.mkFuncDecl(unaryExpr.toString(), new Sort[] {UNIV, UNIV}, ctx.mkBoolSort());

                    Relation relation = Relation.binary(unaryExpr.toString());

                    funcDeclMap.put(relation, fd);

                    Variable a = Variable.unary("a");
                    Variable b = Variable.unary("b");
                    Variable x = Variable.unary("x");

                    Formula formula = b.in(a.join(relation)).iff(a.eq(b).or(b.in(a.join(unaryExpr.expression()))
                            .or(x.in(a.join(unaryExpr.expression())).and(b.in(x.join(relation))).and(a.eq(x).not()).and(b.eq(x).not()).forSome(x.oneOf(Relation.UNIV)))))
                            .forAll(a.oneOf(Relation.UNIV).and(b.oneOf(Relation.UNIV)));

                    goal.add(formula.accept(this));

                    return fd;
                });

                return (BoolExpr) funcDecl.apply(exprs);

                /*int loopCount = constSize - 1;

                List<Expression> expressions = new ArrayList<>();

                expressions.add(Relation.IDEN);

                for (int i = 0; i < loopCount; i++) {
                    Expression expression = unaryExpr.expression();
                    for (int j = 0; j < i; j++) {
                        expression = expression.join(unaryExpr.expression());
                    }
                    expressions.add(expression);
                }

                return ctx.mkOr(expressions.stream().map(e -> e.accept(this)).toArray(BoolExpr[]::new));*/

                /*Expression unionExpr = Relation.IDEN;
                for (int i = 0; i < loopCount; i++) {
                    unionExpr = Relation.IDEN.union(unaryExpr.expression().join(unionExpr));
                }

                return unionExpr.accept(this);*/
            case CLOSURE:
                funcDecl = funcDeclMap.computeIfAbsent(createdRelations.computeIfAbsent(unaryExpr.toString(), s -> unaryExpr), e -> {
                    FuncDecl fd = ctx.mkFuncDecl(unaryExpr.toString(), new Sort[] {UNIV, UNIV}, ctx.mkBoolSort());

                    Relation relation = Relation.binary(unaryExpr.toString());

                    funcDeclMap.put(relation, fd);

                    Variable a = Variable.unary("a");
                    Variable b = Variable.unary("b");
                    Variable x = Variable.unary("x");

                    Formula formula = b.in(a.join(relation)).iff(b.in(a.join(unaryExpr.expression()))
                            .or(x.in(a.join(unaryExpr.expression())).and(b.in(x.join(relation))).and(a.eq(x).not()).and(b.eq(x).not()).forSome(x.oneOf(Relation.UNIV))))
                            .forAll(a.oneOf(Relation.UNIV).and(b.oneOf(Relation.UNIV)));

                    goal.add(formula.accept(this));

                    return fd;
                });

                return (BoolExpr) funcDecl.apply(exprs);

                /*loopCount = constSize - 1;

                expressions = new ArrayList<>();

                for (int i = 0; i < loopCount; i++) {
                    Expression expression = unaryExpr.expression();
                    for (int j = 0; j < i; j++) {
                        expression = expression.join(unaryExpr.expression());
                    }
                    expressions.add(expression);
                }

                return ctx.mkOr(expressions.stream().map(e -> e.accept(this)).toArray(BoolExpr[]::new));*/

                /*unionExpr = Relation.IDEN;
                for (int i = 0; i < loopCount; i++) {
                    unionExpr = Relation.IDEN.union(unaryExpr.expression().join(unionExpr));
                }

                if (unionExpr instanceof BinaryExpression && ((BinaryExpression) unionExpr).op().equals(ExprOperator.UNION))
                    return ((BinaryExpression) unionExpr).right().accept(this);
                else {
                    return ctx.mkFalse();
                }*/
            default:
                return ctx.mkFalse();
        }
    }

    @Override
    public BoolExpr visit(BinaryExpression binExpr) {
        switch (binExpr.op()) {
            case JOIN:
                Expr expr = ctx.mkConst("x!" + varCount++, UNIV);

                Expression leftExpression = binExpr.left();
                Expression rightExpression = binExpr.right();

                Expr[] leftExprs = new Expr[leftExpression.arity()];

                System.arraycopy(exprs, 0, leftExprs, 0, leftExprs.length - 1);
                leftExprs[leftExprs.length - 1] = expr;

                Expr[] rightExprs = new Expr[rightExpression.arity()];

                rightExprs[0] = expr;
                System.arraycopy(exprs, exprs.length - rightExprs.length + 1, rightExprs, 1, rightExprs.length - 1);

                if (leftExpression instanceof Variable) {
                    rightExprs[0] = variableExprMap.get(leftExpression);

                    Expr[] temp = exprs;
                    exprs = rightExprs;
                    BoolExpr boolExpr = rightExpression.accept(this);
                    exprs = temp;
                    return boolExpr;
                }
                else if (rightExpression instanceof Variable) {
                    leftExprs[leftExprs.length - 1] = variableExprMap.get(rightExpression);
                    Expr[] temp = exprs;
                    exprs = leftExprs;
                    BoolExpr boolExpr = leftExpression.accept(this);
                    exprs = temp;
                    return boolExpr;
                }

                Expr[] temp = exprs;

                exprs = leftExprs;
                BoolExpr leftBoolExpr = leftExpression.accept(this);
                exprs = rightExprs;
                BoolExpr rightBoolExpr = rightExpression.accept(this);

                exprs = temp;

                return ctx.mkExists(new Expr[] {expr}
                        , ctx.mkAnd(leftBoolExpr, rightBoolExpr)
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));
            case UNION:
                return ctx.mkOr(binExpr.left().accept(this), binExpr.right().accept(this));
            case INTERSECTION:
                return ctx.mkAnd(binExpr.left().accept(this), binExpr.right().accept(this));
            case PRODUCT:
                leftExpression = binExpr.left();
                rightExpression = binExpr.right();

                leftExprs = new Expr[leftExpression.arity()];
                System.arraycopy(exprs, 0, leftExprs, 0, leftExprs.length);

                rightExprs = new Expr[rightExpression.arity()];
                System.arraycopy(exprs, leftExpression.arity(), rightExprs, 0, rightExprs.length);

                temp = exprs;

                exprs = leftExprs;
                leftBoolExpr = leftExpression.accept(this);
                exprs = rightExprs;
                rightBoolExpr = rightExpression.accept(this);

                exprs = temp;

                return ctx.mkAnd(leftBoolExpr, rightBoolExpr);
            case DIFFERENCE:
                return ctx.mkAnd(binExpr.left().accept(this), ctx.mkNot(binExpr.right().accept(this)));
            case OVERRIDE:
                BoolExpr boolExpr = binExpr.right().accept(this);
                return (BoolExpr) ctx.mkITE(boolExpr, ctx.mkTrue(), binExpr.left().accept(this));
            default:
                return ctx.mkFalse();
        }
    }

    @Override
    public BoolExpr visit(NaryExpression expr) {
        switch (expr.op()) {
            case UNION:
                BoolExpr[] boolExprs = new BoolExpr[expr.size()];
                for (int i = 0; i < boolExprs.length; i++) {
                    boolExprs[i] = expr.child(i).accept(this);
                }
                return ctx.mkOr(boolExprs);
            case PRODUCT:
                boolExprs = new BoolExpr[expr.size()];
                for (int i = 0; i < boolExprs.length; i++) {
                    int start = 0;

                    for (int j = 0; j < i; j++)
                        start += expr.child(i - 1).arity();

                    Expression expression = expr.child(i);
                    Expr[] exprs1 = new Expr[expression.arity()];

                    System.arraycopy(exprs, start, exprs1, 0, exprs1.length);

                    Expr[] temp = exprs;

                    exprs = exprs1;
                    boolExprs[i] = expression.accept(this);

                    exprs = temp;
                }
                return ctx.mkAnd(boolExprs);
            case INTERSECTION:
                boolExprs = new BoolExpr[expr.size()];
                for (int i = 0; i < boolExprs.length; i++) {
                    boolExprs[i] = expr.child(i).accept(this);
                }
                return ctx.mkAnd(boolExprs);
            case OVERRIDE:
                if (expr.size() <= 0)
                    return ctx.mkFalse();

                BoolExpr boolExpr = expr.child(0).accept(this);
                for (int i = 1; i < expr.size(); i++) {
                    BoolExpr temp = expr.child(i).accept(this);
                    boolExpr = (BoolExpr) ctx.mkITE(temp, ctx.mkTrue(), boolExpr);
                }

                return boolExpr;
            default:
                return ctx.mkFalse();
        }
    }

    @Override
    public BoolExpr visit(Comprehension comprehension) {
        // TODO: Implement this.
        return ctx.mkFalse();
    }

    @Override
    public BoolExpr visit(IfExpression ifExpr) {
        return (BoolExpr) ctx.mkITE(ifExpr.condition().accept(this)
                , ifExpr.thenExpr().accept(this)
                , ifExpr.elseExpr().accept(this));
    }

    @Override
    public BoolExpr visit(ProjectExpression project) {
        // TODO: Implement this.
        return ctx.mkFalse();
    }

    @Override
    public BoolExpr visit(IntToExprCast castExpr) {
        // TODO: Implement this.
        return ctx.mkFalse();
    }

    @Override
    public abstract T visit(IntConstant intConst);

    @Override
    public abstract T visit(IfIntExpression intExpr);

    @Override
    public abstract T visit(ExprToIntCast exprToIntCast);

    @Override
    public abstract T visit(NaryIntExpression naryIntExpression);

    @Override
    public abstract T visit(BinaryIntExpression binaryIntExpression);

    @Override
    public abstract T visit(UnaryIntExpression intExpr);

    @Override
    public abstract T visit(SumExpression sumExpression);

    @Override
    public abstract BoolExpr visit(IntComparisonFormula intComparisonFormula);

    @Override
    public BoolExpr visit(QuantifiedFormula quantifiedFormula) {
        int exprsSize = quantifiedFormula.decls().size();

        Expr[] exprs1 = new Expr[exprsSize];

        for (int i = 0; i < exprsSize; i++) {
            Decl decl = quantifiedFormula.decls().get(i);
            exprs1[i] = ctx.mkConst(decl.variable().name(), UNIV);
            variableExprMap.put(decl.variable(), exprs1[i]);
        }

        BoolExpr ands = quantifiedFormula.decls().accept(this);

        Expr[] temp = exprs;

        exprs = exprs1;
        BoolExpr boolExpr = quantifiedFormula.formula().accept(this);
        exprs = temp;

        switch (quantifiedFormula.quantifier()) {
            case ALL:
                return ctx.mkForall(exprs1
                        , ctx.mkImplies(ands, boolExpr)
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
            case SOME:
                return ctx.mkExists(exprs1
                        , ctx.mkAnd(ands, boolExpr)
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));
            default:
                return ctx.mkFalse();
        }
    }

    @Override
    public BoolExpr visit(NaryFormula formula) {
        switch (formula.op()) {
            case AND:
                BoolExpr[] boolExprs = new BoolExpr[formula.size()];
                for (int i = 0; i < boolExprs.length; i++) {
                    boolExprs[i] = formula.child(i).accept(this);
                }
                return ctx.mkAnd(boolExprs);
            case OR:
                boolExprs = new BoolExpr[formula.size()];
                for (int i = 0; i < boolExprs.length; i++) {
                    boolExprs[i] = formula.child(i).accept(this);
                }
                return ctx.mkOr(boolExprs);
            default:
                return ctx.mkFalse();
        }
    }

    @Override
    public BoolExpr visit(BinaryFormula binFormula) {
        switch (binFormula.op()) {
            case IMPLIES:
                return ctx.mkImplies(binFormula.left().accept(this), binFormula.right().accept(this));
            case IFF:
                return ctx.mkEq(binFormula.left().accept(this), binFormula.right().accept(this));
            case OR:
                return ctx.mkOr(binFormula.left().accept(this), binFormula.right().accept(this));
            case AND:
                return ctx.mkAnd(binFormula.left().accept(this), binFormula.right().accept(this));
            default:
                return ctx.mkFalse();
        }
    }

    @Override
    public BoolExpr visit(NotFormula not) {
        return ctx.mkNot(not.formula().accept(this));
    }

    @Override
    public BoolExpr visit(ConstantFormula constant) {
        return constant.booleanValue() ? ctx.mkTrue() : ctx.mkFalse();
    }

    @Override
    public BoolExpr visit(ComparisonFormula compFormula) {
        switch (compFormula.op()) {
            case EQUALS:
                Expr[] exprs1;
                if (compFormula.left() instanceof Variable) {
                    if (compFormula.right() instanceof Variable) {
                        return ctx.mkEq(variableExprMap.get(compFormula.left()), variableExprMap.get(compFormula.right()));
                    }
                    else {
                        Variable variable = Variable.unary("x!" + varCount++);
                        return variable.eq(compFormula.left()).forAll(variable.oneOf(compFormula.right())).accept(this);
                    }
                }
                else if (compFormula.right() instanceof Variable) {
                    Variable variable = Variable.unary("x!" + varCount++);
                    return variable.eq(compFormula.right()).forAll(variable.oneOf(compFormula.left())).accept(this);
                }

                exprs1 = new Expr[compFormula.left().arity()];
                for (int i = 0; i < exprs1.length; i++) {
                    exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                }

                Expr[] temp = exprs;

                exprs = exprs1;
                BoolExpr left = compFormula.left().accept(this);
                BoolExpr right = compFormula.right().accept(this);

                exprs = temp;

                return ctx.mkForall(exprs1, ctx.mkEq(left, right)
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
            case SUBSET:
                if (compFormula.left() instanceof Variable) {
                    if (compFormula.right() instanceof Variable) {
                        return ctx.mkEq(variableExprMap.get(compFormula.left()), variableExprMap.get(compFormula.right()));
                    }
                    else {
                        exprs1 = new Expr[compFormula.left().arity()];
                        exprs1[0] = variableExprMap.get(compFormula.left());

                        temp = exprs;

                        exprs = exprs1;
                        BoolExpr boolExpr = compFormula.right().accept(this);

                        exprs = temp;

                        return boolExpr;
                    }
                }
                else if (compFormula.right() instanceof Variable) {
                    Variable variable = Variable.unary("x!" + varCount++);
                    return variable.eq(compFormula.right()).forAll(variable.oneOf(compFormula.left())).accept(this);
                }

                exprs1 = new Expr[compFormula.left().arity()];
                for (int i = 0; i < exprs1.length; i++) {
                    exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                }

                temp = exprs;

                exprs = exprs1;
                left = compFormula.left().accept(this);
                right = compFormula.right().accept(this);

                exprs = temp;

                return ctx.mkForall(exprs1
                        , ctx.mkImplies(left, right)
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
            default:
                return ctx.mkFalse();
        }
    }

    @Override
    public BoolExpr visit(MultiplicityFormula multiplicityFormula) {
        switch (multiplicityFormula.multiplicity()) {
            case SOME:
                Expr[] exprs1 = new Expr[multiplicityFormula.expression().arity()];
                for (int i = 0; i < exprs1.length; i++) {
                    exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                }

                Expr[] temp = exprs;

                exprs = exprs1;
                BoolExpr boolExpr = multiplicityFormula.expression().accept(this);

                exprs = temp;

                return ctx.mkExists(exprs1, boolExpr
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));
            case NO:
                exprs1 = new Expr[multiplicityFormula.expression().arity()];
                if (multiplicityFormula.expression() instanceof IntToExprCast) {
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkBVConst("i!" + (varCount++), BIT_SIZE);
                    }
                }
                else {
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                    }
                }

                temp = exprs;

                exprs = exprs1;
                boolExpr = multiplicityFormula.expression().accept(this);

                exprs = temp;

                return ctx.mkNot(ctx.mkExists(exprs1, boolExpr
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++)));
            case ONE:
                exprs1 = new Expr[multiplicityFormula.expression().arity()];
                for (int i = 0; i < exprs1.length; i++) {
                    exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                }
                Expr[] exprs2 = new Expr[multiplicityFormula.expression().arity()];
                for (int i = 0; i < exprs2.length; i++) {
                    exprs2[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                }
                BoolExpr[] eqs = new BoolExpr[exprs1.length];
                for (int i = 0; i < eqs.length; i++) {
                    eqs[i] = ctx.mkEq(exprs1[i], exprs2[i]);
                }

                Expr[] allExprs = new Expr[exprs1.length + exprs2.length];
                System.arraycopy(exprs1, 0, allExprs, 0, exprs1.length);
                System.arraycopy(exprs2, 0, allExprs, exprs1.length, exprs2.length);

                temp = exprs;

                exprs = exprs1;
                BoolExpr boolExpr1 = multiplicityFormula.expression().accept(this);
                exprs = exprs2;
                BoolExpr boolExpr2 = multiplicityFormula.expression().accept(this);

                exprs = temp;

                Quantifier lone = ctx.mkForall(allExprs
                        , ctx.mkImplies(ctx.mkAnd(boolExpr1, boolExpr2), ctx.mkAnd(eqs))
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
                Quantifier some = ctx.mkExists(exprs1, boolExpr1
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));

                return ctx.mkAnd(some, lone);
            case LONE:
                exprs1 = new Expr[multiplicityFormula.expression().arity()];
                for (int i = 0; i < exprs1.length; i++) {
                    exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                }
                exprs2 = new Expr[multiplicityFormula.expression().arity()];
                for (int i = 0; i < exprs1.length; i++) {
                    exprs2[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                }
                eqs = new BoolExpr[exprs1.length];
                for (int i = 0; i < eqs.length; i++) {
                    eqs[i] = ctx.mkEq(exprs1[i], exprs2[i]);
                }

                allExprs = new Expr[exprs1.length + exprs2.length];
                System.arraycopy(exprs1, 0, allExprs, 0, exprs1.length);
                System.arraycopy(exprs2, 0, allExprs, exprs1.length, exprs2.length);

                temp = exprs;

                exprs = exprs1;
                boolExpr1 = multiplicityFormula.expression().accept(this);
                exprs = exprs2;
                boolExpr2 = multiplicityFormula.expression().accept(this);

                exprs = temp;

                return ctx.mkForall(allExprs
                        , ctx.mkImplies(ctx.mkAnd(boolExpr1, boolExpr2), ctx.mkAnd(eqs))
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
            default:
                return ctx.mkFalse();
        }
    }

    @Override
    public BoolExpr visit(RelationPredicate predicate) {
        return predicate.toConstraints().accept(this);
    }

}
