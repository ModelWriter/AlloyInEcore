package eu.modelwriter.core.alloyinecore.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.ResourceUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.InstanceState;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.PreferencesInstanceState;

public class ReasonXMIInstanceHandler extends AbstractHandler {


  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    final MessageDialog warningdialog = new MessageDialog(Activator.getShell(), "Model Completion",
        null, "This model file will be extended based on the specification.",
        MessageDialog.INFORMATION, new String[] {"OK", "Cancel"}, 0);
    if (warningdialog.open() != 0) {
      return null;
    }
    final IFile iFile = getIFile();
    if (iFile == null) {
      return null;
    }
    final URI uri = getFileURI();
    IEditorInput editorInput =
        Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput();

    Job job = new Job("AlloyInEcore Reasoning Job") {
      @Override
      protected IStatus run(IProgressMonitor monitor) {
        SubMonitor subMonitor = SubMonitor.convert(monitor, 50);
        subMonitor.setTaskName("Performing generation: ");
        subMonitor.subTask("preparing KodKod solver");

        InstanceState instanceState = new PreferencesInstanceState(iFile.getLocation().toString());
        instanceState.backup();

        ModelExtenderTask task = new ModelExtenderTask(subMonitor, iFile, editorInput, uri,
            ModelExtenderTask.NEW_SOLUTION);
        task.start();

        while (task.isAlive()) {
          try {
            Thread.sleep(200);
            // System.out.println("Did the user terminate the monitor?");
            if (monitor.isCanceled()) {
              task.stop();
              // System.out.println("Yes! Terminated!");
              return Status.CANCEL_STATUS;
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        /*
         * reasonAboutXMIInstance(subMonitor, filePath); Display.getDefault().asyncExec(new
         * Runnable() { public void run() { MessageDialog.openInformation(Activator.getShell(),
         * "Model Extending Process ", "Your job has finished" + (hasErrorWhileReasoning ?
         * " with errors." : ".")); } });
         */


        System.out.println("Normal ShutDowned!");
        return Status.OK_STATUS;

      }

    };
    job.setUser(true);
    job.schedule();

    return null;
  }

  private IFile getIFile() {
    IEditorPart editor;
    editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    return ResourceUtil.getFile(editor.getEditorInput());
  }

  private URI getFileURI() {
    IEditorPart editor = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    final IFile file = ResourceUtil.getFile(editor.getEditorInput());
    return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
  }

}
