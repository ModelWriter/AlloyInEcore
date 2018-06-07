package eu.modelwriter.core.alloyinecore.ui.editor.hyperlink;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.source.ISourceViewer;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.INavigable;
import eu.modelwriter.core.alloyinecore.structure.base.ITarget;
import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.structure.instance.Object;
import eu.modelwriter.core.alloyinecore.structure.instance.ObjectValue;
import eu.modelwriter.core.alloyinecore.structure.instance.Slot;
import eu.modelwriter.core.alloyinecore.structure.model.EcoreImport;
import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.document.AIEDocument;

public class AIEHyperlinkDetector implements IHyperlinkDetector {

  private final ISourceViewer sourceViewer;
  public AIEEditor editor;

  public AIEHyperlinkDetector(final ISourceViewer sourceViewer, final AIEEditor editor) {
    this.sourceViewer = sourceViewer;
    this.editor = editor;
  }

  @Override
  public IHyperlink[] detectHyperlinks(final ITextViewer textViewer, final IRegion region,
      final boolean canShowMultipleHyperlinks) {
    final List<IHyperlink> result = new ArrayList<>();
    try {
      IFile baseFile = ((AIEDocument) sourceViewer.getDocument()).getiFile();
      Element<?> selectedElement = editor.findElement(
          sourceViewer.getDocument().getLineOfOffset(region.getOffset()) + 1, region.getOffset());
      IHyperlink hyperlink = createHyperlink(selectedElement, baseFile);
      if (hyperlink != null)
        result.add(hyperlink);
    } catch (BadLocationException e) {
      System.out.println("BadLocationException at detectHyperlinks: " + e.getMessage());
    }
    return result.isEmpty() ? null : result.toArray(new IHyperlink[0]);
  }

  /**
   * 
   * @param selectedElement if this is instance of {@link INavigable} find target element else
   *        creates hyperlink based on itself
   * @param baseFile for resolving path names
   * @return {@link AIEHyperlink} created based on {@code selectedElement}, empty {@link IHyperlink}
   *         if can't create a hyperlink with parameters
   */
  public static IHyperlink createHyperlink(Element<?> selectedElement, IFile baseFile) {
    // For Instance elements themselfs
    if (selectedElement instanceof Instance
        || selectedElement.getOwnedElement(Instance.class) != null)
      return new AIEInstanceHyperlink(selectedElement, selectedElement, baseFile);

    // For Instance owned elements
    if (selectedElement instanceof Slot || selectedElement instanceof Object
        || selectedElement instanceof ObjectValue)
      return new AIEInstanceHyperlink(null, selectedElement, baseFile);

    // For Ecore imports
    if (selectedElement instanceof EcoreImport)
      return new EcoreHyperlink(selectedElement, selectedElement, baseFile);

    // For Ecore import owned elements
    if (selectedElement.getOwner(EcoreImport.class) != null)
      return new EcoreHyperlink(null, selectedElement, baseFile);

    // For Import elements themselfs
    if (selectedElement instanceof Import)
      return new AIEImportHyperlink(selectedElement, selectedElement, baseFile);

    // For imported elements
    if (selectedElement.getOwner(Import.class) != null)
      return new AIEImportHyperlink(null, selectedElement, baseFile);

    // For elements thats navigable
    if (selectedElement instanceof INavigable) {
      ITarget target = ((INavigable) selectedElement).getTarget();
      if (target != null && !target.equals(selectedElement)) {
        if (target.asElement().isImported()) {
          // For Ecore imports
          if (target.asElement().getOwner(EcoreImport.class) != null)
            return new EcoreHyperlink(selectedElement, target.asElement(), baseFile);
          // For other imported targets
          return new AIEImportHyperlink(selectedElement, target.asElement(), baseFile);
        } else
          return new AIEHyperlink(selectedElement, target.asElement());
      }
    }

    // return dummy hyperlink if nothing matched
    return new IHyperlink() {

      @Override
      public void open() {}

      @Override
      public String getTypeLabel() {
        return null;
      }

      @Override
      public String getHyperlinkText() {
        return null;
      }

      @Override
      public IRegion getHyperlinkRegion() {
        return new Region(0, 0);
      }
    };
  }
}
