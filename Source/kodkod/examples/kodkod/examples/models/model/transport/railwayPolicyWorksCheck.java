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


public final class railwayPolicyWorksCheck {

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
                "Seg$0", "Seg$1", "Seg$2", "Seg$3", "Train$0", "Train$1",
                "TrainState$0", "TrainState$1"
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
        x6_upper.add(factory.tuple("Seg$0"));
        x6_upper.add(factory.tuple("Seg$1"));
        x6_upper.add(factory.tuple("Seg$2"));
        x6_upper.add(factory.tuple("Seg$3"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Train$0"));
        x7_upper.add(factory.tuple("Train$1"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("GateState$0"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("TrainState$0"));
        x9_upper.add(factory.tuple("TrainState$1"));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(2);
        x10_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$0")));
        x10_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$1")));
        x10_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$2")));
        x10_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$3")));
        x10_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$0")));
        x10_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$1")));
        x10_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$2")));
        x10_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$3")));
        x10_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$0")));
        x10_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$1")));
        x10_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$2")));
        x10_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$3")));
        x10_upper.add(factory.tuple("Seg$3").product(factory.tuple("Seg$0")));
        x10_upper.add(factory.tuple("Seg$3").product(factory.tuple("Seg$1")));
        x10_upper.add(factory.tuple("Seg$3").product(factory.tuple("Seg$2")));
        x10_upper.add(factory.tuple("Seg$3").product(factory.tuple("Seg$3")));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(2);
        x11_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$0")));
        x11_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$1")));
        x11_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$2")));
        x11_upper.add(factory.tuple("Seg$0").product(factory.tuple("Seg$3")));
        x11_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$0")));
        x11_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$1")));
        x11_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$2")));
        x11_upper.add(factory.tuple("Seg$1").product(factory.tuple("Seg$3")));
        x11_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$0")));
        x11_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$1")));
        x11_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$2")));
        x11_upper.add(factory.tuple("Seg$2").product(factory.tuple("Seg$3")));
        x11_upper.add(factory.tuple("Seg$3").product(factory.tuple("Seg$0")));
        x11_upper.add(factory.tuple("Seg$3").product(factory.tuple("Seg$1")));
        x11_upper.add(factory.tuple("Seg$3").product(factory.tuple("Seg$2")));
        x11_upper.add(factory.tuple("Seg$3").product(factory.tuple("Seg$3")));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("GateState$0").product(factory.tuple("Seg$0")));
        x12_upper.add(factory.tuple("GateState$0").product(factory.tuple("Seg$1")));
        x12_upper.add(factory.tuple("GateState$0").product(factory.tuple("Seg$2")));
        x12_upper.add(factory.tuple("GateState$0").product(factory.tuple("Seg$3")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(3);
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$0")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$0")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$0")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$0")).product(factory.tuple("Seg$3")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$1")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$1")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$1")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Train$1")).product(factory.tuple("Seg$3")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$0")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$0")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$0")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$0")).product(factory.tuple("Seg$3")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$1")).product(factory.tuple("Seg$0")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$1")).product(factory.tuple("Seg$1")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$1")).product(factory.tuple("Seg$2")));
        x13_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Train$1")).product(factory.tuple("Seg$3")));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Seg$0")));
        x14_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Seg$1")));
        x14_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Seg$2")));
        x14_upper.add(factory.tuple("TrainState$0").product(factory.tuple("Seg$3")));
        x14_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Seg$0")));
        x14_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Seg$1")));
        x14_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Seg$2")));
        x14_upper.add(factory.tuple("TrainState$1").product(factory.tuple("Seg$3")));
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

        Variable x18=Variable.unary("PolicyWorks_this");
        Decls x17=x18.oneOf(x6);
        Expression x20=x18.join(x10);
        Formula x19=x20.in(x6);
        Formula x16=x19.forAll(x17);
        Expression x22=x10.join(Expression.UNIV);
        Formula x21=x22.in(x6);
        Variable x26=Variable.unary("PolicyWorks_this");
        Decls x25=x26.oneOf(x6);
        Expression x28=x26.join(x11);
        Formula x27=x28.in(x6);
        Formula x24=x27.forAll(x25);
        Expression x30=x11.join(Expression.UNIV);
        Formula x29=x30.in(x6);
        Variable x33=Variable.unary("PolicyWorks_this");
        Decls x32=x33.oneOf(x8);
        Expression x35=x33.join(x12);
        Formula x34=x35.in(x6);
        Formula x31=x34.forAll(x32);
        Expression x37=x12.join(Expression.UNIV);
        Formula x36=x37.in(x8);
        Variable x40=Variable.unary("PolicyWorks_this");
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
        Variable x63=Variable.unary("PolicyWorks_this");
        Decls x62=x63.oneOf(x9);
        Expression x65=x63.join(x14);
        Formula x64=x65.in(x6);
        Formula x61=x64.forAll(x62);
        Expression x67=x14.join(Expression.UNIV);
        Formula x66=x67.in(x9);
        Variable x70=Variable.unary("PolicyWorks_s");
        Decls x69=x70.oneOf(x6);
        Expression x72=x70.join(x11);
        Formula x71=x70.in(x72);
        Formula x68=x71.forAll(x69);
        Variable x76=Variable.unary("PolicyWorks_s1");
        Decls x75=x76.oneOf(x6);
        Variable x78=Variable.unary("PolicyWorks_s2");
        Decls x77=x78.oneOf(x6);
        Decls x74=x75.and(x77);
        Expression x82=x78.join(x11);
        Formula x81=x76.in(x82);
        Formula x80=x81.not();
        Expression x84=x76.join(x11);
        Formula x83=x78.in(x84);
        Formula x79=x80.or(x83);
        Formula x73=x79.forAll(x74);
        Variable x87=Variable.unary("PolicyWorks_x");
        Decls x86=x87.oneOf(x9);
        Expression x89=x87.join(x14);
        Variable x92=Variable.unary("PolicyWorks_s");
        Decls x91=x92.oneOf(x6);
        Variable x95=Variable.unary("PolicyWorks_t");
        Decls x94=x95.oneOf(x7);
        Expression x98=x87.join(x13);
        Expression x97=x95.join(x98);
        Formula x96=x97.eq(x92);
        Formula x93=x96.forSome(x94);
        Expression x90=x93.comprehension(x91);
        Formula x88=x89.eq(x90);
        Formula x85=x88.forAll(x86);
        Variable x103=Variable.unary("PolicyWorks_x");
        Decls x102=x103.oneOf(x9);
        Variable x105=Variable.unary("PolicyWorks_x'");
        Decls x104=x105.oneOf(x9);
        Variable x107=Variable.unary("PolicyWorks_g");
        Decls x106=x107.oneOf(x8);
        Variable x109=Variable.unary("PolicyWorks_ts");
        Decls x108=x109.setOf(x7);
        Decls x101=x102.and(x104).and(x106).and(x108);
        Expression x117=x103.join(x13);
        Expression x116=x109.join(x117);
        Expression x118=x107.join(x12);
        Expression x115=x116.intersection(x118);
        Formula x114=x115.no();
        Variable x123=Variable.unary("TrainsMove_t");
        Decls x122=x123.oneOf(x109);
        Expression x126=x105.join(x13);
        Expression x125=x123.join(x126);
        Expression x129=x103.join(x13);
        Expression x128=x123.join(x129);
        Expression x127=x128.join(x10);
        Formula x124=x125.in(x127);
        Formula x121=x124.forAll(x122);
        Variable x132=Variable.unary("TrainsMove_t");
        Expression x133=x7.difference(x109);
        Decls x131=x132.oneOf(x133);
        Expression x136=x105.join(x13);
        Expression x135=x132.join(x136);
        Expression x138=x103.join(x13);
        Expression x137=x132.join(x138);
        Formula x134=x135.eq(x137);
        Formula x130=x134.forAll(x131);
        Formula x120=x121.and(x130);
        Expression x143=x103.join(x14);
        Expression x142=x143.join(x11);
        Expression x144=x10.transpose();
        Expression x141=x142.join(x144);
        Expression x145=x107.join(x12);
        Formula x140=x141.in(x145);
        Variable x149=Variable.unary("GatePolicy_s1");
        Decls x148=x149.oneOf(x6);
        Variable x151=Variable.unary("GatePolicy_s2");
        Decls x150=x151.oneOf(x6);
        Decls x147=x148.and(x150);
        Expression x157=x149.join(x10);
        Expression x156=x157.join(x11);
        Expression x158=x151.join(x10);
        Expression x155=x156.intersection(x158);
        Formula x154=x155.some();
        Formula x153=x154.not();
        Expression x161=x149.union(x151);
        Expression x162=x107.join(x12);
        Expression x160=x161.difference(x162);
        Formula x159=x160.lone();
        Formula x152=x153.or(x159);
        Formula x146=x152.forAll(x147);
        Formula x139=x140.and(x146);
        Formula x119=x120.and(x139);
        Formula x113=x114.and(x119);
        Variable x165=Variable.unary("Safe_s");
        Decls x164=x165.oneOf(x6);
        Expression x168=x165.join(x11);
        Expression x170=x103.join(x13);
        Expression x169=x170.transpose();
        Expression x167=x168.join(x169);
        Formula x166=x167.lone();
        Formula x163=x166.forAll(x164);
        Formula x112=x113.and(x163);
        Formula x111=x112.not();
        Variable x173=Variable.unary("Safe_s");
        Decls x172=x173.oneOf(x6);
        Expression x176=x173.join(x11);
        Expression x178=x105.join(x13);
        Expression x177=x178.transpose();
        Expression x175=x176.join(x177);
        Formula x174=x175.lone();
        Formula x171=x174.forAll(x172);
        Formula x110=x111.or(x171);
        Formula x100=x110.forAll(x101);
        Formula x99=x100.not();
        Formula x179=x0.eq(x0);
        Formula x180=x1.eq(x1);
        Formula x181=x2.eq(x2);
        Formula x182=x3.eq(x3);
        Formula x183=x4.eq(x4);
        Formula x184=x5.eq(x5);
        Formula x185=x6.eq(x6);
        Formula x186=x7.eq(x7);
        Formula x187=x8.eq(x8);
        Formula x188=x9.eq(x9);
        Formula x189=x10.eq(x10);
        Formula x190=x11.eq(x11);
        Formula x191=x12.eq(x12);
        Formula x192=x13.eq(x13);
        Formula x193=x14.eq(x14);
        Formula x15=Formula.compose(FormulaOperator.AND, x16, x21, x24, x29, x31, x36, x38, x58, x61, x66, x68, x73, x85, x99, x179, x180, x181, x182, x183, x184, x185, x186, x187, x188, x189, x190, x191, x192, x193);

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