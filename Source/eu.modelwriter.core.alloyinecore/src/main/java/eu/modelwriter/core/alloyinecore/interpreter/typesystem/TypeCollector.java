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
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.constraints.Formula;
import eu.modelwriter.core.alloyinecore.structure.constraints.IntExpression;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.ModelImport;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Enum;
import eu.modelwriter.core.alloyinecore.structure.model.PrimitiveType;
import eu.modelwriter.core.alloyinecore.structure.model.TypeParameter;
import eu.modelwriter.core.alloyinecore.structure.uml.Expression;

import java.util.*;
import java.util.stream.Collectors;

public class TypeCollector {

    private Instance instance;
    private RootPackage rootPackage;
    private TypeSystem typeSystem;
    private Set<CollectionStrategy> collectionStrategies;

    public static final String typeReferenceName = "class";
    public static final String subClassReferenceName = "extends";
    public static final String superClassReferenceName = "super";

    public static final String gtReferenceName = "_gt_";
    public static final String gteReferenceName = "_gte_";
    public static final String ltReferenceName = "_lt_";
    public static final String lteReferenceName = "_lte_";

    public TypeCollector(Instance instance, TypeSystem typeSystem) {
        this.instance = instance;
        this.rootPackage = instance.getOwnedElement(ModelImport.class)
                .getOwnedElement(Model.class)
                .getOwnedElement(RootPackage.class);

        this.typeSystem = typeSystem;
        this.collectionStrategies = Collections.emptySet();
    }

    public TypeCollector(Instance instance, TypeSystem typeSystem, Set<CollectionStrategy> strategies) {
        this(instance, typeSystem);
        this.collectionStrategies = strategies;
    }

    public void collect() {
        collectTypes();
        collectPrimitiveTypes();
        collectEnums();
        collectReferences();

        collectClassTypes();
        collectComparisonReferences();

        typeSystem.removeUnnecesaryInheritances();
    }

    private void collectTypes() {
        rootPackage.getAllOwnedElements(Class.class, true).forEach(c -> {
            if (collectionStrategies.stream().allMatch(s -> s.isValid(c))) {
                List<eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter> typeParameters =
                        c.getAllOwnedElements(TypeParameter.class, true)
                                .stream()
                                .filter(t -> !(t.getOwner() instanceof Operation || t.getOwner() instanceof Parameter))
                                .map(t -> new eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter(t.getLabel()))
                                .collect(Collectors.toList());

                Type type;

                if (typeParameters.isEmpty()) {
                    type = typeSystem.createBasicType(c.getSegment(), c.isAbstract());
                } else {
                    type = typeSystem.createGenericTypeTemplate(c.getSegment(), c.isAbstract(), typeParameters);
                }

                type.setElement(c);
            }
        });

        typeSystem.getAllTypes().forEach(type -> {
            Element c = type.getElement();

            if (c instanceof Class) {
                ((Class) c).getSuperTypes().forEach(sup -> {
                    Type superType = typeSystem.getType(sup.getSegment());
                    if (superType != null) {
                        type.addSuperType(superType);
                    }
                });
            }
        });
    }

    private void collectPrimitiveTypes() {
        rootPackage.getAllOwnedElements(PrimitiveType.class, true).forEach(primitiveType -> {
            if (collectionStrategies.stream().allMatch(s -> s.isValid(primitiveType))) {
                Atom.AtomType atomType;
                switch (primitiveType.getLabel()){
                    case "EBoolean":
                        atomType = Atom.AtomType.BOOLEAN;
                        break;
                    case "EInt":
                        atomType = Atom.AtomType.INTEGER;
                        break;
                    case "EString":
                        atomType = Atom.AtomType.STRING;
                        break;
                    case "EBigDecimal":
                        atomType = Atom.AtomType.BIG_DECIMAL;
                        break;
                    case "EBigInteger":
                        atomType = Atom.AtomType.BIG_INTEGER;
                        break;
                    default:
                        return;
                }
                typeSystem.createPrimitiveType(primitiveType.getLabel(), atomType).setElement(primitiveType);
            }
        });
    }

