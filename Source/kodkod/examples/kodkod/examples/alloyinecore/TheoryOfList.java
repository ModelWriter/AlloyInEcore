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
import java.util.List;

final class TheoryOfList {

    public static void main(String[] args) {
        TheoryOfList theoryOfList = new TheoryOfList();
        System.out.println(theoryOfList);
    }

    private List<Formula> formulaList;
    private Bounds bounds;
    private Solution solution;

    private TheoryOfList() {
        formulaList = new ArrayList<>();

        solveExample();
    }

    private Relation Object;
    private Relation List;
    private Relation Nil;

    private Relation car;
    private Relation cdr;
    private Relation eq;

    private void solveExample() {
        defineTypes();
        defineFormulas();
        createInstance();

        Solver solver = new Solver();

        solver.options().setSolver(SATFactory.Z3Solver);

        solution = solver.solve(Formula.and(formulaList), bounds);
    }

    private void defineTypes() {
        // sig Object
        Object = Relation.unary("Object");
        // sig List
        List = Relation.unary("List");
        // one 'sig Nil' extends List
        Nil = Relation.unary("Nil");

        // sig 'Nil extends List'
        Formula nilExtendsList = Nil.in(List);

        // no Object & List
        Formula objectListDisjoint = Object.intersection(List).no();

        // 'one' sig Nil extends List
        Formula oneNil = Nil.one();

        car = Relation.binary("car");
        cdr = Relation.binary("cdr");
        eq = Relation.binary("eq");

        // car: lone 'Vehicle'
        Formula carDefinition = car.in(List.product(Object));

        // cdr: lone 'List'
        Formula cdrDefinition = cdr.in(List.product(List));

        // eq: set 'List'
        Formula eqDefinition = eq.in(List.product(List));

        // ******************************************************

        formulaList.add(nilExtendsList);
        formulaList.add(objectListDisjoint);
        formulaList.add(oneNil);
        formulaList.add(carDefinition);
        formulaList.add(cdrDefinition);
        formulaList.add(eqDefinition);
    }

    private void defineFormulas() {
        // car: 'lone' Object
        Variable l = Variable.unary("l");
        Formula carLone = l.join(car).lone().forAll(l.oneOf(List));

        // cdr: 'lone' List
        l = Variable.unary("l");
        Formula cdrLone = l.join(cdr).lone().forAll(l.oneOf(List));

        // car: 'set' List -- By default, no need for a formula.

        // no Nil.car
        Formula noNilCar = Nil.join(car).no();

        // no Nil.cdr
        Formula noNilCdr = Nil.join(cdr).no();

        // all l: List - Nil | some l.cdr and some l.car
        l = Variable.unary("l");
        Formula someCarAndCdr = l.join(cdr).some().and(l.join(car).some()).forAll(l.oneOf(List.difference(Nil)));

        // all l: List: Nil in l.*cdr
        l = Variable.unary("l");
        Formula cdrToNil = Nil.in(l.join(cdr.reflexiveClosure())).forAll(l.oneOf(List));

        // fact listEquality { all a, b: List | a in b.eq iff (a.car = b.car and a.cdr in b.cdr.eq) }
        Variable a = Variable.unary("a");
        Variable b = Variable.unary("b");
        Formula listEquality = a.in(b.join(eq)).iff(a.join(car).eq(b.join(car)).and(a.join(cdr).in(b.join(cdr).join(eq)))).forAll(a.oneOf(List).and(b.oneOf(List)));

        // ******************************************************

        formulaList.add(carLone);
        formulaList.add(cdrLone);
        formulaList.add(noNilCar);
        formulaList.add(noNilCdr);
        formulaList.add(someCarAndCdr);
        formulaList.add(cdrToNil);
        formulaList.add(listEquality);
    }

