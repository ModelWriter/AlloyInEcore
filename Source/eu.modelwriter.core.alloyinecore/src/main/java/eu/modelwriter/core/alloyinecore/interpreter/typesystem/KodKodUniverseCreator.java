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
import eu.modelwriter.core.alloyinecore.interpreter.ParameterParser;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.*;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.PrimitiveType;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.Reference;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.IntegerValue;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import kodkod.ast.*;
import kodkod.engine.bool.Int;
import kodkod.instance.*;
import org.antlr.v4.runtime.Token;

import java.util.*;
import java.util.stream.Collectors;

public class KodKodUniverseCreator {

    private TypeSystem typeSystem;
    private Map<Type, Relation> typeRelationMap;
    private Map<Reference, Relation> referenceRelationMap;
    private Set<FormulaInfo> formulaInfos;

    private Instance instance;

    private Expression compositeExpr;

    private int maxBound = 0;

    public KodKodUniverseCreator(TypeSystem typeSystem, Instance instance) {
        this.typeSystem = typeSystem;
        typeRelationMap = new HashMap<>();
        referenceRelationMap = new HashMap<>();
        this.formulaInfos = new HashSet<>();

        this.instance = instance;

        typeSystem.getAllTypes().forEach(type -> {
            typeRelationMap.computeIfAbsent(type, t -> Relation.unary(t.getName()));
        });

        typeSystem.getRealReferences().forEach(ref -> {
            referenceRelationMap.computeIfAbsent(ref, r -> Relation.binary(r.getName()));
        });

        Set<Relation> compositeRels = new HashSet<>();
        typeSystem.getAllBasicReferences().forEach(ref -> {
            if (ref.getQualifiers().stream().anyMatch(t -> t.getText().equals("composes")))
                compositeRels.add(referenceRelationMap.get(ref));
        });
        typeSystem.getAllGenericReferences().forEach(ref -> {
            if (ref.getQualifiers().stream().anyMatch(t -> t.getText().equals("composes")))
                compositeRels.add(referenceRelationMap.get(ref));
        });

        if (compositeRels.isEmpty())
            compositeExpr = Expression.NONE;
        else
            compositeExpr = Expression.union(compositeRels);

        createTypeSystemFormula();
        collectInvariants();
    }

    private void createTypeSystemFormula() {

        typeFormula(typeSystem.OBJECT, new HashSet<>());
        referenceFormula();
        noDiscreteObjectFormula();
        classFormula();
    }

    private void collectInvariants() {
        Map<String, Relation> relationMap = new HashMap<>();
        typeRelationMap.values().forEach(r -> relationMap.put(r.name(), r));
        referenceRelationMap.values().forEach(r -> relationMap.put(r.name(), r));

        KodKodFormulaVisitor formulaVisitor = new KodKodFormulaVisitor(relationMap);

        formulaVisitor.visitInstance(instance);

        formulaInfos.addAll(formulaVisitor.getFormulaInfos());
    }

    private void classFormula() {
        Type classType = typeSystem.getPrimitiveType("Class");
        Reference typeRef = typeSystem.getReference(TypeCollector.typeReferenceName, typeSystem.OBJECT);

        if (classType == null || typeRef == null)
            return;

        for (Type subClass : classType.getSubTypes()) {
            ParameterParser pp = new ParameterParser(subClass.getName());
            Type type = typeSystem.getType(pp.getParameters().get(0));

            if (type != null) {
                Relation classRel = typeRelationMap.get(subClass);
                Relation typeRel = typeRelationMap.get(type);
                Relation refRel = referenceRelationMap.get(typeRef);

                if (classRel != null && typeRel != null) {
                    Variable var = Variable.unary(String.valueOf(typeRel.name().toLowerCase().charAt(0)));
                    Formula f = classRel.in(var.join(refRel)).iff(var.in(typeRel)).forAll(var.oneOf(Relation.UNIV));
                    formulaInfos.add(new FormulaInfo(f, type.getElement().getToken()));
                }
            }
        }

    }

