package eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

public class PreferencesInstanceState implements InstanceState {

  private static final String MAIN_NODE = "eu.modelwriter.core.alloyinecore.ui";
  private static final String REPLACEMENT = "[?!?]";
  private static final String SATISFIABLE = "satisfiable";
  private static final String VISUALIZE = "visualize";
  private static final String ATOMS = "atoms";
  private static final String RELATIONS = "relations";
  private static final String WITNESSES = "witnesses";
  private static final String WITNESS_RELATIONS = "witnessrelations";
  private static final String INFERRED_WITNESSES = "inferredwitnesses";
  private static final String HIDDEN_TUPLES = "hiddentuples";
  private static final String MODEL_REFERENCES = "modelreferences";
  private static final String MODEL_ATTRIBUTES = "modelattributes";
  private static final String ATTRIBUTE_ATOMS = "attributeatoms";

  private static PreferencesInstanceState pis = null;

  private IEclipsePreferences preferences;
  private Preferences filePreferences;
  private String nodeName;

  public PreferencesInstanceState(String nodeName) {
    preferences = InstanceScope.INSTANCE.getNode(MAIN_NODE);
    nodeName = nodeName.replace("/", REPLACEMENT);
    filePreferences = preferences.node(nodeName);
    this.nodeName = nodeName;
  }

  public static PreferencesInstanceState getDefault() {
    if (pis == null)
      pis = new PreferencesInstanceState("default");
    return pis;
  }

