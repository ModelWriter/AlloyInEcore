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
        Name = "lights",
        Note = "",
        IsCheck = true,
        PartialModel = true,
        BinaryRelations = 2,
        TernaryRelations =1,
        NaryRelations = 0,
        HierarchicalTypes =3,
        NestedRelationalJoins = 5,
        TransitiveClosure = 0,
        NestedQuantifiers = 0,
        SetCardinality = 0,
        Additions = 0,
        Subtractions = 0,
        Comparison = 2,
        OrderedRelations = 0,
        Constraints = 7
)


public final class lightsSafeCheck {

    public static void main(String[] args) throws Exception {

        Relation x0 = Relation.unary("Int/min");
        Relation x1 = Relation.unary("Int/zero");
        Relation x2 = Relation.unary("Int/max");
        Relation x3 = Relation.nary("Int/next", 2);
        Relation x4 = Relation.unary("seq/Int");
        Relation x5 = Relation.unary("String");
        Relation x6 = Relation.unary("this/Red");
        Relation x7 = Relation.unary("this/Yellow");
        Relation x8 = Relation.unary("this/Green");
        Relation x9 = Relation.unary("this/Light");
        Relation x10 = Relation.unary("this/LightState");
        Relation x11 = Relation.unary("this/Junction");
        Relation x12 = Relation.nary("this/LightState.color", 3);
        Relation x13 = Relation.nary("this/Junction.lights", 2);

        List<String> atomlist = Arrays.asList(
                "-1", "-2", "-3", "-4", "-5",
                "-6", "-7", "-8", "0", "1", "2",
                "3", "4", "5", "6", "7", "Green$0",
                "Junction$0", "Light$0", "Light$1", "Light$2", "LightState$0", "LightState$1",
                "LightState$2", "Red$0", "Yellow$0"
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
        x6_upper.add(factory.tuple("Red$0"));
        bounds.boundExactly(x6, x6_upper);

        TupleSet x7_upper = factory.noneOf(1);
        x7_upper.add(factory.tuple("Yellow$0"));
        bounds.boundExactly(x7, x7_upper);

        TupleSet x8_upper = factory.noneOf(1);
        x8_upper.add(factory.tuple("Green$0"));
        bounds.boundExactly(x8, x8_upper);

        TupleSet x9_upper = factory.noneOf(1);
        x9_upper.add(factory.tuple("Light$0"));
        x9_upper.add(factory.tuple("Light$1"));
        x9_upper.add(factory.tuple("Light$2"));
        bounds.bound(x9, x9_upper);

        TupleSet x10_upper = factory.noneOf(1);
        x10_upper.add(factory.tuple("LightState$0"));
        x10_upper.add(factory.tuple("LightState$1"));
        x10_upper.add(factory.tuple("LightState$2"));
        bounds.bound(x10, x10_upper);

        TupleSet x11_upper = factory.noneOf(1);
        x11_upper.add(factory.tuple("Junction$0"));
        bounds.bound(x11, x11_upper);

        TupleSet x12_upper = factory.noneOf(3);
        x12_upper.add(factory.tuple("LightState$0").product(factory.tuple("Light$0")).product(factory.tuple("Red$0")));
        x12_upper.add(factory.tuple("LightState$0").product(factory.tuple("Light$0")).product(factory.tuple("Yellow$0")));
        x12_upper.add(factory.tuple("LightState$0").product(factory.tuple("Light$0")).product(factory.tuple("Green$0")));
        x12_upper.add(factory.tuple("LightState$0").product(factory.tuple("Light$1")).product(factory.tuple("Red$0")));
        x12_upper.add(factory.tuple("LightState$0").product(factory.tuple("Light$1")).product(factory.tuple("Yellow$0")));
        x12_upper.add(factory.tuple("LightState$0").product(factory.tuple("Light$1")).product(factory.tuple("Green$0")));
        x12_upper.add(factory.tuple("LightState$0").product(factory.tuple("Light$2")).product(factory.tuple("Red$0")));
        x12_upper.add(factory.tuple("LightState$0").product(factory.tuple("Light$2")).product(factory.tuple("Yellow$0")));
        x12_upper.add(factory.tuple("LightState$0").product(factory.tuple("Light$2")).product(factory.tuple("Green$0")));
        x12_upper.add(factory.tuple("LightState$1").product(factory.tuple("Light$0")).product(factory.tuple("Red$0")));
        x12_upper.add(factory.tuple("LightState$1").product(factory.tuple("Light$0")).product(factory.tuple("Yellow$0")));
        x12_upper.add(factory.tuple("LightState$1").product(factory.tuple("Light$0")).product(factory.tuple("Green$0")));
        x12_upper.add(factory.tuple("LightState$1").product(factory.tuple("Light$1")).product(factory.tuple("Red$0")));
        x12_upper.add(factory.tuple("LightState$1").product(factory.tuple("Light$1")).product(factory.tuple("Yellow$0")));
        x12_upper.add(factory.tuple("LightState$1").product(factory.tuple("Light$1")).product(factory.tuple("Green$0")));
        x12_upper.add(factory.tuple("LightState$1").product(factory.tuple("Light$2")).product(factory.tuple("Red$0")));
        x12_upper.add(factory.tuple("LightState$1").product(factory.tuple("Light$2")).product(factory.tuple("Yellow$0")));
        x12_upper.add(factory.tuple("LightState$1").product(factory.tuple("Light$2")).product(factory.tuple("Green$0")));
        x12_upper.add(factory.tuple("LightState$2").product(factory.tuple("Light$0")).product(factory.tuple("Red$0")));
        x12_upper.add(factory.tuple("LightState$2").product(factory.tuple("Light$0")).product(factory.tuple("Yellow$0")));
        x12_upper.add(factory.tuple("LightState$2").product(factory.tuple("Light$0")).product(factory.tuple("Green$0")));
        x12_upper.add(factory.tuple("LightState$2").product(factory.tuple("Light$1")).product(factory.tuple("Red$0")));
        x12_upper.add(factory.tuple("LightState$2").product(factory.tuple("Light$1")).product(factory.tuple("Yellow$0")));
        x12_upper.add(factory.tuple("LightState$2").product(factory.tuple("Light$1")).product(factory.tuple("Green$0")));
        x12_upper.add(factory.tuple("LightState$2").product(factory.tuple("Light$2")).product(factory.tuple("Red$0")));
        x12_upper.add(factory.tuple("LightState$2").product(factory.tuple("Light$2")).product(factory.tuple("Yellow$0")));
        x12_upper.add(factory.tuple("LightState$2").product(factory.tuple("Light$2")).product(factory.tuple("Green$0")));
        bounds.bound(x12, x12_upper);

        TupleSet x13_upper = factory.noneOf(2);
        x13_upper.add(factory.tuple("Junction$0").product(factory.tuple("Light$0")));
        x13_upper.add(factory.tuple("Junction$0").product(factory.tuple("Light$1")));
        x13_upper.add(factory.tuple("Junction$0").product(factory.tuple("Light$2")));
        bounds.bound(x13, x13_upper);

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

        Expression x16=x6.intersection(x7);
        Formula x15=x16.no();
        Expression x19=x6.union(x7);
        Expression x18=x19.intersection(x8);
        Formula x17=x18.no();
        Variable x22=Variable.unary("Safe_this");
        Decls x21=x22.oneOf(x10);
        Expression x26=x22.join(x12);
        Expression x28=x19.union(x8);
        Expression x27=x9.product(x28);
        Formula x25=x26.in(x27);
        Variable x31=Variable.unary("");
        Decls x30=x31.oneOf(x9);
        Expression x34=x31.join(x26);
        Formula x33=x34.one();
        Formula x35=x34.in(x28);
        Formula x32=x33.and(x35);
        Formula x29=x32.forAll(x30);
        Formula x24=x25.and(x29);
        Variable x38=Variable.unary("");
        Decls x37=x38.oneOf(x28);
        Expression x40=x26.join(x38);
        Formula x39=x40.in(x9);
        Formula x36=x39.forAll(x37);
        Formula x23=x24.and(x36);
        Formula x20=x23.forAll(x21);
        Expression x43=x12.join(Expression.UNIV);
        Expression x42=x43.join(Expression.UNIV);
        Formula x41=x42.in(x10);
        Variable x47=Variable.unary("Safe_this");
        Decls x46=x47.oneOf(x11);
        Expression x49=x47.join(x13);
        Formula x48=x49.in(x9);
        Formula x45=x48.forAll(x46);
        Expression x51=x13.join(Expression.UNIV);
        Formula x50=x51.in(x11);
        Variable x56=Variable.unary("Safe_s");
        Decls x55=x56.oneOf(x10);
        Variable x58=Variable.unary("Safe_s'");
        Decls x57=x58.oneOf(x10);
        Variable x60=Variable.unary("Safe_j");
        Decls x59=x60.oneOf(x11);
        Decls x54=x55.and(x57).and(x59);
        Expression x66=x60.join(x13);
        Expression x68=x56.join(x12);
        Expression x67=x68.join(x6);
        Expression x65=x66.difference(x67);
        Formula x64=x65.lone();
        Variable x73=Variable.unary("trans_x");
        Expression x74=x60.join(x13);
        Decls x72=x73.oneOf(x74);
        Expression x78=x56.join(x12);
        Expression x77=x73.join(x78);
        Expression x80=x58.join(x12);
        Expression x79=x73.join(x80);
        Formula x76=x77.eq(x79);
        Formula x75=x76.not();
        Expression x71=x75.comprehension(x72);
        Formula x70=x71.lone();
        Variable x83=Variable.unary("trans_x");
        Expression x84=x60.join(x13);
        Decls x82=x83.oneOf(x84);
        Expression x89=x56.join(x12);
        Expression x88=x83.join(x89);
        Expression x91=x58.join(x12);
        Expression x90=x83.join(x91);
        Expression x87=x88.product(x90);
        Expression x96=x28.product(Expression.UNIV);
        Expression x104=Expression.INTS.union(x5);
        Expression x103=x104.union(x28);
        Expression x102=x103.union(x9);
        Expression x101=x102.union(x10);
        Expression x100=x101.union(x11);
        Expression x99=x100.product(Expression.UNIV);
        Expression x97=Expression.IDEN.intersection(x99);
        Expression x95=x96.intersection(x97);
        Expression x106=x6.product(x8);
        Expression x94=x95.union(x106);
        Expression x107=x8.product(x7);
        Expression x93=x94.union(x107);
        Expression x108=x7.product(x6);
        Expression x92=x93.union(x108);
        Formula x86=x87.in(x92);
        Expression x113=x28.difference(x6);
        Expression x112=x6.product(x113);
        Formula x111=x87.in(x112);
        Formula x110=x111.not();
        Expression x115=x60.join(x13);
        Expression x117=x56.join(x12);
        Expression x116=x117.join(x6);
        Formula x114=x115.in(x116);
        Formula x109=x110.or(x114);
        Formula x85=x86.and(x109);
        Formula x81=x85.forAll(x82);
        Formula x69=x70.and(x81);
        Formula x63=x64.and(x69);
        Formula x62=x63.not();
        Expression x120=x60.join(x13);
        Expression x122=x58.join(x12);
        Expression x121=x122.join(x6);
        Expression x119=x120.difference(x121);
        Formula x118=x119.lone();
        Formula x61=x62.or(x118);
        Formula x53=x61.forAll(x54);
        Formula x52=x53.not();
        Formula x123=x0.eq(x0);
        Formula x124=x1.eq(x1);
        Formula x125=x2.eq(x2);
        Formula x126=x3.eq(x3);
        Formula x127=x4.eq(x4);
        Formula x128=x5.eq(x5);
        Formula x129=x6.eq(x6);
        Formula x130=x7.eq(x7);
        Formula x131=x8.eq(x8);
        Formula x132=x9.eq(x9);
        Formula x133=x10.eq(x10);
        Formula x134=x11.eq(x11);
        Formula x135=x12.eq(x12);
        Formula x136=x13.eq(x13);
        Formula x14=Formula.compose(FormulaOperator.AND, x15, x17, x20, x41, x45, x50, x52, x123, x124, x125, x126, x127, x128, x129, x130, x131, x132, x133, x134, x135, x136);

        Solver solver = new Solver();
        solver.options().setSolver(SATFactory.MiniSat);
        solver.options().setBitwidth(4);
        //solver.options().setFlatten(false);
        solver.options().setIntEncoding(Options.IntEncoding.TWOSCOMPLEMENT);
        solver.options().setSymmetryBreaking(20);
        solver.options().setSkolemDepth(0);
        System.out.println("Solving...");
        System.out.flush();
        Solution sol = solver.solve(x14,bounds);
        System.out.println(sol.toString());
    }}