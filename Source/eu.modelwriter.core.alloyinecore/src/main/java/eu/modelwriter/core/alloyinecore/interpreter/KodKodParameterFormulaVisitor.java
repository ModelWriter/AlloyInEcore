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
import eu.modelwriter.core.alloyinecore.structure.constraints.Expression;
import eu.modelwriter.core.alloyinecore.structure.model.Invariant;
import eu.modelwriter.core.alloyinecore.structure.model.RootPackage;
import eu.modelwriter.core.alloyinecore.visitor.BaseVisitorImpl;
import kodkod.ast.Formula;
import kodkod.ast.Node;
import kodkod.ast.Relation;

import java.util.*;
import java.util.stream.Collectors;

public class KodKodParameterFormulaVisitor extends BaseVisitorImpl<Node> {

    private Map<Relation, Relation> genericsMap;
    private Map<Element<?>, Relation> relations;
    private Set<Relation> otherRelations;
    private Map<Invariant, Set<Map<String, String>>> invariantMap;

    private Set<Formula> formulas;
    private Map<Formula, Set<FormulaInfo>> formulaInfos;

    public KodKodParameterFormulaVisitor(Map<Element<?>, Relation> relations, Map<Relation, Relation> genericsMap, Set<Relation> otherRelations) {
        this.genericsMap = genericsMap;
        this.relations = relations;
        this.otherRelations = otherRelations;

        invariantMap = new HashMap<>();
        formulaInfos = new HashMap<>();
        formulas = new HashSet<>();
    }

    @Override
    public Formula visitRootPackage(RootPackage _package) {
        super.visitRootPackage(_package);

        PrivateFormulaVisitor pfv = new PrivateFormulaVisitor(relations, otherRelations);

        invariantMap.forEach((invariant, replacementSet) -> {
            replacementSet.forEach(parameterMap -> {
                Formula f = pfv.visitInvariant(invariant, parameterMap);
                if (f != null) {
                    formulas.add(f);
                    pfv.getFormulaInfos().forEach((formula, infos) -> {
                        formulaInfos.computeIfAbsent(formula, e -> new HashSet<>()).addAll(infos);
                    });
                }
            });
        });

        return formulas.isEmpty() ? Formula.TRUE : Formula.and(formulas);
    }

    @Override
    public Node visitRelation(Expression.Relation relation) {
        Invariant invariant = relation.getOwner(Invariant.class);

        if (invariant != null) {
            String relName = relation.getContext().getText();
            ParameterParser parser = new ParameterParser(relName);

            if (!parser.getParameters().isEmpty()) {
                fillInvariantMap(invariant, parser);
            }
        }

        return super.visitRelation(relation);
    }

    private void fillInvariantMap(Invariant invariant, ParameterParser parser) {
        Set<Map<String, String>> mapSet = invariantMap.computeIfAbsent(invariant, e -> new HashSet<>());

        String mainType = parser.getMainType();

        Set<String> subTypes = genericsMap.entrySet().stream()
                .filter(e -> e.getValue().name().equals(mainType))
                .map(Map.Entry::getKey)
                .map(Relation::name)
                .collect(Collectors.toSet());

        if (mainType.equals("Class")) {
            subTypes.addAll(otherRelations.stream().filter(r -> r.name().startsWith("Class<")).map(Relation::name)
                    .collect(Collectors.toSet()));
        }

        if (subTypes.isEmpty()) {
            if (parser.getExtendsType() != null) {
                subTypes.addAll(genericsMap.entrySet().stream()
                        .filter(e -> e.getValue().name().equals(parser.getExtendsType()))
                        .map(Map.Entry::getKey)
                        .map(Relation::name)
                        .collect(Collectors.toSet()));
            }
            else if (parser.getSuperType() != null) {
                subTypes.addAll(genericsMap.entrySet().stream()
                        .filter(e -> e.getValue().name().equals(parser.getSuperType()))
                        .map(Map.Entry::getKey)
                        .map(Relation::name)
                        .collect(Collectors.toSet()));
            }
        }

        for (String subType : subTypes) {
            Map<String, String> replacementMap = new HashMap<>();
            ParameterParser pp = new ParameterParser(subType);

            if (pp.getParameters().size() != parser.getParameters().size())
                continue;

            Iterator<String> genericParameters = parser.getParameters().iterator();
            Iterator<String> realParameters = pp.getParameters().iterator();

            while (genericParameters.hasNext() && realParameters.hasNext()) {
                String genericParameter = genericParameters.next();
                String realParameter = realParameters.next();

                if (getRelation(genericParameter) == null) {
                    ParameterParser ppSub = new ParameterParser(genericParameter);
                    ParameterParser ppReal = new ParameterParser(realParameter);
                    if (!ppSub.getParameters().isEmpty()) {
                        fillInvariantMap(invariant, ppSub);
                    }
                    else if (getRelation(realParameter) != null && ppSub.getExtendsType() == null && ppSub.getSuperType() == null) {
                        replacementMap.put(genericParameter, realParameter);
                    }
                    else if (ppSub.getExtendsType() != null && ppReal.getExtendsType() != null) {
                        if (getRelation(ppReal.getExtendsType()) != null) {
                            if (getRelation(ppSub.getExtendsType()) == null) {
                                replacementMap.put(ppSub.getExtendsType(), ppReal.getExtendsType());
                            }
                        }
                    }
                    else if (ppSub.getSuperType() != null && ppReal.getSuperType() != null) {
                        if (getRelation(ppReal.getSuperType()) != null) {
                            if (getRelation(ppSub.getSuperType()) == null) {
                                replacementMap.put(ppSub.getSuperType(), ppReal.getSuperType());
                            }
                        }
                    }
                }
            }

            if (!replacementMap.isEmpty())
                mapSet.add(replacementMap);
        }
    }

