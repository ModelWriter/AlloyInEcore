package eu.modelwriter.core.alloyinecore.ui;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.ResourceUtil;
import eu.modelwriter.core.alloyinecore.interpreter.EObjectCreationException;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.InstanceState;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.PreferencesInstanceState;

public class RestoreXMIInstanceHandler extends AbstractHandler {


  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    final MessageDialog warningdialog = new MessageDialog(Activator.getShell(),
        "Restore XMI Instance", null, "This XMI instance will be restored.",
        MessageDialog.INFORMATION, new String[] {"OK", "Cancel"}, 0);
    if (warningdialog.open() != 0) {
      return null;
    }
    final IFile iFile = getIFile();
    if (iFile == null) {
      return null;
    }

    final File file = iFile.getLocation().toFile();

    try {
      restoreXMI(file.getAbsolutePath());
      InstanceState instanceState = new PreferencesInstanceState(iFile.getLocation().toString());
      instanceState.restore();
      instanceState.flush();
    } catch (Exception e) {
      e.printStackTrace();
      ErrorDialog.openError(Activator.getShell(), "Restore XMI Instance Process",
          "Error: " + e.getMessage(), Status.CANCEL_STATUS);
      return Status.ERROR;
    }

    try {
      iFile.refreshLocal(IResource.DEPTH_ONE, null);
    } catch (CoreException e) {
      e.printStackTrace();
    }

    MessageDialog.openInformation(Activator.getShell(), "Restore XMI Instance Process",
        "Instance is restored.");

    return Status.OK_STATUS;
  }

  private IFile getIFile() {
    IEditorPart editor;
    editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    return ResourceUtil.getFile(editor.getEditorInput());
  }

  public void restoreXMI(String filename) throws IOException, EObjectCreationException {
    ResourceSet rs = new ResourceSetImpl();
    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
        new EcoreResourceFactoryImpl());
    rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        new XMIResourceFactoryImpl());

    String original_instance = filename + "_original.xmi";

    URI originalURI = URI.createFileURI(original_instance);

    Resource res = rs.getResource(originalURI, true);
    res.load(Collections.emptyMap());

    URI fileURI = URI.createFileURI(filename);

    res.setURI(fileURI);
    res.save(Collections.EMPTY_MAP);
  }

}
