package kodkod.examples.models.model.java;

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
        Name = "javatypes",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 5,
        TernaryRelations = 0,
        NaryRelations = 0,
        HierarchicalTypes =2,
        NestedRelationalJoins = 2,
        TransitiveClosure = 3,
        NestedQuantifiers = 1,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 0,
        OrderedRelations = 0,
        Constraints = 7
)


public final class javatypesRun {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Object");
        Relation x7 = Relation.unary("this/Class remainder");
        Relation x8 = Relation.unary("this/Interface");
        Relation x9 = Relation.unary("this/Instance");
        Relation x10 = Relation.unary("this/Variable");
        Relation x11 = Relation.nary("this/Type.subtypes", 2);
        Relation x12 = Relation.nary("this/Instance.type", 2);
        Relation x13 = Relation.nary("this/Variable.holds", 2);
        Relation x14 = Relation.nary("this/Variable.type", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Instance$0",
                "Instance$1", "Instance$2", "Object$0", "Type$0", "Type$1", "Variable$0",
                "Variable$1", "Variable$2"
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
        x6_upper.add(factory.tuple("Object$0"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Type$0"));
        x7_upper.add(factory.tuple("Type$1"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Type$0"));
        x8_upper.add(factory.tuple("Type$1"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Instance$0"));
        x9_upper.add(factory.tuple("Instance$1"));
        x9_upper.add(factory.tuple("Instance$2"));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("Variable$0"));
        x10_upper.add(factory.tuple("Variable$1"));
        x10_upper.add(factory.tuple("Variable$2"));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(2);
        x11_upper.add(factory.tuple("Object$0").product(factory.tuple("Object$0")));
        x11_upper.add(factory.tuple("Object$0").product(factory.tuple("Type$0")));
        x11_upper.add(factory.tuple("Object$0").product(factory.tuple("Type$1")));
        x11_upper.add(factory.tuple("Type$0").product(factory.tuple("Object$0")));
        x11_upper.add(factory.tuple("Type$0").product(factory.tuple("Type$0")));
        x11_upper.add(factory.tuple("Type$0").product(factory.tuple("Type$1")));
        x11_upper.add(factory.tuple("Type$1").product(factory.tuple("Object$0")));
        x11_upper.add(factory.tuple("Type$1").product(factory.tuple("Type$0")));
        x11_upper.add(factory.tuple("Type$1").product(factory.tuple("Type$1")));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(2);
        x12_upper.add(factory.tuple("Instance$0").product(factory.tuple("Object$0")));
        x12_upper.add(factory.tuple("Instance$0").product(factory.tuple("Type$0")));
        x12_upper.add(factory.tuple("Instance$0").product(factory.tuple("Type$1")));
        x12_upper.add(factory.tuple("Instance$1").product(factory.tuple("Object$0")));
        x12_upper.add(factory.tuple("Instance$1").product(factory.tuple("Type$0")));
        x12_upper.add(factory.tuple("Instance$1").product(factory.tuple("Type$1")));
        x12_upper.add(factory.tuple("Instance$2").product(factory.tuple("Object$0")));
        x12_upper.add(factory.tuple("Instance$2").product(factory.tuple("Type$0")));
        x12_upper.add(factory.tuple("Instance$2").product(factory.tuple("Type$1")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(2);
        x13_upper.add(factory.tuple("Variable$0").product(factory.tuple("Instance$0")));
        x13_upper.add(factory.tuple("Variable$0").product(factory.tuple("Instance$1")));
        x13_upper.add(factory.tuple("Variable$0").product(factory.tuple("Instance$2")));
        x13_upper.add(factory.tuple("Variable$1").product(factory.tuple("Instance$0")));
        x13_upper.add(factory.tuple("Variable$1").product(factory.tuple("Instance$1")));
        x13_upper.add(factory.tuple("Variable$1").product(factory.tuple("Instance$2")));
        x13_upper.add(factory.tuple("Variable$2").product(factory.tuple("Instance$0")));
        x13_upper.add(factory.tuple("Variable$2").product(factory.tuple("Instance$1")));
        x13_upper.add(factory.tuple("Variable$2").product(factory.tuple("Instance$2")));
        bounds.bound(x13, x13_upper);

        TupleSet x14_upper = factory.noneOf(2);
        x14_upper.add(factory.tuple("Variable$0").product(factory.tuple("Object$0")));
        x14_upper.add(factory.tuple("Variable$0").product(factory.tuple("Type$0")));
        x14_upper.add(factory.tuple("Variable$0").product(factory.tuple("Type$1")));
        x14_upper.add(factory.tuple("Variable$1").product(factory.tuple("Object$0")));
        x14_upper.add(factory.tuple("Variable$1").product(factory.tuple("Type$0")));
        x14_upper.add(factory.tuple("Variable$1").product(factory.tuple("Type$1")));
        x14_upper.add(factory.tuple("Variable$2").product(factory.tuple("Object$0")));
        x14_upper.add(factory.tuple("Variable$2").product(factory.tuple("Type$0")));
        x14_upper.add(factory.tuple("Variable$2").product(factory.tuple("Type$1")));
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

        Expression x18=x6.union(x7);
        Expression x17=x18.intersection(x8);
        Formula x16=x17.no();
        Variable x21=Variable.unary("Show_this");
        Expression x22=x18.union(x8);
        Decls x20=x21.oneOf(x22);
        Expression x24=x21.join(x11);
        Formula x23=x24.in(x22);
        Formula x19=x23.forAll(x20);
        Expression x26=x11.join(Expression.UNIV);
        Formula x25=x26.in(x22);
        Variable x30=Variable.unary("Show_this");
        Decls x29=x30.oneOf(x9);
        Expression x33=x30.join(x12);
        Formula x32=x33.one();
        Formula x34=x33.in(x18);
        Formula x31=x32.and(x34);
        Formula x28=x31.forAll(x29);
        Expression x36=x12.join(Expression.UNIV);
        Formula x35=x36.in(x9);
        Variable x39=Variable.unary("Show_this");
        Decls x38=x39.oneOf(x10);
        Expression x42=x39.join(x13);
        Formula x41=x42.lone();
        Formula x43=x42.in(x9);
        Formula x40=x41.and(x43);
        Formula x37=x40.forAll(x38);
        Expression x45=x13.join(Expression.UNIV);
        Formula x44=x45.in(x10);
        Variable x48=Variable.unary("Show_this");
        Decls x47=x48.oneOf(x10);
        Expression x51=x48.join(x14);
        Formula x50=x51.one();
        Formula x52=x51.in(x22);
        Formula x49=x50.and(x52);
        Formula x46=x49.forAll(x47);
        Expression x54=x14.join(Expression.UNIV);
        Formula x53=x54.in(x10);
        Expression x58=x11.closure();
        Expression x65=Expression.INTS.union(x5);
        Expression x64=x65.union(x22);
        Expression x63=x64.union(x9);
        Expression x62=x63.union(x10);
        Expression x61=x62.product(Expression.UNIV);
        Expression x59=Expression.IDEN.intersection(x61);
        Expression x57=x58.union(x59);
        Expression x56=x6.join(x57);
        Formula x55=x22.in(x56);
        Variable x69=Variable.unary("Show_t");
        Decls x68=x69.oneOf(x22);
        Expression x73=x11.closure();
        Expression x72=x69.join(x73);
        Formula x71=x69.in(x72);
        Formula x70=x71.not();
        Formula x67=x70.forAll(x68);
        Variable x76=Variable.unary("Show_t");
        Decls x75=x76.oneOf(x22);
        Expression x80=x11.transpose();
        Expression x79=x76.join(x80);
        Expression x78=x79.intersection(x18);
        Formula x77=x78.lone();
        Formula x74=x77.forAll(x75);
        Variable x83=Variable.unary("Show_v");
        Decls x82=x83.oneOf(x10);
        Expression x86=x83.join(x13);
        Expression x85=x86.join(x12);
        Expression x88=x83.join(x14);
        Expression x90=x11.closure();
        Expression x92=x62.product(Expression.UNIV);
        Expression x91=Expression.IDEN.intersection(x92);
        Expression x89=x90.union(x91);
        Expression x87=x88.join(x89);
        Formula x84=x85.in(x87);
        Formula x81=x84.forAll(x82);
        Expression x94=x18.difference(x6);
        Formula x93=x94.some();
        Formula x95=x8.some();
        Expression x98=x10.join(x14);
        Expression x97=x98.intersection(x8);
        Formula x96=x97.some();
        Formula x99=x0.eq(x0);
        Formula x100=x1.eq(x1);
        Formula x101=x2.eq(x2);
        Formula x102=x3.eq(x3);
        Formula x103=x4.eq(x4);
        Formula x104=x5.eq(x5);
        Formula x105=x6.eq(x6);
        Formula x106=x7.eq(x7);
        Formula x107=x8.eq(x8);
        Formula x108=x9.eq(x9);
        Formula x109=x10.eq(x10);
        Formula x110=x11.eq(x11);
        Formula x111=x12.eq(x12);
        Formula x112=x13.eq(x13);
        Formula x113=x14.eq(x14);
        Formula x15=Formula.compose(FormulaOperator.AND, x16, x19, x25, x28, x35, x37, x44, x46, x53, x55, x67, x74, x81, x93, x95, x96, x99, x100, x101, x102, x103, x104, x105, x106, x107, x108, x109, x110, x111, x112, x113);

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