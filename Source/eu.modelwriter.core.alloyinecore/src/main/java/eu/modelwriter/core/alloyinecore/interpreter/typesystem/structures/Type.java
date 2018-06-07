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

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import kodkod.ast.Relation;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Type {

    private String name;
    private boolean abstract_;

    private Set<Type> subTypes;
    private Set<Type> superTypes;

    private Set<Reference> references;

    private Element element = null;

    protected Type(String name) {
        this.name = name;

        subTypes = new HashSet<>();
        superTypes = new HashSet<>();
        references = new HashSet<>();
    }

    protected Type(String name, boolean abstract_) {
        this(name);
        this.abstract_ = abstract_;
    }

    public String getMainName() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getFullName() { return name; }

    public Set<Type> getSubTypes() {
        return subTypes;
    }

    public Set<Type> getSuperTypes() {
        return superTypes;
    }

    public Set<Type> getAllSubTypes() {
        Set<Type> subs = new HashSet<>(subTypes);
        subs.addAll(subTypes.stream().flatMap(t -> t.getAllSubTypes().stream()).collect(Collectors.toSet()));
        return subs;
    }

    public Set<Type> getAllSuperTypes() {
        Set<Type> sups = new HashSet<>(superTypes);
        sups.addAll(superTypes.stream().flatMap(t -> t.getAllSuperTypes().stream()).collect(Collectors.toSet()));
        return sups;
    }

    public Set<Reference> getReferences() {
        return references;
    }

    public boolean isAbstract() {
        return abstract_;
    }

    public void setAbstract_(boolean abstract_) {
        this.abstract_ = abstract_;
    }

    public void setSubTypes(Set<Type> subTypes) {
        this.subTypes = subTypes;
    }

    public void setSuperTypes(Set<Type> superTypes) {
        this.superTypes = superTypes;
    }

    public void setReferences(Set<Reference> references) {
        this.references = references;
    }

    public void addReference(Reference reference) {
        this.references.add(reference);
    }

    public void addSuperType(Type superType) {
        if (this.equals(superType))
            return;
        if (getAllSubTypes().contains(superType))
            return;
        if (superType.getAllSuperTypes().contains(this))
            return;

        this.superTypes.add(superType);
        superType.getSubTypes().add(this);
    }

    public void addSubType(Type subType) {
        if (this.equals(subType))
            return;
        if (getAllSuperTypes().contains(subType))
            return;
        if (subType.getAllSubTypes().contains(this))
            return;

        this.subTypes.add(subType);
        subType.getSuperTypes().add(this);
    }

    public void removeUnnecesarySubTypes() {
        subTypes.removeIf(subType -> subTypes.stream()
                .flatMap(s -> s.getAllSubTypes().stream())
                .anyMatch(s -> s.equals(subType)));
    }

    public void removeUnnecesarySuperTypes() {
        superTypes.removeIf(superType -> superTypes.stream()
                .flatMap(s -> s.getAllSuperTypes().stream())
                .anyMatch(s -> s.equals(superType)));
    }

    @Override
    public String toString() {
        return getFullName();
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }
}
