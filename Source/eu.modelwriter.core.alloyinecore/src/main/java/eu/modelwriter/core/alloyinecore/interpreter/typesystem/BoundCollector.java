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

import eu.modelwriter.core.alloyinecore.interpreter.ParameterParser;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.*;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.Reference;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.constraints.Expression;
import eu.modelwriter.core.alloyinecore.structure.constraints.IntExpression;
import eu.modelwriter.core.alloyinecore.structure.instance.*;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Enum;

import java.util.*;
import java.util.stream.Collectors;

public class BoundCollector {

    private Instance instance;
    private TypeSystem typeSystem;

    private Map<Type, Pair<Integer>> scopes;

    private Map<Type, Map<String, Atom>> atomMap;

    private Map<Type, Set<Atom>> unaryLowerBounds;
    private Map<Type, Set<Atom>> unaryUpperBounds;
    private Map<Type, Set<Atom>> unaryExactBounds;

    private Map<Reference, Set<Pair<Atom>>> binaryLowerBounds;
    private Map<Reference, Set<Pair<Atom>>> binaryUpperBounds;
    private Map<Reference, Set<Pair<Atom>>> binaryExactBounds;

    private Set<CollectionStrategy> strategies;

    private int integersPerGap;
    private boolean shouldCreateComparisonReference;

    public BoundCollector(Instance instance, TypeSystem typeSystem) {
        this(instance, typeSystem, Collections.emptySet());
    }

    public BoundCollector(Instance instance, TypeSystem typeSystem, Set<CollectionStrategy> strategies) {
        this.instance = instance;
        this.typeSystem = typeSystem;
        this.strategies = strategies;
        atomMap = new HashMap<>();
        unaryLowerBounds = new HashMap<>();
        unaryUpperBounds = new HashMap<>();
        unaryExactBounds = new HashMap<>();
        binaryLowerBounds = new HashMap<>();
        binaryUpperBounds = new HashMap<>();
        binaryExactBounds = new HashMap<>();

        scopes = new HashMap<>();

        typeSystem.getAllTypes().stream()
                .filter(t -> t instanceof BasicType || t instanceof GenericTypeTemplate)
                .forEach(t -> {
                    if (t.getElement() instanceof Class) {
                        Class aClass = (Class) t.getElement();
                        if (aClass.hasScope()) {
                            scopes.put(t, Pair.of(aClass.getLowerScope(), aClass.getUpperScope()));
                        }
                    }
                });
    }

    public void collect() {
        collectUnariesFromInstance();
        collectBinariesFromInstance();

        collectSingletonStrings();
        collectSingletonBooleans();
        collectClassBounds();

        detectIfComparisonUsed();

        typeSystem.removeUnnecesaryInheritances();

        createBounds();
    }

    private void detectIfComparisonUsed() {
        Type intType = typeSystem.getPrimitiveType("EInt");
        if (intType == null)
            return;
        if (typeSystem.getReference(TypeCollector.ltReferenceName, intType) != null ||
                typeSystem.getReference(TypeCollector.lteReferenceName, intType) != null ||
                typeSystem.getReference(TypeCollector.gtReferenceName, intType) != null ||
                typeSystem.getReference(TypeCollector.gteReferenceName, intType) != null) {
            shouldCreateComparisonReference = true;

            Set<Atom> unaryIntegers = unaryLowerBounds.computeIfAbsent(intType, e -> new HashSet<>());
            Map<String, Atom> atoms = atomMap.getOrDefault(intType, Collections.emptyMap());
            instance.getAllOwnedElements(IntExpression.IntConstant.class, true).stream()
                    .map(Element::getLabel).distinct().forEach(number -> {
                        if (!atoms.containsKey(number))
                            unaryIntegers.add(new Atom(number, Atom.AtomType.INTEGER));
            });

            integersPerGap = typeSystem.getAllBasicReferences().stream()
                    .filter(r -> r.getReferencedType().equals(intType) && !r.getOwnerType().equals(intType))
                    .map(r -> Math.max(
                            getUpperScope(r.getOwnerType()) - binaryLowerBounds.getOrDefault(r, Collections.emptySet()).size()
                            , unaryLowerBounds.getOrDefault(r.getOwnerType(), Collections.emptySet()).size() - binaryLowerBounds.getOrDefault(r, Collections.emptySet()).size()))
                    .filter(i -> i > 0)
                    .reduce((a, b) -> a * b)
                    .orElse(0);
        }
        else {
            shouldCreateComparisonReference = false;
        }
    }

