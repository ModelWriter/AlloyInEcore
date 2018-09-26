package kodkod.util.z3;

import com.microsoft.z3.*;
import com.microsoft.z3.enumerations.Z3_sort_kind;
import com.sun.org.apache.xpath.internal.operations.Bool;
import jdk.nashorn.internal.ir.annotations.Ignore;
import kodkod.ast.*;
import kodkod.ast.operator.ExprOperator;
import kodkod.ast.operator.Multiplicity;
import kodkod.ast.operator.Quantifier;
import kodkod.ast.visitor.ReturnVisitor;
import kodkod.engine.fol2sat.HigherOrderDeclException;
import kodkod.instance.Bounds;
import kodkod.instance.Tuple;
import kodkod.instance.TupleSet;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by harun on 7/16/18.
 */
public class Z3EliminatedFormulaConverter extends Z3FormulaConverter<BitVecExpr> {

    private Map<Object, Expr> objectExprMap;

    private UpperBoundFinder upperBoundFinder;
    private int notCount;
    private Map<Node, Set<Tuple>> upperBoundCache;

    public Z3EliminatedFormulaConverter(Context ctx, Sort UNIV, Map<Expression, FuncDecl> funcDeclMap
            , Map<Object, Expr> objectExprMap, Bounds bounds, int BIT_SIZE) {
        super(ctx, UNIV, funcDeclMap, objectExprMap, BIT_SIZE);
        this.objectExprMap = objectExprMap;

        upperBoundFinder = new UpperBoundFinder(bounds);
        upperBoundCache = new HashMap<>();

        if (objectExprMap.entrySet().stream().anyMatch(e -> e.getKey() instanceof Integer)) {
            FuncDecl intsFuncDecl = ctx.mkFuncDecl("Ints", new Sort[]{UNIV}, ctx.mkBoolSort());
            funcDeclMap.put(Relation.INTS, intsFuncDecl);

            univToInt = ctx.mkFuncDecl("toInt", UNIV, ctx.mkBitVecSort(BIT_SIZE));

            objectExprMap.forEach(((o, expr) -> {
                if (o instanceof Integer) {
                    goal.add((BoolExpr) ctx.mkApp(intsFuncDecl, expr));
                    goal.add(ctx.mkEq(ctx.mkApp(univToInt, expr), ctx.mkBV((Integer) o, BIT_SIZE)));
                } else {
                    try {
                        int i = Integer.parseInt(o.toString());
                        goal.add(ctx.mkEq(ctx.mkApp(univToInt, expr), ctx.mkBV(i, BIT_SIZE)));
                    }
                    catch (NumberFormatException e) {
                        goal.add(ctx.mkEq(ctx.mkApp(univToInt, expr), ctx.mkBV(0, BIT_SIZE)));
                    }
                    goal.add(ctx.mkNot((BoolExpr) ctx.mkApp(intsFuncDecl, expr)));
                }
            }));
        }
    }

    @Override
    public BoolExpr convert(Formula formula) {
        this.notCount = 0;
        return super.convert(formula);
    }

