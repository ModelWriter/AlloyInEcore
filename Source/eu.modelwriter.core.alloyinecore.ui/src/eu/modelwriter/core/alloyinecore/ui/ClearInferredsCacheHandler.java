package eu.modelwriter.core.alloyinecore.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.AIEVisualizationEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.PreferencesInstanceState;

public class ClearInferredsCacheHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    final MessageDialog warningdialog = new MessageDialog(Activator.getShell(), "Clear Cache", null,
        "Inferred objects cache will be cleared.", MessageDialog.INFORMATION,
        new String[] {"OK", "Cancel"}, 0);
    if (warningdialog.open() != 0) {
      return Status.CANCEL;
    }

    PreferencesInstanceState.getDefault().removeAllNodes();

    for (IEditorReference ref : Activator.getActiveWorkbenchWindow().getActivePage()
        .getEditorReferences()) {
      IEditorPart editor = ref.getEditor(false);
      if (editor instanceof AIEVisualizationEditor) {
        ((AIEVisualizationEditor) editor).refreshEditor();
      }
    }

    MessageDialog.openInformation(Activator.getShell(), "Clear Inferred Cache Process",
        "Inferred objects cache is cleared.");

    return Status.OK_STATUS;
  }

}
