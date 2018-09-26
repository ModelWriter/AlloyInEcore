package kodkod.examples.models.simple.genealogy;

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
        Name = "genealogy",
        Note = "",
        IsCheck = false,
        PartialModel = true,
        BinaryRelations = 3,
        TernaryRelations = 0,
        NaryRelations = 0,
        HierarchicalTypes =3,
        NestedRelationalJoins = 1,
        TransitiveClosure = 1,
        NestedQuantifiers = 4,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 4,
        OrderedRelations = 0,
        Constraints = 12
)


public final class genealogyShowRun {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Adam");
        Relation x7 = Relation.unary("this/Man remainder");
        Relation x8 = Relation.unary("this/Eve");
        Relation x9 = Relation.unary("this/Woman remainder");
        Relation x10 = Relation.nary("this/Person.spouse", 2);
        Relation x11 = Relation.nary("this/Person.parents", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Adam$0",
                "Eve$0", "Person$0", "Person$1", "Person$2", "Person$3"
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
        x4_upper.add(factory.tuple("5"));
        bounds.boundExactly(x4, x4_upper);

        TupleSet x5_upper = factory.noneOf(1);
        bounds.boundExactly(x5, x5_upper);

        TupleSet x6_upper = factory.noneOf(1);
        x6_upper.add(factory.tuple("Adam$0"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Person$0"));
        x7_upper.add(factory.tuple("Person$1"));
        x7_upper.add(factory.tuple("Person$2"));
        x7_upper.add(factory.tuple("Person$3"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Eve$0"));
        bounds.boundExactly(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Person$0"));
        x9_upper.add(factory.tuple("Person$1"));
        x9_upper.add(factory.tuple("Person$2"));
        x9_upper.add(factory.tuple("Person$3"));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(2);
        x10_upper.add(factory.tuple("Adam$0").product(factory.tuple("Adam$0")));
        x10_upper.add(factory.tuple("Adam$0").product(factory.tuple("Eve$0")));
        x10_upper.add(factory.tuple("Adam$0").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Adam$0").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Adam$0").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Adam$0").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Eve$0").product(factory.tuple("Adam$0")));
        x10_upper.add(factory.tuple("Eve$0").product(factory.tuple("Eve$0")));
        x10_upper.add(factory.tuple("Eve$0").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Eve$0").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Eve$0").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Eve$0").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Adam$0")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Eve$0")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Adam$0")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Eve$0")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Adam$0")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Eve$0")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$3")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Adam$0")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Eve$0")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$0")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$1")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$2")));
        x10_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$3")));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(2);
        x11_upper.add(factory.tuple("Adam$0").product(factory.tuple("Adam$0")));
        x11_upper.add(factory.tuple("Adam$0").product(factory.tuple("Eve$0")));
        x11_upper.add(factory.tuple("Adam$0").product(factory.tuple("Person$0")));
        x11_upper.add(factory.tuple("Adam$0").product(factory.tuple("Person$1")));
        x11_upper.add(factory.tuple("Adam$0").product(factory.tuple("Person$2")));
        x11_upper.add(factory.tuple("Adam$0").product(factory.tuple("Person$3")));
        x11_upper.add(factory.tuple("Eve$0").product(factory.tuple("Adam$0")));
        x11_upper.add(factory.tuple("Eve$0").product(factory.tuple("Eve$0")));
        x11_upper.add(factory.tuple("Eve$0").product(factory.tuple("Person$0")));
        x11_upper.add(factory.tuple("Eve$0").product(factory.tuple("Person$1")));
        x11_upper.add(factory.tuple("Eve$0").product(factory.tuple("Person$2")));
        x11_upper.add(factory.tuple("Eve$0").product(factory.tuple("Person$3")));
        x11_upper.add(factory.tuple("Person$0").product(factory.tuple("Adam$0")));
        x11_upper.add(factory.tuple("Person$0").product(factory.tuple("Eve$0")));
        x11_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$0")));
        x11_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$1")));
        x11_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$2")));
        x11_upper.add(factory.tuple("Person$0").product(factory.tuple("Person$3")));
        x11_upper.add(factory.tuple("Person$1").product(factory.tuple("Adam$0")));
        x11_upper.add(factory.tuple("Person$1").product(factory.tuple("Eve$0")));
        x11_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$0")));
        x11_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$1")));
        x11_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$2")));
        x11_upper.add(factory.tuple("Person$1").product(factory.tuple("Person$3")));
        x11_upper.add(factory.tuple("Person$2").product(factory.tuple("Adam$0")));
        x11_upper.add(factory.tuple("Person$2").product(factory.tuple("Eve$0")));
        x11_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$0")));
        x11_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$1")));
        x11_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$2")));
        x11_upper.add(factory.tuple("Person$2").product(factory.tuple("Person$3")));
        x11_upper.add(factory.tuple("Person$3").product(factory.tuple("Adam$0")));
        x11_upper.add(factory.tuple("Person$3").product(factory.tuple("Eve$0")));
        x11_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$0")));
        x11_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$1")));
        x11_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$2")));
        x11_upper.add(factory.tuple("Person$3").product(factory.tuple("Person$3")));
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

        Expression x15=x6.union(x7);
        Expression x16=x8.union(x9);
        Expression x14=x15.intersection(x16);
        Formula x13=x14.no();
        Variable x19=Variable.unary("Show_this");
        Expression x20=x15.union(x16);
        Decls x18=x19.oneOf(x20);
        Expression x23=x19.join(x10);
        Formula x22=x23.lone();
        Formula x24=x23.in(x20);
        Formula x21=x22.and(x24);
        Formula x17=x21.forAll(x18);
        Expression x26=x10.join(Expression.UNIV);
        Formula x25=x26.in(x20);
        Variable x30=Variable.unary("Show_this");
        Decls x29=x30.oneOf(x20);
        Expression x32=x30.join(x11);
        Formula x31=x32.in(x20);
        Formula x28=x31.forAll(x29);
        Expression x34=x11.join(Expression.UNIV);
        Formula x33=x34.in(x20);
        Variable x37=Variable.unary("Show_p");
        Decls x36=x37.oneOf(x20);
        Expression x41=x11.closure();
        Expression x40=x37.join(x41);
        Formula x39=x37.in(x40);
        Formula x38=x39.not();
        Formula x35=x38.forAll(x36);
        Variable x44=Variable.unary("Show_p");
        Expression x46=x6.union(x8);
        Expression x45=x20.difference(x46);
        Decls x43=x44.oneOf(x45);
        Variable x51=Variable.unary("Show_mother");
        Decls x50=x51.oneOf(x16);
        Variable x53=Variable.unary("Show_father");
        Decls x52=x53.oneOf(x15);
        Decls x49=x50.and(x52);
        Expression x55=x44.join(x11);
        Expression x56=x51.union(x53);
        Formula x54=x55.eq(x56);
        Expression x48=x54.comprehension(x49);
        Formula x47=x48.one();
        Formula x42=x47.forAll(x43);
        Expression x59=x6.union(x8);
        Expression x58=x59.join(x11);
        Formula x57=x58.no();
        Expression x61=x6.join(x10);
        Formula x60=x61.eq(x8);
        Variable x64=Variable.unary("Show_p");
        Decls x63=x64.oneOf(x20);
        Expression x67=x64.join(x10);
        Formula x66=x67.eq(x64);
        Formula x65=x66.not();
        Formula x62=x65.forAll(x63);
        Expression x69=x10.transpose();
        Formula x68=x10.eq(x69);
        Expression x71=x15.join(x10);
        Formula x70=x71.in(x16);
        Expression x73=x16.join(x10);
        Formula x72=x73.in(x15);
        Variable x76=Variable.unary("Show_p");
        Decls x75=x76.oneOf(x20);
        Expression x81=x76.join(x10);
        Expression x80=x81.join(x11);
        Expression x82=x76.join(x11);
        Expression x79=x80.intersection(x82);
        Formula x78=x79.some();
        Formula x77=x78.not();
        Formula x74=x77.forAll(x75);
        Variable x85=Variable.unary("Show_p");
        Decls x84=x85.oneOf(x20);
        Expression x89=x85.join(x10);
        Expression x90=x85.join(x11);
        Expression x88=x89.intersection(x90);
        Formula x87=x88.some();
        Formula x86=x87.not();
        Formula x83=x86.forAll(x84);
        Variable x93=Variable.unary("Show_p");
        Expression x95=x6.union(x8);
        Expression x94=x20.difference(x95);
        Decls x92=x93.oneOf(x94);
        Expression x97=x93.join(x10);
        Formula x96=x97.some();
        Formula x91=x96.forSome(x92);
        Formula x98=x0.eq(x0);
        Formula x99=x1.eq(x1);
        Formula x100=x2.eq(x2);
        Formula x101=x3.eq(x3);
        Formula x102=x4.eq(x4);
        Formula x103=x5.eq(x5);
        Formula x104=x6.eq(x6);
        Formula x105=x7.eq(x7);
        Formula x106=x8.eq(x8);
        Formula x107=x9.eq(x9);
        Formula x108=x10.eq(x10);
        Formula x109=x11.eq(x11);
        Formula x12=Formula.compose(FormulaOperator.AND, x13, x17, x25, x28, x33, x35, x42, x57, x60, x62, x68, x70, x72, x74, x83, x91, x98, x99, x100, x101, x102, x103, x104, x105, x106, x107, x108, x109);

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