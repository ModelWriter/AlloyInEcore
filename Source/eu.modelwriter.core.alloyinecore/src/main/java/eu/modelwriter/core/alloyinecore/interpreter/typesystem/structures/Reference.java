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
import eu.modelwriter.core.alloyinecore.structure.model.TypedElement;
import kodkod.ast.Relation;
import org.antlr.v4.runtime.Token;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.HashSet;
import java.util.Set;

public abstract class Reference {

    private String name;
    private Type ownerType;
    private StructuralFeature structuralFeature = null;
    private Set<Token> qualifiers;

    public Reference(String name, Type ownerType) {
        this.name = name;
        this.ownerType = ownerType;

        ownerType.getReferences().add(this);

        qualifiers = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return createName(ownerType, name);
    }

    public void setStructuralFeature(StructuralFeature structuralFeature) {
        this.structuralFeature = structuralFeature;

        qualifiers.clear();
        if (structuralFeature instanceof eu.modelwriter.core.alloyinecore.structure.model.Reference) {
            eu.modelwriter.core.alloyinecore.structure.model.Reference ref =
                    (eu.modelwriter.core.alloyinecore.structure.model.Reference) structuralFeature;
            qualifiers = new HashSet<>(ref.getContext().qualifier);
        }
        else if (structuralFeature instanceof Attribute) {
            Attribute ref = (Attribute) structuralFeature;
            qualifiers = new HashSet<>(ref.getContext().qualifier);
        }
    }

    public StructuralFeature getStructuralFeature() {
        return structuralFeature;
    }

    public Set<Token> getQualifiers() {
        return qualifiers;
    }

    public Type getOwnerType() {
        return ownerType;
    }

    public static String createName(Type ownerType, String name) {
        return ownerType.getMainName() + "::" + name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
