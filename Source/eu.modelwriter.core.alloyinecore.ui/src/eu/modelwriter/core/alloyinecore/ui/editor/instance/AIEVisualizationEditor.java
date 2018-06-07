package eu.modelwriter.core.alloyinecore.ui.editor.instance;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.EditorPart;
import edu.mit.csail.sdg.alloy4.ErrorFatal;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.visualization.EcoreInstanceVisualizer;

public class AIEVisualizationEditor extends EditorPart {

  private File file;
  private Frame frame;
  private Composite animationEditor;
  private IResourceChangeListener listener = null;
  private Composite tParent = null;

  public static String EDITOR_ID =
      "eu.modelwriter.core.alloyinecore.ui.editors.visualizationeditor";

  public AIEVisualizationEditor() {}

  public boolean refreshEditor() {
    if (tParent != null) {
      tParent.getChildren()[0].dispose();
      createPartControl(tParent);
      tParent.redraw();
      tParent.layout();
      return true;
    } else
      return false;
  }

  @Override
  public void doSaveAs() {

  }

  @Override
  public boolean isSaveAsAllowed() {
    return false;
  }

  @Override
  public void doSave(IProgressMonitor monitor) {

  }

  @Override
  public void init(IEditorSite site, IEditorInput input) throws PartInitException {
    try {
      /*
       * TODO BUG
       *
       * A Fatal Error occurs while setting GTK look and feel on Ubuntu 16.04
       * (com.sun.java.swing.plaf.gtk.GTKLookAndFeel).
       *
       */
      final String LaF = UIManager.getSystemLookAndFeelClassName();
      if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(LaF)) {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } else {
        UIManager.setLookAndFeel(LaF);
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e1) {

      e1.printStackTrace();
    }

    setSite(site);
    setInput(input);
    this.file = input.getAdapter(File.class);
    setPartName(file.getName());

    listener = new IResourceChangeListener() {
      public void resourceChanged(IResourceChangeEvent event) {
        // Determine if the change is relevant
        if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
          try {
            event.getDelta().accept(new IResourceDeltaVisitor() {
              public boolean visit(IResourceDelta delta) {
                // only interested in changed resources (not added or removed)
                if (delta.getKind() != IResourceDelta.CHANGED)
                  return true;
                // only interested in content changes
                if ((delta.getFlags() & IResourceDelta.CONTENT) == 0)
                  return true;
                IResource resource = delta.getResource();
                // only interested in files with the same file
                if (resource.getType() == IResource.FILE
                    && resource.toString().equals(ResourceUtil.getResource(input).toString())) {
                  System.out.println("ResourceChanged is caught in the Visualization!");
                  Display.getDefault().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                      refreshEditor();
                    }
                  });
                }
                return true;
              }
            });
          } catch (Exception e) {
            // open error dialog with syncExec or print to plugin log file
            e.printStackTrace();
          }
        }
      }
    };
    ResourcesPlugin.getWorkspace().addResourceChangeListener(listener);
    System.out.println("Resource Listener is attached!");
  }

  @Override
  public void dispose() {

    // Remove Resource Changed listeners
    System.out.println("Resource Listener is removed!");
    ResourcesPlugin.getWorkspace().removeResourceChangeListener(listener);

    // Delete previous visualization markers
    try {
      ResourceUtil.getResource(getEditorInput()).deleteMarkers(
          "eu.modelwriter.core.alloyinecore.ui.editor.visualizationmarker", true,
          IResource.DEPTH_INFINITE);
    } catch (CoreException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    window.getPartService().removePartListener(AIEInstanceEditorPartListener.getInstance());

    super.dispose();
  }

  @Override
  public boolean isDirty() {
    return false;
  }

  @Override
  public void createPartControl(Composite parent) {
    tParent = parent;
    animationEditor = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    frame = null;

    if (file != null) {
      try {
        EcoreInstanceVisualizer visualizer = new EcoreInstanceVisualizer(getEditorInput());

        visualizer.addChangeListener(new Runnable() {

          @Override
          public void run() {
            addPanelToFrame(visualizer.getComponent());
          }

        });

        IWorkbenchWindow window = getSite().getPage().getWorkbenchWindow();

        System.out.println("part listener added!");
        window.getPartService().addPartListener(AIEInstanceEditorPartListener.getInstance());

        addPanelToFrame(visualizer.getComponent());
      } catch (ErrorFatal e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void addPanelToFrame(final JComponent component) {
    if (frame == null) {
      getEditorSite().getShell().getDisplay().syncExec(new Runnable() {

        public void run() {
          frame = SWT_AWT.new_Frame(animationEditor);
        }
      });
    }
    if (frame.getComponents().length > 0) {
      frame.removeAll();
    }

    JScrollPane scroll = new JScrollPane(component);

    frame.add(scroll);
    frame.setVisible(true);

  }

  @Override
  public void setFocus() {
    animationEditor.setFocus();
  }

}
