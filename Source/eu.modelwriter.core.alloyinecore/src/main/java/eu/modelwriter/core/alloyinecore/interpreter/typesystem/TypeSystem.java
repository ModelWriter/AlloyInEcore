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

package eu.modelwriter.core.alloyinecore.interpreter.typesystem;

import eu.modelwriter.core.alloyinecore.interpreter.ParameterParser;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.*;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;

import java.util.*;
import java.util.stream.Collectors;

public class TypeSystem {

    public final BasicType OBJECT;

    Map<String, Type> typeMap;
    Map<String, Reference> referenceMap;

    public TypeSystem() {
        typeMap = new HashMap<>();
        referenceMap = new HashMap<>();
        OBJECT = new BasicType("_OBJECT_");
    }

    public TypeSystem(Instance instance) {
        this();

        TypeCollector typeCollector = new TypeCollector(instance, this);
        typeCollector.collect();

        GenericsCollector genericsCollector = new GenericsCollector(instance, this);
        genericsCollector.collect();
    }

    public TypeSystem(Instance instance, Set<CollectionStrategy> strategies) {
        this();

        TypeCollector typeCollector = new TypeCollector(instance, this, strategies);
        typeCollector.collect();

        GenericsCollector genericsCollector = new GenericsCollector(instance, this, strategies);
        genericsCollector.collect();
    }

    public Type getType(String name) {
        if (typeMap.containsKey(name))
            return typeMap.get(name);

        ParameterParser pp = new ParameterParser(name);

        if (pp.getTypeParameters().isEmpty())
            return null;

        return typeMap.getOrDefault(GenericTypeTemplate.createName(name, pp.getTypeParameters()), null);
    }

    public BasicType getBasicType(String name) {
        Type type = getType(name);
        if (type instanceof BasicType)
            return (BasicType) type;
        else
            return null;
    }

    public PrimitiveType getPrimitiveType(String name) {
        Type type = getType(name);
        if (type instanceof PrimitiveType)
            return (PrimitiveType) type;
        else
            return null;
    }

    public GenericTypeTemplate getGenericTypeTemplate(String name) {
        Type type = getType(name);
        if (type instanceof GenericTypeTemplate)
            return (GenericTypeTemplate) type;
        else
            return null;
    }

    public GenericTypeTemplate getGenericTypeTemplate(String name, List<TypeParameter> typeParameters) {
        return getGenericTypeTemplate(GenericTypeTemplate.createName(name, typeParameters));
    }

    public GenericTypeImpl getGenericTypeImpl(String name) {
        Type type = getType(name);
        if (type instanceof GenericTypeImpl)
            return (GenericTypeImpl) type;
        else
            return null;
    }

    public GenericTypeImpl getGenericTypeImpl(String mainName, List<Type> types) {
        GenericTypeTemplate gt = getGenericTypeTemplate(mainName);
        if (gt == null)
            return null;
        else
            return getGenericTypeImpl(GenericTypeImpl.createName(gt, types));
    }

    public GenericTypeAbstractImpl getGenericTypeAbstractImpl(String name) {
        Type type = getType(name);
        if (type instanceof GenericTypeAbstractImpl)
            return (GenericTypeAbstractImpl) type;
        else
            return null;
    }

    public GenericTypeAbstractImpl getGenericTypeAbstractImpl(String mainName, List<TypeParameter> typeParameters) {
        GenericTypeTemplate gt = getGenericTypeTemplate(mainName);
        if (gt == null)
            return null;
        else
            return getGenericTypeAbstractImpl(GenericTypeAbstractImpl.createName(gt.getMainName(), typeParameters));
    }

    public Reference getReference(String longName) {
        return referenceMap.getOrDefault(longName, null);
    }

    public Reference getReference(String shortName, Type ownerType) {
        return referenceMap.getOrDefault(ownerType.getMainName() + "::" + shortName, null);
    }

    public BasicReference getBasicReference(String shortName, Type ownerType) {
        Reference reference = referenceMap.getOrDefault(ownerType + "::" + shortName, null);
        return reference instanceof BasicReference ? (BasicReference) reference : null;
    }

