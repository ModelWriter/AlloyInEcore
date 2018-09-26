package kodkod.util.z3;

import com.microsoft.z3.*;
import com.microsoft.z3.enumerations.Z3_sort_kind;
import kodkod.ast.*;
import kodkod.ast.operator.ExprOperator;
import kodkod.ast.operator.IntCompOperator;
import kodkod.ast.operator.Multiplicity;
import kodkod.ast.visitor.ReturnVisitor;
import kodkod.engine.fol2sat.HigherOrderDeclException;
import kodkod.instance.Bounds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by harun on 7/16/18.
 */
public class Z3FormulaConverterWithBV extends Z3FormulaConverter<BitVecExpr> {

    public Z3FormulaConverterWithBV(Context ctx, Sort UNIV, Map<Expression, FuncDecl> funcDeclMap
            , Map<Object, Expr> objectExprMap, int BIT_SIZE) {
        super(ctx, UNIV, funcDeclMap, objectExprMap, BIT_SIZE);

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
    public BitVecExpr visit(IntConstant intConst) {
        return ctx.mkBV(intConst.value(), BIT_SIZE);
    }

    @Override
    public BitVecExpr visit(IfIntExpression intExpr) {
        return (BitVecExpr) ctx.mkITE(intExpr.condition().accept(this)
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
                , inSorts, ctx.mkBitVecSort(BIT_SIZE));

        Sort[] ordSorts = new Sort[inSize + outSize];
        Arrays.fill(ordSorts, UNIV);

        FuncDecl ordFunc = ctx.mkFuncDecl("ord[" + expression.toString() + "]" + varCount++, ordSorts, ctx.mkBitVecSort(BIT_SIZE));

        Expr[] ordExprs = new Expr[ordSorts.length];
        System.arraycopy(inExprs, 0, ordExprs, 0, inSize);
        for (int i = inSize; i < ordExprs.length; i++) {
            ordExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
        }

        Expr[] outExprs = new Expr[outSize];
        System.arraycopy(ordExprs, inSize, outExprs, 0, outSize);

        BitVecExpr bitVecExpr = ctx.mkBVConst("i!" + varCount++, BIT_SIZE);

        Expr[] invExprs = new Expr[inSize + 1];
        System.arraycopy(inExprs, 0, invExprs, 0, inSize);
        invExprs[invExprs.length - 1] = bitVecExpr;

        Expr[] temp;

        // crd = 0 ⇔ ∀f : FSO, ¬isFSO(f )
        // ****************************************** //
        BoolExpr boolExprEqZero = ctx.mkIff(ctx.mkEq(cardinalityFunc.apply(inExprs), ctx.mkBV(0, BIT_SIZE)), expression.no().accept(this));

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
                        , ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), (BitVecExpr) ordFunc.apply(ordExprs))
                                , ctx.mkBVSLE((BitVecExpr) ordFunc.apply(ordExprs)
                                        , (BitVecExpr) cardinalityFunc.apply(inExprs))))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        exprs = temp;

        // ****************************************** //

        // ∀i : Nat | 1 ≤ i ≤ crd ⇒ isFSO(inv(i))
        // inv = ord^−1
        // ****************************************** //

        temp = exprs;
        exprs = outExprs;

        BoolExpr boolExprInv = ctx.mkForall(invExprs,
                ctx.mkImplies(ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), bitVecExpr)
                        , ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(inExprs)))
                        , ctx.mkExists(outExprs, ctx.mkAnd(
                                /*ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
                                , */expression.accept(this))
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

        Expr[] ordExprs = new Expr[ordSorts.length];
        System.arraycopy(inExprs, 0, ordExprs, 0, inSize);
        for (int i = inSize; i < ordExprs.length; i++) {
            ordExprs[i] = ctx.mkConst("x!" + varCount++, UNIV);
        }

        Expr[] outExprs = new Expr[outSize];
        System.arraycopy(ordExprs, inSize, outExprs, 0, outSize);

        BitVecExpr bitVecExpr = ctx.mkBVConst("i!" + varCount++, BIT_SIZE);

        Sort[] invSorts = new Sort[inSize + 1];
        System.arraycopy(inSorts, 0, invSorts, 0, inSize);
        invSorts[invSorts.length - 1] = ctx.mkBitVecSort(BIT_SIZE);

        Expr[] invExprs = new Expr[inSize + 1];
        System.arraycopy(inExprs, 0, invExprs, 0, inSize);
        invExprs[invExprs.length - 1] = bitVecExpr;

        Expr[] temp;

        // crd = 0 ⇔ ∀f : FSO, ¬isFSO(f )
        // ****************************************** //
        BoolExpr boolExprEqZero = ctx.mkIff(ctx.mkEq(cardinalityFunc.apply(inExprs), ctx.mkBV(0, BIT_SIZE)), expression.no().accept(this));

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
                        , ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), (BitVecExpr) ordFunc.apply(ordExprs))
                                , ctx.mkBVSLE((BitVecExpr) ordFunc.apply(ordExprs)
                                        , (BitVecExpr) cardinalityFunc.apply(inExprs))))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        exprs = temp;

        // ****************************************** //

        // ∀i : Nat | 1 ≤ i ≤ crd ⇒ isFSO(inv(i))
        // inv = ord^−1
        // ****************************************** //

        temp = exprs;
        exprs = outExprs;

        BoolExpr boolExprInv = ctx.mkForall(invExprs,
                ctx.mkImplies(ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), bitVecExpr)
                        , ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(inExprs)))
                        , ctx.mkExists(outExprs, ctx.mkAnd(
                                ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
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
                , invSorts, ctx.mkBitVecSort(BIT_SIZE));

        Expr[] sumExprs = new Expr[ordExprs.length + 1];
        System.arraycopy(ordExprs, 0, sumExprs, 0, ordExprs.length);
        sumExprs[sumExprs.length - 1] = bitVecExpr;

        BoolExpr boolExprNoToResult = ctx.mkForall(sumExprs, ctx.mkImplies(ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
                , ctx.mkEq(noToResultFunc.apply(invExprs), univToInt == null ? ctx.mkBV(0, BIT_SIZE) : univToInt.apply(outExprs)))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        Expr[] exprsPlusBVminus1 = new Expr[invExprs.length];
        System.arraycopy(inExprs, 0, exprsPlusBVminus1, 0, inSize);
        exprsPlusBVminus1[exprsPlusBVminus1.length - 1] = ctx.mkBVAdd(bitVecExpr, ctx.mkBV(1, BIT_SIZE));

        BoolExpr boolExprSum = ctx.mkForall(invExprs
                , ctx.mkEq(sumFunc.apply(invExprs)
                        , ctx.mkITE(ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), bitVecExpr)
                                , ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(inExprs)))
                                , ctx.mkBVAdd((BitVecExpr) sumFunc.apply(exprsPlusBVminus1), (BitVecExpr) noToResultFunc.apply(invExprs))
                                , ctx.mkBV(0, BIT_SIZE)))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        Expr[] sumWithCardExprs = new Expr[invSorts.length];
        System.arraycopy(inExprs, 0, sumWithCardExprs, 0, inExprs.length);
        sumWithCardExprs[sumWithCardExprs.length - 1] = ctx.mkBV(1, BIT_SIZE);

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
    public BitVecExpr visit(ExprToIntCast exprToIntCast) {
        switch (exprToIntCast.op()) {
            case CARDINALITY:
                Expression expression = exprToIntCast.expression();

                if (expression instanceof Variable)
                    return ctx.mkBV(1, BIT_SIZE);

                FuncDecl func = intExprFuncMap.computeIfAbsent(exprToIntCast.toString(), e -> cardinality(expression));

                VariableDetector variableDetector = new VariableDetector();
                expression.accept(variableDetector);
                Expr[] usedExprs = variableDetector.variables().stream().sorted(Comparator.comparingInt(Object::hashCode))
                        .map(v -> variableExprMap.get(v)).filter(Objects::nonNull).toArray(Expr[]::new);

                return (BitVecExpr) func.apply(usedExprs);
            case SUM:
                expression = exprToIntCast.expression();

                if (expression instanceof Variable && univToInt != null)
                    return (BitVecExpr) univToInt.apply(variableExprMap.get(expression));

                func = intExprFuncMap.computeIfAbsent(exprToIntCast.toString(), e -> sum(expression));

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
                        expr = ctx.mkBVMul(expr, iterator.next().accept(this));
                    }
                    return expr;
                case PLUS:
                    while (iterator.hasNext()) {
                        expr = ctx.mkBVAdd(expr, iterator.next().accept(this));
                    }
                    return expr;
                case AND:
                    while (iterator.hasNext()) {
                        expr = ctx.mkBVAND(expr, iterator.next().accept(this));
                    }
                    return expr;
                case OR:
                    while (iterator.hasNext()) {
                        expr = ctx.mkBVOR(expr, iterator.next().accept(this));
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

        BitVecExpr generalSum = sumExpression.intExpr().accept(this);

        // **************************************** //

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

        Expr[] ordExprs = new Expr[ordSorts.length];
        System.arraycopy(outerExprs, 0, ordExprs, 0, inSize);
        System.arraycopy(declExprs, 0, ordExprs, inSize, outSize);

        BitVecExpr bitVecExpr = ctx.mkBVConst("i!" + varCount++, BIT_SIZE);

        Sort[] invSorts = new Sort[inSize + 1];
        System.arraycopy(inSorts, 0, invSorts, 0, inSize);
        invSorts[invSorts.length - 1] = ctx.mkBitVecSort(BIT_SIZE);

        Expr[] invExprs = new Expr[inSize + 1];
        System.arraycopy(outerExprs, 0, invExprs, 0, inSize);
        invExprs[invExprs.length - 1] = bitVecExpr;

        // crd = 0 ⇔ ∀f : FSO, ¬isFSO(f )
        // ****************************************** //
        BoolExpr boolExprEqZero = ctx.mkIff(ctx.mkEq(cardinalityFunc.apply(outerExprs), ctx.mkBV(0, BIT_SIZE)), Expression.union(declExpressionSet).no().accept(this));

        if (inSize > 0) {
            boolExprEqZero = ctx.mkForall(outerExprs, boolExprEqZero
                    , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);
        }
        // ****************************************** //

        // ∀f : FSO | isFSO(f) ⇒ 1 ≤ ord(f ) ≤ crd
        // ****************************************** //

        BoolExpr boolExprOrd = ctx.mkForall(ordExprs
                , ctx.mkImplies(Formula.and(declFormulaSet).accept(this)
                        , ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), (BitVecExpr) ordFunc.apply(ordExprs))
                                , ctx.mkBVSLE((BitVecExpr) ordFunc.apply(ordExprs)
                                        , (BitVecExpr) cardinalityFunc.apply(outerExprs))))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        // ****************************************** //

        // ∀i : Nat | 1 ≤ i ≤ crd ⇒ isFSO(inv(i))
        // inv = ord^−1
        // ****************************************** //

        BoolExpr boolExprInv = ctx.mkForall(invExprs,
                ctx.mkImplies(ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), bitVecExpr)
                        , ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(outerExprs)))
                        , ctx.mkExists(declExprs, ctx.mkAnd(
                                ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
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
        allExprs[allExprs.length - 1] = bitVecExpr;

        Expr[] sumRecursiveExprsPlus1 = new Expr[invExprs.length];
        System.arraycopy(outerExprs, 0, sumRecursiveExprsPlus1, 0, inSize);
        sumRecursiveExprsPlus1[sumRecursiveExprsPlus1.length - 1] = ctx.mkBVAdd(bitVecExpr, ctx.mkBV(1, BIT_SIZE));

        FuncDecl generalFunc = ctx.mkFuncDecl("PARTIAL_SUM[" + sumExpression.toString() + "]" + varCount++, invSorts, ctx.mkBitVecSort(BIT_SIZE));

        BoolExpr boolExprGeneral = ctx.mkForall(allExprs
                        , ctx.mkImplies(ctx.mkEq(ordFunc.apply(ordExprs), bitVecExpr)
                                        , ctx.mkEq(generalFunc.apply(invExprs), generalSum))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        goal.add(boolExprGeneral);

        BoolExpr boolExprSumRecursive = ctx.mkForall(invExprs, ctx.mkEq(sumRecursive.apply(invExprs)
                , ctx.mkITE(ctx.mkAnd(ctx.mkBVSLE(ctx.mkBV(1, BIT_SIZE), bitVecExpr)
                                    , ctx.mkBVSLE(bitVecExpr, (BitVecExpr) cardinalityFunc.apply(outerExprs)))
                        , ctx.mkBVAdd((BitVecExpr) generalFunc.apply(invExprs), (BitVecExpr) sumRecursive.apply(sumRecursiveExprsPlus1))
                        , ctx.mkBV(0, BIT_SIZE)))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        goal.add(boolExprSumRecursive);

        Expr[] outerExprsPlus1 = new Expr[outerExprs.length + 1];
        System.arraycopy(outerExprs, 0, outerExprsPlus1, 0, outerExprs.length);
        outerExprsPlus1[outerExprsPlus1.length - 1] = ctx.mkBV(1, BIT_SIZE);

        BoolExpr boolExprSum = ctx.mkForall(outerExprs, ctx.mkEq(sum.apply(outerExprs), sumRecursive.apply(outerExprsPlus1))
                , 0, null, null, ctx.mkSymbol(quantifierPrefix + quantifierID++), null);

        goal.add(boolExprSum);

        intExprFuncMap.put(sumExpression.toString(), sum);

        variableExprMap = tempMap;

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
        switch (intComparisonFormula.op()) {
            case EQ:
                return ctx.mkEq(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            case GT:
                return ctx.mkBVSGT(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            case LT:
                return ctx.mkBVSLT(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            case GTE:
                return ctx.mkBVSGE(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            case LTE:
                return ctx.mkBVSLE(intComparisonFormula.left().accept(this)
                        , intComparisonFormula.right().accept(this));
            default:
                return ctx.mkFalse();
        }
    }
}
