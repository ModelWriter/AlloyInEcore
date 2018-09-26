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
        BinaryRelations = 1,
        TernaryRelations =1,
        NaryRelations = 0,
        HierarchicalTypes =2,
        NestedRelationalJoins = 2,
        TransitiveClosure = 3,
        NestedQuantifiers = 1,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 2,
        OrderedRelations = 0,
        Constraints = 4
)



public final class addressBookAddLocalCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Addr");
        Relation x7 = Relation.unary("this/Name");
        Relation x8 = Relation.unary("this/Book");
        Relation x9 = Relation.nary("this/Book.addr", 3);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Book$0",
                "Book$1", "Target$0", "Target$1", "Target$2"
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
        x8_upper.add(factory.tuple("Book$0"));
        x8_upper.add(factory.tuple("Book$1"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(3);
        x9_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$0")).product(factory.tuple("Target$0")));
        x9_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$0")).product(factory.tuple("Target$1")));
        x9_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$0")).product(factory.tuple("Target$2")));
        x9_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$1")).product(factory.tuple("Target$0")));
        x9_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$1")).product(factory.tuple("Target$1")));
        x9_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$1")).product(factory.tuple("Target$2")));
        x9_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$2")).product(factory.tuple("Target$0")));
        x9_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$2")).product(factory.tuple("Target$1")));
        x9_upper.add(factory.tuple("Book$0").product(factory.tuple("Target$2")).product(factory.tuple("Target$2")));
        x9_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$0")).product(factory.tuple("Target$0")));
        x9_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$0")).product(factory.tuple("Target$1")));
        x9_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$0")).product(factory.tuple("Target$2")));
        x9_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$1")).product(factory.tuple("Target$0")));
        x9_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$1")).product(factory.tuple("Target$1")));
        x9_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$1")).product(factory.tuple("Target$2")));
        x9_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$2")).product(factory.tuple("Target$0")));
        x9_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$2")).product(factory.tuple("Target$1")));
        x9_upper.add(factory.tuple("Book$1").product(factory.tuple("Target$2")).product(factory.tuple("Target$2")));
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

        Expression x12=x6.intersection(x7);
        Formula x11=x12.no();
        Variable x15=Variable.unary("addLocal_this");
        Decls x14=x15.oneOf(x8);
        Expression x17=x15.join(x9);
        Expression x19=x6.union(x7);
        Expression x18=x7.product(x19);
        Formula x16=x17.in(x18);
        Formula x13=x16.forAll(x14);
        Expression x22=x9.join(Expression.UNIV);
        Expression x21=x22.join(Expression.UNIV);
        Formula x20=x21.in(x8);
        Variable x26=Variable.unary("addLocal_b");
        Decls x25=x26.oneOf(x8);
        Variable x29=Variable.unary("addLocal_n");
        Decls x28=x29.oneOf(x7);
        Expression x34=x26.join(x9);
        Expression x33=x34.closure();
        Expression x32=x29.join(x33);
        Formula x31=x29.in(x32);
        Formula x30=x31.not();
        Formula x27=x30.forAll(x28);
        Formula x24=x27.forAll(x25);
        Variable x39=Variable.unary("addLocal_b");
        Decls x38=x39.oneOf(x8);
        Variable x41=Variable.unary("addLocal_b'");
        Decls x40=x41.oneOf(x8);
        Variable x43=Variable.unary("addLocal_n");
        Decls x42=x43.oneOf(x7);
        Variable x45=Variable.unary("addLocal_n'");
        Decls x44=x45.oneOf(x7);
        Variable x47=Variable.unary("addLocal_t");
        Decls x46=x47.oneOf(x19);
        Decls x37=x38.and(x40).and(x42).and(x44).and(x46);
        Expression x52=x41.join(x9);
        Expression x54=x39.join(x9);
        Expression x55=x43.product(x47);
        Expression x53=x54.union(x55);
        Formula x51=x52.eq(x53);
        Formula x57=x43.eq(x45);
        Formula x56=x57.not();
        Formula x50=x51.and(x56);
        Formula x49=x50.not();
        Expression x62=x39.join(x9);
        Expression x61=x62.closure();
        Expression x60=x45.join(x61);
        Expression x59=x60.intersection(x6);
        Expression x66=x41.join(x9);
        Expression x65=x66.closure();
        Expression x64=x45.join(x65);
        Expression x63=x64.intersection(x6);
        Formula x58=x59.eq(x63);
        Formula x48=x49.or(x58);
        Formula x36=x48.forAll(x37);
        Formula x35=x36.not();
        Formula x67=x0.eq(x0);
        Formula x68=x1.eq(x1);
        Formula x69=x2.eq(x2);
        Formula x70=x3.eq(x3);
        Formula x71=x4.eq(x4);
        Formula x72=x5.eq(x5);
        Formula x73=x6.eq(x6);
        Formula x74=x7.eq(x7);
        Formula x75=x8.eq(x8);
        Formula x76=x9.eq(x9);
        Formula x10=Formula.compose(FormulaOperator.AND, x11, x13, x20, x24, x35, x67, x68, x69, x70, x71, x72, x73, x74, x75, x76);

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