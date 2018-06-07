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

package eu.modelwriter.core.alloyinecore.interpreter;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.INavigable;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import kodkod.ast.Expression;
import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.ast.Variable;
import org.antlr.v4.runtime.Token;

import java.util.*;
import java.util.stream.Collectors;

class TypeSystem {
    private Map<Element<?>, Relation> relationMap;
    private List<Formula> formulas = new ArrayList<>();
    private Expression compositeExpr;

    private Map<Formula, Set<FormulaInfo>> formulaInfos = new HashMap<>();

    Formula getTypeFormula(RootPackage rootPackage, Map<Element<?>, Relation> relationMap) {
        this.relationMap = relationMap;

        // Find all composite references and attributes
        Set<Relation> compositeRels = rootPackage.getAllOwnedElements(Reference.class, false)
                .stream()
                .filter(ref -> ref.getContext()
                        .qualifier
                        .stream()
                        .anyMatch(token -> token.getText().equals("composes")))
                .map(relationMap::get)
                .collect(Collectors.toSet());
        compositeRels.addAll(rootPackage.getAllOwnedElements(Attribute.class, false)
                .stream()
                .filter(ref -> ref.getContext()
                        .qualifier
                        .stream()
                        .anyMatch(token -> token.getText().equals("composes")))
                .map(relationMap::get)
                .collect(Collectors.toSet()));


        if (!compositeRels.isEmpty())
            compositeExpr = Expression.union(compositeRels);
        else
            compositeExpr = null;

        formulas.clear();
        Node root = getTree(rootPackage);
        typeFormula(root, relationMap, formulas);
        return Formula.and(formulas);
    }

