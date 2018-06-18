package kodkod.examples.alloyinecore;

import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.satlab.SATFactory;
import kodkod.engine.satlab.Z3Solver;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.Universe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

final class SimplifiedTheoryOfList {

    public static void main(String[] args) {
        SimplifiedTheoryOfList theoryOfList = new SimplifiedTheoryOfList();
        System.out.println(theoryOfList);

        if (theoryOfList.solution.unsat()) {
            System.out.println("High Level Core:");
            theoryOfList.solution.proof().highLevelCore().keySet().forEach(System.out::println);
            System.out.println();
            System.out.println("Core:");
            theoryOfList.solution.proof().core().forEachRemaining(record -> {
                StringBuilder sb = new StringBuilder();
                sb.append(record.node()).append("(");
                sb.append(record.env().values().stream().flatMap(Collection::stream)
                        .map(tuple -> tuple.atom(0).toString()).collect(Collectors.joining(", ")));
                sb.append(")");
                System.out.println(sb);
            });
        }
    }

    private List<Formula> formulaList;
    private Bounds bounds;
    private Solution solution;

    private SimplifiedTheoryOfList() {
        formulaList = new ArrayList<>();
        solveExample();
    }

    // sig Object
    private Relation Object = Relation.unary("Object");
    // sig List
    private Relation List = Relation.unary("List");
    // one 'sig Nil' extends List
    private Relation  Nil = Relation.unary("Nil");
    // 'car': lone Vehicle
    private Relation car = Relation.binary("car");
    // 'cdr': lone List
    private Relation cdr = Relation.binary("cdr");
    // 'eq': set List
    private Relation eq = Relation.binary("eq");

    private void solveExample() {
        defineTypes();
        defineFormulas();
        createInstance();

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.Z3Solver);

        solution = solver.solve(Formula.and(formulaList), bounds);
    }

    private void defineTypes() {
        // sig 'Nil extends List'
        formulaList.add(Nil.in(List));

        // no Object & List
        formulaList.add(Object.intersection(List).no());

        // 'one' sig Nil extends List
        formulaList.add(Nil.one());

        // car: lone 'Vehicle'
        formulaList.add(car.in(List.product(Object)));

        // cdr: lone 'List'
        formulaList.add(cdr.in(List.product(List)));

        // eq: set 'List'
        formulaList.add(eq.in(List.product(List)));
    }

    private void defineFormulas() {
        // car: 'lone' Object
        Variable l = Variable.unary("l");
        formulaList.add(l.join(car).lone().forAll(l.oneOf(List)));

        // cdr: 'lone' List
        l = Variable.unary("l");
        formulaList.add(l.join(cdr).lone().forAll(l.oneOf(List)));

        // car: 'set' List -- By default, no need for a formula.

        // no Nil.car + Nil.cdr
        formulaList.add(Nil.join(car).union(Nil.join(cdr)).no());

        // all l: List - Nil | some l.cdr and some l.car
        l = Variable.unary("l");
        formulaList.add(l.join(cdr).some().and(l.join(car).some())
                .forAll(l.oneOf(List.difference(Nil))));

        // all l: List: Nil in l.*cdr
        l = Variable.unary("l");
        formulaList.add(Nil.in(l.join(cdr.reflexiveClosure()))
                .forAll(l.oneOf(List)));

        // fact listEquality { all a, b: List | a in b.eq
        //                      iff (a.car = b.car and a.cdr in b.cdr.eq) }
        Variable a = Variable.unary("a");
        Variable b = Variable.unary("b");
        formulaList.add(a.in(b.join(eq)).iff(a.join(car)
                .eq(b.join(car)).and(a.join(cdr).in(b.join(cdr).join(eq))))
                .forAll(a.oneOf(List).and(b.oneOf(List))));
    }

    private void createInstance() {
        String List0 = "List0";
        String List1 = "List1";
        String List2 = "List2";
        String List3 = "List3";
        String List4 = "List4";
        String List5 = "List5";
        String Object0 = "Object0";
        String Object1 = "Object1";

        Universe universe = new Universe(List0, List1, List2, List3,
                List4, List5, Object0, Object1);

        TupleFactory tupleFactory = universe.factory();

        bounds = new Bounds(universe);

        // Bound unary relations
        bounds.boundExactly(Object, tupleFactory.setOf(Object0, Object1));
        bounds.boundExactly(List, tupleFactory.setOf(List0, List1, List2,
                List3, List4, List5));
        bounds.bound(Nil, tupleFactory.setOf(List0, List1, List2,
                List3, List4, List5));

        // Bound binary relations
        bounds.bound(cdr, tupleFactory.setOf(
                tupleFactory.tuple(List1, List2),
                tupleFactory.tuple(List2, List0),
                tupleFactory.tuple(List4, List3),
                tupleFactory.tuple(List3, List0))
                , bounds.upperBound(List).product(bounds.upperBound(List)));

        bounds.bound(car, tupleFactory.setOf(
                tupleFactory.tuple(List0, Object0), //comment this to get a SAT Solution.
                tupleFactory.tuple(List1, Object1),
                tupleFactory.tuple(List2, Object0),
                tupleFactory.tuple(List4, Object1),
                tupleFactory.tuple(List0, Object1),
                tupleFactory.tuple(List3, Object0))
                , bounds.upperBound(List).product(bounds.upperBound(Object)));

        bounds.bound(eq, bounds.upperBound(List).product(bounds.upperBound(List)));
    }

    @Override
    public String toString() { return solution.toString();}
}
