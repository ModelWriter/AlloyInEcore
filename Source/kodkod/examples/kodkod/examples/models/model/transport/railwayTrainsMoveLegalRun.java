package kodkod.examples.models.model.transport;

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
        Name = "railway",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 5,
        TernaryRelations = 1,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 10,
        TransitiveClosure = 0,
        NestedQuantifiers = 2,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 3,
        OrderedRelations = 0,
        Constraints = 10
)


public final class railwayTrainsMoveLegalRun {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Seg");
        Relation x7 = Relation.unary("this/Train");
        Relation x8 = Relation.unary("this/GateState");
        Relation x9 = Relation.unary("this/TrainState");
        Relation x10 = Relation.nary("this/Seg.next", 2);
        Relation x11 = Relation.nary("this/Seg.overlaps", 2);
        Relation x12 = Relation.nary("this/GateState.closed", 2);
        Relation x13 = Relation.nary("this/TrainState.on", 3);
        Relation x14 = Relation.nary("this/TrainState.occupied", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "GateState$0",
                "GateState$1", "GateState$2", "Seg$0", "Seg$1", "Seg$2", "Train$0",
                "Train$1", "Train$2", "TrainState$0", "TrainState$1", "TrainState$2"
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
        x6_upper.add(factory.tuple("Seg$0"));
        x6_upper.add(factory.tuple("Seg$1"));
        x6_upper.add(factory.tuple("Seg$2"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Train$0"));
        x7_upper.add(factory.tuple("Train$1"));
        x7_upper.add(factory.tuple("Train$2"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("GateState$0"));
        x8_upper.add(factory.tuple("GateState$1"));
        x8_upper.add(factory.tuple("GateState$2"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("TrainState$0"));
        x9_upper.add(factory.tuple("TrainState$1"));
        x9_upper.add(factory.tuple("TrainState$2"));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(2);
        x10_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$0")));
        x10_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$1")));
        x10_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$2")));
        x10_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$0")));
        x10_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$1")));
        x10_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$2")));
        x10_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$0")));
        x10_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$1")));
        x10_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$2")));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(2);
        x11_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$0")));
        x11_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$1")));
        x11_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$2")));
        x11_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$0")));
        x11_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$1")));
        x11_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$2")));
        x11_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$0")));
        x11_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$1")));
        x11_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$2")));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("GateState$0").product(factory.tuple("Seg$0")));
        x12_upper.add(factory.tuple("GateState$0").product(factory.tuple("Seg$1")));
        x12_upper.add(factory.tuple("GateState$0").product(factory.tuple("Seg$2")));
        x12_upper.add(factory.tuple("GateState$1").product(factory.tuple("Seg$0")));
        x12_upper.add(factory.tuple("GateState$1").product(factory.tuple("Seg$1")));
        x12_upper.add(factory.tuple("GateState$1").product(factory.tuple("Seg$2")));
        x12_upper.add(factory.tuple("GateState$2").product(factory.tuple("Seg$0")));
        x12_upper.add(factory.tuple("GateState$2").product(factory.tuple("Seg$1")));
        x12_upper.add(factory.tuple("GateState$2").product(factory.tuple("Seg$2")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(3);
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$0")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$0")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$0")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$1")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$1")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$1")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$2")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$2")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$2")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$0")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$0")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$0")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$1")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$1")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$1")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$2")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$2")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$2")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Train$0")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Train$0")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Train$0")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Train$1")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Train$1")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Train$1")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Train$2")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Train$2")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Train$2")).product(factory.tuple("Seg$2")));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Seg$0")));
        x14_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Seg$1")));
        x14_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Seg$2")));
        x14_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Seg$0")));
        x14_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Seg$1")));
        x14_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Seg$2")));
        x14_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Seg$0")));
        x14_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Seg$1")));
        x14_upper.add(factory.tuple("TrainState$2").product(factory.tuple("Seg$2")));
        bounds.bound(x14, x14_upper);

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

        Variable x18=Variable.unary("TrainsMoveLegal_this");
        Decls x17=x18.oneOf(x6);
        Expression x20=x18.join(x10);
        Formula x19=x20.in(x6);
        Formula x16=x19.forAll(x17);
        Expression x22=x10.join(Expression.UNIV);
        Formula x21=x22.in(x6);
        Variable x26=Variable.unary("TrainsMoveLegal_this");
        Decls x25=x26.oneOf(x6);
        Expression x28=x26.join(x11);
        Formula x27=x28.in(x6);
        Formula x24=x27.forAll(x25);
        Expression x30=x11.join(Expression.UNIV);
        Formula x29=x30.in(x6);
        Variable x33=Variable.unary("TrainsMoveLegal_this");
        Decls x32=x33.oneOf(x8);
        Expression x35=x33.join(x12);
        Formula x34=x35.in(x6);
        Formula x31=x34.forAll(x32);
        Expression x37=x12.join(Expression.UNIV);
        Formula x36=x37.in(x8);
        Variable x40=Variable.unary("TrainsMoveLegal_this");
        Decls x39=x40.oneOf(x9);
        Expression x44=x40.join(x13);
        Expression x45=x7.product(x6);
        Formula x43=x44.in(x45);
        Variable x48=Variable.unary("");
        Decls x47=x48.oneOf(x7);
        Expression x51=x48.join(x44);
        Formula x50=x51.lone();
        Formula x52=x51.in(x6);
        Formula x49=x50.and(x52);
        Formula x46=x49.forAll(x47);
        Formula x42=x43.and(x46);
        Variable x55=Variable.unary("");
        Decls x54=x55.oneOf(x6);
        Expression x57=x44.join(x55);
        Formula x56=x57.in(x7);
        Formula x53=x56.forAll(x54);
        Formula x41=x42.and(x53);
        Formula x38=x41.forAll(x39);
        Expression x60=x13.join(Expression.UNIV);
        Expression x59=x60.join(Expression.UNIV);
        Formula x58=x59.in(x9);
        Variable x63=Variable.unary("TrainsMoveLegal_this");
        Decls x62=x63.oneOf(x9);
        Expression x65=x63.join(x14);
        Formula x64=x65.in(x6);
        Formula x61=x64.forAll(x62);
        Expression x67=x14.join(Expression.UNIV);
        Formula x66=x67.in(x9);
        Variable x70=Variable.unary("TrainsMoveLegal_s");
        Decls x69=x70.oneOf(x6);
        Expression x72=x70.join(x11);
        Formula x71=x70.in(x72);
        Formula x68=x71.forAll(x69);
        Variable x76=Variable.unary("TrainsMoveLegal_s1");
        Decls x75=x76.oneOf(x6);
        Variable x78=Variable.unary("TrainsMoveLegal_s2");
        Decls x77=x78.oneOf(x6);
        Decls x74=x75.and(x77);
        Expression x82=x78.join(x11);
        Formula x81=x76.in(x82);
        Formula x80=x81.not();
        Expression x84=x76.join(x11);
        Formula x83=x78.in(x84);
        Formula x79=x80.or(x83);
        Formula x73=x79.forAll(x74);
        Variable x87=Variable.unary("TrainsMoveLegal_x");
        Decls x86=x87.oneOf(x9);
        Expression x89=x87.join(x14);
        Variable x92=Variable.unary("TrainsMoveLegal_s");
        Decls x91=x92.oneOf(x6);
        Variable x95=Variable.unary("TrainsMoveLegal_t");
        Decls x94=x95.oneOf(x7);
        Expression x98=x87.join(x13);
        Expression x97=x95.join(x98);
        Formula x96=x97.eq(x92);
        Formula x93=x96.forSome(x94);
        Expression x90=x93.comprehension(x91);
        Formula x88=x89.eq(x90);
        Formula x85=x88.forAll(x86);
        Variable x102=Variable.unary("TrainsMoveLegal_x");
        Decls x101=x102.oneOf(x9);
        Variable x104=Variable.unary("TrainsMoveLegal_x'");
        Decls x103=x104.oneOf(x9);
        Variable x106=Variable.unary("TrainsMoveLegal_g");
        Decls x105=x106.oneOf(x8);
        Variable x108=Variable.unary("TrainsMoveLegal_ts");
        Decls x107=x108.setOf(x7);
        Decls x100=x101.and(x103).and(x105).and(x107);
        Variable x114=Variable.unary("TrainsMove_t");
        Decls x113=x114.oneOf(x108);
        Expression x117=x104.join(x13);
        Expression x116=x114.join(x117);
        Expression x120=x102.join(x13);
        Expression x119=x114.join(x120);
        Expression x118=x119.join(x10);
        Formula x115=x116.in(x118);
        Formula x112=x115.forAll(x113);
        Variable x123=Variable.unary("TrainsMove_t");
        Expression x124=x7.difference(x108);
        Decls x122=x123.oneOf(x124);
        Expression x127=x104.join(x13);
        Expression x126=x123.join(x127);
        Expression x129=x102.join(x13);
        Expression x128=x123.join(x129);
        Formula x125=x126.eq(x128);
        Formula x121=x125.forAll(x122);
        Formula x111=x112.and(x121);
        Expression x133=x102.join(x13);
        Expression x132=x108.join(x133);
        Expression x134=x106.join(x12);
        Expression x131=x132.intersection(x134);
        Formula x130=x131.no();
        Formula x110=x111.and(x130);
        Expression x139=x102.join(x14);
        Expression x138=x139.join(x11);
        Expression x140=x10.transpose();
        Expression x137=x138.join(x140);
        Expression x141=x106.join(x12);
        Formula x136=x137.in(x141);
        Variable x145=Variable.unary("GatePolicy_s1");
        Decls x144=x145.oneOf(x6);
        Variable x147=Variable.unary("GatePolicy_s2");
        Decls x146=x147.oneOf(x6);
        Decls x143=x144.and(x146);
        Expression x153=x145.join(x10);
        Expression x152=x153.join(x11);
        Expression x154=x147.join(x10);
        Expression x151=x152.intersection(x154);
        Formula x150=x151.some();
        Formula x149=x150.not();
        Expression x157=x145.union(x147);
        Expression x158=x106.join(x12);
        Expression x156=x157.difference(x158);
        Formula x155=x156.lone();
        Formula x148=x149.or(x155);
        Formula x142=x148.forAll(x143);
        Formula x135=x136.and(x142);
        Formula x109=x110.and(x135);
        Formula x99=x109.forSome(x100);
        Formula x159=x0.eq(x0);
        Formula x160=x1.eq(x1);
        Formula x161=x2.eq(x2);
        Formula x162=x3.eq(x3);
        Formula x163=x4.eq(x4);
        Formula x164=x5.eq(x5);
        Formula x165=x6.eq(x6);
        Formula x166=x7.eq(x7);
        Formula x167=x8.eq(x8);
        Formula x168=x9.eq(x9);
        Formula x169=x10.eq(x10);
        Formula x170=x11.eq(x11);
        Formula x171=x12.eq(x12);
        Formula x172=x13.eq(x13);
        Formula x173=x14.eq(x14);
        Formula x15=Formula.compose(FormulaOperator.AND, x16, x21, x24, x29, x31, x36, x38, x58, x61, x66, x68, x73, x85, x99, x159, x160, x161, x162, x163, x164, x165, x166, x167, x168, x169, x170, x171, x172, x173);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x15,bounds);
        System.out.println(sol.toString());
    }}