    private void noDiscreteObjectFormula() {
        if (instance.getRootObject() == null)
            return;

        Type rootType = typeSystem.getType(instance.getRootObject().getClassifier().getSegment());

        if (rootType == null)
            return;

        Relation rootRelation = typeRelationMap.get(rootType);

        Expression typesExpr = Expression.union(typeSystem.getNonPrimitiveRootTypes().stream()
                .map(t -> typeRelationMap.get(t))
                .collect(Collectors.toSet()));

        Formula f = rootRelation.join(compositeExpr.reflexiveClosure()).eq(typesExpr);

        formulaInfos.add( new FormulaInfo(f, rootType.getElement().getToken(),
                "Every object must be accessible from the root object."));
    }

    private void referenceFormula() {
        typeSystem.getAllBasicReferences().stream().filter(r -> r.getStructuralFeature() != null).forEach(reference -> {
            Relation referenceRelation = referenceRelationMap.get(reference);
            Relation source = typeRelationMap.get(reference.getOwnerType());
            Relation target = typeRelationMap.get(reference.getReferencedType());

            if (source == null || target == null || referenceRelation == null)
                return;

            Formula f = referenceRelation.in(source.product(target));

            formulaInfos.add(new FormulaInfo(f, reference.getStructuralFeature().getToken()));
        });

        typeSystem.getAllGenericReferences().forEach(genericReference -> {
            Relation referenceRelation = referenceRelationMap.get(genericReference);

            Set<Expression> products = new HashSet<>();

            genericReference.getSubReferences().forEach(impl -> {
                Relation source = typeRelationMap.get(impl.getOwnerType());
                Relation target = typeRelationMap.get(impl.getReferencedType());
                products.add(source.product(target));
            });

            Formula f;

            if (products.isEmpty())
                f = referenceRelation.no();
            else
                f = referenceRelation.in(Expression.union(products));

            formulaInfos.add(new FormulaInfo(f, genericReference.getStructuralFeature().getToken()));
        });
    }

