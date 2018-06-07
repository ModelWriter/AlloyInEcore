package eu.modelwriter.core.alloyinecore.ui.editor.hyperlink;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.INavigable;
import eu.modelwriter.core.alloyinecore.structure.instance.ModelImport;
import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;

public class AIEImportHyperlink extends AIEHyperlink {

  private IFile baseFile;

  public AIEImportHyperlink(Element<?> selectedElement, Element<?> targetElement, IFile baseFile) {
    super(selectedElement, targetElement);
    this.baseFile = baseFile;
  }

  @Override
  public String getTypeLabel() {
    return "AIE Import Hyperlink";
  }

  @Override
  public void open() {
    String pathName = "";
    if (targetElement instanceof Import) {
      pathName = ((INavigable) targetElement).getPathName();
    } else if (targetElement instanceof ModelImport) {
      pathName = ((ModelImport) targetElement).getPath();
    } else {
      ModelImport modelImport = targetElement.getOwner(ModelImport.class);
      if (modelImport != null) {
        pathName = modelImport.getPath();
      } else {
        Import owner = targetElement.getOwner(Import.class);
        pathName = owner != null ? ((INavigable) owner).getPathName() : "";
      }
    }
    if (!pathName.isEmpty()) {
      IEditorInput fInput = EditorUtils.getIEditorInput(pathName, baseFile);
      try {
        AIEEditor editor = EditorUtils.openAIEEditor(fInput);
        if (!(targetElement instanceof Import || targetElement instanceof ModelImport))
          editor.selectAndReveal(targetElement.getStart(),
              targetElement.getStop() - targetElement.getStart() + 1);
      } catch (PartInitException e) {
        e.printStackTrace();
      }
    }
  }
}