    public void createBounds() {

        typeSystem.getAllTypes().forEach(type -> {
            unaryLowerBounds.computeIfAbsent(type, t -> new HashSet<>());
        });

        typeSystem.getRealReferences().forEach(reference -> {
            binaryLowerBounds.computeIfAbsent(reference, r -> new HashSet<>());
        });

        unaryExactBounds.forEach((type, atoms) -> {
            unaryLowerBounds.computeIfAbsent(type, e -> new HashSet<>()).addAll(atoms);
        });

        binaryExactBounds.forEach((ref, pairs) -> {
            binaryLowerBounds.computeIfAbsent(ref, e -> new HashSet<>()).addAll(pairs);
        });

        unaryLowerBounds.forEach((type, atoms) -> {
            unaryUpperBounds.computeIfAbsent(type, e -> new HashSet<>()).addAll(atoms);
        });

        binaryLowerBounds.forEach((ref, pairs) -> {
            binaryUpperBounds.computeIfAbsent(ref, e -> new HashSet<>()).addAll(pairs);
        });

        UnaryBoundsCreator.create(this);
        BinaryBoundsCreator.create(this);

        unaryLowerBounds.forEach((type, atoms) -> {
            unaryUpperBounds.computeIfAbsent(type, e -> new HashSet<>()).addAll(atoms);
        });

        binaryLowerBounds.forEach((ref, pairs) -> {
            binaryUpperBounds.computeIfAbsent(ref, e -> new HashSet<>()).addAll(pairs);
        });
    }

    public static String getAtomName(Element<?> object) {
        return object.getLabel() + object.getStart();
    }

    // call it after specifying the lower bounds.
    private void collectClassBounds() {
        Type classType = typeSystem.getPrimitiveType("Class");
        if (classType == null)
            return;

        Reference typeRef = typeSystem.getReference(TypeCollector.typeReferenceName, typeSystem.OBJECT);
        Reference extendsRef = typeSystem.getReference(TypeCollector.subClassReferenceName, classType);
        Reference superRef = typeSystem.getReference(TypeCollector.superClassReferenceName, classType);

        for (Type ctype: classType.getSubTypes()) {
            ParameterParser pp = new ParameterParser(ctype.getName());
            Atom atom = new Atom(pp.getParameters().get(0), Atom.AtomType.CLASS);

            unaryExactBounds.computeIfAbsent(ctype, e -> new HashSet<>()).add(atom);
            unaryExactBounds.computeIfAbsent(classType, e -> new HashSet<>()).add(atom);
        }

        for (Type ctype: classType.getSubTypes()) {
            ParameterParser pp = new ParameterParser(ctype.getName());
            Type type = typeSystem.getType(pp.getParameters().get(0));

            for (Type supType: type.getAllSuperTypes()) {
                Type csupType = typeSystem.getType("Class<" + supType.getName() + ">");
                if (csupType != null) {
                    unaryExactBounds.getOrDefault(csupType, Collections.emptySet()).forEach(superAtom -> {
                        unaryExactBounds.getOrDefault(ctype, Collections.emptySet()).forEach(subAtom -> {
                            binaryExactBounds.computeIfAbsent(extendsRef, e -> new HashSet<>()).add(Pair.of(superAtom, subAtom));
                            binaryExactBounds.computeIfAbsent(superRef, e -> new HashSet<>()).add(Pair.of(subAtom, superAtom));
                        });
                    });
                }
            }
        }

        for (Type ctype: classType.getSubTypes()) {

            ParameterParser pp = new ParameterParser(ctype.getName());
            Type type = typeSystem.getType(pp.getParameters().get(0));

            if (unaryExactBounds.containsKey(type)) {
                unaryExactBounds.getOrDefault(ctype, Collections.emptySet()).forEach(classAtom -> {
                    unaryExactBounds.get(type).forEach(typeAtom -> {
                        binaryLowerBounds.computeIfAbsent(typeRef, e -> new HashSet<>())
                                .add(Pair.of(typeAtom, classAtom));
                        binaryUpperBounds.computeIfAbsent(typeRef, e -> new HashSet<>())
                                .add(Pair.of(typeAtom, classAtom));
                    });
                });
            }
            else {
                unaryExactBounds.getOrDefault(ctype, Collections.emptySet()).forEach(classAtom -> {
                    unaryLowerBounds.getOrDefault(type, Collections.emptySet()).forEach(typeAtom -> {
                        binaryLowerBounds.computeIfAbsent(typeRef, e -> new HashSet<>())
                                .add(Pair.of(typeAtom, classAtom));
                    });
                });
            }
        }
    }

