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

import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.ast.Variable;

public class KodKodFormulaHelper {

    public static Formula compositionFormula(Relation type, Relation relation, Expression compositeExpr) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(compositeExpr.transpose()).lone().forAll(var.oneOf(type.join(relation)));
    }

    public static Formula aCyclicFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.in(var.join(relation.closure())).not().forAll(var.oneOf(type));
    }

    public static Formula transitiveFormula(Relation relation) {
        return relation.join(relation).in(relation);
    }

    public static Formula reflexiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.in(var.join(relation)).forAll(var.oneOf(type));
    }

    public static Formula irreflexiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.in(var.join(relation)).not().forAll(var.oneOf(type));
    }

    public static Formula symmetricFormula(Relation relation) {
        return relation.eq(relation.transpose());
    }

    public static Formula antiSymmetricFormula(Relation type, Relation relation) {
        Variable varA = Variable.unary("a");
        Variable varB = Variable.unary("b");
        return varB.in(varA.join(relation)).and(varA.in(varB.join(relation))).implies(varA.eq(varB))
                .forAll(varA.oneOf(type).and(varB.oneOf(type)));
    }

    public static Formula aSymmetricFormula(Relation relation) {
        return relation.eq(relation.transpose()).not();
    }

    public static Formula totalFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).some().forAll(var.oneOf(type));
    }

    public static Formula functionalFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).lone().forAll(var.oneOf(type));
    }

    public static Formula functionFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).one().forAll(var.oneOf(type));
    }

    public static Formula surjectiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return relation.join(var).some().forAll(var.oneOf(type));
    }

    public static Formula injectiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return relation.join(var).lone().forAll(var.oneOf(type));
    }

    public static Formula bijectiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return relation.join(var).one().forAll(var.oneOf(type));
    }

    public static Formula bijectionFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return relation.join(var).one().and(var.join(relation).one()).forAll(var.oneOf(type));
    }

    public static Formula completeFormula(Relation type, Relation relation) {
        Variable varA = Variable.unary("a");
        Variable varB = Variable.unary("b");
        return varA.eq(varB).not().implies(varA.product(varB).in(relation.union(relation.transpose())))
                .forAll(varA.oneOf(type).and(varB.oneOf(type)));
    }

    public static Formula preOrderFormula(Relation type, Relation relation) {
        return reflexiveFormula(type, relation).and(transitiveFormula(relation));
    }

    public static Formula equivalenceFormula(Relation type, Relation relation) {
        return symmetricFormula(relation).and(preOrderFormula(type, relation));
    }

    public static Formula partialOrderFormula(Relation type, Relation relation) {
        return preOrderFormula(type, relation).and(antiSymmetricFormula(type, relation));
    }

    public static Formula totalOrderFormula(Relation type, Relation relation) {
        return partialOrderFormula(type, relation).and(completeFormula(type, relation));
    }

    public static Formula identificationFormula(Relation type, Relation relation) {
        Variable a = Variable.unary("a");
        Variable b = Variable.unary("b");
        return a.eq(b).not().implies(a.join(relation).eq(b.join(relation)).not()).forAll(a.oneOf(type).and(b.oneOf(type)));
    }

    public static Formula exactlyOneFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).one().forAll(var.oneOf(type));
    }

    public static Formula zeroOrOneFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).lone().forAll(var.oneOf(type));
    }

    public static Formula oneOrMoreFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).some().forAll(var.oneOf(type));
    }

    public static Formula cardinalityFormula(String multiplicity, Relation type) {
        switch (multiplicity) {
            case "one":
                return type.one();
            case "lone":
                return type.lone();
            case "some":
                return type.some();
            case "no":
                return type.no();
            default:
                return Formula.TRUE;
        }
    }


}
