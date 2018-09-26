package kodkod.examples.models.puzzle.farmerChickenFox;

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
        Name = "farmer",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 5,
        TernaryRelations = 0,
        NaryRelations = 0,
        HierarchicalTypes =3,
        NestedRelationalJoins = 0,
        TransitiveClosure = 0,
        NestedQuantifiers = 1,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 8,
        OrderedRelations = 1,
        Constraints = 11
)


public final class farmerNoQuantumObjectCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Farmer");
        Relation x7 = Relation.unary("this/Fox");
        Relation x8 = Relation.unary("this/Chicken");
        Relation x9 = Relation.unary("this/Grain");
        Relation x10 = Relation.unary("this/State");
        Relation x11 = Relation.unary("ord/Ord");
        Relation x12 = Relation.nary("this/Object.eats", 2);
        Relation x13 = Relation.nary("this/State.near", 2);
        Relation x14 = Relation.nary("this/State.far", 2);
        Relation x15 = Relation.unary("ord/Ord.First");
        Relation x16 = Relation.nary("ord/Ord.Next", 2);
        Relation x17 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Chicken$0",
                "Farmer$0", "Fox$0", "Grain$0", "State$0", "State$1", "State$2",
                "State$3", "State$4", "State$5", "State$6", "State$7", "ord/Ord$0"
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
        x6_upper.add(factory.tuple("Farmer$0"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Fox$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Chicken$0"));
        bounds.boundExactly(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Grain$0"));
        bounds.boundExactly(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("State$0"));
        x10_upper.add(factory.tuple("State$1"));
        x10_upper.add(factory.tuple("State$2"));
        x10_upper.add(factory.tuple("State$3"));
        x10_upper.add(factory.tuple("State$4"));
        x10_upper.add(factory.tuple("State$5"));
        x10_upper.add(factory.tuple("State$6"));
        x10_upper.add(factory.tuple("State$7"));
        bounds.boundExactly(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(1);
        x11_upper.add(factory.tuple("ord/Ord$0"));
        bounds.boundExactly(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("Fox$0").product(factory.tuple("Chicken$0")));
        x12_upper.add(factory.tuple("Chicken$0").product(factory.tuple("Grain$0")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(2);
        x13_upper.add(factory.tuple("State$0").product(factory.tuple("Farmer$0")));
        x13_upper.add(factory.tuple("State$0").product(factory.tuple("Fox$0")));
        x13_upper.add(factory.tuple("State$0").product(factory.tuple("Chicken$0")));
        x13_upper.add(factory.tuple("State$0").product(factory.tuple("Grain$0")));
        x13_upper.add(factory.tuple("State$1").product(factory.tuple("Farmer$0")));
        x13_upper.add(factory.tuple("State$1").product(factory.tuple("Fox$0")));
        x13_upper.add(factory.tuple("State$1").product(factory.tuple("Chicken$0")));
        x13_upper.add(factory.tuple("State$1").product(factory.tuple("Grain$0")));
        x13_upper.add(factory.tuple("State$2").product(factory.tuple("Farmer$0")));
        x13_upper.add(factory.tuple("State$2").product(factory.tuple("Fox$0")));
        x13_upper.add(factory.tuple("State$2").product(factory.tuple("Chicken$0")));
        x13_upper.add(factory.tuple("State$2").product(factory.tuple("Grain$0")));
        x13_upper.add(factory.tuple("State$3").product(factory.tuple("Farmer$0")));
        x13_upper.add(factory.tuple("State$3").product(factory.tuple("Fox$0")));
        x13_upper.add(factory.tuple("State$3").product(factory.tuple("Chicken$0")));
        x13_upper.add(factory.tuple("State$3").product(factory.tuple("Grain$0")));
        x13_upper.add(factory.tuple("State$4").product(factory.tuple("Farmer$0")));
        x13_upper.add(factory.tuple("State$4").product(factory.tuple("Fox$0")));
        x13_upper.add(factory.tuple("State$4").product(factory.tuple("Chicken$0")));
        x13_upper.add(factory.tuple("State$4").product(factory.tuple("Grain$0")));
        x13_upper.add(factory.tuple("State$5").product(factory.tuple("Farmer$0")));
        x13_upper.add(factory.tuple("State$5").product(factory.tuple("Fox$0")));
        x13_upper.add(factory.tuple("State$5").product(factory.tuple("Chicken$0")));
        x13_upper.add(factory.tuple("State$5").product(factory.tuple("Grain$0")));
        x13_upper.add(factory.tuple("State$6").product(factory.tuple("Farmer$0")));
        x13_upper.add(factory.tuple("State$6").product(factory.tuple("Fox$0")));
        x13_upper.add(factory.tuple("State$6").product(factory.tuple("Chicken$0")));
        x13_upper.add(factory.tuple("State$6").product(factory.tuple("Grain$0")));
        x13_upper.add(factory.tuple("State$7").product(factory.tuple("Farmer$0")));
        x13_upper.add(factory.tuple("State$7").product(factory.tuple("Fox$0")));
        x13_upper.add(factory.tuple("State$7").product(factory.tuple("Chicken$0")));
        x13_upper.add(factory.tuple("State$7").product(factory.tuple("Grain$0")));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("Farmer$0")));
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("Fox$0")));
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("Chicken$0")));
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("Grain$0")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("Farmer$0")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("Fox$0")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("Chicken$0")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("Grain$0")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("Farmer$0")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("Fox$0")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("Chicken$0")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("Grain$0")));
        x14_upper.add(factory.tuple("State$3").product(factory.tuple("Farmer$0")));
        x14_upper.add(factory.tuple("State$3").product(factory.tuple("Fox$0")));
        x14_upper.add(factory.tuple("State$3").product(factory.tuple("Chicken$0")));
        x14_upper.add(factory.tuple("State$3").product(factory.tuple("Grain$0")));
        x14_upper.add(factory.tuple("State$4").product(factory.tuple("Farmer$0")));
        x14_upper.add(factory.tuple("State$4").product(factory.tuple("Fox$0")));
        x14_upper.add(factory.tuple("State$4").product(factory.tuple("Chicken$0")));
        x14_upper.add(factory.tuple("State$4").product(factory.tuple("Grain$0")));
        x14_upper.add(factory.tuple("State$5").product(factory.tuple("Farmer$0")));
        x14_upper.add(factory.tuple("State$5").product(factory.tuple("Fox$0")));
        x14_upper.add(factory.tuple("State$5").product(factory.tuple("Chicken$0")));
        x14_upper.add(factory.tuple("State$5").product(factory.tuple("Grain$0")));
        x14_upper.add(factory.tuple("State$6").product(factory.tuple("Farmer$0")));
        x14_upper.add(factory.tuple("State$6").product(factory.tuple("Fox$0")));
        x14_upper.add(factory.tuple("State$6").product(factory.tuple("Chicken$0")));
        x14_upper.add(factory.tuple("State$6").product(factory.tuple("Grain$0")));
        x14_upper.add(factory.tuple("State$7").product(factory.tuple("Farmer$0")));
        x14_upper.add(factory.tuple("State$7").product(factory.tuple("Fox$0")));
        x14_upper.add(factory.tuple("State$7").product(factory.tuple("Chicken$0")));
        x14_upper.add(factory.tuple("State$7").product(factory.tuple("Grain$0")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(1);
        x15_upper.add(factory.tuple("State$0"));
        x15_upper.add(factory.tuple("State$1"));
        x15_upper.add(factory.tuple("State$2"));
        x15_upper.add(factory.tuple("State$3"));
        x15_upper.add(factory.tuple("State$4"));
        x15_upper.add(factory.tuple("State$5"));
        x15_upper.add(factory.tuple("State$6"));
        x15_upper.add(factory.tuple("State$7"));
        bounds.bound(x15, x15_upper);

        TupleSet x16_upper = factory.noneOf(2);
        x16_upper.add(factory.tuple("State$0").product(factory.tuple("State$0")));
        x16_upper.add(factory.tuple("State$0").product(factory.tuple("State$1")));
        x16_upper.add(factory.tuple("State$0").product(factory.tuple("State$2")));
        x16_upper.add(factory.tuple("State$0").product(factory.tuple("State$3")));
        x16_upper.add(factory.tuple("State$0").product(factory.tuple("State$4")));
        x16_upper.add(factory.tuple("State$0").product(factory.tuple("State$5")));
        x16_upper.add(factory.tuple("State$0").product(factory.tuple("State$6")));
        x16_upper.add(factory.tuple("State$0").product(factory.tuple("State$7")));
        x16_upper.add(factory.tuple("State$1").product(factory.tuple("State$0")));
        x16_upper.add(factory.tuple("State$1").product(factory.tuple("State$1")));
        x16_upper.add(factory.tuple("State$1").product(factory.tuple("State$2")));
        x16_upper.add(factory.tuple("State$1").product(factory.tuple("State$3")));
        x16_upper.add(factory.tuple("State$1").product(factory.tuple("State$4")));
        x16_upper.add(factory.tuple("State$1").product(factory.tuple("State$5")));
        x16_upper.add(factory.tuple("State$1").product(factory.tuple("State$6")));
        x16_upper.add(factory.tuple("State$1").product(factory.tuple("State$7")));
        x16_upper.add(factory.tuple("State$2").product(factory.tuple("State$0")));
        x16_upper.add(factory.tuple("State$2").product(factory.tuple("State$1")));
        x16_upper.add(factory.tuple("State$2").product(factory.tuple("State$2")));
        x16_upper.add(factory.tuple("State$2").product(factory.tuple("State$3")));
        x16_upper.add(factory.tuple("State$2").product(factory.tuple("State$4")));
        x16_upper.add(factory.tuple("State$2").product(factory.tuple("State$5")));
        x16_upper.add(factory.tuple("State$2").product(factory.tuple("State$6")));
        x16_upper.add(factory.tuple("State$2").product(factory.tuple("State$7")));
        x16_upper.add(factory.tuple("State$3").product(factory.tuple("State$0")));
        x16_upper.add(factory.tuple("State$3").product(factory.tuple("State$1")));
        x16_upper.add(factory.tuple("State$3").product(factory.tuple("State$2")));
        x16_upper.add(factory.tuple("State$3").product(factory.tuple("State$3")));
        x16_upper.add(factory.tuple("State$3").product(factory.tuple("State$4")));
        x16_upper.add(factory.tuple("State$3").product(factory.tuple("State$5")));
        x16_upper.add(factory.tuple("State$3").product(factory.tuple("State$6")));
        x16_upper.add(factory.tuple("State$3").product(factory.tuple("State$7")));
        x16_upper.add(factory.tuple("State$4").product(factory.tuple("State$0")));
        x16_upper.add(factory.tuple("State$4").product(factory.tuple("State$1")));
        x16_upper.add(factory.tuple("State$4").product(factory.tuple("State$2")));
        x16_upper.add(factory.tuple("State$4").product(factory.tuple("State$3")));
        x16_upper.add(factory.tuple("State$4").product(factory.tuple("State$4")));
        x16_upper.add(factory.tuple("State$4").product(factory.tuple("State$5")));
        x16_upper.add(factory.tuple("State$4").product(factory.tuple("State$6")));
        x16_upper.add(factory.tuple("State$4").product(factory.tuple("State$7")));
        x16_upper.add(factory.tuple("State$5").product(factory.tuple("State$0")));
        x16_upper.add(factory.tuple("State$5").product(factory.tuple("State$1")));
        x16_upper.add(factory.tuple("State$5").product(factory.tuple("State$2")));
        x16_upper.add(factory.tuple("State$5").product(factory.tuple("State$3")));
        x16_upper.add(factory.tuple("State$5").product(factory.tuple("State$4")));
        x16_upper.add(factory.tuple("State$5").product(factory.tuple("State$5")));
        x16_upper.add(factory.tuple("State$5").product(factory.tuple("State$6")));
        x16_upper.add(factory.tuple("State$5").product(factory.tuple("State$7")));
        x16_upper.add(factory.tuple("State$6").product(factory.tuple("State$0")));
        x16_upper.add(factory.tuple("State$6").product(factory.tuple("State$1")));
        x16_upper.add(factory.tuple("State$6").product(factory.tuple("State$2")));
        x16_upper.add(factory.tuple("State$6").product(factory.tuple("State$3")));
        x16_upper.add(factory.tuple("State$6").product(factory.tuple("State$4")));
        x16_upper.add(factory.tuple("State$6").product(factory.tuple("State$5")));
        x16_upper.add(factory.tuple("State$6").product(factory.tuple("State$6")));
        x16_upper.add(factory.tuple("State$6").product(factory.tuple("State$7")));
        x16_upper.add(factory.tuple("State$7").product(factory.tuple("State$0")));
        x16_upper.add(factory.tuple("State$7").product(factory.tuple("State$1")));
        x16_upper.add(factory.tuple("State$7").product(factory.tuple("State$2")));
        x16_upper.add(factory.tuple("State$7").product(factory.tuple("State$3")));
        x16_upper.add(factory.tuple("State$7").product(factory.tuple("State$4")));
        x16_upper.add(factory.tuple("State$7").product(factory.tuple("State$5")));
        x16_upper.add(factory.tuple("State$7").product(factory.tuple("State$6")));
        x16_upper.add(factory.tuple("State$7").product(factory.tuple("State$7")));
        bounds.bound(x16, x16_upper);

        TupleSet x17_upper = factory.noneOf(1);
        x17_upper.add(factory.tuple("State$0"));
        x17_upper.add(factory.tuple("State$1"));
        x17_upper.add(factory.tuple("State$2"));
        x17_upper.add(factory.tuple("State$3"));
        x17_upper.add(factory.tuple("State$4"));
        x17_upper.add(factory.tuple("State$5"));
        x17_upper.add(factory.tuple("State$6"));
        x17_upper.add(factory.tuple("State$7"));
        bounds.bound(x17, x17_upper);

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

        Expression x20=x6.intersection(x7);
        Formula x19=x20.no();
        Expression x23=x6.union(x7);
        Expression x22=x23.intersection(x8);
        Formula x21=x22.no();
        Expression x26=x23.union(x8);
        Expression x25=x26.intersection(x9);
        Formula x24=x25.no();
        Variable x29=Variable.unary("NoQuantumObjects_this");
        Expression x30=x26.union(x9);
        Decls x28=x29.oneOf(x30);
        Expression x32=x29.join(x12);
        Formula x31=x32.in(x30);
        Formula x27=x31.forAll(x28);
        Expression x34=x12.join(Expression.UNIV);
        Formula x33=x34.in(x30);
        Variable x38=Variable.unary("NoQuantumObjects_this");
        Decls x37=x38.oneOf(x10);
        Expression x40=x38.join(x13);
        Formula x39=x40.in(x30);
        Formula x36=x39.forAll(x37);
        Expression x42=x13.join(Expression.UNIV);
        Formula x41=x42.in(x10);
        Variable x45=Variable.unary("NoQuantumObjects_this");
        Decls x44=x45.oneOf(x10);
        Expression x47=x45.join(x14);
        Formula x46=x47.in(x30);
        Formula x43=x46.forAll(x44);
        Expression x49=x14.join(Expression.UNIV);
        Formula x48=x49.in(x10);
        Expression x52=x11.product(x15);
        Expression x51=x11.join(x52);
        Formula x50=x51.in(x10);
        Expression x55=x11.product(x16);
        Expression x54=x11.join(x55);
        Expression x56=x10.product(x10);
        Formula x53=x54.in(x56);
        Formula x57=x16.totalOrder(x10,x15,x17);
        Expression x60=x7.product(x8);
        Expression x61=x8.product(x9);
        Expression x59=x60.union(x61);
        Formula x58=x12.eq(x59);
        Expression x64=x15.join(x13);
        Formula x63=x64.eq(x30);
        Expression x66=x15.join(x14);
        Formula x65=x66.no();
        Formula x62=x63.and(x65);
        Variable x70=Variable.unary("NoQuantumObjects_s");
        Decls x69=x70.oneOf(x10);
        Variable x72=Variable.unary("NoQuantumObjects_s'");
        Expression x73=x70.join(x16);
        Decls x71=x72.oneOf(x73);
        Decls x68=x69.and(x71);
        Expression x77=x70.join(x13);
        Formula x76=x6.in(x77);
        Expression x81=x72.join(x13);
        Expression x84=x70.join(x13);
        Expression x83=x84.difference(x6);
        Expression x85=x81.join(x12);
        Expression x82=x83.difference(x85);
        Formula x80=x81.eq(x82);
        Expression x87=x72.join(x14);
        Expression x89=x70.join(x14);
        Expression x88=x89.union(x6);
        Formula x86=x87.eq(x88);
        Formula x79=x80.and(x86);
        Variable x93=Variable.unary("crossRiver_x");
        Expression x94=x84.difference(x6);
        Decls x92=x93.oneOf(x94);
        Expression x99=x84.difference(x6);
        Expression x98=x99.difference(x93);
        Expression x100=x81.join(x12);
        Expression x97=x98.difference(x100);
        Formula x96=x81.eq(x97);
        Expression x103=x89.union(x6);
        Expression x102=x103.union(x93);
        Formula x101=x87.eq(x102);
        Formula x95=x96.and(x101);
        Expression x91=x95.comprehension(x92);
        Formula x90=x91.one();
        Formula x78=x79.or(x90);
        Formula x75=x76.implies(x78);
        Formula x105=x76.not();
        Expression x109=x72.join(x14);
        Expression x112=x70.join(x14);
        Expression x111=x112.difference(x6);
        Expression x113=x109.join(x12);
        Expression x110=x111.difference(x113);
        Formula x108=x109.eq(x110);
        Expression x115=x72.join(x13);
        Expression x117=x70.join(x13);
        Expression x116=x117.union(x6);
        Formula x114=x115.eq(x116);
        Formula x107=x108.and(x114);
        Variable x121=Variable.unary("crossRiver_x");
        Expression x122=x112.difference(x6);
        Decls x120=x121.oneOf(x122);
        Expression x127=x112.difference(x6);
        Expression x126=x127.difference(x121);
        Expression x128=x109.join(x12);
        Expression x125=x126.difference(x128);
        Formula x124=x109.eq(x125);
        Expression x131=x117.union(x6);
        Expression x130=x131.union(x121);
        Formula x129=x115.eq(x130);
        Formula x123=x124.and(x129);
        Expression x119=x123.comprehension(x120);
        Formula x118=x119.one();
        Formula x106=x107.or(x118);
        Formula x104=x105.implies(x106);
        Formula x74=x75.and(x104);
        Formula x67=x74.forAll(x68);
        Variable x135=Variable.unary("NoQuantumObjects_s");
        Decls x134=x135.oneOf(x10);
        Variable x139=Variable.unary("NoQuantumObjects_x");
        Decls x138=x139.oneOf(x30);
        Expression x142=x135.join(x13);
        Formula x141=x139.in(x142);
        Expression x144=x135.join(x14);
        Formula x143=x139.in(x144);
        Formula x140=x141.and(x143);
        Formula x137=x140.forSome(x138);
        Formula x136=x137.not();
        Formula x133=x136.forAll(x134);
        Formula x132=x133.not();
        Formula x145=x0.eq(x0);
        Formula x146=x1.eq(x1);
        Formula x147=x2.eq(x2);
        Formula x148=x3.eq(x3);
        Formula x149=x4.eq(x4);
        Formula x150=x5.eq(x5);
        Formula x151=x6.eq(x6);
        Formula x152=x7.eq(x7);
        Formula x153=x8.eq(x8);
        Formula x154=x9.eq(x9);
        Formula x155=x10.eq(x10);
        Formula x156=x11.eq(x11);
        Formula x157=x12.eq(x12);
        Formula x158=x13.eq(x13);
        Formula x159=x14.eq(x14);
        Formula x160=x15.eq(x15);
        Formula x161=x16.eq(x16);
        Formula x162=x17.eq(x17);
        Formula x18=Formula.compose(FormulaOperator.AND, x19, x21, x24, x27, x33, x36, x41, x43, x48, x50, x53, x57, x58, x62, x67, x132, x145, x146, x147, x148, x149, x150, x151, x152, x153, x154, x155, x156, x157, x158, x159, x160, x161, x162);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x18,bounds);
        System.out.println(sol.toString());
    }}