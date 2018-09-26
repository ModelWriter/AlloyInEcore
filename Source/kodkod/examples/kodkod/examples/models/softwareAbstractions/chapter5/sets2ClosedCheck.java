package kodkod.examples.models.softwareAbstractions.chapter5;

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
        Name = "addressBook",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 2,
        TernaryRelations =0,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 0,
        TransitiveClosure = 0,
        NestedQuantifiers = 3,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 2,
        OrderedRelations = 0,
        Constraints = 3
)


public final class sets2ClosedCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Set");
        Relation x7 = Relation.unary("this/Element");
        Relation x8 = Relation.nary("this/Set.elements", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Element$0",
                "Element$1", "Element$2", "Element$3", "Set$0", "Set$1", "Set$10",
                "Set$11", "Set$12", "Set$13", "Set$14", "Set$15", "Set$2",
                "Set$3", "Set$4", "Set$5", "Set$6", "Set$7", "Set$8",
                "Set$9"
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
        x6_upper.add(factory.tuple("Set$0"));
        x6_upper.add(factory.tuple("Set$1"));
        x6_upper.add(factory.tuple("Set$2"));
        x6_upper.add(factory.tuple("Set$3"));
        x6_upper.add(factory.tuple("Set$4"));
        x6_upper.add(factory.tuple("Set$5"));
        x6_upper.add(factory.tuple("Set$6"));
        x6_upper.add(factory.tuple("Set$7"));
        x6_upper.add(factory.tuple("Set$8"));
        x6_upper.add(factory.tuple("Set$9"));
        x6_upper.add(factory.tuple("Set$10"));
        x6_upper.add(factory.tuple("Set$11"));
        x6_upper.add(factory.tuple("Set$12"));
        x6_upper.add(factory.tuple("Set$13"));
        x6_upper.add(factory.tuple("Set$14"));
        x6_upper.add(factory.tuple("Set$15"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Element$0"));
        x7_upper.add(factory.tuple("Element$1"));
        x7_upper.add(factory.tuple("Element$2"));
        x7_upper.add(factory.tuple("Element$3"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(2);
        x8_upper.add(factory.tuple("Set$0").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$0").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$0").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$0").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$1").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$1").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$1").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$1").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$2").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$2").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$2").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$2").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$3").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$3").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$3").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$3").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$4").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$4").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$4").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$4").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$5").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$5").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$5").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$5").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$6").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$6").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$6").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$6").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$7").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$7").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$7").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$7").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$8").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$8").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$8").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$8").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$9").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$9").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$9").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$9").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$10").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$10").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$10").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$10").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$11").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$11").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$11").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$11").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$12").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$12").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$12").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$12").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$13").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$13").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$13").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$13").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$14").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$14").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$14").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$14").product(factory.tuple("Element$3")));
        x8_upper.add(factory.tuple("Set$15").product(factory.tuple("Element$0")));
        x8_upper.add(factory.tuple("Set$15").product(factory.tuple("Element$1")));
        x8_upper.add(factory.tuple("Set$15").product(factory.tuple("Element$2")));
        x8_upper.add(factory.tuple("Set$15").product(factory.tuple("Element$3")));
        bounds.bound(x8, x8_upper);

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

        Variable x12=Variable.unary("Closed_this");
        Decls x11=x12.oneOf(x6);
        Expression x14=x12.join(x8);
        Formula x13=x14.in(x7);
        Formula x10=x13.forAll(x11);
        Expression x16=x8.join(Expression.UNIV);
        Formula x15=x16.in(x6);
        Variable x20=Variable.unary("Closed_s");
        Decls x19=x20.oneOf(x6);
        Expression x22=x20.join(x8);
        Formula x21=x22.no();
        Formula x18=x21.forSome(x19);
        Variable x26=Variable.unary("Closed_s");
        Decls x25=x26.oneOf(x6);
        Variable x28=Variable.unary("Closed_e");
        Decls x27=x28.oneOf(x7);
        Decls x24=x25.and(x27);
        Variable x31=Variable.unary("Closed_s'");
        Decls x30=x31.oneOf(x6);
        Expression x33=x31.join(x8);
        Expression x35=x26.join(x8);
        Expression x34=x35.union(x28);
        Formula x32=x33.eq(x34);
        Formula x29=x32.forSome(x30);
        Formula x23=x29.forAll(x24);
        Variable x40=Variable.unary("Closed_s0");
        Decls x39=x40.oneOf(x6);
        Variable x42=Variable.unary("Closed_s1");
        Decls x41=x42.oneOf(x6);
        Decls x38=x39.and(x41);
        Variable x45=Variable.unary("Closed_s2");
        Decls x44=x45.oneOf(x6);
        Expression x47=x45.join(x8);
        Expression x49=x40.join(x8);
        Expression x50=x42.join(x8);
        Expression x48=x49.union(x50);
        Formula x46=x47.eq(x48);
        Formula x43=x46.forSome(x44);
        Formula x37=x43.forAll(x38);
        Formula x36=x37.not();
        Formula x51=x0.eq(x0);
        Formula x52=x1.eq(x1);
        Formula x53=x2.eq(x2);
        Formula x54=x3.eq(x3);
        Formula x55=x4.eq(x4);
        Formula x56=x5.eq(x5);
        Formula x57=x6.eq(x6);
        Formula x58=x7.eq(x7);
        Formula x59=x8.eq(x8);
        Formula x9=Formula.compose(FormulaOperator.AND, x10, x15, x18, x23, x36, x51, x52, x53, x54, x55, x56, x57, x58, x59);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
       // solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x9,bounds);
        System.out.println(sol.toString());
    }}