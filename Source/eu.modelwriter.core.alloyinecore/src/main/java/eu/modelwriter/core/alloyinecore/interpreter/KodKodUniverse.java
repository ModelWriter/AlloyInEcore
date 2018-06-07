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

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.*;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Enum;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;
import kodkod.ast.*;
import kodkod.engine.Solution;
import kodkod.instance.*;
import kodkod.util.nodes.PrettyPrinter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class KodKodUniverse {

    /**
     * <b> Element -> Relation </b><br>
     * <br>
     * Class -> Unary Relation <br>
     * StructuralFeature -> Binary Relation
     */
    private Map<Element<?>, Relation> relationMap = new HashMap<>();
    /**
     * Lower bounds of unary relations
     */
    private Map<Relation, Set<String>> rel2atoms = new HashMap<>();
    /**
     * Upper bounds of reasoned unary relations
     */
    private Map<Relation, Set<String>> upperBoundAtoms = new HashMap<>();
    /**
     * Atom to Object or Class, if the atom is reasoned maps to Class else corresponding Object.
     */
    private Map<String, Element<?>> atom2object = new HashMap<>();
    /**
     * Lower bound tuple of binary relations
     */
    private Map<Relation, Set<Tuple>> rel2tuple = new HashMap<>();

    private Map<Relation, Relation> genericReplacementMap;
    private Map<StructuralFeature, Set<Relation>> genericRanges;

    private Formula formula;
    private Bounds bounds;
    private Instance instance;
    private RootPackage mmRootPackage;

    private Map<Formula, Set<FormulaInfo>> formulaInfos = new HashMap<>();
    private int biggestCardinality = 7;

    private Set<EObject> inferredEObjects = new HashSet<>();
    private Map<EObject, Map<EStructuralFeature, Set<EObject>>> inferredRelations = new HashMap<>();

    private PrimitiveType EInt = null;
    //private PrimitiveType EBigInteger = null;
    private PrimitiveType EString = null;
    private PrimitiveType EBigDecimal = null;
    private PrimitiveType EBoolean = null;

    private Map<Relation, Map<String, Set<String>>> tuplesToAdd = new HashMap<>();

    private Map<Relation, String> singletonRelations = new HashMap<>();
    private Set<Relation> derivedRelations = new HashSet<>();

    private KodKodTypeSystemProducer typeSystemProducer;

    public KodKodUniverse(Instance instance) throws EObjectCreationException {
        this.instance = instance;
        mmRootPackage = instance.getOwnedElement(ModelImport.class)
                .getOwnedElement(Model.class)
                .getOwnedElement(RootPackage.class);

        ignoreGhostRelations();

        collectRelations();

        collectDerivedRelations();

        collectAtoms();
        collectConstants();

        GenericsCollector gc = new GenericsCollector(mmRootPackage);

        genericReplacementMap = gc.getGenericUnaryReplacementMap();
        genericRanges = gc.getGenericRanges();

        createTypeSystem();

        collectFormulas();
        formula = formula.and(gc.getFormulas());
    }

    private void createTypeSystem() {
        Set<Relation> relations = new HashSet<>();
        relations.addAll(relationMap.values());
        relations.addAll(genericReplacementMap.keySet());

        Set<String> atoms = new HashSet<>();
        atoms.addAll(rel2atoms.values().stream().flatMap(s -> s.stream()).collect(Collectors.toSet()));

        typeSystemProducer = new KodKodTypeSystemProducer(relations);
        typeSystemProducer.visitRootPackage(mmRootPackage);
    }

    private void ignoreGhostRelations() {
        instance.getAllOwnedElements(Reference.class, true).stream()
                .filter(r -> r.getContext().qualifier.stream()
                        .anyMatch(t -> t.getText().equals("ghost")))
                .forEach(r -> r.getOwner().deleteOwnedElement(r));

        instance.getAllOwnedElements(Attribute.class, true).stream()
                .filter(r -> r.getContext().qualifier.stream()
                        .anyMatch(t -> t.getText().equals("ghost")))
                .forEach(r -> r.getOwner().deleteOwnedElement(r));
    }

    private void collectDerivedRelations() {
        instance.getAllOwnedElements(Reference.class, true).stream()
                .filter(r -> r.getContext().qualifier.stream()
                        .anyMatch(t -> t.getText().equals("derived")))
                .forEach(r -> {if (relationMap.containsKey(r)) derivedRelations.add(relationMap.get(r));});

        instance.getAllOwnedElements(Attribute.class, true).stream()
                .filter(r -> r.getContext().qualifier.stream()
                        .anyMatch(t -> t.getText().equals("derived")))
                .forEach(r -> {if (relationMap.containsKey(r)) derivedRelations.add(relationMap.get(r));});

        derivedRelations.forEach(rel -> System.out.println(rel.name()));
    }

    private void collectRelations() {
        mmRootPackage.getAllOwnedElements(PrimitiveType.class, true).forEach(this::getRelationForPrimitiveType);
        mmRootPackage.getAllOwnedElements(Class.class, true).forEach(c ->
            relationMap.put(c, Relation.unary(c.getSegment())));
        mmRootPackage.getAllOwnedElements(Enum.class, true).forEach(c -> {
            Relation enumRel = Relation.unary(c.getSegment());
            relationMap.put(c, enumRel);
            rel2atoms.put(enumRel, c.getAllOwnedElements(EnumLiteral.class, true).stream()
                    .map(EnumLiteral::getLabel).collect(Collectors.toSet()));
            rel2atoms.get(enumRel).forEach(atom -> atom2object.put(atom, c));
                });
        mmRootPackage.getAllOwnedElements(StructuralFeature.class, true).forEach(sf ->
            relationMap.put(sf, Relation.binary(sf.getLabel())));
    }

    private Relation getRelationForPrimitiveType(PrimitiveType pt) {
        if (pt == null)
            return null;

        if (relationMap.containsKey(pt))
            return relationMap.get(pt);

        Relation relation;

        switch (pt.getLabel()) {
            case "EInt":
                if (EInt != null)
                    return relationMap.get(EInt);
                EInt = pt;
                relation = Relation.unary("EInt");
                break;
            case "EString":
                if (EString != null)
                    return relationMap.get(EString);
                EString = pt;
                relation = Relation.unary("EString");
                break;
            case "EBigInteger":
                if (EInt != null)
                    return relationMap.get(EInt);
                EInt = pt;
                relation = Relation.unary("EInt");
                break;
            case "EBigDecimal":
                if (EBigDecimal != null)
                    return relationMap.get(EBigDecimal);
                EBigDecimal = pt;
                relation = Relation.unary("EBigDecimal");
                break;
            case "EBoolean":
                if (EBoolean != null)
                    return relationMap.get(EBoolean);
                EBoolean = pt;
                relation = Relation.unary("EBoolean");
                break;
            default:
                return null;
        }

        relationMap.put(pt, relation);

        return relation;
    }

    private void collectAtoms() {
        AtomCollector atomCollector = new AtomCollector();
        atomCollector.visitInstance(instance);
    }

    private void collectConstants() {
        KodKodConstantVisitor constantVisitor = new KodKodConstantVisitor();
        constantVisitor.visitRootPackage(mmRootPackage);
        Set<String> stringConstants = constantVisitor.getStringConstants();
        Set<String> booleanConstants = constantVisitor.getBooleanConstants();

        for (String stringConstant : stringConstants) {
            Relation singletonRelation = Relation.unary(stringConstant);

            String label = stringConstant.substring(1, stringConstant.length() - 1);
            PrimitiveType pt = EString;
            Relation relation = getRelationForPrimitiveType(pt);
            if (relation != null) {
                rel2atoms.computeIfAbsent(relation, f -> new HashSet<>()).add(label);
                atom2object.put(label, pt);
            }

            singletonRelations.put(singletonRelation, label);
        }

        for (String booleanConstant : booleanConstants) {
            Relation singletonRelation = Relation.unary(booleanConstant);
            
            String label = booleanConstant.toLowerCase();
            PrimitiveType pt = EBoolean;
            Relation relation = getRelationForPrimitiveType(pt);
            if (relation != null) {
                rel2atoms.computeIfAbsent(relation, f -> new HashSet<>()).add(label);
                atom2object.put(label, pt);
            }

            singletonRelations.put(singletonRelation, label);
        }
    }

    private void collectFormulas() throws EObjectCreationException {
        Set<Relation> otherRelations = new HashSet<>();
        otherRelations.addAll(genericReplacementMap.keySet());
        otherRelations.addAll(singletonRelations.keySet());
        otherRelations.addAll(typeSystemProducer.getProducedRelations());

        KodKodFormulaVisitor formulaVisitor = new KodKodFormulaVisitor(relationMap, otherRelations);
        KodKodParameterFormulaVisitor parameterFormulaVisitor = new KodKodParameterFormulaVisitor(relationMap, genericReplacementMap, otherRelations);
        TypeSystem typeSystem = new TypeSystem();

        Formula formulaInvariants = formulaVisitor.visitRootPackage(mmRootPackage);
        Formula formulaGenericInvariants = parameterFormulaVisitor.visitRootPackage(mmRootPackage);
        Formula typeFormula = typeSystem.getTypeFormula(mmRootPackage, relationMap);

        formulaVisitor.getFormulaInfos().forEach((key, value) ->
                formulaInfos.computeIfAbsent(key, e -> new HashSet<>()).addAll(value));

        parameterFormulaVisitor.getFormulaInfos().forEach((key, value) ->
                formulaInfos.computeIfAbsent(key, e -> new HashSet<>()).addAll(value));

        typeSystem.getFormulaInfos().forEach((key, value) ->
                formulaInfos.computeIfAbsent(key, e -> new HashSet<>()).addAll(value));

        formula = typeFormula
                .and(formulaInvariants)
                .and(formulaGenericInvariants)
                .and(relationFormula())
                .and(accessFormula())
                .and(cardinalityFormula())
                .and(typeSystemProducer.getProducedFormulas());
    }

    /**
     * Creates a formula to prevent irrelevant atoms to be in the range or domain of a relation.
     */
    private Formula relationFormula(){
        List<Formula> relFormulas = new ArrayList<>();

        relationMap.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof StructuralFeature)
                .forEach(entry -> {

                    Relation relation = entry.getValue();

                    StructuralFeature sf = (StructuralFeature) entry.getKey();
                    GenericElementType type = (GenericElementType) sf.getOwnedElement(GenericElementType.class);

                    Relation relA = relationMap.get(sf.getOwner());
                    Relation relB;
                    if (type.getTarget() != null) { // If sf is an instance of Reference
                        relB = relationMap.get(type.getTarget().asElement());
                    }
                    else{ // If sf is an instance of Attribute
                        relB = getRelationForPrimitiveType(type.getOwnedElement(PrimitiveType.class));
                    }

                    if (relB == null){ // If range is a generic type
                        return;
                    }

                    Formula f = relation.in(relA.product(relB));

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, sf.getToken(),
                                    relation.name() + " relation must be between " + relA.name() + " and " + relB.name() + ".")
                    );

                    relFormulas.add(f);
                });

        return relFormulas.isEmpty() ? Formula.TRUE : Formula.and(relFormulas);
    }

    /**
     * Creates a formula to make sure the number of atoms is not greater than upper bound.
     */
    private Formula cardinalityFormula() {
        List<Formula> cf = new ArrayList<>();
        List<Integer> cards = new ArrayList<>();

        cards.add(7);

        relationMap.entrySet().stream()
                .filter(e -> e.getKey() instanceof Class)
                .forEach(entry -> {

                    Class c = ((Class) entry.getKey());
                    Relation rel = entry.getValue();

                    if (c.hasScope()
                            && c.getUpperScope() < upperBoundAtoms.getOrDefault(rel, Collections.emptySet()).size()) {

                        cards.add(c.getUpperScope());

                        Formula f = rel.count().lte(IntConstant.constant(c.getUpperScope()));

                        String desc = "There can be max. " + c.getUpperScope() + " " + rel.name() + ".";
                        formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                                (c.getContext().upperScope == null ?
                                        new FormulaInfo(f, c.getContext().lowerScope, desc) :
                                        new FormulaInfo(f, c.getContext().upperScope, desc))
                        );

                        cf.add(f);
                    }

                    if (c.hasScope()
                            && c.getLowerScope() > rel2atoms.getOrDefault(rel, Collections.emptySet()).size()) {

                        cards.add(c.getLowerScope());

                        Formula f = rel.count().gte(IntConstant.constant(c.getLowerScope()));

                        String desc = "There can be min. " + c.getLowerScope() + " " + rel.name() + ".";
                        formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                                new FormulaInfo(f, c.getContext().lowerScope, desc)
                        );

                        cf.add(f);
                    }
                });

        biggestCardinality = cards.stream().reduce(Math::max).orElse(7);
        return cf.isEmpty() ? Formula.TRUE : Formula.and(cf);
    }

    /**
     * Creates a formula to make sure that every atom is accessible from the root.
     */
    private Formula accessFormula() throws EObjectCreationException {
        if (instance.getRootObject() == null)
            throw new EObjectCreationException("Empty Root Object?");
        Class rootClass = instance.getRootObject().getClassifier();
        Relation root = relationMap.get(rootClass);

        Set<Relation> rels = relationMap.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof Reference
                        && ((Reference) entry.getKey()).getContext().qualifier
                                .stream()
                                .anyMatch(token -> token.getText().equals("composes")))
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());

        Set<Relation> types = relationMap.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof Class)
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());

        if (types.isEmpty() || rels.isEmpty())
            return Formula.TRUE;

        Expression relsExpr = Expression.union(rels);
        Expression typesExpr = Expression.union(types);

        Formula f = root.join(relsExpr.reflexiveClosure()).eq(typesExpr);

        formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                new FormulaInfo(f, rootClass.getToken(), "Every object must be accessible from the root object.")
        );

        return f;
    }

    /**
     * Returns the bounds of instance.
     */
    private void createBounds() {
        class ScopeFinder {
            private Set<String> atomsToIgnore = new HashSet<>();
            private Set<String> originalAtoms = new HashSet<>();

            private ScopeFinder(Set<String> originalAtoms){
                this.originalAtoms = new HashSet<>(originalAtoms);
            }

            private void findScope(){
                Map<Class, Boolean> visited = new HashMap<>();

                // Check scope, add new atoms if needed
                relationMap.keySet().stream()
                        .filter(e -> e instanceof Class)
                        .map(e -> (Class) e)
                        .filter(e -> e.getSuperTypes().size() == 0)
                        .forEach(e -> addAtomsForScope(e, visited));

                mmRootPackage.getAllOwnedElements(PrimitiveType.class, true).forEach(pt -> {


                // Add missing attributes if needed
                /*relationMap.entrySet().stream()
                        .filter(entry -> entry.getKey() instanceof PrimitiveType)
                        .forEach(entry -> {
                            PrimitiveType pt = (PrimitiveType) entry.getKey();*/
                            Element owner = pt.getOwner().getOwner().getOwner();
                            if (owner instanceof Class){
                                Set<String> newAtoms = new HashSet<>();
                                Set<String> upperAtoms = new HashSet<>();

                                newAtoms.addAll(upperBoundAtoms.getOrDefault(relationMap.get(owner), Collections.emptySet()));
                                ((Class) owner).getAllSubTypes()
                                        .forEach(e -> newAtoms.addAll(upperBoundAtoms.getOrDefault(relationMap.get(e), Collections.emptySet())));

                                Relation relation = /*entry.getValue()*/ getRelationForPrimitiveType(pt);
                                switch (relation.name()) {
                                    case "EString":
                                        int number = 0;
                                        for (int i = 0; number < newAtoms.size() - rel2atoms.getOrDefault(relation, new HashSet<>()).size(); i++) {
                                            String lbl = relation.name() + "_" + i;
                                            if (!rel2atoms.getOrDefault(relation, new HashSet<>()).contains(lbl)) {
                                                number++;
                                                upperAtoms.add(lbl);
                                                atom2object.put(lbl, pt);
                                            }
                                        }
                                        break;
                                    case "EInt":
                                        for (int i = rel2atoms.getOrDefault(relation, new HashSet<>()).size(); i < newAtoms.size(); i++) {
                                            String lbl;
                                            do {
                                                lbl = new Random().nextInt(100000) + "";
                                            } while (upperAtoms.contains(lbl));
                                            upperAtoms.add(lbl);
                                            atom2object.put(lbl, pt);
                                        }
                                        break;
                                    case "EBoolean":
                                        upperAtoms.add("true");
                                        atom2object.put("true", pt);
                                        upperAtoms.add("false");
                                        atom2object.put("false", pt);
                                        break;
                                    case "EBigDecimal":
                                        for (int i = rel2atoms.getOrDefault(relation, new HashSet<>()).size(); i < newAtoms.size(); i++) {
                                            String lbl;
                                            do {
                                                lbl = (new Random().nextInt(1000) + new Random().nextDouble()) + "";
                                            } while (upperAtoms.contains(lbl));
                                            upperAtoms.add(lbl);
                                            atom2object.put(lbl, pt);
                                        }
                                        break;
                                }

                                upperAtoms.addAll(rel2atoms.getOrDefault(relation, new HashSet<>()));
                                upperBoundAtoms.put(relation, upperAtoms);
                            }
                        });
            }

            private void addAtomsForScope(Class aClass, Map<Class, Boolean> visited){
                if (visited.getOrDefault(aClass, false))
                    return;
                visited.put(aClass, true);
                aClass.getSubTypes().forEach(e -> addAtomsForScope(e, visited));

                Relation relation = relationMap.get(aClass);
                Set<String> currentAtoms = new HashSet<>();

                currentAtoms.addAll(rel2atoms.getOrDefault(relation, new HashSet<>()));

                currentAtoms.addAll(aClass.getAllSubTypes().stream()
                        .flatMap(e -> rel2atoms
                                .getOrDefault(relationMap.getOrDefault(e, null), Collections.emptySet())
                                .stream())
                        .collect(Collectors.toSet()));

                upperBoundAtoms.computeIfAbsent(relation, k -> new HashSet<>()).addAll(aClass.getAllSubTypes().stream()
                        .flatMap(e -> upperBoundAtoms.get(relationMap.get(e)).stream())
                        .collect(Collectors.toSet()));

                Set<String> temp = new HashSet<>(currentAtoms);
                temp.addAll(upperBoundAtoms.get(relation));
                temp = temp.stream().distinct().collect(Collectors.toSet());

                if (temp.size() <= aClass.getLowerScope()) {
                    currentAtoms = temp;

                    if (currentAtoms.size() < aClass.getLowerScope()) {
                        Set<String> newAtoms = getNewAtomsForLowerScope(aClass, currentAtoms.size());
                        currentAtoms.addAll(newAtoms);
                    }
                }

                rel2atoms.put(relation, currentAtoms);
                upperBoundAtoms.get(relation).addAll(currentAtoms);

                Set<String> newAtoms = new HashSet<>();
                if (upperBoundAtoms.get(relation).size() < aClass.getUpperScope()) {
                    newAtoms.addAll(getNewAtomsForUpperScope(aClass, upperBoundAtoms.get(relation).size()));
                    upperBoundAtoms.get(relation).addAll(newAtoms);
                }

                aClass.getSubTypes()
                        .forEach(e -> addToUpper(e, upperBoundAtoms.get(relation)));

                atomsToIgnore.addAll(currentAtoms);
            }

            private void addToUpper(Class aClass, Set<String> atoms){
                if (aClass.hasScope())
                    return;
                Set<String> atomsClone = new HashSet<>(atoms);
                atomsClone.removeAll(atomsToIgnore);
                atomsClone.removeAll(originalAtoms);

                if (atomsClone.isEmpty())
                    return;

                Relation relation = relationMap.get(aClass);

                upperBoundAtoms.get(relation).addAll(atomsClone);

                aClass.getSubTypes().forEach(e -> addToUpper(e, atomsClone));

                aClass.getAllSuperTypes()
                        .forEach(e -> upperBoundAtoms
                                .computeIfAbsent(relationMap.get(e), k -> new HashSet<>())
                                .addAll(upperBoundAtoms.get(relation)));
            }

            private Set<String> getNewAtomsForUpperScope(Class aClass, int curSize) {
                Set<String> newAtoms = new HashSet<>();

                for (int i = curSize; i < aClass.getUpperScope(); i++) {
                    String name = aClass.getSegment() + "_" + i;
                    newAtoms.add(name);
                    atom2object.put(name, aClass);
                }
                return newAtoms;
            }

            private Set<String> getNewAtomsForLowerScope(Class aClass, int curSize) {
                Set<String> newAtoms = new HashSet<>();

                for (int i = curSize; i < aClass.getLowerScope(); i++) {
                    String name = aClass.getSegment() + "_" + i;
                    newAtoms.add(name);
                    atom2object.put(name, aClass);
                }
                return newAtoms;
            }

            private void setUnaryRelBounds(Bounds bounds, TupleFactory f) {
                relationMap.entrySet().stream()
                        .filter(entry -> entry.getKey() instanceof PrimitiveType || entry.getKey() instanceof Class || entry.getKey() instanceof Enum)
                        .forEach(entry -> {
                            Relation rel = entry.getValue();

                            Set<String> lowerBound = rel2atoms.getOrDefault(rel, Collections.emptySet());
                            Set<String> upperBound = upperBoundAtoms.getOrDefault(rel, new HashSet<>());
                            upperBound.addAll(lowerBound);

                            bounds.bound(rel, f.setOf(lowerBound.toArray()), f.setOf(upperBound.toArray()));
                        });
            }

            private void setBinaryRelBounds(Bounds bounds, TupleFactory f) {
                relationMap.entrySet().stream()
                        .filter(entry -> entry.getKey() instanceof StructuralFeature)
                        .forEach(entry -> {
                            Relation rel = entry.getValue();
                            StructuralFeature sf = (StructuralFeature) entry.getKey();
                            Set<Tuple> lowerBound = rel2tuple.getOrDefault(rel, Collections.emptySet());
                            TupleSet lowerBoundTuples = lowerBound.isEmpty() ? f.noneOf(rel.arity()) : f.setOf(lowerBound);
                            TupleSet upperBoundTuples;
                            TupleSet upperBound = getUpperBounds(sf, bounds, f);
                            upperBoundTuples = upperBound == null ? lowerBoundTuples : upperBound;
                            upperBoundTuples.addAll(lowerBoundTuples);
                            bounds.bound(rel, lowerBoundTuples, upperBoundTuples);
                        });
            }

            private TupleSet getUpperBounds(StructuralFeature sf, Bounds bounds, TupleFactory f) {
                Element owner = sf.getOwner();
                Relation domain = relationMap.get(owner);
                GenericElementType type = (GenericElementType) sf.getOwnedElement(GenericElementType.class);
                // If type is attribute
                Relation range;
                if (type.getTarget() == null){
                    range = getRelationForPrimitiveType(type.getOwnedElement(PrimitiveType.class));
                    if (range == null)
                        return null;
                }
                else{
                    range = relationMap.get(type.getTarget().asElement());
                }

                if (range == null){ // Range is a generic type!!!
                    Set<Relation> rels = genericRanges.getOrDefault(sf, Collections.emptySet());
                    Set<Tuple> tSet = new HashSet<>();
                    rels.forEach(relation -> tSet.addAll(bounds.upperBound(relation)));

                    if (tSet.isEmpty())
                        return null;

                    TupleSet domainTuples = bounds.upperBound(domain);
                    TupleSet rangeTuples = f.setOf(tSet);

                    if (domainTuples != null && rangeTuples != null)
                        return domainTuples.product(rangeTuples);
                    else {
                        return null;
                    }
                }

                TupleSet domainTuples = bounds.upperBound(domain);
                TupleSet rangeTuples = bounds.upperBound(range);
                if (domainTuples != null && rangeTuples != null)
                    return domainTuples.product(rangeTuples);
                else {
                    return null;
                }
            }
        }

        ScopeFinder sf = new ScopeFinder(rel2atoms.values().stream()
                .flatMap(Collection::stream).collect(Collectors.toSet()));
        sf.findScope();

        Set<String> universeSet = new HashSet<>(atom2object.keySet());
        universeSet.addAll(typeSystemProducer.getProducedAtoms());
        universeSet.addAll(genericReplacementMap.keySet().stream().map(LeafExpression::name).collect(Collectors.toSet()));

        Universe universe = new Universe(universeSet);
        TupleFactory f = universe.factory();
        Bounds bounds = new Bounds(universe);
        sf.setUnaryRelBounds(bounds, f);

        genericReplacementMap.forEach((key, value) -> bounds.bound(key, f.noneOf(1), bounds.upperBound(value)));
        singletonRelations.forEach((rel, atom) -> bounds.bound(rel, f.setOf(atom), f.setOf(atom)));

        TupleCollector tupleCollector = new TupleCollector(f);
        tupleCollector.visit(instance);

        tuplesToAdd.forEach((rel, tupleMap) -> {
            if (!derivedRelations.contains(rel)) {
                tupleMap.forEach((domain, rangeSet) -> {
                    rangeSet.forEach(range -> {
                        rel2tuple.computeIfAbsent(rel, e -> new HashSet<>()).add(f.tuple(domain, range));
                    });
                });
            }
        });

        sf.setBinaryRelBounds(bounds, f);

        typeSystemProducer.addToBound(f, bounds, upperBoundAtoms.values()
                .stream().flatMap(Collection::stream).collect(Collectors.toSet()));

        this.bounds = bounds;
    }

    /**
     * Writes bounds, formulas, and the solution to a file.
     */
    public void save(String outDir, String fileName, Bounds bounds, Formula formula, Solution solution) {
         try {
             Path path = Paths.get(outDir + File.separator + fileName);
             if (!Files.exists(path.getParent()))
                 Files.createDirectories(path.getParent());
             String newLine = System.getProperty("line.separator");
             String formulas = PrettyPrinter.print(formula, 0)
                     .replace(" && \n ", " and" )
                     .replace(" && \n", " $$" )
                     .replace("\n", "" )
                     .replace(" $$", " \n" )
                     .replace(" . ", ".")
                     .replace("   ", " ");

             String result = bounds.universe().toString() + newLine + newLine +
                     bounds.toString() + newLine + newLine +
                     formulas + newLine + newLine +
                     solution + newLine + newLine +
                     getInstanceString();


             Files.write(path, result.getBytes());
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

    /**
     * Updates instance with the output of solver.
     */
    public void updateWithInstance(kodkod.instance.Instance instance){
        Map<String, Element<?>> a2o = new HashMap<>();
        instance.relationTuples().forEach((Relation relation, TupleSet tuples) -> {
            if (tuples.arity() == 1){
                rel2atoms.remove(relation);
                rel2atoms.put(relation, tuples.stream().map(e -> e.atom(0).toString()).collect(Collectors.toSet()));

                a2o.putAll(atom2object.entrySet().stream()
                        .filter(e -> rel2atoms.get(relation).contains(e.getKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
            }
            else if (tuples.arity() == 2){
                rel2tuple.remove(relation);
                rel2tuple.put(relation, tuples);
            }
        });

        atom2object = a2o;
    }

    /**
     * Prints the current instance on the console.
     */
    public String getInstanceString(){
        String newLine = System.getProperty("line.separator");

        StringBuilder sb = new StringBuilder();

        relationMap.forEach((element, relation) -> {
            if (relation.arity() == 1 ){
                if (rel2atoms.get(relation) == null)
                    return;
                sb.append(String.format("%-15s %s",element.getLabel() + ":", rel2atoms.get(relation).stream().collect(Collectors.joining(", "))) + newLine);
            }
        });

        sb.append(newLine);

        relationMap.forEach((element, relation) -> {
            if (relation.arity() == 2){
                if (rel2tuple.get(relation) == null)
                    return;
                rel2tuple.get(relation).forEach(tuple ->
                        sb.append(relation.name() + " (" + tuple.atom(0) + ", " + tuple.atom(1) + ")" + newLine));
            }
        });

        return sb.toString();
    }

    /**
     * Sets EObjects of atoms from the given resource.
     * Creates new EObjects for the atoms that are not in the resource.
     * Adds those atoms to the resource.
     */
    private void setOrCreateEObjects(Resource res) throws EObjectCreationException {
        EPackage metapackage = res.getContents().get(0).eClass().getEPackage();
        EFactory metafactory = metapackage.getEFactoryInstance();

        // Sort atom2object by their position in the file.
        atom2object = atom2object.entrySet().stream()
                .distinct()
                .sorted((e,f) -> (e.getValue().getStart() - f.getValue().getStart()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        TreeIterator<EObject> treeIterator = res.getAllContents();
        Iterator<Map.Entry<String, Element<?>>> iterator = atom2object.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Element<?>> temp = iterator.next();
            if (temp.getValue() instanceof Object){
                if (treeIterator.hasNext()){
                    EObject eo = treeIterator.next();
                    ((Object) temp.getValue()).setEObject(eo);
                }
                else{
                    System.out.println(temp.getValue().getLabel() + " Something is wrong!");
                }
            }
            else if (temp.getValue() instanceof Class){
                Class type = (Class) temp.getValue();

                // Get the smallest subtype which is not abstract
                type = type.getAllSubTypes().stream()
                        .filter(e ->
                                !e.isAbstract()
                                        && e.getAllSubTypes().stream()
                                        .noneMatch(f -> rel2atoms.get(relationMap.get(f.asElement())).contains(temp.getKey()))
                                        && rel2atoms.get(relationMap.get(e.asElement())).contains(temp.getKey()))
                        .findFirst().orElse(type);

                if (!rel2atoms.get(relationMap.get(type)).contains(temp.getKey())) {
                    List<Class> types = new ArrayList<>();
                    types.add(type);
                    type = null;

                    while (type == null) {
                        types = types.stream().flatMap(e -> e.getSuperTypes().stream()).collect(Collectors.toList());

                        if (types.isEmpty()) {
                            throw new EObjectCreationException(temp.getValue().getLabel() + " is an abstract class!");
                        }

                        for (Class c : types) {
                            type = c;
                            type = type.getAllSubTypes().stream()
                                    .filter(e ->
                                            !e.isAbstract()
                                                    && e.getAllSubTypes().stream()
                                                    .noneMatch(f -> rel2atoms.get(relationMap.get(f.asElement())).contains(temp.getKey()))
                                                    && rel2atoms.get(relationMap.get(e.asElement())).contains(temp.getKey()))
                                    .findFirst().orElse(type);
                            if (rel2atoms.get(relationMap.get(type)).contains(temp.getKey()) && !type.isAbstract())
                                break;
                            else
                                type = null;
                        }
                    }
                }

                EObject eo = metafactory.create((EClass) metapackage.getEClassifier(type.getSegment()));
                Object object = new Object(eo, null);
                temp.setValue(object);

                inferredEObjects.add(eo);
            }
        }
    }

    /**
     * Adds binary relations to the resource.
     */
    private void addRelationsToResource(){
        relationMap.forEach((element, relation) -> {
            if (relation.arity() == 2 && element instanceof Reference) {
                if (rel2tuple.get(relation) == null)
                    return;
                // If model then do not add to resource
                if (((Reference) element).getContext().qualifier.stream()
                        .anyMatch(t -> t.getText().equals("model")))
                    return;
                rel2tuple.get(relation).forEach(tuple -> {
                    String atom1 = (String) tuple.atom(0);
                    String atom2 = (String) tuple.atom(1);
                    EObject eo1 = ((Object)atom2object.get(atom1)).getEObject();
                    java.lang.Object eo2 = null;
                    if (atom2object.get(atom2) instanceof PrimitiveType){
                        PrimitiveType pt = (PrimitiveType) atom2object.get(atom2);
                        if (pt.getLabel().equals("EBoolean")){
                            try {
                                eo2 = Boolean.parseBoolean(atom2);
                            }
                            catch (Exception ex){
                                eo2 = false;
                            }
                        }
                    }
                    else {
                        eo2 = ((Object)atom2object.get(atom2)).getEObject();
                    }

                    EReference reference = (EReference) eo1.eClass().getEStructuralFeature(relation.name());

                    if (eo1.eGet(reference) instanceof EList){
                        if (!((EList<java.lang.Object>)eo1.eGet(reference)).contains(eo2)){
                            ((EList<java.lang.Object>)eo1.eGet(reference)).add(eo2);
                            if (eo2 instanceof EObject)
                                inferredRelations.computeIfAbsent(eo1, e -> new HashMap<>())
                                        .computeIfAbsent(reference, e -> new HashSet<>())
                                        .add((EObject)eo2);
                        }
                    }
                    else if (!eo2.equals(eo1.eGet(reference))){
                        eo1.eSet(reference, eo2);
                        if (eo2 instanceof EObject)
                            inferredRelations.computeIfAbsent(eo1, e -> new HashMap<>())
                                    .computeIfAbsent(reference, e -> new HashSet<>())
                                    .add((EObject) eo2);
                    }
                });
            }
            else if (relation.arity() == 2 && element instanceof Attribute) {
                if (rel2tuple.get(relation) == null)
                    return;
                // If model then do not add to resource
                if (((Attribute) element).getContext().qualifier.stream()
                        .anyMatch(t -> t.getText().equals("model")))
                    return;
                rel2tuple.get(relation).forEach(tuple -> {
                    String atom1 = (String) tuple.atom(0);
                    String atom2 = (String) tuple.atom(1);
                    EObject eo = ((Object)atom2object.get(atom1)).getEObject();
                    Element pt = atom2object.get(atom2);

                    EAttribute ea = eo.eClass().getEAllAttributes().stream()
                            .filter(e -> e.getName().equals(relation.name()))
                            .findFirst()
                            .orElse(null);

                    java.lang.Object objectToAdd = null;
                    if (ea.getEType() instanceof EEnum){
                        try {
                            objectToAdd = ea.getEType().eContents().stream()
                                    .filter(e -> e instanceof EEnumLiteral && ((EEnumLiteral) e).getName().equals(atom2))
                                    .findFirst().orElse(null);
                        }
                        catch (Exception ex){}
                    }
                    else if (pt.getLabel().equals("EString")){
                        objectToAdd = atom2;
                    }
                    else if (pt.getLabel().equals("EInt")){
                        try {
                            objectToAdd = Integer.parseInt(atom2);
                        }
                        catch (Exception ex){
                            objectToAdd = 0;
                        }
                    }
                    else if (pt.getLabel().equals("EBigDecimal")){
                        try {
                            objectToAdd = BigDecimal.valueOf(Double.parseDouble(atom2));
                        }
                        catch (Exception ex){
                            objectToAdd = BigDecimal.ZERO;
                        }
                    }
                    else if (pt.getLabel().equals("EBigInteger")){
                        try {
                            objectToAdd = BigInteger.valueOf(Long.parseLong(atom2));
                        }
                        catch (Exception ex){
                            objectToAdd = BigInteger.ZERO;
                        }
                    }

                    if (objectToAdd != null) {
                        if (eo.eGet(ea) instanceof EList) {
                            if (!((EList<java.lang.Object>) eo.eGet(ea)).contains(objectToAdd)) {
                                ((EList<java.lang.Object>) eo.eGet(ea)).add(objectToAdd);
                            }
                        } else {
                            eo.eSet(ea, objectToAdd);
                        }
                    }
                });
            }
        });

    }

    public void setEObjects(String filename) throws IOException {
        ResourceSet rs = new ResourceSetImpl();
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

        Resource res = rs.getResource(URI.createFileURI(filename), true);
        res.load(Collections.emptyMap());

        // Sort atom2object by their position in the file.
        atom2object = atom2object.entrySet().stream()
                .distinct()
                .sorted((e,f) -> (e.getValue().getStart() - f.getValue().getStart()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        TreeIterator<EObject> treeIterator = res.getAllContents();
        Iterator<Map.Entry<String, Element<?>>> iterator = atom2object.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Element<?>> temp = iterator.next();
            if (temp.getValue() instanceof Object){
                if (treeIterator.hasNext()){
                    EObject eo = treeIterator.next();
                    ((Object) temp.getValue()).setEObject(eo);
                }
                else{
                    System.out.println(temp.getValue().getLabel() + " Something is wrong!");
                }
            }
        }
    }

    /**
     * Saves instance to the XMI file.
     */
    public void saveToXMI(String filename) throws IOException, EObjectCreationException {
        ResourceSet rs = new ResourceSetImpl();
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

        Resource res = rs.getResource(URI.createFileURI(filename), true);
        res.load(Collections.emptyMap());

        setOrCreateEObjects(res);
        addRelationsToResource();

        URI uri = URI.createFileURI(filename);
        res.setURI(uri);

        res.save(Collections.EMPTY_MAP);
    }

    public Set<EObject> getEObjectsOfAtoms(Set<String> atoms) {
        return atoms.stream()
                .map(a -> atom2object.getOrDefault(a, null))
                .filter(e -> e instanceof Object)
                .map(e -> ((Object) e).getEObject())
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public Map<String, String> getInferredsOfAtoms(Set<String> atoms) {
        return atoms.stream()
                .filter(a -> atom2object.getOrDefault(a, null) instanceof Class)
                .collect(Collectors.toMap(a -> a, a -> atom2object.get(a).getLabel()));
    }

    public Formula getFormula() {
        return formula;
    }

    public Bounds getBounds(){
        createBounds();

        return bounds;
    }

    public Set<EObject> getInferredEObjects() {
        return inferredEObjects;
    }

    public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getInferredRelations() {
        return inferredRelations;
    }

    public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getModelReferences() {

        Map<EObject, Map<EStructuralFeature, Set<EObject>>> modelRelations = new HashMap<>();

        relationMap.entrySet().stream()
                .filter(entry -> (entry.getKey() instanceof Reference &&
                        ((Reference) entry.getKey()).getContext().qualifier.stream()
                                .anyMatch(t -> t.getText().equals("model"))))
                .map(Map.Entry::getValue)
                .forEach(relation -> {
                    rel2tuple.getOrDefault(relation, Collections.emptySet()).forEach(tuple -> {
                        Element e1 = atom2object.getOrDefault(tuple.atom(0), null);
                        Element e2 = atom2object.getOrDefault(tuple.atom(1), null);

                        if (e1 instanceof Object && e2 instanceof Object) {
                            EObject eo1 = ((Object) e1).getEObject();
                            EObject eo2 = ((Object) e2).getEObject();

                            if (eo1 != null && eo2 != null) {
                                EStructuralFeature esf = eo1.eClass().getEAnnotations().stream()
                                        .flatMap(e -> e.getContents().stream())
                                        .filter(rel -> rel instanceof EStructuralFeature && ((EStructuralFeature) rel).getName().equals(relation.name()))
                                        .map(rel -> (EStructuralFeature) rel)
                                        .findFirst().orElse(null);

                                if (esf == null) {
                                    esf = eo1.eClass().getEAllSuperTypes().stream().flatMap(e -> e.getEAnnotations().stream())
                                            .flatMap(e -> e.getContents().stream())
                                            .filter(rel -> rel instanceof EStructuralFeature && ((EStructuralFeature) rel).getName().equals(relation.name()))
                                            .map(rel -> (EStructuralFeature) rel)
                                            .findFirst().orElse(null);
                                }
                                if (esf instanceof EReference)
                                    modelRelations.computeIfAbsent(eo1, e -> new HashMap<>())
                                            .computeIfAbsent(esf, e -> new HashSet<>())
                                            .add(eo2);
                            }
                        }
                    });
                });

        return modelRelations;
    }

    public Map<EObject, Map<EStructuralFeature, Set<String>>> getModelAttributes() {

        Map<EObject, Map<EStructuralFeature, Set<String>>> modelRelations = new HashMap<>();

        relationMap.entrySet().stream()
                .filter(entry -> (entry.getKey() instanceof Attribute &&
                                ((Attribute) entry.getKey()).getContext().qualifier.stream()
                                        .anyMatch(t -> t.getText().equals("model"))))
                .map(Map.Entry::getValue)
                .forEach(relation -> {
                    rel2tuple.getOrDefault(relation, Collections.emptySet()).forEach(tuple -> {
                        Element e1 = atom2object.getOrDefault(tuple.atom(0), null);
                        Element e2 = atom2object.getOrDefault(tuple.atom(1), null);

                        if (e1 instanceof Object && (e2 instanceof PrimitiveType || e2 instanceof Enum)) {
                            EObject eo1 = ((Object) e1).getEObject();
                            String eo2 = tuple.atom(1).toString();

                            if (eo1 != null && eo2 != null) {
                                EStructuralFeature esf = eo1.eClass().getEAnnotations().stream()
                                        .flatMap(e -> e.getContents().stream())
                                        .filter(rel -> rel instanceof EStructuralFeature && ((EStructuralFeature) rel).getName().equals(relation.name()))
                                        .map(rel -> (EStructuralFeature) rel)
                                        .findFirst().orElse(null);

                                if (esf == null) {
                                    esf = eo1.eClass().getEAllSuperTypes().stream().flatMap(e -> e.getEAnnotations().stream())
                                            .flatMap(e -> e.getContents().stream())
                                            .filter(rel -> rel instanceof EStructuralFeature && ((EStructuralFeature) rel).getName().equals(relation.name()))
                                            .map(rel -> (EStructuralFeature) rel)
                                            .findFirst().orElse(null);
                                }
                                if (esf instanceof EAttribute)
                                    modelRelations.computeIfAbsent(eo1, e -> new HashMap<>())
                                            .computeIfAbsent(esf, e -> new HashSet<>())
                                            .add(eo2);
                            }
                        }
                    });
                });

        return modelRelations;
    }

    public void setModelAttributes(Map<EObject, Map<EStructuralFeature, Set<String>>> modelAttributes) {
        modelAttributes.forEach((eo1, sfMap) -> {

            String atom1 = atom2object.entrySet().stream()
                    .filter(entry -> entry.getValue() instanceof Object
                            && EcoreUtil.getURI(((Object) entry.getValue()).getEObject()).fragment()
                                .equals(EcoreUtil.getURI(eo1).fragment()))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);

            if (atom1 != null) {
                sfMap.forEach((esf, eoSet) -> {
                    StructuralFeature sf = relationMap.keySet().stream()
                            .filter(e -> e.getLabel().equals(esf.getName()) && e instanceof StructuralFeature)
                            .filter(e -> e.getOwner().getLabel().equals(eo1.eClass().getName())
                                    || ((Class) e.getOwner()).getAllSuperTypes().stream()
                                        .map(Class::getLabel)
                                        .anyMatch(f -> eo1.eClass().getName().equals(f)))
                            .map(e -> (StructuralFeature) e)
                            .findFirst().orElse(null);


                    if (sf instanceof Attribute) {
                        Relation relation = relationMap.get(sf);
                        if (!derivedRelations.contains(relation)) {
                            eoSet.forEach(atom2 -> {
                                if (atom2 != null && relation != null && atom2object.containsKey(atom2)) {
                                    tuplesToAdd.computeIfAbsent(relation, e -> new HashMap<>())
                                            .computeIfAbsent(atom1, e -> new HashSet<>())
                                            .add(atom2);
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    public void setModelReferences(Map<EObject, Map<EStructuralFeature, Set<EObject>>> modelRelations) {
        modelRelations.forEach((eo1, sfMap) -> {

            String atom1 = atom2object.entrySet().stream()
                    .filter(entry -> entry.getValue() instanceof Object
                            && EcoreUtil.getURI(((Object) entry.getValue()).getEObject()).fragment()
                            .equals(EcoreUtil.getURI(eo1).fragment()))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(null);

            if (atom1 != null) {
                sfMap.forEach((esf, eoSet) -> {
                    StructuralFeature sf = relationMap.keySet().stream()
                            .filter(e -> e.getLabel().equals(esf.getName()) && e instanceof StructuralFeature)
                            .filter(e -> e.getOwner().getLabel().equals(eo1.eClass().getName())
                                    || ((Class) e.getOwner()).getAllSuperTypes().stream()
                                    .map(Class::getLabel)
                                    .anyMatch(f -> eo1.eClass().getName().equals(f)))
                            .map(e -> (StructuralFeature) e)
                            .findFirst().orElse(null);


                    if (sf instanceof Reference) {
                        Relation relation = relationMap.get(sf);

                        eoSet.forEach(eo2 -> {
                            String atom2 = atom2object.entrySet().stream()
                                    .filter(entry -> entry.getValue() instanceof Object
                                            && EcoreUtil.getURI(((Object) entry.getValue()).getEObject()).fragment()
                                            .equals(EcoreUtil.getURI(eo2).fragment()))
                                    .map(Map.Entry::getKey)
                                    .findFirst()
                                    .orElse(null);


                            if (atom2 != null && relation != null) {
                                tuplesToAdd.computeIfAbsent(relation, e -> new HashMap<>())
                                        .computeIfAbsent(atom1, e -> new HashSet<>())
                                        .add(atom2);
                            }
                        });
                    }
                });
            }
        });
    }

    private String getAtomName(Element<?> object) {
        if (object instanceof ObjectValue) object = ((ObjectValue) object).getObject();
        int line = object.getStart();
        //String loc = object.getFullLocation().replaceAll("\\D+", "");
        return object.getLabel() + line;
    }

    public int getBitwidth() {
        return (int) Math.ceil(Math.log(biggestCardinality + 1) / Math.log(2)) + 1;
    }

    public Set<FormulaInfo> getFormulaInfos(Formula f) {
        return formulaInfos.getOrDefault(f, Collections.emptySet());
    }

    private class AtomCollector extends BaseVisitorImpl<Object> {

        @Override
        public Object visitStringValue(StringValue stringValue) {
            String label = stringValue.getLabel();
            if (label.length() < 3)
                return super.visitStringValue(stringValue);
            label = label.substring(1, label.length() - 1);
            PrimitiveType pt = EString;
            Relation relation = getRelationForPrimitiveType(pt);
            if (relation != null) {
                rel2atoms.computeIfAbsent(relation, f -> new HashSet<>()).add(label);
                atom2object.put(label, pt);
            }
            return super.visitStringValue(stringValue);
        }

        @Override
        public Object visitIntegerValue(IntegerValue integerValue) {
            PrimitiveType pt = EInt;
            Relation relation = getRelationForPrimitiveType(pt);
            if (relation != null) {
                rel2atoms.computeIfAbsent(relation, f -> new HashSet<>()).add(integerValue.getLabel());
                atom2object.put(integerValue.getLabel(), pt);
            }
            return super.visitIntegerValue(integerValue);
        }

        @Override
        public Object visitBooleanValue(BooleanValue booleanValue) {
            PrimitiveType pt = EBoolean;
            Relation relation = getRelationForPrimitiveType(pt);
            if (relation != null) {
                rel2atoms.computeIfAbsent(relation, f -> new HashSet<>()).add(booleanValue.getLabel());
                atom2object.put(booleanValue.getLabel(), pt);
            }
            return super.visitBooleanValue(booleanValue);
        }

        @Override
        public Object visitRealValue(RealValue realValue) {
            PrimitiveType pt = EBigDecimal;
            Relation relation = getRelationForPrimitiveType(pt);
            if (relation != null) {
                rel2atoms.computeIfAbsent(relation, f -> new HashSet<>()).add(realValue.getLabel());
                atom2object.put(realValue.getLabel(), pt);
            }
            return super.visitRealValue(realValue);
        }

        @Override
        public Object visitObject(Object object) {
            Class classifier = object.getClassifier();

            if (object.getContext().id != null) {
                String id = object.getContext().id.getText();
                PrimitiveType pt = EInt;
                Relation relation = getRelationForPrimitiveType(pt);
                if (relation != null) {
                    rel2atoms.computeIfAbsent(relation, f -> new HashSet<>()).add(id);
                    atom2object.put(id, pt);

                    Attribute attribute = relationMap.keySet().stream()
                            .filter(e -> e instanceof Attribute)
                            .map(a -> (Attribute) a)
                            .filter(a -> a.getContext().qualifier.stream().anyMatch(t -> t.getText().equals("id")))
                            .filter(a ->  a.getOwner().equals(object.getClassifier())
                                        || object.getClassifier().getAllSuperTypes().contains(a.getOwner()))
                            .findFirst().orElse(null);

                    Relation rel = relationMap.get(attribute);
                    String domainAtom = getAtomName(object);

                    tuplesToAdd.computeIfAbsent(rel, e -> new HashMap<>())
                            .computeIfAbsent(domainAtom, e -> new HashSet<>()).add(id);
                }
            }

            Relation relation = relationMap.get(classifier);
            if (relation != null) {
                String name = getAtomName(object);
                rel2atoms.computeIfAbsent(relation, f -> new HashSet<>()).add(name);
                atom2object.put(name, object);
            }
            else
                System.err.println("Relation not found for " + classifier.getFullSegment());
            return super.visitObject(object);
        }
    }

    private class TupleCollector extends BaseVisitorImpl<Object> {
        private TupleFactory f;

        TupleCollector(TupleFactory f) {
            this.f = f;
        }

        @Override
        public Object visitSlot(Slot slot) {
            StructuralFeature key = slot.getDefiningFeature();
            Relation rel = relationMap.get(key);
            if (!derivedRelations.contains(rel)) {
                String domainAtom = getAtomName(slot.getOwner());
                List<Element<?>> elements = new ArrayList<>();
                if (key instanceof Reference) {
                    elements.addAll(slot.getOwnedElements(Object.class));
                    elements.addAll(slot.getOwnedElements(ObjectValue.class));
                    List<String> rangeAtoms = elements
                            .stream()
                            .map(KodKodUniverse.this::getAtomName)
                            .collect(Collectors.toList());
                    rangeAtoms.addAll(slot.getOwnedElements(BooleanValue.class).stream().map(Element::getLabel).collect(Collectors.toList()));
                    for (String rangeAtom : rangeAtoms) {
                        rel2tuple.computeIfAbsent(rel, f -> new HashSet<>()).add(f.tuple(domainAtom, rangeAtom));
                    }
                } else if (key instanceof Attribute) {
                    elements.addAll(slot.getOwnedElements(IntegerValue.class).stream()
                            .filter(e -> !e.getLabel().equals("0"))
                            .collect(Collectors.toList()));
                    elements.addAll(slot.getOwnedElements(BooleanValue.class));
                    elements.addAll(slot.getOwnedElements(ObjectValue.class));
                    elements.addAll(slot.getOwnedElements(RealValue.class));
                    List<String> rangeAtoms = elements
                            .stream()
                            .map(Element::getLabel)
                            .collect(Collectors.toList());

                    rangeAtoms.addAll(slot.getOwnedElements(StringValue.class).stream()
                            .filter(e -> e.getLabel().length() > 2)
                            .map(e -> e.getLabel().substring(1, e.getLabel().length() - 1))
                            .collect(Collectors.toList()));
                    for (String rangeAtom : rangeAtoms) {
                        rel2tuple.computeIfAbsent(rel, f -> new HashSet<>()).add(f.tuple(domainAtom, rangeAtom));
                    }
                }
            }
            return super.visitSlot(slot);
        }
    }

    private class GenericsCollector extends BaseVisitorImpl<Object> {
        Map<String, Set<String>> typeParameters = new HashMap<>();
        Map<String, Map<StructuralFeature, GenericElementType>> typeParameterUsages = new HashMap<>();
        Map<String, Set<String>> genericSubClasses = new HashMap<>();
        Map<String, Set<String>> generic2extendingGeneric = new HashMap<>();

        Map<Relation, Relation> relationReplacementMap = new HashMap<>();
        Map<String, Map<StructuralFeature, String>> createdTypeParameterUsages;
        Map<String, Map<StructuralFeature, String>> genericRangedRelations = new HashMap<>();

        List<Formula> formulas;

        //Map<Relation, Relation> extendsRelationReplacementMap = new HashMap<>();
        //Map<Relation, Relation> superRelationReplacementMap = new HashMap<>();

        GenericsCollector(RootPackage rootPackage){
            formulas = new ArrayList<>();

            visitRootPackage(rootPackage);
            createNewTypes();
        }

        private Formula getFormulas(){
            return formulas.isEmpty() ? Formula.TRUE : Formula.and(formulas);
        }

        private Map<Relation, Relation> getGenericUnaryReplacementMap() {
            return relationReplacementMap;
        }

        private Map<StructuralFeature, Set<Relation>> getGenericRanges() {
            Map<StructuralFeature, Set<Relation>> map = new HashMap<>();
            createdTypeParameterUsages.values().stream()
                    .flatMap(e -> e.entrySet().stream())
                    .filter(e -> !e.getValue().contains("?"))
                    .forEach(entry ->
                map.computeIfAbsent(entry.getKey(), e -> new HashSet<>()).add(getRelation(entry.getValue()))
            );
            return map;
        }

        private Relation getRelation(String name){
            return relationMap.values().stream()
                    .filter(e -> e.name().replace(" ", "").equals(name.replace(" ", "")))
                    .findFirst()
                    .orElse(relationReplacementMap.keySet().stream()
                            .filter(e -> e.name().replace(" ", "").equals(name.replace(" ", "")))
                            .findFirst()
                            .orElse(/*extendsRelationReplacementMap.keySet().stream()
                                    .filter(e -> e.name().replace(" ", "").equals(name.replace(" ", "")))
                                    .findFirst()
                                    .orElse(superRelationReplacementMap.keySet().stream()
                                            .filter(e -> e.name().replace(" ", "").equals(name.replace(" ", "")))
                                            .findFirst()
                                            .orElse(null))*/null));
        }

        @Override
        public Object visitTypeParameter(TypeParameter typeParameter) {
            //TODO: Operations are not being interpreted yet!
            if (typeParameter.getOwner() instanceof Operation || typeParameter.getOwner() instanceof Parameter) {
                return super.visitTypeParameter(typeParameter);
            }
            Class owner = ((Class) typeParameter.getOwner());

            typeParameters.computeIfAbsent(owner.getSegment(), e -> new LinkedHashSet<>())
                    .add(typeParameter.getLabel());

            return super.visitTypeParameter(typeParameter);
        }

        @Override
        public Object visitGenericSuperType(GenericSuperType genericSuperType) {
            if (getRelation(genericSuperType.getLabel()) == null){
                generic2extendingGeneric.computeIfAbsent(genericSuperType.getOwner().getLabel(), e -> new LinkedHashSet<>())
                        .add(genericSuperType.getLabel());
            }

            return super.visitGenericSuperType(genericSuperType);
        }

        @Override
        public Object visitGenericElementType(GenericElementType genericElementType) {
            //TODO: Operations are not being interpreted yet!
            if (genericElementType.getOwner() instanceof Operation || genericElementType.getOwner() instanceof Parameter) {
                return super.visitGenericElementType(genericElementType);
            }
            StructuralFeature reference = ((StructuralFeature) genericElementType.getOwner());
            Class owner = ((Class) reference.getOwner());

            if (typeParameters.getOrDefault(owner.getSegment(), Collections.emptySet()).stream()
                    .anyMatch(e -> e.equals(genericElementType.getLabel())
                            || genericElementType.getAllOwnedElements(GenericTypeArgument.class, false).stream()
                            .anyMatch(f -> f.getLabel().equals(e)))){

                typeParameterUsages.computeIfAbsent(owner.getSegment(), e -> new HashMap<>())
                        .put(reference, genericElementType);
            }
            else if (!genericElementType.getOwnedElements(GenericTypeArgument.class).isEmpty()){
                genericSubClasses.computeIfAbsent(genericElementType.getPathName(), e -> new LinkedHashSet<>())
                        .add(genericElementType.getLabel());
                genericRangedRelations.computeIfAbsent(owner.getSegment(), e -> new HashMap<>())
                        .put(reference, genericElementType.getLabel());
            }

            return super.visitGenericElementType(genericElementType);
        }

        private void createNewTypes(){
            relationReplacementMap = new HashMap<>();
            createdTypeParameterUsages = new HashMap<>();
            Map<String, List<String>> genericParameters = new HashMap<>();

            class TypeCreator {
                private Map<Relation, Set<Relation>> subTypes = new HashMap<>();
                private Map<Relation, Set<Relation>> abstractAndSubTypes = new HashMap<>();

                private void createTypes() {
                    genericSubClasses.values().stream().flatMap(Collection::stream).forEach(this::createType);
                    generic2extendingGeneric.values().stream()
                            .flatMap(Collection::stream)
                            .filter(e -> new ParameterParser(e).getParameters().stream()
                                    .allMatch(t -> getRelation(t) != null))
                            .filter(e -> getRelation(e) == null)
                            .forEach(this::createType);

                    Set<String> t = new HashSet<>(genericParameters.keySet());
                    t.forEach(this::createGenericSubTypes);
                }

                private void createType(String type){
                    ParameterParser pp = new ParameterParser(type);

                    String mainType = pp.getMainType();
                    List<String> parameterTypes = pp.getParameters();

                    if (getRelation(type) == null) {

                        if (parameterTypes.isEmpty())
                            return;

                        Relation relation = Relation.unary(type);
                        Relation replacement = getRelation(mainType);

                        if (replacement == null)
                            return;

                        relationReplacementMap.put(relation, replacement);
                        genericParameters.put(relation.name(), parameterTypes);

                        parameterTypes.forEach(this::createType);


                        Class element = relationMap.entrySet().stream()
                                .filter(entry -> entry.getValue().name().equals(mainType))
                                .map(entry -> (Class) entry.getKey())
                                .findFirst().orElse(null);

                        if (element == null)
                            return;

                        // Create the subtypes if possible
                        element.getSubTypes().forEach(sClass -> {
                            if (typeParameters.get(sClass.getSegment()) != null) {
                                String subWP = generic2extendingGeneric.entrySet().stream()
                                        .filter(g -> new ParameterParser(g.getKey()).getMainType().equals(sClass.getSegment()))
                                        .map(Map.Entry::getKey).findFirst().orElse(null);

                                generic2extendingGeneric.get(subWP).stream()
                                        .filter(g -> new ParameterParser(g).getMainType().equals(mainType)).forEach(supWP -> {

                                    Map<String, String> equalParams = new HashMap<>();

                                    ParameterParser subPP = new ParameterParser(subWP);
                                    List<String> subParameterTypes = subPP.getParameters();

                                    ParameterParser supPP = new ParameterParser(supWP);
                                    List<String> supParameterTypes = supPP.getParameters();

                                    Iterator<String> mainParameters = parameterTypes.iterator();
                                    Iterator<String> supParameters = supParameterTypes.iterator();

                                    while (mainParameters.hasNext() && supParameters.hasNext()){
                                        String mainParam = mainParameters.next();
                                        String supParam = supParameters.next();
                                        if (equalParams.getOrDefault(supParam, null) == null){
                                            equalParams.put(supParam, mainParam);
                                        }
                                        else if (!equalParams.get(supParam).equals(mainParam)) {
                                            return;
                                        }
                                    }

                                    subParameterTypes = subParameterTypes.stream()
                                            .map(e -> equalParams.getOrDefault(e, e)).collect(Collectors.toList());

                                    if (subParameterTypes.stream().anyMatch(e -> getRelation(e) == null)) {
                                        return;
                                    }

                                    String newSubType = subPP.getMainType() + "<"
                                            + subParameterTypes.stream().collect(Collectors.joining(", "))
                                            + ">";

                                    createType(newSubType);
                                });

                            }
                        });
                    }

                    // Create the super types
                    generic2extendingGeneric.entrySet().stream()
                            .filter(e -> new ParameterParser(e.getKey()).getMainType().equals(mainType))
                            .map(Map.Entry::getValue).findFirst().orElse(Collections.emptySet())
                            .forEach(superType -> {
                        Map<String, String> equalParams = new HashMap<>();
                        ParameterParser spp = new ParameterParser(superType);
                        List<String> superParameterTypes = spp.getParameters();

                        if (!parameterTypes.isEmpty()) {
                            Iterator<String> mainParameters = parameterTypes.iterator();
                            Iterator<String> classParameters = typeParameters.getOrDefault(mainType, Collections.emptySet()).iterator();

                            while (mainParameters.hasNext() && classParameters.hasNext()){
                                equalParams.put(classParameters.next(), mainParameters.next());
                            }

                            superParameterTypes = superParameterTypes.stream()
                                    .map(e -> equalParams.getOrDefault(e, e)).collect(Collectors.toList());
                        }

                        String newSuperType = spp.getMainType() + "<"
                                + superParameterTypes.stream().collect(Collectors.joining(", "))
                                + ">";

                        createType(newSuperType);

                        Relation relation = getRelation(type);
                        Relation superRelation = getRelation(newSuperType);

                        subTypes.computeIfAbsent(superRelation, e -> new HashSet<>()).add(relation);
                    });
                }

                private void createGenericSubTypes(String type) {
                    ParameterParser pp = new ParameterParser(type);
                    List<String> empty = new ArrayList<>();
                    empty.add("");
                    List<String> allNewTypes = getNewSubTypeParameters(empty, pp.getParameters(), 0);

                    if (allNewTypes.isEmpty()) {
                        abstractAndSubTypes.computeIfAbsent(getRelation(type), f -> new HashSet<>());
                    }
                    allNewTypes.forEach(e -> {
                        String newSubType = pp.getMainType() + "<" + e + ">";

                        if (type.equals(newSubType))
                            return;

                        if (getRelation(newSubType) == null)
                            createType(newSubType);

                        abstractAndSubTypes.computeIfAbsent(getRelation(type), f -> new HashSet<>()).add(getRelation(newSubType));
                        subTypes.computeIfAbsent(getRelation(type), f -> new HashSet<>()).add(getRelation(newSubType));
                    });
                }

                private List<String> getNewSubTypeParameters(List<String> list, List<String> types, int pos) {
                    if (pos == types.size())
                        return list;

                    List<String> nList = new ArrayList<>();
                    ParameterParser pp = new ParameterParser(types.get(pos));

                    if (types.get(pos).equals("?")) {
                        List<String> subs = getAllTypes();
                        if (subs.isEmpty()) return Collections.EMPTY_LIST;
                        list.forEach(e ->
                                subs.forEach(f ->
                                        nList.add((pos == 0 ? "" : e + ", ") + f)));
                    }
                    else if (pp.getExtendsType() != null) {
                        List<String> subs = getSubTypes(pp.getExtendsType());
                        if (subs.isEmpty()) return Collections.EMPTY_LIST;
                        list.forEach(e ->
                            subs.forEach(f ->
                                nList.add((pos == 0 ? "" : e + ", ") + f)));
                    }
                    else if (pp.getSuperType() != null) {
                        List<String> sups = getSuperTypes(pp.getSuperType());
                        if (sups.isEmpty()) return Collections.EMPTY_LIST;
                        list.forEach(e ->
                                sups.forEach(f ->
                                        nList.add((pos == 0 ? "" : e + ", ") + f)));
                    }
                    else {
                        list.forEach(e -> nList.add((pos == 0 ? "" : e + ", ") + types.get(pos)));
                    }

                    return getNewSubTypeParameters(nList, types, pos + 1);
                }

                private List<String> getSubTypes(String type) {
                    List<String> subs = subTypes.entrySet().stream()
                            .filter(entry -> entry.getKey().name().replace(" ", "").equals(type.replace(" ", "")))
                            .map(Map.Entry::getValue)
                            .flatMap(Collection::stream)
                            .map(LeafExpression::name)
                            .collect(Collectors.toList());

                    Class element = relationMap.entrySet().stream()
                            .filter(entry -> entry.getValue().name().equals(type))
                            .map(entry -> (Class) entry.getKey())
                            .findFirst().orElse(null);

                    if (element != null) {
                        subs.addAll(element.getSubTypes().stream()
                                .map(Class::getSegment)
                                .filter(e -> !typeParameters.keySet().contains(e))
                                .collect(Collectors.toList()));
                    }

                    return subs;
                }

                private List<String> getSuperTypes(String type) {
                    List<String> sups = subTypes.entrySet().stream()
                            .filter(entry -> entry.getValue().stream()
                                    .anyMatch(e -> e.name().replace(" ", "").equals(type.replace(" ", ""))))
                            .map(Map.Entry::getKey)
                            .map(LeafExpression::name)
                            .collect(Collectors.toList());

                    Class element = relationMap.entrySet().stream()
                            .filter(entry -> entry.getValue().name().equals(type))
                            .map(entry -> (Class) entry.getKey())
                            .findFirst().orElse(null);

                    if (element != null) {
                        sups.addAll(element.getSuperTypes().stream()
                                .map(Class::getSegment)
                                .filter(e -> !typeParameters.keySet().contains(e))
                                .collect(Collectors.toList()));
                    }

                    return sups;
                }

                private List<String> getAllTypes() {
                    Set<Relation> rels = relationMap.entrySet().stream()
                            .filter(entry -> entry.getKey() instanceof Class && getRelation(entry.getKey().getLabel()) != null)
                            .map(Map.Entry::getValue)
                            .collect(Collectors.toSet());

                    rels.addAll(getGenericUnaryReplacementMap().keySet());

                    return rels.stream()
                            .filter(r -> subTypes.getOrDefault(r.name(), Collections.EMPTY_SET).isEmpty()
                                    && getRelation(r.name()) != null
                                    && !r.name().contains("?"))
                            .distinct()
                            .map(LeafExpression::name)
                            .filter(e -> !typeParameters.keySet().contains(e))
                            .collect(Collectors.toList());
                }

                private void createUsages() {
                    relationReplacementMap.forEach((relation, replacement) -> {
                        Map<String, String> equalTypeParameters = new HashMap<>();

                        Set<String> superTypeParameters = typeParameters.get(replacement.name());

                        List<String> subTypeParameters = genericParameters.get(relation.name());

                        Iterator<String> superIterator = superTypeParameters.iterator();
                        Iterator<String> subIterator = subTypeParameters.iterator();

                        while (superIterator.hasNext() && subIterator.hasNext()){
                            equalTypeParameters.put(superIterator.next(), subIterator.next());
                        }

                        Map<StructuralFeature, GenericElementType> usages = typeParameterUsages.getOrDefault(replacement.name(), new HashMap<>());
                        UsageNameFinder unf = new UsageNameFinder(equalTypeParameters);

                        createdTypeParameterUsages.put(relation.name(),
                                usages.entrySet().stream()
                                        .collect(Collectors.toMap(Map.Entry::getKey, a -> unf.getNewName(a.getValue()))));
                    });

                    final boolean[] changed = {false};
                    createdTypeParameterUsages.values().stream().flatMap(e -> e.values().stream()).forEach(type -> {
                        if (getRelation(type) == null) {
                            ParameterParser pp = new ParameterParser(type);
                            String mainType = pp.getMainType();

                            Class element = relationMap.entrySet().stream()
                                    .filter(entry -> entry.getValue().name().equals(mainType))
                                    .map(entry -> (Class) entry.getKey())
                                    .findFirst().orElse(null);

                            if (element == null)
                                return;

                            int upperScope = element.getUpperScope();

                            if (createdTypeParameterUsages.keySet().stream()
                                    .filter(t -> new ParameterParser(t).getMainType().equals(mainType))
                                    .count() < upperScope) {

                                createType(type);
                                changed[0] = true;
                            }
                        }
                    });
                    if (changed[0])
                        createUsages();
                }

                private void createFormulas() {
                    genericRangedRelations.entrySet().forEach(entry -> {
                        Relation domain = getRelation(entry.getKey());
                        entry.getValue().entrySet().forEach(relRange -> {
                            Relation relation = relationMap.get(relRange.getKey());
                            Relation range = getRelation(relRange.getValue());

                            Formula f = domain.join(relation).in(range);

                            formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                                    new FormulaInfo(f, relRange.getKey().getToken())
                            );

                            formulas.add(f);
                        });
                    });
                    typeParameterUsages.values().stream().flatMap(e -> e.keySet().stream()).forEach(sf -> {
                        List<Expression> fromTo = new ArrayList<>();
                        Relation reference = relationMap.get(sf);

                        createdTypeParameterUsages.entrySet().stream().forEach(stringMapEntry -> {
                            Relation from = getRelation(stringMapEntry.getKey());
                            stringMapEntry.getValue().entrySet().stream()
                                    .filter(e -> e.getKey().equals(sf))
                                    .forEach(structuralFeatureStringEntry -> {
                                Relation to = getRelation(structuralFeatureStringEntry.getValue());

                                if (to != null && !to.name().contains("?")) {
                                    fromTo.add(from.product(to));
                                }
                            });
                        });
                        if (!fromTo.isEmpty()) {
                            Formula f = reference.in(Expression.union(fromTo));

                            formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                                    new FormulaInfo(f, sf.getToken())
                            );

                            formulas.add(f);
                        }
                    });
                    typeParameters.keySet().forEach(s -> {
                        Relation relation = getRelation(s);
                        Class element = relationMap.entrySet().stream()
                                .filter(er -> er.getValue().equals(relation))
                                .map(er -> (Class) er.getKey())
                                .findFirst().orElse(null);

                        List<Relation> typeList = new ArrayList<>(element.getSubTypes().stream()
                                .map(e -> getRelation(e.getSegment()))
                                .collect(Collectors.toList()));
                        typeList.addAll(relationReplacementMap.entrySet().stream()
                                .filter(e -> e.getValue().equals(relation))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList()));
                        /*typeList.addAll(extendsRelationReplacementMap.entrySet().stream()
                                .filter(e -> e.getValue().equals(relation))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList()));*/

                        Formula f;

                        if (typeList.isEmpty())
                            f = relation.no();
                        else {
                            Expression expression = Expression.union(typeList);
                            f = relation.eq(expression);
                        }

                        formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                                new FormulaInfo(f, element.getToken())
                        );

                        formulas.add(f);
                    });
                    subTypes.forEach((key, value) -> value.forEach(rel -> {
                        if (!abstractAndSubTypes.getOrDefault(key, Collections.EMPTY_SET).contains(rel)) {
                            formulas.add(rel.in(key));
                        }
                    }));
                    abstractAndSubTypes.forEach((sup, value) -> {
                        Set<Relation> subs = new HashSet<>(value);

                        if (subs.isEmpty()) {
                            formulas.add(sup.no());
                        } else {
                            formulas.add(sup.eq(Expression.union(subs)));
                        }
                    });
                    generic2extendingGeneric.forEach((key, value) -> {
                        Relation subRel = getRelation(key);
                        value.stream().filter(e -> new ParameterParser(e).getParameters().stream()
                                .allMatch(t -> getRelation(t) != null)).forEach(rel -> {

                            Class c = relationMap.entrySet().stream()
                                    .filter(entry -> entry.getValue().equals(subRel))
                                    .map(entry -> (Class) entry.getKey())
                                    .findFirst().orElse(null);

                            Formula f = subRel.in(getRelation(rel));

                            formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                                    new FormulaInfo(f, c.getToken())
                            );

                            formulas.add(f);
                        });
                    });

                    typeParameters.keySet().forEach(type -> {
                        Set<Expression> differentTypes = relationReplacementMap.entrySet().stream()
                                .filter(e -> e.getValue().name().equals(type) && !e.getKey().name().contains("?"))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toSet());

                        noIntersection(differentTypes);
                    });
                }

                private void noIntersection(Set<Expression> relations) {
                    for (int i = 1; i < relations.size(); i++){
                        Iterator<Expression> iterator = relations.iterator();
                        Expression rel = null;
                        for (int j = 0; j <= i; j++) {
                            rel = iterator.next();
                        }
                        Set<Expression> exps = relations.stream()
                                .limit(i).collect(Collectors.toSet());
                        Expression exp = Expression.union(exps);
                        if (exp != null && rel != null)
                            formulas.add(rel.intersection(exp).no());
                    }
                }
            }

            TypeCreator typeCreator = new TypeCreator();
            typeCreator.createTypes();
            typeCreator.createUsages();
            typeCreator.createFormulas();
        }

        class UsageNameFinder {
            Map<String, String> equalTypeParameters;

            UsageNameFinder(Map<String, String> equalTypeParameters){
                this.equalTypeParameters = equalTypeParameters;
            }

            private String getNewName(Element element){
                String name;
                String label = element.getLabel();
                List<Element> owneds = element.getOwnedElements(GenericTypeArgument.class);
                List<Element> ownedGws= element.getOwnedElements(GenericWildcard.class);
                ownedGws = ownedGws.stream().filter(gw -> !gw
                        .getOwnedElements(GenericTypeArgument.class).isEmpty())
                        .collect(Collectors.toList());
                owneds.addAll(ownedGws);

                if (owneds.isEmpty()){
                    if (label.contains("extends")){
                        String type = label.substring(0, label.indexOf("extends ") + 8);
                        type = equalTypeParameters.getOrDefault(type, type);
                        label = label.substring(0, label.indexOf("extends ") + 8) + type;
                    }
                    else if (label.contains("super")){
                        String type = label.substring(label.indexOf("super ") + 6);
                        type = equalTypeParameters.getOrDefault(type, type);
                        label = label.substring(0, label.indexOf("super ") + 6) + type;
                    }
                    name = equalTypeParameters.getOrDefault(label, label);
                    return name;
                }
                name = label.substring(0, label.indexOf('<'))
                        + "<"
                        + owneds.stream().map(this::getNewName).collect(Collectors.joining(", "))
                        + ">";
                return name;
            }
        }
    }
}
