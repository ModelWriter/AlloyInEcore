package kodkod.examples.model.fileSystem;

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
        Name = "file_system",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 5,
        TernaryRelations = 0,
        NaryRelations = 0,
        HierarchicalTypes =4,
        NestedRelationalJoins = 2,
        TransitiveClosure = 2,
        NestedQuantifiers = 3,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 4,
        OrderedRelations = 0,
        Constraints = 10
)



public final class file_systemCheck1 {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/File");
        Relation x7 = Relation.unary("this/Root");
        Relation x8 = Relation.unary("this/Cur");
        Relation x9 = Relation.unary("this/Dir remainder");
        Relation x10 = Relation.unary("this/Name");
        Relation x11 = Relation.unary("this/DirEntry");
        Relation x12 = Relation.nary("this/Dir.entries", 2);
        Relation x13 = Relation.nary("this/Dir.parent", 2);
        Relation x14 = Relation.nary("this/DirEntry.name", 2);
        Relation x15 = Relation.nary("this/DirEntry.contents", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "DirEntry$0",
                "DirEntry$1", "DirEntry$2", "DirEntry$3", "DirEntry$4", "Name$0", "Name$1",
                "Name$2", "Name$3", "Name$4", "Object$0", "Object$1", "Object$2",
                "Object$3", "Root$0"
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
        bounds.boundExactly(x4, x4_upper);

        TupleSet x5_upper = factory.noneOf(1);
        bounds.boundExactly(x5, x5_upper);

        TupleSet x6_upper = factory.noneOf(1);
        x6_upper.add(factory.tuple("Object$0"));
        x6_upper.add(factory.tuple("Object$1"));
        x6_upper.add(factory.tuple("Object$2"));
        x6_upper.add(factory.tuple("Object$3"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Root$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Object$0"));
        x8_upper.add(factory.tuple("Object$1"));
        x8_upper.add(factory.tuple("Object$2"));
        x8_upper.add(factory.tuple("Object$3"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Object$0"));
        x9_upper.add(factory.tuple("Object$1"));
        x9_upper.add(factory.tuple("Object$2"));
        x9_upper.add(factory.tuple("Object$3"));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("Name$0"));
        x10_upper.add(factory.tuple("Name$1"));
        x10_upper.add(factory.tuple("Name$2"));
        x10_upper.add(factory.tuple("Name$3"));
        x10_upper.add(factory.tuple("Name$4"));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(1);
        x11_upper.add(factory.tuple("DirEntry$0"));
        x11_upper.add(factory.tuple("DirEntry$1"));
        x11_upper.add(factory.tuple("DirEntry$2"));
        x11_upper.add(factory.tuple("DirEntry$3"));
        x11_upper.add(factory.tuple("DirEntry$4"));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("Root$0").product(factory.tuple("DirEntry$0")));
        x12_upper.add(factory.tuple("Root$0").product(factory.tuple("DirEntry$1")));
        x12_upper.add(factory.tuple("Root$0").product(factory.tuple("DirEntry$2")));
        x12_upper.add(factory.tuple("Root$0").product(factory.tuple("DirEntry$3")));
        x12_upper.add(factory.tuple("Root$0").product(factory.tuple("DirEntry$4")));
        x12_upper.add(factory.tuple("Object$0").product(factory.tuple("DirEntry$0")));
        x12_upper.add(factory.tuple("Object$0").product(factory.tuple("DirEntry$1")));
        x12_upper.add(factory.tuple("Object$0").product(factory.tuple("DirEntry$2")));
        x12_upper.add(factory.tuple("Object$0").product(factory.tuple("DirEntry$3")));
        x12_upper.add(factory.tuple("Object$0").product(factory.tuple("DirEntry$4")));
        x12_upper.add(factory.tuple("Object$1").product(factory.tuple("DirEntry$0")));
        x12_upper.add(factory.tuple("Object$1").product(factory.tuple("DirEntry$1")));
        x12_upper.add(factory.tuple("Object$1").product(factory.tuple("DirEntry$2")));
        x12_upper.add(factory.tuple("Object$1").product(factory.tuple("DirEntry$3")));
        x12_upper.add(factory.tuple("Object$1").product(factory.tuple("DirEntry$4")));
        x12_upper.add(factory.tuple("Object$2").product(factory.tuple("DirEntry$0")));
        x12_upper.add(factory.tuple("Object$2").product(factory.tuple("DirEntry$1")));
        x12_upper.add(factory.tuple("Object$2").product(factory.tuple("DirEntry$2")));
        x12_upper.add(factory.tuple("Object$2").product(factory.tuple("DirEntry$3")));
        x12_upper.add(factory.tuple("Object$2").product(factory.tuple("DirEntry$4")));
        x12_upper.add(factory.tuple("Object$3").product(factory.tuple("DirEntry$0")));
        x12_upper.add(factory.tuple("Object$3").product(factory.tuple("DirEntry$1")));
        x12_upper.add(factory.tuple("Object$3").product(factory.tuple("DirEntry$2")));
        x12_upper.add(factory.tuple("Object$3").product(factory.tuple("DirEntry$3")));
        x12_upper.add(factory.tuple("Object$3").product(factory.tuple("DirEntry$4")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(2);
        x13_upper.add(factory.tuple("Root$0").product(factory.tuple("Root$0")));
        x13_upper.add(factory.tuple("Root$0").product(factory.tuple("Object$0")));
        x13_upper.add(factory.tuple("Root$0").product(factory.tuple("Object$1")));
        x13_upper.add(factory.tuple("Root$0").product(factory.tuple("Object$2")));
        x13_upper.add(factory.tuple("Root$0").product(factory.tuple("Object$3")));
        x13_upper.add(factory.tuple("Object$0").product(factory.tuple("Root$0")));
        x13_upper.add(factory.tuple("Object$0").product(factory.tuple("Object$0")));
        x13_upper.add(factory.tuple("Object$0").product(factory.tuple("Object$1")));
        x13_upper.add(factory.tuple("Object$0").product(factory.tuple("Object$2")));
        x13_upper.add(factory.tuple("Object$0").product(factory.tuple("Object$3")));
        x13_upper.add(factory.tuple("Object$1").product(factory.tuple("Root$0")));
        x13_upper.add(factory.tuple("Object$1").product(factory.tuple("Object$0")));
        x13_upper.add(factory.tuple("Object$1").product(factory.tuple("Object$1")));
        x13_upper.add(factory.tuple("Object$1").product(factory.tuple("Object$2")));
        x13_upper.add(factory.tuple("Object$1").product(factory.tuple("Object$3")));
        x13_upper.add(factory.tuple("Object$2").product(factory.tuple("Root$0")));
        x13_upper.add(factory.tuple("Object$2").product(factory.tuple("Object$0")));
        x13_upper.add(factory.tuple("Object$2").product(factory.tuple("Object$1")));
        x13_upper.add(factory.tuple("Object$2").product(factory.tuple("Object$2")));
        x13_upper.add(factory.tuple("Object$2").product(factory.tuple("Object$3")));
        x13_upper.add(factory.tuple("Object$3").product(factory.tuple("Root$0")));
        x13_upper.add(factory.tuple("Object$3").product(factory.tuple("Object$0")));
        x13_upper.add(factory.tuple("Object$3").product(factory.tuple("Object$1")));
        x13_upper.add(factory.tuple("Object$3").product(factory.tuple("Object$2")));
        x13_upper.add(factory.tuple("Object$3").product(factory.tuple("Object$3")));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Name$0")));
        x14_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Name$1")));
        x14_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Name$2")));
        x14_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Name$3")));
        x14_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Name$4")));
        x14_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Name$0")));
        x14_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Name$1")));
        x14_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Name$2")));
        x14_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Name$3")));
        x14_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Name$4")));
        x14_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Name$0")));
        x14_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Name$1")));
        x14_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Name$2")));
        x14_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Name$3")));
        x14_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Name$4")));
        x14_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Name$0")));
        x14_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Name$1")));
        x14_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Name$2")));
        x14_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Name$3")));
        x14_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Name$4")));
        x14_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Name$0")));
        x14_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Name$1")));
        x14_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Name$2")));
        x14_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Name$3")));
        x14_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Name$4")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(2);
        x15_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Root$0")));
        x15_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Object$0")));
        x15_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Object$1")));
        x15_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Object$2")));
        x15_upper.add(factory.tuple("DirEntry$0").product(factory.tuple("Object$3")));
        x15_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Root$0")));
        x15_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Object$0")));
        x15_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Object$1")));
        x15_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Object$2")));
        x15_upper.add(factory.tuple("DirEntry$1").product(factory.tuple("Object$3")));
        x15_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Root$0")));
        x15_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Object$0")));
        x15_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Object$1")));
        x15_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Object$2")));
        x15_upper.add(factory.tuple("DirEntry$2").product(factory.tuple("Object$3")));
        x15_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Root$0")));
        x15_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Object$0")));
        x15_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Object$1")));
        x15_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Object$2")));
        x15_upper.add(factory.tuple("DirEntry$3").product(factory.tuple("Object$3")));
        x15_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Root$0")));
        x15_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Object$0")));
        x15_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Object$1")));
        x15_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Object$2")));
        x15_upper.add(factory.tuple("DirEntry$4").product(factory.tuple("Object$3")));
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
        Expression x22=x7.union(x8);
        Expression x21=x22.union(x9);
        Expression x20=x6.intersection(x21);
        Formula x19=x20.no();
        Formula x23=x8.lone();
        Formula x24=x8.lone();
        Variable x27=Variable.unary("this");
        Decls x26=x27.oneOf(x6);
        Variable x30=Variable.unary("d");
        Decls x29=x30.oneOf(x21);
        Expression x33=x30.join(x12);
        Expression x32=x33.join(x15);
        Formula x31=x27.in(x32);
        Formula x28=x31.forSome(x29);
        Formula x25=x28.forAll(x26);
        Expression x35=x7.join(x13);
        Formula x34=x35.no();
        Variable x38=Variable.unary("this");
        Decls x37=x38.oneOf(x21);
        Expression x40=x38.join(x12);
        Formula x39=x40.in(x11);
        Formula x36=x39.forAll(x37);
        Expression x42=x12.join(Expression.UNIV);
        Formula x41=x42.in(x21);
        Variable x46=Variable.unary("this");
        Decls x45=x46.oneOf(x21);
        Expression x49=x46.join(x13);
        Formula x48=x49.lone();
        Formula x50=x49.in(x21);
        Formula x47=x48.and(x50);
        Formula x44=x47.forAll(x45);
        Expression x52=x13.join(Expression.UNIV);
        Formula x51=x52.in(x21);
        Variable x55=Variable.unary("this");
        Decls x54=x55.oneOf(x21);
        Expression x59=x55.join(x13);
        Expression x62=x15.transpose();
        Expression x61=x55.join(x62);
        Expression x63=x12.transpose();
        Expression x60=x61.join(x63);
        Formula x58=x59.eq(x60);
        Variable x68=Variable.unary("e1");
        Expression x69=x55.join(x12);
        Decls x67=x68.oneOf(x69);
        Variable x71=Variable.unary("e2");
        Decls x70=x71.oneOf(x69);
        Decls x66=x67.and(x70);
        Expression x75=x68.join(x14);
        Expression x76=x71.join(x14);
        Formula x74=x75.eq(x76);
        Formula x73=x74.not();
        Formula x77=x68.eq(x71);
        Formula x72=x73.or(x77);
        Formula x65=x72.forAll(x66);
        Formula x81=x55.eq(x7);
        Formula x80=x81.not();
        Formula x79=x80.not();
        Expression x84=x13.closure();
        Expression x83=x55.join(x84);
        Formula x82=x7.in(x83);
        Formula x78=x79.or(x82);
        Formula x64=x65.and(x78);
        Formula x57=x58.and(x64);
        Expression x88=x13.closure();
        Expression x87=x55.join(x88);
        Formula x86=x55.in(x87);
        Formula x85=x86.not();
        Formula x56=x57.and(x85);
        Formula x53=x56.forAll(x54);
        Variable x91=Variable.unary("this");
        Decls x90=x91.oneOf(x11);
        Expression x94=x91.join(x14);
        Formula x93=x94.one();
        Formula x95=x94.in(x10);
        Formula x92=x93.and(x95);
        Formula x89=x92.forAll(x90);
        Expression x97=x14.join(Expression.UNIV);
        Formula x96=x97.in(x11);
        Variable x100=Variable.unary("this");
        Decls x99=x100.oneOf(x11);
        Expression x103=x100.join(x15);
        Formula x102=x103.one();
        Expression x105=x6.union(x21);
        Formula x104=x103.in(x105);
        Formula x101=x102.and(x104);
        Formula x98=x101.forAll(x99);
        Expression x107=x15.join(Expression.UNIV);
        Formula x106=x107.in(x11);
        Variable x110=Variable.unary("this");
        Decls x109=x110.oneOf(x11);
        Expression x113=x12.transpose();
        Expression x112=x110.join(x113);
        Formula x111=x112.one();
        Formula x108=x111.forAll(x109);
        Variable x119=Variable.unary("OneParent_buggyVersion_d");
        Expression x120=x21.difference(x7);
        Decls x118=x119.oneOf(x120);
        Expression x122=x119.join(x13);
        Formula x121=x122.one();
        Formula x117=x121.forAll(x118);
        Formula x116=x117.not();
        Variable x125=Variable.unary("NoDirAliases_o");
        Decls x124=x125.oneOf(x21);
        Expression x128=x15.transpose();
        Expression x127=x125.join(x128);
        Formula x126=x127.lone();
        Formula x123=x126.forAll(x124);
        Formula x115=x116.or(x123);
        Formula x114=x115.not();
        Formula x129=x0.eq(x0);
        Formula x130=x1.eq(x1);
        Formula x131=x2.eq(x2);
        Formula x132=x3.eq(x3);
        Formula x133=x4.eq(x4);
        Formula x134=x5.eq(x5);
        Formula x135=x6.eq(x6);
        Formula x136=x7.eq(x7);
        Formula x137=x8.eq(x8);
        Formula x138=x9.eq(x9);
        Formula x139=x10.eq(x10);
        Formula x140=x11.eq(x11);
        Formula x141=x12.eq(x12);
        Formula x142=x13.eq(x13);
        Formula x143=x14.eq(x14);
        Formula x144=x15.eq(x15);
        Formula x16=Formula.compose(FormulaOperator.AND, x17, x19, x23, x24, x25, x34, x36, x41, x44, x51, x53, x89, x96, x98, x106, x108, x114, x129, x130, x131, x132, x133, x134, x135, x136, x137, x138, x139, x140, x141, x142, x143, x144);

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