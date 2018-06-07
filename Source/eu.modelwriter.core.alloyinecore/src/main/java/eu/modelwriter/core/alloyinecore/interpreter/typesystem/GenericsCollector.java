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

import eu.modelwriter.core.alloyinecore.interpreter.GenericsTree;
import eu.modelwriter.core.alloyinecore.interpreter.ParameterParser;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.*;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.GenericTypeTemplate;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.ModelImport;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Reference;
import eu.modelwriter.core.alloyinecore.structure.model.TypeParameter;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;

import java.util.*;
import java.util.stream.Collectors;

public class GenericsCollector extends BaseVisitorImpl<Object> {

    private Map<String, Set<String>> typeParameters = new HashMap<>();
    private Set<String> genericClasses = new HashSet<>();
    private Map<String, Set<String>> generic2superGeneric = new HashMap<>();

    private TypeSystem typeSystem;
    private RootPackage rootPackage;
    private Set<CollectionStrategy> collectionStrategies;

    public GenericsCollector(Instance instance, TypeSystem typeSystem) {
        this.rootPackage = instance.getOwnedElement(ModelImport.class)
                .getOwnedElement(Model.class)
                .getOwnedElement(RootPackage.class);
        this.typeSystem = typeSystem;
        this.collectionStrategies = Collections.emptySet();
    }

    public GenericsCollector(Instance instance, TypeSystem typeSystem, Set<CollectionStrategy> strategies) {
        this(instance, typeSystem);
        this.collectionStrategies = strategies;
    }

    @Override
    public Object visitTypeParameter(TypeParameter typeParameter) {
        //TODO: Operations are not being interpreted yet!
        if (typeParameter.getOwner() instanceof Operation || typeParameter.getOwner() instanceof Parameter) {
            return super.visitTypeParameter(typeParameter);
        }
        Class owner = ((Class) typeParameter.getOwner());

        if (collectionStrategies.stream().allMatch(s -> s.isValid(owner))) {
            typeParameters.computeIfAbsent(owner.getSegment(), e -> new LinkedHashSet<>())
                    .add(typeParameter.getLabel());
        }

        return super.visitTypeParameter(typeParameter);
    }

