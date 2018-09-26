package kodkod.examples.models.model.microsoftCom;

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
        Name = "com",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 10,
        TernaryRelations = 1,
        NaryRelations = 0,
        HierarchicalTypes =2,
        NestedRelationalJoins = 5,
        TransitiveClosure = 1,
        NestedQuantifiers = 10,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 7,
        OrderedRelations = 0,
        Constraints = 10
)


public final class comTheorem2Check {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/IID");
        Relation x7 = Relation.unary("this/LegalInterface");
        Relation x8 = Relation.unary("this/Interface remainder");
        Relation x9 = Relation.unary("this/LegalComponent");
        Relation x10 = Relation.unary("this/Component remainder");
        Relation x11 = Relation.nary("this/Interface.qi", 3);
        Relation x12 = Relation.nary("this/Interface.iids", 2);
        Relation x13 = Relation.nary("this/Interface.iidsKnown", 2);
        Relation x14 = Relation.nary("this/Interface.reaches", 2);
        Relation x15 = Relation.nary("this/Component.interfaces", 2);
        Relation x16 = Relation.nary("this/Component.iids", 2);
        Relation x17 = Relation.nary("this/Component.first", 2);
        Relation x18 = Relation.nary("this/Component.identity", 2);
        Relation x19 = Relation.nary("this/Component.eqs", 2);
        Relation x20 = Relation.nary("this/Component.aggregates", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Component$0",
                "Component$1", "Component$2", "IID$0", "IID$1", "IID$2", "Interface$0",
                "Interface$1", "Interface$2"
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
        bounds.boundExactly(x4, x4_upper);

        TupleSet x5_upper = factory.noneOf(1);
        bounds.boundExactly(x5, x5_upper);

        TupleSet x6_upper = factory.noneOf(1);
        x6_upper.add(factory.tuple("IID$0"));
        x6_upper.add(factory.tuple("IID$1"));
        x6_upper.add(factory.tuple("IID$2"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Interface$0"));
        x7_upper.add(factory.tuple("Interface$1"));
        x7_upper.add(factory.tuple("Interface$2"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Interface$0"));
        x8_upper.add(factory.tuple("Interface$1"));
        x8_upper.add(factory.tuple("Interface$2"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Component$0"));
        x9_upper.add(factory.tuple("Component$1"));
        x9_upper.add(factory.tuple("Component$2"));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("Component$0"));
        x10_upper.add(factory.tuple("Component$1"));
        x10_upper.add(factory.tuple("Component$2"));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(3);
        x11_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$0")).product(factory.tuple("Interface$0")));
        x11_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$0")).product(factory.tuple("Interface$1")));
        x11_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$0")).product(factory.tuple("Interface$2")));
        x11_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$1")).product(factory.tuple("Interface$0")));
        x11_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$1")).product(factory.tuple("Interface$1")));
        x11_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$1")).product(factory.tuple("Interface$2")));
        x11_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$2")).product(factory.tuple("Interface$0")));
        x11_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$2")).product(factory.tuple("Interface$1")));
        x11_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$2")).product(factory.tuple("Interface$2")));
        x11_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$0")).product(factory.tuple("Interface$0")));
        x11_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$0")).product(factory.tuple("Interface$1")));
        x11_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$0")).product(factory.tuple("Interface$2")));
        x11_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$1")).product(factory.tuple("Interface$0")));
        x11_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$1")).product(factory.tuple("Interface$1")));
        x11_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$1")).product(factory.tuple("Interface$2")));
        x11_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$2")).product(factory.tuple("Interface$0")));
        x11_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$2")).product(factory.tuple("Interface$1")));
        x11_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$2")).product(factory.tuple("Interface$2")));
        x11_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$0")).product(factory.tuple("Interface$0")));
        x11_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$0")).product(factory.tuple("Interface$1")));
        x11_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$0")).product(factory.tuple("Interface$2")));
        x11_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$1")).product(factory.tuple("Interface$0")));
        x11_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$1")).product(factory.tuple("Interface$1")));
        x11_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$1")).product(factory.tuple("Interface$2")));
        x11_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$2")).product(factory.tuple("Interface$0")));
        x11_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$2")).product(factory.tuple("Interface$1")));
        x11_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$2")).product(factory.tuple("Interface$2")));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$0")));
        x12_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$1")));
        x12_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$2")));
        x12_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$0")));
        x12_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$1")));
        x12_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$2")));
        x12_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$0")));
        x12_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$1")));
        x12_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$2")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(2);
        x13_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$0")));
        x13_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$1")));
        x13_upper.add(factory.tuple("Interface$0").product(factory.tuple("IID$2")));
        x13_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$0")));
        x13_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$1")));
        x13_upper.add(factory.tuple("Interface$1").product(factory.tuple("IID$2")));
        x13_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$0")));
        x13_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$1")));
        x13_upper.add(factory.tuple("Interface$2").product(factory.tuple("IID$2")));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("Interface$0").product(factory.tuple("Interface$0")));
        x14_upper.add(factory.tuple("Interface$0").product(factory.tuple("Interface$1")));
        x14_upper.add(factory.tuple("Interface$0").product(factory.tuple("Interface$2")));
        x14_upper.add(factory.tuple("Interface$1").product(factory.tuple("Interface$0")));
        x14_upper.add(factory.tuple("Interface$1").product(factory.tuple("Interface$1")));
        x14_upper.add(factory.tuple("Interface$1").product(factory.tuple("Interface$2")));
        x14_upper.add(factory.tuple("Interface$2").product(factory.tuple("Interface$0")));
        x14_upper.add(factory.tuple("Interface$2").product(factory.tuple("Interface$1")));
        x14_upper.add(factory.tuple("Interface$2").product(factory.tuple("Interface$2")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(2);
        x15_upper.add(factory.tuple("Component$0").product(factory.tuple("Interface$0")));
        x15_upper.add(factory.tuple("Component$0").product(factory.tuple("Interface$1")));
        x15_upper.add(factory.tuple("Component$0").product(factory.tuple("Interface$2")));
        x15_upper.add(factory.tuple("Component$1").product(factory.tuple("Interface$0")));
        x15_upper.add(factory.tuple("Component$1").product(factory.tuple("Interface$1")));
        x15_upper.add(factory.tuple("Component$1").product(factory.tuple("Interface$2")));
        x15_upper.add(factory.tuple("Component$2").product(factory.tuple("Interface$0")));
        x15_upper.add(factory.tuple("Component$2").product(factory.tuple("Interface$1")));
        x15_upper.add(factory.tuple("Component$2").product(factory.tuple("Interface$2")));
        bounds.bound(x15, x15_upper);

        TupleSet x16_upper = factory.noneOf(2);
        x16_upper.add(factory.tuple("Component$0").product(factory.tuple("IID$0")));
        x16_upper.add(factory.tuple("Component$0").product(factory.tuple("IID$1")));
        x16_upper.add(factory.tuple("Component$0").product(factory.tuple("IID$2")));
        x16_upper.add(factory.tuple("Component$1").product(factory.tuple("IID$0")));
        x16_upper.add(factory.tuple("Component$1").product(factory.tuple("IID$1")));
        x16_upper.add(factory.tuple("Component$1").product(factory.tuple("IID$2")));
        x16_upper.add(factory.tuple("Component$2").product(factory.tuple("IID$0")));
        x16_upper.add(factory.tuple("Component$2").product(factory.tuple("IID$1")));
        x16_upper.add(factory.tuple("Component$2").product(factory.tuple("IID$2")));
        bounds.bound(x16, x16_upper);

        TupleSet x17_upper = factory.noneOf(2);
        x17_upper.add(factory.tuple("Component$0").product(factory.tuple("Interface$0")));
        x17_upper.add(factory.tuple("Component$0").product(factory.tuple("Interface$1")));
        x17_upper.add(factory.tuple("Component$0").product(factory.tuple("Interface$2")));
        x17_upper.add(factory.tuple("Component$1").product(factory.tuple("Interface$0")));
        x17_upper.add(factory.tuple("Component$1").product(factory.tuple("Interface$1")));
        x17_upper.add(factory.tuple("Component$1").product(factory.tuple("Interface$2")));
        x17_upper.add(factory.tuple("Component$2").product(factory.tuple("Interface$0")));
        x17_upper.add(factory.tuple("Component$2").product(factory.tuple("Interface$1")));
        x17_upper.add(factory.tuple("Component$2").product(factory.tuple("Interface$2")));
        bounds.bound(x17, x17_upper);

        TupleSet x18_upper = factory.noneOf(2);
        x18_upper.add(factory.tuple("Component$0").product(factory.tuple("Interface$0")));
        x18_upper.add(factory.tuple("Component$0").product(factory.tuple("Interface$1")));
        x18_upper.add(factory.tuple("Component$0").product(factory.tuple("Interface$2")));
        x18_upper.add(factory.tuple("Component$1").product(factory.tuple("Interface$0")));
        x18_upper.add(factory.tuple("Component$1").product(factory.tuple("Interface$1")));
        x18_upper.add(factory.tuple("Component$1").product(factory.tuple("Interface$2")));
        x18_upper.add(factory.tuple("Component$2").product(factory.tuple("Interface$0")));
        x18_upper.add(factory.tuple("Component$2").product(factory.tuple("Interface$1")));
        x18_upper.add(factory.tuple("Component$2").product(factory.tuple("Interface$2")));
        bounds.bound(x18, x18_upper);

        TupleSet x19_upper = factory.noneOf(2);
        x19_upper.add(factory.tuple("Component$0").product(factory.tuple("Component$0")));
        x19_upper.add(factory.tuple("Component$0").product(factory.tuple("Component$1")));
        x19_upper.add(factory.tuple("Component$0").product(factory.tuple("Component$2")));
        x19_upper.add(factory.tuple("Component$1").product(factory.tuple("Component$0")));
        x19_upper.add(factory.tuple("Component$1").product(factory.tuple("Component$1")));
        x19_upper.add(factory.tuple("Component$1").product(factory.tuple("Component$2")));
        x19_upper.add(factory.tuple("Component$2").product(factory.tuple("Component$0")));
        x19_upper.add(factory.tuple("Component$2").product(factory.tuple("Component$1")));
        x19_upper.add(factory.tuple("Component$2").product(factory.tuple("Component$2")));
        bounds.bound(x19, x19_upper);

        TupleSet x20_upper = factory.noneOf(2);
        x20_upper.add(factory.tuple("Component$0").product(factory.tuple("Component$0")));
        x20_upper.add(factory.tuple("Component$0").product(factory.tuple("Component$1")));
        x20_upper.add(factory.tuple("Component$0").product(factory.tuple("Component$2")));
        x20_upper.add(factory.tuple("Component$1").product(factory.tuple("Component$0")));
        x20_upper.add(factory.tuple("Component$1").product(factory.tuple("Component$1")));
        x20_upper.add(factory.tuple("Component$1").product(factory.tuple("Component$2")));
        x20_upper.add(factory.tuple("Component$2").product(factory.tuple("Component$0")));
        x20_upper.add(factory.tuple("Component$2").product(factory.tuple("Component$1")));
        x20_upper.add(factory.tuple("Component$2").product(factory.tuple("Component$2")));
        bounds.bound(x20, x20_upper);

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

        Variable x24=Variable.unary("Theorem2_this");
        Expression x25=x7.union(x8);
        Decls x23=x24.oneOf(x25);
        Expression x29=x24.join(x11);
        Expression x30=x6.product(x25);
        Formula x28=x29.in(x30);
        Variable x33=Variable.unary("");
        Decls x32=x33.oneOf(x6);
        Expression x36=x33.join(x29);
        Formula x35=x36.lone();
        Formula x37=x36.in(x25);
        Formula x34=x35.and(x37);
        Formula x31=x34.forAll(x32);
        Formula x27=x28.and(x31);
        Variable x40=Variable.unary("");
        Decls x39=x40.oneOf(x25);
        Expression x42=x29.join(x40);
        Formula x41=x42.in(x6);
        Formula x38=x41.forAll(x39);
        Formula x26=x27.and(x38);
        Formula x22=x26.forAll(x23);
        Expression x45=x11.join(Expression.UNIV);
        Expression x44=x45.join(Expression.UNIV);
        Formula x43=x44.in(x25);
        Variable x49=Variable.unary("Theorem2_this");
        Decls x48=x49.oneOf(x25);
        Expression x51=x49.join(x12);
        Formula x50=x51.in(x6);
        Formula x47=x50.forAll(x48);
        Expression x53=x12.join(Expression.UNIV);
        Formula x52=x53.in(x25);
        Variable x56=Variable.unary("Theorem2_this");
        Decls x55=x56.oneOf(x25);
        Expression x59=x56.join(x13);
        Formula x58=x59.one();
        Formula x60=x59.in(x6);
        Formula x57=x58.and(x60);
        Formula x54=x57.forAll(x55);
        Expression x62=x13.join(Expression.UNIV);
        Formula x61=x62.in(x25);
        Variable x65=Variable.unary("Theorem2_this");
        Decls x64=x65.oneOf(x25);
        Expression x68=x65.join(x14);
        Formula x67=x68.one();
        Formula x69=x68.in(x25);
        Formula x66=x67.and(x69);
        Formula x63=x66.forAll(x64);
        Expression x71=x14.join(Expression.UNIV);
        Formula x70=x71.in(x25);
        Variable x74=Variable.unary("Theorem2_this");
        Decls x73=x74.oneOf(x25);
        Expression x77=x74.join(x13);
        Expression x79=x74.join(x11);
        Expression x83=Expression.INTS.union(x5);
        Expression x82=x83.union(x6);
        Expression x81=x82.union(x25);
        Expression x85=x9.union(x10);
        Expression x80=x81.union(x85);
        Expression x78=x79.join(x80);
        Formula x76=x77.eq(x78);
        Expression x87=x74.join(x14);
        Expression x89=x74.join(x11);
        Expression x88=x80.join(x89);
        Formula x86=x87.eq(x88);
        Formula x75=x76.and(x86);
        Formula x72=x75.forAll(x73);
        Variable x92=Variable.unary("Theorem2_this");
        Decls x91=x92.oneOf(x85);
        Expression x94=x92.join(x15);
        Formula x93=x94.in(x25);
        Formula x90=x93.forAll(x91);
        Expression x96=x15.join(Expression.UNIV);
        Formula x95=x96.in(x85);
        Variable x99=Variable.unary("Theorem2_this");
        Decls x98=x99.oneOf(x85);
        Expression x101=x99.join(x16);
        Formula x100=x101.in(x6);
        Formula x97=x100.forAll(x98);
        Expression x103=x16.join(Expression.UNIV);
        Formula x102=x103.in(x85);
        Variable x106=Variable.unary("Theorem2_this");
        Decls x105=x106.oneOf(x85);
        Expression x109=x106.join(x17);
        Formula x108=x109.one();
        Expression x111=x106.join(x15);
        Formula x110=x109.in(x111);
        Formula x107=x108.and(x110);
        Formula x104=x107.forAll(x105);
        Expression x113=x17.join(Expression.UNIV);
        Formula x112=x113.in(x85);
        Variable x116=Variable.unary("Theorem2_this");
        Decls x115=x116.oneOf(x85);
        Expression x119=x116.join(x18);
        Formula x118=x119.one();
        Expression x121=x116.join(x15);
        Formula x120=x119.in(x121);
        Formula x117=x118.and(x120);
        Formula x114=x117.forAll(x115);
        Expression x123=x18.join(Expression.UNIV);
        Formula x122=x123.in(x85);
        Variable x126=Variable.unary("Theorem2_this");
        Decls x125=x126.oneOf(x85);
        Expression x128=x126.join(x19);
        Formula x127=x128.in(x85);
        Formula x124=x127.forAll(x125);
        Expression x130=x19.join(Expression.UNIV);
        Formula x129=x130.in(x85);
        Variable x133=Variable.unary("Theorem2_this");
        Decls x132=x133.oneOf(x85);
        Expression x135=x133.join(x20);
        Formula x134=x135.in(x85);
        Formula x131=x134.forAll(x132);
        Expression x137=x20.join(Expression.UNIV);
        Formula x136=x137.in(x85);
        Variable x141=Variable.unary("Theorem2_c1");
        Decls x140=x141.oneOf(x85);
        Variable x143=Variable.unary("Theorem2_c2");
        Decls x142=x143.oneOf(x85);
        Decls x139=x140.and(x142);
        Expression x146=x141.product(x143);
        Formula x145=x146.in(x19);
        Expression x148=x141.join(x18);
        Expression x149=x143.join(x18);
        Formula x147=x148.eq(x149);
        Formula x144=x145.iff(x147);
        Formula x138=x144.forAll(x139);
        Variable x152=Variable.unary("Theorem2_unknown");
        Decls x151=x152.oneOf(x6);
        Variable x155=Variable.unary("Theorem2_c");
        Decls x154=x155.oneOf(x85);
        Variable x158=Variable.unary("Theorem2_i");
        Expression x159=x155.join(x15);
        Decls x157=x158.oneOf(x159);
        Expression x162=x158.join(x11);
        Expression x161=x152.join(x162);
        Expression x163=x155.join(x18);
        Formula x160=x161.eq(x163);
        Formula x156=x160.forAll(x157);
        Formula x153=x156.forAll(x154);
        Formula x150=x153.forSome(x151);
        Variable x166=Variable.unary("Theorem2_c");
        Decls x165=x166.oneOf(x85);
        Expression x169=x166.join(x16);
        Expression x171=x166.join(x15);
        Expression x170=x171.join(x12);
        Formula x168=x169.eq(x170);
        Variable x174=Variable.unary("Theorem2_i");
        Expression x175=x166.join(x15);
        Decls x173=x174.oneOf(x175);
        Variable x178=Variable.unary("Theorem2_x");
        Decls x177=x178.oneOf(x6);
        Expression x181=x174.join(x11);
        Expression x180=x178.join(x181);
        Expression x182=x166.join(x15);
        Formula x179=x180.in(x182);
        Formula x176=x179.forAll(x177);
        Formula x172=x176.forAll(x173);
        Formula x167=x168.and(x172);
        Formula x164=x167.forAll(x165);
        Variable x185=Variable.unary("Theorem2_i");
        Decls x184=x185.oneOf(x7);
        Variable x188=Variable.unary("Theorem2_x");
        Expression x189=x185.join(x13);
        Decls x187=x188.oneOf(x189);
        Expression x193=x185.join(x11);
        Expression x192=x188.join(x193);
        Expression x191=x192.join(x12);
        Formula x190=x188.in(x191);
        Formula x186=x190.forAll(x187);
        Formula x183=x186.forAll(x184);
        Expression x195=x9.join(x15);
        Formula x194=x195.in(x7);
        Variable x198=Variable.unary("Theorem2_i");
        Decls x197=x198.oneOf(x7);
        Expression x200=x198.join(x12);
        Expression x201=x198.join(x13);
        Formula x199=x200.in(x201);
        Formula x196=x199.forAll(x197);
        Variable x205=Variable.unary("Theorem2_i");
        Decls x204=x205.oneOf(x7);
        Variable x207=Variable.unary("Theorem2_j");
        Decls x206=x207.oneOf(x7);
        Decls x203=x204.and(x206);
        Expression x211=x205.join(x14);
        Formula x210=x207.in(x211);
        Formula x209=x210.not();
        Expression x213=x205.join(x12);
        Expression x214=x207.join(x13);
        Formula x212=x213.in(x214);
        Formula x208=x209.or(x212);
        Formula x202=x208.forAll(x203);
        Variable x218=Variable.unary("Theorem2_i");
        Decls x217=x218.oneOf(x7);
        Variable x220=Variable.unary("Theorem2_j");
        Decls x219=x220.oneOf(x7);
        Decls x216=x217.and(x219);
        Expression x224=x218.join(x14);
        Formula x223=x220.in(x224);
        Formula x222=x223.not();
        Expression x226=x220.join(x13);
        Expression x227=x218.join(x13);
        Formula x225=x226.in(x227);
        Formula x221=x222.or(x225);
        Formula x215=x221.forAll(x216);
        Variable x230=Variable.unary("Theorem2_c");
        Decls x229=x230.oneOf(x85);
        Expression x234=x20.closure();
        Expression x233=x230.join(x234);
        Formula x232=x230.in(x233);
        Formula x231=x232.not();
        Formula x228=x231.forAll(x229);
        Variable x237=Variable.unary("Theorem2_outer");
        Decls x236=x237.oneOf(x85);
        Variable x240=Variable.unary("Theorem2_inner");
        Expression x241=x237.join(x20);
        Decls x239=x240.oneOf(x241);
        Expression x245=x240.join(x15);
        Expression x246=x237.join(x15);
        Expression x244=x245.intersection(x246);
        Formula x243=x244.some();
        Variable x249=Variable.unary("Theorem2_o");
        Expression x250=x237.join(x15);
        Decls x248=x249.oneOf(x250);
        Variable x253=Variable.unary("Theorem2_i");
        Expression x255=x240.join(x15);
        Expression x256=x240.join(x17);
        Expression x254=x255.difference(x256);
        Decls x252=x253.oneOf(x254);
        Variable x259=Variable.unary("Theorem2_x");
        Decls x258=x259.oneOf(x85);
        Expression x262=x259.join(x16);
        Expression x263=x253.join(x11);
        Expression x261=x262.join(x263);
        Expression x265=x259.join(x16);
        Expression x266=x249.join(x11);
        Expression x264=x265.join(x266);
        Formula x260=x261.eq(x264);
        Formula x257=x260.forAll(x258);
        Formula x251=x257.forAll(x252);
        Formula x247=x251.forSome(x248);
        Formula x242=x243.and(x247);
        Formula x238=x242.forAll(x239);
        Formula x235=x238.forAll(x236);
        Variable x270=Variable.unary("Theorem2_outer");
        Decls x269=x270.oneOf(x85);
        Variable x273=Variable.unary("Theorem2_inner");
        Expression x274=x270.join(x20);
        Decls x272=x273.oneOf(x274);
        Formula x277=x273.in(x9);
        Formula x276=x277.not();
        Expression x279=x273.join(x16);
        Expression x280=x270.join(x16);
        Formula x278=x279.in(x280);
        Formula x275=x276.or(x278);
        Formula x271=x275.forAll(x272);
        Formula x268=x271.forAll(x269);
        Formula x267=x268.not();
        Formula x281=x0.eq(x0);
        Formula x282=x1.eq(x1);
        Formula x283=x2.eq(x2);
        Formula x284=x3.eq(x3);
        Formula x285=x4.eq(x4);
        Formula x286=x5.eq(x5);
        Formula x287=x6.eq(x6);
        Formula x288=x7.eq(x7);
        Formula x289=x8.eq(x8);
        Formula x290=x9.eq(x9);
        Formula x291=x10.eq(x10);
        Formula x292=x11.eq(x11);
        Formula x293=x12.eq(x12);
        Formula x294=x13.eq(x13);
        Formula x295=x14.eq(x14);
        Formula x296=x15.eq(x15);
        Formula x297=x16.eq(x16);
        Formula x298=x17.eq(x17);
        Formula x299=x18.eq(x18);
        Formula x300=x19.eq(x19);
        Formula x301=x20.eq(x20);
        Formula x21=Formula.compose(FormulaOperator.AND, x22, x43, x47, x52, x54, x61, x63, x70, x72, x90, x95, x97, x102, x104, x112, x114, x122, x124, x129, x131, x136, x138, x150, x164, x183, x194, x196, x202, x215, x228, x235, x267, x281, x282, x283, x284, x285, x286, x287, x288, x289, x290, x291, x292, x293, x294, x295, x296, x297, x298, x299, x300, x301);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x21,bounds);
        System.out.println(sol.toString());
    }}