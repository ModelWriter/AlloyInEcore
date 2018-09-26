package kodkod.examples.models.simple.stateMachine;

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
        Name = "reset-flip-flop-with-enable",
        Note = "",
        IsCheck = false,
        PartialModel = true,
        BinaryRelations = 6,
        TernaryRelations = 2,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 1,
        TransitiveClosure = 5,
        NestedQuantifiers = 2,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 4,
        OrderedRelations = 1,
        Constraints = 6
)


public final class reset_flip_flop_with_enableShowRun {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/C");
        Relation x7 = Relation.unary("this/X");
        Relation x8 = Relation.unary("this/On");
        Relation x9 = Relation.unary("this/Off");
        Relation x10 = Relation.unary("this/Trace");
        Relation x11 = Relation.unary("ordering/Ord");
        Relation x12 = Relation.unary("open$2/Ord");
        Relation x13 = Relation.unary("open$3/Ord");
        Relation x14 = Relation.nary("this/Trace.state", 2);
        Relation x15 = Relation.nary("this/Trace.event", 2);
        Relation x16 = Relation.unary("ordering/Ord.First");
        Relation x17 = Relation.nary("ordering/Ord.Next", 2);
        Relation x18 = Relation.nary("open$2/Ord.First", 2);
        Relation x19 = Relation.nary("open$2/Ord.Next", 3);
        Relation x20 = Relation.nary("open$3/Ord.First", 2);
        Relation x21 = Relation.nary("open$3/Ord.Next", 3);
        Relation x22 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "C$0",
                "Off$0", "On$0", "Trace$0", "Trace$1", "Trace$2", "Trace$3",
                "Trace$4", "Trace$5", "Trace$6", "Trace$7", "Trace$8", "Trace$9",
                "X$0", "open$2/Ord$0", "open$3/Ord$0", "ordering/Ord$0"
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
        x4_upper.add(factory.tuple("4"));
        x4_upper.add(factory.tuple("5"));
        x4_upper.add(factory.tuple("6"));
        bounds.boundExactly(x4, x4_upper);

        TupleSet x5_upper = factory.noneOf(1);
        bounds.boundExactly(x5, x5_upper);

