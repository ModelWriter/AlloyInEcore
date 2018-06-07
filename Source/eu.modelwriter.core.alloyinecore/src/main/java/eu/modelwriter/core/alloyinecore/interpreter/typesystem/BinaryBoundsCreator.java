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

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by harun on 2/2/18.
 */
public class BinaryBoundsCreator {

    private TypeSystem typeSystem;
    private BoundCollector boundCollector;

    private BinaryBoundsCreator(BoundCollector boundCollector) {
        this.typeSystem = boundCollector.getTypeSystem();
        this.boundCollector = boundCollector;
    }

    public static void create(BoundCollector boundCollector) {
        BinaryBoundsCreator bbc = new BinaryBoundsCreator(boundCollector);

        bbc.createBounds();
    }

    private void createBounds() {

        BasicReference typeReference = typeSystem.getBasicReference(TypeCollector.typeReferenceName, typeSystem.OBJECT);
        if (typeReference != null) {
            Set<Pair<Atom>> pairs = new HashSet<>();

            boundCollector.getUnaryLowerBounds().forEach(((type, atomSet) -> {
                atomSet.forEach(sourceAtom -> {
                    boundCollector.getUnaryLowerBounds().getOrDefault(typeSystem.getType("Class<" + type.getName() + ">"), Collections.emptySet())
                            .forEach(targetAtom -> {
                                pairs.add(Pair.of(sourceAtom, targetAtom));
                            });
                });
            }));

            boundCollector.getBinaryLowerBounds().put(typeReference, new HashSet<>(pairs));

            boundCollector.getUnaryUpperBounds().forEach(((type, atomSet) -> {
                atomSet.forEach(sourceAtom -> {
                    boundCollector.getUnaryUpperBounds().getOrDefault(typeSystem.getType("Class<" + type.getName() + ">"), Collections.emptySet())
                            .forEach(targetAtom -> {
                                pairs.add(Pair.of(sourceAtom, targetAtom));
                            });
                });
            }));

            boundCollector.getBinaryUpperBounds().put(typeReference, new HashSet<>(pairs));
        }

        // Create comparison references' bounds
        if (boundCollector.shouldCreateComparisonReference()) {
            PrimitiveType eIntType = typeSystem.getPrimitiveType("EInt");
            if (eIntType != null) {

                List<Atom> sortedAtoms = boundCollector.getUnaryUpperBounds()
                        .getOrDefault(eIntType, Collections.emptySet())
                        .stream()
                        .sorted(Comparator.comparingInt(a -> Integer.parseInt(a.getName())))
                        .collect(Collectors.toList());

                BasicReference reference;

                // LT
                reference = typeSystem.getBasicReference(TypeCollector.ltReferenceName, eIntType);
                if (reference != null) {
                    Set<Pair<Atom>> pairs = boundCollector.getBinaryLowerBounds()
                            .computeIfAbsent(reference, r -> new HashSet<>());

                    for (int i = 0; i < sortedAtoms.size() - 1; i++) {
                        for (int j = i + 1; j < sortedAtoms.size(); j++) {
                            pairs.add(Pair.of(sortedAtoms.get(i), sortedAtoms.get(j)));
                        }
                    }

                    boundCollector.getBinaryUpperBounds().put(reference, pairs);
                }

                // LTE
                reference = typeSystem.getBasicReference(TypeCollector.lteReferenceName, eIntType);
                if (reference != null) {
                    Set<Pair<Atom>> pairs = boundCollector.getBinaryLowerBounds()
                            .computeIfAbsent(reference, r -> new HashSet<>());

                    for (int i = 0; i < sortedAtoms.size() - 1; i++) {
                        for (int j = i + 1; j < sortedAtoms.size(); j++) {
                            pairs.add(Pair.of(sortedAtoms.get(i), sortedAtoms.get(j)));
                        }
                        pairs.add(Pair.of(sortedAtoms.get(i), sortedAtoms.get(i)));
                    }

                    boundCollector.getBinaryUpperBounds().put(reference, pairs);
                }

                // GT
                reference = typeSystem.getBasicReference(TypeCollector.gtReferenceName, eIntType);
                if (reference != null) {
                    Set<Pair<Atom>> pairs = boundCollector.getBinaryLowerBounds()
                            .computeIfAbsent(reference, r -> new HashSet<>());

                    for (int i = 0; i < sortedAtoms.size() - 1; i++) {
                        for (int j = i + 1; j < sortedAtoms.size(); j++) {
                            pairs.add(Pair.of(sortedAtoms.get(j), sortedAtoms.get(i)));
                        }
                    }

                    boundCollector.getBinaryUpperBounds().put(reference, pairs);
                }

                // GTE
                reference = typeSystem.getBasicReference(TypeCollector.gteReferenceName, eIntType);
                if (reference != null) {
                    Set<Pair<Atom>> pairs = boundCollector.getBinaryLowerBounds()
                            .computeIfAbsent(reference, r -> new HashSet<>());

                    for (int i = 0; i < sortedAtoms.size() - 1; i++) {
                        for (int j = i + 1; j < sortedAtoms.size(); j++) {
                            pairs.add(Pair.of(sortedAtoms.get(j), sortedAtoms.get(i)));
                        }
                        pairs.add(Pair.of(sortedAtoms.get(i), sortedAtoms.get(i)));
                    }

                    boundCollector.getBinaryUpperBounds().put(reference, pairs);
                }
            }
        }

        typeSystem.getAllBasicReferences().stream()
                .filter(r -> !(r.getOwnerType() instanceof PrimitiveType) && r.getOwnerType() != typeSystem.OBJECT).forEach(reference -> {
            Set<Pair<Atom>> pairs = new HashSet<>();

            boundCollector.getUnaryUpperBounds().getOrDefault(reference.getOwnerType(), Collections.emptySet())
                    .forEach(sourceAtom -> {
                        boundCollector.getUnaryUpperBounds().getOrDefault(reference.getReferencedType(), Collections.emptySet())
                                .forEach(targetAtom -> {
                                    pairs.add(Pair.of(sourceAtom, targetAtom));
                                });
                    });

            boundCollector.getBinaryUpperBounds().put(reference, pairs);
        });

        typeSystem.getAllGenericReferenceImpls().forEach(reference -> {
            Set<Pair<Atom>> pairs = new HashSet<>();

            boundCollector.getUnaryUpperBounds().getOrDefault(reference.getOwnerType(), Collections.emptySet())
                    .forEach(sourceAtom -> {
                        boundCollector.getUnaryUpperBounds().getOrDefault(reference.getReferencedType(), Collections.emptySet())
                                .forEach(targetAtom -> {
                                    pairs.add(Pair.of(sourceAtom, targetAtom));
                                });
                    });

            boundCollector.getBinaryUpperBounds().computeIfAbsent(reference.getGenericReference(), r -> new HashSet<>())
                    .addAll(pairs);
        });
    }

}
