package kodkod.examples.alloyinecore;

import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.satlab.SATFactory;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.Universe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TestModel {

    public static void main(String[] args) {
        TestModel requirementsModel = new TestModel();
        System.out.println(requirementsModel);

        if (requirementsModel.solution.unsat()) {
            System.out.println("High Level Core:");
            requirementsModel.solution.proof().highLevelCore().keySet().forEach(System.out::println);
            System.out.println();
            System.out.println("Core:");
            requirementsModel.solution.proof().core().forEachRemaining(record -> {
                StringBuilder sb = new StringBuilder();
                sb.append(record.node()).append("(");
                sb.append(record.env().values().stream().flatMap(Collection::stream)
                        .map(tuple -> tuple.atom(0).toString()).collect(Collectors.joining(", ")));
                sb.append(")");
                System.out.println(sb);
            });
        }
    }

    private java.util.List<Formula> formulaList;
    private Bounds bounds;
    private Solution solution;

    private TestModel() {
        formulaList = new ArrayList<>();
        solveExample();
    }

    private Relation Head = Relation.unary("Head");
    private Relation Tail = Relation.unary("Tail");
    private Relation List = Relation.unary("List");

    private Relation cdr = Relation.binary("cdr");

    private void solveExample() {
        defineTypes();
        defineFormulas();
        createInstance();

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.Z3Solver);

        solution = solver.solve(Formula.and(formulaList), bounds);
    }

    private void defineTypes() {
    }

    private void defineFormulas() {
        //formulaList.add(antisymmetric(cdr));
        //formulaList.add(irreflexive(cdr));

        formulaList.add(Head.one());
        formulaList.add(Tail.one());

        Variable a = Variable.unary("a");

        formulaList.add(a.join(cdr).lone().forAll(a.oneOf(List)));
        formulaList.add(List.eq(Head.join(cdr.reflexiveClosure())));
        formulaList.add(List.eq(Tail.join(cdr.transpose().reflexiveClosure())));
        formulaList.add(a.in(a.join(cdr.closure())).not().forAll(a.oneOf(List)));
    }

    private void createInstance() {
        Set<String> reqs = new HashSet<>();

        for (int i = 1; i <= 4; i++) {
            reqs.add("r" + i);
        }

        Set<String> all = new HashSet<>(reqs);

        Universe universe = new Universe(all);

        TupleFactory tupleFactory = universe.factory();

        bounds = new Bounds(universe);

        bounds.boundExactly(List, tupleFactory.setOf(reqs.toArray()));
        bounds.bound(Head, tupleFactory.setOf(reqs.toArray()));
        bounds.bound(Tail, tupleFactory.setOf(reqs.toArray()));

        bounds.bound(cdr, tupleFactory.allOf(2));
    }

    private static Formula infer(Relation r1, Relation r2, Relation r3) {
        return r1.join(r2).in(r3);
    }

    private static Formula transitive(Relation r) {
        return r.join(r).in(r);
    }

    private static Formula symmetric(Relation r) {
        return r.eq(r.transpose());
    }

    private static Formula antisymmetric(Relation r) {
        return r.intersection(r.transpose()).no();
    }

    private static Formula reflexive(Relation type, Relation rel) {
        Variable v = Variable.unary(type.name().charAt(0) + "");
        return v.in(v.join(rel)).forAll(v.oneOf(type));
    }

    private static Formula irreflexive(Relation r) {
        return Relation.IDEN.intersection(r).no();
    }

    @Override
    public String toString() { return solution.toString();}

}
