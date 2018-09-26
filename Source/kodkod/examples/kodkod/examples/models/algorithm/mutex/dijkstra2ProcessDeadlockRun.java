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

public final class dijkstra2ProcessDeadlockRun {

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
                "Mutex$1", "Mutex$2", "Process$0", "Process$1", "Process$2", "State$0",
                "State$1", "State$2", "mo/Ord$0", "so/Ord$0"
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
        x6_upper.add(factory.tuple("Process$0"));
        x6_upper.add(factory.tuple("Process$1"));
        x6_upper.add(factory.tuple("Process$2"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Mutex$0"));
        x7_upper.add(factory.tuple("Mutex$1"));
        x7_upper.add(factory.tuple("Mutex$2"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("State$0"));
        x8_upper.add(factory.tuple("State$1"));
        x8_upper.add(factory.tuple("State$2"));
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
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$2")));
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$2")));
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$0").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$2")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$2")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$2")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$1").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$2")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$2")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$2")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$0")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$1")));
        x11_upper.add(factory.tuple("State$2").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$2")));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(3);
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$2")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$2")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$0").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$2")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$2")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$2")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$1").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$2")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$0")).product(factory.tuple("Mutex$2")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$1")).product(factory.tuple("Mutex$2")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$0")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$1")));
        x12_upper.add(factory.tuple("State$2").product(factory.tuple("Process$2")).product(factory.tuple("Mutex$2")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(1);
        x13_upper.add(factory.tuple("State$0"));
        x13_upper.add(factory.tuple("State$1"));
        x13_upper.add(factory.tuple("State$2"));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("State$0")));
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("State$1")));
        x14_upper.add(factory.tuple("State$0").product(factory.tuple("State$2")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("State$0")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("State$1")));
        x14_upper.add(factory.tuple("State$1").product(factory.tuple("State$2")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("State$0")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("State$1")));
        x14_upper.add(factory.tuple("State$2").product(factory.tuple("State$2")));
        bounds.bound(x14, x14_upper);

        TupleSet x15_upper = factory.noneOf(1);
        x15_upper.add(factory.tuple("Mutex$0"));
        x15_upper.add(factory.tuple("Mutex$1"));
        x15_upper.add(factory.tuple("Mutex$2"));
        bounds.bound(x15, x15_upper);

        TupleSet x16_upper = factory.noneOf(2);
        x16_upper.add(factory.tuple("Mutex$0").product(factory.tuple("Mutex$0")));
        x16_upper.add(factory.tuple("Mutex$0").product(factory.tuple("Mutex$1")));
        x16_upper.add(factory.tuple("Mutex$0").product(factory.tuple("Mutex$2")));
        x16_upper.add(factory.tuple("Mutex$1").product(factory.tuple("Mutex$0")));
        x16_upper.add(factory.tuple("Mutex$1").product(factory.tuple("Mutex$1")));
        x16_upper.add(factory.tuple("Mutex$1").product(factory.tuple("Mutex$2")));
        x16_upper.add(factory.tuple("Mutex$2").product(factory.tuple("Mutex$0")));
        x16_upper.add(factory.tuple("Mutex$2").product(factory.tuple("Mutex$1")));
        x16_upper.add(factory.tuple("Mutex$2").product(factory.tuple("Mutex$2")));
        bounds.bound(x16, x16_upper);

        TupleSet x17_upper = factory.noneOf(1);
        x17_upper.add(factory.tuple("State$0"));
        x17_upper.add(factory.tuple("State$1"));
        x17_upper.add(factory.tuple("State$2"));
        bounds.bound(x17, x17_upper);

        TupleSet x18_upper = factory.noneOf(1);
        x18_upper.add(factory.tuple("Mutex$0"));
        x18_upper.add(factory.tuple("Mutex$1"));
        x18_upper.add(factory.tuple("Mutex$2"));
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

        Variable x22=Variable.unary("Deadlock_this");
        Decls x21=x22.oneOf(x8);
        Expression x24=x22.join(x11);
        Expression x25=x6.product(x7);
        Formula x23=x24.in(x25);
        Formula x20=x23.forAll(x21);
        Expression x28=x11.join(Expression.UNIV);
        Expression x27=x28.join(Expression.UNIV);
        Formula x26=x27.in(x8);
        Variable x32=Variable.unary("Deadlock_this");
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
        Formula x55=x6.some();
        Variable x58=Variable.unary("Deadlock_s");
        Decls x57=x58.oneOf(x8);
        Variable x61=Variable.unary("Deadlock_p");
        Decls x60=x61.oneOf(x6);
        Expression x64=x58.join(x12);
        Expression x63=x61.join(x64);
        Formula x62=x63.some();
        Formula x59=x62.forAll(x60);
        Formula x56=x59.forSome(x57);
        Formula x65=x0.eq(x0);
        Formula x66=x1.eq(x1);
        Formula x67=x2.eq(x2);
        Formula x68=x3.eq(x3);
        Formula x69=x4.eq(x4);
        Formula x70=x5.eq(x5);
        Formula x71=x6.eq(x6);
        Formula x72=x7.eq(x7);
        Formula x73=x8.eq(x8);
        Formula x74=x9.eq(x9);
        Formula x75=x10.eq(x10);
        Formula x76=x11.eq(x11);
        Formula x77=x12.eq(x12);
        Formula x78=x13.eq(x13);
        Formula x79=x14.eq(x14);
        Formula x80=x15.eq(x15);
        Formula x81=x16.eq(x16);
        Formula x82=x17.eq(x17);
        Formula x83=x18.eq(x18);
        Formula x19=Formula.compose(FormulaOperator.AND, x20, x26, x30, x36, x39, x42, x46, x47, x50, x54, x55, x56, x65, x66, x67, x68, x69, x70, x71, x72, x73, x74, x75, x76, x77, x78, x79, x80, x81, x82, x83);

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