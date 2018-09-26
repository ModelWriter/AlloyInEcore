package kodkod.examples.models.softwareAbstractions.chapter6.memory;

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
        Name = "cacheMemory",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 1,
        TernaryRelations =2,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 3,
        TransitiveClosure = 0,
        NestedQuantifiers = 1,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 9,
        OrderedRelations = 0,
        Constraints = 12
)



public final class cacheMemoryLoadNotObservableCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Addr");
        Relation x7 = Relation.unary("this/Data");
        Relation x8 = Relation.unary("this/CacheSystem");
        Relation x9 = Relation.nary("this/CacheSystem.main", 3);
        Relation x10 = Relation.nary("this/CacheSystem.cache", 3);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Addr$0",
                "Addr$1", "Addr$2", "CacheSystem$0", "CacheSystem$1", "CacheSystem$2", "Data$0",
                "Data$1", "Data$2"
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
        x6_upper.add(factory.tuple("Addr$0"));
        x6_upper.add(factory.tuple("Addr$1"));
        x6_upper.add(factory.tuple("Addr$2"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Data$0"));
        x7_upper.add(factory.tuple("Data$1"));
        x7_upper.add(factory.tuple("Data$2"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("CacheSystem$0"));
        x8_upper.add(factory.tuple("CacheSystem$1"));
        x8_upper.add(factory.tuple("CacheSystem$2"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(3);
        x9_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$0")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$0")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$0")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$1")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$1")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$1")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$2")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$2")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$2")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$0")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$0")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$0")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$1")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$1")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$1")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$2")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$2")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$2")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$0")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$0")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$0")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$1")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$1")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$1")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$2")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$2")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$2")).product(factory.tuple("Data$2")));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(3);
        x10_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$0")).product(factory.tuple("Data$0")));
        x10_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$0")).product(factory.tuple("Data$1")));
        x10_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$0")).product(factory.tuple("Data$2")));
        x10_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$1")).product(factory.tuple("Data$0")));
        x10_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$1")).product(factory.tuple("Data$1")));
        x10_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$1")).product(factory.tuple("Data$2")));
        x10_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$2")).product(factory.tuple("Data$0")));
        x10_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$2")).product(factory.tuple("Data$1")));
        x10_upper.add(factory.tuple("CacheSystem$0").product(factory.tuple("Addr$2")).product(factory.tuple("Data$2")));
        x10_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$0")).product(factory.tuple("Data$0")));
        x10_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$0")).product(factory.tuple("Data$1")));
        x10_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$0")).product(factory.tuple("Data$2")));
        x10_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$1")).product(factory.tuple("Data$0")));
        x10_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$1")).product(factory.tuple("Data$1")));
        x10_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$1")).product(factory.tuple("Data$2")));
        x10_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$2")).product(factory.tuple("Data$0")));
        x10_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$2")).product(factory.tuple("Data$1")));
        x10_upper.add(factory.tuple("CacheSystem$1").product(factory.tuple("Addr$2")).product(factory.tuple("Data$2")));
        x10_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$0")).product(factory.tuple("Data$0")));
        x10_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$0")).product(factory.tuple("Data$1")));
        x10_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$0")).product(factory.tuple("Data$2")));
        x10_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$1")).product(factory.tuple("Data$0")));
        x10_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$1")).product(factory.tuple("Data$1")));
        x10_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$1")).product(factory.tuple("Data$2")));
        x10_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$2")).product(factory.tuple("Data$0")));
        x10_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$2")).product(factory.tuple("Data$1")));
        x10_upper.add(factory.tuple("CacheSystem$2").product(factory.tuple("Addr$2")).product(factory.tuple("Data$2")));
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

        Variable x14=Variable.unary("LoadNotObservable_this");
        Decls x13=x14.oneOf(x8);
        Expression x18=x14.join(x9);
        Expression x19=x6.product(x7);
        Formula x17=x18.in(x19);
        Variable x22=Variable.unary("");
        Decls x21=x22.oneOf(x6);
        Expression x25=x22.join(x18);
        Formula x24=x25.lone();
        Formula x26=x25.in(x7);
        Formula x23=x24.and(x26);
        Formula x20=x23.forAll(x21);
        Formula x16=x17.and(x20);
        Variable x29=Variable.unary("");
        Decls x28=x29.oneOf(x7);
        Expression x31=x18.join(x29);
        Formula x30=x31.in(x6);
        Formula x27=x30.forAll(x28);
        Formula x15=x16.and(x27);
        Formula x12=x15.forAll(x13);
        Expression x34=x9.join(Expression.UNIV);
        Expression x33=x34.join(Expression.UNIV);
        Formula x32=x33.in(x8);
        Variable x38=Variable.unary("LoadNotObservable_this");
        Decls x37=x38.oneOf(x8);
        Expression x42=x38.join(x10);
        Expression x43=x6.product(x7);
        Formula x41=x42.in(x43);
        Variable x46=Variable.unary("");
        Decls x45=x46.oneOf(x6);
        Expression x49=x46.join(x42);
        Formula x48=x49.lone();
        Formula x50=x49.in(x7);
        Formula x47=x48.and(x50);
        Formula x44=x47.forAll(x45);
        Formula x40=x41.and(x44);
        Variable x53=Variable.unary("");
        Decls x52=x53.oneOf(x7);
        Expression x55=x42.join(x53);
        Formula x54=x55.in(x6);
        Formula x51=x54.forAll(x52);
        Formula x39=x40.and(x51);
        Formula x36=x39.forAll(x37);
        Expression x58=x10.join(Expression.UNIV);
        Expression x57=x58.join(Expression.UNIV);
        Formula x56=x57.in(x8);
        Variable x63=Variable.unary("LoadNotObservable_c");
        Decls x62=x63.oneOf(x8);
        Variable x65=Variable.unary("LoadNotObservable_c'");
        Decls x64=x65.oneOf(x8);
        Variable x67=Variable.unary("LoadNotObservable_c");
                Decls x66=x67.oneOf(x8);
        Variable x69=Variable.unary("LoadNotObservable_a1");
        Decls x68=x69.oneOf(x6);
        Variable x71=Variable.unary("LoadNotObservable_a2");
        Decls x70=x71.oneOf(x6);
        Variable x73=Variable.unary("LoadNotObservable_d1");
        Decls x72=x73.oneOf(x7);
        Variable x75=Variable.unary("LoadNotObservable_d2");
        Decls x74=x75.oneOf(x7);
        Variable x77=Variable.unary("LoadNotObservable_d3");
        Decls x76=x77.oneOf(x7);
        Decls x61=x62.and(x64).and(x66).and(x68).and(x70).and(x72).and(x74).and(x76);
        Formula x83=x75.some();
        Expression x86=x63.join(x10);
        Expression x85=x71.join(x86);
        Formula x84=x75.eq(x85);
        Formula x82=x83.and(x84);
        Expression x90=x65.join(x9);
        Expression x91=x63.join(x9);
        Formula x89=x90.eq(x91);
        Expression x93=x65.join(x10);
        Expression x95=x63.join(x10);
        Expression x96=x69.product(x73);
        Expression x94=x95.override(x96);
        Formula x92=x93.eq(x94);
        Formula x88=x89.and(x92);
        Formula x98=x77.some();
        Expression x101=x67.join(x10);
        Expression x100=x71.join(x101);
        Formula x99=x77.eq(x100);
        Formula x97=x98.and(x99);
        Formula x87=x88.and(x97);
        Formula x81=x82.and(x87);
        Variable x105=Variable.unary("load_addrs");
        Expression x108=x65.join(x9);
        Expression x107=x108.join(x7);
        Expression x110=x65.join(x10);
        Expression x109=x110.join(x7);
        Expression x106=x107.difference(x109);
        Decls x104=x105.setOf(x106);
        Expression x112=x67.join(x10);
        Expression x114=x65.join(x10);
        Expression x116=x105.product(Expression.UNIV);
        Expression x117=x65.join(x9);
        Expression x115=x116.intersection(x117);
        Expression x113=x114.override(x115);
        Formula x111=x112.eq(x113);
        Formula x103=x111.forSome(x104);
        Expression x119=x67.join(x9);
        Expression x120=x65.join(x9);
        Formula x118=x119.eq(x120);
        Formula x102=x103.and(x118);
        Formula x80=x81.and(x102);
        Formula x79=x80.not();
        Formula x123=x69.eq(x71);
        Expression x122=x123.thenElse(x73,x75);
        Formula x121=x77.eq(x122);
        Formula x78=x79.or(x121);
        Formula x60=x78.forAll(x61);
        Formula x59=x60.not();
        Formula x124=x0.eq(x0);
        Formula x125=x1.eq(x1);
        Formula x126=x2.eq(x2);
        Formula x127=x3.eq(x3);
        Formula x128=x4.eq(x4);
        Formula x129=x5.eq(x5);
        Formula x130=x6.eq(x6);
        Formula x131=x7.eq(x7);
        Formula x132=x8.eq(x8);
        Formula x133=x9.eq(x9);
        Formula x134=x10.eq(x10);
        Formula x11=Formula.compose(FormulaOperator.AND, x12, x32, x36, x56, x59, x124, x125, x126, x127, x128, x129, x130, x131, x132, x133, x134);

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