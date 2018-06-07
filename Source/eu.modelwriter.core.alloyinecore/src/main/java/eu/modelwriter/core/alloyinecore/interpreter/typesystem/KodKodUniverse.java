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

import eu.modelwriter.core.alloyinecore.interpreter.EObjectCreationException;
import eu.modelwriter.core.alloyinecore.interpreter.FormulaInfo;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.*;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.PrimitiveType;
import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.Reference;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import kodkod.ast.Formula;
import kodkod.ast.Relation;
import kodkod.engine.Solution;
import kodkod.instance.Bounds;
import kodkod.instance.Tuple;
import kodkod.instance.TupleSet;
import kodkod.util.nodes.PrettyPrinter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class KodKodUniverse {

    private UniverseCreator universeCreator; // Type system and bounds are created there.
    private KodKodUniverseCreator kodKodUniverseCreator; // Universe is converted into KodKod universe there.

    private Map<Type, Set<Atom>> atoms; // Every type and their atoms.
    private Map<Reference, Set<Pair<Atom>>> references; // Every relation and their tuples.

    private Map<EObject, Map<EStructuralFeature, Set<EObject>>> inferredRelations;
    private Set<EObject> inferredEObjects;

    private Bounds bounds = null;
    private Formula formula = null;

    public KodKodUniverse(Instance instance) {
        // Create type system and bounds.
        this.universeCreator = new UniverseCreator(instance);

        // Get the atoms and relations on the given instance.
        this.atoms = universeCreator.getAtoms();
        this.references = universeCreator.getReferences();

        // Create KodKod formula from the type system.
        kodKodUniverseCreator = new KodKodUniverseCreator(universeCreator.getTypeSystem(), instance);

        inferredEObjects = new HashSet<>();
        inferredRelations = new HashMap<>();
    }

    public Set<FormulaInfo> getFormulaInfos() {
        return kodKodUniverseCreator.getFormulaInfos();
    }

    public Set<FormulaInfo> getFormulaInfos(Formula f) {
        return kodKodUniverseCreator.getFormulaInfos().stream()
                .filter(fi -> fi.getFormula().equals(f))
                .collect(Collectors.toSet());
    }

    /**
     * IMPORTANT: getBounds() must be called first. Because creating bounds can create new formula.
     */
    public Formula getFormula() {
        if (formula == null)
            formula = kodKodUniverseCreator.getFormula();
        return formula;
    }

    public Bounds getBounds() {
        if (bounds == null) {
            // There can be atoms or relations that came not from partial instance. Add them to the bound collector.
            universeCreator.getBoundCollector().addAtoms(atoms);
            universeCreator.getBoundCollector().addReferences(references);

            bounds = kodKodUniverseCreator.createBounds(universeCreator.getBoundCollector());
        }
        return bounds;
    }

    // Update instance with the solution instance. This is the final instance.
    public void updateWithInstance(kodkod.instance.Instance instance) {
        this.atoms = kodKodUniverseCreator.getAtoms(instance);
        this.references = kodKodUniverseCreator.getReferences(instance);
    }

    public int getBitwidth() {
        return Math.max(4, (int) Math.ceil(Math.log(kodKodUniverseCreator.getMaxBound() + 1) / Math.log(2)) + 1);
    }

    public String getInstanceString(){
        String newLine = System.getProperty("line.separator");

        StringBuilder sb = new StringBuilder();

        atoms.forEach(((type, atomSet) -> {
            // if (type.getElement() instanceof Class)
                sb.append(String.format("%-15s %s", type.getFullName() + ":"
                        , atomSet.stream().map(Atom::getName).collect(Collectors.joining(", "))))
                        .append(newLine);
        }));

        sb.append(newLine);

        references.forEach((reference, pairSet) -> {
            if (reference.getStructuralFeature() != null)
                pairSet.forEach(pair ->
                        sb.append(reference)
                                .append(" (")
                                .append(pair.getFirst().getName())
                                .append(", ")
                                .append(pair.getSecond().getName())
                                .append(")")
                                .append(newLine));
        });

        return sb.toString();
    }

    public void save(String outDir, String fileName, Bounds bounds, Formula formula, Solution solution, String proofString) {
        try {
            Path path = Paths.get(outDir + File.separator + fileName);
            if (!Files.exists(path.getParent()))
                Files.createDirectories(path.getParent());
            String newLine = System.getProperty("line.separator");
            String formulas = PrettyPrinter.print(formula, 0)
                    .replace(" && \n ", " and" )
                    .replace(" && \n", " $$" )
                    .replace("\n", "" )
                    .replace(" $$", " \n" )
                    .replace(" . ", ".")
                    .replace("   ", " ");

            String result = bounds.universe().toString() + newLine + newLine +
                    bounds.toString() + newLine + newLine +
                    formulas + newLine + newLine +
                    solution.toString() + newLine + newLine +
                    (solution.proof() != null ? (proofString + newLine + newLine) : "") +
                    getInstanceString();


            Files.write(path, result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // Visualization Stuff

    public Set<EObject> getWitnessAtoms(Set<Atom> atoms) {
        return KodKodUniverse.this.atoms.values().stream()
                .flatMap(Collection::stream)
                .filter(atoms::contains)
                .map(Atom::getObject)
                .filter(e -> e instanceof Object)
                .map(e -> ((Object) e).getEObject())
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getWitnessRelations(Map<Relation, TupleSet> relTupleMap) {
        Map<EObject, Map<EStructuralFeature, Set<EObject>>> rels = new HashMap<>();

        Map<Reference, Set<Pair<Atom>>> referencePairMap = kodKodUniverseCreator.getReferences(relTupleMap);

        references.forEach((reference, value) -> value.forEach(pair -> {
            Element e1 = pair.getFirst().getObject();
            Element e2 = pair.getSecond().getObject();

            if (e1 instanceof Object && e2 instanceof Object) {
                EObject eo1 = ((Object) e1).getEObject();
                EObject eo2 = ((Object) e2).getEObject();

                if (eo1 != null && eo2 != null) {
                    EStructuralFeature esf = eo1.eClass().getEAllStructuralFeatures().stream()
                            .filter(rel -> rel.getName().equals(reference.getName()))
                            .findFirst().orElse(null);

                    if (esf instanceof EReference)
                        if (referencePairMap.getOrDefault(reference, Collections.emptySet()).stream()
                                .anyMatch(p -> p.getFirst().equals(pair.getFirst())
                                        && p.getSecond().equals(pair.getSecond())))
                            rels.computeIfAbsent(eo1, e -> new HashMap<>())
                                    .computeIfAbsent(esf, e -> new HashSet<>())
                                    .add(eo2);
                }
            }
        }));

        return rels;
    }

    public Set<EObject> getEObjectsOfAtoms(Set<String> atoms) {
        return atoms.stream()
                .map(s -> KodKodUniverse.this.atoms.values().stream().flatMap(Collection::stream).filter(a -> a.getName().equals(s)).findFirst().orElse(null))
                .filter(Objects::nonNull)
                .map(Atom::getObject)
                .filter(e -> e instanceof Object)
                .map(e -> ((Object) e).getEObject())
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public Map<String, String> getInferredsOfAtoms(Set<String> atoms) {
        return atoms.stream()
                .filter(s -> KodKodUniverse.this.atoms.values().stream().flatMap(Collection::stream)
                        .filter(a -> a.getName().equals(s))
                        .anyMatch(a -> !(a.getObject() instanceof Object) || ((Object) a.getObject()).getEObject() == null))
                .collect(Collectors.toMap(s -> s, s -> KodKodUniverse.this.atoms.values().stream().flatMap(Collection::stream)
                        .filter(a -> a.getName().equals(s)).findFirst().orElse(null).getObject().getLabel()));
    }

    public Set<EObject> getInferredEObjects() {
        return inferredEObjects;
    }

    public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getInferredRelations() {
        return inferredRelations;
    }

    public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getModelReferences() {

        Map<EObject, Map<EStructuralFeature, Set<EObject>>> modelRelations = new HashMap<>();

        references.entrySet().stream()
                .filter(r -> r.getKey().getQualifiers().stream().anyMatch(t -> t.getText().equals("model")))
                .forEach(entry -> {
                    Reference reference = entry.getKey();
                    entry.getValue().forEach(pair -> {
                        Element e1 = pair.getFirst().getObject();
                        Element e2 = pair.getSecond().getObject();

                        if (e1 instanceof Object && e2 instanceof Object) {
                            EObject eo1 = ((Object) e1).getEObject();
                            EObject eo2 = ((Object) e2).getEObject();

                            if (eo1 != null && eo2 != null) {
                                EStructuralFeature esf = eo1.eClass().getEAnnotations().stream()
                                        .flatMap(e -> e.getContents().stream())
                                        .filter(rel -> rel instanceof EStructuralFeature
                                                && ((EStructuralFeature) rel).getName().equals(reference.getName()))
                                        .map(rel -> (EStructuralFeature) rel)
                                        .findFirst().orElse(null);

                                if (esf == null) {
                                    esf = eo1.eClass().getEAllSuperTypes().stream().flatMap(e -> e.getEAnnotations().stream())
                                            .flatMap(e -> e.getContents().stream())
                                            .filter(rel -> rel instanceof EStructuralFeature
                                                    && ((EStructuralFeature) rel).getName().equals(reference.getName()))
                                            .map(rel -> (EStructuralFeature) rel)
                                            .findFirst().orElse(null);
                                }
                                if (esf instanceof EReference)
                                    modelRelations.computeIfAbsent(eo1, e -> new HashMap<>())
                                            .computeIfAbsent(esf, e -> new HashSet<>())
                                            .add(eo2);
                            }
                        }
                    });
                });

        return modelRelations;
    }

    public Map<EObject, Map<EStructuralFeature, Set<String>>> getModelAttributes() {

        Map<EObject, Map<EStructuralFeature, Set<String>>> modelRelations = new HashMap<>();

        references.entrySet().stream()
                .filter(r -> r.getKey().getQualifiers().stream().anyMatch(t -> t.getText().equals("model")))
                .forEach(entry -> {
                    Reference reference = entry.getKey();
                    entry.getValue().forEach(pair -> {
                        Element e1 = pair.getFirst().getObject();
                        Element e2 = pair.getSecond().getObject();

                        if (e1 instanceof Object && !(e2 instanceof Object)) {
                            EObject eo1 = ((Object) e1).getEObject();
                            String eo2 = pair.getSecond().getName();

                            if (eo1 != null && eo2 != null) {
                                EStructuralFeature esf = eo1.eClass().getEAnnotations().stream()
                                        .flatMap(e -> e.getContents().stream())
                                        .filter(rel -> rel instanceof EStructuralFeature
                                                && ((EStructuralFeature) rel).getName().equals(reference.getName()))
                                        .map(rel -> (EStructuralFeature) rel)
                                        .findFirst().orElse(null);

                                if (esf == null) {
                                    esf = eo1.eClass().getEAllSuperTypes().stream().flatMap(e -> e.getEAnnotations().stream())
                                            .flatMap(e -> e.getContents().stream())
                                            .filter(rel -> rel instanceof EStructuralFeature
                                                    && ((EStructuralFeature) rel).getName().equals(reference.getName()))
                                            .map(rel -> (EStructuralFeature) rel)
                                            .findFirst().orElse(null);
                                }
                                if (esf instanceof EAttribute)
                                    modelRelations.computeIfAbsent(eo1, e -> new HashMap<>())
                                            .computeIfAbsent(esf, e -> new HashSet<>())
                                            .add(eo2);
                            }
                        }
                    });
                });

        return modelRelations;
    }

    public void setModelReferences(Map<EObject, Map<EStructuralFeature, Set<EObject>>> modelRelations) {
        modelRelations.forEach((eo1, sfMap) -> {

            Atom atom1 = atoms.values().stream().flatMap(Collection::stream)
                    .filter(e -> e.getObject() instanceof Object
                            && EcoreUtil.getURI(((Object) e.getObject()).getEObject()).fragment()
                            .equals(EcoreUtil.getURI(eo1).fragment()))
                    .findFirst()
                    .orElse(null);

            if (atom1 != null) {
                sfMap.forEach((esf, eoSet) -> {

                    Reference reference = universeCreator.getTypeSystem()
                            .getReference(esf.getName(),
                                    universeCreator.getTypeSystem().getType(((EClassImpl) esf.eContainer().eContainer()).getName()));

                    if (reference != null && reference.getStructuralFeature() instanceof eu.modelwriter.core.alloyinecore.structure.model.Reference) {
                        if (reference.getQualifiers().stream().noneMatch(t -> t.getText().equals("derived"))) {
                            eoSet.forEach(eo2 -> {
                                Atom atom2 = atoms.values().stream().flatMap(Collection::stream)
                                        .filter(e -> e.getObject() instanceof Object
                                                && EcoreUtil.getURI(((Object) e.getObject()).getEObject()).fragment()
                                                .equals(EcoreUtil.getURI(eo2).fragment()))
                                        .findFirst()
                                        .orElse(null);


                                if (atom2 != null) {
                                    references.computeIfAbsent(reference, r -> new HashSet<>()).add(Pair.of(atom1, atom2));
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    public void setModelAttributes(Map<EObject, Map<EStructuralFeature, Set<String>>> modelAttributes) {
        modelAttributes.forEach((eo1, sfMap) -> {

            Atom atom1 = atoms.values().stream().flatMap(Collection::stream)
                    .filter(e -> e.getObject() instanceof Object
                            && EcoreUtil.getURI(((Object) e.getObject()).getEObject()).fragment()
                            .equals(EcoreUtil.getURI(eo1).fragment()))
                    .findFirst()
                    .orElse(null);

            if (atom1 != null) {
                sfMap.forEach((esf, eoSet) -> {

                    BasicReference reference = universeCreator.getTypeSystem()
                            .getBasicReference(esf.getName(),
                                    universeCreator.getTypeSystem().getType(((EClassImpl) esf.eContainer().eContainer()).getName()));

                    if (reference != null
                            && reference.getStructuralFeature() instanceof Attribute
                            && reference.getReferencedType() instanceof PrimitiveType) {

                        PrimitiveType referencedType = (PrimitiveType) reference.getReferencedType();
                        Atom.AtomType atomType = referencedType.getAtomType();

                        if (reference.getQualifiers().stream().noneMatch(t -> t.getText().equals("derived"))) {
                            eoSet.forEach(str -> {
                                Set<Atom> set = atoms.computeIfAbsent(referencedType, t -> new HashSet<>());
                                Atom atom2 = set.stream().filter(a -> a.getName().equals(str))
                                        .findFirst().orElse(new Atom(str, atomType));
                                set.add(atom2);

                                references.computeIfAbsent(reference, r -> new HashSet<>()).add(Pair.of(atom1, atom2));
                            });
                        }
                    }
                });
            }
        });
    }



    // ECore Stuff

    private String original_instance = null;

    public void saveToXMI(String filename) throws IOException, EObjectCreationException {
        ResourceSet rs = new ResourceSetImpl();
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

        URI fileURI = URI.createFileURI(filename);

        if (original_instance == null) {
            original_instance = filename + "_original.xmi";
            URI originalURI = URI.createFileURI(original_instance);

            Resource res = rs.getResource(fileURI, true);
            res.load(Collections.emptyMap());

            res.setURI(originalURI);
            res.save(Collections.EMPTY_MAP);
        }

        URI originalURI = URI.createFileURI(original_instance);
        Resource res = rs.getResource(originalURI, true);
        res.load(Collections.emptyMap());

        inferredEObjects.clear();
        inferredRelations.clear();

        setEObjects(res);
        createEObjects(res);
        addRelationsToResource();

        res.setURI(fileURI);

        res.save(Collections.EMPTY_MAP);
    }

    public void setEObjects(String filename) throws IOException {

        ResourceSet rs = new ResourceSetImpl();
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

        Resource res = rs.getResource(URI.createFileURI(filename), true);
        res.load(Collections.emptyMap());

        setEObjects(res);
    }

    private void setEObjects(Resource res) throws IOException {

        // Sort atom2object by their position in the file.
        List<Atom> list = atoms.values().stream()
                .flatMap(Collection::stream)
                .filter(e -> e.getObject() instanceof Object && ((Object) e.getObject()).getContext() != null)
                .distinct()
                .sorted(Comparator.comparingInt(e -> e.getObject().getStart()))
                .collect(Collectors.toList());

        TreeIterator<EObject> treeIterator = res.getAllContents();
        Iterator<Atom> iterator = list.iterator();

        while (iterator.hasNext()) {
            Atom temp = iterator.next();
            if (treeIterator.hasNext()){
                EObject eo = treeIterator.next();
                ((Object) temp.getObject()).setEObject(eo);
            }
            else {
                System.out.println(temp.getObject().getLabel() + " Something is wrong!");
            }
        }
    }

    private void createEObjects(Resource res) throws EObjectCreationException {

        EPackage metaPackage = res.getContents().get(0).eClass().getEPackage();
        EFactory metaFactory = metaPackage.getEFactoryInstance();

        atoms.forEach((type, atomSet) -> {
            atomSet.forEach(atom -> {
                if (!(atom.getObject() instanceof Class ||
                        (atom.getObject() instanceof Object && ((Object) atom.getObject()).getContext() == null)))
                    return;
                /*if ((atom.getObject() instanceof Object && ((Object) atom.getObject()).getContext() != null))
                    return;*/

                if (type.getAllSubTypes().stream()
                        .filter(t -> !t.isAbstract())
                        .map(t -> atoms.getOrDefault(t, Collections.emptySet()))
                        .flatMap(Collection::stream)
                        .anyMatch(a -> atom == a)) {
                    return;
                }

                if (type.isAbstract()) {
                    System.out.println(atom.getObject().getLabel() + " is an abstract class!");
                    return;
                }

                EObject eo = metaFactory.create((EClass) metaPackage.getEClassifier(type.getMainName()));
                Object object = new Object(eo, null);
                atom.setObject(object);

                inferredEObjects.add(eo);
            });
        });
    }

    private void addRelationsToResource() {
        atoms.values().stream()
                .flatMap(Collection::stream)
                .distinct()
                .filter(a -> a.getObject() instanceof Object).forEach(atom -> {
                    EObject eo1 = ((Object) atom.getObject()).getEObject();
                    if (eo1 == null)
                        return;
                    eo1.eClass().getEAllStructuralFeatures().stream()
                            .filter(EStructuralFeature::isDerived)
                            .forEach(eSF -> {

                                eo1.eUnset(eSF);

                            });
                });

        references.forEach((reference, pairs) -> {

            if (reference.getQualifiers().stream().anyMatch(t -> t.getText().equals("model")))
                return;

            pairs.forEach(pair -> {

                Atom atom1 = pair.getFirst();
                Atom atom2 = pair.getSecond();

                if (!(atom1.getObject() instanceof Object)) {
                    // System.out.println(atom1 + " is not an Object!");
                    return;
                }

                if ((((Object) atom1.getObject()).getEObject() == null)) {
                    System.out.println(atom1 + " doesn't have an EObject!");
                    return;
                }

                EObject eo1 = ((Object) atom1.getObject()).getEObject();
                EStructuralFeature eSF = eo1.eClass().getEStructuralFeature(reference.getName());

                if (eSF instanceof EReference) {
                    if (!(atom2.getObject() instanceof Object)) {
                        System.out.println(atom2 + " is not an Object!");
                        return;
                    }

                    if ((((Object) atom2.getObject()).getEObject() == null)) {
                        System.out.println(atom2 + " doesn't have an EObject!");
                        return;
                    }

                    EObject eo2 = ((Object) atom2.getObject()).getEObject();
                    if (eo1.eGet(eSF) instanceof EList) {
                        EList eList = (EList) eo1.eGet(eSF);
                        if (!eList.contains(eo2)) {
                            eList.add(eo2);
                            inferredRelations.computeIfAbsent(eo1, e -> new HashMap<>())
                                    .computeIfAbsent(eSF, e -> new HashSet<>())
                                    .add(eo2);
                        }
                    }
                    else if (!eo2.equals(eo1.eGet(eSF))) {
                        eo1.eSet(eSF, eo2);
                        inferredRelations.computeIfAbsent(eo1, e -> new HashMap<>())
                                .computeIfAbsent(eSF, e -> new HashSet<>())
                                .add(eo2);
                    }
                }
                else if (eSF instanceof EAttribute) {
                    java.lang.Object eo2 = null;

                    switch (atom2.getType()) {
                        case STRING:
                            eo2 = atom2.getName();
                            break;
                        case BOOLEAN:
                            try {
                                eo2 = Boolean.parseBoolean(atom2.getName());
                            }
                            catch (Exception ex){
                                eo2 = false;
                            }
                            break;
                        case INTEGER:
                            try {
                                eo2 = Integer.parseInt(atom2.getName());
                            }
                            catch (Exception ex){
                                eo2 = 0;
                            }
                            break;
                        case BIG_DECIMAL:
                            try {
                                eo2 = BigDecimal.valueOf(Double.parseDouble(atom2.getName()));
                            }
                            catch (Exception ex){
                                eo2 = BigDecimal.ZERO;
                            }
                            break;
                        case BIG_INTEGER:
                            try {
                                eo2 = BigInteger.valueOf(Long.parseLong(atom2.getName()));
                            }
                            catch (Exception ex){
                                eo2 = BigInteger.ZERO;
                            }
                            break;
                        case ENUM:
                            try {
                                eo2 = eSF.getEType().eContents().stream()
                                        .filter(e -> {
                                            return e instanceof EEnumLiteral && ((EEnumLiteral) e).getName().equals(atom2.getName());
                                        })
                                        .findFirst().orElse(null);
                            }
                            catch (Exception ignored){}
                    }

                    if (eo2 == null) {
                        System.out.println("Couldn't determine " + atom2 + "'s value!");
                        return;
                    }

                    if (eo1.eGet(eSF) instanceof EList) {
                        EList eList = (EList) eo1.eGet(eSF);
                        if (!eList.contains(eo2)) {
                            eList.add(eo2);
                        }
                    }
                    else if (!eo2.equals(eo1.eGet(eSF))) {
                        eo1.eSet(eSF, eo2);
                    }
                }

            });
        });
    }

}