    private void collectUnariesFromInstance() {
        instance.getAllOwnedElements(StringValue.class, false).forEach(stringValue -> {
            String label = stringValue.getLabel();

            // Pass empty strings
            if (label.length() < 3)
                return;

            // Get rid of double quotes
            label = label.substring(1, label.length() - 1);

            Type type = typeSystem.getType("EString");

            if (type != null && !atomMap.getOrDefault(type, Collections.emptyMap()).containsKey(label)) {
                Atom atom = new Atom(label, Atom.AtomType.STRING);
                atom.setObject(stringValue);
                unaryLowerBounds.computeIfAbsent(type, f -> new HashSet<>()).add(atom);
                atomMap.computeIfAbsent(type, e -> new HashMap<>()).put(label, atom);
            }
        });

        instance.getAllOwnedElements(IntegerValue.class, false).forEach(integerValue -> {
            String label = integerValue.getLabel();

            if (label.equals("0"))
                return;

            Type type = typeSystem.getType("EInt");

            if (type != null && !atomMap.getOrDefault(type, Collections.emptyMap()).containsKey(label)) {
                Atom atom = new Atom(label, Atom.AtomType.INTEGER);
                atom.setObject(integerValue);
                unaryLowerBounds.computeIfAbsent(type, f -> new HashSet<>()).add(atom);
                atomMap.computeIfAbsent(type, e -> new HashMap<>()).put(label, atom);
            }
        });

        instance.getAllOwnedElements(RealValue.class, false).forEach(realValue -> {
            String label = realValue.getLabel();

            Type type = typeSystem.getType("EBigDecimal");

            if (type != null && !atomMap.getOrDefault(type, Collections.emptyMap()).containsKey(label)) {
                Atom atom = new Atom(label, Atom.AtomType.BIG_DECIMAL);
                atom.setObject(realValue);
                unaryLowerBounds.computeIfAbsent(type, f -> new HashSet<>()).add(atom);
                atomMap.computeIfAbsent(type, e -> new HashMap<>()).put(label, atom);
            }
        });

        instance.getAllOwnedElements(EnumLiteral.class, false).forEach(enumLiteral -> {
            Type enumType = null;

            Enum owner = enumLiteral.getOwner(Enum.class);
            if (owner != null)
                enumType = typeSystem.getType(owner.getLabel());

            if (enumType != null) {
                Type literalType = typeSystem.createPrimitiveType(enumLiteral.getLabel(), Atom.AtomType.ENUM);
                literalType.setElement(enumLiteral);

                enumType.addSubType(literalType);

                Atom atom = new Atom(/*enumType.getName() + "::" + */literalType.getName(), Atom.AtomType.ENUM);
                atom.setObject(enumLiteral);

                unaryExactBounds.computeIfAbsent(literalType, t -> new HashSet<>()).add(atom);
                unaryExactBounds.computeIfAbsent(enumType, t -> new HashSet<>()).add(atom);

                atomMap.computeIfAbsent(enumType, e -> new HashMap<>()).put(atom.getName(), atom);
                atomMap.computeIfAbsent(literalType, e -> new HashMap<>()).put(atom.getName(), atom);
            }
        });

        instance.getAllOwnedElements(Object.class, false).forEach(object -> {
            if (strategies.stream().anyMatch(s -> !s.isValid(object)))
                return;

            Type type = typeSystem.getType(object.getClassifier().getSegment());

            if (type != null) {
                Atom atom = new Atom(getAtomName(object), Atom.AtomType.OBJECT);
                atom.setObject(object);
                unaryLowerBounds.computeIfAbsent(type, f -> new HashSet<>()).add(atom);
                atomMap.computeIfAbsent(type, e -> new HashMap<>()).put(atom.getName(), atom);
            }

            if (object.getContext().id != null) {
                String id = object.getContext().id.getText();
                Type idType = typeSystem.getType("EInt");

                if (idType != null) {
                    Atom atom = new Atom(id, Atom.AtomType.INTEGER);
                    atom.setObject(object.getContext().id.current);
                    unaryLowerBounds.computeIfAbsent(idType, f -> new HashSet<>()).add(atom);
                    atomMap.computeIfAbsent(idType, e -> new HashMap<>()).put(atom.getName(), atom);
                }
            }
        });

        if (typeSystem.getType("EBoolean") != null) {
            Type type = typeSystem.getType("EBoolean");

            Atom atomTrue = new Atom("true", Atom.AtomType.BOOLEAN);
            Atom atomFalse = new Atom("false", Atom.AtomType.BOOLEAN);

            unaryExactBounds.computeIfAbsent(type, f -> new HashSet<>()).add(atomTrue);
            unaryExactBounds.computeIfAbsent(type, f -> new HashSet<>()).add(atomFalse);
            atomMap.computeIfAbsent(type, e -> new HashMap<>()).put("true", atomTrue);
            atomMap.computeIfAbsent(type, e -> new HashMap<>()).put("false", atomFalse);
        }
    }

