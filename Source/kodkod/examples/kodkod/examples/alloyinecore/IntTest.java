package kodkod.examples.alloyinecore;

import kodkod.ast.*;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.Universe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

final class IntTest {

    public static void main(String[] args) {
        IntTest theoryOfList = new IntTest();
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

    private IntTest() {
        formulaList = new ArrayList<>();
        solveExample();
    }

    private Relation Object = Relation.unary("Object");
    private Relation Max = Relation.unary("Max");
    private Relation no = Relation.binary("no");

    private void solveExample() {
        defineTypes();
        defineFormulas();
        createInstance();

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.Z3Solver);
        solver.options().setBitwidth(4);

        solution = solver.solve(Formula.and(formulaList), bounds);
    }

    private void defineTypes() {
        formulaList.add(Max.one());

        formulaList.add(no.in(Object.product(Relation.INTS)));
    }

    private void defineFormulas() {
        Variable o = Variable.unary("o");
        formulaList.add(o.join(no).one().forAll(o.oneOf(Object)));

        Variable o1 = Variable.unary("o1");
        Variable o2 = Variable.unary("o2");
        formulaList.add(o1.join(no).eq(o2.join(no)).not().forAll(o1.oneOf(Object).and(o2.oneOf(Object.difference(o1)))));

        formulaList.add(Max.join(no).sum().gte(o.join(no).sum()).forAll(o.oneOf(Object)));
    }

    private void createInstance() {
        String Object1 = "Object1";
        String Object2 = "Object2";
        String Object3 = "Object3";

        Universe universe = new Universe(Object1, Object2, Object3, 1, 2, 3);

        TupleFactory tupleFactory = universe.factory();

        bounds = new Bounds(universe);

        for (int i = 0; i < 3; i++) {
            bounds.boundExactly(i + 1, tupleFactory.setOf(i + 1));
        }

        bounds.boundExactly(Object, tupleFactory.setOf(Object1, Object2, Object3));
        bounds.bound(Max, tupleFactory.setOf(Object1, Object2, Object3));
        bounds.bound(no, tupleFactory.allOf(2));
    }

    @Override
    public String toString() { return solution.toString();}
}