    @Override
    public Object visitGenericSuperType(GenericSuperType genericSuperType) {
        if (collectionStrategies.stream().allMatch(s -> s.isValid(genericSuperType.getOwner()))) {
            if (typeSystem.getType(genericSuperType.getLabel()) == null) {
                generic2superGeneric.computeIfAbsent(genericSuperType.getOwner().getLabel(), e -> new LinkedHashSet<>())
                        .add(genericSuperType.getLabel());
            }
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

        if (collectionStrategies.stream().allMatch(s -> s.isValid(owner) && s.isValid(reference))) {
            if (typeParameters.getOrDefault(owner.getSegment(), Collections.emptySet()).stream()
                    .anyMatch(e -> e.equals(genericElementType.getLabel())
                            || genericElementType.getAllOwnedElements(GenericTypeArgument.class, false).stream()
                            .anyMatch(f -> f.getLabel().equals(e)))) {
                // Do nothing.
            } else if (!genericElementType.getOwnedElements(GenericTypeArgument.class).isEmpty()) {
                genericClasses.add(genericElementType.getLabel());
            }
        }

        return super.visitGenericElementType(genericElementType);
    }



    public void collect() {
        visitRootPackage(rootPackage);

        // Example: if (class List<E> && class Nil<V> extends List<V>) then ((List -> Nil) -> (E -> V))
        setEqualParameters();

        // Example: List<Vehicle>, List<?>, List<? extends Vehicle> etc...
        createNewTypes();

        // Example: class Container { property heads: List<?>[*]; }
        collectGenericReferences();

        // Example: class List<E> { property car: E[?]; }
        createGenericReferenceImpls();


        typeSystem.removeUnnecesaryInheritances();
    }

    private void setEqualParameters() {

        typeSystem.getAllGenericTypeTemplates().forEach(genericType -> {
            generic2superGeneric.getOrDefault(genericType.getFullName(), Collections.emptySet()).forEach(superType -> {
                ParameterParser pp = new ParameterParser(superType);
                if (pp.getTypeParameters().isEmpty())
                    return;

                GenericTypeTemplate superGT = typeSystem.getGenericTypeTemplate(pp.getMainType());
                if (superGT == null)
                    return;

                for (int i = 0; i < pp.getTypeParameters().size(); i++) {
                    genericType.addEqualParameter(superGT, pp.getTypeParameters().get(i), superGT.getTypeParameters().get(i));
                    superGT.addEqualParameter(genericType, superGT.getTypeParameters().get(i), pp.getTypeParameters().get(i));
                }
            });
        });
    }

    private void createNewTypes(){

        // List<?>, List<? extends Vehicle> etc...
        genericClasses.forEach(this::createType);

        // CarList extends List<EnginedVehicle> etc...
        generic2superGeneric.forEach((g, set) -> {
            Type gt = typeSystem.getType(g);
            if (gt != null) {
                set.forEach(eg -> {
                    Type egt = createType(eg);
                    if (egt != null) {
                        egt.addSubType(gt);
                    }
                });
            }
        });

        // Create all possible subtypes of generic abstract types like List<?> etc...
        typeSystem.getAllGenericTypeAbstractImpls().forEach(this::createImplsFromAbstractImpl);
    }

    private void collectGenericReferences() {
        rootPackage.getAllOwnedElements(StructuralFeature.class, true).forEach(sf -> {

            Class owner = (Class) sf.getOwner();

            if (collectionStrategies.stream().allMatch(s -> s.isValid(sf) && s.isValid(owner))) {

                Type ownerType = typeSystem.getType(owner.getSegment());

                if (ownerType != null) {
                    GenericElementType type = (GenericElementType) sf.getOwnedElement(GenericElementType.class);
                    if (sf instanceof Reference) {
                        Type referencedType = typeSystem.getType(type.getLabel());
                        if (referencedType instanceof GenericTypeImpl || referencedType instanceof GenericTypeAbstractImpl) {
                            typeSystem.createBasicReference(sf.getLabel(), ownerType, referencedType).setStructuralFeature(sf);
                        } else if (!(referencedType instanceof BasicType)) {
                            eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter tp
                                    = new eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter(
                                    type.getLabel());

                            tp.setOwnerType(ownerType);
                            typeSystem.createGenericReference(sf.getLabel(), ownerType, tp).setStructuralFeature(sf);
                        }
                    }
                }
            }
        });
    }

    private void createGenericReferenceImpls() {

        Map<GenericTypeTemplate, Integer> loopMap = new HashMap<>();

        typeSystem.getAllGenericTypeTemplates().stream()
                .filter(t -> ((Class) t.getElement()).getUpperScope() > 0)
                .forEach(t -> loopMap.put(t, ((Class) t.getElement()).getUpperScope()));

        final Collection<GenericTypeImpl> genericTypeImpls = typeSystem.getAllGenericTypeImpls();

        final Collection<GenericTypeImpl> typesSoFar = new HashSet<>();

        while (!genericTypeImpls.isEmpty()) {

            genericTypeImpls.forEach(impl -> {

                Map<eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter, Type> typeParameterMap =
                        impl.getGenericTypeTemplate().getTypeParameters()
                                .stream()
                                .collect(Collectors
                                        .toMap(e -> e, e -> impl.getTypes().get(impl.getGenericTypeTemplate().getTypeParameters().indexOf(e))));

                impl.getGenericTypeTemplate().getReferences().stream()
                        .filter(r -> r instanceof GenericReference)
                        .map(r -> (GenericReference) r)
                        .forEach(reference -> {

                            Type type = createTypeUsingMap(reference.getReferencedTypeParameter(), typeParameterMap);

                            if (type == null)
                                return;

                            GenericReferenceImpl referenceImpl = typeSystem.createGenericReferenceImpl(
                                    reference.getName(), impl, type);

                            reference.addSubReference(referenceImpl);
                            impl.addReference(referenceImpl);
                        });

            });

            typesSoFar.addAll(genericTypeImpls);

            Collection<GenericTypeImpl> newImpls = typeSystem.getAllGenericTypeImpls().stream()
                    .filter(t -> !typesSoFar.contains(t))
                    .collect(Collectors.toSet());

            newImpls.stream()
                    .map(GenericTypeImpl::getGenericTypeTemplate)
                    .distinct()
                    .forEach(gt -> {
                        if (loopMap.containsKey(gt))
                            loopMap.put(gt, loopMap.get(gt) - 1);
                    });

            genericTypeImpls.clear();
            genericTypeImpls.addAll(newImpls.stream()
                    .filter(t -> loopMap.getOrDefault(t.getGenericTypeTemplate(), 0) > 0)
                    .collect(Collectors.toSet()));
        }
    }

    private Type createType(String type) {
        Type theType = typeSystem.getType(type);
        if (theType != null)
            return theType;

        ParameterParser pp = new ParameterParser(type);

        if (pp.getTypeParameters().isEmpty())
            return null;

        GenericTypeTemplate genericTypeTemplate = typeSystem.getGenericTypeTemplate(pp.getMainType());

        if (genericTypeTemplate == null)
            return null;

        List<Type> parameterTypes = pp.getParameters().stream().map(this::createType).collect(Collectors.toList());
        boolean isAbstractImpl = parameterTypes.stream().anyMatch(Objects::isNull);

        Type newType;

        if (isAbstractImpl) {
            newType = typeSystem.createGenericTypeAbstractImpl(genericTypeTemplate, pp.getTypeParameters());
        }
        else {
            newType = typeSystem.createGenericTypeImpl(genericTypeTemplate, parameterTypes);
        }

        if (!isAbstractImpl) {

            Map<eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter, Type> typeParameterMap = new HashMap<>();

            GenericTypeImpl genericTypeImpl = (GenericTypeImpl) newType;

            for (int i = 0; i < genericTypeTemplate.getTypeParameters().size(); i++) {
                typeParameterMap.put(genericTypeTemplate.getTypeParameters().get(i), genericTypeImpl.getTypes().get(i));
            }

            genericTypeTemplate.getSubTypes().forEach(subType -> {
                if (subType instanceof GenericTypeTemplate){
                    GenericTypeImpl impl = createGenericTypeImpl((GenericTypeTemplate) subType, typeParameterMap.entrySet()
                            .stream()
                            .filter(e -> genericTypeTemplate.getEqualParameter((GenericTypeTemplate) subType, e.getKey()) != null)
                            .collect(Collectors
                                    .toMap(e -> genericTypeTemplate.getEqualParameter((GenericTypeTemplate)subType, e.getKey())
                                            , Map.Entry::getValue)));

                    if (impl != null)
                        newType.addSubType(impl);
                }
            });

            genericTypeTemplate.getSuperTypes().forEach(superType -> {
                if (superType instanceof GenericTypeTemplate){
                    GenericTypeImpl impl = createGenericTypeImpl((GenericTypeTemplate) superType, typeParameterMap.entrySet()
                            .stream()
                            .filter(e -> genericTypeTemplate.getEqualParameter((GenericTypeTemplate) superType, e.getKey()) != null)
                            .collect(Collectors
                                    .toMap(e -> genericTypeTemplate.getEqualParameter((GenericTypeTemplate)superType, e.getKey())
                                            , Map.Entry::getValue)));

                    if (impl != null)
                        newType.addSuperType(impl);
                }
            });

        }

        return newType;
    }

    private Type createTypeUsingMap(eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter typeParameter
            , Map<eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter, Type> typeParameterMap) {

        GenericsTree tree = new GenericsTree(typeParameter.getName());

        for (Map.Entry<eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter, Type> entry
                : typeParameterMap.entrySet()) {

            tree = tree.replace(entry.getKey().getName(), entry.getValue().getFullName());

        }

        Type type, genericType;

        genericType = typeSystem.getType(tree.getMainType());

        if (genericType != null && genericType.isAbstract()) {
            type = typeSystem.getType(tree.getType());
        }
        else {
            type = createType(tree.getType());
        }

        if (type instanceof GenericTypeAbstractImpl) {
            createImplsFromAbstractImpl((GenericTypeAbstractImpl) type);
        }

        return type;

    }

    private GenericTypeImpl createGenericTypeImpl(GenericTypeTemplate genericTypeTemplate
            , Map<eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter, Type> typeParameterMap) {

        List<Type> types = genericTypeTemplate.getTypeParameters().stream().map(p -> {
            Type theType = typeSystem.getType(p.getName());
            if (theType != null)
                return theType;

            if (typeParameterMap.entrySet().stream().anyMatch(e -> e.getKey().equals(p)))
                return typeParameterMap.entrySet().stream().filter(e -> e.getKey().equals(p)).findFirst().get().getValue();

            theType = createType(p.getName());
            if (theType != null)
                return theType;

            ParameterParser pp = new ParameterParser(p.getName());
            if (pp.getTypeParameters().isEmpty())
                return null;

            GenericTypeTemplate gt = typeSystem.getGenericTypeTemplate(pp.getMainType());
            if (gt == null)
                return null;

            return createGenericTypeImpl(gt, typeParameterMap);
        }).collect(Collectors.toList());

        if (types.contains(null))
            return null;

        return (GenericTypeImpl) createType(GenericTypeImpl.createName(genericTypeTemplate, types));
    }

    private void createImplsFromAbstractImpl(GenericTypeAbstractImpl abstractImpl) {
        Set<List<Type>> setOfTypes = new HashSet<>();
        setOfTypes.add(new ArrayList<>());

        for (eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter typeParameter : abstractImpl.getTypeParameters()) {
            Set<Type> typesToAdd = getPossibleTypes(typeParameter);

            if (typesToAdd.isEmpty()) {
                setOfTypes.clear();
                break;
            }

            Set<List<Type>> newSetOfTypes = new HashSet<>();

            setOfTypes.forEach(typeList -> {
                typesToAdd.forEach(type -> {
                    List<Type> newTypeList = new ArrayList<>(typeList);
                    newTypeList.add(type);
                    newSetOfTypes.add(newTypeList);
                });
            });

            setOfTypes = newSetOfTypes;
        }

        setOfTypes.forEach(typeList -> {
            Type createdType;
            if (abstractImpl.getGenericTypeTemplate().isAbstract())
                createdType = typeSystem.getType(GenericTypeImpl.createName(abstractImpl.getGenericTypeTemplate(), typeList));
            else
                createdType = createType(GenericTypeImpl.createName(abstractImpl.getGenericTypeTemplate(), typeList));

            if (createdType != null) {
                createdType.addSuperType(abstractImpl);
            }
        });
    }

    private Set<Type> getPossibleTypes(eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter typeParameter) {
        Set<Type> types = new HashSet<>();

        ParameterParser pp = new ParameterParser(typeParameter.getName());

        Type theType = typeSystem.getType(pp.getType());
        if (theType != null) {
            types.add(theType);
            return types;
        }

        if (pp.getType().equals("?")) {
            types.addAll(typeSystem.getAllBasicTypes());
            types.addAll(typeSystem.getAllGenericTypeImpls());
            return types;
        }
        else if (pp.getExtendsType() != null) {
            Type extendsType = typeSystem.getType(pp.getExtendsType());
            if (extendsType == null) {
                extendsType = createType(pp.getExtendsType());
                if (extendsType instanceof GenericTypeAbstractImpl)
                    createImplsFromAbstractImpl((GenericTypeAbstractImpl) extendsType);
            }

            if (extendsType == null)
                return Collections.emptySet();

            typeSystem.removeUnnecesaryInheritances();

            return extendsType.getSubTypes().stream()
                    .filter(t -> t instanceof GenericTypeImpl || t instanceof BasicType)
                    .collect(Collectors.toSet());
        }
        else if (pp.getSuperType() != null) {
            Type superType = typeSystem.getType(pp.getSuperType());
            if (superType == null) {
                superType = createType(pp.getSuperType());
                if (superType instanceof GenericTypeAbstractImpl)
                    createImplsFromAbstractImpl((GenericTypeAbstractImpl) superType);
            }

            if (superType == null)
                return Collections.emptySet();

            typeSystem.removeUnnecesaryInheritances();

            return superType.getSuperTypes().stream()
                    .filter(t -> t instanceof GenericTypeImpl || t instanceof BasicType)
                    .collect(Collectors.toSet());
        }

        return Collections.emptySet();
    }

}