    private Formula typeFormula(Node node, Map<Element<?>, Relation> relationMap, List<Formula> formulas) {
        // skip top level object
        if (!node.getSuperTypes().isEmpty()) {
            if (node.isAbstract) {
                Formula f = abstractnessFormula(node, relationMap);

                formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                        new FormulaInfo(f, node.classRef.getContext().isAbstract, node.name + " is abstract.")
                );

                formulas.add(f);
            }
            Relation relation = relationMap.get(node.classRef);
            node.getSubTypes().forEach(n -> {
                Formula f = relationMap.get(n.classRef).in(relation);

                formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                        new FormulaInfo(f, n.classRef.getToken(),
                                n.name + " is a subtype of " + node.name + ".")
                );

                formulas.add(f);
            });
        }
        // intersections between siblings
        Node[] subs = node.getSubTypes().toArray(new Node[0]);
        for (int i = 0; i < subs.length; i++) {
            Node left = subs[i];
            for (int j = i + 1; j < subs.length; j++) {
                Node right = subs[j];
                if (!intersects(left, right)) {
                    Relation leftRel = relationMap.get(left.classRef);
                    Relation rightRel = relationMap.get(right.classRef);
                    Formula f = leftRel.intersection(rightRel).no();

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, left.classRef.getToken(),
                                    left.name + " and " + right.name + " are disjoint types.")
                    );
                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, right.classRef.getToken(),
                                    left.name + " and " + right.name + " are disjoint types.")
                    );

                    formulas.add(f);
                }
            }
        }

        applyQualifierFormulas(node);

        // Find cardinality set constraints on EReferences and generate the formula
        node.classRef.getOwnedElements(Reference.class)
                .stream()
                .filter(ref -> ref.getContext().cardinality != null)
                .forEach(reference -> {
                    Token token = reference.getContext().cardinality;

                    Formula f = cardinalityFormula(
                            reference.getContext().cardinality.getText(), relationMap.get(reference)
                    );

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, token)
                    );

                    formulas.add(f);
                });

        // Find cardinality set constraints on EAttribute and generate the formula
        node.classRef.getOwnedElements(Attribute.class)
                .stream()
                .filter(ref -> ref.getContext().cardinality != null)
                .forEach(attribute -> {
                    Token token = attribute.getContext().cardinality;

                    Formula f = cardinalityFormula(
                            attribute.getContext().cardinality.getText(), relationMap.get(attribute)
                    );

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, token)
                    );

                    formulas.add(f);
                });

        // Find cardinality set constraints on EClass and generate the formula
        if (node.classRef.getContext() != null && node.classRef.getContext().cardinality != null) {
            Formula f = cardinalityFormula(node.classRef.getContext().cardinality.getText(), relationMap.get(node.classRef));

            Token token = node.classRef.getContext().cardinality;

            formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                    new FormulaInfo(f, token)
            );

            formulas.add(f);
        }

        // Find multiplicity constraints on EReferences for one, lone and some
        node.classRef.getOwnedElements(Reference.class)
                .stream()
                .filter(ref -> TypedElement.getMultiplicity(ref.getContext().ownedMultiplicity).equals("[1]"))
                .forEach(reference -> {
                    Formula f = exactlyOneFormula(relationMap.get(reference.getOwner()), relationMap.get(reference));

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, reference.getToken())
                    );

                    formulas.add(f);
                });

        node.classRef.getOwnedElements(Reference.class)
                .stream()
                .filter(ref -> TypedElement.getMultiplicity(ref.getContext().ownedMultiplicity).startsWith("[?"))
                .forEach(reference -> {
                    Formula f = zeroOrOneFormula(relationMap.get(reference.getOwner()), relationMap.get(reference));

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, reference.getToken())
                    );

                    formulas.add(f);
                });

        node.classRef.getOwnedElements(Reference.class)
                .stream()
                .filter(ref -> TypedElement.getMultiplicity(ref.getContext().ownedMultiplicity).startsWith("[+"))
                .forEach(reference -> {
                    Formula f = oneOrMoreFormula(relationMap.get(reference.getOwner()), relationMap.get(reference));

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, reference.getToken())
                    );

                    formulas.add(f);
                });

        // Find multiplicity constraints on EAttributes for one, lone and some
        node.classRef.getOwnedElements(Attribute.class)
                .stream()
                .filter(ref -> TypedElement.getMultiplicity(ref.getContext().ownedMultiplicity).equals("[1]"))
                .forEach(attribute -> {
                    Formula f = exactlyOneFormula(relationMap.get(attribute.getOwner()), relationMap.get(attribute));

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, attribute.getToken())
                    );

                    formulas.add(f);
                });

        node.classRef.getOwnedElements(Attribute.class)
                .stream()
                .filter(ref -> TypedElement.getMultiplicity(ref.getContext().ownedMultiplicity).startsWith("[?"))
                .forEach(attribute -> {
                    Formula f = zeroOrOneFormula(relationMap.get(attribute.getOwner()), relationMap.get(attribute));

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, attribute.getToken())
                    );

                    formulas.add(f);
                });

        node.classRef.getOwnedElements(Attribute.class)
                .stream()
                .filter(ref -> TypedElement.getMultiplicity(ref.getContext().ownedMultiplicity).startsWith("[+"))
                .forEach(attribute -> {
                    Formula f = oneOrMoreFormula(relationMap.get(attribute.getOwner()), relationMap.get(attribute));

                    formulaInfos.computeIfAbsent(f, e -> new HashSet<>()).add(
                            new FormulaInfo(f, attribute.getToken())
                    );

                    formulas.add(f);
                });

        node.getSubTypes().forEach(n -> typeFormula(n, relationMap, formulas));
        return Formula.and(formulas);
    }

    private void applyQualifierFormulas(Node node) {
        node.classRef.getOwnedElements(Reference.class).forEach(ref -> {
            Relation type = relationMap.get(ref.getOwner());
            Relation relation = relationMap.get(ref);

            List<Token> qualifiers = ref.getContext().qualifier;

            for (Token token : qualifiers) {
                Formula formula = null;
                String desc = null;

                switch (token.getText()) {
                    case "acyclic":
                        formula = aCyclicFormula(type, relation);
                        break;
                    case "composes":
                        formula = compositionFormula(type, relation, compositeExpr);
                        desc = "An object must be \"" + relation.name() + "\"-ed by max. 1 " + type.name() + ".";
                        break;
                    case "reflexive":
                        formula = reflexiveFormula(type, relation);
                        break;
                    case "irreflexive":
                        formula = irreflexiveFormula(type, relation);
                        break;
                    case "transitive":
                        formula = transitiveFormula(relation);
                        break;
                    case "symmetric":
                        formula = symmetricFormula(relation);
                        break;
                    case "asymmetric":
                        formula = aSymmetricFormula(relation);
                        break;
                    case "antisymmetric":
                        formula = antiSymmetricFormula(type, relation);
                        break;
                    case "total":
                        formula = totalFormula(type, relation);
                        break;
                    case "functional":
                        formula = functionalFormula(type, relation);
                        break;
                    case "function":
                        formula = functionFormula(type, relation);
                        break;
                    case "surjective":
                        formula = surjectiveFormula(type, relation);
                        break;
                    case "injective":
                        formula = injectiveFormula(type, relation);
                        break;
                    case "bijective":
                        formula = bijectiveFormula(type, relation);
                        break;
                    case "complete":
                        formula = completeFormula(type, relation);
                        break;
                    case "bijection":
                        formula = bijectionFormula(type, relation);
                        break;
                    case "preorder":
                        formula = preOrderFormula(type, relation);
                        break;
                    case "equivalence":
                        formula = equivalenceFormula(type, relation);
                        break;
                    case "partialorder":
                        formula = partialOrderFormula(type, relation);
                        break;
                    case "totalorder":
                        formula = totalOrderFormula(type, relation);
                        break;
                }

                if (formula != null) {

                    FormulaInfo formulaInfo;

                    if (desc == null)
                        formulaInfo = new FormulaInfo(formula, token);
                    else
                        formulaInfo = new FormulaInfo(formula, token, desc);

                    formulas.add(formula);
                    formulaInfos.computeIfAbsent(formula, e -> new HashSet<>()).add(formulaInfo);
                }
            }
        });

        node.classRef.getOwnedElements(Attribute.class).forEach(ref -> {
            Relation type = relationMap.get(ref.getOwner());
            Relation relation = relationMap.get(ref);

            List<Token> qualifiers = ref.getContext().qualifier;

            for (Token token : qualifiers) {
                Formula formula = null;
                //String desc = null;

                switch (token.getText()) {
                    case "id":
                        formula = identificationFormula(type, relation);
                        break;
                }

                if (formula == null)
                    return;

                FormulaInfo formulaInfo;

                //if (desc == null)
                    formulaInfo = new FormulaInfo(formula, token);
                //else
                //    formulaInfo = new FormulaInfo(formula, token, desc);

                formulas.add(formula);
                formulaInfos.computeIfAbsent(formula, e -> new HashSet<>()).add(formulaInfo);
            }
        });
    }

    private Formula abstractnessFormula(Node node, Map<Element<?>, Relation> relationMap) {
        Relation relation = relationMap.get(node.classRef);
        if (relation != null) {
            List<Relation> rels = node.getSubTypes()
                    .stream()
                    .map(n -> relationMap.get(n.classRef))
                    .collect(Collectors.toList());
            if (!rels.isEmpty()) {
                return relation.eq(Expression.union(rels));
            } else return relation.no();
        }
        return Formula.TRUE;
    }

    private Formula compositionFormula(Relation type, Relation relation, Expression compositeExpr) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(compositeExpr.transpose()).lone().forAll(var.oneOf(type.join(relation)));
    }

    private Formula aCyclicFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.in(var.join(relation.closure())).not().forAll(var.oneOf(type));
    }

    private Formula transitiveFormula(Relation relation) {
        return relation.join(relation).in(relation);
    }

    private Formula reflexiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.in(var.join(relation)).forAll(var.oneOf(type));
    }

    private Formula irreflexiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.in(var.join(relation)).not().forAll(var.oneOf(type));
    }

    private Formula symmetricFormula(Relation relation) {
        return relation.eq(relation.transpose());
    }

    private Formula antiSymmetricFormula(Relation type, Relation relation) {
        Variable varA = Variable.unary("a");
        Variable varB = Variable.unary("b");
        return varB.in(varA.join(relation)).and(varA.in(varB.join(relation))).implies(varA.eq(varB))
                .forAll(varA.oneOf(type).and(varB.oneOf(type)));
    }

    private Formula aSymmetricFormula(Relation relation) {
        return relation.eq(relation.transpose()).not();
    }

    private Formula totalFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).some().forAll(var.oneOf(type));
    }

    private Formula functionalFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).lone().forAll(var.oneOf(type));
    }

    private Formula functionFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).one().forAll(var.oneOf(type));
    }

    private Formula surjectiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return relation.join(var).some().forAll(var.oneOf(type));
    }

    private Formula injectiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return relation.join(var).lone().forAll(var.oneOf(type));
    }

    private Formula bijectiveFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return relation.join(var).one().forAll(var.oneOf(type));
    }

    private Formula bijectionFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return relation.join(var).one().and(var.join(relation).one()).forAll(var.oneOf(type));
    }

    private Formula completeFormula(Relation type, Relation relation) {
        Variable varA = Variable.unary("a");
        Variable varB = Variable.unary("b");
        return varA.eq(varB).not().implies(varA.product(varB).in(relation.union(relation.transpose())))
                .forAll(varA.oneOf(type).and(varB.oneOf(type)));
    }

    private Formula preOrderFormula(Relation type, Relation relation) {
        return reflexiveFormula(type, relation).and(transitiveFormula(relation));
    }

    private Formula equivalenceFormula(Relation type, Relation relation) {
        return symmetricFormula(relation).and(preOrderFormula(type, relation));
    }

    private Formula partialOrderFormula(Relation type, Relation relation) {
        return preOrderFormula(type, relation).and(antiSymmetricFormula(type, relation));
    }

    private Formula totalOrderFormula(Relation type, Relation relation) {
        return partialOrderFormula(type, relation).and(completeFormula(type, relation));
    }

    private Formula identificationFormula(Relation type, Relation relation) {
        Variable a = Variable.unary("a");
        Variable b = Variable.unary("b");
        return a.eq(b).not().implies(a.join(relation).eq(b.join(relation)).not()).forAll(a.oneOf(type).and(b.oneOf(type)));
    }

    //one
    private Formula exactlyOneFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).one().forAll(var.oneOf(type));
    }

    //lone
    private Formula zeroOrOneFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).lone().forAll(var.oneOf(type));
    }

    //some
    private Formula oneOrMoreFormula(Relation type, Relation relation) {
        Variable var = Variable.unary(String.valueOf(type.name().toLowerCase().charAt(0)));
        return var.join(relation).some().forAll(var.oneOf(type));
    }

    private Formula cardinalityFormula(String multiplicity, Relation type) {
        switch (multiplicity) {
            case "one":
                return type.one();
            case "lone":
                return type.lone();
            case "some":
                return type.some();
            case "no":
                return type.no();
            default:
                return Formula.TRUE;
        }
    }

    Map<Formula, Set<FormulaInfo>> getFormulaInfos() {
        return formulaInfos;
    }

    private Node getTree(RootPackage rootPackage) {
        Node root = new Node(new ObjectClass());
        for (Class aClass : rootPackage.getAllOwnedElements(Class.class, true)) {
            addToTree(root, aClass);
        }
        return root;
    }

    private Node addToTree(Node root, Class aClass) {
        Node found = searchTree(root, aClass);
        if (found != null) return found;
        Node node = new Node(aClass);
        List<Class> superTypes = aClass.getOwnedElements(GenericSuperType.class)
                .stream()
                .map(INavigable::getTarget)
                .map(in -> (Class) in.asElement())
                .collect(Collectors.toList());
        if (superTypes.isEmpty()) {
            root.getSubTypes().add(node);
            node.getSuperTypes().add(root);
        } else {
            for (Class superType : superTypes) {
                Node superNode = addToTree(root, superType);
                superNode.getSubTypes().add(node);
                node.getSuperTypes().add(superNode);
            }
        }
        return node;
    }

    private Node searchTree(Node startNode, Class aClass) {
        for (Node subNode : startNode.getSubTypes()) {
            if (subNode.classRef.equals(aClass)) return subNode;
            else {
                Node subResult = searchTree(subNode, aClass);
                if (subResult != null) return subResult;
            }
        }
        return null;
    }

    private boolean intersects(Node node1, Node node2) {
        return !Collections.disjoint(flattenSubTypes(node1), flattenSubTypes(node2));
    }

    private List<Node> flattenSubTypes(Node node) {
        ArrayList<Node> subs = new ArrayList<>(node.getSubTypes());
        for (Node subType : node.getSubTypes()) {
            subs.addAll(flattenSubTypes(subType));
        }
        return subs;
    }

    public static class Node {
        String name;
        boolean isAbstract;
        Class classRef;
        Set<Node> subTypes = new HashSet<>();
        Set<Node> superTypes = new HashSet<>();

        public Node(Class aClass) {
            classRef = aClass;
            name = aClass.getSegment();
            isAbstract = aClass.isAbstract();
        }

        Set<Node> getSubTypes() {
            return subTypes;
        }

        Set<Node> getSuperTypes() {
            return superTypes;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Node && this.classRef.equals(((Node) obj).classRef);
        }

        @Override
        public int hashCode() {
            return this.classRef.hashCode();
        }
    }

    public static class ObjectClass extends Class {

        ObjectClass() {
            super(null, null);
        }

        @Override
        public Token getToken() {
            return null;
        }

        @Override
        public String getSegment() {
            return "Object";
        }

        @Override
        public boolean isAbstract() {
            return true;
        }

        @Override
        public int hashCode() {
            return this.getClass().getSimpleName().hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof ObjectClass && obj.hashCode() == this.hashCode();
        }
    }

}