    private void typeFormula(Type type, Set<Type> visitedTypes) {
        if (visitedTypes.contains(type))
            return;

        visitedTypes.add(type);

        Relation relation = typeRelationMap.getOrDefault(type, null);
        List<Type> subTypes = new ArrayList<>(type.getSubTypes().stream()
                .filter(t -> !(t instanceof PrimitiveType))
                .collect(Collectors.toList()));

        if (relation != null) {
            if (type.isAbstract()) {
                Formula f;
                if (subTypes.isEmpty()) {
                    f = relation.no();
                }
                else {
                    f = relation.eq(Expression.union(subTypes.stream()
                            .map(t -> typeRelationMap.get(t))
                            .collect(Collectors.toSet())));
                }
                formulaInfos.add(
                        new FormulaInfo(f
                                , ((Class) type.getElement()).getContext().isAbstract
                                , type.getName() + " is abstract.")
                );
            }
            else {
                subTypes.forEach(subType -> {
                    Formula f = typeRelationMap.get(subType).in(relation);

                    formulaInfos.add(
                            new FormulaInfo(f
                                    , subType.getElement().getToken()
                                    , subType.getName() + " is a subtype of " + type.getName() + ".")
                    );
                });
            }

            if (type instanceof BasicType || type instanceof GenericTypeTemplate) {
                applyQualifierFormulas(type);

                // Find cardinality set constraints on references and generate the formula
                type.getReferences().stream()
                        .filter(ref -> ref instanceof BasicReference || ref instanceof GenericReference)
                        .forEach(reference -> {
                            Token token = getCardinality(reference);
                            if (token != null) {
                                Formula f = KodKodFormulaHelper.cardinalityFormula(token.getText(), referenceRelationMap.get(reference));
                                formulaInfos.add(new FormulaInfo(f, token));
                            }
                        });

                // Find cardinality set constraints on EClass and generate the formula
                if (type.getElement() instanceof Class && ((Class) type.getElement()).getContext().cardinality != null) {

                    Token token = ((Class) type.getElement()).getContext().cardinality;

                    Formula f = KodKodFormulaHelper.cardinalityFormula(token.getText(), relation);

                    formulaInfos.add(new FormulaInfo(f, token));
                }

                // Find multiplicity constraints on references for one, lone and some
                type.getReferences().stream()
                        .filter(ref -> ref instanceof BasicReference || ref instanceof GenericReference)
                        .filter(ref -> getOwnedMultiplicity(ref).equals("[1]"))
                        .forEach(reference -> {
                            Formula f = KodKodFormulaHelper.exactlyOneFormula(relation, referenceRelationMap.get(reference));
                            formulaInfos.add(new FormulaInfo(f, reference.getStructuralFeature().getToken()));
                        });

                type.getReferences().stream()
                        .filter(ref -> ref instanceof BasicReference || ref instanceof GenericReference)
                        .filter(ref -> getOwnedMultiplicity(ref).startsWith("[?"))
                        .forEach(reference -> {
                            Formula f = KodKodFormulaHelper.zeroOrOneFormula(relation, referenceRelationMap.get(reference));
                            formulaInfos.add(new FormulaInfo(f, reference.getStructuralFeature().getToken()));
                        });

                type.getReferences().stream()
                        .filter(ref -> ref instanceof BasicReference || ref instanceof GenericReference)
                        .filter(ref -> getOwnedMultiplicity(ref).startsWith("[+"))
                        .forEach(reference -> {
                            Formula f = KodKodFormulaHelper.oneOrMoreFormula(relation, referenceRelationMap.get(reference));
                            formulaInfos.add(new FormulaInfo(f, reference.getStructuralFeature().getToken()));
                        });
            }
        }

        for (int i = 0; i < subTypes.size(); i++) {
            Type left = subTypes.get(i);
            for (int j = i + 1; j < subTypes.size(); j++) {
                Type right = subTypes.get(j);
                if (Collections.disjoint(left.getAllSubTypes(), right.getAllSubTypes())) {
                    Relation leftRel = typeRelationMap.get(left);
                    Relation rightRel = typeRelationMap.get(right);
                    Formula f = leftRel.intersection(rightRel).no();

                    formulaInfos.add(new FormulaInfo(f, left.getElement().getToken(),
                                    left.getName() + " and " + right.getName() + " are disjoint types.")
                    );
                    formulaInfos.add(new FormulaInfo(f, right.getElement().getToken(),
                            left.getName() + " and " + right.getName() + " are disjoint types.")
                    );
                }
            }
        }

        subTypes.forEach(subType -> typeFormula(subType, visitedTypes));
    }

    private static Token getCardinality(Reference reference) {
        StructuralFeature structuralFeature = reference.getStructuralFeature();
        if (structuralFeature instanceof eu.modelwriter.core.alloyinecore.structure.model.Reference)
            return ((eu.modelwriter.core.alloyinecore.structure.model.Reference) structuralFeature).getContext().cardinality;
        else if (structuralFeature instanceof Attribute)
            return ((Attribute) structuralFeature).getContext().cardinality;
        return null;
    }

    private static String getOwnedMultiplicity(Reference reference) {
        StructuralFeature structuralFeature = reference.getStructuralFeature();
        if (structuralFeature instanceof eu.modelwriter.core.alloyinecore.structure.model.Reference)
            return TypedElement.getMultiplicity(((eu.modelwriter.core.alloyinecore.structure.model.Reference) structuralFeature).getContext().ownedMultiplicity);
        else if (structuralFeature instanceof Attribute)
            return TypedElement.getMultiplicity(((Attribute) structuralFeature).getContext().ownedMultiplicity);
        else return TypedElement.getMultiplicity(null);
    }

