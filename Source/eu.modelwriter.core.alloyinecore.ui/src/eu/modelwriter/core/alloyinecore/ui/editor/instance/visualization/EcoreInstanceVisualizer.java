package eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.ResourceUtil;
import edu.mit.csail.sdg.alloy4.ErrorFatal;
import eu.modelwriter.core.alloyinecore.ui.Activator;
import eu.modelwriter.core.alloyinecore.ui.Workarounds;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Atom;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Relation;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Tuple;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.model.Universe;

public class EcoreInstanceVisualizer extends InstanceVisualizer {

  private Map<EObject, Relation> relationMap;
  private Map<EObject, Atom> object2atom;
  private Map<Atom, IMarker> atom2marker;

  private Map<String, Relation> attributeRelationMap;
  private Map<String, Atom> datatype2atom;

  private Set<Tuple> hiddenTuples;

  Relation InferredWitnessType = null;

  Resource resource;

  Map<EObject, Map<EStructuralFeature, Set<EObject>>> modelReferences;
  Map<EObject, Map<EStructuralFeature, Set<String>>> modelAttributes;

  PreferencesInstanceState instanceState;

  final String reflectiveEditorID = "org.eclipse.emf.ecore.presentation.ReflectiveEditorID";

  public EcoreInstanceVisualizer(IEditorInput input) throws ErrorFatal, IOException {
    super(input);
  }

  @Override
  protected void createUniverse() throws IOException {
    relationMap = new HashMap<>();
    object2atom = new HashMap<>();
    atom2marker = new HashMap<>();
    datatype2atom = new HashMap<>();
    attributeRelationMap = new HashMap<>();
    hiddenTuples = new HashSet<>();

    this.universe = new Universe();

    resource = getResource();

    instanceState = new PreferencesInstanceState(input.getAdapter(File.class).getAbsolutePath());

    visitAtom(resource.getContents().get(0));

    getModelReferences();
    getModelAttributes();
    setHiddenTuples();
    markInferreds();
    setAttributeAtoms();

    relationMap.values().forEach(e -> {
      universe.addRelation(e);
    });

    attributeRelationMap.values().forEach(e -> {
      universe.addRelation(e);
    });

    setMarkers();

    if (InferredWitnessType != null)
      universe.addRelation(InferredWitnessType);
  }

  private void setMarkers() {
    final IResource resource = ResourceUtil.getResource(input);

    object2atom.keySet().forEach(eo -> {
      Atom atom = object2atom.get(eo);
      // Create the Marker to list the inferred EObjects in Markers View.
      try {
        IMarker marker;
        if (atom2marker.containsKey(atom)) {
          marker = atom2marker.get(atom);
        } else {
          marker = resource
              .createMarker("eu.modelwriter.core.alloyinecore.ui.editor.visualizationmarker");
          atom2marker.put(atom, marker);
        }
        marker.setAttribute(IMarker.MESSAGE, atom.getText());
        marker.setAttribute(IDE.EDITOR_ID_ATTR, reflectiveEditorID);
        marker.setAttribute("uri", EcoreUtil.getURI(eo).toString());
        atom2marker.put(atom, marker);
      } catch (CoreException e) {
        e.printStackTrace();
      }
    });
  }

  private void getModelReferences() {
    modelReferences = instanceState.getModelReferences(object2atom.keySet());

    modelReferences.forEach((eo1, sfMap) -> {
      Atom atom1 = object2atom.get(eo1);

      sfMap.forEach((sf, eoSet) -> {
        Relation rel = relationMap.computeIfAbsent(sf, e -> {
          Relation r = new Relation(sf.getName());
          r.setParent(atom1.getLocatedIn());
          if (sf instanceof EAttribute)
            r.setAttribute(true);
          return r;
        });

        eoSet.forEach(eo2 -> {
          Atom atom2 = object2atom.get(eo2);
          Tuple tuple = new Tuple(rel.getName());
          tuple.addAtom(atom1);
          tuple.addAtom(atom2);
          tuple.setRelation(rel);
          tuple.setInferred(true);
          rel.addTuple(tuple);
        });
      });
    });
  }

