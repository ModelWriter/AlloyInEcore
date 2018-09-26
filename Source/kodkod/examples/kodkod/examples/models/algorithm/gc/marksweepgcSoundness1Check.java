package kodkod.examples.models.algorithm.gc;

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
        Name = "marksweepgc",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 3,
        TernaryRelations =2,
        NaryRelations = 0,
        HierarchicalTypes = 0,
        NestedRelationalJoins = 23,
        TransitiveClosure = 4,
        NestedQuantifiers = 0,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 10,
        OrderedRelations = 0,
        Constraints =14
)


public final class marksweepgcSoundness1Check {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Node");
        Relation x7 = Relation.unary("this/HeapState");
        Relation x8 = Relation.nary("this/HeapState.left", 3);
        Relation x9 = Relation.nary("this/HeapState.right", 3);
        Relation x10 = Relation.nary("this/HeapState.marked", 2);
        Relation x11 = Relation.nary("this/HeapState.freeList", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "HeapState$0",
                "HeapState$1", "HeapState$2", "Node$0", "Node$1", "Node$2"
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
        x6_upper.add(factory.tuple("Node$0"));
        x6_upper.add(factory.tuple("Node$1"));
        x6_upper.add(factory.tuple("Node$2"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("HeapState$0"));
        x7_upper.add(factory.tuple("HeapState$1"));
        x7_upper.add(factory.tuple("HeapState$2"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(3);
        x8_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$0")).product(factory.tuple("Node$0")));
        x8_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$0")).product(factory.tuple("Node$1")));
        x8_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$0")).product(factory.tuple("Node$2")));
        x8_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$1")).product(factory.tuple("Node$0")));
        x8_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$1")).product(factory.tuple("Node$1")));
        x8_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$1")).product(factory.tuple("Node$2")));
        x8_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$2")).product(factory.tuple("Node$0")));
        x8_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$2")).product(factory.tuple("Node$1")));
        x8_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$2")).product(factory.tuple("Node$2")));
        x8_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$0")).product(factory.tuple("Node$0")));
        x8_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$0")).product(factory.tuple("Node$1")));
        x8_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$0")).product(factory.tuple("Node$2")));
        x8_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$1")).product(factory.tuple("Node$0")));
        x8_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$1")).product(factory.tuple("Node$1")));
        x8_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$1")).product(factory.tuple("Node$2")));
        x8_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$2")).product(factory.tuple("Node$0")));
        x8_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$2")).product(factory.tuple("Node$1")));
        x8_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$2")).product(factory.tuple("Node$2")));
        x8_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$0")).product(factory.tuple("Node$0")));
        x8_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$0")).product(factory.tuple("Node$1")));
        x8_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$0")).product(factory.tuple("Node$2")));
        x8_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$1")).product(factory.tuple("Node$0")));
        x8_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$1")).product(factory.tuple("Node$1")));
        x8_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$1")).product(factory.tuple("Node$2")));
        x8_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$2")).product(factory.tuple("Node$0")));
        x8_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$2")).product(factory.tuple("Node$1")));
        x8_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$2")).product(factory.tuple("Node$2")));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(3);
        x9_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$0")).product(factory.tuple("Node$0")));
        x9_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$0")).product(factory.tuple("Node$1")));
        x9_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$0")).product(factory.tuple("Node$2")));
        x9_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$1")).product(factory.tuple("Node$0")));
        x9_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$1")).product(factory.tuple("Node$1")));
        x9_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$1")).product(factory.tuple("Node$2")));
        x9_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$2")).product(factory.tuple("Node$0")));
        x9_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$2")).product(factory.tuple("Node$1")));
        x9_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$2")).product(factory.tuple("Node$2")));
        x9_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$0")).product(factory.tuple("Node$0")));
        x9_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$0")).product(factory.tuple("Node$1")));
        x9_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$0")).product(factory.tuple("Node$2")));
        x9_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$1")).product(factory.tuple("Node$0")));
        x9_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$1")).product(factory.tuple("Node$1")));
        x9_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$1")).product(factory.tuple("Node$2")));
        x9_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$2")).product(factory.tuple("Node$0")));
        x9_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$2")).product(factory.tuple("Node$1")));
        x9_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$2")).product(factory.tuple("Node$2")));
        x9_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$0")).product(factory.tuple("Node$0")));
        x9_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$0")).product(factory.tuple("Node$1")));
        x9_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$0")).product(factory.tuple("Node$2")));
        x9_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$1")).product(factory.tuple("Node$0")));
        x9_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$1")).product(factory.tuple("Node$1")));
        x9_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$1")).product(factory.tuple("Node$2")));
        x9_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$2")).product(factory.tuple("Node$0")));
        x9_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$2")).product(factory.tuple("Node$1")));
        x9_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$2")).product(factory.tuple("Node$2")));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(2);
        x10_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$0")));
        x10_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$1")));
        x10_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$2")));
        x10_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$0")));
        x10_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$1")));
        x10_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$2")));
        x10_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$0")));
        x10_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$1")));
        x10_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$2")));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(2);
        x11_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$0")));
        x11_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$1")));
        x11_upper.add(factory.tuple("HeapState$0").product(factory.tuple("Node$2")));
        x11_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$0")));
        x11_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$1")));
        x11_upper.add(factory.tuple("HeapState$1").product(factory.tuple("Node$2")));
        x11_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$0")));
        x11_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$1")));
        x11_upper.add(factory.tuple("HeapState$2").product(factory.tuple("Node$2")));
        bounds.bound(x11, x11_upper);

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

        Variable x15=Variable.unary("Soundness1_this");
        Decls x14=x15.oneOf(x7);
        Expression x19=x15.join(x8);
        Expression x20=x6.product(x6);
        Formula x18=x19.in(x20);
        Variable x23=Variable.unary("");
        Decls x22=x23.oneOf(x6);
        Expression x26=x23.join(x19);
        Formula x25=x26.lone();
        Formula x27=x26.in(x6);
        Formula x24=x25.and(x27);
        Formula x21=x24.forAll(x22);
        Formula x17=x18.and(x21);
        Variable x30=Variable.unary("");
        Decls x29=x30.oneOf(x6);
        Expression x32=x19.join(x30);
        Formula x31=x32.in(x6);
        Formula x28=x31.forAll(x29);
        Formula x16=x17.and(x28);
        Formula x13=x16.forAll(x14);
        Expression x35=x8.join(Expression.UNIV);
        Expression x34=x35.join(Expression.UNIV);
        Formula x33=x34.in(x7);
        Variable x39=Variable.unary("Soundness1_this");
        Decls x38=x39.oneOf(x7);
        Expression x43=x39.join(x9);
        Expression x44=x6.product(x6);
        Formula x42=x43.in(x44);
        Variable x47=Variable.unary("");
        Decls x46=x47.oneOf(x6);
        Expression x50=x47.join(x43);
        Formula x49=x50.lone();
        Formula x51=x50.in(x6);
        Formula x48=x49.and(x51);
        Formula x45=x48.forAll(x46);
        Formula x41=x42.and(x45);
        Variable x54=Variable.unary("");
        Decls x53=x54.oneOf(x6);
        Expression x56=x43.join(x54);
        Formula x55=x56.in(x6);
        Formula x52=x55.forAll(x53);
        Formula x40=x41.and(x52);
        Formula x37=x40.forAll(x38);
        Expression x59=x9.join(Expression.UNIV);
        Expression x58=x59.join(Expression.UNIV);
        Formula x57=x58.in(x7);
        Variable x62=Variable.unary("Soundness1_this");
        Decls x61=x62.oneOf(x7);
        Expression x64=x62.join(x10);
        Formula x63=x64.in(x6);
        Formula x60=x63.forAll(x61);
        Expression x66=x10.join(Expression.UNIV);
        Formula x65=x66.in(x7);
        Variable x69=Variable.unary("Soundness1_this");
        Decls x68=x69.oneOf(x7);
        Expression x72=x69.join(x11);
        Formula x71=x72.lone();
        Formula x73=x72.in(x6);
        Formula x70=x71.and(x73);
        Formula x67=x70.forAll(x68);
        Expression x75=x11.join(Expression.UNIV);
        Formula x74=x75.in(x7);
        Variable x80=Variable.unary("Soundness1_h");
        Decls x79=x80.oneOf(x7);
        Variable x82=Variable.unary("Soundness1_h'");
        Decls x81=x82.oneOf(x7);
        Variable x84=Variable.unary("Soundness1_root");
        Decls x83=x84.oneOf(x6);
        Decls x78=x79.and(x81).and(x83);
        Variable x90=Variable.unary("GC_hs1");
        Decls x89=x90.oneOf(x7);
        Variable x92=Variable.unary("GC_hs2");
        Decls x91=x92.oneOf(x7);
        Decls x88=x89.and(x91);
        Expression x98=x90.join(x10);
        Formula x97=x98.no();
        Expression x100=x90.join(x8);
        Expression x101=x80.join(x8);
        Formula x99=x100.eq(x101);
        Formula x96=x97.and(x99);
        Expression x103=x90.join(x9);
        Expression x104=x80.join(x9);
        Formula x102=x103.eq(x104);
        Formula x95=x96.and(x102);
        Expression x108=x92.join(x10);
        Expression x113=x90.join(x8);
        Expression x114=x90.join(x9);
        Expression x112=x113.union(x114);
        Expression x111=x112.closure();
        Expression x110=x84.join(x111);
        Expression x109=x84.union(x110);
        Formula x107=x108.eq(x109);
        Expression x116=x92.join(x8);
        Expression x117=x90.join(x8);
        Formula x115=x116.eq(x117);
        Formula x106=x107.and(x115);
        Expression x119=x92.join(x9);
        Expression x120=x90.join(x9);
        Formula x118=x119.eq(x120);
        Formula x105=x106.and(x118);
        Formula x94=x95.and(x105);
        Expression x125=x82.join(x11);
        Expression x128=x82.join(x8);
        Expression x127=x128.closure();
        Expression x134=Expression.INTS.union(x5);
        Expression x133=x134.union(x6);
        Expression x132=x133.union(x7);
        Expression x131=x132.product(Expression.UNIV);
        Expression x129=Expression.IDEN.intersection(x131);
        Expression x126=x127.union(x129);
        Expression x124=x125.join(x126);
        Expression x137=x92.join(x10);
        Expression x136=x6.difference(x137);
        Formula x123=x124.in(x136);
        Variable x140=Variable.unary("setFreeList_n");
        Decls x139=x140.oneOf(x6);
        Expression x145=x92.join(x10);
        Formula x144=x140.in(x145);
        Formula x143=x144.not();
        Expression x150=x82.join(x9);
        Expression x149=x140.join(x150);
        Formula x148=x149.no();
        Expression x153=x82.join(x8);
        Expression x152=x140.join(x153);
        Expression x155=x82.join(x11);
        Expression x158=x82.join(x8);
        Expression x157=x158.closure();
        Expression x160=x132.product(Expression.UNIV);
        Expression x159=Expression.IDEN.intersection(x160);
        Expression x156=x157.union(x159);
        Expression x154=x155.join(x156);
        Formula x151=x152.in(x154);
        Formula x147=x148.and(x151);
        Expression x163=x82.join(x11);
        Expression x166=x82.join(x8);
        Expression x165=x166.closure();
        Expression x168=x132.product(Expression.UNIV);
        Expression x167=Expression.IDEN.intersection(x168);
        Expression x164=x165.union(x167);
        Expression x162=x163.join(x164);
        Formula x161=x140.in(x162);
        Formula x146=x147.and(x161);
        Formula x142=x143.implies(x146);
        Formula x170=x143.not();
        Expression x174=x82.join(x8);
        Expression x173=x140.join(x174);
        Expression x176=x92.join(x8);
        Expression x175=x140.join(x176);
        Formula x172=x173.eq(x175);
        Expression x179=x82.join(x9);
        Expression x178=x140.join(x179);
        Expression x181=x92.join(x9);
        Expression x180=x140.join(x181);
        Formula x177=x178.eq(x180);
        Formula x171=x172.and(x177);
        Formula x169=x170.implies(x171);
        Formula x141=x142.and(x169);
        Formula x138=x141.forAll(x139);
        Formula x122=x123.and(x138);
        Expression x183=x82.join(x10);
        Expression x184=x92.join(x10);
        Formula x182=x183.eq(x184);
        Formula x121=x122.and(x182);
        Formula x93=x94.and(x121);
        Formula x87=x93.forSome(x88);
        Formula x86=x87.not();
        Variable x187=Variable.unary("Soundness1_live");
        Expression x192=x80.join(x8);
        Expression x193=x80.join(x9);
        Expression x191=x192.union(x193);
        Expression x190=x191.closure();
        Expression x189=x84.join(x190);
        Expression x188=x84.union(x189);
        Decls x186=x187.oneOf(x188);
        Expression x197=x82.join(x8);
        Expression x196=x187.join(x197);
        Expression x199=x80.join(x8);
        Expression x198=x187.join(x199);
        Formula x195=x196.eq(x198);
        Expression x202=x82.join(x9);
        Expression x201=x187.join(x202);
        Expression x204=x80.join(x9);
        Expression x203=x187.join(x204);
        Formula x200=x201.eq(x203);
        Formula x194=x195.and(x200);
        Formula x185=x194.forAll(x186);
        Formula x85=x86.or(x185);
        Formula x77=x85.forAll(x78);
        Formula x76=x77.not();
        Formula x205=x0.eq(x0);
        Formula x206=x1.eq(x1);
        Formula x207=x2.eq(x2);
        Formula x208=x3.eq(x3);
        Formula x209=x4.eq(x4);
        Formula x210=x5.eq(x5);
        Formula x211=x6.eq(x6);
        Formula x212=x7.eq(x7);
        Formula x213=x8.eq(x8);
        Formula x214=x9.eq(x9);
        Formula x215=x10.eq(x10);
        Formula x216=x11.eq(x11);
        Formula x12=Formula.compose(FormulaOperator.AND, x13, x33, x37, x57, x60, x65, x67, x74, x76, x205, x206, x207, x208, x209, x210, x211, x212, x213, x214, x215, x216);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
       // solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x12,bounds);
        System.out.println(sol.toString());
    }}