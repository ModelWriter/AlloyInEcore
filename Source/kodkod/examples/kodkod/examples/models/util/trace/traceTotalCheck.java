package kodkod.examples.models.util.trace;

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
        Name = "trace",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 2,
        TernaryRelations =0,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 6,
        TransitiveClosure = 2,
        NestedQuantifiers = 0,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 0,
        OrderedRelations = 1,
        Constraints = 4
)



public final class traceTotalCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/elem");
        Relation x7 = Relation.unary("this/Ord");
        Relation x8 = Relation.unary("this/back");
        Relation x9 = Relation.unary("this/Ord.First");
        Relation x10 = Relation.nary("this/Ord.Next", 2);
        Relation x11 = Relation.unary("");

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Ord$0",
                "elem$0", "elem$1", "elem$2"
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
        x6_upper.add(factory.tuple("elem$2"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Ord$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("elem$0"));
        x8_upper.add(factory.tuple("elem$1"));
        x8_upper.add(factory.tuple("elem$2"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("elem$0"));
        x9_upper.add(factory.tuple("elem$1"));
        x9_upper.add(factory.tuple("elem$2"));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(2);
        x10_upper.add(factory.tuple("elem$0").product(factory.tuple("elem$0")));
        x10_upper.add(factory.tuple("elem$0").product(factory.tuple("elem$1")));
        x10_upper.add(factory.tuple("elem$0").product(factory.tuple("elem$2")));
        x10_upper.add(factory.tuple("elem$1").product(factory.tuple("elem$0")));
        x10_upper.add(factory.tuple("elem$1").product(factory.tuple("elem$1")));
        x10_upper.add(factory.tuple("elem$1").product(factory.tuple("elem$2")));
        x10_upper.add(factory.tuple("elem$2").product(factory.tuple("elem$0")));
        x10_upper.add(factory.tuple("elem$2").product(factory.tuple("elem$1")));
        x10_upper.add(factory.tuple("elem$2").product(factory.tuple("elem$2")));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(1);
        x11_upper.add(factory.tuple("elem$0"));
        x11_upper.add(factory.tuple("elem$1"));
        x11_upper.add(factory.tuple("elem$2"));
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

        Formula x13=x8.in(x6);
        Formula x14=x8.lone();
        Expression x17=x7.product(x9);
        Expression x16=x7.join(x17);
        Formula x15=x16.in(x6);
        Expression x20=x7.product(x10);
        Expression x19=x7.join(x20);
        Expression x21=x6.product(x6);
        Formula x18=x19.in(x21);
        Formula x22=x10.totalOrder(x6,x9,x11);
        Expression x29=x10.join(x6);
        Expression x28=x6.difference(x29);
        Expression x27=x28.product(x8);
        Formula x26=x27.no();
        Formula x25=x26.not();
        Variable x34=Variable.unary("");
        Decls x33=x34.oneOf(x6);
        Formula x38=x34.eq(x9);
        Expression x41=x10.union(x27);
        Expression x40=x41.join(x34);
        Formula x39=x40.one();
        Formula x37=x38.or(x39);
        Expression x45=x41.join(x6);
        Expression x44=x6.difference(x45);
        Formula x43=x34.eq(x44);
        Expression x47=x34.join(x41);
        Formula x46=x47.one();
        Formula x42=x43.or(x46);
        Formula x36=x37.and(x42);
        Expression x51=x41.closure();
        Expression x50=x34.join(x51);
        Formula x49=x34.in(x50);
        Formula x48=x49.not();
        Formula x35=x36.and(x48);
        Formula x32=x35.forAll(x33);
        Expression x54=x41.reflexiveClosure();
        Expression x53=x9.join(x54);
        Formula x52=x6.in(x53);
        Formula x31=x32.and(x52);
        Expression x56=x41.join(x9);
        Formula x55=x56.no();
        Formula x30=x31.and(x55);
        Formula x24=x25.or(x30);
        Formula x23=x24.not();
        Formula x57=x0.eq(x0);
        Formula x58=x1.eq(x1);
        Formula x59=x2.eq(x2);
        Formula x60=x3.eq(x3);
        Formula x61=x4.eq(x4);
        Formula x62=x5.eq(x5);
        Formula x63=x6.eq(x6);
        Formula x64=x7.eq(x7);
        Formula x65=x8.eq(x8);
        Formula x66=x9.eq(x9);
        Formula x67=x10.eq(x10);
        Formula x68=x11.eq(x11);
        Formula x12=Formula.compose(FormulaOperator.AND, x13, x14, x15, x18, x22, x23, x57, x58, x59, x60, x61, x62, x63, x64, x65, x66, x67, x68);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x12,bounds);
        System.out.println(sol.toString());
    }}