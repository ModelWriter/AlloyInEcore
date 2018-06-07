package eu.modelwriter.core.alloyinecore.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class TextEditorInput implements IEditorInput {

  private String text;
  private String name;
  private IFile file;

  public TextEditorInput(String name, String text) {
    this.name = name;
    this.text = text;
  }

  public void setFile(IFile file) {
    this.file = file;
  }

  public IFile getFile() {
    return file;
  }

  public String getText() {
    return text;
  }

  @Override
  public <T> T getAdapter(Class<T> adapter) {
    return null;
  }

  @Override
  public boolean exists() {
    return true;
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    return null;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public IPersistableElement getPersistable() {
    return null;
  }

  @Override
  public String getToolTipText() {
    return null;
  }

}
