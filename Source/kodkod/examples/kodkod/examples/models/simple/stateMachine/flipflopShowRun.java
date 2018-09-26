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
        Name = "flip-flop",
        Note = "",
        IsCheck = false,
        PartialModel = true,
        BinaryRelations = 6,
        TernaryRelations = 2,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 1,
        TransitiveClosure = 4,
        NestedQuantifiers = 1,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 3,
        OrderedRelations = 1,
        Constraints = 5
)


public final class flipflopShowRun {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/C");
        Relation x7 = Relation.unary("this/On");
        Relation x8 = Relation.unary("this/Off");
        Relation x9 = Relation.unary("this/Trace");
        Relation x10 = Relation.unary("ordering/Ord");
        Relation x11 = Relation.unary("open$2/Ord");
        Relation x12 = Relation.unary("open$3/Ord");
        Relation x13 = Relation.nary("this/Trace.state", 2);
        Relation x14 = Relation.nary("this/Trace.event", 2);
        Relation x15 = Relation.unary("ordering/Ord.First");
        Relation x16 = Relation.nary("ordering/Ord.Next", 2);
        Relation x17 = Relation.nary("open$2/Ord.First", 2);
        Relation x18 = Relation.nary("open$2/Ord.Next", 3);
        Relation x19 = Relation.nary("open$3/Ord.First", 2);
        Relation x20 = Relation.nary("open$3/Ord.Next", 3);
        Relation x21 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "C$0",
                "Off$0", "On$0", "Trace$0", "Trace$1", "Trace$2", "Trace$3",
                "Trace$4", "Trace$5", "Trace$6", "Trace$7", "Trace$8", "Trace$9",
                "open$2/Ord$0", "open$3/Ord$0", "ordering/Ord$0"
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
        x7_upper.add(factory.tuple("On$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Off$0"));
        bounds.boundExactly(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Trace$0"));
        x9_upper.add(factory.tuple("Trace$1"));
        x9_upper.add(factory.tuple("Trace$2"));
        x9_upper.add(factory.tuple("Trace$3"));
        x9_upper.add(factory.tuple("Trace$4"));
        x9_upper.add(factory.tuple("Trace$5"));
        x9_upper.add(factory.tuple("Trace$6"));
        x9_upper.add(factory.tuple("Trace$7"));
        x9_upper.add(factory.tuple("Trace$8"));
        x9_upper.add(factory.tuple("Trace$9"));
        bounds.boundExactly(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("ordering/Ord$0"));
        bounds.boundExactly(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(1);
        x11_upper.add(factory.tuple("open$2/Ord$0"));
        bounds.boundExactly(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(1);
        x12_upper.add(factory.tuple("open$3/Ord$0"));
        bounds.boundExactly(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(2);
        x13_upper.add(factory.tuple("Trace$0").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$0").product(factory.tuple("Off$0")));
        x13_upper.add(factory.tuple("Trace$1").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$1").product(factory.tuple("Off$0")));
        x13_upper.add(factory.tuple("Trace$2").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$2").product(factory.tuple("Off$0")));
        x13_upper.add(factory.tuple("Trace$3").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$3").product(factory.tuple("Off$0")));
        x13_upper.add(factory.tuple("Trace$4").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$4").product(factory.tuple("Off$0")));
        x13_upper.add(factory.tuple("Trace$5").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$5").product(factory.tuple("Off$0")));
        x13_upper.add(factory.tuple("Trace$6").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$6").product(factory.tuple("Off$0")));
        x13_upper.add(factory.tuple("Trace$7").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$7").product(factory.tuple("Off$0")));
        x13_upper.add(factory.tuple("Trace$8").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$8").product(factory.tuple("Off$0")));
        x13_upper.add(factory.tuple("Trace$9").product(factory.tuple("On$0")));
        x13_upper.add(factory.tuple("Trace$9").product(factory.tuple("Off$0")));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("Trace$0").product(factory.tuple("C$0")));
        x14_upper.add(factory.tuple("Trace$1").product(factory.tuple("C$0")));
        x14_upper.add(factory.tuple("Trace$2").product(factory.tuple("C$0")));
        x14_upper.add(factory.tuple("Trace$3").product(factory.tuple("C$0")));
        x14_upper.add(factory.tuple("Trace$4").product(factory.tuple("C$0")));
        x14_upper.add(factory.tuple("Trace$5").product(factory.tuple("C$0")));
        x14_upper.add(factory.tuple("Trace$6").product(factory.tuple("C$0")));
        x14_upper.add(factory.tuple("Trace$7").product(factory.tuple("C$0")));
        x14_upper.add(factory.tuple("Trace$8").product(factory.tuple("C$0")));
        x14_upper.add(factory.tuple("Trace$9").product(factory.tuple("C$0")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(1);
        x15_upper.add(factory.tuple("Trace$0"));
        x15_upper.add(factory.tuple("Trace$1"));
        x15_upper.add(factory.tuple("Trace$2"));
        x15_upper.add(factory.tuple("Trace$3"));
        x15_upper.add(factory.tuple("Trace$4"));
        x15_upper.add(factory.tuple("Trace$5"));
        x15_upper.add(factory.tuple("Trace$6"));
        x15_upper.add(factory.tuple("Trace$7"));
        x15_upper.add(factory.tuple("Trace$8"));
        x15_upper.add(factory.tuple("Trace$9"));
        bounds.bound(x15, x15_upper);

        TupleSet x16_upper = factory.noneOf(2);
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$0").product(factory.tuple("Trace$9")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$1").product(factory.tuple("Trace$9")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$2").product(factory.tuple("Trace$9")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$3").product(factory.tuple("Trace$9")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$4").product(factory.tuple("Trace$9")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$5").product(factory.tuple("Trace$9")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$6").product(factory.tuple("Trace$9")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$7").product(factory.tuple("Trace$9")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$8").product(factory.tuple("Trace$9")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$0")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$1")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$2")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$3")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$4")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$5")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$6")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$7")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$8")));
        x16_upper.add(factory.tuple("Trace$9").product(factory.tuple("Trace$9")));
        bounds.bound(x16, x16_upper);

        TupleSet x17_upper = factory.noneOf(2);
        x17_upper.add(factory.tuple("open$2/Ord$0").product(factory.tuple("C$0")));
        bounds.boundExactly(x17, x17_upper);

        TupleSet x18_upper = factory.noneOf(3);
        bounds.boundExactly(x18, x18_upper);

        TupleSet x19_upper = factory.noneOf(2);
        x19_upper.add(factory.tuple("open$3/Ord$0").product(factory.tuple("On$0")));
        bounds.boundExactly(x19, x19_upper);

        TupleSet x20_upper = factory.noneOf(3);
        x20_upper.add(factory.tuple("open$3/Ord$0").product(factory.tuple("On$0")).product(factory.tuple("Off$0")));
        bounds.boundExactly(x20, x20_upper);

        TupleSet x21_upper = factory.noneOf(1);
        x21_upper.add(factory.tuple("Trace$0"));
        x21_upper.add(factory.tuple("Trace$1"));
        x21_upper.add(factory.tuple("Trace$2"));
        x21_upper.add(factory.tuple("Trace$3"));
        x21_upper.add(factory.tuple("Trace$4"));
        x21_upper.add(factory.tuple("Trace$5"));
        x21_upper.add(factory.tuple("Trace$6"));
        x21_upper.add(factory.tuple("Trace$7"));
        x21_upper.add(factory.tuple("Trace$8"));
        x21_upper.add(factory.tuple("Trace$9"));
        bounds.bound(x21, x21_upper);

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

        Expression x24=x7.intersection(x8);
        Formula x23=x24.no();
        Variable x27=Variable.unary("show_this");
        Decls x26=x27.oneOf(x9);
        Expression x30=x27.join(x13);
        Formula x29=x30.one();
        Expression x32=x7.union(x8);
        Formula x31=x30.in(x32);
        Formula x28=x29.and(x31);
        Formula x25=x28.forAll(x26);
        Expression x34=x13.join(Expression.UNIV);
        Formula x33=x34.in(x9);
        Variable x38=Variable.unary("show_this");
        Decls x37=x38.oneOf(x9);
        Expression x41=x38.join(x14);
        Formula x40=x41.lone();
        Formula x42=x41.in(x6);
        Formula x39=x40.and(x42);
        Formula x36=x39.forAll(x37);
        Expression x44=x14.join(Expression.UNIV);
        Formula x43=x44.in(x9);
        Expression x47=x10.product(x15);
        Expression x46=x10.join(x47);
        Formula x45=x46.in(x9);
        Expression x50=x10.product(x16);
        Expression x49=x10.join(x50);
        Expression x51=x9.product(x9);
        Formula x48=x49.in(x51);
        Formula x52=x16.totalOrder(x9,x15,x21);
        Expression x54=x11.join(x17);
        Formula x53=x54.in(x6);
        Expression x56=x11.join(x18);
        Expression x57=x6.product(x6);
        Formula x55=x56.in(x57);
        Variable x62=Variable.unary("");
        Decls x61=x62.oneOf(x6);
        Expression x67=x11.join(x17);
        Formula x66=x62.eq(x67);
        Expression x70=x11.join(x18);
        Expression x69=x70.join(x62);
        Formula x68=x69.one();
        Formula x65=x66.or(x68);
        Expression x74=x70.join(x6);
        Expression x73=x6.difference(x74);
        Formula x72=x62.eq(x73);
        Expression x76=x62.join(x70);
        Formula x75=x76.one();
        Formula x71=x72.or(x75);
        Formula x64=x65.and(x71);
        Expression x80=x70.closure();
        Expression x79=x62.join(x80);
        Formula x78=x62.in(x79);
        Formula x77=x78.not();
        Formula x63=x64.and(x77);
        Formula x60=x63.forAll(x61);
        Expression x83=x70.reflexiveClosure();
        Expression x82=x67.join(x83);
        Formula x81=x6.in(x82);
        Formula x59=x60.and(x81);
        Expression x85=x70.join(x67);
        Formula x84=x85.no();
        Formula x58=x59.and(x84);
        Expression x87=x12.join(x19);
        Formula x86=x87.in(x32);
        Expression x89=x12.join(x20);
        Expression x90=x32.product(x32);
        Formula x88=x89.in(x90);
        Variable x95=Variable.unary("");
        Decls x94=x95.oneOf(x32);
        Expression x100=x12.join(x19);
        Formula x99=x95.eq(x100);
        Expression x103=x12.join(x20);
        Expression x102=x103.join(x95);
        Formula x101=x102.one();
        Formula x98=x99.or(x101);
        Expression x107=x103.join(x32);
        Expression x106=x32.difference(x107);
        Formula x105=x95.eq(x106);
        Expression x109=x95.join(x103);
        Formula x108=x109.one();
        Formula x104=x105.or(x108);
        Formula x97=x98.and(x104);
        Expression x113=x103.closure();
        Expression x112=x95.join(x113);
        Formula x111=x95.in(x112);
        Formula x110=x111.not();
        Formula x96=x97.and(x110);
        Formula x93=x96.forAll(x94);
        Expression x116=x103.reflexiveClosure();
        Expression x115=x100.join(x116);
        Formula x114=x32.in(x115);
        Formula x92=x93.and(x114);
        Expression x118=x103.join(x100);
        Formula x117=x118.no();
        Formula x91=x92.and(x117);
        Expression x120=x15.join(x13);
        Formula x119=x120.eq(x7);
        Expression x124=x16.join(x9);
        Expression x123=x9.difference(x124);
        Expression x122=x123.join(x14);
        Formula x121=x122.no();
        Variable x128=Variable.unary("show_t");
        Expression x129=x9.difference(x123);
        Decls x127=x128.oneOf(x129);
        Variable x131=Variable.unary("show_t'");
        Expression x132=x128.join(x16);
        Decls x130=x131.oneOf(x132);
        Decls x126=x127.and(x130);
        Variable x135=Variable.unary("show_e");
        Decls x134=x135.oneOf(x6);
        Expression x138=x128.join(x14);
        Formula x137=x138.eq(x135);
        Expression x140=x131.join(x13);
        Expression x142=x128.join(x14);
        Expression x144=x128.join(x13);
        Expression x147=x6.product(x8);
        Expression x146=x7.product(x147);
        Expression x149=x6.product(x7);
        Expression x148=x8.product(x149);
        Expression x145=x146.union(x148);
        Expression x143=x144.join(x145);
        Expression x141=x142.join(x143);
        Formula x139=x140.eq(x141);
        Formula x136=x137.and(x139);
        Formula x133=x136.forSome(x134);
        Formula x125=x133.forAll(x126);
        Variable x152=Variable.unary("show_t");
        Decls x151=x152.setOf(x9);
        Formula x150=Formula.TRUE.forSome(x151);
        Formula x154=x0.eq(x0);
        Formula x155=x1.eq(x1);
        Formula x156=x2.eq(x2);
        Formula x157=x3.eq(x3);
        Formula x158=x4.eq(x4);
        Formula x159=x5.eq(x5);
        Formula x160=x6.eq(x6);
        Formula x161=x7.eq(x7);
        Formula x162=x8.eq(x8);
        Formula x163=x9.eq(x9);
        Formula x164=x10.eq(x10);
        Formula x165=x11.eq(x11);
        Formula x166=x12.eq(x12);
        Formula x167=x13.eq(x13);
        Formula x168=x14.eq(x14);
        Formula x169=x15.eq(x15);
        Formula x170=x16.eq(x16);
        Formula x171=x17.eq(x17);
        Formula x172=x18.eq(x18);
        Formula x173=x19.eq(x19);
        Formula x174=x20.eq(x20);
        Formula x175=x21.eq(x21);
        Formula x22=Formula.compose(FormulaOperator.AND, x23, x25, x33, x36, x43, x45, x48, x52, x53, x55, x58, x86, x88, x91, x119, x121, x125, x150, x154, x155, x156, x157, x158, x159, x160, x161, x162, x163, x164, x165, x166, x167, x168, x169, x170, x171, x172, x173, x174, x175);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x22,bounds);
        System.out.println(sol.toString());
    }}