    private void collectBinariesFromInstance() {
        instance.getAllOwnedElements(Slot.class, true).forEach(slot -> {
            StructuralFeature sf = slot.getDefiningFeature();
            if (sf == null)
                return;

            if (strategies.stream().anyMatch(s -> !s.isValid(sf)))
                return;

            Reference reference = typeSystem.getReference(sf.getLabel(), typeSystem.getType(((Class) sf.getOwner()).getSegment()));

            if (reference == null)
                return;

            if (reference.getQualifiers().stream().anyMatch(t -> t.getText().equals("derived")))
                return;

            Type sourceType = typeSystem.getType(((Object) slot.getOwner()).getClassifier().getSegment());
            String sourceAtom = getAtomName(slot.getOwner());
            Atom atom1 = atomMap.getOrDefault(sourceType, Collections.emptyMap()).getOrDefault(sourceAtom, null);

            slot.getOwnedElements(Object.class).forEach(e -> {
                Type targetType = typeSystem.getType(e.getClassifier().getSegment());
                String targetAtom = getAtomName(e);
                Atom atom2 = atomMap.getOrDefault(targetType, Collections.emptyMap()).getOrDefault(targetAtom, null);

                if (atom2 != null)
                    binaryLowerBounds.computeIfAbsent(reference, r -> new HashSet<>()).add(Pair.of(atom1, atom2));
            });

            slot.getOwnedElements(ObjectValue.class).forEach(e -> {
                Type targetType = typeSystem.getType(e.getObject().getClassifier().getSegment());
                String targetAtom = getAtomName(e.getObject());
                Atom atom2 = atomMap.getOrDefault(targetType, Collections.emptyMap()).getOrDefault(targetAtom, null);

                if (atom2 != null)
                    binaryLowerBounds.computeIfAbsent(reference, r -> new HashSet<>()).add(Pair.of(atom1, atom2));
            });

            slot.getOwnedElements(BooleanValue.class).forEach(e -> {
                Type targetType = typeSystem.getType("EBoolean");
                String targetAtom = e.getLabel();
                Atom atom2 = atomMap.getOrDefault(targetType, Collections.emptyMap()).getOrDefault(targetAtom, null);

                if (atom2 != null)
                    binaryLowerBounds.computeIfAbsent(reference, r -> new HashSet<>()).add(Pair.of(atom1, atom2));
            });

            slot.getOwnedElements(IntegerValue.class).forEach(e -> {
                Type targetType = typeSystem.getType("EInt");
                String targetAtom = e.getLabel();
                Atom atom2 = atomMap.getOrDefault(targetType, Collections.emptyMap()).getOrDefault(targetAtom, null);

                if (atom2 != null)
                    binaryLowerBounds.computeIfAbsent(reference, r -> new HashSet<>()).add(Pair.of(atom1, atom2));
            });

            slot.getOwnedElements(RealValue.class).forEach(e -> {
                Type targetType = typeSystem.getType("EBigDecimal");
                String targetAtom = e.getLabel();
                Atom atom2 = atomMap.getOrDefault(targetType, Collections.emptyMap()).getOrDefault(targetAtom, null);

                if (atom2 != null)
                    binaryLowerBounds.computeIfAbsent(reference, r -> new HashSet<>()).add(Pair.of(atom1, atom2));
            });

            slot.getOwnedElements(StringValue.class).forEach(e -> {
                Type targetType = typeSystem.getType("EString");
                String targetAtom = e.getLabel().substring(1, e.getLabel().length() - 1);
                Atom atom2 = atomMap.getOrDefault(targetType, Collections.emptyMap()).getOrDefault(targetAtom, null);

                if (atom2 != null)
                    binaryLowerBounds.computeIfAbsent(reference, r -> new HashSet<>()).add(Pair.of(atom1, atom2));
            });
        });
    }

