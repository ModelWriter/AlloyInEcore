package kodkod.examples.models.simple.book;

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
        Name = "birthday",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 2,
        TernaryRelations = 1,
        NaryRelations = 0,
        HierarchicalTypes =0,
        NestedRelationalJoins = 2,
        TransitiveClosure = 0,
        NestedQuantifiers = 2,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 6,
        OrderedRelations = 0,
        Constraints = 11
)



public final class birthdayDellsUndoCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Name");
        Relation x7 = Relation.unary("this/Date");
        Relation x8 = Relation.unary("this/BirthdayBook");
        Relation x9 = Relation.nary("this/BirthdayBook.known", 2);
        Relation x10 = Relation.nary("this/BirthdayBook.date", 3);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "BirthdayBook$0",
                "BirthdayBook$1", "Date$0", "Date$1", "Date$2", "Name$0", "Name$1",
                "Name$2"
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
        x6_upper.add(factory.tuple("Name$0"));
        x6_upper.add(factory.tuple("Name$1"));
        x6_upper.add(factory.tuple("Name$2"));
        bounds.bound(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Date$0"));
        x7_upper.add(factory.tuple("Date$1"));
        x7_upper.add(factory.tuple("Date$2"));
        bounds.bound(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("BirthdayBook$0"));
        x8_upper.add(factory.tuple("BirthdayBook$1"));
        bounds.bound(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(2);
        x9_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$0")));
        x9_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$1")));
        x9_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$2")));
        x9_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$0")));
        x9_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$1")));
        x9_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$2")));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(3);
        x10_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$0")).product(factory.tuple("Date$0")));
        x10_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$0")).product(factory.tuple("Date$1")));
        x10_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$0")).product(factory.tuple("Date$2")));
        x10_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$1")).product(factory.tuple("Date$0")));
        x10_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$1")).product(factory.tuple("Date$1")));
        x10_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$1")).product(factory.tuple("Date$2")));
        x10_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$2")).product(factory.tuple("Date$0")));
        x10_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$2")).product(factory.tuple("Date$1")));
        x10_upper.add(factory.tuple("BirthdayBook$0").product(factory.tuple("Name$2")).product(factory.tuple("Date$2")));
        x10_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$0")).product(factory.tuple("Date$0")));
        x10_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$0")).product(factory.tuple("Date$1")));
        x10_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$0")).product(factory.tuple("Date$2")));
        x10_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$1")).product(factory.tuple("Date$0")));
        x10_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$1")).product(factory.tuple("Date$1")));
        x10_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$1")).product(factory.tuple("Date$2")));
        x10_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$2")).product(factory.tuple("Date$0")));
        x10_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$2")).product(factory.tuple("Date$1")));
        x10_upper.add(factory.tuple("BirthdayBook$1").product(factory.tuple("Name$2")).product(factory.tuple("Date$2")));
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

        Variable x14=Variable.unary("DelIsUndo_this");
        Decls x13=x14.oneOf(x8);
        Expression x16=x14.join(x9);
        Formula x15=x16.in(x6);
        Formula x12=x15.forAll(x13);
        Expression x18=x9.join(Expression.UNIV);
        Formula x17=x18.in(x8);
        Variable x22=Variable.unary("DelIsUndo_this");
        Decls x21=x22.oneOf(x8);
        Expression x26=x22.join(x10);
        Expression x28=x22.join(x9);
        Expression x27=x28.product(x7);
        Formula x25=x26.in(x27);
        Variable x31=Variable.unary("");
        Decls x30=x31.oneOf(x28);
        Expression x34=x31.join(x26);
        Formula x33=x34.one();
        Formula x35=x34.in(x7);
        Formula x32=x33.and(x35);
        Formula x29=x32.forAll(x30);
        Formula x24=x25.and(x29);
        Variable x38=Variable.unary("");
        Decls x37=x38.oneOf(x7);
        Expression x40=x26.join(x38);
        Expression x41=x22.join(x9);
        Formula x39=x40.in(x41);
        Formula x36=x39.forAll(x37);
        Formula x23=x24.and(x36);
        Formula x20=x23.forAll(x21);
        Expression x44=x10.join(Expression.UNIV);
        Expression x43=x44.join(Expression.UNIV);
        Formula x42=x43.in(x8);
        Variable x49=Variable.unary("DelIsUndo_bb1");
        Decls x48=x49.oneOf(x8);
        Variable x51=Variable.unary("DelIsUndo_bb2");
        Decls x50=x51.oneOf(x8);
        Variable x53=Variable.unary("DelIsUndo_bb3");
        Decls x52=x53.oneOf(x8);
        Variable x55=Variable.unary("DelIsUndo_n");
        Decls x54=x55.oneOf(x6);
        Variable x57=Variable.unary("DelIsUndo_d");
        Decls x56=x57.oneOf(x7);
        Decls x47=x48.and(x50).and(x52).and(x54).and(x56);
        Expression x62=x51.join(x10);
        Expression x64=x49.join(x10);
        Expression x65=x55.product(x57);
        Expression x63=x64.override(x65);
        Formula x61=x62.eq(x63);
        Expression x67=x53.join(x10);
        Expression x69=x51.join(x10);
        Expression x70=x55.product(x7);
        Expression x68=x69.difference(x70);
        Formula x66=x67.eq(x68);
        Formula x60=x61.and(x66);
        Formula x59=x60.not();
        Expression x72=x49.join(x10);
        Expression x73=x53.join(x10);
        Formula x71=x72.eq(x73);
        Formula x58=x59.or(x71);
        Formula x46=x58.forAll(x47);
        Formula x45=x46.not();
        Formula x74=x0.eq(x0);
        Formula x75=x1.eq(x1);
        Formula x76=x2.eq(x2);
        Formula x77=x3.eq(x3);
        Formula x78=x4.eq(x4);
        Formula x79=x5.eq(x5);
        Formula x80=x6.eq(x6);
        Formula x81=x7.eq(x7);
        Formula x82=x8.eq(x8);
        Formula x83=x9.eq(x9);
        Formula x84=x10.eq(x10);
        Formula x11=Formula.compose(FormulaOperator.AND, x12, x17, x20, x42, x45, x74, x75, x76, x77, x78, x79, x80, x81, x82, x83, x84);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
       // solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x11,bounds);
        System.out.println(sol.toString());
    }}