        TupleSet x6_upper = factory.noneOf(1);
        x6_upper.add(factory.tuple("C$0"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("X$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("On$0"));
        bounds.boundExactly(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Off$0"));
        bounds.boundExactly(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("Trace$0"));
        x10_upper.add(factory.tuple("Trace$1"));
        x10_upper.add(factory.tuple("Trace$2"));
        x10_upper.add(factory.tuple("Trace$3"));
        x10_upper.add(factory.tuple("Trace$4"));
        x10_upper.add(factory.tuple("Trace$5"));
        x10_upper.add(factory.tuple("Trace$6"));
        x10_upper.add(factory.tuple("Trace$7"));
        x10_upper.add(factory.tuple("Trace$8"));
        x10_upper.add(factory.tuple("Trace$9"));
        bounds.boundExactly(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(1);
        x11_upper.add(factory.tuple("ordering/Ord$0"));
        bounds.boundExactly(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(1);
        x12_upper.add(factory.tuple("open$2/Ord$0"));
        bounds.boundExactly(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(1);
        x13_upper.add(factory.tuple("open$3/Ord$0"));
        bounds.boundExactly(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("Trace$0").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$0").product(factory.tuple("Off$0")));
        x14_upper.add(factory.tuple("Trace$1").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$1").product(factory.tuple("Off$0")));
        x14_upper.add(factory.tuple("Trace$2").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$2").product(factory.tuple("Off$0")));
        x14_upper.add(factory.tuple("Trace$3").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$3").product(factory.tuple("Off$0")));
        x14_upper.add(factory.tuple("Trace$4").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$4").product(factory.tuple("Off$0")));
        x14_upper.add(factory.tuple("Trace$5").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$5").product(factory.tuple("Off$0")));
        x14_upper.add(factory.tuple("Trace$6").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$6").product(factory.tuple("Off$0")));
        x14_upper.add(factory.tuple("Trace$7").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$7").product(factory.tuple("Off$0")));
        x14_upper.add(factory.tuple("Trace$8").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$8").product(factory.tuple("Off$0")));
        x14_upper.add(factory.tuple("Trace$9").product(factory.tuple("On$0")));
        x14_upper.add(factory.tuple("Trace$9").product(factory.tuple("Off$0")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(2);
        x15_upper.add(factory.tuple("Trace$0").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$0").product(factory.tuple("X$0")));
        x15_upper.add(factory.tuple("Trace$1").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$1").product(factory.tuple("X$0")));
        x15_upper.add(factory.tuple("Trace$2").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$2").product(factory.tuple("X$0")));
        x15_upper.add(factory.tuple("Trace$3").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$3").product(factory.tuple("X$0")));
        x15_upper.add(factory.tuple("Trace$4").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$4").product(factory.tuple("X$0")));
        x15_upper.add(factory.tuple("Trace$5").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$5").product(factory.tuple("X$0")));
        x15_upper.add(factory.tuple("Trace$6").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$6").product(factory.tuple("X$0")));
        x15_upper.add(factory.tuple("Trace$7").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$7").product(factory.tuple("X$0")));
        x15_upper.add(factory.tuple("Trace$8").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$8").product(factory.tuple("X$0")));
        x15_upper.add(factory.tuple("Trace$9").product(factory.tuple("C$0")));
        x15_upper.add(factory.tuple("Trace$9").product(factory.tuple("X$0")));
        bounds.bound(x15, x15_upper);

        TupleSet x16_upper = factory.noneOf(1);
        x16_upper.add(factory.tuple("Trace$0"));
        x16_upper.add(factory.tuple("Trace$1"));
        x16_upper.add(factory.tuple("Trace$2"));
        x16_upper.add(factory.tuple("Trace$3"));
        x16_upper.add(factory.tuple("Trace$4"));
        x16_upper.add(factory.tuple("Trace$5"));
        x16_upper.add(factory.tuple("Trace$6"));
        x16_upper.add(factory.tuple("Trace$7"));
        x16_upper.add(factory.tuple("Trace$8"));
        x16_upper.add(factory.tuple("Trace$9"));
        bounds.bound(x16, x16_upper);

        TupleSet x17_upper = factory.noneOf(2);
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$9")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$9")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$9")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$9")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$9")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$9")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$9")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$9")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$9")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$0")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$1")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$2")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$3")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$4")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$5")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$6")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$7")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$8")));
        x17_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$9")));
        bounds.bound(x17, x17_upper);

        TupleSet x18_upper = factory.noneOf(2);
        x18_upper.add(factory.tuple("open$2/Ord$0").product(factory.tuple("C$0")));
        bounds.boundExactly(x18, x18_upper);

        TupleSet x19_upper = factory.noneOf(3);
        x19_upper.add(factory.tuple("open$2/Ord$0").product(factory.tuple("C$0")).product(factory.tuple("X$0")));
        bounds.boundExactly(x19, x19_upper);

        TupleSet x20_upper = factory.noneOf(2);
        x20_upper.add(factory.tuple("open$3/Ord$0").product(factory.tuple("On$0")));
        bounds.boundExactly(x20, x20_upper);

        TupleSet x21_upper = factory.noneOf(3);
        x21_upper.add(factory.tuple("open$3/Ord$0").product(factory.tuple("On$0")).product(factory.tuple("Off$0")));
        bounds.boundExactly(x21, x21_upper);

        TupleSet x22_upper = factory.noneOf(1);
        x22_upper.add(factory.tuple("Trace$0"));
        x22_upper.add(factory.tuple("Trace$1"));
        x22_upper.add(factory.tuple("Trace$2"));
        x22_upper.add(factory.tuple("Trace$3"));
        x22_upper.add(factory.tuple("Trace$4"));
        x22_upper.add(factory.tuple("Trace$5"));
        x22_upper.add(factory.tuple("Trace$6"));
        x22_upper.add(factory.tuple("Trace$7"));
        x22_upper.add(factory.tuple("Trace$8"));
        x22_upper.add(factory.tuple("Trace$9"));
        bounds.bound(x22, x22_upper);

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

        Expression x25=x6.intersection(x7);
        Formula x24=x25.no();
        Expression x27=x8.intersection(x9);
        Formula x26=x27.no();
        Variable x30=Variable.unary("show_this");
        Decls x29=x30.oneOf(x10);
        Expression x33=x30.join(x14);
        Formula x32=x33.one();
        Expression x35=x8.union(x9);
        Formula x34=x33.in(x35);
        Formula x31=x32.and(x34);
        Formula x28=x31.forAll(x29);
        Expression x37=x14.join(Expression.UNIV);
        Formula x36=x37.in(x10);
        Variable x41=Variable.unary("show_this");
        Decls x40=x41.oneOf(x10);
        Expression x44=x41.join(x15);
        Formula x43=x44.lone();
        Expression x46=x6.union(x7);
        Formula x45=x44.in(x46);
        Formula x42=x43.and(x45);
        Formula x39=x42.forAll(x40);
        Expression x48=x15.join(Expression.UNIV);
        Formula x47=x48.in(x10);
        Expression x51=x11.product(x16);
        Expression x50=x11.join(x51);
        Formula x49=x50.in(x10);
        Expression x54=x11.product(x17);
        Expression x53=x11.join(x54);
        Expression x55=x10.product(x10);
        Formula x52=x53.in(x55);
        Formula x56=x17.totalOrder(x10,x16,x22);
        Expression x58=x12.join(x18);
        Formula x57=x58.in(x46);
        Expression x60=x12.join(x19);
        Expression x61=x46.product(x46);
        Formula x59=x60.in(x61);
        Variable x66=Variable.unary("");
        Decls x65=x66.oneOf(x46);
        Expression x71=x12.join(x18);
        Formula x70=x66.eq(x71);
        Expression x74=x12.join(x19);
        Expression x73=x74.join(x66);
        Formula x72=x73.one();
        Formula x69=x70.or(x72);
        Expression x78=x74.join(x46);
        Expression x77=x46.difference(x78);
        Formula x76=x66.eq(x77);
        Expression x80=x66.join(x74);
        Formula x79=x80.one();
        Formula x75=x76.or(x79);
        Formula x68=x69.and(x75);
        Expression x84=x74.closure();
        Expression x83=x66.join(x84);
        Formula x82=x66.in(x83);
        Formula x81=x82.not();
        Formula x67=x68.and(x81);
        Formula x64=x67.forAll(x65);
        Expression x87=x74.reflexiveClosure();
        Expression x86=x71.join(x87);
        Formula x85=x46.in(x86);
        Formula x63=x64.and(x85);
        Expression x89=x74.join(x71);
        Formula x88=x89.no();
        Formula x62=x63.and(x88);
        Expression x91=x13.join(x20);
        Formula x90=x91.in(x35);
        Expression x93=x13.join(x21);
        Expression x94=x35.product(x35);
        Formula x92=x93.in(x94);
        Variable x99=Variable.unary("");
        Decls x98=x99.oneOf(x35);
        Expression x104=x13.join(x20);
        Formula x103=x99.eq(x104);
        Expression x107=x13.join(x21);
        Expression x106=x107.join(x99);
        Formula x105=x106.one();
        Formula x102=x103.or(x105);
        Expression x111=x107.join(x35);
        Expression x110=x35.difference(x111);
        Formula x109=x99.eq(x110);
        Expression x113=x99.join(x107);
        Formula x112=x113.one();
        Formula x108=x109.or(x112);
        Formula x101=x102.and(x108);
        Expression x117=x107.closure();
        Expression x116=x99.join(x117);
        Formula x115=x99.in(x116);
        Formula x114=x115.not();
        Formula x100=x101.and(x114);
        Formula x97=x100.forAll(x98);
        Expression x120=x107.reflexiveClosure();
        Expression x119=x104.join(x120);
        Formula x118=x35.in(x119);
        Formula x96=x97.and(x118);
        Expression x122=x107.join(x104);
        Formula x121=x122.no();
        Formula x95=x96.and(x121);
        Expression x124=x16.join(x14);
        Formula x123=x124.eq(x8);
        Expression x128=x17.join(x10);
        Expression x127=x10.difference(x128);
        Expression x126=x127.join(x15);
        Formula x125=x126.no();
        Variable x132=Variable.unary("show_t'");
        Expression x133=x10.difference(x16);
        Decls x131=x132.oneOf(x133);
        Variable x135=Variable.unary("show_t");
        Expression x137=x17.transpose();
        Expression x136=x132.join(x137);
        Decls x134=x135.oneOf(x136);
        Decls x130=x131.and(x134);
        Variable x140=Variable.unary("show_e");
        Decls x139=x140.oneOf(x46);
        Expression x143=x135.join(x15);
        Formula x142=x143.eq(x140);
        Expression x145=x132.join(x14);
        Expression x147=x135.join(x15);
        Expression x149=x135.join(x14);
        Expression x154=x6.product(x9);
        Expression x153=x8.product(x154);
        Expression x156=x7.product(x8);
        Expression x155=x8.product(x156);
        Expression x152=x153.union(x155);
        Expression x158=x6.product(x8);
        Expression x157=x9.product(x158);
        Expression x151=x152.union(x157);
        Expression x160=x7.product(x9);
        Expression x159=x9.product(x160);
        Expression x150=x151.union(x159);
        Expression x148=x149.join(x150);
        Expression x146=x147.join(x148);
        Formula x144=x145.eq(x146);
        Formula x141=x142.and(x144);
        Formula x138=x141.forSome(x139);
        Formula x129=x138.forAll(x130);
        Variable x163=Variable.unary("show_t");
        Decls x162=x163.oneOf(x10);
        Variable x166=Variable.unary("show_s");
        Expression x168=x17.closure();
        Expression x167=x163.join(x168);
        Decls x165=x166.oneOf(x167);
        Expression x170=x166.join(x14);
        Formula x169=x170.eq(x9);
        Formula x164=x169.forAll(x165);
        Formula x161=x164.forSome(x162);
        Formula x171=x0.eq(x0);
        Formula x172=x1.eq(x1);
        Formula x173=x2.eq(x2);
        Formula x174=x3.eq(x3);
        Formula x175=x4.eq(x4);
        Formula x176=x5.eq(x5);
        Formula x177=x6.eq(x6);
        Formula x178=x7.eq(x7);
        Formula x179=x8.eq(x8);
        Formula x180=x9.eq(x9);
        Formula x181=x10.eq(x10);
        Formula x182=x11.eq(x11);
        Formula x183=x12.eq(x12);
        Formula x184=x13.eq(x13);
        Formula x185=x14.eq(x14);
        Formula x186=x15.eq(x15);
        Formula x187=x16.eq(x16);
        Formula x188=x17.eq(x17);
        Formula x189=x18.eq(x18);
        Formula x190=x19.eq(x19);
        Formula x191=x20.eq(x20);
        Formula x192=x21.eq(x21);
        Formula x193=x22.eq(x22);
        Formula x23=Formula.compose(FormulaOperator.AND, x24, x26, x28, x36, x39, x47, x49, x52, x56, x57, x59, x62, x90, x92, x95, x123, x125, x129, x161, x171, x172, x173, x174, x175, x176, x177, x178, x179, x180, x181, x182, x183, x184, x185, x186, x187, x188, x189, x190, x191, x192, x193);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x23,bounds);
        System.out.println(sol.toString());
    }}