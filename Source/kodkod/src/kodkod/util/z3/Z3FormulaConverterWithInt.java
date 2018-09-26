package kodkod.util.z3;

import com.microsoft.z3.*;
import kodkod.ast.*;
import kodkod.ast.operator.ExprOperator;
import kodkod.ast.operator.Multiplicity;
import kodkod.ast.visitor.ReturnVisitor;
import kodkod.engine.fol2sat.HigherOrderDeclException;
import kodkod.instance.Bounds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by harun on 7/16/18.
 */
public class Z3FormulaConverterWithInt extends Z3FormulaConverter<IntExpr> {

    public Z3FormulaConverterWithInt(Context ctx, Sort UNIV, Map<Expression, FuncDecl> funcDeclMap
            , Map<Object, Expr> objectExprMap, int BIT_SIZE) {
        super(ctx, UNIV, funcDeclMap, objectExprMap, BIT_SIZE);

        if (objectExprMap.entrySet().stream().anyMatch(e -> e.getKey() instanceof Integer)) {
            FuncDecl intsFuncDecl = ctx.mkFuncDecl("Ints", new Sort[]{UNIV}, ctx.mkBoolSort());
            funcDeclMap.put(Relation.INTS, intsFuncDecl);

            univToInt = ctx.mkFuncDecl("toInt", UNIV, ctx.mkIntSort());

            objectExprMap.forEach(((o, expr) -> {
                if (o instanceof Integer) {
                    goal.add((BoolExpr) ctx.mkApp(intsFuncDecl, expr));
                    goal.add(ctx.mkEq(ctx.mkApp(univToInt, expr), ctx.mkInt((Integer) o)));
                } else {
                    try {
                        int i = Integer.parseInt(o.toString());
                        goal.add(ctx.mkEq(ctx.mkApp(univToInt, expr), ctx.mkInt(i)));
                    }
                    catch (NumberFormatException e) {
                        goal.add(ctx.mkEq(ctx.mkApp(univToInt, expr), ctx.mkInt(0)));
                    }
                    goal.add(ctx.mkNot((BoolExpr) ctx.mkApp(intsFuncDecl, expr)));
                }
            }));
        }
    }

    @Override
    public IntExpr visit(IntConstant intConst) {
        return ctx.mkInt(intConst.value());
    }

    @Override
    public IntExpr visit(IfIntExpression intExpr) {
        return (IntExpr) ctx.mkITE(intExpr.condition().accept(this)
                , intExpr.thenExpr().accept(this)
                , intExpr.elseExpr().accept(this));
    }