    private void createInstance() {
        String VehicleList0 = "VehicleList0";
        String VehicleList1 = "VehicleList1";
        String VehicleList2 = "VehicleList2";
        String VehicleList3 = "VehicleList3";
        String VehicleList4 = "VehicleList4";
        String VehicleList5 = "VehicleList5";
        String Vehicle0 = "Vehicle0";
        String Vehicle1 = "Vehicle1";

        Universe universe = new Universe(VehicleList0, VehicleList1, VehicleList2, VehicleList3, VehicleList4, VehicleList5, Vehicle0, Vehicle1);

        TupleFactory tupleFactory = universe.factory();

        bounds = new Bounds(universe);

        // Bound types
        bounds.boundExactly(Object, tupleFactory.setOf(Vehicle0, Vehicle1));
        bounds.boundExactly(List, tupleFactory.setOf(VehicleList0, VehicleList1, VehicleList2, VehicleList3, VehicleList4, VehicleList5));
        bounds.bound(Nil, tupleFactory.setOf(VehicleList0, VehicleList1, VehicleList2, VehicleList3, VehicleList4, VehicleList5));

        // Bound relations
        bounds.bound(cdr, tupleFactory.setOf(
                    tupleFactory.tuple(VehicleList1, VehicleList2)
                    , tupleFactory.tuple(VehicleList2, VehicleList0)
                    , tupleFactory.tuple(VehicleList4, VehicleList3)
                    , tupleFactory.tuple(VehicleList3, VehicleList0))
                , tupleFactory.setOf(
                        tupleFactory.tuple(VehicleList0, VehicleList0)
                        , tupleFactory.tuple(VehicleList0, VehicleList1)
                        , tupleFactory.tuple(VehicleList0, VehicleList2)
                        , tupleFactory.tuple(VehicleList0, VehicleList3)
                        , tupleFactory.tuple(VehicleList0, VehicleList4)
                        , tupleFactory.tuple(VehicleList0, VehicleList5)
                        , tupleFactory.tuple(VehicleList1, VehicleList0)
                        , tupleFactory.tuple(VehicleList1, VehicleList1)
                        , tupleFactory.tuple(VehicleList1, VehicleList2)
                        , tupleFactory.tuple(VehicleList1, VehicleList3)
                        , tupleFactory.tuple(VehicleList1, VehicleList4)
                        , tupleFactory.tuple(VehicleList1, VehicleList5)
                        , tupleFactory.tuple(VehicleList2, VehicleList0)
                        , tupleFactory.tuple(VehicleList2, VehicleList1)
                        , tupleFactory.tuple(VehicleList2, VehicleList2)
                        , tupleFactory.tuple(VehicleList2, VehicleList3)
                        , tupleFactory.tuple(VehicleList2, VehicleList4)
                        , tupleFactory.tuple(VehicleList2, VehicleList5)
                        , tupleFactory.tuple(VehicleList3, VehicleList0)
                        , tupleFactory.tuple(VehicleList3, VehicleList1)
                        , tupleFactory.tuple(VehicleList3, VehicleList2)
                        , tupleFactory.tuple(VehicleList3, VehicleList3)
                        , tupleFactory.tuple(VehicleList3, VehicleList4)
                        , tupleFactory.tuple(VehicleList3, VehicleList5)
                        , tupleFactory.tuple(VehicleList4, VehicleList0)
                        , tupleFactory.tuple(VehicleList4, VehicleList1)
                        , tupleFactory.tuple(VehicleList4, VehicleList2)
                        , tupleFactory.tuple(VehicleList4, VehicleList3)
                        , tupleFactory.tuple(VehicleList4, VehicleList4)
                        , tupleFactory.tuple(VehicleList4, VehicleList5)
                        , tupleFactory.tuple(VehicleList5, VehicleList0)
                        , tupleFactory.tuple(VehicleList5, VehicleList1)
                        , tupleFactory.tuple(VehicleList5, VehicleList2)
                        , tupleFactory.tuple(VehicleList5, VehicleList3)
                        , tupleFactory.tuple(VehicleList5, VehicleList4)
                        , tupleFactory.tuple(VehicleList5, VehicleList5)
                ));

        bounds.bound(car, tupleFactory.setOf(
                    tupleFactory.tuple(VehicleList1, Vehicle1)
                    , tupleFactory.tuple(VehicleList2, Vehicle0)
                    , tupleFactory.tuple(VehicleList4, Vehicle1)
                    , tupleFactory.tuple(VehicleList0, Vehicle1)
                    , tupleFactory.tuple(VehicleList3, Vehicle0))
                , tupleFactory.setOf(
                        tupleFactory.tuple(VehicleList0, Vehicle0)
                        , tupleFactory.tuple(VehicleList0, Vehicle1)
                        , tupleFactory.tuple(VehicleList1, Vehicle0)
                        , tupleFactory.tuple(VehicleList1, Vehicle1)
                        , tupleFactory.tuple(VehicleList2, Vehicle0)
                        , tupleFactory.tuple(VehicleList2, Vehicle1)
                        , tupleFactory.tuple(VehicleList3, Vehicle0)
                        , tupleFactory.tuple(VehicleList3, Vehicle1)
                        , tupleFactory.tuple(VehicleList4, Vehicle0)
                        , tupleFactory.tuple(VehicleList4, Vehicle1)
                        , tupleFactory.tuple(VehicleList5, Vehicle0)
                        , tupleFactory.tuple(VehicleList5, Vehicle1)
                ));

        bounds.bound(eq, tupleFactory.setOf(
                tupleFactory.tuple(VehicleList0, VehicleList0)
                , tupleFactory.tuple(VehicleList0, VehicleList1)
                , tupleFactory.tuple(VehicleList0, VehicleList2)
                , tupleFactory.tuple(VehicleList0, VehicleList3)
                , tupleFactory.tuple(VehicleList0, VehicleList4)
                , tupleFactory.tuple(VehicleList0, VehicleList5)
                , tupleFactory.tuple(VehicleList1, VehicleList0)
                , tupleFactory.tuple(VehicleList1, VehicleList1)
                , tupleFactory.tuple(VehicleList1, VehicleList2)
                , tupleFactory.tuple(VehicleList1, VehicleList3)
                , tupleFactory.tuple(VehicleList1, VehicleList4)
                , tupleFactory.tuple(VehicleList1, VehicleList5)
                , tupleFactory.tuple(VehicleList2, VehicleList0)
                , tupleFactory.tuple(VehicleList2, VehicleList1)
                , tupleFactory.tuple(VehicleList2, VehicleList2)
                , tupleFactory.tuple(VehicleList2, VehicleList3)
                , tupleFactory.tuple(VehicleList2, VehicleList4)
                , tupleFactory.tuple(VehicleList2, VehicleList5)
                , tupleFactory.tuple(VehicleList3, VehicleList0)
                , tupleFactory.tuple(VehicleList3, VehicleList1)
                , tupleFactory.tuple(VehicleList3, VehicleList2)
                , tupleFactory.tuple(VehicleList3, VehicleList3)
                , tupleFactory.tuple(VehicleList3, VehicleList4)
                , tupleFactory.tuple(VehicleList3, VehicleList5)
                , tupleFactory.tuple(VehicleList4, VehicleList0)
                , tupleFactory.tuple(VehicleList4, VehicleList1)
                , tupleFactory.tuple(VehicleList4, VehicleList2)
                , tupleFactory.tuple(VehicleList4, VehicleList3)
                , tupleFactory.tuple(VehicleList4, VehicleList4)
                , tupleFactory.tuple(VehicleList4, VehicleList5)
                , tupleFactory.tuple(VehicleList5, VehicleList0)
                , tupleFactory.tuple(VehicleList5, VehicleList1)
                , tupleFactory.tuple(VehicleList5, VehicleList2)
                , tupleFactory.tuple(VehicleList5, VehicleList3)
                , tupleFactory.tuple(VehicleList5, VehicleList4)
                , tupleFactory.tuple(VehicleList5, VehicleList5)
        ));
    }

    @Override
    public String toString() {
        return solution.toString();
    }
}