    public GenericReference getGenericReference(String shortName, Type ownerType) {
        Reference reference = referenceMap.getOrDefault(ownerType + "::" + shortName, null);
        return reference instanceof GenericReference ? (GenericReference) reference : null;
    }

    public GenericReferenceImpl getGenericReferenceImpl(String shortName, Type ownerType) {
        Reference reference = referenceMap.getOrDefault(ownerType + "::" + shortName, null);
        return reference instanceof GenericReferenceImpl ? (GenericReferenceImpl) reference : null;
    }

    public BasicType createBasicType(String name, boolean abstract_) {
        Type type = typeMap.computeIfAbsent(name, n -> new BasicType(name, abstract_));
        type.addSuperType(OBJECT);
        return type instanceof BasicType ? (BasicType) type : null;
    }

    public PrimitiveType createPrimitiveType(String name, Atom.AtomType atomType) {
        Type type = typeMap.computeIfAbsent(name, n -> new PrimitiveType(name, atomType));
        type.addSuperType(OBJECT);
        return type instanceof PrimitiveType ? (PrimitiveType) type : null;
    }

    public GenericTypeTemplate createGenericTypeTemplate(String name, boolean abstract_, List<TypeParameter> typeParameters) {
        Type type = typeMap.computeIfAbsent(name, n -> new GenericTypeTemplate(name, abstract_, typeParameters));
        type.addSuperType(OBJECT);
        return type instanceof GenericTypeTemplate ? (GenericTypeTemplate) type : null;
    }

    public GenericTypeAbstractImpl createGenericTypeAbstractImpl(GenericTypeTemplate genericTypeTemplate, List<TypeParameter> typeParameters) {
        Type type =  typeMap.computeIfAbsent(
                GenericTypeAbstractImpl.createName(genericTypeTemplate.getMainName(), typeParameters),
                n -> new GenericTypeAbstractImpl(genericTypeTemplate, typeParameters));
        return type instanceof GenericTypeAbstractImpl ? (GenericTypeAbstractImpl) type : null;
    }

    public GenericTypeImpl createGenericTypeImpl(GenericTypeTemplate genericTypeTemplate, List<Type> types) {
        Type type = typeMap.computeIfAbsent(GenericTypeImpl.createName(genericTypeTemplate, types),
                n -> new GenericTypeImpl(genericTypeTemplate, genericTypeTemplate.isAbstractImpl(), types));
        return type instanceof GenericTypeImpl ? (GenericTypeImpl) type : null;
    }

    public BasicReference createBasicReference(String name, Type ownerType, Type referencedType) {
        String newName = Reference.createName(ownerType, name);
        if (referenceMap.containsKey(newName)) {
            if (referenceMap.get(newName) instanceof BasicReference)
                return (BasicReference) referenceMap.get(newName);
            else
                return null;
        }
        BasicReference ref = new BasicReference(name, ownerType, referencedType);
        addReference(ref);
        return ref;
    }

    public GenericReference createGenericReference(String name, Type ownerType, TypeParameter referencedTypeParameter) {
        String newName = Reference.createName(ownerType, name);
        if (referenceMap.containsKey(newName)) {
            if (referenceMap.get(newName) instanceof GenericReference)
                return (GenericReference) referenceMap.get(newName);
            else
                return null;
        }
        GenericReference ref = new GenericReference(name, ownerType, referencedTypeParameter);
        addReference(ref);
        return ref;
    }

    public GenericReferenceImpl createGenericReferenceImpl(String name, Type ownerType, Type referencedType) {
        String newName = GenericReferenceImpl.createName(ownerType, name, referencedType);
        if (referenceMap.containsKey(newName)) {
            if (referenceMap.get(newName) instanceof GenericReferenceImpl)
                return (GenericReferenceImpl) referenceMap.get(newName);
            else
                return null;
        }
        Reference gr = referenceMap.getOrDefault(Reference.createName(ownerType, name), null);
        if (gr instanceof GenericReference) {
            GenericReferenceImpl ref = new GenericReferenceImpl(ownerType, (GenericReference) gr, referencedType);
            addReference(ref);
            return ref;
        }
        else
            return null;

    }

