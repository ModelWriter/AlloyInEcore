package kodkod.util.z3;

import kodkod.ast.*;
import kodkod.ast.visitor.AbstractCollector;
import kodkod.instance.Bounds;
import kodkod.instance.Tuple;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by harun on 7/13/18.
 */
public class UpperBoundFinder extends AbstractCollector<Tuple> {

    private Map<Variable, Set<Tuple>> variableTuples;

    private Bounds bounds;
    private TupleFactory factory;

    public UpperBoundFinder(Bounds bounds) {
        super(new HashSet<>());

        this.variableTuples = new HashMap<>();
        this.bounds = bounds;
        this.factory = bounds.universe().factory();
    }

    public void renew() {
        variableTuples.clear();
    }

    public boolean isReady(Decl decl) {
        VariableDetector variableDetector = new VariableDetector();

        decl.expression().accept(variableDetector);

        return variableDetector.variables().stream().allMatch(v -> variableTuples.containsKey(v));
    }

    @Override
    protected Set<Tuple> newSet() {
        return new HashSet<>();
    }

    @Override
    public Set<Tuple> visit(QuantifiedFormula quantFormula) {
        return quantFormula.decls().accept(this);
    }

    @Override
    public Set<Tuple> visit(Decls decls) {
        Set<Decl> declSet = new HashSet<>();
        decls.forEach(declSet::add);

        Set<Decl> visited = new HashSet<>();

        while (declSet.size() != visited.size()) {
            int visitedSize = visited.size();
            declSet.forEach(decl -> {
                if (!visited.contains(decl) && isReady(decl)) {
                    decl.accept(this);
                    visited.add(decl);
                }
            });
            if (visitedSize == visited.size())
                break;
        }

        declSet.forEach(decl -> {
            variableTuples.computeIfAbsent(decl.variable(), v -> factory.allOf(1));
        });

        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(Decl decl) {
        Set<Tuple> set = decl.expression().accept(this);
        variableTuples.put(decl.variable(), set);
        return set;
    }

    @Override
    public Set<Tuple> visit(Relation relation) {
        return bounds.upperBound(relation);
    }

    @Override
    public Set<Tuple> visit(Variable variable) {
        return variableTuples.getOrDefault(variable, factory.allOf(1));
    }

    @Override
    public Set<Tuple> visit(ConstantExpression constExpr) {
        if (constExpr == ConstantExpression.UNIV)
            return factory.allOf(1);
        if (constExpr == ConstantExpression.IDEN)
            return factory.setOf(bounds.universe().factory().allOf(1).stream()
                    .map(t -> t.product(t)).collect(Collectors.toSet()));
        if (constExpr == ConstantExpression.INTS)
            return bounds.intBounds().isEmpty() ? factory.noneOf(1)
                    : factory.setOf(bounds.intBounds().values().stream()
                    .flatMap(Collection::stream).collect(Collectors.toSet()));

        return bounds.universe().factory().noneOf(constExpr.arity());
    }

    @Override
    public Set<Tuple> visit(UnaryExpression unaryExpr) {
        switch (unaryExpr.op()) {
            case CLOSURE:
                TupleSet original = (TupleSet) unaryExpr.expression().accept(this);
                Set<Tuple> allTuples = new HashSet<>(original);
                Set<Tuple> realTuples = new HashSet<>();
                Set<Tuple> newOnes = new HashSet<>();
                Set<Tuple> prevs = new HashSet<>(original);
                do {
                    newOnes.clear();

                    allTuples.forEach(tuple1 -> {
                        prevs.forEach(tuple2 -> {
                            if (tuple1.atom(1).equals(tuple2.atom(0))) {
                                newOnes.add(factory.tuple(tuple1.atom(0), tuple2.atom(1)));
                            }
                        });
                    });

                    prevs.clear();
                    prevs.addAll(newOnes);
                    allTuples.addAll(newOnes);
                    realTuples.addAll(newOnes);
                } while (!allTuples.containsAll(newOnes));

                return realTuples.isEmpty() ? factory.noneOf(unaryExpr.arity()) : factory.setOf(realTuples);
            case REFLEXIVE_CLOSURE:
                original = (TupleSet) unaryExpr.expression().accept(this);
                allTuples = new HashSet<>(original);
                newOnes = new HashSet<>();
                prevs = new HashSet<>(original);
                do {
                    newOnes.clear();

                    allTuples.forEach(tuple1 -> {
                        prevs.forEach(tuple2 -> {
                            if (tuple1.atom(1).equals(tuple2.atom(0))) {
                                newOnes.add(factory.tuple(tuple1.atom(0), tuple2.atom(1)));
                            }
                        });
                    });

                    prevs.clear();
                    prevs.addAll(newOnes);
                    allTuples.addAll(newOnes);
                } while (!allTuples.containsAll(newOnes));

                return allTuples.isEmpty() ? factory.noneOf(unaryExpr.arity()) : factory.setOf(allTuples);
            case TRANSPOSE:
                TupleSet tupleSet = (TupleSet) unaryExpr.expression().accept(this);
                return tupleSet.project(1).product(tupleSet.project(0));
        }

        return factory.noneOf(unaryExpr.arity());
    }

    @Override
    public Set<Tuple> visit(BinaryExpression binExpr) {
        switch (binExpr.op()) {
            case UNION:
                Set<Tuple> left = new HashSet<>(binExpr.left().accept(this));
                Set<Tuple> right = binExpr.right().accept(this);
                left.addAll(right);
                return left.isEmpty() ? factory.noneOf(binExpr.arity()) : factory.setOf(left);
            case DIFFERENCE:
                left = new HashSet<>(binExpr.left().accept(this));

                VariableDetector variableDetector = new VariableDetector();
                binExpr.right().accept(variableDetector);

                if (!variableDetector.variables().isEmpty())
                    return left;

                right = binExpr.right().accept(this);
                left.removeAll(right);
                return left.isEmpty() ? factory.noneOf(binExpr.arity()) : factory.setOf(left);
            case JOIN:
                left = new HashSet<>(binExpr.left().accept(this));
                right = binExpr.right().accept(this);

                Set<Tuple> result = new HashSet<>();

                left.forEach(tuple1 -> {
                    right.forEach(tuple2 -> {
                        if (tuple1.atom(tuple1.arity() - 1).equals(tuple2.atom(0))) {
                            Object[] atoms = new Object[binExpr.arity()];
                            for (int i = 0; i < tuple1.arity() - 1; i++) {
                                atoms[i] = tuple1.atom(i);
                            }
                            for (int i = 0; i < tuple2.arity() - 1; i++) {
                                atoms[i + tuple1.arity() - 1] = tuple2.atom(i + 1);
                            }
                            result.add(factory.tuple(atoms));
                        }
                    });
                });

                return result.isEmpty() ? factory.noneOf(binExpr.arity()) : factory.setOf(result);
            case INTERSECTION:
                left = new HashSet<>(binExpr.left().accept(this));
                right = binExpr.right().accept(this);
                left.removeIf(t -> !right.contains(t));
                return left.isEmpty() ? factory.noneOf(binExpr.arity()) : factory.setOf(left);
            case PRODUCT:
                left = binExpr.left().accept(this);
                right = binExpr.right().accept(this);
                return ((TupleSet) left).product((TupleSet) right);
            case OVERRIDE:
                // TODO: Check this.
                left = new HashSet<>(binExpr.left().accept(this));
                right = binExpr.right().accept(this);
                left.addAll(right);
                return left.isEmpty() ? factory.noneOf(binExpr.arity()) : factory.setOf(left);
        }

        return factory.noneOf(binExpr.arity());
    }

    @Override
    public Set<Tuple> visit(NaryExpression expr) {
        switch (expr.op()) {
            case UNION:
                Set<Tuple> tuples = new HashSet<>();
                expr.iterator().forEachRemaining(expression -> tuples.addAll(expression.accept(this)));
                return tuples.isEmpty() ? factory.noneOf(expr.arity()) : factory.setOf(tuples);
            case INTERSECTION:
                Set<Tuple> set;
                Iterator<Expression> iterator = expr.iterator();
                if (iterator.hasNext())
                    set = new HashSet<>(iterator.next().accept(this));
                else
                    return factory.noneOf(expr.arity());

                while (iterator.hasNext()) {
                    Set<Tuple> temp = iterator.next().accept(this);
                    set.removeIf(t -> !temp.contains(t));
                }

                return set.isEmpty() ? factory.noneOf(expr.arity()) : factory.setOf(set);
            case PRODUCT:
                iterator = expr.iterator();
                if (iterator.hasNext())
                    set = iterator.next().accept(this);
                else
                    return factory.noneOf(expr.arity());

                while (iterator.hasNext()) {
                    Set<Tuple> temp = iterator.next().accept(this);
                    set = ((TupleSet) set).product((TupleSet) temp);
                }

                return set.isEmpty() ? factory.noneOf(expr.arity()) : factory.setOf(set);
            case OVERRIDE:
                // TODO: Check this.
                Set<Tuple> tuples2 = new HashSet<>();
                expr.iterator().forEachRemaining(expression -> tuples2.addAll(expression.accept(this)));
                return tuples2.isEmpty() ? factory.noneOf(expr.arity()) : factory.setOf(tuples2);
        }

        return factory.noneOf(expr.arity());
    }

    @Override
    public Set<Tuple> visit(NotFormula not) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(IfExpression ifExpr) {
        return factory.noneOf(ifExpr.arity());
    }

    @Override
    public Set<Tuple> visit(NaryFormula formula) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(IntConstant intConst) {
        for (Object o : factory.universe()) {
            try {
                if (Integer.parseInt(o.toString()) == intConst.value())
                    return factory.setOf(factory.tuple(o));
            } catch (NumberFormatException ignored) {
            }
        }
        return factory.allOf(1);
    }

    @Override
    public Set<Tuple> visit(ExprToIntCast intExpr) {
        return intExpr.expression().accept(this);
    }

    @Override
    public Set<Tuple> visit(SumExpression intExpr) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(IntToExprCast castExpr) {
        return castExpr.intExpr().accept(this);
    }

    @Override
    public Set<Tuple> visit(RelationPredicate pred) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(IfIntExpression intExpr) {
        Set<Tuple> then = intExpr.thenExpr().accept(this);
        then.addAll(intExpr.elseExpr().accept(this));
        return then;
    }

    @Override
    public Set<Tuple> visit(BinaryFormula binFormula) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(ConstantFormula constant) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(NaryIntExpression intExpr) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(ProjectExpression project) {
        return project.arity() == 0 ? factory.noneOf(project.arity()) : factory.allOf(project.arity());
    }

    @Override
    public Set<Tuple> visit(UnaryIntExpression intExpr) {
        return Relation.INTS.accept(this);
    }

    @Override
    public Set<Tuple> visit(BinaryIntExpression intExpr) {
        return Relation.INTS.accept(this);
    }

    @Override
    public Set<Tuple> visit(Comprehension comprehension) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(IntComparisonFormula intComp) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(ComparisonFormula compFormula) {
        return Collections.emptySet();
    }

    @Override
    public Set<Tuple> visit(MultiplicityFormula multFormula) {
        return Collections.emptySet();
    }
}