  @Override
  public void restore() {
    Preferences backup_preferences = preferences.node(nodeName + "_backup");

    try {
      filePreferences.removeNode();
      filePreferences = preferences.node(nodeName);

      copy(filePreferences, backup_preferences);
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void backup() {
    Preferences backup_preferences = preferences.node(nodeName + "_backup");
    try {
      backup_preferences.removeNode();
      backup_preferences = preferences.node(nodeName + "_backup");

      copy(backup_preferences, filePreferences);
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  private void copy(Preferences to, Preferences from) throws BackingStoreException {
    for (String key : from.keys()) {
      to.put(key, from.get(key, ""));
    }

    for (String child : from.childrenNames()) {
      copy(to.node(child), from.node(child));
    }
  }

  @Override
  public void saveWitnesses(Set<EObject> eObjects) {
    Preferences witnesses = filePreferences.node(WITNESSES);

    eObjects.forEach(eo -> {
      try {
        witnesses.put(WITNESSES + witnesses.keys().length, getURIString(eo));
      } catch (BackingStoreException e1) {
        e1.printStackTrace();
      }
    });
  }

  @Override
  public void saveWitnessRelations(
      Map<EObject, Map<EStructuralFeature, Set<EObject>>> witnessRelations) {
    // TODO Auto-generated method stub
    Preferences relations = filePreferences.node(WITNESS_RELATIONS);

    witnessRelations.forEach((eo1, map) -> {
      Preferences peo1 = relations.node(getURIString(eo1));
      map.forEach((sf, eos) -> {
        Preferences psf = peo1.node(sf.getFeatureID() + "");
        eos.forEach(eo2 -> {
          try {
            psf.put(sf.getName() + psf.keys().length, getURIString(eo2));
          } catch (BackingStoreException e) {
            e.printStackTrace();
          }
        });
      });
    });
  }

  @Override
  public void saveInferredEObjects(Set<EObject> eObjects) {
    Preferences atoms = filePreferences.node(ATOMS);

    eObjects.forEach(eo -> {
      try {
        atoms.put(ATOMS + atoms.keys().length, getURIString(eo));
      } catch (BackingStoreException e1) {
        e1.printStackTrace();
      }
    });

  }

  @Override
  public void saveInferredRelations(
      Map<EObject, Map<EStructuralFeature, Set<EObject>>> inferredRelations) {

    Preferences relations = filePreferences.node(RELATIONS);

    inferredRelations.forEach((eo1, map) -> {
      Preferences peo1 = relations.node(getURIString(eo1));
      map.forEach((sf, eos) -> {
        Preferences psf = peo1.node(sf.getFeatureID() + "");
        eos.forEach(eo2 -> {
          try {
            psf.put(sf.getName() + psf.keys().length, getURIString(eo2));
          } catch (BackingStoreException e) {
            e.printStackTrace();
          }
        });
      });
    });
  }

  @Override
  public void saveInferredWitnesses(Map<String, String> inferredWitnesses) {
    Preferences iw = filePreferences.node(INFERRED_WITNESSES);


    inferredWitnesses.forEach((atom, type) -> {
      iw.put(atom, type);
    });

  }

  @Override
  public void saveHiddenTuples(Map<String, Set<String>> hiddenTuples) {
    Preferences ht = filePreferences.node(HIDDEN_TUPLES);

    hiddenTuples.forEach((relName, tuples) -> {
      Preferences ts = ht.node(relName);
      tuples.forEach(tuple -> {
        ts.put(tuple, "");
      });
    });
  }

  @Override
  public void saveModelAttributes(
      Map<EObject, Map<EStructuralFeature, Set<String>>> modelRelations) {

    Preferences relations = filePreferences.node(MODEL_ATTRIBUTES);

    modelRelations.forEach((eo1, map) -> {
      Preferences peo1 = relations.node(getURIString(eo1));
      map.forEach((sf, eos) -> {
        Preferences psf = peo1.node(sf.getName());
        eos.forEach(eo2 -> {
          try {
            psf.put(sf.getName() + psf.keys().length, eo2);
          } catch (BackingStoreException e) {
            e.printStackTrace();
          }
        });
      });
    });
  }

  @Override
  public Map<EObject, Map<EStructuralFeature, Set<String>>> getModelAttributes(
      Set<EObject> lookIn) {

    Map<EObject, Map<EStructuralFeature, Set<String>>> modelRelations = new HashMap<>();

    Preferences relations = filePreferences.node(MODEL_ATTRIBUTES);

    try {
      Arrays.asList(relations.childrenNames()).forEach(eoUri1 -> {
        EObject eo1 = getEObject(eoUri1, lookIn);

        if (eo1 == null)
          return;

        Map<EStructuralFeature, Set<String>> sfMap =
            modelRelations.computeIfAbsent(eo1, e -> new HashMap<>());

        Preferences childEo1 = relations.node(eoUri1);
        try {
          Arrays.asList(childEo1.childrenNames()).forEach(sfChild -> {
            EStructuralFeature sf =
                eo1.eClass().getEAnnotations().stream().flatMap(e -> e.getContents().stream())
                    .filter(rel -> rel instanceof EStructuralFeature
                        && ((EStructuralFeature) rel).getName().equals(sfChild))
                    .map(rel -> (EStructuralFeature) rel).findFirst().orElse(null);

            if (sf == null) {
              sf = eo1.eClass().getEAllSuperTypes().stream()
                  .flatMap(e -> e.getEAnnotations().stream()).flatMap(e -> e.getContents().stream())
                  .filter(rel -> rel instanceof EStructuralFeature
                      && ((EStructuralFeature) rel).getName().equals(sfChild))
                  .map(rel -> (EStructuralFeature) rel).findFirst().orElse(null);
            }
            if (sf == null)
              return;

            Set<String> eoSet = sfMap.computeIfAbsent(sf, e -> new HashSet<>());

            Preferences childSf = childEo1.node(sfChild);
            try {
              Arrays.asList(childSf.keys()).forEach(keysf -> {
                String eo2 = childSf.get(keysf, "");

                if (eo2 == null)
                  return;

                eoSet.add(eo2);
              });
            } catch (BackingStoreException e) {
              e.printStackTrace();
            }
          });
        } catch (BackingStoreException e) {
          e.printStackTrace();
        }
      });
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    return modelRelations;
  }

  @Override
  public void saveModelReferences(
      Map<EObject, Map<EStructuralFeature, Set<EObject>>> modelRelations) {

    Preferences relations = filePreferences.node(MODEL_REFERENCES);

    modelRelations.forEach((eo1, map) -> {
      Preferences peo1 = relations.node(getURIString(eo1));
      map.forEach((sf, eos) -> {
        Preferences psf = peo1.node(sf.getName());
        eos.forEach(eo2 -> {
          try {
            psf.put(sf.getName() + psf.keys().length, getURIString(eo2));
          } catch (BackingStoreException e) {
            e.printStackTrace();
          }
        });
      });
    });
  }

  @Override
  public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getModelReferences(
      Set<EObject> lookIn) {

    Map<EObject, Map<EStructuralFeature, Set<EObject>>> modelRelations = new HashMap<>();

    Preferences relations = filePreferences.node(MODEL_REFERENCES);

    try {
      Arrays.asList(relations.childrenNames()).forEach(eoUri1 -> {
        EObject eo1 = getEObject(eoUri1, lookIn);

        if (eo1 == null)
          return;

        Map<EStructuralFeature, Set<EObject>> sfMap =
            modelRelations.computeIfAbsent(eo1, e -> new HashMap<>());

        Preferences childEo1 = relations.node(eoUri1);
        try {
          Arrays.asList(childEo1.childrenNames()).forEach(sfChild -> {
            EStructuralFeature sf =
                eo1.eClass().getEAnnotations().stream().flatMap(e -> e.getContents().stream())
                    .filter(rel -> rel instanceof EStructuralFeature
                        && ((EStructuralFeature) rel).getName().equals(sfChild))
                    .map(rel -> (EStructuralFeature) rel).findFirst().orElse(null);

            if (sf == null) {
              sf = eo1.eClass().getEAllSuperTypes().stream()
                  .flatMap(e -> e.getEAnnotations().stream()).flatMap(e -> e.getContents().stream())
                  .filter(rel -> rel instanceof EStructuralFeature
                      && ((EStructuralFeature) rel).getName().equals(sfChild))
                  .map(rel -> (EStructuralFeature) rel).findFirst().orElse(null);
            }
            if (sf == null)
              return;

            Set<EObject> eoSet = sfMap.computeIfAbsent(sf, e -> new HashSet<>());

            Preferences childSf = childEo1.node(sfChild);
            try {
              Arrays.asList(childSf.keys()).forEach(keysf -> {
                EObject eo2 = getEObject(childSf.get(keysf, ""), lookIn);

                if (eo2 == null)
                  return;

                eoSet.add(eo2);
              });
            } catch (BackingStoreException e) {
              e.printStackTrace();
            }
          });
        } catch (BackingStoreException e) {
          e.printStackTrace();
        }
      });
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    return modelRelations;
  }

  @Override
  public Map<String, Set<String>> gethiddenTuples() {
    Map<String, Set<String>> hiddenTuples = new HashMap<>();

    Preferences ht = filePreferences.node(HIDDEN_TUPLES);

    try {
      Arrays.asList(ht.childrenNames()).forEach(relName -> {
        Set<String> set = hiddenTuples.computeIfAbsent(relName, e -> new HashSet<>());
        Preferences ts = ht.node(relName);
        try {
          set.addAll(Arrays.asList(ts.keys()));
        } catch (BackingStoreException e1) {
          e1.printStackTrace();
        }
      });
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    return hiddenTuples;
  }

  @Override
  public void clearHiddenTuples() {
    Preferences ht = filePreferences.node(HIDDEN_TUPLES);

    try {
      ht.removeNode();
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public Map<String, String> getInferredWitnesses() {
    Map<String, String> inferredWitnesses = null;

    Preferences iw = filePreferences.node(INFERRED_WITNESSES);

    try {
      inferredWitnesses = Arrays.asList(iw.keys()).stream()
          .collect(Collectors.toMap(key -> key, key -> iw.get(key, "")));
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    return inferredWitnesses == null ? Collections.EMPTY_MAP : inferredWitnesses;
  }


  @SuppressWarnings("unchecked")
  @Override
  public Set<EObject> getInferredEObjects(Set<EObject> lookIn) {
    Preferences atoms = filePreferences.node(ATOMS);

    try {
      return Arrays.asList(atoms.keys()).stream().map(key -> atoms.get(key, ""))
          .map(uriStr -> getEObject(uriStr, lookIn)).filter(eo -> eo != null)
          .collect(Collectors.toSet());
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    return Collections.EMPTY_SET;
  }

  @Override
  public Set<EObject> getWitnesses(Set<EObject> lookIn) {
    Preferences witnesses = filePreferences.node(WITNESSES);

    try {
      return Arrays.asList(witnesses.keys()).stream().map(key -> witnesses.get(key, ""))
          .map(uriStr -> getEObject(uriStr, lookIn)).filter(eo -> eo != null)
          .collect(Collectors.toSet());
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    return Collections.emptySet();
  }

  @Override
  public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getInferredRelations(
      Set<EObject> lookIn) {

    Map<EObject, Map<EStructuralFeature, Set<EObject>>> inferredRelations = new HashMap<>();

    Preferences relations = filePreferences.node(RELATIONS);

    try {
      Arrays.asList(relations.childrenNames()).forEach(eoUri1 -> {
        EObject eo1 = getEObject(eoUri1, lookIn);

        if (eo1 == null)
          return;

        Map<EStructuralFeature, Set<EObject>> sfMap =
            inferredRelations.computeIfAbsent(eo1, e -> new HashMap<>());

        Preferences childEo1 = relations.node(eoUri1);
        try {
          Arrays.asList(childEo1.childrenNames()).forEach(sfChild -> {
            EStructuralFeature sf = eo1.eClass().getEStructuralFeature(Integer.parseInt(sfChild));

            if (sf == null)
              return;

            Set<EObject> eoSet = sfMap.computeIfAbsent(sf, e -> new HashSet<>());

            Preferences childSf = childEo1.node(sfChild);
            try {
              Arrays.asList(childSf.keys()).forEach(keysf -> {
                EObject eo2 = getEObject(childSf.get(keysf, ""), lookIn);

                if (eo2 == null)
                  return;

                eoSet.add(eo2);
              });
            } catch (BackingStoreException e) {
              e.printStackTrace();
            }
          });
        } catch (BackingStoreException e) {
          e.printStackTrace();
        }
      });
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    return inferredRelations;
  }

  @Override
  public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getWitnessRelations(
      Set<EObject> lookIn) {

    Map<EObject, Map<EStructuralFeature, Set<EObject>>> witnessRelations = new HashMap<>();

    Preferences relations = filePreferences.node(WITNESS_RELATIONS);

    try {
      Arrays.asList(relations.childrenNames()).forEach(eoUri1 -> {
        EObject eo1 = getEObject(eoUri1, lookIn);

        if (eo1 == null)
          return;

        Map<EStructuralFeature, Set<EObject>> sfMap =
            witnessRelations.computeIfAbsent(eo1, e -> new HashMap<>());

        Preferences childEo1 = relations.node(eoUri1);
        try {
          Arrays.asList(childEo1.childrenNames()).forEach(sfChild -> {
            EStructuralFeature sf = eo1.eClass().getEStructuralFeature(Integer.parseInt(sfChild));

            if (sf == null)
              return;

            Set<EObject> eoSet = sfMap.computeIfAbsent(sf, e -> new HashSet<>());

            Preferences childSf = childEo1.node(sfChild);
            try {
              Arrays.asList(childSf.keys()).forEach(keysf -> {
                EObject eo2 = getEObject(childSf.get(keysf, ""), lookIn);

                if (eo2 == null)
                  return;

                eoSet.add(eo2);
              });
            } catch (BackingStoreException e) {
              e.printStackTrace();
            }
          });
        } catch (BackingStoreException e) {
          e.printStackTrace();
        }
      });
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    return witnessRelations;
  }

  private EObject getEObject(String uri, Set<EObject> lookIn) {
    return lookIn.stream().filter(e -> getURIString(e).equals(uri)).findFirst().orElse(null);
  }

  private String getURIString(EObject eo) {
    return EcoreUtil.getURI(eo).fragment().replace("/", REPLACEMENT);
  }

  @Override
  public void removeAllNodes() {
    try {
      for (String node : preferences.childrenNames())
        preferences.node(node).removeNode();
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void removeSubNode() {
    try {
      filePreferences.removeNode();
    } catch (BackingStoreException e2) {
      e2.printStackTrace();
    }
  }

  @Override
  public void createSubNode() {
    filePreferences = preferences.node(nodeName);
  }

  @Override
  public void emptySubNode() {
    removeSubNode();
    createSubNode();
  }

  @Override
  public void saveSatisfiable(boolean satisfiable) {
    filePreferences.putBoolean(SATISFIABLE, satisfiable);
  }

  @Override
  public void saveVisualize(boolean visualize) {
    filePreferences.putBoolean(VISUALIZE, visualize);
  }

  @Override
  public boolean isSatisfiable() {
    return filePreferences.getBoolean(SATISFIABLE, false);
  }

  @Override
  public boolean shouldVisualize() {
    return filePreferences.getBoolean(VISUALIZE, false);
  }

  @Override
  public void flush() {
    try {
      preferences.flush();
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void clearSatisfiable() {
    filePreferences.remove(SATISFIABLE);
  }

  @Override
  public void clearVisualize() {
    filePreferences.remove(VISUALIZE);
  }

  @Override
  public void clearWitnesses() {
    Preferences ht = filePreferences.node(WITNESSES);
    Preferences at = filePreferences.node(WITNESS_RELATIONS);

    try {
      ht.removeNode();
      at.removeNode();
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void clearInferreds() {
    Preferences ht = filePreferences.node(RELATIONS);
    Preferences at = filePreferences.node(ATOMS);

    try {
      ht.removeNode();
      at.removeNode();
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void clearModels() {
    Preferences ht = filePreferences.node(MODEL_REFERENCES);

    try {
      ht.removeNode();
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    Preferences ht2 = filePreferences.node(MODEL_ATTRIBUTES);

    try {
      ht2.removeNode();
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void clearInferredWitnesses() {
    Preferences ht = filePreferences.node(INFERRED_WITNESSES);

    try {
      ht.removeNode();
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void clearAttributeAtoms() {
    Preferences ht = filePreferences.node(ATTRIBUTE_ATOMS);

    try {
      ht.removeNode();
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void saveAttributeAtoms(Set<EObject> eObjects) {
    Preferences atoms = filePreferences.node(ATTRIBUTE_ATOMS);

    eObjects.forEach(eo -> {
      try {
        atoms.put(ATTRIBUTE_ATOMS + atoms.keys().length, getURIString(eo));
      } catch (BackingStoreException e1) {
        e1.printStackTrace();
      }
    });
  }

  @SuppressWarnings("unchecked")
  @Override
  public Set<EObject> getAttributeAtoms(Set<EObject> lookIn) {
    Preferences atoms = filePreferences.node(ATTRIBUTE_ATOMS);

    try {
      return Arrays.asList(atoms.keys()).stream().map(key -> atoms.get(key, ""))
          .map(uriStr -> getEObject(uriStr, lookIn)).filter(eo -> eo != null)
          .collect(Collectors.toSet());
    } catch (BackingStoreException e) {
      e.printStackTrace();
    }

    return Collections.EMPTY_SET;
  }

}