    public void addType(Type type) {
        if (type == OBJECT)
            return;
        if (!typeMap.containsKey(type.getName())) {
            typeMap.put(type.getFullName(), type);
            type.getReferences().forEach(this::addReference);
        }
    }

    public void addReference(Reference sf) {
        if (!referenceMap.containsKey(sf.getFullName())) {
            referenceMap.put(sf.getFullName(), sf);
            addType(sf.getOwnerType());
            if (sf instanceof BasicReference)
                addType(((BasicReference) sf).getReferencedType());
            else if (sf instanceof GenericReferenceImpl)
                addType(((GenericReferenceImpl) sf).getReferencedType());
        }
    }

    public Collection<Type> getAllTypes() {
        return typeMap.values();
    }

    public Collection<Type> getAllNonPrimitiveTypes() {
        return typeMap.values().stream()
                .filter(t -> !(t instanceof PrimitiveType))
                .collect(Collectors.toSet());
    }

    public Collection<BasicType> getAllBasicTypes() {
        return typeMap.values().stream().filter(t -> t instanceof BasicType)
                .map(t -> (BasicType) t).collect(Collectors.toSet());
    }

    public Collection<PrimitiveType> getAllPrimitiveTypes() {
        return typeMap.values().stream().filter(t -> t instanceof PrimitiveType)
                .map(t -> (PrimitiveType) t).collect(Collectors.toSet());
    }

    public Collection<GenericTypeTemplate> getAllGenericTypeTemplates() {
        return typeMap.values().stream().filter(t -> t instanceof GenericTypeTemplate)
                .map(t -> (GenericTypeTemplate) t).collect(Collectors.toSet());
    }

    public Collection<GenericTypeImpl> getAllGenericTypeImpls() {
        return typeMap.values().stream().filter(t -> t instanceof GenericTypeImpl)
                .map(t -> (GenericTypeImpl) t).collect(Collectors.toSet());
    }

    public Collection<GenericTypeAbstractImpl> getAllGenericTypeAbstractImpls() {
        return typeMap.values().stream().filter(t -> t instanceof GenericTypeAbstractImpl)
                .map(t -> (GenericTypeAbstractImpl) t).collect(Collectors.toSet());
    }

    public Collection<Reference> getAllReferences() {
        return referenceMap.values();
    }

    public Collection<BasicReference> getAllBasicReferences() {
        return referenceMap.values().stream().filter(r -> r instanceof BasicReference)
                .map(r -> (BasicReference) r).collect(Collectors.toSet());
    }

    public Collection<GenericReference> getAllGenericReferences() {
        return referenceMap.values().stream().filter(r -> r instanceof GenericReference)
                .map(r -> (GenericReference) r).collect(Collectors.toSet());
    }

    public Collection<GenericReferenceImpl> getAllGenericReferenceImpls() {
        return referenceMap.values().stream().filter(r -> r instanceof GenericReferenceImpl)
                .map(r -> (GenericReferenceImpl) r).collect(Collectors.toSet());
    }

    public void removeUnnecesaryInheritances() {
        typeMap.values().forEach(Type::removeUnnecesarySubTypes);
        typeMap.values().forEach(Type::removeUnnecesarySuperTypes);
        OBJECT.removeUnnecesarySubTypes();
    }

    public Collection<Type> getRootTypes() {
        return OBJECT.getSubTypes();
    }

    public Collection<Type> getNonPrimitiveRootTypes() {
        return getRootTypes().stream()
                .filter(t -> !(t instanceof PrimitiveType))
                .collect(Collectors.toSet());
    }

    public Collection<Reference> getRealReferences() {
        return referenceMap.values().stream().filter(r -> r instanceof BasicReference || r instanceof GenericReference)
                .collect(Collectors.toSet());
    }

}
