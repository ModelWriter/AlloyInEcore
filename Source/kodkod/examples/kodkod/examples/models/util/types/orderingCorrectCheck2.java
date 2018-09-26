package kodkod.examples.models.util.types;

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
        Name = "ordering",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 2,
        TernaryRelations =0,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 4,
        TransitiveClosure = 12,
        NestedQuantifiers = 0,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 9,
        OrderedRelations = 0,
        Constraints = 32
)

public final class orderingCorrectCheck2 {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/elem");
        Relation x7 = Relation.unary("this/Ord");
        Relation x8 = Relation.unary("this/Ord.First");
        Relation x9 = Relation.nary("this/Ord.Next", 2);
        Relation x10 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Ord$0",
                "elem$0", "elem$1"
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
        x6_upper.add(factory.tuple("elem$0"));
        x6_upper.add(factory.tuple("elem$1"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Ord$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("elem$0"));
        x8_upper.add(factory.tuple("elem$1"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(2);
        x9_upper.add(factory.tuple("elem$0").product(factory.tuple("elem$0")));
        x9_upper.add(factory.tuple("elem$0").product(factory.tuple("elem$1")));
        x9_upper.add(factory.tuple("elem$1").product(factory.tuple("elem$0")));
        x9_upper.add(factory.tuple("elem$1").product(factory.tuple("elem$1")));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("elem$0"));
        x10_upper.add(factory.tuple("elem$1"));
        bounds.bound(x10, x10_upper);

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

        Expression x14=x7.product(x8);
        Expression x13=x7.join(x14);
        Formula x12=x13.in(x6);
        Expression x17=x7.product(x9);
        Expression x16=x7.join(x17);
        Expression x18=x6.product(x6);
        Formula x15=x16.in(x18);
        Formula x19=x9.totalOrder(x6,x8,x10);
        Variable x25=Variable.unary("correct_b");
        Decls x24=x25.oneOf(x6);
        Expression x29=x25.join(x9);
        Formula x28=x29.lone();
        Expression x32=x9.transpose();
        Expression x31=x25.join(x32);
        Formula x30=x31.lone();
        Formula x27=x28.and(x30);
        Expression x36=x9.closure();
        Expression x35=x25.join(x36);
        Formula x34=x25.in(x35);
        Formula x33=x34.not();
        Formula x26=x27.and(x33);
        Formula x23=x26.forAll(x24);
        Expression x40=x8.join(x32);
        Formula x39=x40.no();
        Variable x45=Variable.unary("correct_b");
        Decls x44=x45.oneOf(x6);
        Formula x50=x45.eq(x8);
        Formula x49=x50.not();
        Expression x54=x9.join(x6);
        Expression x53=x6.difference(x54);
        Formula x52=x45.eq(x53);
        Formula x51=x52.not();
        Formula x48=x49.and(x51);
        Formula x47=x48.not();
        Expression x57=x45.join(x32);
        Formula x56=x57.one();
        Expression x59=x45.join(x9);
        Formula x58=x59.one();
        Formula x55=x56.and(x58);
        Formula x46=x47.or(x55);
        Formula x43=x46.forAll(x44);
        Expression x63=x9.closure();
        Expression x69=Expression.INTS.union(x5);
        Expression x68=x69.union(x6);
        Expression x67=x68.union(x7);
        Expression x66=x67.product(Expression.UNIV);
        Expression x64=Expression.IDEN.intersection(x66);
        Expression x62=x63.union(x64);
        Expression x61=x8.join(x62);
        Formula x60=x6.eq(x61);
        Formula x42=x43.and(x60);
        Variable x75=Variable.unary("correct_a");
        Decls x74=x75.oneOf(x6);
        Variable x77=Variable.unary("correct_b");
        Decls x76=x77.oneOf(x6);
        Decls x73=x74.and(x76);
        Expression x81=x75.intersection(x77);
        Formula x80=x81.no();
        Formula x79=x80.not();
        Expression x85=x9.closure();
        Expression x84=x77.join(x85);
        Formula x83=x75.in(x84);
        Expression x89=x9.transpose();
        Expression x88=x89.closure();
        Expression x87=x77.join(x88);
        Formula x86=x75.in(x87);
        Formula x82=x83.or(x86);
        Formula x78=x79.or(x82);
        Formula x72=x78.forAll(x73);
        Formula x41=x42.and(x72);
        Formula x38=x39.and(x41);
        Formula x95=x6.one();
        Formula x94=x95.not();
        Formula x93=x94.not();
        Formula x98=x8.one();
        Formula x101=x53.one();
        Expression x103=x8.join(x9);
        Formula x102=x103.one();
        Formula x100=x101.and(x102);
        Expression x105=x53.join(x32);
        Formula x104=x105.one();
        Formula x99=x100.and(x104);
        Formula x97=x98.and(x99);
        Formula x107=x8.eq(x53);
        Formula x106=x107.not();
        Formula x96=x97.and(x106);
        Formula x92=x93.or(x96);
        Variable x111=Variable.unary("correct_a");
        Decls x110=x111.oneOf(x6);
        Variable x113=Variable.unary("correct_b");
        Decls x112=x113.oneOf(x6);
        Decls x109=x110.and(x112);
        Expression x118=x111.intersection(x113);
        Formula x117=x118.no();
        Expression x121=x9.closure();
        Expression x120=x113.join(x121);
        Formula x119=x111.in(x120);
        Formula x116=x117.and(x119);
        Expression x124=x89.closure();
        Expression x123=x113.join(x124);
        Formula x122=x111.in(x123);
        Formula x115=x116.and(x122);
        Formula x114=x115.not();
        Formula x108=x114.forAll(x109);
        Formula x91=x92.and(x108);
        Variable x128=Variable.unary("correct_a");
        Decls x127=x128.oneOf(x6);
        Variable x130=Variable.unary("correct_b");
        Decls x129=x130.oneOf(x6);
        Variable x132=Variable.unary("correct_c");
        Decls x131=x132.oneOf(x6);
        Decls x126=x127.and(x129).and(x131);
        Expression x138=x128.union(x130);
        Expression x137=x138.intersection(x132);
        Formula x136=x137.no();
        Expression x140=x128.intersection(x130);
        Formula x139=x140.no();
        Formula x135=x136.and(x139);
        Formula x134=x135.not();
        Expression x146=x9.closure();
        Expression x145=x128.join(x146);
        Formula x144=x130.in(x145);
        Expression x149=x9.closure();
        Expression x148=x130.join(x149);
        Formula x147=x132.in(x148);
        Formula x143=x144.and(x147);
        Formula x142=x143.not();
        Expression x152=x9.closure();
        Expression x151=x128.join(x152);
        Formula x150=x132.in(x151);
        Formula x141=x142.or(x150);
        Formula x133=x134.or(x141);
        Formula x125=x133.forAll(x126);
        Formula x90=x91.and(x125);
        Formula x37=x38.and(x90);
        Formula x22=x23.and(x37);
        Expression x156=x53.join(x9);
        Formula x155=x156.no();
        Formula x160=x6.one();
        Formula x159=x160.not();
        Formula x163=x8.eq(x6);
        Formula x165=x53.eq(x6);
        Formula x166=x9.no();
        Formula x164=x165.and(x166);
        Formula x162=x163.and(x164);
        Formula x167=x89.no();
        Formula x161=x162.and(x167);
        Formula x158=x159.or(x161);
        Variable x171=Variable.unary("correct_a");
        Decls x170=x171.oneOf(x6);
        Variable x173=Variable.unary("correct_b");
        Decls x172=x173.oneOf(x6);
        Variable x175=Variable.unary("correct_c");
        Decls x174=x175.oneOf(x6);
        Decls x169=x170.and(x172).and(x174);
        Expression x181=x171.union(x173);
        Expression x180=x181.intersection(x175);
        Formula x179=x180.no();
        Expression x183=x171.intersection(x173);
        Formula x182=x183.no();
        Formula x178=x179.and(x182);
        Formula x177=x178.not();
        Expression x189=x89.closure();
        Expression x188=x171.join(x189);
        Formula x187=x173.in(x188);
        Expression x192=x89.closure();
        Expression x191=x173.join(x192);
        Formula x190=x175.in(x191);
        Formula x186=x187.and(x190);
        Formula x185=x186.not();
        Expression x195=x89.closure();
        Expression x194=x171.join(x195);
        Formula x193=x175.in(x194);
        Formula x184=x185.or(x193);
        Formula x176=x177.or(x184);
        Formula x168=x176.forAll(x169);
        Formula x157=x158.and(x168);
        Formula x154=x155.and(x157);
        Expression x197=x9.transpose();
        Formula x196=x89.eq(x197);
        Formula x153=x154.and(x196);
        Formula x21=x22.and(x153);
        Formula x20=x21.not();
        Formula x198=x0.eq(x0);
        Formula x199=x1.eq(x1);
        Formula x200=x2.eq(x2);
        Formula x201=x3.eq(x3);
        Formula x202=x4.eq(x4);
        Formula x203=x5.eq(x5);
        Formula x204=x6.eq(x6);
        Formula x205=x7.eq(x7);
        Formula x206=x8.eq(x8);
        Formula x207=x9.eq(x9);
        Formula x208=x10.eq(x10);
        Formula x11=Formula.compose(FormulaOperator.AND, x12, x15, x19, x20, x198, x199, x200, x201, x202, x203, x204, x205, x206, x207, x208);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x11,bounds);
        System.out.println(sol.toString());
    }}