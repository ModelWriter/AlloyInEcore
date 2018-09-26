package kodkod.examples.models.softwareAbstractions.chapter2;

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
        Name = "addressBook3d",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 3,
        TernaryRelations =1,
        NaryRelations = 0,
        HierarchicalTypes =4,
        NestedRelationalJoins = 4,
        TransitiveClosure = 3,
        NestedQuantifiers = 4,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 6,
        OrderedRelations = 1,
        Constraints = 20
)

public final class addressBook3dLookupYieldsCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Addr");
        Relation x7 = Relation.unary("this/Alias");
        Relation x8 = Relation.unary("this/Group");
        Relation x9 = Relation.unary("this/Book");
        Relation x10 = Relation.unary("BookOrder/Ord");
        Relation x11 = Relation.nary("this/Book.names", 2);
        Relation x12 = Relation.nary("this/Book.addr", 3);
        Relation x13 = Relation.unary("BookOrder/Ord.First");
        Relation x14 = Relation.nary("BookOrder/Ord.Next", 2);
        Relation x15 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Book$0",
                "Book$1", "Book$2", "Book$3", "BookOrder/Ord$0", "Target$0", "Target$1",
                "Target$2"
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
        x6_upper.add(factory.tuple("Target$0"));
        x6_upper.add(factory.tuple("Target$1"));
        x6_upper.add(factory.tuple("Target$2"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Target$0"));
        x7_upper.add(factory.tuple("Target$1"));
        x7_upper.add(factory.tuple("Target$2"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Target$0"));
        x8_upper.add(factory.tuple("Target$1"));
        x8_upper.add(factory.tuple("Target$2"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Book$0"));
        x9_upper.add(factory.tuple("Book$1"));
        x9_upper.add(factory.tuple("Book$2"));
        x9_upper.add(factory.tuple("Book$3"));
        bounds.boundExactly(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("BookOrder/Ord$0"));
        bounds.boundExactly(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(2);
        x11_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$0")));
        x11_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$1")));
        x11_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$2")));
        x11_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$0")));
        x11_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$1")));
        x11_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$2")));
        x11_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$0")));
        x11_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$1")));
        x11_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$2")));
        x11_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$0")));
        x11_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$1")));
        x11_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$2")));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(3);
        x12_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$0")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$0")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$0")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$1")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$1")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$1")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$2")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$2")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$2")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$0")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$0")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$0")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$1")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$1")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$1")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$2")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$2")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$2")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$0")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$0")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$0")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$1")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$1")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$1")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$2")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$2")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$2").product(factory.tuple("Target$2")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$0")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$0")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$0")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$1")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$1")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$1")).product(factory.tuple("Target$2")));
        x12_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$2")).product(factory.tuple("Target$0")));
        x12_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$2")).product(factory.tuple("Target$1")));
        x12_upper.add(factory.tuple("Book$3").product(factory.tuple("Target$2")).product(factory.tuple("Target$2")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(1);
        x13_upper.add(factory.tuple("Book$0"));
        x13_upper.add(factory.tuple("Book$1"));
        x13_upper.add(factory.tuple("Book$2"));
        x13_upper.add(factory.tuple("Book$3"));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("Book$0").product(factory.tuple("Book$0")));
        x14_upper.add(factory.tuple("Book$0").product(factory.tuple("Book$1")));
        x14_upper.add(factory.tuple("Book$0").product(factory.tuple("Book$2")));
        x14_upper.add(factory.tuple("Book$0").product(factory.tuple("Book$3")));
        x14_upper.add(factory.tuple("Book$1").product(factory.tuple("Book$0")));
        x14_upper.add(factory.tuple("Book$1").product(factory.tuple("Book$1")));
        x14_upper.add(factory.tuple("Book$1").product(factory.tuple("Book$2")));
        x14_upper.add(factory.tuple("Book$1").product(factory.tuple("Book$3")));
        x14_upper.add(factory.tuple("Book$2").product(factory.tuple("Book$0")));
        x14_upper.add(factory.tuple("Book$2").product(factory.tuple("Book$1")));
        x14_upper.add(factory.tuple("Book$2").product(factory.tuple("Book$2")));
        x14_upper.add(factory.tuple("Book$2").product(factory.tuple("Book$3")));
        x14_upper.add(factory.tuple("Book$3").product(factory.tuple("Book$0")));
        x14_upper.add(factory.tuple("Book$3").product(factory.tuple("Book$1")));
        x14_upper.add(factory.tuple("Book$3").product(factory.tuple("Book$2")));
        x14_upper.add(factory.tuple("Book$3").product(factory.tuple("Book$3")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(1);
        x15_upper.add(factory.tuple("Book$0"));
        x15_upper.add(factory.tuple("Book$1"));
        x15_upper.add(factory.tuple("Book$2"));
        x15_upper.add(factory.tuple("Book$3"));
        bounds.bound(x15, x15_upper);

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

        Expression x18=x7.intersection(x8);
        Formula x17=x18.no();
        Expression x21=x7.union(x8);
        Expression x20=x6.intersection(x21);
        Formula x19=x20.no();
        Variable x24=Variable.unary("lookupYields_this");
        Decls x23=x24.oneOf(x9);
        Expression x26=x24.join(x11);
        Formula x25=x26.in(x21);
        Formula x22=x25.forAll(x23);
        Expression x28=x11.join(Expression.UNIV);
        Formula x27=x28.in(x9);
        Variable x32=Variable.unary("lookupYields_this");
        Decls x31=x32.oneOf(x9);
        Expression x36=x32.join(x12);
        Expression x38=x32.join(x11);
        Expression x39=x6.union(x21);
        Expression x37=x38.product(x39);
        Formula x35=x36.in(x37);
        Variable x42=Variable.unary("");
        Decls x41=x42.oneOf(x38);
        Expression x45=x42.join(x36);
        Formula x44=x45.some();
        Formula x46=x45.in(x39);
        Formula x43=x44.and(x46);
        Formula x40=x43.forAll(x41);
        Formula x34=x35.and(x40);
        Variable x49=Variable.unary("");
        Decls x48=x49.oneOf(x39);
        Expression x51=x36.join(x49);
        Expression x52=x32.join(x11);
        Formula x50=x51.in(x52);
        Formula x47=x50.forAll(x48);
        Formula x33=x34.and(x47);
        Formula x30=x33.forAll(x31);
        Expression x55=x12.join(Expression.UNIV);
        Expression x54=x55.join(Expression.UNIV);
        Formula x53=x54.in(x9);
        Variable x58=Variable.unary("lookupYields_this");
        Decls x57=x58.oneOf(x9);
        Variable x62=Variable.unary("lookupYields_n");
        Decls x61=x62.oneOf(x21);
        Expression x67=x58.join(x12);
        Expression x66=x67.closure();
        Expression x65=x62.join(x66);
        Formula x64=x62.in(x65);
        Formula x63=x64.not();
        Formula x60=x63.forAll(x61);
        Variable x70=Variable.unary("lookupYields_a");
        Decls x69=x70.oneOf(x7);
        Expression x73=x58.join(x12);
        Expression x72=x70.join(x73);
        Formula x71=x72.lone();
        Formula x68=x71.forAll(x69);
        Formula x59=x60.and(x68);
        Formula x56=x59.forAll(x57);
        Expression x76=x10.product(x13);
        Expression x75=x10.join(x76);
        Formula x74=x75.in(x9);
        Expression x79=x10.product(x14);
        Expression x78=x10.join(x79);
        Expression x80=x9.product(x9);
        Formula x77=x78.in(x80);
        Formula x81=x14.totalOrder(x9,x13,x15);
        Expression x83=x13.join(x12);
        Formula x82=x83.no();
        Variable x86=Variable.unary("lookupYields_b");
        Expression x89=x14.join(x9);
        Expression x88=x9.difference(x89);
        Expression x87=x9.difference(x88);
        Decls x85=x86.oneOf(x87);
        Variable x93=Variable.unary("lookupYields_n");
        Decls x92=x93.oneOf(x21);
        Variable x95=Variable.unary("lookupYields_t");
        Decls x94=x95.oneOf(x39);
        Decls x91=x92.and(x94);
        Formula x99=x95.in(x6);
        Expression x103=x21.intersection(x95);
        Expression x105=x86.join(x12);
        Expression x104=x105.closure();
        Expression x102=x103.join(x104);
        Expression x101=x102.intersection(x6);
        Formula x100=x101.some();
        Formula x98=x99.or(x100);
        Expression x108=x86.join(x14);
        Expression x107=x108.join(x12);
        Expression x110=x86.join(x12);
        Expression x111=x93.product(x95);
        Expression x109=x110.union(x111);
        Formula x106=x107.eq(x109);
        Formula x97=x98.and(x106);
        Expression x116=x86.join(x12);
        Expression x115=x116.join(x93);
        Formula x114=x115.no();
        Expression x120=x86.join(x12);
        Expression x119=x93.join(x120);
        Expression x118=x119.difference(x95);
        Formula x117=x118.some();
        Formula x113=x114.or(x117);
        Expression x122=x108.join(x12);
        Expression x124=x86.join(x12);
        Expression x125=x93.product(x95);
        Expression x123=x124.difference(x125);
        Formula x121=x122.eq(x123);
        Formula x112=x113.and(x121);
        Formula x96=x97.or(x112);
        Formula x90=x96.forSome(x91);
        Formula x84=x90.forAll(x85);
        Variable x130=Variable.unary("lookupYields_b");
        Decls x129=x130.oneOf(x9);
        Variable x132=Variable.unary("lookupYields_n");
        Expression x133=x130.join(x11);
        Decls x131=x132.oneOf(x133);
        Decls x128=x129.and(x131);
        Expression x138=x130.join(x12);
        Expression x137=x138.closure();
        Expression x136=x132.join(x137);
        Expression x135=x136.intersection(x6);
        Formula x134=x135.some();
        Formula x127=x134.forAll(x128);
        Formula x126=x127.not();
        Formula x139=x0.eq(x0);
        Formula x140=x1.eq(x1);
        Formula x141=x2.eq(x2);
        Formula x142=x3.eq(x3);
        Formula x143=x4.eq(x4);
        Formula x144=x5.eq(x5);
        Formula x145=x6.eq(x6);
        Formula x146=x7.eq(x7);
        Formula x147=x8.eq(x8);
        Formula x148=x9.eq(x9);
        Formula x149=x10.eq(x10);
        Formula x150=x11.eq(x11);
        Formula x151=x12.eq(x12);
        Formula x152=x13.eq(x13);
        Formula x153=x14.eq(x14);
        Formula x154=x15.eq(x15);
        Formula x16=Formula.compose(FormulaOperator.AND, x17, x19, x22, x27, x30, x53, x56, x74, x77, x81, x82, x84, x126, x139, x140, x141, x142, x143, x144, x145, x146, x147, x148, x149, x150, x151, x152, x153, x154);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x16,bounds);
        System.out.println(sol.toString());
    }}