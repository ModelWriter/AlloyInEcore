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

package eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures;

import eu.modelwriter.core.alloyinecore.structure.model.Attribute;
import eu.modelwriter.core.alloyinecore.structure.model.StructuralFeature;
import org.antlr.v4.runtime.Token;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericReference extends Reference {

    private TypeParameter referencedTypeParameter;
    private Set<GenericReferenceImpl> subReferences;

    public GenericReference(String name, Type ownerType, TypeParameter referencedTypeParameter) {
        super(name, ownerType);
        this.referencedTypeParameter = referencedTypeParameter;
        subReferences = new HashSet<>();
    }

    public TypeParameter getReferencedTypeParameter() {
        return referencedTypeParameter;
    }

    public void setReferencedTypeParameter(TypeParameter referencedTypeParameter) {
        this.referencedTypeParameter = referencedTypeParameter;
    }

    public Set<GenericReferenceImpl> getSubReferences() {
        return subReferences;
    }

    public void setSubReferences(Set<GenericReferenceImpl> subReferences) {
        this.subReferences = subReferences;
    }

    public void addSubReference(GenericReferenceImpl reference) {
        subReferences.add(reference);
    }
}
