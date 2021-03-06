package kodkod.examples.models.softwareAbstractions.chapter6;

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
        Name = "ringElection2",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 5,
        TernaryRelations =1,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 7,
        TransitiveClosure = 3,
        NestedQuantifiers = 2,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 10,
        OrderedRelations = 2,
        Constraints = 17
)


public final class ringElection2AtMostOneElectedCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Time");
        Relation x7 = Relation.unary("this/Process");
        Relation x8 = Relation.unary("TO/Ord");
        Relation x9 = Relation.unary("PO/Ord");
        Relation x10 = Relation.nary("this/Process.succ", 2);
        Relation x11 = Relation.nary("this/Process.toSend", 3);
        Relation x12 = Relation.nary("this/Process.elected", 2);
        Relation x13 = Relation.unary("TO/Ord.First");
        Relation x14 = Relation.nary("TO/Ord.Next", 2);
        Relation x15 = Relation.unary("PO/Ord.First");
        Relation x16 = Relation.nary("PO/Ord.Next", 2);
        Relation x17 = Relation.unary("");
        Relation x18 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "PO/Ord$0",
                "Process$0", "Process$1", "Process$2", "TO/Ord$0", "Time$0", "Time$1",
                "Time$2", "Time$3", "Time$4", "Time$5", "Time$6"
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
        x6_upper.add(factory.tuple("Time$0"));
        x6_upper.add(factory.tuple("Time$1"));
        x6_upper.add(factory.tuple("Time$2"));
        x6_upper.add(factory.tuple("Time$3"));
        x6_upper.add(factory.tuple("Time$4"));
        x6_upper.add(factory.tuple("Time$5"));
        x6_upper.add(factory.tuple("Time$6"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Process$0"));
        x7_upper.add(factory.tuple("Process$1"));
        x7_upper.add(factory.tuple("Process$2"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("TO/Ord$0"));
        bounds.boundExactly(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("PO/Ord$0"));
        bounds.boundExactly(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(2);
        x10_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$0")));
        x10_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$1")));
        x10_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$2")));
        x10_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$0")));
        x10_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$1")));
        x10_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$2")));
        x10_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$0")));
        x10_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$1")));
        x10_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$2")));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(3);
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$0")).product(factory.tuple("Time$0")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$0")).product(factory.tuple("Time$1")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$0")).product(factory.tuple("Time$2")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$0")).product(factory.tuple("Time$3")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$0")).product(factory.tuple("Time$4")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$0")).product(factory.tuple("Time$5")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$0")).product(factory.tuple("Time$6")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$1")).product(factory.tuple("Time$0")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$1")).product(factory.tuple("Time$1")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$1")).product(factory.tuple("Time$2")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$1")).product(factory.tuple("Time$3")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$1")).product(factory.tuple("Time$4")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$1")).product(factory.tuple("Time$5")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$1")).product(factory.tuple("Time$6")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$2")).product(factory.tuple("Time$0")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$2")).product(factory.tuple("Time$1")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$2")).product(factory.tuple("Time$2")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$2")).product(factory.tuple("Time$3")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$2")).product(factory.tuple("Time$4")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$2")).product(factory.tuple("Time$5")));
        x11_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$2")).product(factory.tuple("Time$6")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$0")).product(factory.tuple("Time$0")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$0")).product(factory.tuple("Time$1")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$0")).product(factory.tuple("Time$2")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$0")).product(factory.tuple("Time$3")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$0")).product(factory.tuple("Time$4")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$0")).product(factory.tuple("Time$5")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$0")).product(factory.tuple("Time$6")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$1")).product(factory.tuple("Time$0")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$1")).product(factory.tuple("Time$1")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$1")).product(factory.tuple("Time$2")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$1")).product(factory.tuple("Time$3")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$1")).product(factory.tuple("Time$4")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$1")).product(factory.tuple("Time$5")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$1")).product(factory.tuple("Time$6")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$2")).product(factory.tuple("Time$0")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$2")).product(factory.tuple("Time$1")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$2")).product(factory.tuple("Time$2")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$2")).product(factory.tuple("Time$3")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$2")).product(factory.tuple("Time$4")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$2")).product(factory.tuple("Time$5")));
        x11_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$2")).product(factory.tuple("Time$6")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$0")).product(factory.tuple("Time$0")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$0")).product(factory.tuple("Time$1")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$0")).product(factory.tuple("Time$2")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$0")).product(factory.tuple("Time$3")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$0")).product(factory.tuple("Time$4")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$0")).product(factory.tuple("Time$5")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$0")).product(factory.tuple("Time$6")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$1")).product(factory.tuple("Time$0")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$1")).product(factory.tuple("Time$1")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$1")).product(factory.tuple("Time$2")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$1")).product(factory.tuple("Time$3")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$1")).product(factory.tuple("Time$4")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$1")).product(factory.tuple("Time$5")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$1")).product(factory.tuple("Time$6")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$2")).product(factory.tuple("Time$0")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$2")).product(factory.tuple("Time$1")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$2")).product(factory.tuple("Time$2")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$2")).product(factory.tuple("Time$3")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$2")).product(factory.tuple("Time$4")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$2")).product(factory.tuple("Time$5")));
        x11_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$2")).product(factory.tuple("Time$6")));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("Process$0").product(factory.tuple("Time$0")));
        x12_upper.add(factory.tuple("Process$0").product(factory.tuple("Time$1")));
        x12_upper.add(factory.tuple("Process$0").product(factory.tuple("Time$2")));
        x12_upper.add(factory.tuple("Process$0").product(factory.tuple("Time$3")));
        x12_upper.add(factory.tuple("Process$0").product(factory.tuple("Time$4")));
        x12_upper.add(factory.tuple("Process$0").product(factory.tuple("Time$5")));
        x12_upper.add(factory.tuple("Process$0").product(factory.tuple("Time$6")));
        x12_upper.add(factory.tuple("Process$1").product(factory.tuple("Time$0")));
        x12_upper.add(factory.tuple("Process$1").product(factory.tuple("Time$1")));
        x12_upper.add(factory.tuple("Process$1").product(factory.tuple("Time$2")));
        x12_upper.add(factory.tuple("Process$1").product(factory.tuple("Time$3")));
        x12_upper.add(factory.tuple("Process$1").product(factory.tuple("Time$4")));
        x12_upper.add(factory.tuple("Process$1").product(factory.tuple("Time$5")));
        x12_upper.add(factory.tuple("Process$1").product(factory.tuple("Time$6")));
        x12_upper.add(factory.tuple("Process$2").product(factory.tuple("Time$0")));
        x12_upper.add(factory.tuple("Process$2").product(factory.tuple("Time$1")));
        x12_upper.add(factory.tuple("Process$2").product(factory.tuple("Time$2")));
        x12_upper.add(factory.tuple("Process$2").product(factory.tuple("Time$3")));
        x12_upper.add(factory.tuple("Process$2").product(factory.tuple("Time$4")));
        x12_upper.add(factory.tuple("Process$2").product(factory.tuple("Time$5")));
        x12_upper.add(factory.tuple("Process$2").product(factory.tuple("Time$6")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(1);
        x13_upper.add(factory.tuple("Time$0"));
        x13_upper.add(factory.tuple("Time$1"));
        x13_upper.add(factory.tuple("Time$2"));
        x13_upper.add(factory.tuple("Time$3"));
        x13_upper.add(factory.tuple("Time$4"));
        x13_upper.add(factory.tuple("Time$5"));
        x13_upper.add(factory.tuple("Time$6"));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("Time$0").product(factory.tuple("Time$0")));
        x14_upper.add(factory.tuple("Time$0").product(factory.tuple("Time$1")));
        x14_upper.add(factory.tuple("Time$0").product(factory.tuple("Time$2")));
        x14_upper.add(factory.tuple("Time$0").product(factory.tuple("Time$3")));
        x14_upper.add(factory.tuple("Time$0").product(factory.tuple("Time$4")));
        x14_upper.add(factory.tuple("Time$0").product(factory.tuple("Time$5")));
        x14_upper.add(factory.tuple("Time$0").product(factory.tuple("Time$6")));
        x14_upper.add(factory.tuple("Time$1").product(factory.tuple("Time$0")));
        x14_upper.add(factory.tuple("Time$1").product(factory.tuple("Time$1")));
        x14_upper.add(factory.tuple("Time$1").product(factory.tuple("Time$2")));
        x14_upper.add(factory.tuple("Time$1").product(factory.tuple("Time$3")));
        x14_upper.add(factory.tuple("Time$1").product(factory.tuple("Time$4")));
        x14_upper.add(factory.tuple("Time$1").product(factory.tuple("Time$5")));
        x14_upper.add(factory.tuple("Time$1").product(factory.tuple("Time$6")));
        x14_upper.add(factory.tuple("Time$2").product(factory.tuple("Time$0")));
        x14_upper.add(factory.tuple("Time$2").product(factory.tuple("Time$1")));
        x14_upper.add(factory.tuple("Time$2").product(factory.tuple("Time$2")));
        x14_upper.add(factory.tuple("Time$2").product(factory.tuple("Time$3")));
        x14_upper.add(factory.tuple("Time$2").product(factory.tuple("Time$4")));
        x14_upper.add(factory.tuple("Time$2").product(factory.tuple("Time$5")));
        x14_upper.add(factory.tuple("Time$2").product(factory.tuple("Time$6")));
        x14_upper.add(factory.tuple("Time$3").product(factory.tuple("Time$0")));
        x14_upper.add(factory.tuple("Time$3").product(factory.tuple("Time$1")));
        x14_upper.add(factory.tuple("Time$3").product(factory.tuple("Time$2")));
        x14_upper.add(factory.tuple("Time$3").product(factory.tuple("Time$3")));
        x14_upper.add(factory.tuple("Time$3").product(factory.tuple("Time$4")));
        x14_upper.add(factory.tuple("Time$3").product(factory.tuple("Time$5")));
        x14_upper.add(factory.tuple("Time$3").product(factory.tuple("Time$6")));
        x14_upper.add(factory.tuple("Time$4").product(factory.tuple("Time$0")));
        x14_upper.add(factory.tuple("Time$4").product(factory.tuple("Time$1")));
        x14_upper.add(factory.tuple("Time$4").product(factory.tuple("Time$2")));
        x14_upper.add(factory.tuple("Time$4").product(factory.tuple("Time$3")));
        x14_upper.add(factory.tuple("Time$4").product(factory.tuple("Time$4")));
        x14_upper.add(factory.tuple("Time$4").product(factory.tuple("Time$5")));
        x14_upper.add(factory.tuple("Time$4").product(factory.tuple("Time$6")));
        x14_upper.add(factory.tuple("Time$5").product(factory.tuple("Time$0")));
        x14_upper.add(factory.tuple("Time$5").product(factory.tuple("Time$1")));
        x14_upper.add(factory.tuple("Time$5").product(factory.tuple("Time$2")));
        x14_upper.add(factory.tuple("Time$5").product(factory.tuple("Time$3")));
        x14_upper.add(factory.tuple("Time$5").product(factory.tuple("Time$4")));
        x14_upper.add(factory.tuple("Time$5").product(factory.tuple("Time$5")));
        x14_upper.add(factory.tuple("Time$5").product(factory.tuple("Time$6")));
        x14_upper.add(factory.tuple("Time$6").product(factory.tuple("Time$0")));
        x14_upper.add(factory.tuple("Time$6").product(factory.tuple("Time$1")));
        x14_upper.add(factory.tuple("Time$6").product(factory.tuple("Time$2")));
        x14_upper.add(factory.tuple("Time$6").product(factory.tuple("Time$3")));
        x14_upper.add(factory.tuple("Time$6").product(factory.tuple("Time$4")));
        x14_upper.add(factory.tuple("Time$6").product(factory.tuple("Time$5")));
        x14_upper.add(factory.tuple("Time$6").product(factory.tuple("Time$6")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(1);
        x15_upper.add(factory.tuple("Process$0"));
        x15_upper.add(factory.tuple("Process$1"));
        x15_upper.add(factory.tuple("Process$2"));
        bounds.bound(x15, x15_upper);

        TupleSet x16_upper = factory.noneOf(2);
        x16_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$0")));
        x16_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$1")));
        x16_upper.add(factory.tuple("Process$0").product(factory.tuple("Process$2")));
        x16_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$0")));
        x16_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$1")));
        x16_upper.add(factory.tuple("Process$1").product(factory.tuple("Process$2")));
        x16_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$0")));
        x16_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$1")));
        x16_upper.add(factory.tuple("Process$2").product(factory.tuple("Process$2")));
        bounds.bound(x16, x16_upper);

        TupleSet x17_upper = factory.noneOf(1);
        x17_upper.add(factory.tuple("Time$0"));
        x17_upper.add(factory.tuple("Time$1"));
        x17_upper.add(factory.tuple("Time$2"));
        x17_upper.add(factory.tuple("Time$3"));
        x17_upper.add(factory.tuple("Time$4"));
        x17_upper.add(factory.tuple("Time$5"));
        x17_upper.add(factory.tuple("Time$6"));
        bounds.bound(x17, x17_upper);

        TupleSet x18_upper = factory.noneOf(1);
        x18_upper.add(factory.tuple("Process$0"));
        x18_upper.add(factory.tuple("Process$1"));
        x18_upper.add(factory.tuple("Process$2"));
        bounds.bound(x18, x18_upper);

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

        Variable x22=Variable.unary("AtMostOneElected_this");
        Decls x21=x22.oneOf(x7);
        Expression x25=x22.join(x10);
        Formula x24=x25.one();
        Formula x26=x25.in(x7);
        Formula x23=x24.and(x26);
        Formula x20=x23.forAll(x21);
        Expression x28=x10.join(Expression.UNIV);
        Formula x27=x28.in(x7);
        Variable x32=Variable.unary("AtMostOneElected_this");
        Decls x31=x32.oneOf(x7);
        Expression x34=x32.join(x11);
        Expression x35=x7.product(x6);
        Formula x33=x34.in(x35);
        Formula x30=x33.forAll(x31);
        Expression x38=x11.join(Expression.UNIV);
        Expression x37=x38.join(Expression.UNIV);
        Formula x36=x37.in(x7);
        Variable x41=Variable.unary("AtMostOneElected_this");
        Decls x40=x41.oneOf(x7);
        Expression x43=x41.join(x12);
        Formula x42=x43.in(x6);
        Formula x39=x42.forAll(x40);
        Expression x45=x12.join(Expression.UNIV);
        Formula x44=x45.in(x7);
        Expression x48=x8.product(x13);
        Expression x47=x8.join(x48);
        Formula x46=x47.in(x6);
        Expression x51=x8.product(x14);
        Expression x50=x8.join(x51);
        Expression x52=x6.product(x6);
        Formula x49=x50.in(x52);
        Formula x53=x14.totalOrder(x6,x13,x17);
        Expression x56=x9.product(x15);
        Expression x55=x9.join(x56);
        Formula x54=x55.in(x7);
        Expression x59=x9.product(x16);
        Expression x58=x9.join(x59);
        Expression x60=x7.product(x7);
        Formula x57=x58.in(x60);
        Formula x61=x16.totalOrder(x7,x15,x18);
        Variable x64=Variable.unary("AtMostOneElected_p");
        Decls x63=x64.oneOf(x7);
        Expression x67=x10.closure();
        Expression x66=x64.join(x67);
        Formula x65=x7.in(x66);
        Formula x62=x65.forAll(x63);
        Expression x69=x12.join(x13);
        Formula x68=x69.no();
        Variable x72=Variable.unary("AtMostOneElected_t");
        Expression x73=x6.difference(x13);
        Decls x71=x72.oneOf(x73);
        Expression x75=x12.join(x72);
        Variable x78=Variable.unary("AtMostOneElected_p");
        Decls x77=x78.oneOf(x7);
        Expression x82=x78.join(x11);
        Expression x81=x82.join(x72);
        Expression x84=x78.join(x11);
        Expression x86=x14.transpose();
        Expression x85=x72.join(x86);
        Expression x83=x84.join(x85);
        Expression x80=x81.difference(x83);
        Formula x79=x78.in(x80);
        Expression x76=x79.comprehension(x77);
        Formula x74=x75.eq(x76);
        Formula x70=x74.forAll(x71);
        Variable x89=Variable.unary("init_p");
        Decls x88=x89.oneOf(x7);
        Expression x92=x89.join(x11);
        Expression x91=x92.join(x13);
        Formula x90=x91.eq(x89);
        Formula x87=x90.forAll(x88);
        Variable x95=Variable.unary("AtMostOneElected_t");
        Expression x98=x14.join(x6);
        Expression x97=x6.difference(x98);
        Expression x96=x6.difference(x97);
        Decls x94=x95.oneOf(x96);
        Variable x101=Variable.unary("AtMostOneElected_p");
        Decls x100=x101.oneOf(x7);
        Variable x106=Variable.unary("step_id");
        Expression x108=x101.join(x11);
        Expression x107=x108.join(x95);
        Decls x105=x106.oneOf(x107);
        Expression x112=x95.join(x14);
        Expression x111=x108.join(x112);
        Expression x114=x108.join(x95);
        Expression x113=x114.difference(x106);
        Formula x110=x111.eq(x113);
        Expression x118=x101.join(x10);
        Expression x117=x118.join(x11);
        Expression x116=x117.join(x112);
        Expression x120=x117.join(x95);
        Expression x123=x101.join(x10);
        Expression x125=x16.transpose();
        Expression x124=x125.closure();
        Expression x122=x123.join(x124);
        Expression x121=x106.difference(x122);
        Expression x119=x120.union(x121);
        Formula x115=x116.eq(x119);
        Formula x109=x110.and(x115);
        Formula x104=x109.forSome(x105);
        Variable x128=Variable.unary("step_id");
        Expression x131=x10.join(x101);
        Expression x130=x131.join(x11);
        Expression x129=x130.join(x95);
        Decls x127=x128.oneOf(x129);
        Expression x134=x130.join(x112);
        Expression x136=x130.join(x95);
        Expression x135=x136.difference(x128);
        Formula x133=x134.eq(x135);
        Expression x140=x131.join(x10);
        Expression x139=x140.join(x11);
        Expression x138=x139.join(x112);
        Expression x142=x139.join(x95);
        Expression x145=x131.join(x10);
        Expression x147=x16.transpose();
        Expression x146=x147.closure();
        Expression x144=x145.join(x146);
        Expression x143=x128.difference(x144);
        Expression x141=x142.union(x143);
        Formula x137=x138.eq(x141);
        Formula x132=x133.and(x137);
        Formula x126=x132.forSome(x127);
        Formula x103=x104.or(x126);
        Expression x150=x101.join(x11);
        Expression x149=x150.join(x95);
        Expression x152=x101.join(x11);
        Expression x151=x152.join(x112);
        Formula x148=x149.eq(x151);
        Formula x102=x103.or(x148);
        Formula x99=x102.forAll(x100);
        Formula x93=x99.forAll(x94);
        Expression x155=x12.join(x6);
        Formula x154=x155.lone();
        Formula x153=x154.not();
        Formula x156=x0.eq(x0);
        Formula x157=x1.eq(x1);
        Formula x158=x2.eq(x2);
        Formula x159=x3.eq(x3);
        Formula x160=x4.eq(x4);
        Formula x161=x5.eq(x5);
        Formula x162=x6.eq(x6);
        Formula x163=x7.eq(x7);
        Formula x164=x8.eq(x8);
        Formula x165=x9.eq(x9);
        Formula x166=x10.eq(x10);
        Formula x167=x11.eq(x11);
        Formula x168=x12.eq(x12);
        Formula x169=x13.eq(x13);
        Formula x170=x14.eq(x14);
        Formula x171=x15.eq(x15);
        Formula x172=x16.eq(x16);
        Formula x173=x17.eq(x17);
        Formula x174=x18.eq(x18);
        Formula x19=Formula.compose(FormulaOperator.AND, x20, x27, x30, x36, x39, x44, x46, x49, x53, x54, x57, x61, x62, x68, x70, x87, x93, x153, x156, x157, x158, x159, x160, x161, x162, x163, x164, x165, x166, x167, x168, x169, x170, x171, x172, x173, x174);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x19,bounds);
        System.out.println(sol.toString());
    }}