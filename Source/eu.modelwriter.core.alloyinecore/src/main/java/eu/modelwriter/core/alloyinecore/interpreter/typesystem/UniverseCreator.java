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

import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.Atom;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.Pair;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.Reference;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.Type;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.model.Attribute;
import eu.modelwriter.core.alloyinecore.structure.model.StructuralFeature;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Created by harun on 1/30/18.
 */
public class UniverseCreator {

    private TypeSystem typeSystem;
    private BoundCollector boundCollector;

    public UniverseCreator(Instance instance) {
        this.typeSystem = new TypeSystem(instance, Collections.singleton(new GhostCollectionStrategy()));

        boundCollector = new BoundCollector(instance, typeSystem, Collections.singleton(new GhostCollectionStrategy()));
        boundCollector.collect();
    }

    public BoundCollector getBoundCollector() {
        return boundCollector;
    }

    public TypeSystem getTypeSystem() {
        return typeSystem;
    }

    public Map<Type, Set<Atom>> getAtoms () {
        return boundCollector.getUnaryLowerBounds();
    }

    public Map<Reference, Set<Pair<Atom>>> getReferences () {
        return boundCollector.getBinaryLowerBounds();
    }

    /**
     * Structural features with "ghost" qualifiers are invalid.
     * We ignore them.
     */
    class GhostCollectionStrategy extends CollectionStrategy {

        @Override
        public boolean isValid(StructuralFeature sf) {

            if (sf instanceof Attribute) {
                return ((Attribute) sf).getContext().qualifier.stream().noneMatch(t -> t.getText().equals("ghost"));
            }
            if (sf instanceof eu.modelwriter.core.alloyinecore.structure.model.Reference) {
                return ((eu.modelwriter.core.alloyinecore.structure.model.Reference) sf).getContext().qualifier.stream()
                        .noneMatch(t -> t.getText().equals("ghost"));
            }

            return super.isValid(sf);
        }
    }
}
