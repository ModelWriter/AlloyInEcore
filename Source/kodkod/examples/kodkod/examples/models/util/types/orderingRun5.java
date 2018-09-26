package kodkod.examples.models.util.types;

import java.util.Arrays;
import java.util.List;
import kodkod.ast.*;
import kodkod.ast.operator.*;
import kodkod.examples.ExampleMetadata;
import kodkod.instance.*;
import kodkod.engine.*;
import kodkod.engine.satlab.SATFactory;
import kodkod.engine.config.Options;

@ExampleMetadata(
        Name = "ordering",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 2,
        TernaryRelations =0,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 4,
        TransitiveClosure = 0,
        NestedQuantifiers = 0,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 9,
        OrderedRelations = 0,
        Constraints = 32
)


public final class orderingRun5 {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/elem");
        Relation x7 = Relation.unary("this/Ord");
        Relation x8 = Relation.unary("this/Ord.First");
        Relation x9 = Relation.nary("this/Ord.Next", 2);
        Relation x10 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Ord$0",
                "elem$0", "elem$1", "elem$2", "elem$3"
        );

        Universe universe = new Universe(atomlist);
        TupleFactory factory = universe.factory();
        Bounds bounds = new Bounds(universe);

        TupleSet x0_upper = factory.noneOf(1);
        x0_upper.add(factory.tuple("-8"));
        bounds.boundExactly(x0, x0_upper);

        TupleSet x1_upper = factory.noneOf(1);
        x1_upper.add(factory.tuple("0"));
        bounds.boundExactly(x1, x1_upper);

        TupleSet x2_upper = factory.noneOf(1);
        x2_upper.add(factory.tuple("7"));
        bounds.boundExactly(x2, x2_upper);

        TupleSet x3_upper = factory.noneOf(2);
        x3_upper.add(factory.tuple("-8").product(factory.tuple("-7")));
        x3_upper.add(factory.tuple("-7").product(factory.tuple("-6")));
        x3_upper.add(factory.tuple("-6").product(factory.tuple("-5")));
        x3_upper.add(factory.tuple("-5").product(factory.tuple("-4")));
        x3_upper.add(factory.tuple("-4").product(factory.tuple("-3")));
        x3_upper.add(factory.tuple("-3").product(factory.tuple("-2")));
        x3_upper.add(factory.tuple("-2").product(factory.tuple("-1")));
        x3_upper.add(factory.tuple("-1").product(factory.tuple("0")));
        x3_upper.add(factory.tuple("0").product(factory.tuple("1")));
        x3_upper.add(factory.tuple("1").product(factory.tuple("2")));
        x3_upper.add(factory.tuple("2").product(factory.tuple("3")));
        x3_upper.add(factory.tuple("3").product(factory.tuple("4")));
        x3_upper.add(factory.tuple("4").product(factory.tuple("5")));
        x3_upper.add(factory.tuple("5").product(factory.tuple("6")));
        x3_upper.add(factory.tuple("6").product(factory.tuple("7")));
        bounds.boundExactly(x3, x3_upper);

        TupleSet x4_upper = factory.noneOf(1);
        x4_upper.add(factory.tuple("0"));
        x4_upper.add(factory.tuple("1"));
        x4_upper.add(factory.tuple("2"));
        x4_upper.add(factory.tuple("3"));
        bounds.boundExactly(x4, x4_upper);

        TupleSet x5_upper = factory.noneOf(1);
        bounds.boundExactly(x5, x5_upper);

        TupleSet x6_upper = factory.noneOf(1);
        x6_upper.add(factory.tuple("elem$0"));
        x6_upper.add(factory.tuple("elem$1"));
        x6_upper.add(factory.tuple("elem$2"));
        x6_upper.add(factory.tuple("elem$3"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Ord$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("elem$0"));
        x8_upper.add(factory.tuple("elem$1"));
        x8_upper.add(factory.tuple("elem$2"));
        x8_upper.add(factory.tuple("elem$3"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(2);
        x9_upper.add(factory.tuple("elem$0").product(factory.tuple("elem$0")));
        x9_upper.add(factory.tuple("elem$0").product(factory.tuple("elem$1")));
        x9_upper.add(factory.tuple("elem$0").product(factory.tuple("elem$2")));
        x9_upper.add(factory.tuple("elem$0").product(factory.tuple("elem$3")));
        x9_upper.add(factory.tuple("elem$1").product(factory.tuple("elem$0")));
        x9_upper.add(factory.tuple("elem$1").product(factory.tuple("elem$1")));
        x9_upper.add(factory.tuple("elem$1").product(factory.tuple("elem$2")));
        x9_upper.add(factory.tuple("elem$1").product(factory.tuple("elem$3")));
        x9_upper.add(factory.tuple("elem$2").product(factory.tuple("elem$0")));
        x9_upper.add(factory.tuple("elem$2").product(factory.tuple("elem$1")));
        x9_upper.add(factory.tuple("elem$2").product(factory.tuple("elem$2")));
        x9_upper.add(factory.tuple("elem$2").product(factory.tuple("elem$3")));
        x9_upper.add(factory.tuple("elem$3").product(factory.tuple("elem$0")));
        x9_upper.add(factory.tuple("elem$3").product(factory.tuple("elem$1")));
        x9_upper.add(factory.tuple("elem$3").product(factory.tuple("elem$2")));
        x9_upper.add(factory.tuple("elem$3").product(factory.tuple("elem$3")));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("elem$0"));
        x10_upper.add(factory.tuple("elem$1"));
        x10_upper.add(factory.tuple("elem$2"));
        x10_upper.add(factory.tuple("elem$3"));
        bounds.bound(x10, x10_upper);

        bounds.boundExactly(-8,factory.range(factory.tuple("-8"),factory.tuple("-8")));
        bounds.boundExactly(-7,factory.range(factory.tuple("-7"),factory.tuple("-7")));
        bounds.boundExactly(-6,factory.range(factory.tuple("-6"),factory.tuple("-6")));
        bounds.boundExactly(-5,factory.range(factory.tuple("-5"),factory.tuple("-5")));
        bounds.boundExactly(-4,factory.range(factory.tuple("-4"),factory.tuple("-4")));
        bounds.boundExactly(-3,factory.range(factory.tuple("-3"),factory.tuple("-3")));
        bounds.boundExactly(-2,factory.range(factory.tuple("-2"),factory.tuple("-2")));
        bounds.boundExactly(-1,factory.range(factory.tuple("-1"),factory.tuple("-1")));
        bounds.boundExactly(0,factory.range(factory.tuple("0"),factory.tuple("0")));
        bounds.boundExactly(1,factory.range(factory.tuple("1"),factory.tuple("1")));
        bounds.boundExactly(2,factory.range(factory.tuple("2"),factory.tuple("2")));
        bounds.boundExactly(3,factory.range(factory.tuple("3"),factory.tuple("3")));
        bounds.boundExactly(4,factory.range(factory.tuple("4"),factory.tuple("4")));
        bounds.boundExactly(5,factory.range(factory.tuple("5"),factory.tuple("5")));
        bounds.boundExactly(6,factory.range(factory.tuple("6"),factory.tuple("6")));
        bounds.boundExactly(7,factory.range(factory.tuple("7"),factory.tuple("7")));

        Expression x14=x7.product(x8);
        Expression x13=x7.join(x14);
        Formula x12=x13.in(x6);
        Expression x17=x7.product(x9);
        Expression x16=x7.join(x17);
        Expression x18=x6.product(x6);
        Formula x15=x16.in(x18);
        Formula x19=x9.totalOrder(x6,x8,x10);
        Formula x20=x0.eq(x0);
        Formula x21=x1.eq(x1);
        Formula x22=x2.eq(x2);
        Formula x23=x3.eq(x3);
        Formula x24=x4.eq(x4);
        Formula x25=x5.eq(x5);
        Formula x26=x6.eq(x6);
        Formula x27=x7.eq(x7);
        Formula x28=x8.eq(x8);
        Formula x29=x9.eq(x9);
        Formula x30=x10.eq(x10);
        Formula x11=Formula.compose(FormulaOperator.AND, x12, x15, x19, x20, x21, x22, x23, x24, x25, x26, x27, x28, x29, x30);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
       // solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x11,bounds);
        System.out.println(sol.toString());
    }}