    private void applyQualifierFormulas(Type type) {
        type.getReferences().stream()
                .filter(ref -> ref instanceof BasicReference || ref instanceof GenericReference)
                .forEach(ref -> {
                    Relation typeRelation = typeRelationMap.get(type);
                    Relation relation = referenceRelationMap.get(ref);

                    Set<Token> qualifiers = ref.getQualifiers();

                    for (Token token : qualifiers) {
                        Formula formula = null;
                        String desc = null;

                        switch (token.getText()) {
                            case "id":
                                formula = KodKodFormulaHelper.identificationFormula(typeRelation, relation);
                                break;
                            case "acyclic":
                                formula = KodKodFormulaHelper.aCyclicFormula(typeRelation, relation);
                                desc = relation.name() + " is acyclic.";
                                break;
                            case "composes":
                                formula = KodKodFormulaHelper.compositionFormula(typeRelation, relation, compositeExpr);
                                //desc = "An object must be composed by max. 1 " + typeRelation.name() + ".";
                                break;
                            case "reflexive":
                                formula = KodKodFormulaHelper.reflexiveFormula(typeRelation, relation);
                                desc = relation.name() + " is reflexive.";
                                break;
                            case "irreflexive":
                                formula = KodKodFormulaHelper.irreflexiveFormula(typeRelation, relation);
                                desc = relation.name() + " is irreflexive.";
                                break;
                            case "transitive":
                                formula = KodKodFormulaHelper.transitiveFormula(relation);
                                desc = relation.name() + " is transitive.";
                                break;
                            case "symmetric":
                                formula = KodKodFormulaHelper.symmetricFormula(relation);
                                desc = relation.name() + " is symmetric.";
                                break;
                            case "asymmetric":
                                formula = KodKodFormulaHelper.aSymmetricFormula(relation);
                                desc = relation.name() + " is asymmetric.";
                                break;
                            case "antisymmetric":
                                formula = KodKodFormulaHelper.antiSymmetricFormula(typeRelation, relation);
                                desc = relation.name() + " is antisymmetric.";
                                break;
                            case "total":
                                formula = KodKodFormulaHelper.totalFormula(typeRelation, relation);
                                desc = relation.name() + " is total.";
                                break;
                            case "functional":
                                formula = KodKodFormulaHelper.functionalFormula(typeRelation, relation);
                                desc = relation.name() + " is functional.";
                                break;
                            case "function":
                                formula = KodKodFormulaHelper.functionFormula(typeRelation, relation);
                                desc = relation.name() + " is function.";
                                break;
                            case "surjective":
                                formula = KodKodFormulaHelper.surjectiveFormula(typeRelation, relation);
                                desc = relation.name() + " is surjective.";
                                break;
                            case "injective":
                                formula = KodKodFormulaHelper.injectiveFormula(typeRelation, relation);
                                desc = relation.name() + " is injective.";
                                break;
                            case "bijective":
                                formula = KodKodFormulaHelper.bijectiveFormula(typeRelation, relation);
                                desc = relation.name() + " is bijective.";
                                break;
                            case "complete":
                                formula = KodKodFormulaHelper.completeFormula(typeRelation, relation);
                                desc = relation.name() + " is complete.";
                                break;
                            case "bijection":
                                formula = KodKodFormulaHelper.bijectionFormula(typeRelation, relation);
                                desc = relation.name() + " is bijection.";
                                break;
                            case "preorder":
                                formula = KodKodFormulaHelper.preOrderFormula(typeRelation, relation);
                                desc = relation.name() + " is pre-order.";
                                break;
                            case "equivalence":
                                formula = KodKodFormulaHelper.equivalenceFormula(typeRelation, relation);
                                desc = relation.name() + " is equivalence.";
                                break;
                            case "partialorder":
                                formula = KodKodFormulaHelper.partialOrderFormula(typeRelation, relation);
                                desc = relation.name() + " is partial-order.";
                                break;
                            case "totalorder":
                                formula = KodKodFormulaHelper.totalOrderFormula(typeRelation, relation);
                                desc = relation.name() + " is total-order.";
                                break;
                        }

                        if (formula != null) {

                            FormulaInfo formulaInfo;

                            if (desc == null)
                                formulaInfo = new FormulaInfo(formula, token);
                            else
                                formulaInfo = new FormulaInfo(formula, token, desc);

                            formulaInfos.add(formulaInfo);
                        }
                    }
        });
    }

