package kodkod.examples.models.puzzle.halmosHandshake;

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
        Name = "handshake",
        Note = "",
        IsCheck =false,
        PartialModel = true,
        BinaryRelations = 3,
        TernaryRelations = 0,
        NaryRelations = 0,
        HierarchicalTypes =2,
        NestedRelationalJoins = 1,
        TransitiveClosure = 0,
        NestedQuantifiers = 1,
        SetCardinality = 2,
        Additions = 0,
        Subtractions = 0,
        Comparison = 8,
        OrderedRelations = 0,
        Constraints = 9
)


public final class handshakeP10Run {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Jocelyn");
        Relation x7 = Relation.unary("this/Hilary");
        Relation x8 = Relation.unary("this/Person remainder");
        Relation x9 = Relation.nary("this/Person.spouse", 2);
        Relation x10 = Relation.nary("this/Person.shaken", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-10", "-11", "-12", "-13",
                "-14", "-15", "-16", "-2", "-3", "-4",
                "-5", "-6", "-7", "-8", "-9", "0",
                "1", "10", "11", "12", "13", "14",
                "15", "2", "3", "4", "5", "6",
                "7", "8", "9", "Hilary$0", "Jocelyn$0", "Person$0",
                "Person$1", "Person$2", "Person$3", "Person$4", "Person$5", "Person$6",
                "Person$7"
        );

        Universe universe = new Universe(atomlist);
        TupleFactory factory = universe.factory();
        Bounds bounds = new Bounds(universe);

        TupleSet x0_upper = factory.noneOf(1);
        x0_upper.add(factory.tuple("-16"));
        bounds.boundExactly(x0, x0_upper);

        TupleSet x1_upper = factory.noneOf(1);
        x1_upper.add(factory.tuple("0"));
        bounds.boundExactly(x1, x1_upper);

        TupleSet x2_upper = factory.noneOf(1);
        x2_upper.add(factory.tuple("15"));
        bounds.boundExactly(x2, x2_upper);