    private Relation getRelation(String relName) {
        return relations.values().stream()
                .filter(e -> e.name().replace(" ", "").equals(relName.replace(" ", "")))
                .findFirst()
                .orElse(genericsMap.keySet().stream()
                        .filter(e -> e.name().replace(" ", "").equals(relName.replace(" ", "")))
                        .findFirst()
                        .orElse(otherRelations.stream()
                                .filter(e -> e.name().replace(" ", "").equals(relName.replace(" ", "")))
                                .findFirst()
                                .orElse(null)));
    }

    public Map<Formula, Set<FormulaInfo>> getFormulaInfos() {
        return formulaInfos;
    }

    public class PrivateFormulaVisitor extends KodKodFormulaVisitor {
        private Map<String, String> parameterMap;
        private Map<Element<?>, Relation> relations;
        private Set<Relation> otherRelations;

        public PrivateFormulaVisitor(Map<Element<?>, Relation> relations, Set<Relation> otherRelations) {
            super(relations, otherRelations);
            this.relations = relations;
            this.otherRelations = otherRelations;
        }

        @Override
        public Node visitRelation(Expression.Relation relation) {
            return getRelation(getRelationName(relation.getContext().getText()));
        }

        public Formula visitInvariant(Invariant invariant, Map<String, String> parameterMap) {
            this.parameterMap = parameterMap;
            return (Formula) visitInvariant(invariant);
        }

        private String getRelationName(String relName) {
            if (getRelation(relName) != null)
                return relName;
            if (parameterMap.containsKey(relName))
                return parameterMap.get(relName);

            ParameterParser pp = new ParameterParser(relName);

            if (pp.getParameters().isEmpty()) {
                if (pp.getExtendsType() != null) {
                    String newName = "?extends" + getRelationName(pp.getExtendsType());
                    return newName;
                }
                else if (pp.getSuperType() != null){
                    String newName = "?super" + getRelationName(pp.getSuperType());
                    return newName;
                }
                else {
                    return null;
                }
            }
            else {
                String newName = pp.getMainType() + "<";
                newName += pp.getParameters().stream().map(this::getRelationName).collect(Collectors.joining(","));
                newName += ">";

                if (getRelation(newName) == null)
                    System.out.println("Type '" + newName + "' doesn't exist in the model!");
                else
                    return newName;
            }

            return null;
        }

        private Relation getRelation(String relName) {
            return relations.values().stream()
                    .filter(e -> e.name().replace(" ", "").equals(relName.replace(" ", "")))
                    .findFirst()
                    .orElse(otherRelations.stream()
                            .filter(e -> e.name().replace(" ", "").equals(relName.replace(" ", "")))
                            .findFirst()
                            .orElse(null));
        }
    }

}
