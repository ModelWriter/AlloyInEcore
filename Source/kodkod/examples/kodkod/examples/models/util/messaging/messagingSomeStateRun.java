package kodkod.examples.models.util.messaging;

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
        Name = "messaging",
        Note = "",
        IsCheck = false,
        PartialModel = true,
        BinaryRelations = 7,
        TernaryRelations =6,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 28,
        TransitiveClosure = 2,
        NestedQuantifiers = 1,
        SetCardinality = 1,
        Additions = 0,
        Subtractions = 0,
        Comparison = 17,
        OrderedRelations = 1,
        Constraints = 37
)



public final class messagingSomeStateRun {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Node");
        Relation x7 = Relation.unary("this/MsgState");
        Relation x8 = Relation.unary("this/Msg");
        Relation x9 = Relation.unary("this/Tick");
        Relation x10 = Relation.unary("this/NodeState");
        Relation x11 = Relation.unary("ord/Ord");
        Relation x12 = Relation.nary("this/MsgState.from", 2);
        Relation x13 = Relation.nary("this/MsgState.to", 2);
        Relation x14 = Relation.nary("this/Msg.state", 2);
        Relation x15 = Relation.nary("this/Msg.sentOn", 2);
        Relation x16 = Relation.nary("this/Msg.readOn", 3);
        Relation x17 = Relation.nary("this/Tick.state", 3);
        Relation x18 = Relation.nary("this/Tick.visible", 3);
        Relation x19 = Relation.nary("this/Tick.read", 3);
        Relation x20 = Relation.nary("this/Tick.sent", 3);
        Relation x21 = Relation.nary("this/Tick.available", 2);
        Relation x22 = Relation.nary("this/Tick.needsToSend", 3);
        Relation x23 = Relation.unary("ord/Ord.First");
        Relation x24 = Relation.nary("ord/Ord.Next", 2);
        Relation x25 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Msg$0",
                "Msg$1", "MsgState$0", "MsgState$1", "Node$0", "Node$1", "NodeState$0",
                "NodeState$1", "Tick$0", "Tick$1", "ord/Ord$0"
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
        bounds.boundExactly(x4, x4_upper);

        TupleSet x5_upper = factory.noneOf(1);
        bounds.boundExactly(x5, x5_upper);

