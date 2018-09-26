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
        Name = "abstractMemory",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 1,
        TernaryRelations =1,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 1,
        TransitiveClosure = 0,
        NestedQuantifiers = 0,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 5,
        OrderedRelations = 0,
        Constraints = 8
)



public final class abstractMemoryWriteIdempotentCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Addr");
        Relation x7 = Relation.unary("this/Data");
        Relation x8 = Relation.unary("this/Memory");
        Relation x9 = Relation.nary("this/Memory.data", 3);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Addr$0",
                "Addr$1", "Addr$2", "Data$0", "Data$1", "Data$2", "Memory$0",
                "Memory$1", "Memory$2"
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
        x8_upper.add(factory.tuple("Memory$0"));
        x8_upper.add(factory.tuple("Memory$1"));
        x8_upper.add(factory.tuple("Memory$2"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(3);
        x9_upper.add(factory.tuple("Memory$0").product(factory.tuple("Addr$0")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("Memory$0").product(factory.tuple("Addr$0")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("Memory$0").product(factory.tuple("Addr$0")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("Memory$0").product(factory.tuple("Addr$1")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("Memory$0").product(factory.tuple("Addr$1")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("Memory$0").product(factory.tuple("Addr$1")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("Memory$0").product(factory.tuple("Addr$2")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("Memory$0").product(factory.tuple("Addr$2")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("Memory$0").product(factory.tuple("Addr$2")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("Memory$1").product(factory.tuple("Addr$0")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("Memory$1").product(factory.tuple("Addr$0")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("Memory$1").product(factory.tuple("Addr$0")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("Memory$1").product(factory.tuple("Addr$1")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("Memory$1").product(factory.tuple("Addr$1")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("Memory$1").product(factory.tuple("Addr$1")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("Memory$1").product(factory.tuple("Addr$2")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("Memory$1").product(factory.tuple("Addr$2")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("Memory$1").product(factory.tuple("Addr$2")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("Memory$2").product(factory.tuple("Addr$0")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("Memory$2").product(factory.tuple("Addr$0")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("Memory$2").product(factory.tuple("Addr$0")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("Memory$2").product(factory.tuple("Addr$1")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("Memory$2").product(factory.tuple("Addr$1")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("Memory$2").product(factory.tuple("Addr$1")).product(factory.tuple("Data$2")));
        x9_upper.add(factory.tuple("Memory$2").product(factory.tuple("Addr$2")).product(factory.tuple("Data$0")));
        x9_upper.add(factory.tuple("Memory$2").product(factory.tuple("Addr$2")).product(factory.tuple("Data$1")));
        x9_upper.add(factory.tuple("Memory$2").product(factory.tuple("Addr$2")).product(factory.tuple("Data$2")));
        bounds.bound(x9, x9_upper);

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

        Variable x13=Variable.unary("WriteIdempotent_this");
        Decls x12=x13.oneOf(x8);
        Expression x17=x13.join(x9);
        Expression x18=x6.product(x7);
        Formula x16=x17.in(x18);
        Variable x21=Variable.unary("");
        Decls x20=x21.oneOf(x6);
        Expression x24=x21.join(x17);
        Formula x23=x24.lone();
        Formula x25=x24.in(x7);
        Formula x22=x23.and(x25);
        Formula x19=x22.forAll(x20);
        Formula x15=x16.and(x19);
        Variable x28=Variable.unary("");
        Decls x27=x28.oneOf(x7);
        Expression x30=x17.join(x28);
        Formula x29=x30.in(x6);
        Formula x26=x29.forAll(x27);
        Formula x14=x15.and(x26);
        Formula x11=x14.forAll(x12);
        Expression x33=x9.join(Expression.UNIV);
        Expression x32=x33.join(Expression.UNIV);
        Formula x31=x32.in(x8);
        Variable x38=Variable.unary("WriteIdempotent_m");
        Decls x37=x38.oneOf(x8);
        Variable x40=Variable.unary("WriteIdempotent_m'");
        Decls x39=x40.oneOf(x8);
        Decls x36=x37.and(x39);
        Expression x44=x38.intersection(x40);
        Formula x43=x44.no();
        Expression x46=x38.join(x9);
        Expression x47=x40.join(x9);
        Formula x45=x46.eq(x47);
        Formula x42=x43.and(x45);
        Formula x41=x42.not();
        Formula x35=x41.forAll(x36);
        Variable x52=Variable.unary("WriteIdempotent_m");
        Decls x51=x52.oneOf(x8);
        Variable x54=Variable.unary("WriteIdempotent_m'");
        Decls x53=x54.oneOf(x8);
        Variable x56=Variable.unary("WriteIdempotent_m");
                Decls x55=x56.oneOf(x8);
        Variable x58=Variable.unary("WriteIdempotent_a");
        Decls x57=x58.oneOf(x6);
        Variable x60=Variable.unary("WriteIdempotent_d");
        Decls x59=x60.oneOf(x7);
        Decls x50=x51.and(x53).and(x55).and(x57).and(x59);
        Expression x65=x54.join(x9);
        Expression x67=x52.join(x9);
        Expression x68=x58.product(x60);
        Expression x66=x67.override(x68);
        Formula x64=x65.eq(x66);
        Expression x70=x56.join(x9);
        Expression x72=x54.join(x9);
        Expression x73=x58.product(x60);
        Expression x71=x72.override(x73);
        Formula x69=x70.eq(x71);
        Formula x63=x64.and(x69);
        Formula x62=x63.not();
        Formula x74=x54.eq(x56);
        Formula x61=x62.or(x74);
        Formula x49=x61.forAll(x50);
        Formula x48=x49.not();
        Formula x75=x0.eq(x0);
        Formula x76=x1.eq(x1);
        Formula x77=x2.eq(x2);
        Formula x78=x3.eq(x3);
        Formula x79=x4.eq(x4);
        Formula x80=x5.eq(x5);
        Formula x81=x6.eq(x6);
        Formula x82=x7.eq(x7);
        Formula x83=x8.eq(x8);
        Formula x84=x9.eq(x9);
        Formula x10=Formula.compose(FormulaOperator.AND, x11, x31, x35, x48, x75, x76, x77, x78, x79, x80, x81, x82, x83, x84);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x10,bounds);
        System.out.println(sol.toString());
    }}