    private void boundFormulas(BoundCollector boundCollector) {
        int[] max = {getMaxBound()};

        boundCollector.getUnaryLowerBounds().forEach((type, atoms) -> {
            if (!typeRelationMap.containsKey(type))
                return;
            int lower = boundCollector.getLowerScope(type);
            if (boundCollector.hasScope(type) && lower > atoms.size()) {
                int upper = boundCollector.getUpperScope(type);
                if (lower == upper) {
                    // #Type = lower
                    Formula f = typeRelationMap.get(type).count().eq(IntConstant.constant(lower));
                    formulaInfos.add(new FormulaInfo(f, ((Class) type.getElement()).getContext().lowerScope));

                    max[0] = Math.max(max[0], lower);
                }
                else {
                    // #Type >= lower
                    Formula f = typeRelationMap.get(type).count().gte(IntConstant.constant(lower));
                    formulaInfos.add(new FormulaInfo(f, ((Class) type.getElement()).getContext().lowerScope));

                    max[0] = Math.max(max[0], lower);
                }
            }
        });

        boundCollector.getUnaryUpperBounds().forEach((type, atoms) -> {
            if (!typeRelationMap.containsKey(type))
                return;
            int upper = boundCollector.getUpperScope(type);
            if (boundCollector.hasScope(type) && boundCollector.getUpperScope(type) < atoms.size()) {
                int lower = boundCollector.getLowerScope(type);
                if (lower != upper) {
                    // Type <= upper
                    Formula f = typeRelationMap.get(type).count().lte(IntConstant.constant(upper));
                    formulaInfos.add(new FormulaInfo(f,
                            ((Class) type.getElement()).getContext().upperScope == null ?
                                    ((Class) type.getElement()).getContext().lowerScope :
                                    ((Class) type.getElement()).getContext().upperScope));

                    max[0] = Math.max(max[0], upper);
                }
                else if (lower <= boundCollector.getUnaryLowerBounds().get(type).size()) {
                    Formula f = typeRelationMap.get(type).count().gte(IntConstant.constant(upper));
                    formulaInfos.add(new FormulaInfo(f, ((Class) type.getElement()).getContext().lowerScope));

                    max[0] = Math.max(max[0], upper);
                }
            }
        });

        setMaxBound(max[0]);
    }

    public Bounds createBounds(BoundCollector boundCollector) {

        boundCollector.createBounds();

        boundFormulas(boundCollector);

        Universe universe = new Universe(boundCollector.getAtoms());
        TupleFactory f = universe.factory();
        Bounds bounds = new Bounds(universe);

        boundCollector.getUnaryLowerBounds().forEach((type, atoms) -> {
            bounds.bound(typeRelationMap.get(type), f.setOf(atoms.toArray()), f.setOf(boundCollector.getUnaryUpperBounds().get(type).toArray()));
        });

        boundCollector.getBinaryLowerBounds().forEach((ref, pairs) -> {
            Set<Pair<Atom>> upperPairs = boundCollector.getBinaryUpperBounds().get(ref);

            TupleSet lowerSet = pairs.isEmpty() ? f.noneOf(2) : f.setOf(pairs.stream()
                    .map(p -> f.tuple(p.getFirst(), p.getSecond())).collect(Collectors.toSet()));
            TupleSet upperSet = upperPairs.isEmpty() ? f.noneOf(2) : f.setOf(upperPairs.stream()
                    .map(p -> f.tuple(p.getFirst(), p.getSecond())).collect(Collectors.toSet()));

            bounds.bound(referenceRelationMap.get(ref), lowerSet, upperSet);
        });

        return bounds;
    }

