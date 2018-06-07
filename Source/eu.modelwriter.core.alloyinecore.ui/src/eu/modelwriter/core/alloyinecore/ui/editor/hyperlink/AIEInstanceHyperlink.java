package eu.modelwriter.core.alloyinecore.ui.editor.hyperlink;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.INavigable;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.AIEInstanceEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;

public class AIEInstanceHyperlink extends AIEHyperlink {

  private IFile baseFile;

  public AIEInstanceHyperlink(final Element<?> selectedElement, Element<?> targetElement,
      IFile baseFile) {
    super(selectedElement, targetElement);
    this.baseFile = baseFile;
  }

  @Override
  public String getTypeLabel() {
    return "AIE Instance Hyperlink";
  }

  @Override
  public void open() {
    String pathName = "";
    if (targetElement instanceof Import) {
      pathName = ((INavigable) targetElement).getPathName();
    } else {
      Import owner = targetElement.getOwner(Import.class);
      pathName = owner != null ? ((INavigable) owner).getPathName() : "";
    }
    if (!pathName.isEmpty()) {
      try {
        IEditorInput input = EditorUtils.getIEditorInput(pathName, baseFile);
        AIEInstanceEditor editor = EditorUtils.openAIEInstanceEditor(input);
        if (!(targetElement instanceof Instance || targetElement instanceof Import))
          editor.selectAndReveal(targetElement.getStart(),
              targetElement.getStop() - targetElement.getStart() + 1);
      } catch (PartInitException e) {
        e.printStackTrace();
      }
    }
  }
}
