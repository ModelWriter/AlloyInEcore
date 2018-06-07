package eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization;

import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface InstanceState {

  public void clearSatisfiable();

  public void clearVisualize();

  public void clearWitnesses();

  public void clearInferreds();

  public void clearAttributeAtoms();

  public void clearInferredWitnesses();

  public void clearModels();

  public void saveSatisfiable(boolean satisfiable);

  public void saveVisualize(boolean visualize);

  void saveWitnesses(Set<EObject> eObjects);

  void saveInferredWitnesses(Map<String, String> inferredWitnesses);

  void saveWitnessRelations(Map<EObject, Map<EStructuralFeature, Set<EObject>>> witnessRelations);

  public void saveInferredEObjects(Set<EObject> eObjects);

  public void saveAttributeAtoms(Set<EObject> eObjects);

  public void saveInferredRelations(
      Map<EObject, Map<EStructuralFeature, Set<EObject>>> inferredRelations);

  public Set<EObject> getWitnesses(Set<EObject> lookIn);

  public Map<String, String> getInferredWitnesses();

  public Set<EObject> getInferredEObjects(Set<EObject> lookIn);

  public Set<EObject> getAttributeAtoms(Set<EObject> lookIn);

  public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getInferredRelations(
      Set<EObject> lookIn);

  public Map<EObject, Map<EStructuralFeature, Set<EObject>>> getWitnessRelations(
      Set<EObject> lookIn);

  public boolean isSatisfiable();

  public boolean shouldVisualize();

  public void removeAllNodes();

  public void removeSubNode();

  public void createSubNode();

  public void flush();

  public void emptySubNode();

  void saveHiddenTuples(Map<String, Set<String>> hiddenTuples);

  Map<String, Set<String>> gethiddenTuples();

  void clearHiddenTuples();

  void saveModelReferences(Map<EObject, Map<EStructuralFeature, Set<EObject>>> modelRelations);

  Map<EObject, Map<EStructuralFeature, Set<EObject>>> getModelReferences(Set<EObject> lookIn);

  void saveModelAttributes(Map<EObject, Map<EStructuralFeature, Set<String>>> modelRelations);

  Map<EObject, Map<EStructuralFeature, Set<String>>> getModelAttributes(Set<EObject> lookIn);

  void backup();

  void restore();

}