    private void collectEnums() {
        rootPackage.getAllOwnedElements(Enum.class, true).forEach(c -> {
            if (collectionStrategies.stream().allMatch(s -> s.isValid(c))) {
                typeSystem.createPrimitiveType(c.getSegment(), Atom.AtomType.ENUM).setElement(c);
            }
        });
    }

    private void collectReferences() {
        rootPackage.getAllOwnedElements(StructuralFeature.class, true).forEach(sf -> {
            if (collectionStrategies.stream().allMatch(s -> s.isValid(sf))) {
                Type ownerType = typeSystem.getType(((Class) sf.getOwner()).getSegment());
                Type referencedType;

                if (ownerType != null) {
                    GenericElementType type = (GenericElementType) sf.getOwnedElement(GenericElementType.class);
                    if (sf instanceof Attribute) {
                        if (type.getOwnedElement(PrimitiveType.class) == null)
                            referencedType = typeSystem.getType(type.getLabel());
                        else
                            referencedType = typeSystem.getType(type.getOwnedElement(PrimitiveType.class).getLabel());
                        BasicReference ref = typeSystem.createBasicReference(sf.getLabel(), ownerType, referencedType);
                        ref.setStructuralFeature(sf);
                    } else {
                        referencedType = typeSystem.getType(type.getLabel());
                        if (referencedType instanceof BasicType
                                || referencedType instanceof GenericTypeImpl
                                || referencedType instanceof GenericTypeAbstractImpl) {
                            BasicReference ref = typeSystem.createBasicReference(sf.getLabel(), ownerType, referencedType);
                            ref.setStructuralFeature(sf);
                        }
                    }
                }
            }
        });
    }

    private void collectClassTypes() {
        boolean[] created = {false};
        instance.getAllOwnedElements(eu.modelwriter.core.alloyinecore.structure.constraints.Expression.Relation.class,
                false).forEach(relation -> {
            if (!created[0]) {
                String text = relation.getContext().getText();

                ParameterParser pp = new ParameterParser(text);
                if (pp.getMainType().equals(typeReferenceName) || pp.getMainType().equals("Class")) {
                    if (typeSystem.getType("Class") == null) {

                        Set<Type> types = new HashSet<>(typeSystem.getAllTypes());
                        Type classType = typeSystem.createPrimitiveType("Class", Atom.AtomType.CLASS);

                        for (Type type : types) {
                            typeSystem.createPrimitiveType("Class<" + type.getName() + ">", Atom.AtomType.CLASS).addSuperType(classType);
                        }

                        typeSystem.createBasicReference(typeReferenceName, typeSystem.OBJECT, classType);
                        typeSystem.createBasicReference(subClassReferenceName, classType, classType);
                        typeSystem.createBasicReference(superClassReferenceName, classType, classType);
                    }
                    created[0] = true;
                }
            }
        });
    }

    private void collectComparisonReferences() {
        Type intType = typeSystem.getPrimitiveType("EInt");

        if (intType == null)
            return;

        if (instance.getAllOwnedElements(Formula.Lt.class, true).stream()
                .anyMatch(lt -> lt.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())) {
            typeSystem.createBasicReference(ltReferenceName, intType, intType);
        }
        if (instance.getAllOwnedElements(Formula.Lte.class, true).stream()
                .anyMatch(lte -> lte.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())) {
            typeSystem.createBasicReference(lteReferenceName, intType, intType);
        }
        if (instance.getAllOwnedElements(Formula.Gt.class, true).stream()
                .anyMatch(gt -> gt.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())) {
            typeSystem.createBasicReference(gtReferenceName, intType, intType);
        }
        if (instance.getAllOwnedElements(Formula.Gte.class, true).stream()
                .anyMatch(gte -> gte.getAllOwnedElements(IntExpression.Count.class, true).isEmpty())) {
            typeSystem.createBasicReference(gteReferenceName, intType, intType);
        }
    }

}
