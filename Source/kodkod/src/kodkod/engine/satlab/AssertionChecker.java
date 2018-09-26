package kodkod.engine.satlab;

import com.microsoft.z3.Expr;
import kodkod.ast.*;
import kodkod.ast.operator.ExprOperator;
import kodkod.ast.operator.FormulaOperator;
import kodkod.instance.Bounds;
import kodkod.instance.Tuple;
import kodkod.instance.TupleSet;

import java.util.*;

public class AssertionChecker implements SATSolver {

    private Bounds bounds;
    private Set<Object> objects;
    private Map<Variable, Object> variableObjectMap;

    private Set<Formula> unsatFormulaSet;

    public Set<Map.Entry<Relation, Tuple>> getUnsatTupleSet() {
        return Collections.emptySet();
    }

    public Set<Formula> getUnsatFormulaSet() {
        return unsatFormulaSet;
    }

    public boolean solve(Formula formula, Bounds bounds) {
        this.bounds = bounds;
        variableObjectMap = new HashMap<>();
        this.objects = new HashSet<>();
        this.unsatFormulaSet = new HashSet<>();
        bounds.universe().forEach(o -> objects.add(o));

        return separateFormula(formula).stream().allMatch(f -> {
            boolean sat = visit(f, new Object[] {});
            if (!sat)
                unsatFormulaSet.add(f);
            return sat;
        });
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

    private Set<Object[]> getCombinations(int arity) {
        Set<Object[]> set = new HashSet<>();
        int size = bounds.universe().size();
        for (int i = 0; i < Math.pow(size, arity); i++) {
            Object[] objects = new Object[arity];
            for (int j = 0; j < arity; j++) {
                objects[j] = bounds.universe().atom((int) ((i / Math.pow(size, j)) % size));
            }
            set.add(objects);
        }
        return set;
    }

    private Set<Tuple> getBound(Relation relation) {
        Set<Tuple> bound = bounds.lowerBound(relation);
        return bound == null ? bounds.universe().factory().noneOf(relation.arity()) : bound;
    }

    private boolean visit(Node node, Object[] obj) {
        if (node instanceof Relation) {
            return getBound((Relation) node).contains(bounds.universe().factory().tuple(obj));
        }
        else if (node instanceof ConstantExpression) {
            if (node.equals(Relation.IDEN)) {
                return obj[0].equals(obj[1]);
            }
            else if (node.equals(Relation.UNIV)) {
                return obj.length == 1;
            }
            else if (node.equals(Relation.NONE)) {
                return obj.length == 0;
            }
        }
        else if (node instanceof Variable) {
            return variableObjectMap.get(node).equals(obj[0]);
        }
        else if (node instanceof UnaryExpression) {
            UnaryExpression unaryExpression = (UnaryExpression) node;
            switch (unaryExpression.op()) {
                case TRANSPOSE:
                    return visit(unaryExpression.expression(), new Object[] {obj[1], obj[0]});
                case REFLEXIVE_CLOSURE:
                    Expression ex = unaryExpression.expression();
                    while (ex instanceof BinaryExpression && ((BinaryExpression) ex).op().equals(ExprOperator.JOIN)) {
                        ex = ((BinaryExpression) ex).right();
                    }

                    int loopCount =  bounds.universe().size() - 1;

                    if (ex.equals(Relation.NONE)) {
                        loopCount = 0;
                    }
                    else if (ex instanceof Relation) {
                        loopCount = (int) (getBound((Relation) ex).stream()
                                .map(t -> t.atom(t.arity() - 1))
                                .distinct().count()) - 1;
                    }

                    Expression unionExpr = Relation.IDEN;
                    for (int i = 0; i < loopCount - 1; i++) {
                        unionExpr = Relation.IDEN.union(unaryExpression.expression().join(unionExpr));
                    }
                    return visit(unionExpr, obj);
                case CLOSURE:
                    ex = unaryExpression.expression();
                    while (ex instanceof BinaryExpression && ((BinaryExpression) ex).op().equals(ExprOperator.JOIN)) {
                        ex = ((BinaryExpression) ex).right();
                    }

                    loopCount =  bounds.universe().size() - 1;

                    if (ex.equals(Relation.NONE)) {
                        loopCount = 0;
                    }
                    else if (ex instanceof Relation) {
                        loopCount = (int) (getBound((Relation) ex).stream()
                                .map(t -> t.atom(t.arity() - 1))
                                .distinct().count()) - 1;
                    }
                    unionExpr = Relation.IDEN;
                    for (int i = 0; i < loopCount - 1; i++) {
                        unionExpr = Relation.IDEN.union(unaryExpression.expression().join(unionExpr));
                    }

                    if (unionExpr instanceof BinaryExpression && ((BinaryExpression) unionExpr).op().equals(ExprOperator.UNION))
                        return visit(((BinaryExpression) unionExpr).right(), obj);
                    else {
                        return false;
                    }
            }
        }
        else if (node instanceof BinaryExpression) {
            BinaryExpression binaryExpression = (BinaryExpression) node;
            switch (binaryExpression.op()) {
                case JOIN:
                    Expression leftExpression = binaryExpression.left();
                    Expression rightExpression = binaryExpression.right();

                    Object[] leftExprs = new Object[leftExpression.arity()];
                    System.arraycopy(obj, 0, leftExprs, 0, leftExprs.length - 1);

                    Object[] rightExprs = new Object[rightExpression.arity()];
                    System.arraycopy(obj, obj.length - rightExprs.length + 1, rightExprs, 1, rightExprs.length - 1);

                    return objects.stream().anyMatch(o -> {
                        leftExprs[leftExprs.length - 1] = o;
                        rightExprs[0] = o;
                        return visit(leftExpression, leftExprs) && visit(rightExpression, rightExprs);
                    });
                case UNION:
                    return visit(binaryExpression.left(), obj) || visit(binaryExpression.right(), obj);
                case INTERSECTION:
                    return visit(binaryExpression.left(), obj) && visit(binaryExpression.right(), obj);
                case PRODUCT:
                    leftExpression = binaryExpression.left();
                    rightExpression = binaryExpression.right();

                    leftExprs = new Expr[leftExpression.arity()];
                    System.arraycopy(obj, 0, leftExprs, 0, leftExprs.length);

                    rightExprs = new Expr[rightExpression.arity()];
                    System.arraycopy(obj, leftExpression.arity(), rightExprs, 0, rightExprs.length);

                    return visit(leftExpression, leftExprs) && visit(rightExpression, rightExprs);
                case DIFFERENCE:
                    return visit(binaryExpression.left(), obj) && !visit(binaryExpression.right(), obj);
                case OVERRIDE:
                    // TODO: Implement this.
                    break;
            }
        }
        else if (node instanceof NaryExpression) {
            NaryExpression naryExpression = (NaryExpression) node;

            switch (naryExpression.op()) {
                case UNION:
                    for (int i = 0; i < naryExpression.size(); i++) {
                        if  (visit(naryExpression.child(i), obj))
                            return true;
                    }
                    return false;
                case PRODUCT:
                    for (int i = 0; i < naryExpression.size(); i++) {
                        int start = 0;

                        for (int j = 0; j < i; j++)
                            start += naryExpression.child(i - 1).arity();

                        Expression expression = naryExpression.child(i);
                        Object[] exprs1 = new Object[expression.arity()];

                        System.arraycopy(obj, start, exprs1, 0, exprs1.length);

                        if (!visit(expression, exprs1))
                            return false;
                    }
                    return true;
                case INTERSECTION:
                    for (int i = 0; i < naryExpression.size(); i++) {
                        if (!visit(naryExpression.child(i), obj))
                            return false;
                    }
                    return true;
                case OVERRIDE:
                    // TODO: Implement this.
                    break;
            }
        }
        else if (node instanceof NotFormula) {
            NotFormula notFormula = (NotFormula) node;
            return !visit(notFormula.formula(), obj);
        }
        else if (node instanceof ComparisonFormula) {
            ComparisonFormula comparisonFormula = (ComparisonFormula) node;
            switch (comparisonFormula.op()) {
                case EQUALS:
                    return getCombinations(comparisonFormula.left().arity()).stream()
                            .allMatch(o -> visit(comparisonFormula.left(), o) == visit(comparisonFormula.right(), o));
                case SUBSET:
                    return getCombinations(comparisonFormula.left().arity()).stream()
                            .allMatch(o -> !visit(comparisonFormula.left(), o) || visit(comparisonFormula.right(), o));
            }
        }
        else if (node instanceof BinaryFormula) {
            BinaryFormula binaryFormula = (BinaryFormula) node;
            switch (binaryFormula.op()) {
                case IMPLIES:
                    return !visit(binaryFormula.left(), obj) || visit(binaryFormula.right(), obj);
                case IFF:
                    return visit(binaryFormula.left(), obj) == visit(binaryFormula.right(), obj);
                case OR:
                    return visit(binaryFormula.left(), obj) || visit(binaryFormula.right(), obj);
                case AND:
                    return visit(binaryFormula.left(), obj) && visit(binaryFormula.right(), obj);
            }
        }
        else if (node instanceof NaryFormula) {
            NaryFormula naryFormula = (NaryFormula) node;
            switch (naryFormula.op()) {
                case AND:
                    for (int i = 0; i < naryFormula.size(); i++) {
                        if (!visit(naryFormula.child(i), obj))
                            return false;
                    }
                    return true;
                case OR:
                    for (int i = 0; i < naryFormula.size(); i++) {
                        if (visit(naryFormula.child(i), obj))
                            return true;
                    }
                    return false;
            }
        }
        else if (node instanceof MultiplicityFormula) {
            MultiplicityFormula multiplicityFormula = (MultiplicityFormula) node;
            switch (multiplicityFormula.multiplicity()) {
                case SOME:
                    return getCombinations(multiplicityFormula.expression().arity()).stream()
                            .anyMatch(o -> visit(multiplicityFormula.expression(), o));
                case NO:
                    return getCombinations(multiplicityFormula.expression().arity()).stream()
                            .noneMatch(o -> visit(multiplicityFormula.expression(), o));
                case ONE:
                    int count = 0;
                    for (Object[] o : getCombinations(multiplicityFormula.expression().arity())) {
                        if (visit(multiplicityFormula.expression(), o))
                            count++;
                        if (count > 1)
                            return false;
                    }
                    return count == 1;
                case LONE:
                    count = 0;
                    for (Object[] o : getCombinations(multiplicityFormula.expression().arity())) {
                        if (visit(multiplicityFormula.expression(), o))
                            count++;
                        if (count > 1)
                            return false;
                    }
                    return true;
            }
        }
        else if (node instanceof QuantifiedFormula) {
            QuantifiedFormula quantifiedFormula = (QuantifiedFormula) node;
            int exprsSize = quantifiedFormula.decls().size();

            switch (quantifiedFormula.quantifier()) {
                case ALL:
                    return getCombinations(exprsSize).stream().allMatch(o -> {
                        for (int i = 0; i < o.length; i++) {
                            Decl decl = quantifiedFormula.decls().get(i);
                            variableObjectMap.put(decl.variable(), o[i]);
                            if (!visit(decl.variable().in(decl.expression()), obj))
                                return true;
                        }
                        return visit(quantifiedFormula.formula(), obj);
                    });
                case SOME:
                    return getCombinations(exprsSize).stream().anyMatch(o -> {
                        for (int i = 0; i < o.length; i++) {
                            Decl decl = quantifiedFormula.decls().get(i);
                            variableObjectMap.put(decl.variable(), o[i]);
                            if (!visit(decl.variable().in(decl.expression()), obj))
                                return true;
                        }
                        return visit(quantifiedFormula.formula(), obj);
                    });
            }
        }
        if (node instanceof ConstantFormula) {
            ConstantFormula constantFormula = (ConstantFormula) node;
            return constantFormula.booleanValue();
        }
        else if (node instanceof IntComparisonFormula) {
            IntComparisonFormula intComparisonFormula = (IntComparisonFormula) node;
            switch (intComparisonFormula.op()) {
                case EQ:
                    return visitIntExpression(intComparisonFormula.left(), obj) ==
                            visitIntExpression(intComparisonFormula.right(), obj);
                case GT:
                    return visitIntExpression(intComparisonFormula.left(), obj) >
                            visitIntExpression(intComparisonFormula.right(), obj);
                case LT:
                    return visitIntExpression(intComparisonFormula.left(), obj) <
                            visitIntExpression(intComparisonFormula.right(), obj);
                case GTE:
                    return visitIntExpression(intComparisonFormula.left(), obj) >=
                            visitIntExpression(intComparisonFormula.right(), obj);
                case LTE:
                    return visitIntExpression(intComparisonFormula.left(), obj) <=
                            visitIntExpression(intComparisonFormula.right(), obj);
            }
        }
        else if (node instanceof IfExpression) {
            IfExpression ifExpression = (IfExpression) node;
            return visit(ifExpression.condition(), obj)
                    ? visit(ifExpression.thenExpr(), obj)
                    : visit(ifExpression.elseExpr(), obj);
        }
        else if (node instanceof RelationPredicate) {
            RelationPredicate relationPredicate = (RelationPredicate) node;
            return visit(relationPredicate.toConstraints(), obj);
        }

        return true;
    }

    private int visitIntExpression(Node node, Object[] obj) {
        if (node instanceof kodkod.ast.IntConstant) {
            IntConstant intConstant = (IntConstant) node;
            return intConstant.value();
        }
        else if (node instanceof ExprToIntCast) {
            ExprToIntCast exprToIntCast = (ExprToIntCast) node;
            switch (exprToIntCast.op()) {
                case CARDINALITY:
                    int card = 0;
                    // TODO: Formula of cardinality
                    return card;
                case SUM:
                    int sum = 0;
                    // TODO: Formula of sum
                    return sum;
            }
        }
        else if (node instanceof kodkod.ast.SumExpression) {
            SumExpression sumExpression = (SumExpression) node;
            int sum = 0;
            // TODO: Formula of sum
            return sum;
        }
        else if (node instanceof IfIntExpression) {
            IfIntExpression ifExpression = (IfIntExpression) node;
            return visit(ifExpression.condition(), obj)
                    ? visitIntExpression(ifExpression.thenExpr(), obj)
                    : visitIntExpression(ifExpression.elseExpr(), obj);
        }
        else if (node instanceof UnaryIntExpression) {
            UnaryIntExpression unaryIntExpression = (UnaryIntExpression) node;
            int expr = visitIntExpression(unaryIntExpression.intExpr(), obj);
            switch (unaryIntExpression.op()) {
                case SGN:
                    return expr == 0 ? 0 : (expr > 0 ? 1 : -1);
                case NOT:
                    return ~expr;
                case NEG:
                    return -expr;
                case ABS:
                    return Math.abs(expr);
            }
        }
        else if (node instanceof BinaryIntExpression) {
            BinaryIntExpression binaryIntExpression = (BinaryIntExpression) node;
            int left = visitIntExpression(binaryIntExpression.left(), obj);
            int right = visitIntExpression(binaryIntExpression.right(), obj);
            switch (binaryIntExpression.op()) {
                case AND:
                    return left & right;
                case OR:
                    return left | right;
                case SHA:
                    return left >> right;
                case SHL:
                    return left << right;
                case SHR:
                    return left >>> right;
                case XOR:
                    return left ^ right;
                case PLUS:
                    return left + right;
                case MINUS:
                    return left - right;
                case DIVIDE:
                    return left / right;
                case MODULO:
                    return left % right;
                case MULTIPLY:
                    return left * right;
            }
        }
        else if (node instanceof kodkod.ast.NaryIntExpression) {
            NaryIntExpression naryIntExpression = (NaryIntExpression) node;
            Iterator<IntExpression> iterator = naryIntExpression.iterator();
            if (iterator.hasNext()) {
                int expr = visitIntExpression(iterator.next(), obj);
                switch (naryIntExpression.op()) {
                    case MULTIPLY:
                        while (iterator.hasNext()) {
                            expr *= visitIntExpression(iterator.next(), obj);
                        }
                        return expr;
                    case PLUS:
                        while (iterator.hasNext()) {
                            expr += visitIntExpression(iterator.next(), obj);
                        }
                        return expr;
                    case AND:
                        while (iterator.hasNext()) {
                            expr &= visitIntExpression(iterator.next(), obj);
                        }
                        return expr;
                    case OR:
                        while (iterator.hasNext()) {
                            expr |= visitIntExpression(iterator.next(), obj);
                        }
                        return expr;
                }
            }
        }
        return 0;
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