    @Override
    public BoolExpr visit(BinaryExpression binExpr) {
        switch (binExpr.op()) {
            case JOIN:
                Expression leftExpression = binExpr.left();
                Expression rightExpression = binExpr.right();

                Expr[] leftExprs = new Expr[leftExpression.arity()];

                System.arraycopy(exprs, 0, leftExprs, 0, leftExprs.length - 1);

                Expr[] rightExprs = new Expr[rightExpression.arity()];

                System.arraycopy(exprs, exprs.length - rightExprs.length + 1, rightExprs, 1, rightExprs.length - 1);

                if (leftExpression instanceof Variable) {
                    rightExprs[0] = variableExprMap.get(leftExpression);

                    Expr[] temp = exprs;
                    exprs = rightExprs;
                    BoolExpr boolExpr = rightExpression.accept(this);
                    exprs = temp;
                    return boolExpr;
                } else if (rightExpression instanceof Variable) {
                    leftExprs[leftExprs.length - 1] = variableExprMap.get(rightExpression);
                    Expr[] temp = exprs;
                    exprs = leftExprs;
                    BoolExpr boolExpr = leftExpression.accept(this);
                    exprs = temp;
                    return boolExpr;
                }

                if (notCount % 2 == 1) {
                    Expr[] temp = exprs;

                    Set<BoolExpr> boolExprs = new HashSet<>();

                    Set<Tuple> leftTupleSet = upperBoundCache.computeIfAbsent(leftExpression, e -> leftExpression.accept(upperBoundFinder));
                    Set<Tuple> rightTupleSet = upperBoundCache.computeIfAbsent(rightExpression, e -> rightExpression.accept(upperBoundFinder));

                    leftTupleSet.forEach(tuple1 -> {
                        rightTupleSet.forEach(tuple2 -> {
                            if (tuple1.atom(tuple1.arity() - 1).equals(tuple2.atom(0))) {
                                Expr expr1 = objectExprMap.get(tuple2.atom(0));

                                leftExprs[leftExprs.length - 1] = expr1;
                                rightExprs[0] = expr1;

                                exprs = leftExprs;
                                BoolExpr leftBoolExpr = leftExpression.accept(this);
                                exprs = rightExprs;
                                BoolExpr rightBoolExpr = rightExpression.accept(this);

                                boolExprs.add(ctx.mkAnd(leftBoolExpr, rightBoolExpr));

                            }
                        });
                    });

                    exprs = temp;

                    BoolExpr[] boolExprArray = boolExprs.toArray(new BoolExpr[0]);

                    return ctx.mkOr(boolExprArray);

                } else {
                    Expr expr;

                    expr = ctx.mkConst("x!" + varCount++, UNIV);


                    leftExprs[leftExprs.length - 1] = expr;
                    rightExprs[0] = expr;

                    Expr[] temp = exprs;

                    exprs = leftExprs;
                    BoolExpr leftBoolExpr = leftExpression.accept(this);
                    exprs = rightExprs;
                    BoolExpr rightBoolExpr = rightExpression.accept(this);

                    exprs = temp;

                    return ctx.mkExists(new Expr[]{expr}
                            , ctx.mkAnd(leftBoolExpr, rightBoolExpr)
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));

                }
            case UNION:
                BoolExpr leftBoolExpr = binExpr.left().accept(this);
                BoolExpr rightBoolExpr = binExpr.right().accept(this);

                return ctx.mkOr(leftBoolExpr, rightBoolExpr);

            case INTERSECTION:
                leftBoolExpr = binExpr.left().accept(this);
                rightBoolExpr = binExpr.right().accept(this);

                return ctx.mkAnd(leftBoolExpr, rightBoolExpr);

            case PRODUCT:
                leftExpression = binExpr.left();
                rightExpression = binExpr.right();

                leftExprs = new Expr[leftExpression.arity()];
                System.arraycopy(exprs, 0, leftExprs, 0, leftExprs.length);

                rightExprs = new Expr[rightExpression.arity()];
                System.arraycopy(exprs, leftExpression.arity(), rightExprs, 0, rightExprs.length);

                Expr[] temp = exprs;

                exprs = leftExprs;
                leftBoolExpr = leftExpression.accept(this);
                exprs = rightExprs;
                rightBoolExpr = rightExpression.accept(this);

                exprs = temp;

                return ctx.mkAnd(leftBoolExpr, rightBoolExpr);

            case DIFFERENCE:
                leftBoolExpr = binExpr.left().accept(this);

                notCount++;
                rightBoolExpr = binExpr.right().accept(this);
                notCount--;

                rightBoolExpr = ctx.mkNot(rightBoolExpr);

                return ctx.mkAnd(leftBoolExpr, rightBoolExpr);

            case OVERRIDE:
                BoolExpr boolExpr = binExpr.right().accept(this);
                BoolExpr else_ = binExpr.left().accept(this);

                return (BoolExpr) ctx.mkITE(boolExpr, ctx.mkTrue(), else_);

            default:

                return ctx.mkFalse();

        }
    }

    @Override
    public BoolExpr visit(IfExpression ifExpr) {
        BoolExpr then_ = ifExpr.thenExpr().accept(this);
        notCount++;
        then_ = ctx.mkImplies(ifExpr.condition().accept(this), then_);
        notCount--;

        BoolExpr else_ = ctx.mkOr(ifExpr.condition().accept(this), ifExpr.elseExpr().accept(this));

        return ctx.mkAnd(then_, else_);

    }

    @Override
    public BitVecExpr visit(IntConstant intConst) {
        return ctx.mkBV(intConst.value(), BIT_SIZE);
    }

    @Override
    public BitVecExpr visit(IfIntExpression intExpr) {
        // TODO: Re-think this. (notCount)
        BoolExpr if_ = intExpr.condition().accept(this);
        BitVecExpr then_ = intExpr.thenExpr().accept(this);
        BitVecExpr else_ = intExpr.elseExpr().accept(this);

        return (BitVecExpr) ctx.mkITE(if_, then_, else_);

    }

    private FuncDecl eliminatedCardinality(Expression expression) {
        int tempNotCount = notCount;
        notCount = 0;

        VariableDetector variableDetector = new VariableDetector();
        expression.accept(variableDetector);

        Set<Variable> variables = variableDetector.variables().stream()
                .filter(v -> variableExprMap.containsKey(v))
                .collect(Collectors.toSet());

        Map<Variable, Expr> tempMap = new HashMap<>();

        int inSize = variables.size();
        int outSize = expression.arity();

        Sort[] inSorts = new Sort[inSize];
        Arrays.fill(inSorts, UNIV);

        FuncDecl cardinalityFunc = ctx.mkFuncDecl("#[" + expression.toString() + "]" + varCount++
                , inSorts, ctx.mkBitVecSort(BIT_SIZE));

        Sort[] ordSorts = new Sort[inSize + outSize];
        Arrays.fill(ordSorts, UNIV);

        FuncDecl ordFunc = ctx.mkFuncDecl("ord[" + expression.toString() + "]" + varCount++, ordSorts, ctx.mkBitVecSort(BIT_SIZE));

        Set<Tuple> upperbounds = expression.accept(upperBoundFinder);

        QuantifierEliminator.getQuantifiers(objectExprMap, upperBoundFinder, variables.toArray(new Variable[0])).forEach(map -> {

            map.forEach((variable, constExpr) -> {
                Expr expr = variableExprMap.get(variable);
                if (expr.isConst()) {
                    tempMap.put(variable, expr);
                    variableExprMap.put(variable, constExpr);
                }
            });

            Expr[] inExprs = map.entrySet().stream().sorted(Comparator.comparingInt(a -> a.getKey().hashCode()))
                    .map(e -> variableExprMap.get(e.getKey())).toArray(Expr[]::new);

            Expr[] ordExprs = new Expr[ordSorts.length];
            System.arraycopy(inExprs, 0, ordExprs, 0, inSize);

            Expr[] outExprs = new Expr[outSize];

            BitVecExpr bitVecExpr = ctx.mkBVConst("i!" + varCount++, BIT_SIZE);

            Expr[] invExprs = new Expr[inSize + 1];
            System.arraycopy(inExprs, 0, invExprs, 0, inSize);
            invExprs[invExprs.length - 1] = bitVecExpr;

            // crd = 0 ⇔ ∀f : FSO, ¬isFSO(f )
            // ****************************************** //
            BoolExpr first = ctx.mkImplies(ctx.mkEq(cardinalityFunc.apply(inExprs), ctx.mkBV(0, BIT_SIZE)), expression.no().accept(this));
            notCount++;
            BoolExpr second = ctx.mkImplies(expression.no().accept(this), ctx.mkEq(cardinalityFunc.apply(inExprs), ctx.mkBV(0, BIT_SIZE)));
            notCount--;
            BoolExpr boolExprEqZero = ctx.mkAnd(first, second);

            goal.add(boolExprEqZero);
            // ****************************************** //

            // ∀f : FSO | isFSO(f) ⇒ 1 ≤ ord(f ) ≤ crd
            // ****************************************** //

            notCount++;

            upperbounds.forEach(tuple -> {
                for (int i = inSize; i < ordExprs.length; i++) {
                    ordExprs[i] = objectExprMap.get(tuple.atom(i - inSize));
                }

                System.arraycopy(ordExprs, inSize, outExprs, 0, outSize);

                exprs = outExprs;

                BoolExpr boolExpr = ctx.mkImplies(expression.accept(this)
                        , ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), (BitVecExpr) ordFunc.apply(ordExprs))
                                , ctx.mkBVSLE((BitVecExpr) ordFunc.apply(ordExprs)
                                        , (BitVecExpr) cardinalityFunc.apply(inExprs))));

                goal.add(boolExpr);
            });

            notCount--;

            // ****************************************** //

            // ∀i : Nat | 1 ≤ i ≤ crd ⇒ isFSO(inv(i))
            // inv = ord^−1
            // ****************************************** //

            for (int i = inSize; i < ordExprs.length; i++) {
                ordExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
            }

            System.arraycopy(ordExprs, inSize, outExprs, 0, outSize);

            exprs = outExprs;

            for (int i = 1; i <= upperbounds.size(); i++) {
                bitVecExpr = ctx.mkBV(i, BIT_SIZE);

                BoolExpr boolExpr = ctx.mkImplies(ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), bitVecExpr)
                        , ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(inExprs)))
                        , ctx.mkExists(outExprs, ctx.mkAnd(
                                ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
                                , expression.accept(this))
                                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null));

                goal.add(boolExpr);
            }

            final Expr[] oneToOneExprs = new Expr[inSize + outSize * 2];
            System.arraycopy(inExprs, 0, oneToOneExprs, 0, inSize);

            upperbounds.forEach(tuple1 -> {
                for (int i = 0; i < outSize; i++) {
                    oneToOneExprs[inSize + i] = objectExprMap.get(tuple1.atom(i));
                }
                upperbounds.forEach(tuple2 -> {
                    for (int i = 0; i < outSize; i++) {
                        oneToOneExprs[inSize + outSize + i] = objectExprMap.get(tuple2.atom(i));
                    }

                    Expr[] firstOne = new Expr[ordExprs.length];
                    System.arraycopy(oneToOneExprs, 0, firstOne, 0, firstOne.length);

                    Expr[] secondOne = new Expr[ordExprs.length];
                    System.arraycopy(oneToOneExprs, 0, secondOne, 0, inSize);
                    System.arraycopy(oneToOneExprs, ordExprs.length, secondOne, inSize, outSize);

                    BoolExpr[] eqs = new BoolExpr[outSize];
                    for (int i = 0; i < outSize; i++) {
                        eqs[i] = ctx.mkEq(firstOne[i + inSize], secondOne[i + inSize]);
                    }

                    BoolExpr boolExpr = ctx.mkImplies(ctx.mkEq(ordFunc.apply(firstOne), ordFunc.apply(secondOne)), ctx.mkAnd(eqs));

                    goal.add(boolExpr);
                });
            });
            // ****************************************** //

            variableExprMap.putAll(tempMap);
        });

        notCount = tempNotCount;

        return cardinalityFunc;
    }

    private FuncDecl eliminatedSum(Expression expression) {
        int tempNotCount = notCount;
        notCount = 0;

        VariableDetector variableDetector = new VariableDetector();
        expression.accept(variableDetector);

        Set<Variable> variables = variableDetector.variables().stream()
                .filter(v -> variableExprMap.containsKey(v))
                .collect(Collectors.toSet());

        Map<Variable, Expr> tempMap = new HashMap<>();

        int inSize = variables.size();
        int outSize = expression.arity();

        Sort[] inSorts = new Sort[inSize];
        Arrays.fill(inSorts, UNIV);

        FuncDecl sum = ctx.mkFuncDecl("SUM[" + expression.toString() + "]" + varCount++
                , inSorts, ctx.mkBitVecSort(BIT_SIZE));

        FuncDecl cardinalityFunc = ctx.mkFuncDecl("#[" + expression.toString() + "]" + varCount++
                , inSorts, ctx.mkBitVecSort(BIT_SIZE));

        Sort[] sumSorts = new Sort[inSize + 1];
        Arrays.fill(sumSorts, UNIV);
        sumSorts[sumSorts.length - 1] = ctx.mkBitVecSort(BIT_SIZE);

        FuncDecl sumFunc = ctx.mkFuncDecl("SUM_RECURSIVE[" + expression.toString() + "]" + varCount++
                , sumSorts, ctx.mkBitVecSort(BIT_SIZE));

        Sort[] ordSorts = new Sort[inSize + outSize];
        Arrays.fill(ordSorts, UNIV);

        FuncDecl ordFunc = ctx.mkFuncDecl("ord[" + expression.toString() + "]" + varCount++, ordSorts, ctx.mkBitVecSort(BIT_SIZE));

        Sort[] invSorts = new Sort[inSize + 1];
        System.arraycopy(inSorts, 0, invSorts, 0, inSize);
        invSorts[invSorts.length - 1] = ctx.mkBitVecSort(BIT_SIZE);

        FuncDecl noToResultFunc = ctx.mkFuncDecl("NO[" + expression.toString() + "]" + varCount++
                , invSorts, ctx.mkBitVecSort(BIT_SIZE));

        Set<Tuple> upperbounds = expression.accept(upperBoundFinder);

        int minCount = (int) Math.min(upperbounds.size(), Math.pow(2, BIT_SIZE - 1) - 1);

        QuantifierEliminator.getQuantifiers(objectExprMap, upperBoundFinder, variables.toArray(new Variable[0])).forEach(map -> {

            map.forEach((variable, constExpr) -> {
                Expr expr = variableExprMap.get(variable);
                if (expr.isConst()) {
                    tempMap.put(variable, expr);
                    variableExprMap.put(variable, constExpr);
                }
            });

            Expr[] inExprs = map.entrySet().stream().sorted(Comparator.comparingInt(a -> a.getKey().hashCode()))
                    .map(e -> variableExprMap.get(e.getKey())).toArray(Expr[]::new);

            Expr[] ordExprs = new Expr[ordSorts.length];
            System.arraycopy(inExprs, 0, ordExprs, 0, inSize);

            Expr[] outExprs = new Expr[outSize];

            Expr[] invExprs = new Expr[inSize + 1];
            System.arraycopy(inExprs, 0, invExprs, 0, inSize);
            invExprs[invExprs.length - 1] = null;

            // crd = 0 ⇔ ∀f : FSO, ¬isFSO(f )
            // ****************************************** //

            BoolExpr first = ctx.mkImplies(ctx.mkEq(cardinalityFunc.apply(inExprs), ctx.mkBV(0, BIT_SIZE)), expression.no().accept(this));
            notCount++;
            BoolExpr second = ctx.mkImplies(expression.no().accept(this), ctx.mkEq(cardinalityFunc.apply(inExprs), ctx.mkBV(0, BIT_SIZE)));
            notCount--;
            BoolExpr boolExprEqZero = ctx.mkAnd(first, second);

            goal.add(boolExprEqZero);
            // ****************************************** //

            // ∀f : FSO | isFSO(f) ⇒ 1 ≤ ord(f ) ≤ crd
            // ****************************************** //

            notCount++;

            upperbounds.forEach(tuple -> {
                for (int i = inSize; i < ordExprs.length; i++) {
                    ordExprs[i] = objectExprMap.get(tuple.atom(i - inSize));
                }

                System.arraycopy(ordExprs, inSize, outExprs, 0, outSize);

                exprs = outExprs;

                BoolExpr boolExpr = ctx.mkImplies(expression.accept(this)
                        , ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), (BitVecExpr) ordFunc.apply(ordExprs))
                                , ctx.mkBVSLE((BitVecExpr) ordFunc.apply(ordExprs)
                                        , (BitVecExpr) cardinalityFunc.apply(inExprs))));

                goal.add(boolExpr);
            });

            notCount--;

            // ****************************************** //

            // ∀i : Nat | 1 ≤ i ≤ crd ⇒ isFSO(inv(i))
            // inv = ord^−1
            // ****************************************** //

            for (int i = inSize; i < ordExprs.length; i++) {
                ordExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
            }

            System.arraycopy(ordExprs, inSize, outExprs, 0, outSize);

            exprs = outExprs;

            for (int i = 1; i <= minCount; i++) {
                BitVecExpr bitVecExpr = ctx.mkBV(i, BIT_SIZE);

                BoolExpr boolExpr = ctx.mkImplies(ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), bitVecExpr)
                        , ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(inExprs)))
                        , ctx.mkExists(outExprs, ctx.mkAnd(
                                ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
                                , expression.accept(this))
                                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null));

                goal.add(boolExpr);
            }

            final Expr[] oneToOneExprs = new Expr[inSize + outSize * 2];
            System.arraycopy(inExprs, 0, oneToOneExprs, 0, inSize);

            upperbounds.forEach(tuple1 -> {
                for (int i = 0; i < outSize; i++) {
                    oneToOneExprs[inSize + i] = objectExprMap.get(tuple1.atom(i));
                }
                upperbounds.forEach(tuple2 -> {
                    for (int i = 0; i < outSize; i++) {
                        oneToOneExprs[inSize + outSize + i] = objectExprMap.get(tuple2.atom(i));
                    }

                    Expr[] firstOne = new Expr[ordExprs.length];
                    System.arraycopy(oneToOneExprs, 0, firstOne, 0, firstOne.length);

                    Expr[] secondOne = new Expr[ordExprs.length];
                    System.arraycopy(oneToOneExprs, 0, secondOne, 0, inSize);
                    System.arraycopy(oneToOneExprs, ordExprs.length, secondOne, inSize, outSize);

                    BoolExpr[] eqs = new BoolExpr[outSize];
                    for (int i = 0; i < outSize; i++) {
                        eqs[i] = ctx.mkEq(firstOne[i + inSize], secondOne[i + inSize]);
                    }

                    BoolExpr boolExpr = ctx.mkImplies(ctx.mkEq(ordFunc.apply(firstOne), ordFunc.apply(secondOne)), ctx.mkAnd(eqs));

                    goal.add(boolExpr);
                });
            });
            // ****************************************** //

            for (int i = 1; i <= minCount; i++) {
                BitVecExpr bitVecExpr = ctx.mkBV(i, BIT_SIZE);
                invExprs[invExprs.length - 1] = bitVecExpr;

                upperbounds.forEach(tuple -> {
                    for (int j = 0; j < outSize; j++) {
                        outExprs[j] = objectExprMap.get(tuple.atom(j));
                        ordExprs[inSize + j] = outExprs[j];
                    }

                    BoolExpr boolExpr = ctx.mkImplies(ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
                            , ctx.mkEq(noToResultFunc.apply(invExprs), univToInt == null ? ctx.mkBV(0, BIT_SIZE) : univToInt.apply(outExprs)));

                    goal.add(boolExpr);
                });

                Expr[] exprsPlusBVminus1 = new Expr[invExprs.length];
                System.arraycopy(inExprs, 0, exprsPlusBVminus1, 0, inSize);
                exprsPlusBVminus1[exprsPlusBVminus1.length - 1] = ctx.mkBV(i + 1, BIT_SIZE);

                BoolExpr boolExpr = ctx.mkEq(sumFunc.apply(invExprs)
                        , ctx.mkITE(ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(inExprs))
                                , ctx.mkBVAdd((BitVecExpr) sumFunc.apply(exprsPlusBVminus1), (BitVecExpr) noToResultFunc.apply(invExprs))
                                , ctx.mkBV(0, BIT_SIZE)));

                goal.add(boolExpr);
            }

            Expr[] sumWithCardExprs = new Expr[invSorts.length];
            System.arraycopy(inExprs, 0, sumWithCardExprs, 0, inExprs.length);
            sumWithCardExprs[sumWithCardExprs.length - 1] = ctx.mkBV(1, BIT_SIZE);

            BoolExpr boolExprSumEq = ctx.mkEq(sum.apply(inExprs), sumFunc.apply(sumWithCardExprs));

            goal.add(boolExprSumEq);

            variableExprMap.putAll(tempMap);
        });

        intExprFuncMap.put(expression.count().toString(), cardinalityFunc);

        notCount = tempNotCount;

        return sum;
    }

    @Override
    public BitVecExpr visit(ExprToIntCast exprToIntCast) {
        switch (exprToIntCast.op()) {
            case CARDINALITY:
                Expression expression = exprToIntCast.expression();

                if (expression instanceof Variable)
                    return ctx.mkBV(1, BIT_SIZE);

                FuncDecl func = intExprFuncMap.computeIfAbsent(exprToIntCast.toString(), e -> eliminatedCardinality(expression));

                VariableDetector variableDetector = new VariableDetector();
                expression.accept(variableDetector);
                Expr[] usedExprs = variableDetector.variables().stream().sorted(Comparator.comparingInt(Object::hashCode))
                        .map(v -> variableExprMap.get(v)).filter(Objects::nonNull).toArray(Expr[]::new);

                return (BitVecExpr) func.apply(usedExprs);
            case SUM:
                expression = exprToIntCast.expression();

                if (expression instanceof Variable && univToInt != null)
                    return (BitVecExpr) univToInt.apply(variableExprMap.get(expression));

                func = intExprFuncMap.computeIfAbsent(exprToIntCast.toString(), e -> eliminatedSum(expression));

                variableDetector = new VariableDetector();
                expression.accept(variableDetector);
                usedExprs = variableDetector.variables().stream().sorted(Comparator.comparingInt(Object::hashCode))
                        .map(v -> variableExprMap.get(v)).filter(Objects::nonNull).toArray(Expr[]::new);

                return (BitVecExpr) func.apply(usedExprs);
            default:
                return ctx.mkBV(0, BIT_SIZE);
        }
    }

    @Override
    public BitVecExpr visit(NaryIntExpression naryIntExpression) {
        Iterator<IntExpression> iterator = naryIntExpression.iterator();
        if (iterator.hasNext()) {
            BitVecExpr expr = iterator.next().accept(this);
            switch (naryIntExpression.op()) {
                case MULTIPLY:
                    while (iterator.hasNext()) {
                        BitVecExpr next = iterator.next().accept(this);
                        expr = ctx.mkBVMul(expr, next);

                    }
                    return expr;
                case PLUS:
                    while (iterator.hasNext()) {
                        BitVecExpr next = iterator.next().accept(this);
                        expr = ctx.mkBVAdd(expr, next);

                    }
                    return expr;
                case AND:
                    while (iterator.hasNext()) {
                        BitVecExpr next = iterator.next().accept(this);
                        expr = ctx.mkBVAND(expr, next);

                    }
                    return expr;
                case OR:
                    while (iterator.hasNext()) {
                        BitVecExpr next = iterator.next().accept(this);
                        expr = ctx.mkBVOR(expr, next);

                    }
                    return expr;
            }
        }
        return ctx.mkBV(0, BIT_SIZE);

    }

    @Override
    public BitVecExpr visit(BinaryIntExpression binaryIntExpression) {
        BitVecExpr left = binaryIntExpression.left().accept(this);
        BitVecExpr right = binaryIntExpression.right().accept(this);
        switch (binaryIntExpression.op()) {
            case AND:
                return ctx.mkBVAND(left, right);
            case OR:
                return ctx.mkBVOR(left, right);
            case SHA:
                return ctx.mkBVASHR(left, right);
            case SHL:
                return ctx.mkBVSHL(left, right);
            case SHR:
                return ctx.mkBVLSHR(left, right);
            case XOR:
                return ctx.mkBVXOR(left, right);
            case PLUS:
                return ctx.mkBVAdd(left, right);
            case MINUS:
                return ctx.mkBVSub(left, right);
            case DIVIDE:
                return ctx.mkBVSDiv(left, right);
            case MODULO:
                return ctx.mkBVSMod(left, right);
            case MULTIPLY:
                return ctx.mkBVMul(left, right);
            default:
                return ctx.mkBV(0, BIT_SIZE);
        }

    }

    @Override
    public BitVecExpr visit(UnaryIntExpression intExpr) {
        BitVecExpr expr = intExpr.intExpr().accept(this);
        switch (intExpr.op()) {
            case SGN:
                return (BitVecExpr) ctx.mkITE(ctx.mkEq(expr, ctx.mkBV(0, BIT_SIZE))
                        , ctx.mkBV(0, BIT_SIZE)
                        , ctx.mkITE(ctx.mkBVSGT(expr, ctx.mkBV(0, BIT_SIZE))
                                , ctx.mkBV(1, BIT_SIZE)
                                , ctx.mkBV(-1, BIT_SIZE)));
            case NOT:
                return ctx.mkBVNot(expr);
            case NEG:
                return ctx.mkBVNeg(expr);
            case ABS:
                return (BitVecExpr) ctx.mkITE(ctx.mkBVSLT(expr, ctx.mkBV(0, BIT_SIZE)), ctx.mkBVNeg(expr), expr);
            default:
                return ctx.mkBV(0, BIT_SIZE);
        }

    }

    private FuncDecl sum(SumExpression sumExpression) {

        int tempNotCount = notCount;
        notCount = 0;

        VariableDetector variableDetector = new VariableDetector();
        sumExpression.accept(variableDetector);

        List<Variable> outerVariables = new ArrayList<>(variableDetector.variables());
        List<Variable> declVariables = new ArrayList<>();

        Set<Expression> declExpressionSet = new HashSet<>();
        Set<Formula> declFormulaSet = new HashSet<>();

        sumExpression.decls().forEach(decl -> {
            if (decl.multiplicity() != Multiplicity.ONE)
                throw new HigherOrderDeclException(decl);
            if (decl.expression().arity() != 1)
                throw new RuntimeException(decl + ": decl.expression.arity != 1");
            declVariables.add(decl.variable());
            declExpressionSet.add(decl.expression());
            declFormulaSet.add(decl.variable().in(decl.expression()));
        });

        outerVariables.removeAll(declVariables);

        outerVariables.sort(Comparator.comparingInt(Object::hashCode));

        Map<Variable, Expr> tempMap = new HashMap<>(variableExprMap);

        Expr[] declExprs = new Expr[declVariables.size()];
        Expr[] outerExprs = new Expr[outerVariables.size()];

        int inSize = outerVariables.size();
        int outSize = declVariables.size();

        Sort[] inSorts = new Sort[inSize];
        Arrays.fill(inSorts, UNIV);

        FuncDecl sum = ctx.mkFuncDecl("SUM[" + sumExpression.toString() + "]" + varCount++
                , inSorts, ctx.mkBitVecSort(BIT_SIZE));

        FuncDecl cardinalityFunc = ctx.mkFuncDecl("#[" + sumExpression.toString() + "]" + varCount++
                , inSorts, ctx.mkBitVecSort(BIT_SIZE));

        Sort[] sumSorts = new Sort[inSize + 1];
        Arrays.fill(sumSorts, UNIV);
        sumSorts[sumSorts.length - 1] = ctx.mkBitVecSort(BIT_SIZE);

        FuncDecl sumRecursive = ctx.mkFuncDecl("SUM_RECURSIVE[" + sumExpression.toString() + "]" + varCount++
                , sumSorts, ctx.mkBitVecSort(BIT_SIZE));

        Sort[] ordSorts = new Sort[inSize + outSize];
        Arrays.fill(ordSorts, UNIV);

        FuncDecl ordFunc = ctx.mkFuncDecl("ord[" + sumExpression.toString() + "]" + varCount++, ordSorts, ctx.mkBitVecSort(BIT_SIZE));

        Sort[] invSorts = new Sort[inSize + 1];
        System.arraycopy(inSorts, 0, invSorts, 0, inSize);
        invSorts[invSorts.length - 1] = ctx.mkBitVecSort(BIT_SIZE);

        Set<Map<Variable, Expr>> outerMapSet = QuantifierEliminator.getQuantifiers(objectExprMap, upperBoundFinder, outerVariables.toArray(new Variable[0]));
        Set<Map<Variable, Expr>> declMapSet = QuantifierEliminator.getQuantifiers(objectExprMap, upperBoundFinder, declVariables.toArray(new Variable[0]));

        FuncDecl generalFunc = ctx.mkFuncDecl("PARTIAL_SUM[" + sumExpression.toString() + "]" + varCount++, invSorts, ctx.mkBitVecSort(BIT_SIZE));

        int minCount = (int) Math.min(Math.pow(2, BIT_SIZE - 1) - 1, declMapSet.size() * outerMapSet.size());

        outerMapSet.forEach(outerMap -> {
            for (int i = 0; i < outerExprs.length; i++) {
                outerExprs[i] = outerMap.get(outerVariables.get(i));
                variableExprMap.put(outerVariables.get(i), outerExprs[i]);
            }

            Expr[] invExprs = new Expr[inSize + 1];
            System.arraycopy(outerExprs, 0, invExprs, 0, inSize);
            invExprs[invExprs.length - 1] = null;

            Expr[] sumRecursiveExprsPlus1 = new Expr[invExprs.length];
            System.arraycopy(outerExprs, 0, sumRecursiveExprsPlus1, 0, inSize);
            sumRecursiveExprsPlus1[sumRecursiveExprsPlus1.length - 1] = null;

            // crd = 0 ⇔ ∀f : FSO, ¬isFSO(f )
            // ****************************************** //
            BoolExpr first = ctx.mkImplies(ctx.mkEq(cardinalityFunc.apply(outerExprs), ctx.mkBV(0, BIT_SIZE)), Expression.union(declExpressionSet).no().accept(this));
            notCount++;
            BoolExpr second = ctx.mkImplies(Expression.union(declExpressionSet).no().accept(this), ctx.mkEq(cardinalityFunc.apply(outerExprs), ctx.mkBV(0, BIT_SIZE)));
            notCount--;
            BoolExpr boolExprEqZero = ctx.mkAnd(first, second);

            goal.add(boolExprEqZero);
            // ****************************************** //

            // ∀i : Nat | 1 ≤ i ≤ crd ⇒ isFSO(inv(i))
            // inv = ord^−1

            Expr[] ordExprs = new Expr[ordSorts.length];
            System.arraycopy(outerExprs, 0, ordExprs, 0, inSize);
            for (int i = inSize; i < ordExprs.length; i++) {
                ordExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
                declExprs[i - inSize] = ordExprs[i];
            }

            for (int i = 0; i < declExprs.length; i++) {
                variableExprMap.put(declVariables.get(i), declExprs[i]);
            }

            for (int i = 1; i <= minCount; i++) {
                BitVecExpr bitVecExpr = ctx.mkBV(i, BIT_SIZE);
                invExprs[invExprs.length - 1] = bitVecExpr;
                sumRecursiveExprsPlus1[sumRecursiveExprsPlus1.length - 1] = ctx.mkBV(i + 1, BIT_SIZE);

                BoolExpr boolExprInv = ctx.mkImplies(ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), bitVecExpr)
                        , ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(outerExprs)))
                        , ctx.mkExists(declExprs, ctx.mkAnd(
                                ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
                                , Formula.and(declFormulaSet).accept(this))
                                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null));

                goal.add(boolExprInv);

                BoolExpr boolExprSumRecursive = ctx.mkEq(sumRecursive.apply(invExprs)
                        , ctx.mkITE(ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), bitVecExpr)
                                , ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(outerExprs)))
                                , ctx.mkBVAdd((BitVecExpr) generalFunc.apply(invExprs), (BitVecExpr) sumRecursive.apply(sumRecursiveExprsPlus1))
                                , ctx.mkBV(0, BIT_SIZE)));

                goal.add(boolExprSumRecursive);
            }

            // ****************************************** //

            Expr[] outerExprsPlus1 = new Expr[outerExprs.length + 1];
            System.arraycopy(outerExprs, 0, outerExprsPlus1, 0, outerExprs.length);
            outerExprsPlus1[outerExprsPlus1.length - 1] = ctx.mkBV(1, BIT_SIZE);

            BoolExpr boolExprSum = ctx.mkEq(sum.apply(outerExprs), sumRecursive.apply(outerExprsPlus1));

            goal.add(boolExprSum);

            declMapSet.forEach(declMap -> {
                for (int i = 0; i < declExprs.length; i++) {
                    declExprs[i] = declMap.get(declVariables.get(i));
                    variableExprMap.put(declVariables.get(i), declExprs[i]);
                }

                BitVecExpr generalSum = sumExpression.intExpr().accept(this);

                System.arraycopy(declExprs, 0, ordExprs, inSize, outSize);

                // ∀f : FSO | isFSO(f) ⇒ 1 ≤ ord(f ) ≤ crd
                // ****************************************** //

                notCount++;
                BoolExpr boolExprOrd = ctx.mkImplies(Formula.and(declFormulaSet).accept(this)
                                , ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), (BitVecExpr) ordFunc.apply(ordExprs))
                                        , ctx.mkBVSLE((BitVecExpr) ordFunc.apply(ordExprs)
                                                , (BitVecExpr) cardinalityFunc.apply(outerExprs))));
                notCount--;

                goal.add(boolExprOrd);
                // ****************************************** //

                Expr[] oneToOneExprs = new Expr[inSize + outSize * 2];
                System.arraycopy(ordExprs, 0, oneToOneExprs, 0, ordExprs.length);

                declMapSet.forEach(declMap2 -> {
                    for (int i = 0; i < declExprs.length; i++) {
                        oneToOneExprs[i + ordExprs.length] = declMap2.get(declVariables.get(i));
                    }

                    Expr[] firstOne = new Expr[ordExprs.length];
                    System.arraycopy(oneToOneExprs, 0, firstOne, 0, firstOne.length);

                    Expr[] secondOne = new Expr[ordExprs.length];
                    System.arraycopy(oneToOneExprs, 0, secondOne, 0, inSize);
                    System.arraycopy(oneToOneExprs, ordExprs.length, secondOne, inSize, outSize);

                    BoolExpr[] eqs = new BoolExpr[outSize];
                    for (int i = 0; i < outSize; i++) {
                        eqs[i] = ctx.mkEq(firstOne[i + inSize], secondOne[i + inSize]);
                    }

                    BoolExpr boolExprOneToOne = ctx.mkImplies(ctx.mkEq(ordFunc.apply(firstOne), ordFunc.apply(secondOne))
                                    , ctx.mkAnd(eqs));

                    goal.add(boolExprOneToOne);
                });

                for (int i = 1; i <= minCount; i++) {
                    BitVecExpr bitVecExpr = ctx.mkBV(i, BIT_SIZE);
                    invExprs[invExprs.length - 1] = bitVecExpr;

                    sumRecursiveExprsPlus1[sumRecursiveExprsPlus1.length - 1] = ctx.mkBV(i + 1, BIT_SIZE);

                    BoolExpr boolExprGeneral = ctx.mkImplies(ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
                                    , ctx.mkEq(generalFunc.apply(invExprs), generalSum));

                    goal.add(boolExprGeneral);
                }

            });
        });

        intExprFuncMap.put(sumExpression.toString(), sum);

        variableExprMap = tempMap;
        notCount = tempNotCount;

        return sum;
    }

    @Override
    public BitVecExpr visit(SumExpression sumExpression) {
        VariableDetector variableDetector = new VariableDetector();
        sumExpression.accept(variableDetector);

        List<Variable> outerVariables = new ArrayList<>(variableDetector.variables());

        sumExpression.decls().forEach(decl -> {
            outerVariables.remove(decl.variable());
        });

        outerVariables.sort(Comparator.comparingInt(Object::hashCode));

        Expr[] inExpr = outerVariables.stream().map(v -> variableExprMap.get(v)).toArray(Expr[]::new);

        return (BitVecExpr) intExprFuncMap.computeIfAbsent(sumExpression.toString(), s -> sum(sumExpression)).apply(inExpr);
    }

    @Override
    public BoolExpr visit(IntComparisonFormula intComparisonFormula) {
        BitVecExpr left;
        BitVecExpr right;
        switch (intComparisonFormula.op()) {
            case EQ:
                left = intComparisonFormula.left().accept(this);
                right = intComparisonFormula.right().accept(this);
                return ctx.mkEq(left, right);
            case GT:
                left = intComparisonFormula.left().accept(this);
                right = intComparisonFormula.right().accept(this);
                return ctx.mkBVSGT(left, right);
            case LT:
                left = intComparisonFormula.left().accept(this);
                right = intComparisonFormula.right().accept(this);
                return ctx.mkBVSLT(left, right);
            case GTE:
                left = intComparisonFormula.left().accept(this);
                right = intComparisonFormula.right().accept(this);
                return ctx.mkBVSGE(left, right);
            case LTE:
                left = intComparisonFormula.left().accept(this);
                right = intComparisonFormula.right().accept(this);
                return ctx.mkBVSLE(left, right);
            default:
                return ctx.mkFalse();
        }

    }

    @Override
    public BoolExpr visit(QuantifiedFormula quantifiedFormula) {
        int exprsSize = quantifiedFormula.decls().size();

        if ((quantifiedFormula.quantifier() == Quantifier.ALL && notCount % 2 == 0) ||
                (quantifiedFormula.quantifier() == Quantifier.SOME && notCount % 2 == 1)) {
            BoolExpr[] ands = new BoolExpr[exprsSize];

            Expr[] temp = exprs;

            quantifiedFormula.accept(upperBoundFinder);

            Variable[] variables = new Variable[quantifiedFormula.decls().size()];
            for (int i = 0; i < quantifiedFormula.decls().size(); i++) {
                variables[i] = quantifiedFormula.decls().get(i).variable();
            }
            Set<Map<Variable, Expr>> q = QuantifierEliminator.getQuantifiers(objectExprMap, upperBoundFinder, variables);

            Set<BoolExpr> boolExprs = new HashSet<>();
            q.forEach(map -> {
                variableExprMap.putAll(map);
                BoolExpr boolExpr = quantifiedFormula.formula().accept(this);
                notCount++;
                for (int i = 0; i < exprsSize; i++) {
                    Decl decl = quantifiedFormula.decls().get(i);
                    ands[i] = decl.accept(this);
                }
                notCount--;
                switch (quantifiedFormula.quantifier()) {
                    case ALL:
                        boolExpr = ctx.mkImplies(ctx.mkAnd(ands), boolExpr);
                        break;
                    case SOME:
                        boolExpr = ctx.mkAnd(ctx.mkAnd(ands), boolExpr);
                        break;
                }

                boolExprs.add(boolExpr);
            });

            exprs = temp;

            BoolExpr[] boolExprArray = boolExprs.toArray(new BoolExpr[0]);

            return quantifiedFormula.quantifier() == Quantifier.ALL ? ctx.mkAnd(boolExprArray) : ctx.mkOr(boolExprArray);
        }
        else {
            Expr[] exprs1 = new Expr[exprsSize];
            BoolExpr[] ands = new BoolExpr[exprsSize];

            for (int i = 0; i < exprsSize; i++) {
                Decl decl = quantifiedFormula.decls().get(i);
                exprs1[i] = ctx.mkConst(decl.variable().name(), UNIV);
                variableExprMap.put(decl.variable(), exprs1[i]);
            }

            notCount++;
            for (int i = 0; i < exprsSize; i++) {
                Decl decl = quantifiedFormula.decls().get(i);
                ands[i] = decl.accept(this);
            }
            notCount--;

            Expr[] temp = exprs;

            exprs = exprs1;
            BoolExpr boolExpr = quantifiedFormula.formula().accept(this);

            exprs = temp;

            return quantifiedFormula.quantifier() == Quantifier.SOME
                    ? ctx.mkExists(exprs1
                        , ctx.mkAnd(ctx.mkAnd(ands), boolExpr)
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++)
                        , ctx.mkSymbol(skolemPrefix + skolemID++))
                    : ctx.mkForall(exprs1
                        , ctx.mkImplies(ctx.mkAnd(ands), boolExpr)
                        , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++)
                        , ctx.mkSymbol(skolemPrefix + skolemID++));
        }

    }

    @Override
    public BoolExpr visit(BinaryFormula binFormula) {
        BoolExpr left;
        BoolExpr right;
        switch (binFormula.op()) {
            case IMPLIES:
                notCount++;
                left = binFormula.left().accept(this);
                notCount--;
                right = binFormula.right().accept(this);
                return ctx.mkImplies(left, right);
            case IFF:
                notCount++;
                left = binFormula.left().accept(this);
                notCount--;
                right = binFormula.right().accept(this);
                BoolExpr first = ctx.mkImplies(left, right);

                left = binFormula.left().accept(this);
                notCount++;
                right = binFormula.right().accept(this);
                notCount--;
                BoolExpr second = ctx.mkImplies(right, left);
                return ctx.mkAnd(first, second);
            case OR:
                left = binFormula.left().accept(this);
                right = binFormula.right().accept(this);
                return ctx.mkOr(left, right);
            case AND:
                left = binFormula.left().accept(this);
                right = binFormula.right().accept(this);
                return ctx.mkAnd(left, right);
            default:
                return ctx.mkFalse();
        }

    }

    @Override
    public BoolExpr visit(NotFormula not) {
        notCount++;
        BoolExpr boolExpr = not.formula().accept(this);
        notCount--;
        return ctx.mkNot(boolExpr);
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

                Expr[] temp = exprs;

                if (notCount % 2 == 0) {
                    Set<BoolExpr> boolExprs = new HashSet<>();

                    Set<Tuple> tupleSet = new HashSet<>(upperBoundCache.computeIfAbsent(compFormula.left()
                            , e -> compFormula.left().accept(upperBoundFinder)));
                    tupleSet.addAll(upperBoundCache.computeIfAbsent(compFormula.right()
                            , e -> compFormula.right().accept(upperBoundFinder)));

                    tupleSet.forEach(tuple -> {
                        exprs = new Expr[tuple.arity()];
                        for (int i = 0; i < tuple.arity(); i++) {
                            exprs[i] = objectExprMap.get(tuple.atom(i));
                        }

                        notCount++;
                        BoolExpr left = compFormula.left().accept(this);
                        notCount--;
                        BoolExpr right = compFormula.right().accept(this);

                        BoolExpr first = ctx.mkImplies(left, right);

                        left = compFormula.left().accept(this);
                        notCount++;
                        right = compFormula.right().accept(this);
                        notCount--;

                        BoolExpr second = ctx.mkImplies(right, left);

                        boolExprs.add(ctx.mkAnd(first, second));

                    });

                    exprs = temp;
                    return ctx.mkAnd(boolExprs.toArray(new BoolExpr[0]));
                }
                else {
                    exprs1 = new Expr[compFormula.left().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                    }

                    exprs = exprs1;

                    notCount++;
                    BoolExpr left = compFormula.left().accept(this);
                    notCount--;
                    BoolExpr right = compFormula.right().accept(this);

                    BoolExpr first = ctx.mkImplies(left, right);

                    left = compFormula.left().accept(this);
                    notCount++;
                    right = compFormula.right().accept(this);
                    notCount--;

                    BoolExpr second = ctx.mkImplies(right, left);

                    exprs = temp;

                    return ctx.mkForall(exprs1, ctx.mkAnd(first, second)
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
                }

            case SUBSET:
                if (compFormula.left() instanceof Variable) {
                    if (compFormula.right() instanceof Variable) {
                        return ctx.mkEq(variableExprMap.get(compFormula.left()), variableExprMap.get(compFormula.right()));

                    } else {
                        exprs1 = new Expr[compFormula.left().arity()];
                        exprs1[0] = variableExprMap.get(compFormula.left());

                        temp = exprs;

                        exprs = exprs1;
                        BoolExpr boolExpr = compFormula.right().accept(this);

                        exprs = temp;

                        return boolExpr;
                    }
                } else if (compFormula.right() instanceof Variable) {
                    Variable variable = Variable.unary("x!" + varCount++);
                    return variable.eq(compFormula.right()).forAll(variable.oneOf(compFormula.left())).accept(this);
                }

                temp = exprs;

                if (notCount % 2 == 0) {
                    Set<BoolExpr> boolExprs = new HashSet<>();
                    upperBoundCache.computeIfAbsent(compFormula.left(), e -> compFormula.left().accept(upperBoundFinder)).forEach(tuple -> {
                        exprs = new Expr[tuple.arity()];
                        for (int i = 0; i < tuple.arity(); i++) {
                            exprs[i] = objectExprMap.get(tuple.atom(i));
                        }

                        notCount++;
                        BoolExpr left = compFormula.left().accept(this);
                        notCount--;
                        BoolExpr right = compFormula.right().accept(this);

                        boolExprs.add(ctx.mkImplies(left, right));

                    });

                    exprs = temp;

                    return ctx.mkAnd(boolExprs.toArray(new BoolExpr[0]));
                }
                else {
                    exprs1 = new Expr[compFormula.left().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                    }

                    exprs = exprs1;

                    notCount++;
                    BoolExpr left = compFormula.left().accept(this);
                    notCount--;

                    BoolExpr right = compFormula.right().accept(this);

                    exprs = temp;

                    return ctx.mkForall(exprs1
                            , ctx.mkImplies(left, right)
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
                }
            default:
                return ctx.mkFalse();

        }
    }

    @Override
    public BoolExpr visit(MultiplicityFormula multiplicityFormula) {
        switch (multiplicityFormula.multiplicity()) {
            case SOME:
                Expr[] temp = exprs;

                if (notCount % 2 == 0) {
                    Expr[] exprs1 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                    }

                    exprs = exprs1;
                    BoolExpr boolExpr = multiplicityFormula.expression().accept(this);

                    exprs = temp;
                    return ctx.mkExists(exprs1, boolExpr
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++));
                }
                else {
                    Set<BoolExpr> boolExprs = new HashSet<>();

                    upperBoundCache.computeIfAbsent(multiplicityFormula.expression()
                            , e ->  multiplicityFormula.expression().accept(upperBoundFinder))
                            .forEach(tuple -> {
                                exprs = new Expr[tuple.arity()];
                                for (int i = 0; i < tuple.arity(); i++) {
                                    exprs[i] = objectExprMap.get(tuple.atom(i));
                                }
                                boolExprs.add(multiplicityFormula.expression().accept(this));
                            });

                    exprs = temp;

                    return ctx.mkOr(boolExprs.toArray(new BoolExpr[0]));
                }

            case NO:
                temp = exprs;

                if (notCount % 2 == 0) {
                    Set<BoolExpr> boolExprs = new HashSet<>();
                    upperBoundCache.computeIfAbsent(multiplicityFormula.expression()
                            , e -> multiplicityFormula.expression().accept(upperBoundFinder))
                            .forEach(tuple -> {
                                exprs = new Expr[tuple.arity()];
                                for (int i = 0; i < tuple.arity(); i++) {
                                    exprs[i] = objectExprMap.get(tuple.atom(i));
                                }
                                notCount++;
                                BoolExpr b = multiplicityFormula.expression().accept(this);
                                notCount--;

                                boolExprs.add(ctx.mkNot(b));

                            });

                    exprs = temp;

                    return ctx.mkAnd(boolExprs.toArray(new BoolExpr[0]));
                }
                else {
                    Expr[]exprs1 = new Expr[multiplicityFormula.expression().arity()];
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

                    exprs = exprs1;

                    notCount++;
                    BoolExpr boolExpr = multiplicityFormula.expression().accept(this);
                    notCount--;

                    exprs = temp;

                    return ctx.mkNot(ctx.mkExists(exprs1, boolExpr
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), ctx.mkSymbol(skolemPrefix + skolemID++)));
                }
            case ONE:
                BoolExpr some = multiplicityFormula.expression().some().accept(this);
                BoolExpr lone = multiplicityFormula.expression().lone().accept(this);
                return ctx.mkAnd(some, lone);

            case LONE:
                temp = exprs;

                if (notCount % 2 == 0) {
                    Set<BoolExpr> boolExprs = new HashSet<>();

                    Set<Tuple> tupleSet = upperBoundCache.computeIfAbsent(multiplicityFormula.expression()
                            , e -> multiplicityFormula.expression().accept(upperBoundFinder));

                    notCount++;

                    tupleSet.forEach(tuple -> {
                        exprs = new Expr[tuple.arity()];
                        for (int i = 0; i < tuple.arity(); i++) {
                            exprs[i] = objectExprMap.get(tuple.atom(i));
                        }

                        BoolExpr b1 = multiplicityFormula.expression().accept(this);

                        Expr[] exprs2 = exprs;

                        tupleSet.forEach(tuple2 -> {
                            exprs = new Expr[tuple2.arity()];
                            for (int i = 0; i < tuple2.arity(); i++) {
                                exprs[i] = objectExprMap.get(tuple2.atom(i));
                            }

                            BoolExpr b2 = multiplicityFormula.expression().accept(this);

                            BoolExpr[] eqs = new BoolExpr[exprs.length];
                            for (int i = 0; i < eqs.length; i++) {
                                eqs[i] = ctx.mkEq(exprs[i], exprs2[i]);

                            }
                            boolExprs.add(ctx.mkImplies(ctx.mkAnd(b1, b2), ctx.mkAnd(eqs)));

                        });
                    });

                    notCount--;

                    exprs = temp;
                    return ctx.mkAnd(boolExprs.toArray(new BoolExpr[0]));
                }
                else {
                    Expr[] exprs1 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs1[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                    }
                    Expr[] exprs2 = new Expr[multiplicityFormula.expression().arity()];
                    for (int i = 0; i < exprs1.length; i++) {
                        exprs2[i] = ctx.mkConst("x!" + (varCount++), UNIV);
                    }
                    BoolExpr[] eqs = new BoolExpr[exprs1.length];
                    for (int i = 0; i < eqs.length; i++) {
                        eqs[i] = ctx.mkEq(exprs1[i], exprs2[i]);
                    }

                    Expr[] allExprs = new Expr[exprs1.length + exprs2.length];
                    System.arraycopy(exprs1, 0, allExprs, 0, exprs1.length);
                    System.arraycopy(exprs2, 0, allExprs, exprs1.length, exprs2.length);

                    notCount++;

                    exprs = exprs1;
                    BoolExpr boolExpr1 = multiplicityFormula.expression().accept(this);
                    exprs = exprs2;
                    BoolExpr boolExpr2 = multiplicityFormula.expression().accept(this);

                    notCount--;

                    exprs = temp;

                    return ctx.mkForall(allExprs
                            , ctx.mkImplies(ctx.mkAnd(boolExpr1, boolExpr2), ctx.mkAnd(eqs))
                            , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
                }
            default:
                return ctx.mkFalse();

        }
    }
}