  private void getModelAttributes() {
    modelAttributes = instanceState.getModelAttributes(object2atom.keySet());

    modelAttributes.forEach((eo1, sfMap) -> {
      Atom atom1 = object2atom.get(eo1);

      sfMap.forEach((sf, atomSet) -> {
        if (!(sf instanceof EAttribute))
          return;

        Relation rel = relationMap.computeIfAbsent(sf, e -> {
          Relation r = new Relation(sf.getName());
          r.setParent(atom1.getLocatedIn());
          if (sf instanceof EAttribute)
            r.setAttribute(true);
          return r;
        });

        atomSet.forEach(a -> {
          Atom atom2 = getAttributeAtom(a);
          Tuple tuple = new Tuple(rel.getName());
          tuple.addAtom(atom1);
          tuple.addAtom(atom2);
          tuple.setRelation(rel);
          tuple.setInferred(true);
          rel.addTuple(tuple);
        });
      });
    });
  }

  private void setHiddenTuples() {
    Map<String, Set<String>> hiddens = instanceState.gethiddenTuples();

    Iterator<Tuple> iteratorTuples =
        relationMap.values().stream().flatMap(r -> r.getTuples().stream()).iterator();

    while (iteratorTuples.hasNext()) {
      Tuple t = iteratorTuples.next();
      String relName = (t.getAtomCount() == 2 ? t.getRelation().getParent().getName() + "_" : "")
          + t.getRelation().getName();

      if (hiddens.getOrDefault(relName, Collections.emptySet()).contains(t.toString())) {
        t.getRelation().getTuples().remove(t);
        hiddenTuples.add(t);

        if (t.getArity() == 1) {
          relationMap.values().forEach(rel -> {
            Iterator<Tuple> tuples = rel.getTuples().iterator();

            while (tuples.hasNext()) {
              Tuple tuple = tuples.next();
              if (tuple.contains(t.getAtom(0))) {
                tuples.remove();
                hiddenTuples.add(tuple);
              }
            }
          });
        }
      }
    }
  }

  private void setAttributeAtoms() {
    Set<EObject> attributeAtoms = instanceState.getAttributeAtoms(object2atom.keySet());

    attributeAtoms.forEach(eo -> {
      Atom atom = object2atom.getOrDefault(eo, null);
      if (atom == null)
        return;
      setAtomAsAttribute(atom);
    });

    updateAttributeAtomsInPreferences();
  }

  private void markInferreds() {
    boolean satisfiable = instanceState.isSatisfiable();
    boolean visualize = instanceState.shouldVisualize();

    if (satisfiable && visualize) {

      Set<EObject> inferredEObjects = instanceState.getInferredEObjects(object2atom.keySet());

      inferredEObjects.forEach(eo -> {
        Atom atom = object2atom.getOrDefault(eo, null);
        if (atom == null)
          return;
        atom.setInferred(true);
      });

      instanceState.getInferredRelations(object2atom.keySet()).forEach((eo1, sfMap) -> {
        Atom atom1 = object2atom.get(eo1);

        sfMap.forEach((sf, eoSet) -> {
          Relation relation = relationMap.get(sf);

          eoSet.forEach(eo2 -> {
            Atom atom2 = object2atom.get(eo2);
            if (relation != null)
              relation.getTuples().stream()
                  .filter(t -> t.getAtom(0).equals(atom1) && t.getAtom(1).equals(atom2))
                  .forEach(t -> t.setInferred(true));
          });
        });
      });
    }
    if (!satisfiable && visualize) {
      Set<EObject> witnessEObjects = instanceState.getWitnesses(object2atom.keySet());
      Map<String, String> inferredWitnesses = instanceState.getInferredWitnesses();
      Map<EObject, Map<EStructuralFeature, Set<EObject>>> witnessRelations =
          instanceState.getWitnessRelations(object2atom.keySet());

      witnessEObjects.forEach(eo -> {
        Atom atom = object2atom.getOrDefault(eo, null);
        if (atom == null)
          return;
        atom.setWitness(true);
      });

      /*
       * TO SHOW THE INFERRED WITNESS ATOMS
       * 
       * inferredWitnesses.forEach((name, type) -> { if (InferredWitnessType == null)
       * InferredWitnessType = new Relation("Inferred Witness");
       * 
       * Atom atom = new Atom(name); atom.setLocatedIn(InferredWitnessType); atom.setWitness(true);
       * InferredWitnessType.addAtomWithTuple(atom); });
       */

      witnessRelations.forEach((eo1, sfMap) -> {
        Atom atom1 = object2atom.get(eo1);

        sfMap.forEach((sf, eoSet) -> {
          Relation relation = relationMap.get(sf);

          eoSet.forEach(eo2 -> {
            Atom atom2 = object2atom.get(eo2);
            if (relation != null)
              relation.getTuples().stream()
                  .filter(t -> t.getAtom(0).equals(atom1) && t.getAtom(1).equals(atom2))
                  .forEach(t -> t.setWitness(true));
          });
        });
      });
    }
  }

