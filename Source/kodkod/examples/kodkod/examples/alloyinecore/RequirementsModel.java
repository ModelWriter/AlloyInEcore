package kodkod.examples.alloyinecore;

import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import kodkod.engine.Solution;
import kodkod.engine.Solver;
import kodkod.engine.satlab.SATFactory;
import kodkod.examples.ExampleMetadata;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.Universe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@ExampleMetadata(
        Name = "RequirementsModel",
        Note = "",
        IsCheck = false,
        PartialModel = true,
        BinaryRelations = 7,
        TernaryRelations = 0,
        NaryRelations = 0,
        HierarchicalTypes = 0,
        NestedRelationalJoins = 0,
        TransitiveClosure = 0,
        NestedQuantifiers = 0,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 3,
        OrderedRelations = 0,
        Constraints = 45
)
public class RequirementsModel {

    public static void main(String[] args) {
        RequirementsModel requirementsModel = new RequirementsModel();
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

    private RequirementsModel() {
        formulaList = new ArrayList<>();
        solveExample();
    }

    private Relation Requirement = Relation.unary("Requirement");
    private Relation Name = Relation.unary("Name");

    private Relation name = Relation.binary("name");
    private Relation requires = Relation.binary("requires");
    private Relation refines = Relation.binary("refines");
    private Relation contains = Relation.binary("contains");
    private Relation equals = Relation.binary("equals");
    private Relation conflicts = Relation.binary("conflicts");
    private Relation partiallyRefines = Relation.binary("partiallyRefines");

    private void solveExample() {
        defineTypes();
        defineFormulas();
        createInstance();

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.Z3Solver);

        solution = solver.solve(Formula.and(formulaList), bounds);
    }

    private void defineTypes() {
        /*

        NO NEED TO DEFINE THESE

        // no Name & Requirement
        formulaList.add(Name.intersection(Requirement).no());

        formulaList.add(name.in(Requirement.product(Name)));
        formulaList.add(requires.in(Requirement.product(Requirement)));
        formulaList.add(refines.in(Requirement.product(Requirement)));
        formulaList.add(contains.in(Requirement.product(Requirement)));
        formulaList.add(equals.in(Requirement.product(Requirement)));
        formulaList.add(conflicts.in(Requirement.product(Requirement)));
        formulaList.add(partiallyRefines.in(Requirement.product(Requirement)));
        */
    }

    private void defineFormulas() {
        formulaList.add(transitive(requires));
        formulaList.add(antisymmetric(requires));
        formulaList.add(irreflexive(requires));

        formulaList.add(transitive(refines));
        formulaList.add(antisymmetric(refines));
        formulaList.add(irreflexive(refines));

        formulaList.add(transitive(contains));
        formulaList.add(antisymmetric(contains));
        formulaList.add(irreflexive(contains));

        formulaList.add(transitive(partiallyRefines));
        formulaList.add(antisymmetric(partiallyRefines));
        formulaList.add(irreflexive(partiallyRefines));

        formulaList.add(symmetric(equals));
        formulaList.add(reflexive(Requirement, equals));
        formulaList.add(transitive(equals));

        formulaList.add(symmetric(conflicts));
        formulaList.add(irreflexive(conflicts));

        formulaList.add(infer(requires, refines, requires));
        formulaList.add(infer(requires, contains, requires));
        formulaList.add(infer(requires, conflicts, conflicts));
        formulaList.add(infer(requires, equals, requires));

        formulaList.add(infer(refines, requires, requires));
        formulaList.add(infer(refines, contains, refines));
        formulaList.add(infer(refines, partiallyRefines, partiallyRefines));
        formulaList.add(infer(refines, conflicts, conflicts));
        formulaList.add(infer(refines, equals, refines));

        formulaList.add(infer(contains, requires, requires));
        formulaList.add(infer(contains, refines, refines));
        formulaList.add(infer(contains, partiallyRefines, partiallyRefines));
        formulaList.add(infer(contains, conflicts, conflicts));
        formulaList.add(infer(contains, equals, contains));

        formulaList.add(infer(partiallyRefines, equals, partiallyRefines));

        formulaList.add(infer(conflicts, equals, conflicts));

        formulaList.add(infer(equals, requires, requires));
        formulaList.add(infer(equals, refines, refines));
        formulaList.add(infer(equals, contains, contains));
        formulaList.add(infer(equals, conflicts, conflicts));
        formulaList.add(infer(equals, partiallyRefines, partiallyRefines));


        formulaList.add(Expression.union(requires, requires.transpose())
                .intersection(Expression.union(refines, refines.transpose())).no());
        formulaList.add(Expression.union(contains, contains.transpose())
                .intersection(Expression.union(equals, equals.transpose())).no());
        formulaList.add(Expression.union(conflicts, conflicts.transpose())
                .intersection(Expression.union(partiallyRefines, partiallyRefines.transpose())).no());
        formulaList.add(Expression.union(requires, requires.transpose(), refines, refines.transpose())
                .intersection(Expression.union(contains, contains.transpose(), equals, equals.transpose())).no());
        formulaList.add(Expression.union(requires, requires.transpose(), refines, refines.transpose(), contains, contains.transpose(), equals, equals.transpose())
                .intersection(Expression.union(conflicts, conflicts.transpose(), partiallyRefines, partiallyRefines.transpose())).no());

        Variable a = Variable.unary("a");
        Variable b = Variable.unary("b");
        formulaList.add(a.eq(b).not().implies(a.join(name).eq(b.join(name)).not()).forAll(a.oneOf(Requirement).and(b.oneOf(Requirement))));

        formulaList.add(a.join(name).one().forAll(a.oneOf(Requirement)));
    }

    private void createInstance() {
        String r1 = "r1";
        String r2 = "r2";
        String r3 = "r3";
        String name1 = "Name1";
        String name2 = "Name2";
        String name3 = "Name3";

        Universe universe = new Universe(r1, r2, r3, name1, name2, name3);

        TupleFactory tupleFactory = universe.factory();

        bounds = new Bounds(universe);

        bounds.boundExactly(Requirement, tupleFactory.setOf(r1, r2, r3));
        bounds.boundExactly(Name, tupleFactory.setOf(name1, name2, name3));

        bounds.bound(name, tupleFactory.setOf(
                tupleFactory.tuple(r1, name1), tupleFactory.tuple(r2, name2), tupleFactory.tuple(r3, name3))
                , bounds.upperBound(Requirement).product(bounds.upperBound(Name)));
        bounds.bound(requires, tupleFactory.setOf(
                tupleFactory.tuple(r1, r2), tupleFactory.tuple(r2, r3))
                , bounds.upperBound(Requirement).product(bounds.upperBound(Requirement)));
        bounds.bound(refines, bounds.upperBound(Requirement).product(bounds.upperBound(Requirement)));
        bounds.bound(contains, bounds.upperBound(Requirement).product(bounds.upperBound(Requirement)));
        bounds.bound(equals, bounds.upperBound(Requirement).product(bounds.upperBound(Requirement)));
        bounds.bound(conflicts, bounds.upperBound(Requirement).product(bounds.upperBound(Requirement)));
        bounds.bound(partiallyRefines, bounds.upperBound(Requirement).product(bounds.upperBound(Requirement)));
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
        return type.product(type).in(rel);
    }

    private static Formula irreflexive(Relation r) {
        return Relation.IDEN.intersection(r).no();
    }

    @Override
    public String toString() { return solution.toString();}

}