    private FuncDecl cardinality(Expression expression) {
        VariableDetector variableDetector = new VariableDetector();
        expression.accept(variableDetector);

        Set<Variable> variables = variableDetector.variables().stream()
                .filter(v -> variableExprMap.containsKey(v))
                .collect(Collectors.toSet());

        Map<Variable, Expr> tempMap = new HashMap<>();

        variables.forEach(variable -> {
            Expr expr = variableExprMap.get(variable);
            if (expr.isConst()) {
                tempMap.put(variable, expr);
                variableExprMap.put(variable, ctx.mkConst("x!" + varCount++, UNIV));
            }
        });

        Expr[] inExprs = variables.stream().sorted(Comparator.comparingInt(Object::hashCode)).map(v -> variableExprMap.get(v)).toArray(Expr[]::new);

        int inSize = variables.size();
        int outSize = expression.arity();

        Sort[] inSorts = new Sort[inSize];
        Arrays.fill(inSorts, UNIV);

        FuncDecl cardinalityFunc = ctx.mkFuncDecl("#[" + expression.toString() + "]" + varCount++
                , inSorts, ctx.mkIntSort());

        Sort[] ordSorts = new Sort[inSize + outSize];
        Arrays.fill(ordSorts, UNIV);

        FuncDecl ordFunc = ctx.mkFuncDecl("ord[" + expression.toString() + "]" + varCount++, ordSorts, ctx.mkIntSort());

        Expr[] ordExprs = new Expr[ordSorts.length];
        System.arraycopy(inExprs, 0, ordExprs, 0, inSize);
        for (int i = inSize; i < ordExprs.length; i++) {
            ordExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
        }

        Expr[] outExprs = new Expr[outSize];
        System.arraycopy(ordExprs, inSize, outExprs, 0, outSize);

        IntExpr intExpr = ctx.mkIntConst("i!" + varCount++);

        Expr[] invExprs = new Expr[inSize + 1];
        System.arraycopy(inExprs, 0, invExprs, 0, inSize);
        invExprs[invExprs.length - 1] = intExpr;

        Expr[] temp;

        // crd = 0 ⇔ ∀f : FSO, ¬isFSO(f )
        // ****************************************** //
        BoolExpr boolExprEqZero = ctx.mkIff(ctx.mkEq(cardinalityFunc.apply(inExprs), ctx.mkInt(0)), expression.no().accept(this));

        if (inSize > 0) {
            boolExprEqZero = ctx.mkForall(inExprs, boolExprEqZero
                    , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
        }
        // ****************************************** //

        // ∀f : FSO | isFSO(f) ⇒ 1 ≤ ord(f ) ≤ crd
        // ****************************************** //

        temp = exprs;
        exprs = outExprs;

        BoolExpr boolExprOrd = ctx.mkForall(ordExprs
                , ctx.mkImplies(expression.accept(this)
                        , ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), (IntExpr) ordFunc.apply(ordExprs))
                                , ctx.mkLe((IntExpr) ordFunc.apply(ordExprs)
                                        , (IntExpr) cardinalityFunc.apply(inExprs))))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        exprs = temp;

        // ****************************************** //

        // ∀i : Nat | 1 ≤ i ≤ crd ⇒ isFSO(inv(i))
        // inv = ord^−1
        // ****************************************** //

        temp = exprs;
        exprs = outExprs;