  private void visitAtom(EObject eobject) {
    Relation type = relationMap.computeIfAbsent(eobject.eClass(),
        e -> new Relation(eobject.eClass().getName()));

    Atom atom = getAtom(eobject);

    eobject.eClass().getEAllStructuralFeatures().forEach(sf -> {
      if (sf.getEAnnotations().stream().anyMatch(ea -> ea.getSource().contains("ghost")))
        return;
      if (eobject.eGet(sf) instanceof EList<?>) {
        if (((EList<?>) eobject.eGet(sf)).isEmpty())
          return;

        Relation rel = relationMap.computeIfAbsent(sf, e -> {
          Relation r = new Relation(sf.getName());
          r.setParent(type);
          if (sf instanceof EAttribute)
            r.setAttribute(true);
          return r;
        });

        ((EList<?>) eobject.eGet(sf)).forEach(eo -> {
          Atom target = eo instanceof EObjectImpl ? getAtom((EObject) eo) : getAttributeAtom(eo);
          Tuple tuple = new Tuple(rel.getName());
          tuple.addAtom(atom);
          tuple.addAtom(target);
          tuple.setRelation(rel);
          rel.addTuple(tuple);
        });
      } else if (eobject.eGet(sf) != null) {
        Relation rel = relationMap.computeIfAbsent(sf, e -> {
          Relation r = new Relation(sf.getName());
          r.setParent(type);
          if (sf instanceof EAttribute)
            r.setAttribute(true);
          return r;
        });

        Object eo = eobject.eGet(sf);

        Atom target = eo instanceof EObjectImpl ? getAtom((EObject) eo) : getAttributeAtom(eo);
        Tuple tuple = new Tuple(rel.getName());
        tuple.addAtom(atom);
        tuple.addAtom(target);
        tuple.setRelation(rel);
        rel.addTuple(tuple);
      }

    });

    eobject.eContents().forEach(e -> visitAtom(e));
  }

  private Atom getAttributeAtom(Object object) {
    return datatype2atom.computeIfAbsent(object.toString(), e -> {
      Relation type = attributeRelationMap.computeIfAbsent(object.getClass().getName(), f -> {
        Relation rel = new Relation(object.getClass().getName());
        rel.setAttribute(true);
        return rel;
      });

      Atom atom = new Atom(object.toString());
      atom.setLocatedIn(type);
      Tuple tuple = new Tuple(atom.getText());
      tuple.addAtom(atom);
      tuple.setRelation(type);
      type.addTuple(tuple);

      return atom;
    });
  }

  private Atom getAtom(EObject eo) {
    return object2atom.computeIfAbsent(eo, e -> {

      Relation type =
          relationMap.computeIfAbsent(eo.eClass(), f -> new Relation(eo.eClass().getName()));

      Atom atom = new Atom(eo.eClass().getName() + "$" + type.getTupleCount());
      atom.setLocatedIn(type);
      Tuple tuple = new Tuple(atom.getText());
      tuple.addAtom(atom);
      tuple.setRelation(type);
      type.addTuple(tuple);

      return atom;
    });
  }

  private EObject getEObject(Atom atom) {
    return object2atom.entrySet().stream().filter(e -> e.getValue().equals(atom))
        .map(e -> e.getKey()).findFirst().orElse(null);
  }

  private EStructuralFeature getSF(Relation relation) {
    return (EStructuralFeature) relationMap.entrySet().stream()
        .filter(e -> e.getValue().equals(relation)).map(e -> e.getKey()).findFirst().orElse(null);
  }

