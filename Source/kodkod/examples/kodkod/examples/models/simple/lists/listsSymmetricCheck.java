package kodkod.examples.models.simple.lists;

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
        Name = "lists",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 5,
        TernaryRelations = 0,
        NaryRelations = 0,
        HierarchicalTypes =2,
        NestedRelationalJoins = 2,
        TransitiveClosure = 5,
        NestedQuantifiers = 0,
        SetCardinality = 4,
        Additions = 0,
        Subtractions = 0,
        Comparison = 4,
        OrderedRelations = 0,
        Constraints = 15
)


public final class listsSymmetricCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Thing");
        Relation x7 = Relation.unary("this/NonEmptyList");
        Relation x8 = Relation.unary("this/EmptyList");
        Relation x9 = Relation.nary("this/List.equivTo", 2);
        Relation x10 = Relation.nary("this/List.prefixes", 2);
        Relation x11 = Relation.nary("this/NonEmptyList.car", 2);
        Relation x12 = Relation.nary("this/NonEmptyList.cdr", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "List$0",
                "List$1", "List$2", "List$3", "List$4", "List$5", "Thing$0",
                "Thing$1", "Thing$2", "Thing$3", "Thing$4", "Thing$5"
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
        bounds.boundExactly(x4, x4_upper);

        TupleSet x5_upper = factory.noneOf(1);
        bounds.boundExactly(x5, x5_upper);

        TupleSet x6_upper = factory.noneOf(1);
        x6_upper.add(factory.tuple("Thing$0"));
        x6_upper.add(factory.tuple("Thing$1"));
        x6_upper.add(factory.tuple("Thing$2"));
        x6_upper.add(factory.tuple("Thing$3"));
        x6_upper.add(factory.tuple("Thing$4"));
        x6_upper.add(factory.tuple("Thing$5"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("List$0"));
        x7_upper.add(factory.tuple("List$1"));
        x7_upper.add(factory.tuple("List$2"));
        x7_upper.add(factory.tuple("List$3"));
        x7_upper.add(factory.tuple("List$4"));
        x7_upper.add(factory.tuple("List$5"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("List$0"));
        x8_upper.add(factory.tuple("List$1"));
        x8_upper.add(factory.tuple("List$2"));
        x8_upper.add(factory.tuple("List$3"));
        x8_upper.add(factory.tuple("List$4"));
        x8_upper.add(factory.tuple("List$5"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(2);
        x9_upper.add(factory.tuple("List$0").product(factory.tuple("List$0")));
        x9_upper.add(factory.tuple("List$0").product(factory.tuple("List$1")));
        x9_upper.add(factory.tuple("List$0").product(factory.tuple("List$2")));
        x9_upper.add(factory.tuple("List$0").product(factory.tuple("List$3")));
        x9_upper.add(factory.tuple("List$0").product(factory.tuple("List$4")));
        x9_upper.add(factory.tuple("List$0").product(factory.tuple("List$5")));
        x9_upper.add(factory.tuple("List$1").product(factory.tuple("List$0")));
        x9_upper.add(factory.tuple("List$1").product(factory.tuple("List$1")));
        x9_upper.add(factory.tuple("List$1").product(factory.tuple("List$2")));
        x9_upper.add(factory.tuple("List$1").product(factory.tuple("List$3")));
        x9_upper.add(factory.tuple("List$1").product(factory.tuple("List$4")));
        x9_upper.add(factory.tuple("List$1").product(factory.tuple("List$5")));
        x9_upper.add(factory.tuple("List$2").product(factory.tuple("List$0")));
        x9_upper.add(factory.tuple("List$2").product(factory.tuple("List$1")));
        x9_upper.add(factory.tuple("List$2").product(factory.tuple("List$2")));
        x9_upper.add(factory.tuple("List$2").product(factory.tuple("List$3")));
        x9_upper.add(factory.tuple("List$2").product(factory.tuple("List$4")));
        x9_upper.add(factory.tuple("List$2").product(factory.tuple("List$5")));
        x9_upper.add(factory.tuple("List$3").product(factory.tuple("List$0")));
        x9_upper.add(factory.tuple("List$3").product(factory.tuple("List$1")));
        x9_upper.add(factory.tuple("List$3").product(factory.tuple("List$2")));
        x9_upper.add(factory.tuple("List$3").product(factory.tuple("List$3")));
        x9_upper.add(factory.tuple("List$3").product(factory.tuple("List$4")));
        x9_upper.add(factory.tuple("List$3").product(factory.tuple("List$5")));
        x9_upper.add(factory.tuple("List$4").product(factory.tuple("List$0")));
        x9_upper.add(factory.tuple("List$4").product(factory.tuple("List$1")));
        x9_upper.add(factory.tuple("List$4").product(factory.tuple("List$2")));
        x9_upper.add(factory.tuple("List$4").product(factory.tuple("List$3")));
        x9_upper.add(factory.tuple("List$4").product(factory.tuple("List$4")));
        x9_upper.add(factory.tuple("List$4").product(factory.tuple("List$5")));
        x9_upper.add(factory.tuple("List$5").product(factory.tuple("List$0")));
        x9_upper.add(factory.tuple("List$5").product(factory.tuple("List$1")));
        x9_upper.add(factory.tuple("List$5").product(factory.tuple("List$2")));
        x9_upper.add(factory.tuple("List$5").product(factory.tuple("List$3")));
        x9_upper.add(factory.tuple("List$5").product(factory.tuple("List$4")));
        x9_upper.add(factory.tuple("List$5").product(factory.tuple("List$5")));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(2);
        x10_upper.add(factory.tuple("List$0").product(factory.tuple("List$0")));
        x10_upper.add(factory.tuple("List$0").product(factory.tuple("List$1")));
        x10_upper.add(factory.tuple("List$0").product(factory.tuple("List$2")));
        x10_upper.add(factory.tuple("List$0").product(factory.tuple("List$3")));
        x10_upper.add(factory.tuple("List$0").product(factory.tuple("List$4")));
        x10_upper.add(factory.tuple("List$0").product(factory.tuple("List$5")));
        x10_upper.add(factory.tuple("List$1").product(factory.tuple("List$0")));
        x10_upper.add(factory.tuple("List$1").product(factory.tuple("List$1")));
        x10_upper.add(factory.tuple("List$1").product(factory.tuple("List$2")));
        x10_upper.add(factory.tuple("List$1").product(factory.tuple("List$3")));
        x10_upper.add(factory.tuple("List$1").product(factory.tuple("List$4")));
        x10_upper.add(factory.tuple("List$1").product(factory.tuple("List$5")));
        x10_upper.add(factory.tuple("List$2").product(factory.tuple("List$0")));
        x10_upper.add(factory.tuple("List$2").product(factory.tuple("List$1")));
        x10_upper.add(factory.tuple("List$2").product(factory.tuple("List$2")));
        x10_upper.add(factory.tuple("List$2").product(factory.tuple("List$3")));
        x10_upper.add(factory.tuple("List$2").product(factory.tuple("List$4")));
        x10_upper.add(factory.tuple("List$2").product(factory.tuple("List$5")));
        x10_upper.add(factory.tuple("List$3").product(factory.tuple("List$0")));
        x10_upper.add(factory.tuple("List$3").product(factory.tuple("List$1")));
        x10_upper.add(factory.tuple("List$3").product(factory.tuple("List$2")));
        x10_upper.add(factory.tuple("List$3").product(factory.tuple("List$3")));
        x10_upper.add(factory.tuple("List$3").product(factory.tuple("List$4")));
        x10_upper.add(factory.tuple("List$3").product(factory.tuple("List$5")));
        x10_upper.add(factory.tuple("List$4").product(factory.tuple("List$0")));
        x10_upper.add(factory.tuple("List$4").product(factory.tuple("List$1")));
        x10_upper.add(factory.tuple("List$4").product(factory.tuple("List$2")));
        x10_upper.add(factory.tuple("List$4").product(factory.tuple("List$3")));
        x10_upper.add(factory.tuple("List$4").product(factory.tuple("List$4")));
        x10_upper.add(factory.tuple("List$4").product(factory.tuple("List$5")));
        x10_upper.add(factory.tuple("List$5").product(factory.tuple("List$0")));
        x10_upper.add(factory.tuple("List$5").product(factory.tuple("List$1")));
        x10_upper.add(factory.tuple("List$5").product(factory.tuple("List$2")));
        x10_upper.add(factory.tuple("List$5").product(factory.tuple("List$3")));
        x10_upper.add(factory.tuple("List$5").product(factory.tuple("List$4")));
        x10_upper.add(factory.tuple("List$5").product(factory.tuple("List$5")));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(2);
        x11_upper.add(factory.tuple("List$0").product(factory.tuple("Thing$0")));
        x11_upper.add(factory.tuple("List$0").product(factory.tuple("Thing$1")));
        x11_upper.add(factory.tuple("List$0").product(factory.tuple("Thing$2")));
        x11_upper.add(factory.tuple("List$0").product(factory.tuple("Thing$3")));
        x11_upper.add(factory.tuple("List$0").product(factory.tuple("Thing$4")));
        x11_upper.add(factory.tuple("List$0").product(factory.tuple("Thing$5")));
        x11_upper.add(factory.tuple("List$1").product(factory.tuple("Thing$0")));
        x11_upper.add(factory.tuple("List$1").product(factory.tuple("Thing$1")));
        x11_upper.add(factory.tuple("List$1").product(factory.tuple("Thing$2")));
        x11_upper.add(factory.tuple("List$1").product(factory.tuple("Thing$3")));
        x11_upper.add(factory.tuple("List$1").product(factory.tuple("Thing$4")));
        x11_upper.add(factory.tuple("List$1").product(factory.tuple("Thing$5")));
        x11_upper.add(factory.tuple("List$2").product(factory.tuple("Thing$0")));
        x11_upper.add(factory.tuple("List$2").product(factory.tuple("Thing$1")));
        x11_upper.add(factory.tuple("List$2").product(factory.tuple("Thing$2")));
        x11_upper.add(factory.tuple("List$2").product(factory.tuple("Thing$3")));
        x11_upper.add(factory.tuple("List$2").product(factory.tuple("Thing$4")));
        x11_upper.add(factory.tuple("List$2").product(factory.tuple("Thing$5")));
        x11_upper.add(factory.tuple("List$3").product(factory.tuple("Thing$0")));
        x11_upper.add(factory.tuple("List$3").product(factory.tuple("Thing$1")));
        x11_upper.add(factory.tuple("List$3").product(factory.tuple("Thing$2")));
        x11_upper.add(factory.tuple("List$3").product(factory.tuple("Thing$3")));
        x11_upper.add(factory.tuple("List$3").product(factory.tuple("Thing$4")));
        x11_upper.add(factory.tuple("List$3").product(factory.tuple("Thing$5")));
        x11_upper.add(factory.tuple("List$4").product(factory.tuple("Thing$0")));
        x11_upper.add(factory.tuple("List$4").product(factory.tuple("Thing$1")));
        x11_upper.add(factory.tuple("List$4").product(factory.tuple("Thing$2")));
        x11_upper.add(factory.tuple("List$4").product(factory.tuple("Thing$3")));
        x11_upper.add(factory.tuple("List$4").product(factory.tuple("Thing$4")));
        x11_upper.add(factory.tuple("List$4").product(factory.tuple("Thing$5")));
        x11_upper.add(factory.tuple("List$5").product(factory.tuple("Thing$0")));
        x11_upper.add(factory.tuple("List$5").product(factory.tuple("Thing$1")));
        x11_upper.add(factory.tuple("List$5").product(factory.tuple("Thing$2")));
        x11_upper.add(factory.tuple("List$5").product(factory.tuple("Thing$3")));
        x11_upper.add(factory.tuple("List$5").product(factory.tuple("Thing$4")));
        x11_upper.add(factory.tuple("List$5").product(factory.tuple("Thing$5")));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("List$0").product(factory.tuple("List$0")));
        x12_upper.add(factory.tuple("List$0").product(factory.tuple("List$1")));
        x12_upper.add(factory.tuple("List$0").product(factory.tuple("List$2")));
        x12_upper.add(factory.tuple("List$0").product(factory.tuple("List$3")));
        x12_upper.add(factory.tuple("List$0").product(factory.tuple("List$4")));
        x12_upper.add(factory.tuple("List$0").product(factory.tuple("List$5")));
        x12_upper.add(factory.tuple("List$1").product(factory.tuple("List$0")));
        x12_upper.add(factory.tuple("List$1").product(factory.tuple("List$1")));
        x12_upper.add(factory.tuple("List$1").product(factory.tuple("List$2")));
        x12_upper.add(factory.tuple("List$1").product(factory.tuple("List$3")));
        x12_upper.add(factory.tuple("List$1").product(factory.tuple("List$4")));
        x12_upper.add(factory.tuple("List$1").product(factory.tuple("List$5")));
        x12_upper.add(factory.tuple("List$2").product(factory.tuple("List$0")));
        x12_upper.add(factory.tuple("List$2").product(factory.tuple("List$1")));
        x12_upper.add(factory.tuple("List$2").product(factory.tuple("List$2")));
        x12_upper.add(factory.tuple("List$2").product(factory.tuple("List$3")));
        x12_upper.add(factory.tuple("List$2").product(factory.tuple("List$4")));
        x12_upper.add(factory.tuple("List$2").product(factory.tuple("List$5")));
        x12_upper.add(factory.tuple("List$3").product(factory.tuple("List$0")));
        x12_upper.add(factory.tuple("List$3").product(factory.tuple("List$1")));
        x12_upper.add(factory.tuple("List$3").product(factory.tuple("List$2")));
        x12_upper.add(factory.tuple("List$3").product(factory.tuple("List$3")));
        x12_upper.add(factory.tuple("List$3").product(factory.tuple("List$4")));
        x12_upper.add(factory.tuple("List$3").product(factory.tuple("List$5")));
        x12_upper.add(factory.tuple("List$4").product(factory.tuple("List$0")));
        x12_upper.add(factory.tuple("List$4").product(factory.tuple("List$1")));
        x12_upper.add(factory.tuple("List$4").product(factory.tuple("List$2")));
        x12_upper.add(factory.tuple("List$4").product(factory.tuple("List$3")));
        x12_upper.add(factory.tuple("List$4").product(factory.tuple("List$4")));
        x12_upper.add(factory.tuple("List$4").product(factory.tuple("List$5")));
        x12_upper.add(factory.tuple("List$5").product(factory.tuple("List$0")));
        x12_upper.add(factory.tuple("List$5").product(factory.tuple("List$1")));
        x12_upper.add(factory.tuple("List$5").product(factory.tuple("List$2")));
        x12_upper.add(factory.tuple("List$5").product(factory.tuple("List$3")));
        x12_upper.add(factory.tuple("List$5").product(factory.tuple("List$4")));
        x12_upper.add(factory.tuple("List$5").product(factory.tuple("List$5")));
        bounds.bound(x12, x12_upper);

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

        Expression x15=x7.intersection(x8);
        Formula x14=x15.no();
        Variable x18=Variable.unary("symmetric_this");
        Decls x17=x18.oneOf(x7);
        Expression x21=x18.join(x11);
        Formula x20=x21.one();
        Formula x22=x21.in(x6);
        Formula x19=x20.and(x22);
        Formula x16=x19.forAll(x17);
        Expression x24=x11.join(Expression.UNIV);
        Formula x23=x24.in(x7);
        Variable x28=Variable.unary("symmetric_this");
        Decls x27=x28.oneOf(x7);
        Expression x31=x28.join(x12);
        Formula x30=x31.one();
        Expression x33=x7.union(x8);
        Formula x32=x31.in(x33);
        Formula x29=x30.and(x32);
        Formula x26=x29.forAll(x27);
        Expression x35=x12.join(Expression.UNIV);
        Formula x34=x35.in(x7);
        Variable x38=Variable.unary("symmetric_this");
        Decls x37=x38.oneOf(x33);
        Expression x40=x38.join(x9);
        Formula x39=x40.in(x33);
        Formula x36=x39.forAll(x37);
        Expression x42=x9.join(Expression.UNIV);
        Formula x41=x42.in(x33);
        Variable x45=Variable.unary("symmetric_this");
        Decls x44=x45.oneOf(x33);
        Expression x47=x45.join(x10);
        Formula x46=x47.in(x33);
        Formula x43=x46.forAll(x44);
        Expression x49=x10.join(Expression.UNIV);
        Formula x48=x49.in(x33);
        Expression x51=x33.join(x11);
        Formula x50=x6.in(x51);
        Variable x54=Variable.unary("symmetric_L");
        Decls x53=x54.oneOf(x33);
        Variable x57=Variable.unary("isFinite_e");
        Decls x56=x57.oneOf(x8);
        Expression x61=x12.closure();
        Expression x67=Expression.INTS.union(x5);
        Expression x66=x67.union(x6);
        Expression x65=x66.union(x33);
        Expression x64=x65.product(Expression.UNIV);
        Expression x62=Expression.IDEN.intersection(x64);
        Expression x60=x61.union(x62);
        Expression x59=x54.join(x60);
        Formula x58=x57.in(x59);
        Formula x55=x58.forSome(x56);
        Formula x52=x55.forAll(x53);
        Variable x72=Variable.unary("symmetric_a");
        Decls x71=x72.oneOf(x33);
        Variable x74=Variable.unary("symmetric_b");
        Decls x73=x74.oneOf(x33);
        Decls x70=x71.and(x73);
        Expression x77=x74.join(x9);
        Formula x76=x72.in(x77);
        Expression x81=x72.join(x11);
        Expression x82=x74.join(x11);
        Formula x80=x81.eq(x82);
        Expression x84=x74.join(x12);
        Expression x86=x72.join(x12);
        Expression x85=x86.join(x9);
        Formula x83=x84.in(x85);
        Formula x79=x80.and(x83);
        Expression x91=x12.closure();
        Expression x93=x65.product(Expression.UNIV);
        Expression x92=Expression.IDEN.intersection(x93);
        Expression x90=x91.union(x92);
        Expression x89=x72.join(x90);
        IntExpression x88=x89.count();
        Expression x97=x12.closure();
        Expression x99=x65.product(Expression.UNIV);
        Expression x98=Expression.IDEN.intersection(x99);
        Expression x96=x97.union(x98);
        Expression x95=x74.join(x96);
        IntExpression x94=x95.count();
        Formula x87=x88.eq(x94);
        Formula x78=x79.and(x87);
        Formula x75=x76.iff(x78);
        Formula x69=x75.forAll(x70);
        Variable x103=Variable.unary("symmetric_e");
        Decls x102=x103.oneOf(x8);
        Variable x105=Variable.unary("symmetric_L");
        Decls x104=x105.oneOf(x33);
        Decls x101=x102.and(x104);
        Expression x107=x105.join(x10);
        Formula x106=x103.in(x107);
        Formula x100=x106.forAll(x101);
        Variable x111=Variable.unary("symmetric_a");
        Decls x110=x111.oneOf(x7);
        Variable x113=Variable.unary("symmetric_b");
        Decls x112=x113.oneOf(x7);
        Decls x109=x110.and(x112);
        Expression x116=x113.join(x10);
        Formula x115=x111.in(x116);
        Expression x120=x111.join(x11);
        Expression x121=x113.join(x11);
        Formula x119=x120.eq(x121);
        Expression x123=x111.join(x12);
        Expression x125=x113.join(x12);
        Expression x124=x125.join(x10);
        Formula x122=x123.in(x124);
        Formula x118=x119.and(x122);
        Expression x130=x12.closure();
        Expression x132=x65.product(Expression.UNIV);
        Expression x131=Expression.IDEN.intersection(x132);
        Expression x129=x130.union(x131);
        Expression x128=x111.join(x129);
        IntExpression x127=x128.count();
        Expression x136=x12.closure();
        Expression x138=x65.product(Expression.UNIV);
        Expression x137=Expression.IDEN.intersection(x138);
        Expression x135=x136.union(x137);
        Expression x134=x113.join(x135);
        IntExpression x133=x134.count();
        Formula x126=x127.lt(x133);
        Formula x117=x118.and(x126);
        Formula x114=x115.iff(x117);
        Formula x108=x114.forAll(x109);
        Variable x143=Variable.unary("symmetric_a");
        Decls x142=x143.oneOf(x33);
        Variable x145=Variable.unary("symmetric_b");
        Decls x144=x145.oneOf(x33);
        Decls x141=x142.and(x144);
        Expression x148=x145.join(x9);
        Formula x147=x143.in(x148);
        Expression x150=x143.join(x9);
        Formula x149=x145.in(x150);
        Formula x146=x147.iff(x149);
        Formula x140=x146.forAll(x141);
        Formula x139=x140.not();
        Formula x151=x0.eq(x0);
        Formula x152=x1.eq(x1);
        Formula x153=x2.eq(x2);
        Formula x154=x3.eq(x3);
        Formula x155=x4.eq(x4);
        Formula x156=x5.eq(x5);
        Formula x157=x6.eq(x6);
        Formula x158=x7.eq(x7);
        Formula x159=x8.eq(x8);
        Formula x160=x9.eq(x9);
        Formula x161=x10.eq(x10);
        Formula x162=x11.eq(x11);
        Formula x163=x12.eq(x12);
        Formula x13=Formula.compose(FormulaOperator.AND, x14, x16, x23, x26, x34, x36, x41, x43, x48, x50, x52, x69, x100, x108, x139, x151, x152, x153, x154, x155, x156, x157, x158, x159, x160, x161, x162, x163);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
       // solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x13,bounds);
        System.out.println(sol.toString());
    }}