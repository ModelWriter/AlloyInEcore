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

import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.*;
import eu.modelwriter.core.alloyinecore.structure.model.GenericType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by harun on 2/2/18.
 */
public class UnaryBoundsCreator {

    private TypeSystem typeSystem;
    private BoundCollector boundCollector;

    private Set<Atom> atomsToIgnore;
    private Set<Atom> originalAtoms;
    private Map<Type, Boolean> visited;

    private UnaryBoundsCreator(BoundCollector boundCollector) {
        this.typeSystem = boundCollector.getTypeSystem();
        this.boundCollector = boundCollector;

        atomsToIgnore = new HashSet<>();
        originalAtoms = boundCollector.getUnaryLowerBounds().values().stream()
                .flatMap(Collection::stream)
                .filter(a -> a.getType().equals(Atom.AtomType.OBJECT))
                .collect(Collectors.toSet());
        visited = new HashMap<>();
    }

    public static void create(BoundCollector boundCollector) {
        UnaryBoundsCreator ubc = new UnaryBoundsCreator(boundCollector);

        ubc.typeSystem.getRootTypes().stream().filter(t -> t instanceof BasicType || t instanceof GenericTypeTemplate).forEach(ubc::createObjectAtoms);
        ubc.typeSystem.getAllTypes().stream().filter(t -> t.getSuperTypes().size() > 1).forEach(type -> {
            type.getAllSuperTypes().forEach(e -> boundCollector.getUnaryUpperBounds()
                            .computeIfAbsent(e, t -> new HashSet<>())
                            .addAll(boundCollector.getUnaryUpperBounds().get(type)));
        });

        /*ubc.boundCollector.getUnaryLowerBounds().put(ubc.typeSystem.OBJECT, ubc.typeSystem.getRootTypes().stream()
                .filter(t -> !(t instanceof PrimitiveType) || !((PrimitiveType) t).getAtomType().equals(Atom.AtomType.CLASS))
                .map(t -> ubc.boundCollector.getUnaryLowerBounds().getOrDefault(t, Collections.emptySet()))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));
        ubc.boundCollector.getUnaryUpperBounds().put(ubc.typeSystem.OBJECT, ubc.typeSystem.getRootTypes().stream()
                .filter(t -> !(t instanceof PrimitiveType) || !((PrimitiveType) t).getAtomType().equals(Atom.AtomType.CLASS))
                .map(t -> ubc.boundCollector.getUnaryUpperBounds().getOrDefault(t, Collections.emptySet()))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));*/

        ubc.createPrimitiveTypeAtoms();
    }