  private Resource getResource() throws IOException {
    ResourceSet rs = new ResourceSetImpl();
    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
        new EcoreResourceFactoryImpl());
    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new XMIResourceFactoryImpl());

    Resource res = rs.getResource(
        URI.createPlatformResourceURI(ResourceUtil.getFile(input).getFullPath().toString(), true),
        true);
    res.load(Collections.emptyMap());

    return res;
  }

  public static IEditorPart openMarkerInEditor(IMarker marker, IWorkbenchPage page) {
    IEditorPart editor = page.getActiveEditor();
    if (editor != null) {
      IEditorInput input = editor.getEditorInput();
      IFile file = ResourceUtil.getFile(input);

      if (file != null) {
        if (marker.getResource().equals(file) && OpenStrategy.activateOnOpen()) {
          page.activate(editor);
        }
      }
    }

    if (marker != null && marker.getResource() instanceof IFile) {
      try {
        return IDE.openEditor(page, marker, OpenStrategy.activateOnOpen());
      } catch (PartInitException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  protected void doubleClickedOn(Atom atom) {
    URI uri = EcoreUtil.getURI(getEObject(atom));
    final IResource resource = ResourceUtil.getResource(input);
    // asycnsExec!!
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          IMarker marker;

          marker = resource
              .createMarker("eu.modelwriter.core.alloyinecore.ui.editor.visualizationmarker");
          atom2marker.put(atom, marker);

          marker.setAttribute(IDE.EDITOR_ID_ATTR, reflectiveEditorID);
          marker.setAttribute("uri", uri.toString());

          // IDE.openEditor(Activator.getActiveWorkbenchWindow().getActivePage(), marker, true);
          IEditorPart part =
              openMarkerInEditor(marker, Activator.getActiveWorkbenchWindow().getActivePage());

          marker.delete();
          System.out.println(
              PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceFocus());
          part.setFocus();

          Workarounds.doubleAltKeyPressed();

        } catch (CoreException e) {
          e.printStackTrace();
        }
      }
    });
  }

  Object selected = null;

  @Override
  protected void createGraph() throws ErrorFatal {
    super.createGraph();

    final JMenuItem showHiddenAtoms = new JMenuItem("Show Hidden Objects");
    final JMenuItem hide = new JMenuItem("Hide");
    final JMenuItem remove = new JMenuItem("Delete");
    final JMenuItem showAsAttribute = new JMenuItem("Show as Attribute");
    final JMenu forcedAttributes = new JMenu("Attribute Atoms");
    final JMenu deleteAttribute = new JMenu("Delete Attribute");

    showHiddenAtoms.setVisible(true);
    showHiddenAtoms.setEnabled(!hiddenTuples.isEmpty());
    hide.setVisible(false);
    remove.setVisible(false);
    showAsAttribute.setVisible(false);
    forcedAttributes.setVisible(object2atom.values().stream().anyMatch(a -> a.isForcedAttribute()));
    deleteAttribute.setVisible(false);

    object2atom.values().stream().filter(a -> a.isForcedAttribute()).forEach(a -> {
      JMenuItem atomMenuItem = new JMenuItem(a.getText());

      atomMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          a.setForcedAttribute(false);

          updateAttributeAtomsInPreferences();

          relationMap.values().stream().flatMap(r -> r.getTuples().stream())
              .filter(t -> t.getAtom(t.getAtomCount() - 1).equals(a))
              .forEach(t -> t.setForcedAttribute(false));


          try {
            createGraph();
            runChangeListeners();
          } catch (ErrorFatal e1) {
            e1.printStackTrace();
          }

        }
      });

      atomMenuItem.setVisible(true);

      forcedAttributes.add(atomMenuItem);
    });

    panel.pop.add(hide);
    panel.pop.add(remove);
    panel.pop.add(forcedAttributes);
    panel.pop.add(showHiddenAtoms);
    panel.pop.add(showAsAttribute);
    panel.pop.add(deleteAttribute);

    hide.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (selected != null) {

          setHidden(selected);

          try {
            createGraph();
            runChangeListeners();
          } catch (ErrorFatal e1) {
            e1.printStackTrace();
          }
        }
      }
    });

    remove.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (selected != null) {

          remove(selected);

          try {
            createGraph();
            runChangeListeners();
          } catch (ErrorFatal e1) {
            e1.printStackTrace();
          }

        }
      }
    });

    showHiddenAtoms.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        hiddenTuples.forEach(tuple -> {
          tuple.getRelation().addTuple(tuple);
        });

        hiddenTuples.clear();

        instanceState.clearHiddenTuples();

        try {
          createGraph();
          runChangeListeners();
        } catch (ErrorFatal e1) {
          e1.printStackTrace();
        }
      }
    });

    showAsAttribute.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (!(selected instanceof Atom))
          return;

        Atom atom = (Atom) selected;

        setAtomAsAttribute(atom);

        updateAttributeAtomsInPreferences();

        try {
          createGraph();
          runChangeListeners();
        } catch (ErrorFatal e1) {
          e1.printStackTrace();
        }
      }
    });

    panel.addMouseListener(new MouseAdapter() {

      @Override
      public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        selected = panel.alloyGetAnnotationAtXY(e.getX(), e.getY());

        deleteAttribute.removeAll();

        if (selected != null) {
          hide.setVisible(true);
          remove.setVisible(!selected.equals(object2atom.get(resource.getContents().get(0))));
          showAsAttribute.setVisible(selected instanceof Atom && relationMap.values().stream()
              .flatMap(r -> r.getTuples().stream()).filter(t -> t.getArity() == 2)
              .anyMatch(t -> t.getAtom(1).equals(selected) && !t.getAtom(0).equals(t.getAtom(1))));

          forcedAttributes.setVisible(false);
          showHiddenAtoms.setVisible(false);

          boolean hasAttribute = selected instanceof Atom
              && universe.getRelations().stream().flatMap(r -> r.getTuples().stream())
                  .filter(t -> t.getArity() == 2).anyMatch(t -> t.getAtom(0).equals(selected)
                      && (t.getAtom(1).isForcedAttribute() || t.getRelation().isAttribute()));

          deleteAttribute.setVisible(hasAttribute);

          if (hasAttribute) {
            universe.getRelations().stream().flatMap(r -> r.getTuples().stream())
                .filter(t -> t.getArity() == 2)
                .filter(t -> t.getAtom(0).equals(selected)
                    && (t.getAtom(1).isForcedAttribute() || t.getRelation().isAttribute()))
                .forEach(t -> {
                  Atom source = t.getAtom(0);
                  Atom target = t.getAtom(1);
                  Relation rel = t.getRelation();

                  JMenuItem atomMenuItem = new JMenuItem(rel.getName() + ": " + target.getText());

                  atomMenuItem.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                      if (selected != null) {
                        if (getEObject(target) != null)
                          removeEObject(source, rel, target);
                        else
                          removeAttribute(source, rel, target);
                      }
                    }
                  });

                  atomMenuItem.setVisible(true);

                  deleteAttribute.add(atomMenuItem);
                });
          }
        } else {
          hide.setVisible(false);
          remove.setVisible(false);
          showAsAttribute.setVisible(false);
          forcedAttributes
              .setVisible(object2atom.values().stream().anyMatch(a -> a.isForcedAttribute()));
          showHiddenAtoms.setVisible(true);
          deleteAttribute.setVisible(false);
        }
      }
    });
  }

  private void updateAttributeAtomsInPreferences() {
    InstanceState instanceState =
        new PreferencesInstanceState(input.getAdapter(File.class).getAbsolutePath());

    instanceState.clearAttributeAtoms();

    instanceState.saveAttributeAtoms(
        object2atom.entrySet().stream().filter(e -> e.getValue().isForcedAttribute())
            .map(e -> e.getKey()).collect(Collectors.toSet()));
  }

  private void setAtomAsAttribute(Atom atom) {
    if (atom == null)
      return;

    atom.setForcedAttribute(true);

    relationMap.values().stream().flatMap(r -> r.getTuples().stream())
        .filter(t -> t.getAtom(t.getAtomCount() - 1).equals(atom))
        .forEach(t -> t.setForcedAttribute(true));
  }

  private void remove(Object object) {
    if (object instanceof Atom) {
      Atom atom = (Atom) object;

      EObject eo = getEObject(atom);

      if (eo == null)
        return;

      modelReferences.remove(eo);
      modelReferences.forEach((o, map) -> map.values().forEach(set -> set.remove(eo)));

      InstanceState instanceState =
          new PreferencesInstanceState(input.getAdapter(File.class).getAbsolutePath());

      instanceState.clearModels();
      instanceState.saveModelReferences(modelReferences);
      instanceState.saveModelAttributes(modelAttributes);

      EcoreUtil.remove(eo);

      Display.getDefault().syncExec(new Runnable() {

        public void run() {
          try {
            resource.save(Collections.EMPTY_MAP);
          } catch (IOException e) {
            e.printStackTrace();
          }
        };

      });
    }
    if (object instanceof Tuple) {
      Tuple tuple = (Tuple) object;

      Relation rel = tuple.getRelation();

      if (tuple.getAtom(1) == null) {
        removeAttribute(tuple.getAtom(0), rel, tuple.getAtom(1));
      } else {
        removeEObject(tuple.getAtom(0), rel, tuple.getAtom(1));
      }
    }
  }

  private void removeAttribute(Atom source, Relation rel, Atom target) {
    EObject sourceObject = getEObject(source);

    if (sourceObject == null)
      return;

    EStructuralFeature sf = getSF(rel);

    if (sf == null)
      return;

    Set<String> set = modelAttributes.getOrDefault(sourceObject, new HashMap<>()).getOrDefault(sf,
        new HashSet<>());

    if (set.contains(target.getText())) {

      set.remove(target.getText());

      InstanceState instanceState =
          new PreferencesInstanceState(input.getAdapter(File.class).getAbsolutePath());

      instanceState.clearModels();
      instanceState.saveModelReferences(modelReferences);
      instanceState.saveModelAttributes(modelAttributes);
    }

    if (sourceObject.eClass().getEAllStructuralFeatures().contains(sf)) {
      if (FeatureMapUtil.isMany(sourceObject, sf)) {
        ((List<?>) sourceObject.eGet(sf)).removeIf(t -> target.getText().equals(t.toString()));
      } else {
        sourceObject.eUnset(sf);
      }
    }

    Display.getDefault().syncExec(new Runnable() {

      public void run() {
        try {
          resource.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
          e.printStackTrace();
        }
      };

    });
  }

  private void removeEObject(Atom source, Relation rel, Atom target) {
    EObject sourceObject = getEObject(source);
    EObject targetObject = getEObject(target);

    if (sourceObject == null || targetObject == null)
      return;

    EStructuralFeature sf = getSF(rel);

    if (sf == null)
      return;

    modelReferences.getOrDefault(sourceObject, new HashMap<>())
        .getOrDefault(sf, Collections.emptySet()).remove(targetObject);

    InstanceState instanceState =
        new PreferencesInstanceState(input.getAdapter(File.class).getAbsolutePath());

    instanceState.clearModels();
    instanceState.saveModelReferences(modelReferences);
    instanceState.saveModelAttributes(modelAttributes);

    if (sourceObject.eClass().getEAllStructuralFeatures().contains(sf)) {
      if (FeatureMapUtil.isMany(sourceObject, sf)) {
        ((List<?>) sourceObject.eGet(sf)).remove(targetObject);
      } else {
        sourceObject.eUnset(sf);
      }
    }

    Display.getDefault().syncExec(new Runnable() {

      public void run() {
        try {
          resource.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
          e.printStackTrace();
        }
      };

    });
  }

  private void setHidden(Object object) {
    PreferencesInstanceState instanceState =
        new PreferencesInstanceState(input.getAdapter(File.class).getAbsolutePath());

    Map<String, Set<String>> hiddens = new HashMap<>();

    if (object instanceof Atom) {
      Atom atom = (Atom) object;
      atom.setHidden(true);

      relationMap.values().forEach(rel -> {
        Iterator<Tuple> tuples = rel.getTuples().iterator();

        while (tuples.hasNext()) {
          Tuple tuple = tuples.next();
          if (tuple.contains(atom)) {
            tuples.remove();
            hiddenTuples.add(tuple);

            hiddens.computeIfAbsent(
                (tuple.getAtomCount() == 2 ? tuple.getRelation().getParent().getName() + "_" : "")
                    + tuple.getRelation().getName(),
                e -> new HashSet<>()).add(tuple.toString());
          }
        }
      });
    } else if (object instanceof Tuple) {
      Tuple tuple = (Tuple) object;
      tuple.getRelation().getTuples().remove(tuple);
      hiddenTuples.add(tuple);

      hiddens.computeIfAbsent(
          tuple.getRelation().getParent().getName() + "_" + tuple.getRelation().getName(),
          e -> new HashSet<>()).add(tuple.toString());
    }

    instanceState.saveHiddenTuples(hiddens);
  }


  private java.util.List<Runnable> changeListeners = new ArrayList<>();

  public void addChangeListener(Runnable runnable) {
    changeListeners.add(runnable);
  }

  public void removeChangeListener(Runnable runnable) {
    changeListeners.remove(runnable);
  }

  public void runChangeListeners() {
    for (Runnable r : changeListeners) {
      r.run();
    }
  }
}