    public Set<FormulaInfo> getFormulaInfos() {
        return formulaInfos;
    }

    public Set<Relation> getRelations() {
        Set<Relation> relations = new HashSet<>();
        relations.addAll(typeRelationMap.values());
        relations.addAll(referenceRelationMap.values());
        return relations;
    }

    public Formula getFormula() {
        return Formula.and(formulaInfos.stream().map(FormulaInfo::getFormula).collect(Collectors.toSet()));
    }

    public Map<Type, Set<Atom>> getAtoms(kodkod.instance.Instance instance) {
        Map<Type, Set<Atom>> typeAtoms = new HashMap<>();

        instance.relationTuples().forEach((Relation relation, TupleSet tuples) -> {
            if (tuples.arity() == 1){
                Type type = typeRelationMap.entrySet().stream()
                        .filter(e -> e.getValue().equals(relation))
                        .map(Map.Entry::getKey)
                        .findFirst().orElse(null);

                if (type != null)
                    typeAtoms.put(type, tuples.stream()
                            .map(e -> (Atom) e.atom(0))
                            .collect(Collectors.toSet()));
            }
        });

        return typeAtoms;
    }

    public Map<Type, Set<Atom>> getAtoms(Map<Relation, TupleSet> tupleSetMap) {
        Map<Type, Set<Atom>> typeAtoms = new HashMap<>();

        tupleSetMap.forEach((Relation relation, TupleSet tuples) -> {
            if (tuples.arity() == 1){
                Type type = typeRelationMap.entrySet().stream()
                        .filter(e -> e.getValue().equals(relation))
                        .map(Map.Entry::getKey)
                        .findFirst().orElse(null);

                if (type != null)
                    typeAtoms.put(type, tuples.stream()
                            .map(e -> (Atom) e.atom(0))
                            .collect(Collectors.toSet()));
            }
        });

        return typeAtoms;
    }

    public Map<Reference, Set<Pair<Atom>>> getReferences(kodkod.instance.Instance instance) {

        Map<Reference, Set<Pair<Atom>>> referencePairs = new HashMap<>();

        instance.relationTuples().forEach((Relation relation, TupleSet tuples) -> {
            if (tuples.arity() == 2){
                Reference ref = referenceRelationMap.entrySet().stream()
                        .filter(e -> e.getValue().equals(relation))
                        .map(Map.Entry::getKey)
                        .findFirst().orElse(null);

                if (ref != null)
                    referencePairs.put(ref, tuples.stream()
                            .map(e -> Pair.of((Atom) e.atom(0), (Atom) e.atom(1)))
                            .collect(Collectors.toSet()));
            }
        });

        return referencePairs;
    }

    public Map<Reference, Set<Pair<Atom>>> getReferences(Map<Relation, TupleSet> tupleSetMap) {

        Map<Reference, Set<Pair<Atom>>> referencePairs = new HashMap<>();

        tupleSetMap.forEach((Relation relation, TupleSet tuples) -> {
            if (tuples.arity() == 2){
                Reference ref = referenceRelationMap.entrySet().stream()
                        .filter(e -> e.getValue().equals(relation))
                        .map(Map.Entry::getKey)
                        .findFirst().orElse(null);

                if (ref != null)
                    referencePairs.put(ref, tuples.stream()
                            .map(e -> Pair.of((Atom) e.atom(0), (Atom) e.atom(1)))
                            .collect(Collectors.toSet()));
            }
        });

        return referencePairs;
    }

    public int getMaxBound() {
        return maxBound;
    }

    public void setMaxBound(int maxBound) {
        this.maxBound = maxBound;
    }

}
