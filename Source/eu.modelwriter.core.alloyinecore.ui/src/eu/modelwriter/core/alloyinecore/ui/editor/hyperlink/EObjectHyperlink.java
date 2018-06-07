package eu.modelwriter.core.alloyinecore.ui.editor.hyperlink;

import org.eclipse.emf.ecore.EObject;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.Object;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;

public class EObjectHyperlink extends AIEHyperlink {

  private EObject eObject;
  private AIEEditor editor;

  public EObjectHyperlink(Element<?> selectedElement, AIEEditor editor) {
    super(selectedElement, null);
    this.editor = editor;
    eObject = ((Object<?, ?>) selectedElement).getEObject();
  }

  @Override
  public String getTypeLabel() {
    return "AIE EObject Hyperlink";
  }

  @Override
  public String getHyperlinkText() {
    return "Open in Ecore Editor";
  }

  @Override
  public void open() {
    editor.openEcoreEditorAndReveal(eObject);
  }
}