    private void createPrimitiveTypeAtoms() {

        // Create and add integers if gt, gte, lt, lte used.
        int integerPerGap = boundCollector.getIntegersPerGap();
        if (integerPerGap > 0) {
            PrimitiveType pt = typeSystem.getPrimitiveType("EInt");

            List<Integer> integerList = boundCollector.getUnaryLowerBounds()
                    .getOrDefault(pt, Collections.emptySet()).stream()
                    .map(e -> Integer.parseInt(e.getName()))
                    .sorted()
                    .collect(Collectors.toList());

            List<Integer> newIntegers = new ArrayList<>();

            for (int i = 0; i < integerList.size(); i++) {
                if (i == 0) {
                    int number = integerList.get(i);
                    for (int j = 0; j < integerPerGap; j++) {
                        newIntegers.add(number - j - 1);
                    }
                }
                else if (i == integerList.size() - 1) {
                    int number = integerList.get(i);
                    for (int j = 0; j < integerPerGap; j++) {
                        newIntegers.add(number + j + 1);
                    }
                }
                else {
                    int downLimit = integerList.get(i);
                    int upLimit = integerList.get(i + 1);

                    int ipg = Math.min(upLimit - downLimit - 1, integerPerGap);
                    for (int j = 0; j < ipg; j++) {
                        newIntegers.add(downLimit + j + 1);
                    }
                }
            }

            boundCollector.getUnaryUpperBounds().computeIfAbsent(pt, p -> new HashSet<>()).addAll(
                    boundCollector.getUnaryLowerBounds()
                            .getOrDefault(pt, Collections.emptySet())
            );

            boundCollector.getUnaryUpperBounds().computeIfAbsent(pt, p -> new HashSet<>()).addAll(
                    newIntegers.stream()
                            .map(i -> new Atom(i + "", Atom.AtomType.INTEGER))
                            .collect(Collectors.toSet())
            );

        }

        // Get upper scope informations
        Map<PrimitiveType, Integer> primitiveUpperScopes = new HashMap<>();
        typeSystem.getAllPrimitiveTypes().forEach(primitiveType -> {
            typeSystem.getAllBasicReferences().stream()
                    .filter(ref -> ref.getReferencedType().equals(primitiveType)).forEach(ref -> {
                        Type ownerType = ref.getOwnerType();
                        primitiveUpperScopes.put(
                                primitiveType,
                                primitiveUpperScopes.computeIfAbsent(primitiveType, p -> 0)
                                        + boundCollector.getUpperScope(ownerType));
            });
        });

        primitiveUpperScopes.forEach(((primitiveType, upperScope) -> {
            Set<Atom> atoms = new HashSet<>();
            atoms.addAll(boundCollector.getUnaryLowerBounds().getOrDefault(primitiveType, Collections.emptySet()));

            int count = upperScope - atoms.size();
            if (count <= 0)
                return;

            switch (primitiveType.getAtomType()) {
                case STRING:
                    for (int i = 0; i < count; i++) {
                        String name = "String_" + i;
                        if (atoms.stream().anyMatch(a -> a.getName().equals(name)))
                            count++;
                        else
                            atoms.add(new Atom(name, Atom.AtomType.STRING));
                    }
                    break;
                case INTEGER:
                    for (int i = 0; i < count; i++) {
                        String name = "" + new Random().nextInt() % 10000;
                        if (atoms.stream().anyMatch(a -> a.getName().equals(name)))
                            count++;
                        else
                            atoms.add(new Atom(name, Atom.AtomType.INTEGER));
                    }
                    break;
                case BIG_INTEGER:
                    for (int i = 0; i < count; i++) {
                        String name = "" + new Random().nextInt() % 10000;
                        if (atoms.stream().anyMatch(a -> a.getName().equals(name)))
                            count++;
                        else
                            atoms.add(new Atom(name, Atom.AtomType.BIG_INTEGER));
                    }
                    break;
                case BIG_DECIMAL:
                    for (int i = 0; i < count; i++) {
                        String name = "" + new Random().nextFloat();
                        if (atoms.stream().anyMatch(a -> a.getName().equals(name)))
                            count++;
                        else
                            atoms.add(new Atom(name, Atom.AtomType.BIG_DECIMAL));
                    }
                    break;
            }

            boundCollector.getUnaryUpperBounds().computeIfAbsent(primitiveType, p -> new HashSet<>()).addAll(atoms);
        }));
    }