    private void collectSingletonStrings() {
        instance.getAllOwnedElements(Expression.Relation.class, false).forEach(relation -> {
            String text = relation.getContext().getText();

            if (relation.getContext().singleton() != null) {

                if (text.length() >= 2 && text.startsWith("\"") && text.endsWith("\"")) {

                    Type eString = typeSystem.getType("EString");

                    if (eString != null) {

                        Type type = typeSystem.createPrimitiveType(text, Atom.AtomType.STRING);
                        if (type != null) {

                            eString.addSubType(type);

                            // Get rid of double quotes
                            String name = text.substring(1, text.length() - 1);

                            Atom atom = atomMap.computeIfAbsent(eString, e -> new HashMap<>())
                                    .computeIfAbsent(name, e -> new Atom(name, Atom.AtomType.STRING));

                            unaryLowerBounds.computeIfAbsent(eString, f -> new HashSet<>()).add(atom);
                            unaryExactBounds.computeIfAbsent(type, f -> new HashSet<>()).add(atom);
                            atomMap.computeIfAbsent(type, e -> new HashMap<>()).put(name, atom);
                        }
                    }
                }
            }
        });
    }

    private void collectSingletonBooleans() {
        if (instance.getAllOwnedElements(Expression.Relation.class, false).stream()
                .anyMatch(r -> r.getContext().getText().equals("True"))) {
            Type type = typeSystem.createPrimitiveType("True", Atom.AtomType.BOOLEAN);
            Type eBoolean = typeSystem.getType("EBoolean");
            if (eBoolean != null) {
                eBoolean.addSubType(type);

                Atom atom = atomMap.computeIfAbsent(eBoolean, e -> new HashMap<>())
                        .computeIfAbsent("true", e -> new Atom("true", Atom.AtomType.BOOLEAN));

                unaryExactBounds.computeIfAbsent(type, e -> new HashSet<>()).add(atom);
                atomMap.computeIfAbsent(type, e -> new HashMap<>()).put("true", atom);
            }
        }

        if (instance.getAllOwnedElements(Expression.Relation.class, false).stream()
                .anyMatch(r -> r.getContext().getText().equals("False"))) {
            Type type = typeSystem.createPrimitiveType("False", Atom.AtomType.BOOLEAN);
            Type eBoolean = typeSystem.getType("EBoolean");
            if (eBoolean != null) {
                eBoolean.addSubType(type);

                Atom atom = atomMap.computeIfAbsent(eBoolean, e -> new HashMap<>())
                        .computeIfAbsent("false", e -> new Atom("false", Atom.AtomType.BOOLEAN));

                unaryExactBounds.computeIfAbsent(type, e -> new HashSet<>()).add(atom);
                atomMap.computeIfAbsent(type, e -> new HashMap<>()).put("false", atom);
            }
        }
    }

    public boolean hasScope(Type type) {
        return scopes.containsKey(type);
    }

    public int getLowerScope(Type type) {
        return scopes.getOrDefault(type, Pair.of(0, 0)).getFirst();
    }

    public int getUpperScope(Type type) {
        return scopes.getOrDefault(type, Pair.of(0, 0)).getSecond();
    }

    public TypeSystem getTypeSystem() {
        return typeSystem;
    }

    public Map<Type, Set<Atom>> getUnaryLowerBounds() {
        return unaryLowerBounds;
    }

    public Map<Type, Set<Atom>> getUnaryUpperBounds() {
        return unaryUpperBounds;
    }

    public Map<Reference, Set<Pair<Atom>>> getBinaryLowerBounds() {
        return binaryLowerBounds;
    }

    public Map<Reference, Set<Pair<Atom>>> getBinaryUpperBounds() {
        return binaryUpperBounds;
    }

    public Set<Atom> getAtoms() {
        return unaryUpperBounds.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
    }

    public int getIntegersPerGap() {
        return integersPerGap;
    }

    public boolean shouldCreateComparisonReference() {
        return shouldCreateComparisonReference;
    }

    public void addAtoms(Map<Type, Set<Atom>> atoms) {
        atoms.forEach((type, atomSet) -> {
            getUnaryLowerBounds().computeIfAbsent(type, e -> new HashSet<>()).addAll(atomSet);
        });
    }

    public void addReferences(Map<Reference, Set<Pair<Atom>>> references) {
        references.forEach((reference, pairSet) -> {
            getBinaryLowerBounds().computeIfAbsent(reference, e -> new HashSet<>()).addAll(pairSet);
        });
    }
}
