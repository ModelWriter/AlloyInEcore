package eu.modelwriter.core.alloyinecore.ui.editor.hyperlink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.PartInitException;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.model.Import;
import eu.modelwriter.core.alloyinecore.ui.TextEditorInput;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;

public class EcoreHyperlink extends AIEHyperlink {

  private IFile baseFile;
  private static TextEditorInput ecoreInput;

  static {
    InputStream resourceAsStream = EcoreHyperlink.class.getResourceAsStream("/Ecore.recore");
    String ecoreRecore = getStreamAsString(resourceAsStream);
    ecoreInput = new TextEditorInput("Ecore.ecore", ecoreRecore);
  }

  public EcoreHyperlink(Element<?> selectedElement, Element<?> targetElement, IFile baseFile) {
    super(selectedElement, targetElement);
    this.targetElement = targetElement;
    this.baseFile = baseFile;
  }

  @Override
  public String getTypeLabel() {
    return "AIE Hyperlink";
  }

  private TextEditorInput getEcoreInput() {
    return ecoreInput;
  }

  @Override
  public void open() {
    TextEditorInput input = getEcoreInput();
    input.setFile(baseFile);
    try {
      AIEEditor editor = EditorUtils.openAIEEditor(input);
      if (!(targetElement instanceof Import))
        editor.selectAndReveal(targetElement.getStart(),
            targetElement.getStop() - targetElement.getStart() + 1);
    } catch (PartInitException e) {
      e.printStackTrace();
    }
  }

  public static String getStreamAsString(InputStream stream) {
    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();
    String line;
    try {
      br = new BufferedReader(new InputStreamReader(stream));
      while ((line = br.readLine()) != null) {
        sb.append(line);
        sb.append(System.getProperty("line.separator"));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return sb.toString();
  }
}
