package eu.modelwriter.core.alloyinecore.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.ResourceUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;

public class OpenInstancesModelWithAIEEditor extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {

    IEditorPart editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    final IFile file = ResourceUtil.getFile(editor.getEditorInput());

    ResourceSet rs = new ResourceSetImpl();
    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
        new EcoreResourceFactoryImpl());
    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new XMIResourceFactoryImpl());

    String original_instance = file.getLocation().toFile().getAbsolutePath();

    URI originalURI = URI.createFileURI(original_instance);

    Resource res = rs.getResource(originalURI, true);
    try {
      res.load(Collections.emptyMap());
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    String fileName =
        EcoreUtil.getURI(res.getContents().get(0).eClass().getEPackage()).toFileString();

    Display.getDefault().syncExec(new Runnable() {

      @Override
      public void run() {

        try {
          int index =
              Arrays.asList(new Path(fileName).segments()).indexOf(file.getFullPath().segment(0));
          IFile iFileModel = ResourcesPlugin.getWorkspace().getRoot()
              .getFile(new Path(fileName).removeFirstSegments(index));
          IMarker marker = iFileModel
              .createMarker("eu.modelwriter.core.alloyinecore.ui.editor.parseerrormarker");
          marker.setAttribute(IDE.EDITOR_ID_ATTR, AIEEditor.EDITOR_ID);
          marker.setAttribute(IMarker.TEXT, "Temporary Marker");
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