        TupleSet x3_upper = factory.noneOf(2);
        x3_upper.add(factory.tuple("-16").product(factory.tuple("-15")));
        x3_upper.add(factory.tuple("-15").product(factory.tuple("-14")));
        x3_upper.add(factory.tuple("-14").product(factory.tuple("-13")));
        x3_upper.add(factory.tuple("-13").product(factory.tuple("-12")));
        x3_upper.add(factory.tuple("-12").product(factory.tuple("-11")));
        x3_upper.add(factory.tuple("-11").product(factory.tuple("-10")));
        x3_upper.add(factory.tuple("-10").product(factory.tuple("-9")));
        x3_upper.add(factory.tuple("-9").product(factory.tuple("-8")));
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
        x3_upper.add(factory.tuple("7").product(factory.tuple("8")));
        x3_upper.add(factory.tuple("8").product(factory.tuple("9")));
        x3_upper.add(factory.tuple("9").product(factory.tuple("10")));
        x3_upper.add(factory.tuple("10").product(factory.tuple("11")));
        x3_upper.add(factory.tuple("11").product(factory.tuple("12")));
        x3_upper.add(factory.tuple("12").product(factory.tuple("13")));
        x3_upper.add(factory.tuple("13").product(factory.tuple("14")));
        x3_upper.add(factory.tuple("14").product(factory.tuple("15")));
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
        x6_upper.add(factory.tuple("Jocelyn$0"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Hilary$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Person$0"));
        x8_upper.add(factory.tuple("Person$1"));
        x8_upper.add(factory.tuple("Person$2"));
        x8_upper.add(factory.tuple("Person$3"));
        x8_upper.add(factory.tuple("Person$4"));
        x8_upper.add(factory.tuple("Person$5"));
        x8_upper.add(factory.tuple("Person$6"));
        x8_upper.add(factory.tuple("Person$7"));
        bounds.boundExactly(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(2);
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$7")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$7")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$7")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$7")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$7")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$7")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$7")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$7")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$7")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Jocelyn$0")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Hilary$0")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$0")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$1")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$2")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$3")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$4")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$5")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$6")));
        x9_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$7")));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(2);
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Jocelyn$0").product(factory.tuple("Person$7")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Hilary$0").product(factory.tuple("Person$7")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$7")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$7")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$7")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$7")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Person$4").product(factory.tuple("Person$7")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Person$5").product(factory.tuple("Person$7")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Person$6").product(factory.tuple("Person$7")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Jocelyn$0")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Hilary$0")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$4")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$5")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$6")));
        x10_upper.add(factory.tuple("Person$7").product(factory.tuple("Person$7")));
        bounds.bound(x10, x10_upper);

        bounds.boundExactly(-16,factory.range(factory.tuple("-16"),factory.tuple("-16")));
        bounds.boundExactly(-15,factory.range(factory.tuple("-15"),factory.tuple("-15")));
        bounds.boundExactly(-14,factory.range(factory.tuple("-14"),factory.tuple("-14")));
        bounds.boundExactly(-13,factory.range(factory.tuple("-13"),factory.tuple("-13")));
        bounds.boundExactly(-12,factory.range(factory.tuple("-12"),factory.tuple("-12")));
        bounds.boundExactly(-11,factory.range(factory.tuple("-11"),factory.tuple("-11")));
        bounds.boundExactly(-10,factory.range(factory.tuple("-10"),factory.tuple("-10")));
        bounds.boundExactly(-9,factory.range(factory.tuple("-9"),factory.tuple("-9")));
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
        bounds.boundExactly(8,factory.range(factory.tuple("8"),factory.tuple("8")));
        bounds.boundExactly(9,factory.range(factory.tuple("9"),factory.tuple("9")));
        bounds.boundExactly(10,factory.range(factory.tuple("10"),factory.tuple("10")));
        bounds.boundExactly(11,factory.range(factory.tuple("11"),factory.tuple("11")));
        bounds.boundExactly(12,factory.range(factory.tuple("12"),factory.tuple("12")));
        bounds.boundExactly(13,factory.range(factory.tuple("13"),factory.tuple("13")));
        bounds.boundExactly(14,factory.range(factory.tuple("14"),factory.tuple("14")));
        bounds.boundExactly(15,factory.range(factory.tuple("15"),factory.tuple("15")));

        Expression x13=x6.intersection(x7);
        Formula x12=x13.no();
        Variable x16=Variable.unary("P10_this");
        Expression x18=x6.union(x7);
        Expression x17=x18.union(x8);
        Decls x15=x16.oneOf(x17);
        Expression x21=x16.join(x9);
        Formula x20=x21.one();
        Formula x22=x21.in(x17);
        Formula x19=x20.and(x22);
        Formula x14=x19.forAll(x15);
        Expression x24=x9.join(Expression.UNIV);
        Formula x23=x24.in(x17);
        Variable x28=Variable.unary("P10_this");
        Decls x27=x28.oneOf(x17);
        Expression x30=x28.join(x10);
        Formula x29=x30.in(x17);
        Formula x26=x29.forAll(x27);
        Expression x32=x10.join(Expression.UNIV);
        Formula x31=x32.in(x17);
        Variable x35=Variable.unary("P10_p");
        Decls x34=x35.oneOf(x17);
        Expression x39=x35.join(x9);
        Expression x38=x35.union(x39);
        Expression x40=x35.join(x10);
        Expression x37=x38.intersection(x40);
        Formula x36=x37.no();
        Formula x33=x36.forAll(x34);
        Variable x44=Variable.unary("P10_p");
        Decls x43=x44.oneOf(x17);
        Variable x46=Variable.unary("P10_q");
        Decls x45=x46.oneOf(x17);
        Decls x42=x43.and(x45);
        Expression x50=x46.join(x10);
        Formula x49=x44.in(x50);
        Formula x48=x49.not();
        Expression x52=x44.join(x10);
        Formula x51=x46.in(x52);
        Formula x47=x48.or(x51);
        Formula x41=x47.forAll(x42);
        Variable x56=Variable.unary("P10_p");
        Decls x55=x56.oneOf(x17);
        Variable x58=Variable.unary("P10_q");
        Decls x57=x58.oneOf(x17);
        Decls x54=x55.and(x57);
        Formula x62=x56.eq(x58);
        Formula x61=x62.not();
        Formula x60=x61.not();
        Expression x67=x56.join(x9);
        Formula x66=x67.eq(x58);
        Formula x65=x66.not();
        Expression x69=x58.join(x9);
        Formula x68=x69.eq(x56);
        Formula x64=x65.or(x68);
        Expression x72=x56.join(x9);
        Expression x73=x58.join(x9);
        Formula x71=x72.eq(x73);
        Formula x70=x71.not();
        Formula x63=x64.and(x70);
        Formula x59=x60.or(x63);
        Formula x53=x59.forAll(x54);
        Variable x76=Variable.unary("P10_p");
        Decls x75=x76.oneOf(x17);
        Expression x80=x76.join(x9);
        Expression x79=x80.join(x9);
        Formula x78=x79.eq(x76);
        Expression x83=x76.join(x9);
        Formula x82=x76.eq(x83);
        Formula x81=x82.not();
        Formula x77=x78.and(x81);
        Formula x74=x77.forAll(x75);
        Variable x87=Variable.unary("P10_p");
        Expression x88=x17.difference(x6);
        Decls x86=x87.oneOf(x88);
        Variable x90=Variable.unary("P10_q");
        Decls x89=x90.oneOf(x88);
        Decls x85=x86.and(x89);
        Formula x94=x87.eq(x90);
        Formula x93=x94.not();
        Formula x92=x93.not();
        Expression x98=x87.join(x10);
        IntExpression x97=x98.count();
        Expression x100=x90.join(x10);
        IntExpression x99=x100.count();
        Formula x96=x97.eq(x99);
        Formula x95=x96.not();
        Formula x91=x92.or(x95);
        Formula x84=x91.forAll(x85);
        Expression x102=x7.join(x9);
        Formula x101=x102.eq(x6);
        Formula x103=x0.eq(x0);
        Formula x104=x1.eq(x1);
        Formula x105=x2.eq(x2);
        Formula x106=x3.eq(x3);
        Formula x107=x4.eq(x4);
        Formula x108=x5.eq(x5);
        Formula x109=x6.eq(x6);
        Formula x110=x7.eq(x7);
        Formula x111=x8.eq(x8);
        Formula x112=x9.eq(x9);
        Formula x113=x10.eq(x10);
        Formula x11=Formula.compose(FormulaOperator.AND, x12, x14, x23, x26, x31, x33, x41, x53, x74, x84, x101, x103, x104, x105, x106, x107, x108, x109, x110, x111, x112, x113);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(5);
       // solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x11,bounds);
        System.out.println(sol.toString());
    }}