        TupleSet x6_upper = factory.noneOf(1);
        x6_upper.add(factory.tuple("Node$0"));
        x6_upper.add(factory.tuple("Node$1"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("MsgState$0"));
        x7_upper.add(factory.tuple("MsgState$1"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Msg$0"));
        x8_upper.add(factory.tuple("Msg$1"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Tick$0"));
        x9_upper.add(factory.tuple("Tick$1"));
        bounds.boundExactly(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("NodeState$0"));
        x10_upper.add(factory.tuple("NodeState$1"));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(1);
        x11_upper.add(factory.tuple("ord/Ord$0"));
        bounds.boundExactly(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("MsgState$0").product(factory.tuple("Node$0")));
        x12_upper.add(factory.tuple("MsgState$0").product(factory.tuple("Node$1")));
        x12_upper.add(factory.tuple("MsgState$1").product(factory.tuple("Node$0")));
        x12_upper.add(factory.tuple("MsgState$1").product(factory.tuple("Node$1")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(2);
        x13_upper.add(factory.tuple("MsgState$0").product(factory.tuple("Node$0")));
        x13_upper.add(factory.tuple("MsgState$0").product(factory.tuple("Node$1")));
        x13_upper.add(factory.tuple("MsgState$1").product(factory.tuple("Node$0")));
        x13_upper.add(factory.tuple("MsgState$1").product(factory.tuple("Node$1")));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("Msg$0").product(factory.tuple("MsgState$0")));
        x14_upper.add(factory.tuple("Msg$0").product(factory.tuple("MsgState$1")));
        x14_upper.add(factory.tuple("Msg$1").product(factory.tuple("MsgState$0")));
        x14_upper.add(factory.tuple("Msg$1").product(factory.tuple("MsgState$1")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(2);
        x15_upper.add(factory.tuple("Msg$0").product(factory.tuple("Tick$0")));
        x15_upper.add(factory.tuple("Msg$0").product(factory.tuple("Tick$1")));
        x15_upper.add(factory.tuple("Msg$1").product(factory.tuple("Tick$0")));
        x15_upper.add(factory.tuple("Msg$1").product(factory.tuple("Tick$1")));
        bounds.bound(x15, x15_upper);

        TupleSet x16_upper = factory.noneOf(3);
        x16_upper.add(factory.tuple("Msg$0").product(factory.tuple("Node$0")).product(factory.tuple("Tick$0")));
        x16_upper.add(factory.tuple("Msg$0").product(factory.tuple("Node$0")).product(factory.tuple("Tick$1")));
        x16_upper.add(factory.tuple("Msg$0").product(factory.tuple("Node$1")).product(factory.tuple("Tick$0")));
        x16_upper.add(factory.tuple("Msg$0").product(factory.tuple("Node$1")).product(factory.tuple("Tick$1")));
        x16_upper.add(factory.tuple("Msg$1").product(factory.tuple("Node$0")).product(factory.tuple("Tick$0")));
        x16_upper.add(factory.tuple("Msg$1").product(factory.tuple("Node$0")).product(factory.tuple("Tick$1")));
        x16_upper.add(factory.tuple("Msg$1").product(factory.tuple("Node$1")).product(factory.tuple("Tick$0")));
        x16_upper.add(factory.tuple("Msg$1").product(factory.tuple("Node$1")).product(factory.tuple("Tick$1")));
        bounds.bound(x16, x16_upper);

        TupleSet x17_upper = factory.noneOf(3);
        x17_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("NodeState$0")));
        x17_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("NodeState$1")));
        x17_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("NodeState$0")));
        x17_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("NodeState$1")));
        x17_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("NodeState$0")));
        x17_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("NodeState$1")));
        x17_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("NodeState$0")));
        x17_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("NodeState$1")));
        bounds.bound(x17, x17_upper);

        TupleSet x18_upper = factory.noneOf(3);
        x18_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("Msg$0")));
        x18_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("Msg$1")));
        x18_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("Msg$0")));
        x18_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("Msg$1")));
        x18_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("Msg$0")));
        x18_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("Msg$1")));
        x18_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("Msg$0")));
        x18_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("Msg$1")));
        bounds.bound(x18, x18_upper);

        TupleSet x19_upper = factory.noneOf(3);
        x19_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("Msg$0")));
        x19_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("Msg$1")));
        x19_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("Msg$0")));
        x19_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("Msg$1")));
        x19_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("Msg$0")));
        x19_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("Msg$1")));
        x19_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("Msg$0")));
        x19_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("Msg$1")));
        bounds.bound(x19, x19_upper);

        TupleSet x20_upper = factory.noneOf(3);
        x20_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("Msg$0")));
        x20_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("Msg$1")));
        x20_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("Msg$0")));
        x20_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("Msg$1")));
        x20_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("Msg$0")));
        x20_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("Msg$1")));
        x20_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("Msg$0")));
        x20_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("Msg$1")));
        bounds.bound(x20, x20_upper);

        TupleSet x21_upper = factory.noneOf(2);
        x21_upper.add(factory.tuple("Tick$0").product(factory.tuple("Msg$0")));
        x21_upper.add(factory.tuple("Tick$0").product(factory.tuple("Msg$1")));
        x21_upper.add(factory.tuple("Tick$1").product(factory.tuple("Msg$0")));
        x21_upper.add(factory.tuple("Tick$1").product(factory.tuple("Msg$1")));
        bounds.bound(x21, x21_upper);

        TupleSet x22_upper = factory.noneOf(3);
        x22_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("Msg$0")));
        x22_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$0")).product(factory.tuple("Msg$1")));
        x22_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("Msg$0")));
        x22_upper.add(factory.tuple("Tick$0").product(factory.tuple("Node$1")).product(factory.tuple("Msg$1")));
        x22_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("Msg$0")));
        x22_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$0")).product(factory.tuple("Msg$1")));
        x22_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("Msg$0")));
        x22_upper.add(factory.tuple("Tick$1").product(factory.tuple("Node$1")).product(factory.tuple("Msg$1")));
        bounds.bound(x22, x22_upper);

        TupleSet x23_upper = factory.noneOf(1);
        x23_upper.add(factory.tuple("Tick$0"));
        x23_upper.add(factory.tuple("Tick$1"));
        bounds.bound(x23, x23_upper);

        TupleSet x24_upper = factory.noneOf(2);
        x24_upper.add(factory.tuple("Tick$0").product(factory.tuple("Tick$0")));
        x24_upper.add(factory.tuple("Tick$0").product(factory.tuple("Tick$1")));
        x24_upper.add(factory.tuple("Tick$1").product(factory.tuple("Tick$0")));
        x24_upper.add(factory.tuple("Tick$1").product(factory.tuple("Tick$1")));
        bounds.bound(x24, x24_upper);

        TupleSet x25_upper = factory.noneOf(1);
        x25_upper.add(factory.tuple("Tick$0"));
        x25_upper.add(factory.tuple("Tick$1"));
        bounds.bound(x25, x25_upper);

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

        Variable x29=Variable.unary("SomeState_this");
        Decls x28=x29.oneOf(x7);
        Expression x32=x29.join(x12);
        Formula x31=x32.one();
        Formula x33=x32.in(x6);
        Formula x30=x31.and(x33);
        Formula x27=x30.forAll(x28);
        Expression x35=x12.join(Expression.UNIV);
        Formula x34=x35.in(x7);
        Variable x39=Variable.unary("SomeState_this");
        Decls x38=x39.oneOf(x7);
        Expression x41=x39.join(x13);
        Formula x40=x41.in(x6);
        Formula x37=x40.forAll(x38);
        Expression x43=x13.join(Expression.UNIV);
        Formula x42=x43.in(x7);
        Variable x46=Variable.unary("SomeState_this");
        Decls x45=x46.oneOf(x8);
        Expression x49=x46.join(x14);
        Formula x48=x49.one();
        Formula x50=x49.in(x7);
        Formula x47=x48.and(x50);
        Formula x44=x47.forAll(x45);
        Expression x52=x14.join(Expression.UNIV);
        Formula x51=x52.in(x8);
        Variable x55=Variable.unary("SomeState_this");
        Decls x54=x55.oneOf(x8);
        Expression x58=x55.join(x15);
        Formula x57=x58.one();
        Formula x59=x58.in(x9);
        Formula x56=x57.and(x59);
        Formula x53=x56.forAll(x54);
        Expression x61=x15.join(Expression.UNIV);
        Formula x60=x61.in(x8);
        Variable x64=Variable.unary("SomeState_this");
        Decls x63=x64.oneOf(x8);
        Expression x68=x64.join(x16);
        Expression x69=x6.product(x9);
        Formula x67=x68.in(x69);
        Variable x72=Variable.unary("");
        Decls x71=x72.oneOf(x6);
        Expression x75=x72.join(x68);
        Formula x74=x75.lone();
        Formula x76=x75.in(x9);
        Formula x73=x74.and(x76);
        Formula x70=x73.forAll(x71);
        Formula x66=x67.and(x70);
        Variable x79=Variable.unary("");
        Decls x78=x79.oneOf(x9);
        Expression x81=x68.join(x79);
        Formula x80=x81.in(x6);
        Formula x77=x80.forAll(x78);
        Formula x65=x66.and(x77);
        Formula x62=x65.forAll(x63);
        Expression x84=x16.join(Expression.UNIV);
        Expression x83=x84.join(Expression.UNIV);
        Formula x82=x83.in(x8);
        Variable x87=Variable.unary("SomeState_this");
        Decls x86=x87.oneOf(x8);
        Expression x90=x87.join(x16);
        Expression x89=x90.join(x9);
        Expression x92=x87.join(x14);
        Expression x91=x92.join(x13);
        Formula x88=x89.in(x91);
        Formula x85=x88.forAll(x86);
        Variable x95=Variable.unary("SomeState_this");
        Decls x94=x95.oneOf(x9);
        Expression x99=x95.join(x17);
        Expression x100=x6.product(x10);
        Formula x98=x99.in(x100);
        Variable x103=Variable.unary("");
        Decls x102=x103.oneOf(x6);
        Expression x106=x103.join(x99);
        Formula x105=x106.one();
        Formula x107=x106.in(x10);
        Formula x104=x105.and(x107);
        Formula x101=x104.forAll(x102);
        Formula x97=x98.and(x101);
        Variable x110=Variable.unary("");
        Decls x109=x110.oneOf(x10);
        Expression x112=x99.join(x110);
        Formula x111=x112.in(x6);
        Formula x108=x111.forAll(x109);
        Formula x96=x97.and(x108);
        Formula x93=x96.forAll(x94);
        Expression x115=x17.join(Expression.UNIV);
        Expression x114=x115.join(Expression.UNIV);
        Formula x113=x114.in(x9);
        Variable x118=Variable.unary("SomeState_this");
        Decls x117=x118.oneOf(x9);
        Expression x120=x118.join(x18);
        Expression x121=x6.product(x8);
        Formula x119=x120.in(x121);
        Formula x116=x119.forAll(x117);
        Expression x124=x18.join(Expression.UNIV);
        Expression x123=x124.join(Expression.UNIV);
        Formula x122=x123.in(x9);
        Variable x127=Variable.unary("SomeState_this");
        Decls x126=x127.oneOf(x9);
        Expression x129=x127.join(x19);
        Expression x130=x6.product(x8);
        Formula x128=x129.in(x130);
        Formula x125=x128.forAll(x126);
        Expression x133=x19.join(Expression.UNIV);
        Expression x132=x133.join(Expression.UNIV);
        Formula x131=x132.in(x9);
        Variable x136=Variable.unary("SomeState_this");
        Decls x135=x136.oneOf(x9);
        Expression x138=x136.join(x20);
        Expression x139=x6.product(x8);
        Formula x137=x138.in(x139);
        Formula x134=x137.forAll(x135);
        Expression x142=x20.join(Expression.UNIV);
        Expression x141=x142.join(Expression.UNIV);
        Formula x140=x141.in(x9);
        Variable x145=Variable.unary("SomeState_this");
        Decls x144=x145.oneOf(x9);
        Expression x147=x145.join(x21);
        Formula x146=x147.in(x8);
        Formula x143=x146.forAll(x144);
        Expression x149=x21.join(Expression.UNIV);
        Formula x148=x149.in(x9);
        Variable x152=Variable.unary("SomeState_this");
        Decls x151=x152.oneOf(x9);
        Expression x154=x152.join(x22);
        Expression x155=x6.product(x8);
        Formula x153=x154.in(x155);
        Formula x150=x153.forAll(x151);
        Expression x158=x22.join(Expression.UNIV);
        Expression x157=x158.join(Expression.UNIV);
        Formula x156=x157.in(x9);
        Expression x161=x11.product(x23);
        Expression x160=x11.join(x161);
        Formula x159=x160.in(x9);
        Expression x164=x11.product(x24);
        Expression x163=x11.join(x164);
        Expression x165=x9.product(x9);
        Formula x162=x163.in(x165);
        Formula x166=x24.totalOrder(x9,x23,x25);
        Expression x169=x23.join(x18);
        Expression x168=x6.join(x169);
        Formula x167=x168.no();
        Variable x172=Variable.unary("SomeState_pre");
        Expression x175=x24.join(x9);
        Expression x174=x9.difference(x175);
        Expression x173=x9.difference(x174);
        Decls x171=x172.oneOf(x173);
        Expression x178=x172.join(x24);
        Expression x177=x178.join(x21);
        Expression x180=x172.join(x21);
        Expression x182=x172.join(x20);
        Expression x181=x6.join(x182);
        Expression x179=x180.difference(x181);
        Formula x176=x177.eq(x179);
        Formula x170=x176.forAll(x171);
        Variable x185=Variable.unary("SomeState_t");
        Decls x184=x185.oneOf(x9);
        Expression x190=x185.join(x20);
        Expression x189=x6.join(x190);
        Expression x191=x185.join(x21);
        Formula x188=x189.in(x191);
        Expression x197=x185.join(x20);
        Expression x196=x6.join(x197);
        Expression x195=x196.join(x15);
        Formula x194=x195.in(x185);
        Expression x200=x185.join(x20);
        Expression x199=x6.join(x200);
        Expression x202=x185.join(x20);
        Expression x201=x6.join(x202);
        Formula x198=x199.eq(x201);
        Formula x193=x194.and(x198);
        Variable x206=Variable.unary("SomeState_n");
        Decls x205=x206.oneOf(x6);
        Variable x208=Variable.unary("SomeState_m");
        Decls x207=x208.oneOf(x8);
        Decls x204=x205.and(x207);
        Expression x213=x208.join(x16);
        Expression x212=x206.join(x213);
        Formula x211=x212.eq(x185);
        Formula x210=x211.not();
        Expression x216=x185.join(x19);
        Expression x215=x206.join(x216);
        Formula x214=x208.in(x215);
        Formula x209=x210.or(x214);
        Formula x203=x209.forAll(x204);
        Formula x192=x193.and(x203);
        Formula x187=x188.and(x192);
        Expression x223=x185.join(x19);
        Expression x222=x6.join(x223);
        Expression x221=x222.join(x16);
        Expression x220=x6.join(x221);
        Formula x219=x220.in(x185);
        Variable x226=Variable.unary("SomeState_n");
        Decls x225=x226.oneOf(x6);
        Expression x231=x185.join(x20);
        Expression x230=x226.join(x231);
        Expression x229=x230.join(x14);
        Expression x228=x229.join(x12);
        Formula x227=x228.in(x226);
        Formula x224=x227.forAll(x225);
        Formula x218=x219.and(x224);
        Variable x235=Variable.unary("SomeState_n");
        Decls x234=x235.oneOf(x6);
        Variable x237=Variable.unary("SomeState_m");
        Decls x236=x237.oneOf(x8);
        Decls x233=x234.and(x236);
        Expression x243=x185.join(x18);
        Expression x242=x235.join(x243);
        Formula x241=x237.in(x242);
        Formula x240=x241.not();
        Expression x247=x237.join(x14);
        Expression x246=x247.join(x13);
        Formula x245=x235.in(x246);
        Expression x249=x237.join(x15);
        Expression x252=x24.transpose();
        Expression x251=x252.closure();
        Expression x250=x185.join(x251);
        Formula x248=x249.in(x250);
        Formula x244=x245.and(x248);
        Formula x239=x240.or(x244);
        Expression x257=x185.join(x19);
        Expression x256=x235.join(x257);
        Formula x255=x237.in(x256);
        Formula x254=x255.not();
        Expression x263=x24.closure();
        Expression x262=x185.join(x263);
        Expression x261=x262.join(x18);
        Expression x260=x235.join(x261);
        Formula x259=x237.in(x260);
        Formula x258=x259.not();
        Formula x253=x254.or(x258);
        Formula x238=x239.and(x253);
        Formula x232=x238.forAll(x233);
        Formula x217=x218.and(x232);
        Formula x186=x187.and(x217);
        Formula x183=x186.forAll(x184);
        Expression x266=x9.join(x20);
        Expression x265=x6.join(x266);
        Formula x264=x8.in(x265);
        Formula x267=x19.in(x18);
        IntExpression x269=x6.count();
        IntExpression x270=IntConstant.constant(1);
        Formula x268=x269.gt(x270);
        Formula x271=x0.eq(x0);
        Formula x272=x1.eq(x1);
        Formula x273=x2.eq(x2);
        Formula x274=x3.eq(x3);
        Formula x275=x4.eq(x4);
        Formula x276=x5.eq(x5);
        Formula x277=x6.eq(x6);
        Formula x278=x7.eq(x7);
        Formula x279=x8.eq(x8);
        Formula x280=x9.eq(x9);
        Formula x281=x10.eq(x10);
        Formula x282=x11.eq(x11);
        Formula x283=x12.eq(x12);
        Formula x284=x13.eq(x13);
        Formula x285=x14.eq(x14);
        Formula x286=x15.eq(x15);
        Formula x287=x16.eq(x16);
        Formula x288=x17.eq(x17);
        Formula x289=x18.eq(x18);
        Formula x290=x19.eq(x19);
        Formula x291=x20.eq(x20);
        Formula x292=x21.eq(x21);
        Formula x293=x22.eq(x22);
        Formula x294=x23.eq(x23);
        Formula x295=x24.eq(x24);
        Formula x296=x25.eq(x25);
        Formula x26=Formula.compose(FormulaOperator.AND, x27, x34, x37, x42, x44, x51, x53, x60, x62, x82, x85, x93, x113, x116, x122, x125, x131, x134, x140, x143, x148, x150, x156, x159, x162, x166, x167, x170, x183, x264, x267, x268, x271, x272, x273, x274, x275, x276, x277, x278, x279, x280, x281, x282, x283, x284, x285, x286, x287, x288, x289, x290, x291, x292, x293, x294, x295, x296);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x26,bounds);
        System.out.println(sol.toString());
    }}