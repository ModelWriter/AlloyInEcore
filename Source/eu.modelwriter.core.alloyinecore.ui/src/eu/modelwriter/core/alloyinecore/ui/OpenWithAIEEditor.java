package eu.modelwriter.core.alloyinecore.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.ResourceUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;

public class OpenWithAIEEditor extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    IEditorPart editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    final IFile file = ResourceUtil.getFile(editor.getEditorInput());
    final URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

    Display.getDefault().syncExec(new Runnable() {

      @Override
      public void run() {

        try {
          IMarker marker = ResourceUtil.getResource(editor.getEditorInput())
              .createMarker("eu.modelwriter.core.alloyinecore.ui.editor.parseerrormarker");
          marker.setAttribute(IDE.EDITOR_ID_ATTR, AIEEditor.EDITOR_ID);
          marker.setAttribute(IMarker.TEXT, "Temporary Marker");
          marker.setAttribute("uri", uri.toString());
          IDE.openEditor(Activator.getActiveWorkbenchWindow().getActivePage(), marker, true);
          marker.delete();
        } catch (CoreException e) {
          e.printStackTrace();
        }
      }

    });

    return null;
  }

}
