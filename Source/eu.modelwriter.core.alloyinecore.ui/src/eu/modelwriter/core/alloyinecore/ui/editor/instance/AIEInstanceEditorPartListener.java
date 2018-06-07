/**
 * 
 */
package eu.modelwriter.core.alloyinecore.ui.editor.instance;

import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import eu.modelwriter.core.alloyinecore.ui.Workarounds;

/**
 * @author ferhat
 *
 */
class AIEInstanceEditorPartListener implements IPartListener2 {

  private static AIEInstanceEditorPartListener instance = null;

  protected AIEInstanceEditorPartListener() {
    // Exists only to defeat instantiation.
  }

  public static AIEInstanceEditorPartListener getInstance() {
    if (instance == null) {
      instance = new AIEInstanceEditorPartListener();
    }
    return instance;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IPartListener2#partActivated(org.eclipse.ui.IWorkbenchPartReference)
   */
  @Override
  public void partActivated(IWorkbenchPartReference partRef) {
    System.out.println("partActivated![" + partRef.getTitle() + "] (" + partRef.getId() + ")");
    System.out.println("isFocused? "
        + PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceFocus());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IPartListener2#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)
   */
  @Override
  public void partBroughtToTop(IWorkbenchPartReference partRef) {
    System.out.println("partBroughtToTop![" + partRef.getTitle() + "] (" + partRef.getId() + ")");

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IPartListener2#partClosed(org.eclipse.ui.IWorkbenchPartReference)
   */
  @Override
  public void partClosed(IWorkbenchPartReference partRef) {
    System.out.println("partClosed![" + partRef.getTitle() + "] (" + partRef.getId() + ")");

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IPartListener2#partDeactivated(org.eclipse.ui.IWorkbenchPartReference)
   */
  @Override
  public void partDeactivated(IWorkbenchPartReference partRef) {
    if (partRef.getId().equals("eu.modelwriter.core.alloyinecore.ui.editors.visualizationeditor"))
      Workarounds.doubleAltKeyPressed();
    System.out.println("partDeactivated![" + partRef.getTitle() + "] (" + partRef.getId() + ")");

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IPartListener2#partOpened(org.eclipse.ui.IWorkbenchPartReference)
   */
  @Override
  public void partOpened(IWorkbenchPartReference partRef) {
    System.out.println("partOpened![" + partRef.getTitle() + "] (" + partRef.getId() + ")");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IPartListener2#partHidden(org.eclipse.ui.IWorkbenchPartReference)
   */
  @Override
  public void partHidden(IWorkbenchPartReference partRef) {
    System.out.println("partHidden![" + partRef.getTitle() + "] (" + partRef.getId() + ")");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IPartListener2#partVisible(org.eclipse.ui.IWorkbenchPartReference)
   */
  @Override
  public void partVisible(IWorkbenchPartReference partRef) {
    System.out.println("partVisible![" + partRef.getTitle() + "] (" + partRef.getId() + ")");

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IPartListener2#partInputChanged(org.eclipse.ui.IWorkbenchPartReference)
   */
  @Override
  public void partInputChanged(IWorkbenchPartReference partRef) {
    System.out.println("partInputChanged![" + partRef.getTitle() + "] (" + partRef.getId() + ")");

  }

}
