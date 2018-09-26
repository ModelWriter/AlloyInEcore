package kodkod.examples.models.algorithm.mutex;

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
        Name = "dijkstra-2-process",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 3,
        TernaryRelations = 2,
        NaryRelations = 0,
        HierarchicalTypes = 0,
        NestedRelationalJoins = 33,
        TransitiveClosure = 0,
        NestedQuantifiers = 1,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 13,
        OrderedRelations = 2,
        Constraints = 34
)


public final class dijkstra2ProcessShowDijkstraRun {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Process");
        Relation x7 = Relation.unary("this/Mutex");
        Relation x8 = Relation.unary("this/State");
        Relation x9 = Relation.unary("so/Ord");
        Relation x10 = Relation.unary("mo/Ord");
        Relation x11 = Relation.nary("this/State.holds", 3);
        Relation x12 = Relation.nary("this/State.waits", 3);
        Relation x13 = Relation.unary("so/Ord.First");
        Relation x14 = Relation.nary("so/Ord.Next", 2);
        Relation x15 = Relation.unary("mo/Ord.First");
        Relation x16 = Relation.nary("mo/Ord.Next", 2);
        Relation x17 = Relation.unary("");
        Relation x18 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Mutex$0",
                "Mutex$1", "Process$0", "Process$1", "State$0", "State$1", "State$2",
                "State$3", "State$4", "mo/Ord$0", "so/Ord$0"
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
        x6_upper.add(factory.tuple("Process$0"));
        x6_upper.add(factory.tuple("Process$1"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Mutex$0"));
        x7_upper.add(factory.tuple("Mutex$1"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("State$0"));
        x8_upper.add(factory.tuple("State$1"));
        x8_upper.add(factory.tuple("State$2"));
        x8_upper.add(factory.tuple("State$3"));
        x8_upper.add(factory.tuple("State$4"));
        bounds.boundExactly(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("so/Ord$0"));
        bounds.boundExactly(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("mo/Ord$0"));
        bounds.boundExactly(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(3);
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$3").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$3").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$3").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$3").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$4").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$4").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$4").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$4").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(3);
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$3").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$3").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$3").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$3").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$4").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$4").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$4").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$4").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(1);
        x13_upper.add(factory.tuple("State$0"));
        x13_upper.add(factory.tuple("State$1"));
        x13_upper.add(factory.tuple("State$2"));
        x13_upper.add(factory.tuple("State$3"));
        x13_upper.add(factory.tuple("State$4"));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("State$0")));
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("State$1")));
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("State$2")));
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("State$3")));
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("State$4")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("State$0")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("State$1")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("State$2")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("State$3")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("State$4")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("State$0")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("State$1")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("State$2")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("State$3")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("State$4")));
        x14_upper.add(factory.tuple("State$3").product(factory.tuple("State$0")));
        x14_upper.add(factory.tuple("State$3").product(factory.tuple("State$1")));
        x14_upper.add(factory.tuple("State$3").product(factory.tuple("State$2")));
        x14_upper.add(factory.tuple("State$3").product(factory.tuple("State$3")));
        x14_upper.add(factory.tuple("State$3").product(factory.tuple("State$4")));
        x14_upper.add(factory.tuple("State$4").product(factory.tuple("State$0")));
        x14_upper.add(factory.tuple("State$4").product(factory.tuple("State$1")));
        x14_upper.add(factory.tuple("State$4").product(factory.tuple("State$2")));
        x14_upper.add(factory.tuple("State$4").product(factory.tuple("State$3")));
        x14_upper.add(factory.tuple("State$4").product(factory.tuple("State$4")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(1);
        x15_upper.add(factory.tuple("Mutex$0"));
        x15_upper.add(factory.tuple("Mutex$1"));
        bounds.bound(x15, x15_upper);

        TupleSet x16_upper = factory.noneOf(2);
        x16_upper.add(factory.tuple("Mutex$0").product(factory.tuple("Mutex$0")));
        x16_upper.add(factory.tuple("Mutex$0").product(factory.tuple("Mutex$1")));
        x16_upper.add(factory.tuple("Mutex$1").product(factory.tuple("Mutex$0")));
        x16_upper.add(factory.tuple("Mutex$1").product(factory.tuple("Mutex$1")));
        bounds.bound(x16, x16_upper);

        TupleSet x17_upper = factory.noneOf(1);
        x17_upper.add(factory.tuple("State$0"));
        x17_upper.add(factory.tuple("State$1"));
        x17_upper.add(factory.tuple("State$2"));
        x17_upper.add(factory.tuple("State$3"));
        x17_upper.add(factory.tuple("State$4"));
        bounds.bound(x17, x17_upper);

        TupleSet x18_upper = factory.noneOf(1);
        x18_upper.add(factory.tuple("Mutex$0"));
        x18_upper.add(factory.tuple("Mutex$1"));
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

        Variable x22=Variable.unary("ShowDijkstra_this");
        Decls x21=x22.oneOf(x8);
        Expression x24=x22.join(x11);
        Expression x25=x6.product(x7);
        Formula x23=x24.in(x25);
        Formula x20=x23.forAll(x21);
        Expression x28=x11.join(Expression.UNIV);
        Expression x27=x28.join(Expression.UNIV);
        Formula x26=x27.in(x8);
        Variable x32=Variable.unary("ShowDijkstra_this");
        Decls x31=x32.oneOf(x8);
        Expression x34=x32.join(x12);
        Expression x35=x6.product(x7);
        Formula x33=x34.in(x35);
        Formula x30=x33.forAll(x31);
        Expression x38=x12.join(Expression.UNIV);
        Expression x37=x38.join(Expression.UNIV);
        Formula x36=x37.in(x8);
        Expression x41=x9.product(x13);
        Expression x40=x9.join(x41);
        Formula x39=x40.in(x8);
        Expression x44=x9.product(x14);
        Expression x43=x9.join(x44);
        Expression x45=x8.product(x8);
        Formula x42=x43.in(x45);
        Formula x46=x14.totalOrder(x8,x13,x17);
        Expression x49=x10.product(x15);
        Expression x48=x10.join(x49);
        Formula x47=x48.in(x7);
        Expression x52=x10.product(x16);
        Expression x51=x10.join(x52);
        Expression x53=x7.product(x7);
        Formula x50=x51.in(x53);
        Formula x54=x16.totalOrder(x7,x15,x18);
        Expression x58=x13.join(x11);
        Expression x59=x13.join(x12);
        Expression x57=x58.union(x59);
        Formula x56=x57.no();
        Variable x62=Variable.unary("GrabOrRelease_pre");
        Expression x65=x14.join(x8);
        Expression x64=x8.difference(x65);
        Expression x63=x8.difference(x64);
        Decls x61=x62.oneOf(x63);
        Expression x71=x62.join(x14);
        Expression x70=x71.join(x11);
        Expression x72=x62.join(x11);
        Formula x69=x70.eq(x72);
        Expression x74=x71.join(x12);
        Expression x75=x62.join(x12);
        Formula x73=x74.eq(x75);
        Formula x68=x69.and(x73);
        Variable x79=Variable.unary("GrabOrRelease_p");
        Decls x78=x79.oneOf(x6);
        Variable x81=Variable.unary("GrabOrRelease_m");
        Decls x80=x81.oneOf(x7);
        Decls x77=x78.and(x80);
        Expression x87=x62.join(x12);
        Expression x86=x79.join(x87);
        Formula x85=x86.some();
        Formula x84=x85.not();
        Expression x93=x62.join(x11);
        Expression x92=x79.join(x93);
        Formula x91=x81.in(x92);
        Formula x90=x91.not();
        Expression x99=x62.join(x11);
        Expression x98=x99.transpose();
        Expression x97=x81.join(x98);
        Formula x96=x97.no();
        Expression x103=x71.join(x11);
        Expression x102=x79.join(x103);
        Expression x106=x62.join(x11);
        Expression x105=x79.join(x106);
        Expression x104=x105.union(x81);
        Formula x101=x102.eq(x104);
        Expression x109=x71.join(x12);
        Expression x108=x79.join(x109);
        Formula x107=x108.no();
        Formula x100=x101.and(x107);
        Formula x95=x96.implies(x100);
        Formula x111=x96.not();
        Expression x115=x71.join(x11);
        Expression x114=x79.join(x115);
        Expression x117=x62.join(x11);
        Expression x116=x79.join(x117);
        Formula x113=x114.eq(x116);
        Expression x120=x71.join(x12);
        Expression x119=x79.join(x120);
        Formula x118=x119.eq(x81);
        Formula x112=x113.and(x118);
        Formula x110=x111.implies(x112);
        Formula x94=x95.and(x110);
        Formula x89=x90.and(x94);
        Variable x123=Variable.unary("GrabMutex_otherProc");
        Expression x124=x6.difference(x79);
        Decls x122=x123.oneOf(x124);
        Expression x128=x71.join(x11);
        Expression x127=x123.join(x128);
        Expression x130=x62.join(x11);
        Expression x129=x123.join(x130);
        Formula x126=x127.eq(x129);
        Expression x133=x71.join(x12);
        Expression x132=x123.join(x133);
        Expression x135=x62.join(x12);
        Expression x134=x123.join(x135);
        Formula x131=x132.eq(x134);
        Formula x125=x126.and(x131);
        Formula x121=x125.forAll(x122);
        Formula x88=x89.and(x121);
        Formula x83=x84.and(x88);
        Variable x138=Variable.unary("GrabMutex_m'");
        Expression x140=x62.join(x11);
        Expression x139=x79.join(x140);
        Decls x137=x138.oneOf(x139);
        Expression x144=x16.transpose();
        Expression x143=x144.closure();
        Expression x142=x81.join(x143);
        Formula x141=x138.in(x142);
        Formula x136=x141.forAll(x137);
        Formula x82=x83.and(x136);
        Formula x76=x82.forSome(x77);
        Formula x67=x68.or(x76);
        Variable x148=Variable.unary("GrabOrRelease_p");
        Decls x147=x148.oneOf(x6);
        Variable x150=Variable.unary("GrabOrRelease_m");
        Decls x149=x150.oneOf(x7);
        Decls x146=x147.and(x149);
        Expression x156=x62.join(x12);
        Expression x155=x148.join(x156);
        Formula x154=x155.some();
        Formula x153=x154.not();
        Expression x161=x62.join(x11);
        Expression x160=x148.join(x161);
        Formula x159=x150.in(x160);
        Expression x164=x71.join(x12);
        Expression x163=x148.join(x164);
        Formula x162=x163.no();
        Formula x158=x159.and(x162);
        Expression x170=x62.join(x12);
        Expression x169=x170.transpose();
        Expression x168=x150.join(x169);
        Formula x167=x168.no();
        Expression x175=x71.join(x11);
        Expression x174=x175.transpose();
        Expression x173=x150.join(x174);
        Formula x172=x173.no();
        Expression x179=x71.join(x12);
        Expression x178=x179.transpose();
        Expression x177=x150.join(x178);
        Formula x176=x177.no();
        Formula x171=x172.and(x176);
        Formula x166=x167.implies(x171);
        Formula x181=x167.not();
        Variable x184=Variable.unary("ReleaseMutex_lucky");
        Expression x187=x62.join(x12);
        Expression x186=x187.transpose();
        Expression x185=x150.join(x186);
        Decls x183=x184.oneOf(x185);
        Expression x192=x71.join(x12);
        Expression x191=x192.transpose();
        Expression x190=x150.join(x191);
        Expression x196=x62.join(x12);
        Expression x195=x196.transpose();
        Expression x194=x150.join(x195);
        Expression x193=x194.difference(x184);
        Formula x189=x190.eq(x193);
        Expression x200=x71.join(x11);
        Expression x199=x200.transpose();
        Expression x198=x150.join(x199);
        Formula x197=x198.eq(x184);
        Formula x188=x189.and(x197);
        Formula x182=x188.forSome(x183);
        Formula x180=x181.implies(x182);
        Formula x165=x166.and(x180);
        Formula x157=x158.and(x165);
        Formula x152=x153.and(x157);
        Expression x204=x71.join(x11);
        Expression x203=x148.join(x204);
        Expression x207=x62.join(x11);
        Expression x206=x148.join(x207);
        Expression x205=x206.difference(x150);
        Formula x202=x203.eq(x205);
        Variable x210=Variable.unary("ReleaseMutex_mu");
        Expression x211=x7.difference(x150);
        Decls x209=x210.oneOf(x211);
        Expression x216=x71.join(x12);
        Expression x215=x216.transpose();
        Expression x214=x210.join(x215);
        Expression x219=x62.join(x12);
        Expression x218=x219.transpose();
        Expression x217=x210.join(x218);
        Formula x213=x214.eq(x217);
        Expression x223=x71.join(x11);
        Expression x222=x223.transpose();
        Expression x221=x210.join(x222);
        Expression x226=x62.join(x11);
        Expression x225=x226.transpose();
        Expression x224=x210.join(x225);
        Formula x220=x221.eq(x224);
        Formula x212=x213.and(x220);
        Formula x208=x212.forAll(x209);
        Formula x201=x202.and(x208);
        Formula x151=x152.and(x201);
        Formula x145=x151.forSome(x146);
        Formula x66=x67.or(x145);
        Formula x60=x66.forAll(x61);
        Formula x55=x56.and(x60);
        Formula x228=x6.some();
        Variable x231=Variable.unary("Deadlock_s");
        Decls x230=x231.oneOf(x8);
        Variable x234=Variable.unary("Deadlock_p");
        Decls x233=x234.oneOf(x6);
        Expression x237=x231.join(x12);
        Expression x236=x234.join(x237);
        Formula x235=x236.some();
        Formula x232=x235.forAll(x233);
        Formula x229=x232.forSome(x230);
        Formula x227=x228.and(x229);
        Formula x238=x12.some();
        Formula x239=x0.eq(x0);
        Formula x240=x1.eq(x1);
        Formula x241=x2.eq(x2);
        Formula x242=x3.eq(x3);
        Formula x243=x4.eq(x4);
        Formula x244=x5.eq(x5);
        Formula x245=x6.eq(x6);
        Formula x246=x7.eq(x7);
        Formula x247=x8.eq(x8);
        Formula x248=x9.eq(x9);
        Formula x249=x10.eq(x10);
        Formula x250=x11.eq(x11);
        Formula x251=x12.eq(x12);
        Formula x252=x13.eq(x13);
        Formula x253=x14.eq(x14);
        Formula x254=x15.eq(x15);
        Formula x255=x16.eq(x16);
        Formula x256=x17.eq(x17);
        Formula x257=x18.eq(x18);
        Formula x19=Formula.compose(FormulaOperator.AND, x20, x26, x30, x36, x39, x42, x46, x47, x50, x54, x55, x227, x238, x239, x240, x241, x242, x243, x244, x245, x246, x247, x248, x249, x250, x251, x252, x253, x254, x255, x256, x257);

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