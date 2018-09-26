package kodkod.examples.models.softwareAbstractions.chapter4;

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
        Name = "filesystem",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 2,
        TernaryRelations =0,
        NaryRelations = 0,
        HierarchicalTypes =3,
        NestedRelationalJoins = 0,
        TransitiveClosure = 1,
        NestedQuantifiers = 2,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 0,
        OrderedRelations = 0,
        Constraints = 4
)

public final class filesystemRootTopCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Root");
        Relation x7 = Relation.unary("this/Dir remainder");
        Relation x8 = Relation.unary("this/File");
        Relation x9 = Relation.nary("this/Dir.contents", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Object$0",
                "Object$1", "Root$0"
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
        x6_upper.add(factory.tuple("Root$0"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Object$0"));
        x7_upper.add(factory.tuple("Object$1"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Object$0"));
        x8_upper.add(factory.tuple("Object$1"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(2);
        x9_upper.add(factory.tuple("Root$0").product(factory.tuple("Root$0")));
        x9_upper.add(factory.tuple("Root$0").product(factory.tuple("Object$0")));
        x9_upper.add(factory.tuple("Root$0").product(factory.tuple("Object$1")));
        x9_upper.add(factory.tuple("Object$0").product(factory.tuple("Root$0")));
        x9_upper.add(factory.tuple("Object$0").product(factory.tuple("Object$0")));
        x9_upper.add(factory.tuple("Object$0").product(factory.tuple("Object$1")));
        x9_upper.add(factory.tuple("Object$1").product(factory.tuple("Root$0")));
        x9_upper.add(factory.tuple("Object$1").product(factory.tuple("Object$0")));
        x9_upper.add(factory.tuple("Object$1").product(factory.tuple("Object$1")));
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

        Expression x13=x6.union(x7);
        Expression x12=x13.intersection(x8);
        Formula x11=x12.no();
        Variable x16=Variable.unary("RootTop_this");
        Decls x15=x16.oneOf(x13);
        Expression x18=x16.join(x9);
        Expression x19=x13.union(x8);
        Formula x17=x18.in(x19);
        Formula x14=x17.forAll(x15);
        Expression x21=x9.join(Expression.UNIV);
        Formula x20=x21.in(x13);
        Expression x26=x9.closure();
        Expression x31=Expression.INTS.union(x5);
        Expression x30=x31.union(x19);
        Expression x29=x30.product(Expression.UNIV);
        Expression x27=Expression.IDEN.intersection(x29);
        Expression x25=x26.union(x27);
        Expression x24=x6.join(x25);
        Formula x23=x19.in(x24);
        Variable x36=Variable.unary("RootTop_o");
        Decls x35=x36.oneOf(x19);
        Expression x39=x36.join(x9);
        Formula x38=x6.in(x39);
        Formula x37=x38.not();
        Formula x34=x37.forAll(x35);
        Formula x33=x34.not();
        Formula x40=x0.eq(x0);
        Formula x41=x1.eq(x1);
        Formula x42=x2.eq(x2);
        Formula x43=x3.eq(x3);
        Formula x44=x4.eq(x4);
        Formula x45=x5.eq(x5);
        Formula x46=x6.eq(x6);
        Formula x47=x7.eq(x7);
        Formula x48=x8.eq(x8);
        Formula x49=x9.eq(x9);
        Formula x10=Formula.compose(FormulaOperator.AND, x11, x14, x20, x23, x33, x40, x41, x42, x43, x44, x45, x46, x47, x48, x49);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
       // solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x10,bounds);
        System.out.println(sol.toString());
    }}