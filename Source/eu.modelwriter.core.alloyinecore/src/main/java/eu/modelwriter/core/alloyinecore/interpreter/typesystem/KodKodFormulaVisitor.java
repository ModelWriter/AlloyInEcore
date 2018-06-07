/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore.interpreter.typesystem;

import eu.modelwriter.core.alloyinecore.interpreter.FormulaInfo;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.INavigable;
import eu.modelwriter.core.alloyinecore.structure.base.ISegment;
import eu.modelwriter.core.alloyinecore.structure.constraints.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Package;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;
import kodkod.ast.Decls;
import kodkod.ast.Node;
import kodkod.ast.Relation;
import kodkod.util.nodes.PrettyPrinter;

import java.util.*;
import java.util.stream.Collectors;

public class KodKodFormulaVisitor extends BaseVisitorImpl<Node> {

    private Map<String, Relation> relationMap;

    private Map<String, Node> declarations = new HashMap<>();
    private List<List<kodkod.ast.Variable>> disjVars = new ArrayList<>();
    private List<kodkod.ast.Formula> formulas = new ArrayList<>();
    private Map<Element, kodkod.ast.Formula> reasons = new HashMap<>();

    private Set<FormulaInfo> formulaInfos;

    public KodKodFormulaVisitor(Map<String, Relation> relationMap) {
        this.relationMap = relationMap;
        this.formulaInfos = new HashSet<>();
    }

    public Map<Element, kodkod.ast.Formula> getReasons() {
        return reasons;
    }

    public List<String> prettyPrintFormulas() {
        return formulas.stream()
                .map(f -> PrettyPrinter.print(f, 0).replaceAll("\n", ""))
                .collect(Collectors.toList());
    }

    @Override
    public Node visit(Element<?> element) {
        return super.visit(element);
    }

    @Override
    public kodkod.ast.Formula visitRootPackage(RootPackage _package) {
        formulas.clear();
        disjVars.clear();
        declarations.clear();
        super.visitRootPackage(_package);
        return kodkod.ast.Formula.and(formulas);
    }