    private void createObjectAtoms(Type type) {
        if (visited.getOrDefault(type, false))
            return;
        visited.put(type, true);
        type.getSubTypes().forEach(this::createObjectAtoms);

        boundCollector.getUnaryLowerBounds().computeIfAbsent(type, t -> new HashSet<>())
                .addAll(type.getSubTypes().stream()
                        .filter(t -> t.getSuperTypes().stream().filter(x -> (x instanceof GenericTypeTemplate || x instanceof BasicType)).count() <= 1)
                        .flatMap(t -> boundCollector.getUnaryLowerBounds().getOrDefault(t, Collections.emptySet()).stream())
                        .collect(Collectors.toSet()));

        boundCollector.getUnaryUpperBounds().computeIfAbsent(type, t -> new HashSet<>())
                .addAll(type.getSubTypes().stream()
                        .filter(t -> t.getSuperTypes().stream().filter(x -> (x instanceof GenericTypeTemplate || x instanceof BasicType)).count() <= 1)
                        .flatMap(t -> boundCollector.getUnaryUpperBounds().getOrDefault(t, Collections.emptySet()).stream())
                        .collect(Collectors.toSet()));

        if (type.getSubTypes().stream().noneMatch(t -> (t instanceof GenericTypeTemplate || t instanceof BasicType) && t.getSuperTypes().size() > 1)) {
            Set<Atom> temp = new HashSet<>(boundCollector.getUnaryLowerBounds().get(type));
            temp.addAll(boundCollector.getUnaryUpperBounds().get(type));

            if (temp.size() <= boundCollector.getLowerScope(type)) {
                boundCollector.getUnaryLowerBounds().put(type, temp);

                if (boundCollector.getUnaryLowerBounds().get(type).size() < boundCollector.getLowerScope(type)) {
                    Set<Atom> newAtoms = createNewAtoms(type,
                            boundCollector.getUnaryLowerBounds().get(type).size(),
                            boundCollector.getLowerScope(type));
                    boundCollector.getUnaryLowerBounds().get(type).addAll(newAtoms);

                    type.getSubTypes().forEach(t -> addToUpper(t, newAtoms));
                }
            }
        }

        boundCollector.getUnaryUpperBounds().get(type).addAll(boundCollector.getUnaryLowerBounds().get(type));

        Set<Atom> newAtoms = new HashSet<>();
        if (boundCollector.getUnaryUpperBounds().get(type).size() < boundCollector.getUpperScope(type)) {
            newAtoms.addAll(createNewAtoms(type,
                    boundCollector.getUnaryUpperBounds().get(type).size(),
                    boundCollector.getUpperScope(type)));
            boundCollector.getUnaryUpperBounds().get(type).addAll(newAtoms);

            type.getSubTypes().forEach(t -> addToUpper(t, newAtoms));
        }

        if (type instanceof GenericTypeTemplate) {
            type.getSubTypes().forEach(t -> addToUpperOfGenerics(t, boundCollector.getUnaryLowerBounds().get(type)));
        }

        // type.getSubTypes().forEach(t -> addToUpper(t, type, boundCollector.getUnaryUpperBounds().get(type)));

        atomsToIgnore.addAll(boundCollector.getUnaryLowerBounds().get(type));
    }

    private void addToUpperOfGenerics(Type type, Set<Atom> atoms){
        if (!(type instanceof GenericTypeAbstractImpl || type instanceof GenericTypeImpl))
            return;
        if (boundCollector.hasScope(type))
            return;
        Set<Atom> atomsClone = new HashSet<>(atoms);
        atomsClone.removeAll(atomsToIgnore);

        if (atomsClone.isEmpty())
            return;

        boundCollector.getUnaryUpperBounds().computeIfAbsent(type, t -> new HashSet<>()).addAll(atomsClone);

        type.getSubTypes().forEach(subType -> addToUpperOfGenerics(subType, atomsClone));
    }

    private void addToUpper(Type type, Set<Atom> atoms){
        if (boundCollector.hasScope(type))
            return;
        Set<Atom> atomsClone = new HashSet<>(atoms);
        atomsClone.removeAll(atomsToIgnore);
        if (type instanceof BasicType)
            atomsClone.removeAll(originalAtoms);

        if (atomsClone.isEmpty())
            return;

        boundCollector.getUnaryUpperBounds().computeIfAbsent(type, t -> new HashSet<>()).addAll(atomsClone);

        type.getSubTypes().forEach(subType -> addToUpper(subType, atomsClone));
    }

    private Set<Atom> createNewAtoms(Type type, int curSize, int wantedSize) {
        Set<Atom> newAtoms = new HashSet<>();

        for (int i = curSize; i < wantedSize; i++) {
            Atom atom = new Atom(type.getName() + "_" + i, Atom.AtomType.OBJECT);
            atom.setObject(type.getElement());
            newAtoms.add(atom);
        }
        return newAtoms;
    }

}