        BoolExpr boolExprInv = ctx.mkForall(invExprs,
                ctx.mkImplies(ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), intExpr)
                        , ctx.mkLe(intExpr, (IntExpr) cardinalityFunc.apply(inExprs)))
                        , ctx.mkExists(outExprs, ctx.mkAnd(
                                ctx.mkEq(ordFunc.apply(ordExprs), intExpr)
                                , expression.accept(this))
                                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        exprs = temp;

        Expr[] oneToOneExprs = new Expr[inSize + outSize * 2];
        for (int i = 0; i < oneToOneExprs.length; i++) {
            oneToOneExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
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

        BoolExpr boolExprOneToOne = ctx.mkForall(oneToOneExprs
                , ctx.mkImplies(ctx.mkEq(ordFunc.apply(firstOne), ordFunc.apply(secondOne))
                        , ctx.mkAnd(eqs))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        // ****************************************** //

        goal.add(boolExprEqZero);
        goal.add(boolExprOrd);
        goal.add(boolExprInv);
        goal.add(boolExprOneToOne);

        variableExprMap.putAll(tempMap);

        return cardinalityFunc;
    }

    private FuncDecl sum(Expression expression) {
        VariableDetector variableDetector = new VariableDetector();
        expression.accept(variableDetector);

        Set<Variable> variables = variableDetector.variables().stream()
                .filter(v -> variableExprMap.containsKey(v))
                .collect(Collectors.toSet());

        Map<Variable, Expr> tempMap = new HashMap<>();

        variables.forEach(variable -> {
            Expr expr = variableExprMap.get(variable);
            if (expr.isConst()) {
                tempMap.put(variable, expr);
                variableExprMap.put(variable, ctx.mkConst("x!" + varCount++, UNIV));
            }
        });

        Expr[] inExprs = variables.stream().sorted(Comparator.comparingInt(Object::hashCode)).map(v -> variableExprMap.get(v)).toArray(Expr[]::new);

        int inSize = variables.size();
        int outSize = expression.arity();

        Sort[] inSorts = new Sort[inSize];
        Arrays.fill(inSorts, UNIV);

        FuncDecl sum = ctx.mkFuncDecl("SUM[" + expression.toString() + "]" + varCount++
                , inSorts, ctx.mkIntSort());

        FuncDecl cardinalityFunc = ctx.mkFuncDecl("#[" + expression.toString() + "]" + varCount++
                , inSorts, ctx.mkIntSort());

        Sort[] sumSorts = new Sort[inSize + 1];
        Arrays.fill(sumSorts, UNIV);
        sumSorts[sumSorts.length - 1] = ctx.mkIntSort();

        FuncDecl sumFunc = ctx.mkFuncDecl("SUM_RECURSIVE[" + expression.toString() + "]" + varCount++
                , sumSorts, ctx.mkIntSort());

        Sort[] ordSorts = new Sort[inSize + outSize];
        Arrays.fill(ordSorts, UNIV);

        FuncDecl ordFunc = ctx.mkFuncDecl("ord[" + expression.toString() + "]" + varCount++, ordSorts, ctx.mkIntSort());

        Expr[] ordExprs = new Expr[ordSorts.length];
        System.arraycopy(inExprs, 0, ordExprs, 0, inSize);
        for (int i = inSize; i < ordExprs.length; i++) {
            ordExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
        }

        Expr[] outExprs = new Expr[outSize];
        System.arraycopy(ordExprs, inSize, outExprs, 0, outSize);

        IntExpr intExpr = ctx.mkIntConst("i!" + varCount++);

        Sort[] invSorts = new Sort[inSize + 1];
        System.arraycopy(inSorts, 0, invSorts, 0, inSize);
        invSorts[invSorts.length - 1] = ctx.mkIntSort();

        Expr[] invExprs = new Expr[inSize + 1];
        System.arraycopy(inExprs, 0, invExprs, 0, inSize);
        invExprs[invExprs.length - 1] = intExpr;

        Expr[] temp;

        // crd = 0 ⇔ ∀f : FSO, ¬isFSO(f )
        // ****************************************** //
        BoolExpr boolExprEqZero = ctx.mkIff(ctx.mkEq(cardinalityFunc.apply(inExprs), ctx.mkInt(0)), expression.no().accept(this));

        if (inSize > 0) {
            boolExprEqZero = ctx.mkForall(inExprs, boolExprEqZero
                    , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
        }
        // ****************************************** //

        // ∀f : FSO | isFSO(f) ⇒ 1 ≤ ord(f ) ≤ crd
        // ****************************************** //

        temp = exprs;
        exprs = outExprs;

        BoolExpr boolExprOrd = ctx.mkForall(ordExprs
                , ctx.mkImplies(expression.accept(this)
                        , ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), (IntExpr) ordFunc.apply(ordExprs))
                                , ctx.mkLe((IntExpr) ordFunc.apply(ordExprs)
                                        , (IntExpr) cardinalityFunc.apply(inExprs))))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        exprs = temp;

        // ****************************************** //

        // ∀i : Nat | 1 ≤ i ≤ crd ⇒ isFSO(inv(i))
        // inv = ord^−1
        // ****************************************** //

        temp = exprs;
        exprs = outExprs;

        BoolExpr boolExprInv = ctx.mkForall(invExprs,
                ctx.mkImplies(ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), intExpr)
                        , ctx.mkLe(intExpr, (IntExpr) cardinalityFunc.apply(inExprs)))
                        , ctx.mkExists(outExprs, ctx.mkAnd(
                                ctx.mkEq(ordFunc.apply(ordExprs), intExpr)
                                , expression.accept(this))
                                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        exprs = temp;

        Expr[] oneToOneExprs = new Expr[inSize + outSize * 2];
        for (int i = 0; i < oneToOneExprs.length; i++) {
            oneToOneExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
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

        BoolExpr boolExprOneToOne = ctx.mkForall(oneToOneExprs
                , ctx.mkImplies(ctx.mkEq(ordFunc.apply(firstOne), ordFunc.apply(secondOne))
                        , ctx.mkAnd(eqs))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        // ****************************************** //

        FuncDecl noToResultFunc = ctx.mkFuncDecl("NO[" + expression.toString() + "]" + varCount++
                , invSorts, ctx.mkIntSort());

        Expr[] sumExprs = new Expr[ordExprs.length + 1];
        System.arraycopy(ordExprs, 0, sumExprs, 0, ordExprs.length);
        sumExprs[sumExprs.length - 1] = intExpr;

        BoolExpr boolExprNoToResult = ctx.mkForall(sumExprs, ctx.mkImplies(ctx.mkEq(ordFunc.apply(ordExprs), intExpr)
                , ctx.mkEq(noToResultFunc.apply(invExprs), univToInt == null ? ctx.mkInt(0) : univToInt.apply(outExprs)))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        Expr[] exprsPlusBVminus1 = new Expr[invExprs.length];
        System.arraycopy(inExprs, 0, exprsPlusBVminus1, 0, inSize);
        exprsPlusBVminus1[exprsPlusBVminus1.length - 1] = ctx.mkAdd(intExpr, ctx.mkInt(1));

        BoolExpr boolExprSum = ctx.mkForall(invExprs
                , ctx.mkEq(sumFunc.apply(invExprs)
                        , ctx.mkITE(ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), intExpr)
                                , ctx.mkLe(intExpr, (IntExpr) cardinalityFunc.apply(inExprs)))
                                , ctx.mkAdd((IntExpr) sumFunc.apply(exprsPlusBVminus1), (IntExpr) noToResultFunc.apply(invExprs))
                                , ctx.mkInt(0)))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        Expr[] sumWithCardExprs = new Expr[invSorts.length];
        System.arraycopy(inExprs, 0, sumWithCardExprs, 0, inExprs.length);
        sumWithCardExprs[sumWithCardExprs.length - 1] = ctx.mkInt(1);

        BoolExpr boolExprSumEq = ctx.mkEq(sum.apply(inExprs), sumFunc.apply(sumWithCardExprs));
        if (inSize > 0) {
            boolExprSumEq = ctx.mkForall(inExprs, boolExprSumEq
                    , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
        }

        goal.add(boolExprEqZero);
        goal.add(boolExprOrd);
        goal.add(boolExprInv);
        goal.add(boolExprOneToOne);
        goal.add(boolExprNoToResult);
        goal.add(boolExprSum);
        goal.add(boolExprSumEq);

        variableExprMap.putAll(tempMap);

        intExprFuncMap.put(expression.count().toString(), cardinalityFunc);

        return sum;
    }

    @Override
    public IntExpr visit(ExprToIntCast exprToIntCast) {
        switch (exprToIntCast.op()) {
            case CARDINALITY:
                Expression expression = exprToIntCast.expression();

                if (expression instanceof Variable)
                    return ctx.mkInt(1);

                FuncDecl func = intExprFuncMap.computeIfAbsent(exprToIntCast.toString(), e -> cardinality(expression));

                VariableDetector variableDetector = new VariableDetector();
                expression.accept(variableDetector);
                Expr[] usedExprs = variableDetector.variables().stream().sorted(Comparator.comparingInt(Object::hashCode))
                        .map(v -> variableExprMap.get(v)).filter(Objects::nonNull).toArray(Expr[]::new);

                return (IntExpr) func.apply(usedExprs);
            case SUM:
                expression = exprToIntCast.expression();

                if (univToInt == null)
                    return ctx.mkInt(0);

                if (expression instanceof Variable)
                    return (IntExpr) univToInt.apply(variableExprMap.get(expression));

                func = intExprFuncMap.computeIfAbsent(exprToIntCast.toString(), e -> sum(expression));

                variableDetector = new VariableDetector();
                expression.accept(variableDetector);
                usedExprs = variableDetector.variables().stream().sorted(Comparator.comparingInt(Object::hashCode))
                        .map(v -> variableExprMap.get(v)).filter(Objects::nonNull).toArray(Expr[]::new);

                return (IntExpr) func.apply(usedExprs);
            default:
                return ctx.mkInt(0);
        }
    }

    @Override
    public IntExpr visit(NaryIntExpression naryIntExpression) {
        Iterator<IntExpression> iterator = naryIntExpression.iterator();
        if (iterator.hasNext()) {
            IntExpr expr = iterator.next().accept(this);
            switch (naryIntExpression.op()) {
                case MULTIPLY:
                    while (iterator.hasNext()) {
                        expr = (IntExpr) ctx.mkMul(expr, iterator.next().accept(this));
                    }
                    return expr;
                case PLUS:
                    while (iterator.hasNext()) {
                        expr = (IntExpr) ctx.mkAdd(expr, iterator.next().accept(this));
                    }
                    return expr;
                case AND:
                    while (iterator.hasNext()) {
                        expr = ctx.mkBV2Int(ctx.mkBVAND(ctx.mkInt2BV(BIT_SIZE, expr), ctx.mkInt2BV(BIT_SIZE, iterator.next().accept(this))), true);
                    }
                    return expr;
                case OR:
                    while (iterator.hasNext()) {
                        expr = ctx.mkBV2Int(ctx.mkBVOR(ctx.mkInt2BV(BIT_SIZE, expr), ctx.mkInt2BV(BIT_SIZE, iterator.next().accept(this))), true);
                    }
                    return expr;
            }
        }
        return ctx.mkInt(0);
    }

    @Override
    public IntExpr visit(BinaryIntExpression binaryIntExpression) {
        IntExpr left = binaryIntExpression.left().accept(this);
        IntExpr right = binaryIntExpression.right().accept(this);
        switch (binaryIntExpression.op()) {
            case AND:
                return ctx.mkBV2Int(ctx.mkBVAND(ctx.mkInt2BV(BIT_SIZE, left), ctx.mkInt2BV(BIT_SIZE, right)), true);
            case OR:
                return ctx.mkBV2Int(ctx.mkBVOR(ctx.mkInt2BV(BIT_SIZE, left), ctx.mkInt2BV(BIT_SIZE, right)), true);
            case SHA:
                return ctx.mkBV2Int(ctx.mkBVASHR(ctx.mkInt2BV(BIT_SIZE, left), ctx.mkInt2BV(BIT_SIZE, right)), true);
            case SHL:
                return ctx.mkBV2Int(ctx.mkBVSHL(ctx.mkInt2BV(BIT_SIZE, left), ctx.mkInt2BV(BIT_SIZE, right)), true);
            case SHR:
                return ctx.mkBV2Int(ctx.mkBVLSHR(ctx.mkInt2BV(BIT_SIZE, left), ctx.mkInt2BV(BIT_SIZE, right)), true);
            case XOR:
                return ctx.mkBV2Int(ctx.mkBVXOR(ctx.mkInt2BV(BIT_SIZE, left), ctx.mkInt2BV(BIT_SIZE, right)), true);
            case PLUS:
                return (IntExpr) ctx.mkAdd(left, right);
            case MINUS:
                return (IntExpr) ctx.mkSub(left, right);
            case DIVIDE:
                return (IntExpr) ctx.mkDiv(left, right);
            case MODULO:
                return ctx.mkMod(left, right);
            case MULTIPLY:
                return (IntExpr) ctx.mkMul(left, right);
            default:
                return ctx.mkInt(0);
        }
    }

    @Override
    public IntExpr visit(UnaryIntExpression intExpr) {
        IntExpr expr = intExpr.intExpr().accept(this);
        switch (intExpr.op()) {
            case SGN:
                return (IntExpr) ctx.mkITE(ctx.mkEq(expr, ctx.mkInt(0))
                        , ctx.mkInt(0)
                        , ctx.mkITE(ctx.mkGt(expr, ctx.mkInt(0))
                                , ctx.mkInt(1)
                                , ctx.mkInt(-1)));
            case NOT:
                return ctx.mkBV2Int(ctx.mkBVNot(ctx.mkInt2BV(BIT_SIZE, expr)), true);
            case NEG:
                return (IntExpr) ctx.mkMul(expr, ctx.mkInt(-1));
            case ABS:
                return (IntExpr) ctx.mkITE(ctx.mkLe(expr, ctx.mkInt(0)), ctx.mkMul(expr, ctx.mkInt(-1)), expr);
            default:
                return ctx.mkInt(0);
        }
    }

    private FuncDecl sum(SumExpression sumExpression) {

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

        for (int i = 0; i < declExprs.length; i++) {
            declExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
            variableExprMap.put(declVariables.get(i), declExprs[i]);
        }

        for (int i = 0; i < outerExprs.length; i++) {
            outerExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
            variableExprMap.put(outerVariables.get(i), outerExprs[i]);
        }

        IntExpr generalSum = sumExpression.intExpr().accept(this);

        // **************************************** //

        int inSize = outerVariables.size();
        int outSize = declVariables.size();

        Sort[] inSorts = new Sort[inSize];
        Arrays.fill(inSorts, UNIV);

        FuncDecl sum = ctx.mkFuncDecl("SUM[" + sumExpression.toString() + "]" + varCount++
                , inSorts, ctx.mkIntSort());

        FuncDecl cardinalityFunc = ctx.mkFuncDecl("#[" + sumExpression.toString() + "]" + varCount++
                , inSorts, ctx.mkIntSort());

        Sort[] sumSorts = new Sort[inSize + 1];
        Arrays.fill(sumSorts, UNIV);
        sumSorts[sumSorts.length - 1] = ctx.mkIntSort();

        FuncDecl sumRecursive = ctx.mkFuncDecl("SUM_RECURSIVE[" + sumExpression.toString() + "]" + varCount++
                , sumSorts, ctx.mkIntSort());

        Sort[] ordSorts = new Sort[inSize + outSize];
        Arrays.fill(ordSorts, UNIV);

        FuncDecl ordFunc = ctx.mkFuncDecl("ord[" + sumExpression.toString() + "]" + varCount++, ordSorts, ctx.mkIntSort());

        Expr[] ordExprs = new Expr[ordSorts.length];
        System.arraycopy(outerExprs, 0, ordExprs, 0, inSize);
        System.arraycopy(declExprs, 0, ordExprs, inSize, outSize);

        IntExpr intExpr = ctx.mkIntConst("i!" + varCount++);

        Sort[] invSorts = new Sort[inSize + 1];
        System.arraycopy(inSorts, 0, invSorts, 0, inSize);
        invSorts[invSorts.length - 1] = ctx.mkIntSort();

        Expr[] invExprs = new Expr[inSize + 1];
        System.arraycopy(outerExprs, 0, invExprs, 0, inSize);
        invExprs[invExprs.length - 1] = intExpr;

        // crd = 0 ⇔ ∀f : FSO, ¬isFSO(f )
        // ****************************************** //
        BoolExpr boolExprEqZero = ctx.mkIff(ctx.mkEq(cardinalityFunc.apply(outerExprs), ctx.mkInt(0)), Expression.union(declExpressionSet).no().accept(this));

        if (inSize > 0) {
            boolExprEqZero = ctx.mkForall(outerExprs, boolExprEqZero
                    , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
        }
        // ****************************************** //

        // ∀f : FSO | isFSO(f) ⇒ 1 ≤ ord(f ) ≤ crd
        // ****************************************** //

        BoolExpr boolExprOrd = ctx.mkForall(ordExprs
                , ctx.mkImplies(Formula.and(declFormulaSet).accept(this)
                        , ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), (IntExpr) ordFunc.apply(ordExprs))
                                , ctx.mkLe((IntExpr) ordFunc.apply(ordExprs)
                                        , (IntExpr) cardinalityFunc.apply(outerExprs))))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        // ****************************************** //

        // ∀i : Nat | 1 ≤ i ≤ crd ⇒ isFSO(inv(i))
        // inv = ord^−1
        // ****************************************** //

        BoolExpr boolExprInv = ctx.mkForall(invExprs,
                ctx.mkImplies(ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), intExpr)
                        , ctx.mkLe(intExpr, (IntExpr) cardinalityFunc.apply(outerExprs)))
                        , ctx.mkExists(declExprs, ctx.mkAnd(
                                ctx.mkEq(ordFunc.apply(ordExprs), intExpr)
                                , Formula.and(declFormulaSet).accept(this))
                                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        Expr[] oneToOneExprs = new Expr[inSize + outSize * 2];
        for (int i = 0; i < oneToOneExprs.length; i++) {
            oneToOneExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
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

        BoolExpr boolExprOneToOne = ctx.mkForall(oneToOneExprs
                , ctx.mkImplies(ctx.mkEq(ordFunc.apply(firstOne), ordFunc.apply(secondOne))
                        , ctx.mkAnd(eqs))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        goal.add(boolExprEqZero);
        goal.add(boolExprOrd);
        goal.add(boolExprInv);
        goal.add(boolExprOneToOne);

        // ****************************************** //

        Expr[] allExprs = new Expr[ordExprs.length + 1];
        System.arraycopy(ordExprs, 0, allExprs, 0, ordExprs.length);
        allExprs[allExprs.length - 1] = intExpr;

        Expr[] sumRecursiveExprsPlus1 = new Expr[invExprs.length];
        System.arraycopy(outerExprs, 0, sumRecursiveExprsPlus1, 0, inSize);
        sumRecursiveExprsPlus1[sumRecursiveExprsPlus1.length - 1] = ctx.mkAdd(intExpr, ctx.mkInt(1));

        FuncDecl generalFunc = ctx.mkFuncDecl("PARTIAL_SUM[" + sumExpression.toString() + "]" + varCount++, invSorts, ctx.mkIntSort());

        BoolExpr boolExprGeneral = ctx.mkForall(allExprs
                        , ctx.mkImplies(ctx.mkEq(ordFunc.apply(ordExprs), intExpr)
                                        , ctx.mkEq(generalFunc.apply(invExprs), generalSum))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        goal.add(boolExprGeneral);

        BoolExpr boolExprSumRecursive = ctx.mkForall(invExprs, ctx.mkEq(sumRecursive.apply(invExprs)
                , ctx.mkITE(ctx.mkAnd(ctx.mkLe(ctx.mkInt(1), intExpr)
                                    , ctx.mkLe(intExpr, (IntExpr) cardinalityFunc.apply(outerExprs)))
                        , ctx.mkAdd((IntExpr) generalFunc.apply(invExprs), (IntExpr) sumRecursive.apply(sumRecursiveExprsPlus1))
                        , ctx.mkInt(0)))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        goal.add(boolExprSumRecursive);

        Expr[] outerExprsPlus1 = new Expr[outerExprs.length + 1];
        System.arraycopy(outerExprs, 0, outerExprsPlus1, 0, outerExprs.length);
        outerExprsPlus1[outerExprsPlus1.length - 1] = ctx.mkInt(1);

        BoolExpr boolExprSum = ctx.mkForall(outerExprs, ctx.mkEq(sum.apply(outerExprs), sumRecursive.apply(outerExprsPlus1))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        goal.add(boolExprSum);

        intExprFuncMap.put(sumExpression.toString(), sum);

        variableExprMap = tempMap;

        return sum;
    }

    @Override
    public IntExpr visit(SumExpression sumExpression) {
        VariableDetector variableDetector = new VariableDetector();
        sumExpression.accept(variableDetector);

        List<Variable> outerVariables = new ArrayList<>(variableDetector.variables());

        sumExpression.decls().forEach(decl -> {
            outerVariables.remove(decl.variable());
        });

        outerVariables.sort(Comparator.comparingInt(Object::hashCode));

        Expr[] inExpr = outerVariables.stream().map(v -> variableExprMap.get(v)).toArray(Expr[]::new);

        return (IntExpr) intExprFuncMap.computeIfAbsent(sumExpression.toString(), s -> sum(sumExpression)).apply(inExpr);
    }

    @Override
    public BoolExpr visit(IntComparisonFormula intComparisonFormula) {
        switch (intComparisonFormula.op()) {
            case EQ:
                return ctx.mkEq(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            case GT:
                return ctx.mkGt(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            case LT:
                return ctx.mkLt(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            case GTE:
                return ctx.mkGe(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            case LTE:
                return ctx.mkLe(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            default:
                return ctx.mkFalse();
        }
    }
}