    @Override
    public Node visitInvariant(Invariant invariant) {
        try {
            return visitFormula(invariant);
        }
        catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Node visitReason(Reason reason) {
        try {
            kodkod.ast.Formula formula = visitFormula(reason);
            reasons.put(reason.getOwner(), formula);
            return formula;
        }
        catch (NullPointerException e) {
            return null;
        }
    }

    private kodkod.ast.Formula visitFormula(Element<?> element) {

        kodkod.ast.Formula formula = (kodkod.ast.Formula) this.visit(element.getOwnedElement(Formula.class));
        formulas.add(formula);
        declarations.clear();
        disjVars.clear();

        formulaInfos.add(new FormulaInfo(formula, element.getToken()));

        return formula;
    }

    public Set<FormulaInfo> getFormulaInfos() {
        return formulaInfos;
    }

    @Override
    public Node visitImport(Import _import) {
        // Don't visit imports
        return null;
    }

    @Override
    public Node visitPostCondition(PostCondition postCondition) {
        return null;
    }

    @Override
    public Node visitPreCondition(PreCondition preCondition) {
        return null;
    }

    /**
     * For all, some, one, lone, no
     */

    @Override
    public Node visitForAll(Formula.ForAll forAll) {
        Decls decls = getDecls(forAll);
        kodkod.ast.Formula formula = getFormulas(forAll);

        if (!disjVars.isEmpty())
            formula = implementDisjOperatorOverFormula().implies(formula).forAll(decls);
        else
            formula = formula.forAll(decls);
        return formula;
    }

    @Override
    public Node visitForSome(Formula.ForSome forSome) {
        Decls decls = getDecls(forSome);
        kodkod.ast.Formula formula = getFormulas(forSome);

        if (!disjVars.isEmpty())
            formula = implementDisjOperatorOverFormula().and(formula).forSome(decls);
        else
            formula = formula.forSome(decls);
        return formula;
    }

    @Override
    public Node visitForNo(Formula.ForNo forNo) {
        Decls decls = getDecls(forNo);
        kodkod.ast.Formula formula = getFormulas(forNo);

        if (!disjVars.isEmpty())
            formula = implementDisjOperatorOverFormula().implies(formula).not().forAll(decls);
        else
            formula = formula.not().forAll(decls);
        return formula;
    }

    @Override
    public Node visitForOne(Formula.ForOne forOne) {
        Decls decls = getDecls(forOne);
        Iterator<Formula> iterator = forOne.getOwnedElements(Formula.class).iterator();
        final Map<Node, Node> variableReplacement =
                new HashMap<>();
        kodkod.ast.Formula formula = null;
        if (iterator.hasNext()) {
            formula = (kodkod.ast.Formula) this.visit(iterator.next());
            while (iterator.hasNext()) {
                formula = formula.and((kodkod.ast.Formula) this.visit(iterator.next()));
            }

            Decls primedDecls = null;
            List<kodkod.ast.Formula> andFormulas =
                    new ArrayList<>();
            Iterator<kodkod.ast.Decl> declIterator = decls.iterator();
            if (declIterator.hasNext()) {
                kodkod.ast.Decl decl = declIterator.next();
                kodkod.ast.Variable x = kodkod.ast.Variable.unary(decl.variable().name() + "'");
                variableReplacement.put(decl.variable(), x);
                // oneof?
                primedDecls = x.oneOf(decl.expression());
                andFormulas.add(x.eq(decl.variable()));
                while (declIterator.hasNext()) {
                    decl = declIterator.next();
                    x = kodkod.ast.Variable.unary(decl.variable().name() + "'");
                    primedDecls = primedDecls.and(x.oneOf(decl.expression()));
                    andFormulas.add(x.eq(decl.variable()));
                }
            }

            final kodkod.ast.visitor.AbstractReplacer replacer =
                    new kodkod.ast.visitor.AbstractReplacer(variableReplacement.keySet()) {
                        public kodkod.ast.Expression visit(kodkod.ast.Variable variable) {
                            System.out.println(PrettyPrinter.print(variable, 2));
                            return variableReplacement.containsKey(variable)
                                    ? (kodkod.ast.Variable) variableReplacement.get(variable) : variable;
                        }
                    };

            formula = formula.accept(replacer).iff(kodkod.ast.Formula.and(andFormulas))
                    .forAll(primedDecls).forSome(decls);
        }
        return formula;
    }

    @Override
    public Node visitForLone(Formula.ForLone forLone) {
        Decls decls = getDecls(forLone);
        Iterator<Formula> iterator = forLone.getOwnedElements(Formula.class).iterator();
        final Map<Node, Node> variableReplacement =
                new HashMap<>();
        kodkod.ast.Formula formula = null;
        if (iterator.hasNext()) {
            formula = (kodkod.ast.Formula) this.visit(iterator.next());
            while (iterator.hasNext()) {
                formula = formula.and((kodkod.ast.Formula) this.visit(iterator.next()));
            }

            Decls primedDecls = null;
            List<kodkod.ast.Formula> andFormulas =
                    new ArrayList<>();
            Iterator<kodkod.ast.Decl> declIterator = decls.iterator();
            if (declIterator.hasNext()) {
                kodkod.ast.Decl decl = declIterator.next();
                kodkod.ast.Variable x = kodkod.ast.Variable.unary(decl.variable().name() + "'");
                variableReplacement.put(decl.variable(), x);
                // oneof?
                primedDecls = x.oneOf(decl.expression());
                andFormulas.add(x.eq(decl.variable()));
                while (declIterator.hasNext()) {
                    decl = declIterator.next();
                    x = kodkod.ast.Variable.unary(decl.variable().name() + "'");
                    primedDecls = primedDecls.and(x.oneOf(decl.expression()));
                    andFormulas.add(x.eq(decl.variable()));
                }
            }

            final kodkod.ast.visitor.AbstractReplacer replacer =
                    new kodkod.ast.visitor.AbstractReplacer(variableReplacement.keySet()) {
                        public kodkod.ast.Expression visit(kodkod.ast.Variable variable) {
                            System.out.println(PrettyPrinter.print(variable, 2));
                            return variableReplacement.containsKey(variable)
                                    ? (kodkod.ast.Variable) variableReplacement.get(variable) : variable;
                        }
                    };

            formula = formula.and(formula.accept(replacer)).implies(kodkod.ast.Formula.and(andFormulas))
                    .forAll(primedDecls).forAll(decls);


        }
        return formula;
    }

    /**
     * Quantifier Declarations
     */

    @Override
    public Node visitVariable(Variable variable) {
        return kodkod.ast.Variable.unary(variable.getText());
    }

    @Override
    public Node visitBinding(Expression.Binding var) {
        return declarations.get(var.getContext().getText());
    }

    @Override
    public Node visitLet(Formula.Let let) {
        // visit declarations
        getDecls(let);
        // visit and return formula
        return getFormula(let);
    }

    @Override
    public Node visitLetDeclaration(LetDeclaration letDeclaration) {
        kodkod.ast.Expression exp = getExpression(letDeclaration);
        List<Variable> vars = letDeclaration.getOwnedElements(Variable.class);
        for (Variable var : vars) {
            declarations.put(var.getText(), exp);

        }
        // Return dummy declaration, for sake of getDecls() method
        return kodkod.ast.Variable.unary("x").oneOf(exp);
    }

    @Override
    public Node visitOneOf(QuantifierDeclaration.OneOf oneOf) {
        kodkod.ast.Expression exp = getExpression(oneOf);
        List<Variable> vars = oneOf.getOwnedElements(Variable.class);
        boolean disj = oneOf.getContext().disj != null;
        Decls decls = null;
        List<kodkod.ast.Variable> kodkodVars = vars.stream()
                .map(variable -> {
                    return exp.arity() == 1 ? (kodkod.ast.Variable) visit(variable) :
                            kodkod.ast.Variable.nary(variable.getText(), exp.arity());
                })
                .collect(Collectors.toList());
        for (kodkod.ast.Variable kodkodVar : kodkodVars) {
            declarations.put(kodkodVar.name(), kodkodVar);
            if (decls == null) decls = kodkodVar.oneOf(exp);
            else decls = decls.and(kodkodVar.oneOf(exp));
        }
        if (disj) disjVars.add(kodkodVars);
        return decls;
    }

    @Override
    public Node visitLoneOf(QuantifierDeclaration.LoneOf loneOf) {
        kodkod.ast.Expression exp = getExpression(loneOf);
        List<Variable> vars = loneOf.getOwnedElements(Variable.class);
        boolean disj = loneOf.getContext().disj != null;
        Decls decls = null;
        List<kodkod.ast.Variable> kodkodVars = vars.stream()
                .map(variable -> {
                    return exp.arity() == 1 ? (kodkod.ast.Variable) visit(variable) :
                            kodkod.ast.Variable.nary(variable.getText(), exp.arity());
                })
                .collect(Collectors.toList());
        for (kodkod.ast.Variable kodkodVar : kodkodVars) {
            declarations.put(kodkodVar.name(), kodkodVar);
            if (decls == null) decls = kodkodVar.loneOf(exp);
            else decls = decls.and(kodkodVar.loneOf(exp));
        }
        if (disj) disjVars.add(kodkodVars);
        return decls;
    }

    @Override
    public Node visitSomeOf(QuantifierDeclaration.SomeOf someOf) {
        kodkod.ast.Expression exp = getExpression(someOf);
        List<Variable> vars = someOf.getOwnedElements(Variable.class);
        boolean disj = someOf.getContext().disj != null;
        Decls decls = null;
        List<kodkod.ast.Variable> kodkodVars = vars.stream()
                .map(variable -> {
                    return exp.arity() == 1 ? (kodkod.ast.Variable) visit(variable) :
                            kodkod.ast.Variable.nary(variable.getText(), exp.arity());
                })
                .collect(Collectors.toList());
        for (kodkod.ast.Variable kodkodVar : kodkodVars) {
            declarations.put(kodkodVar.name(), kodkodVar);
            if (decls == null) decls = kodkodVar.someOf(exp);
            else decls = decls.and(kodkodVar.someOf(exp));
        }
        if (disj) disjVars.add(kodkodVars);
        return decls;
    }

    @Override
    public Node visitSetOf(QuantifierDeclaration.SetOf setOf) {
        kodkod.ast.Expression exp = getExpression(setOf);
        List<Variable> vars = setOf.getOwnedElements(Variable.class);
        boolean disj = setOf.getContext().disj != null;
        Decls decls = null;
        List<kodkod.ast.Variable> kodkodVars = vars.stream()
                .map(variable -> {
                    return exp.arity() == 1 ? (kodkod.ast.Variable) visit(variable) :
                            kodkod.ast.Variable.nary(variable.getText(), exp.arity());
                })
                .collect(Collectors.toList());
        for (kodkod.ast.Variable kodkodVar : kodkodVars) {
            declarations.put(kodkodVar.name(), kodkodVar);
            if (decls == null) decls = kodkodVar.setOf(exp);
            else decls = decls.and(kodkodVar.setOf(exp));
        }
        if (disj) disjVars.add(kodkodVars);
        return decls;
    }

    @Override
    public Node visitRelation(Expression.Relation relation) {
        return getRelation(relation, relation.getContext().getText());
    }

    /**
     * Formula
     */

    @Override
    public Node visitSome(Formula.Some some) {
        return ((kodkod.ast.Expression) super.visitChildren(some)).some();
    }

    @Override
    public Node visitOne(Formula.One one) {
        return ((kodkod.ast.Expression) super.visitChildren(one)).one();
    }

    @Override
    public Node visitLone(Formula.Lone lone) {
        return ((kodkod.ast.Expression) super.visitChildren(lone)).lone();
    }

    @Override
    public Node visitNo(Formula.No no) {
        return ((kodkod.ast.Expression) super.visitChildren(no)).no();
    }

    @Override
    public Node visitIn(Formula.In in) {
        return getLeftExpression(in).in(getRightExpression(in));
    }

    @Override
    public Node visitNotIn(Formula.NotIn notIn) {
        return getLeftExpression(notIn).in(getRightExpression(notIn)).not();
    }

    @Override
    public Node visitEqual(Formula.Equal equal) {
        return getLeftExpression(equal).eq(getRightExpression(equal));
    }

    @Override
    public Node visitNotEqual(Formula.NotEqual notEqual) {
        return getLeftExpression(notEqual).eq(getRightExpression(notEqual)).not();
    }


    /**
     * Integer Comparison Operators
     */

    @Override
    public Node visitEq(Formula.Eq eq) {
        if (!eq.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(eq).eq(getRightIntExpression(eq));
        return getLeftExpressionOfInt(eq).eq(getRightExpressionOfInt(eq));
    }

    @Override
    public Node visitLt(Formula.Lt lt) {
        if (!lt.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(lt).lt(getRightIntExpression(lt));
        return getLeftExpressionOfInt(lt).product(getRightExpressionOfInt(lt))
                .in(relationMap.get(TypeCollector.ltReferenceName));
    }

    @Override
    public Node visitLte(Formula.Lte lte) {
        if (!lte.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(lte).lte(getRightIntExpression(lte));
        return getLeftExpressionOfInt(lte).product(getRightExpressionOfInt(lte))
                .in(relationMap.get(TypeCollector.lteReferenceName));
    }

    @Override
    public Node visitGte(Formula.Gte gte) {
        if (!gte.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(gte).gte(getRightIntExpression(gte));
        return getLeftExpressionOfInt(gte).product(getRightExpressionOfInt(gte))
                .in(relationMap.get(TypeCollector.gteReferenceName));
    }

    @Override
    public Node visitGt(Formula.Gt gt) {
        if (!gt.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(gt).gt(getRightIntExpression(gt));
        return getLeftExpressionOfInt(gt).product(getRightExpressionOfInt(gt))
                .in(relationMap.get(TypeCollector.gtReferenceName));
    }

    @Override
    public Node visitNotEq(Formula.NotEq notEq) {
        if (!notEq.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(notEq).eq(getRightIntExpression(notEq)).not();
        return getLeftExpressionOfInt(notEq).eq(getRightExpressionOfInt(notEq)).not();
    }

    @Override
    public Node visitNotLt(Formula.NotLt notLt) {
        if (!notLt.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(notLt).lt(getRightIntExpression(notLt)).not();
        return getLeftExpressionOfInt(notLt).product(getRightExpressionOfInt(notLt))
                .in(relationMap.get(TypeCollector.ltReferenceName)).not();
    }

    @Override
    public Node visitNotLte(Formula.NotLte notLte) {
        if (!notLte.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(notLte).lte(getRightIntExpression(notLte)).not();
        return getLeftExpressionOfInt(notLte).product(getRightExpressionOfInt(notLte))
                .in(relationMap.get(TypeCollector.lteReferenceName)).not();
    }

    @Override
    public Node visitNotGt(Formula.NotGt notGt) {
        if (!notGt.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(notGt).gt(getRightIntExpression(notGt)).not();
        return getLeftExpressionOfInt(notGt).product(getRightExpressionOfInt(notGt))
                .in(relationMap.get(TypeCollector.gtReferenceName)).not();
    }

    @Override
    public Node visitNotGte(Formula.NotGte notGte) {
        if (!notGte.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())
            return getLeftIntExpression(notGte).gte(getRightIntExpression(notGte)).not();
        return getLeftExpressionOfInt(notGte).product(getRightExpressionOfInt(notGte))
                .in(relationMap.get(TypeCollector.gteReferenceName)).not();
    }

    @Override
    public Node visitSumDeclaration(Formula.SumDeclaration sumDeclaration) {
        Decls decls = getDecls(sumDeclaration);
        kodkod.ast.IntExpression expression = getLeftIntExpression(sumDeclaration);
        return expression.sum(decls);
    }

    @Override
    public Node visitAcyclic(Formula.Acyclic acyclic) {
        Relation relation = getRelation(acyclic, acyclic.getContext().relationId().getText());
        return relation.acyclic();
    }

    @Override
    public Node visitFunction(Formula.Function function) {
        Relation relation = getRelation(function, function.getContext().rel.getText());
        kodkod.ast.Expression domain = getLeftExpression(function);
        kodkod.ast.Expression range = getRightExpression(function);
        return relation.function(domain, range);
    }

    @Override
    public Node visitTotalOrder(Formula.TotalOrder totalOrder) {
        Relation rel = getRelation(totalOrder, totalOrder.getContext().rel.getText());
        Relation last = getRelation(totalOrder, totalOrder.getContext().last.getText());
        Relation ordered = getRelation(totalOrder, totalOrder.getContext().ordered.getText());
        Relation first = getRelation(totalOrder, totalOrder.getContext().first.getText());
        return rel.totalOrder(ordered, first, last);
    }

    @Override
    public Node visitPartialFunction(Formula.PartialFunction partialFunction) {
        Relation relation = getRelation(partialFunction, partialFunction.getContext().rel.getText());
        kodkod.ast.Expression domain = getLeftExpression(partialFunction);
        kodkod.ast.Expression range = getRightExpression(partialFunction);
        return relation.partialFunction(domain, range);
    }

    @Override
    public Node visitNot(Formula.Not not) {
        Element<?> formula = not.getOwnedElement(Formula.class);
        kodkod.ast.Formula f1 = (kodkod.ast.Formula) this.visit(formula);
        return f1.not();
    }

    @Override
    public Node visitAnd(Formula.And and) {
        return getLeftFormula(and).and(getRightFormula(and));
    }

    @Override
    public Node visitOr(Formula.Or or) {
        return getLeftFormula(or).or(getRightFormula(or));
    }

    @Override
    public Node visitImplies(Formula.Implies implies) {
        return getLeftFormula(implies).implies(getRightFormula(implies));
    }

    @Override
    public Node visitIff(Formula.Iff iff) {
        return getLeftFormula(iff).iff(getRightFormula(iff));
    }

    @Override
    public Node visitTrue(Formula.True _true) {
        return kodkod.ast.Formula.TRUE;
    }

    @Override
    public Node visitFalse(Formula.False _false) {
        return kodkod.ast.Formula.FALSE;
    }

    /**
     * Expression
     */

    @Override
    public Node visitTranspose(Expression.Transpose transpose) {
        return getExpression(transpose).transpose();
    }

    @Override
    public Node visitClosure(Expression.Closure closure) {
        return getExpression(closure).closure();
    }

    @Override
    public Node visitReflexive(Expression.Reflexive reflexive) {
        return getExpression(reflexive).reflexiveClosure();
    }

    @Override
    public Node visitUnion(Expression.Union union) {
        return getLeftExpression(union).union(getRightExpression(union));
    }

    @Override
    public Node visitIntersection(Expression.Intersection intersection) {
        return getLeftExpression(intersection).intersection(getRightExpression(intersection));
    }

    @Override
    public Node visitDifference(Expression.Difference difference) {
        return getLeftExpression(difference).difference(getRightExpression(difference));
    }

    @Override
    public Node visitJoin(Expression.Join join) {
        return getLeftExpression(join).join(getRightExpression(join));
    }

    @Override
    public Node visitBoxJoin(Expression.BoxJoin boxJoin) {
        return getLeftExpression(boxJoin).join(getRightExpression(boxJoin));
    }

    @Override
    public Node visitProduct(Expression.Product product) {
        return getLeftExpression(product).product(getRightExpression(product));
    }

    @Override
    public Node visitDomainRestriction(Expression.DomainRestriction domainRestriction) {
        //((left -> univ) & right)
        kodkod.ast.Expression left = getLeftExpression(domainRestriction);
        kodkod.ast.Expression right = getRightExpression(domainRestriction);
        return left.product(kodkod.ast.Expression.UNIV).intersection(right);
    }

    @Override
    public Node visitRangeRestriction(Expression.RangeRestriction rangeRestriction) {
        //(left & (univ -> right))
        kodkod.ast.Expression left = getLeftExpression(rangeRestriction);
        kodkod.ast.Expression right = getRightExpression(rangeRestriction);
        return left.intersection(kodkod.ast.Expression.UNIV.product(right));
    }

    @Override
    public Node visitComprehension(Expression.Comprehension comprehension) {
        kodkod.ast.Formula formula = getFormula(comprehension);
        Decls decls = getDecls(comprehension);
        return formula.comprehension(decls);
    }

    @Override
    public Node visitComprehensionDeclaration(ComprehensionDeclaration comprehensionDeclaration) {
        kodkod.ast.Expression exp = getExpression(comprehensionDeclaration);
        List<Variable> vars = comprehensionDeclaration.getOwnedElements(Variable.class);
        boolean disj = comprehensionDeclaration.getContext().disj != null;
        Decls decls = null;
        List<kodkod.ast.Variable> kodkodVars = vars.stream()
                .map(variable -> {
                    return exp.arity() == 1 ? (kodkod.ast.Variable) visit(variable) :
                            kodkod.ast.Variable.nary(variable.getText(), exp.arity());
                })
                .collect(Collectors.toList());
        for (kodkod.ast.Variable kodkodVar : kodkodVars) {
            declarations.put(kodkodVar.name(), kodkodVar);
            if (decls == null) decls = kodkodVar.oneOf(exp);
            else decls = decls.and(kodkodVar.oneOf(exp));
        }
        if (disj) disjVars.add(kodkodVars);
        return decls;
    }

    @Override
    public Node visitIfExpression(Expression.IfExpression ifExpression) {
        kodkod.ast.Formula condition = getFormula(ifExpression);
        kodkod.ast.Expression thenExp = getLeftExpression(ifExpression);
        kodkod.ast.Expression elseExp = getRightExpression(ifExpression);
        return condition.thenElse(thenExp, elseExp);
    }

    @Override
    public Node visitIden(Expression.Iden iden) {
        return kodkod.ast.LeafExpression.IDEN;
    }

    @Override
    public Node visitNone(Expression.None none) {
        return kodkod.ast.LeafExpression.NONE;
    }

    @Override
    public Node visitInts(Expression.Ints ints) {
        return kodkod.ast.LeafExpression.INTS;
    }

    @Override
    public Node visitUniv(Expression.Univ univ) {
        return kodkod.ast.LeafExpression.UNIV;
    }

    /**
     * Int Expressions
     */

    @Override
    public Node visitIfIntExpression(IntExpression.IfIntExpression ifIntExpression) {
        kodkod.ast.Formula condition = getFormula(ifIntExpression);
        kodkod.ast.IntExpression thenExp = getLeftIntExpression(ifIntExpression);
        kodkod.ast.IntExpression elseExp = getRightIntExpression(ifIntExpression);
        return condition.thenElse(thenExp, elseExp);
    }

    @Override
    public Node visitSum(IntExpression.Sum sum) {
        return getExpression(sum).sum();
    }

    @Override
    public Node visitCount(IntExpression.Count count) {
        return getExpression(count).count();
    }

    @Override
    public Node visitPlus(IntExpression.Plus plus) {
        return getLeftIntExpression(plus).plus(getRightIntExpression(plus));
    }

    @Override
    public Node visitMinus(IntExpression.Minus minus) {
        return getLeftIntExpression(minus).minus(getRightIntExpression(minus));
    }

    @Override
    public Node visitMultiply(IntExpression.Multiply multiply) {
        return getLeftIntExpression(multiply).multiply(getRightIntExpression(multiply));
    }

    @Override
    public Node visitDivide(IntExpression.Divide divide) {
        return getLeftIntExpression(divide).divide(getRightIntExpression(divide));
    }

    @Override
    public Node visitModulo(IntExpression.Modulo modulo) {
        return getLeftIntExpression(modulo).modulo(getRightIntExpression(modulo));
    }

    @Override
    public Node visitIntConstant(IntExpression.IntConstant intConstant) {
        /*String digits = intConstant.getContext().sign != null &&
                !intConstant.getContext().sign.getText().isEmpty() ? "-" : "" +
                intConstant.getContext().INT().getText();
        return kodkod.ast.IntConstant.constant(Integer.valueOf(digits));*/
        return kodkod.ast.IntConstant.constant(Integer.parseInt(intConstant.getLabel()));
    }

    /**
     * Utils
     */

    private kodkod.ast.Formula implementDisjOperatorOverFormula() {

        List<kodkod.ast.Formula> listOfDisjFormulas =
                new ArrayList<>();

        for (List<kodkod.ast.Variable> disjVars : disjVars) {
            if (disjVars.size() > 1) {
                Iterator<kodkod.ast.Variable> iterator = disjVars.iterator();
                kodkod.ast.Variable var1 = iterator.next();
                kodkod.ast.Variable var2 = iterator.next();
                kodkod.ast.Formula formula = var1.eq(var2).not();
                while (iterator.hasNext()) {
                    kodkod.ast.Variable var3 = iterator.next();
                    formula = formula.and(var2.eq(var3).not());
                    var2 = var3;
                }
                listOfDisjFormulas.add(formula);
            }
        }

        kodkod.ast.Formula andOfDisjFormula = null;
        if (!listOfDisjFormulas.isEmpty()) {
            Iterator<kodkod.ast.Formula> iterator = listOfDisjFormulas.iterator();
            if (iterator.hasNext()) {
                andOfDisjFormula = iterator.next();
                while (iterator.hasNext()) {
                    andOfDisjFormula = andOfDisjFormula.and(iterator.next());
                }
            }
        }
        return andOfDisjFormula;
    }

    private Relation getRelation(Element<?> element, String relName) {
        return relationMap.getOrDefault(relName, null);
    }

    private kodkod.ast.Formula getFormulas(Element<?> element) {
        List<Formula> formulas = element.getOwnedElements(Formula.class);
        List<kodkod.ast.Formula> kodkodFormulaList = formulas.stream()
                .map(f -> (kodkod.ast.Formula) this.visit(f))
                .collect(Collectors.toList());
        kodkod.ast.Formula kodkodFormula = null;
        for (kodkod.ast.Formula formula : kodkodFormulaList) {
            if (kodkodFormula == null) kodkodFormula = formula;
            else kodkodFormula = kodkodFormula.and(formula);
        }
        return kodkodFormula;
    }

    private kodkod.ast.Formula getFormula(Element<?> element) {
        Formula formula1 = element.getOwnedElement(Formula.class);
        return (kodkod.ast.Formula) this.visit(formula1);
    }

    private kodkod.ast.Formula getLeftFormula(Element<?> element) {
        Element<?> left = element.getOwnedElements(Formula.class).get(0);
        return (kodkod.ast.Formula) this.visit(left);
    }

    private kodkod.ast.Formula getRightFormula(Element<?> element) {
        Element<?> left = element.getOwnedElements(Formula.class).get(1);
        return (kodkod.ast.Formula) this.visit(left);
    }

    private Decls getDecls(Element<?> element) {
        List<Declaration> decls = element.getOwnedElements(Declaration.class);
        Decls kodkodDecls = null;
        List<Decls> kodkodDeclsList = decls.stream().map(d -> (Decls) this.visit(d)).collect(Collectors.toList());
        for (Decls decl : kodkodDeclsList) {
            if (kodkodDecls == null) kodkodDecls = decl;
            else kodkodDecls = kodkodDecls.and(decl);
        }
        return kodkodDecls;
    }

    private kodkod.ast.Expression getExpression(Element<?> element) {
        Expression<?> expression = element.getOwnedElement(Expression.class);
        return (kodkod.ast.Expression) visit(expression);
    }

    private kodkod.ast.Expression getLeftExpression(Element<?> element) {
        Element<?> left = element.getOwnedElements(Expression.class).get(0);
        return (kodkod.ast.Expression) this.visit(left);
    }

    private kodkod.ast.Expression getRightExpression(Element<?> element) {
        Element<?> left = element.getOwnedElements(Expression.class).get(1);
        return (kodkod.ast.Expression) this.visit(left);
    }

    private kodkod.ast.IntExpression getLeftIntExpression(Element<?> element) {
        Element<?> left = element.getOwnedElements(IntExpression.class).get(0);
        return (kodkod.ast.IntExpression) this.visit(left);
    }

    private kodkod.ast.IntExpression getRightIntExpression(Element<?> element) {
        Element<?> left = element.getOwnedElements(IntExpression.class).get(1);
        return (kodkod.ast.IntExpression) this.visit(left);
    }

    private kodkod.ast.Expression getLeftExpressionOfInt(Element<?> element) {
        Element<?> left = element.getOwnedElements(IntExpression.class).get(0);
        return (kodkod.ast.Expression) this.visit(left);
    }

    private kodkod.ast.Expression getRightExpressionOfInt(Element<?> element) {
        Element<?> left = element.getOwnedElements(IntExpression.class).get(1);
        return (kodkod.ast.Expression) this.visit(left);
    }

}
