package eu.modelwriter.core.alloyinecore.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ide.ResourceUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.AIEVisualizationEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.InstanceState;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.PreferencesInstanceState;

public class ClearCacheForSpecificXMIHandler extends AbstractHandler {


  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    final MessageDialog warningdialog = new MessageDialog(Activator.getShell(),
        "Clear Cache For Specific XMI", null, "Cache of this XMI instance will be cleared.",
        MessageDialog.INFORMATION, new String[] {"OK", "Cancel"}, 0);
    if (warningdialog.open() != 0) {
      return null;
    }
    final IFile iFile = getIFile();
    if (iFile == null) {
      return null;
    }

    InstanceState instanceState = new PreferencesInstanceState(iFile.getLocation().toString());
    instanceState.removeSubNode();

    for (IEditorReference ref : Activator.getActiveWorkbenchWindow().getActivePage()
        .getEditorReferences()) {
      IEditorPart editor = ref.getEditor(false);
      if (editor instanceof AIEVisualizationEditor) {
        ((AIEVisualizationEditor) editor).refreshEditor();
      }
    }

    MessageDialog.openInformation(Activator.getShell(), "Clear Cache For Specific XMI Process",
        "Cache is cleared.");

    return Status.OK_STATUS;
  }

  private IFile getIFile() {
    IEditorPart editor;
    editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    return ResourceUtil.getFile(editor.getEditorInput());
  }

}
