/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
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

package eu.modelwriter.core.alloyinecore.interpreter;

import eu.modelwriter.core.alloyinecore.structure.constraints.Expression;
import eu.modelwriter.core.alloyinecore.structure.model.RootPackage;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;
import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import kodkod.instance.Bounds;
import kodkod.instance.TupleFactory;
import kodkod.instance.TupleSet;

import java.util.*;
import java.util.stream.Collectors;

public class KodKodTypeSystemProducer extends BaseVisitorImpl<Void> {

    private static final String TYPE_RELATION = "class";
    private Relation typeRelation;

    private Set<Relation> relations;

    private Set<Relation> producedRelations;
    private Set<Formula> producedFormulas;

    private boolean produceTypeRelations;

    private Map<Relation, Set<String>> unaryBounds;
    private Set<String> producedAtoms;

    public KodKodTypeSystemProducer(Set<Relation> relations) {
        this.relations = new HashSet<>(relations.stream().filter(r -> r.arity() == 1).collect(Collectors.toSet()));

        this.producedFormulas = new HashSet<>();
        this.producedRelations = new HashSet<>();
        this.unaryBounds = new HashMap<>();
        this.producedAtoms = new HashSet<>();

        produceTypeRelations = false;
    }

    @Override
    public Void visitRootPackage(RootPackage _package) {
        Void v = super.visitRootPackage(_package);

        if (produceTypeRelations)
            produce();

        return v;
    }

    @Override
    public Void visitRelation(Expression.Relation relation) {
        String relName = relation.getContext().getText();

        if (relName.equals(TYPE_RELATION)) {
            produceTypeRelations = true;
        }

        return super.visitRelation(relation);
    }

    private void produce() {
        typeRelation = Relation.binary(TYPE_RELATION);

        Relation theClass = Relation.unary("Class");
        for (Relation relation : relations) {
            String atom = relation.name();
            Relation relationClass = Relation.unary("Class<" + atom + ">");

            producedAtoms.add(atom);

            unaryBounds.computeIfAbsent(relationClass, r -> new HashSet<>()).add(atom);
            unaryBounds.computeIfAbsent(theClass, r -> new HashSet<>()).add(atom);

            Variable var = Variable.unary(String.valueOf(relation.name().toLowerCase().charAt(0)));
            Formula f = var.in(relation).iff(relationClass.in(var.join(typeRelation))).forAll(var.oneOf(Relation.UNIV));
            producedFormulas.add(f);
        }

        producedRelations.add(theClass);
        producedRelations.add(typeRelation);
        producedRelations.addAll(unaryBounds.keySet());
    }

    public Bounds addToBound(TupleFactory f, Bounds bounds, Set<String> allAtoms) {
        if (isProduced()) {
            unaryBounds.forEach((rel, set) -> {
                bounds.boundExactly(rel, f.setOf(set.toArray()));
            });

            TupleSet binaryUpper = f.setOf(allAtoms.toArray()).product(f.setOf(producedAtoms.toArray()));
            bounds.bound(typeRelation, f.noneOf(binaryUpper.arity()), binaryUpper);
        }
        return bounds;
    }

    public Formula getProducedFormulas() {
        return Formula.and(producedFormulas);
    }

    public Set<Relation> getProducedRelations() {
        return producedRelations;
    }

    public Set<String> getProducedAtoms() {
        return producedAtoms;
    }

    public boolean isProduced() {
        return produceTypeRelations;
    }
}
