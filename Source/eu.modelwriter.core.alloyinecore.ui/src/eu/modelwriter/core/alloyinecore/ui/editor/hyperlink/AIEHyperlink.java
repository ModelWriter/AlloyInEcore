package eu.modelwriter.core.alloyinecore.ui.editor.hyperlink;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.editors.text.TextEditor;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.ui.Activator;

public class AIEHyperlink implements IHyperlink {

  protected Element<?> targetElement;
  protected Element<?> selectedElement;
  protected IRegion region;

  public AIEHyperlink(final Element<?> selectedElement, final Element<?> targetElement) {
    this.selectedElement = selectedElement;
    this.targetElement = targetElement;
    if (selectedElement != null) {
      int start = selectedElement.getToken().getStartIndex();
      int lenght = selectedElement.getToken().getStopIndex() - start + 1;
      region = new Region(start, lenght);
    } else {
      region = new Region(0, 0);
    }
  }

  @Override
  public IRegion getHyperlinkRegion() {
    return region;
  }

  @Override
  public String getTypeLabel() {
    return "AIE Hyperlink";
  }

  @Override
  public String getHyperlinkText() {
    return "Open declaration";
  }

  @Override
  public void open() {
    final TextEditor editor =
        (TextEditor) Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    if (targetElement != null) {
      editor.selectAndReveal(targetElement.getStart(),
          targetElement.getStop() - targetElement.getStart() + 1);
      editor.setFocus();
    }
  }
}
