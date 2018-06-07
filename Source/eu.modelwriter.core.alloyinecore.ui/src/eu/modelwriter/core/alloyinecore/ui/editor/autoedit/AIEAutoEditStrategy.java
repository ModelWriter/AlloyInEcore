package eu.modelwriter.core.alloyinecore.ui.editor.autoedit;

import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;

public class AIEAutoEditStrategy extends DefaultIndentLineAutoEditStrategy {

  private void configureCaret(final DocumentCommand command, final int caretInc) {
    command.caretOffset = command.offset + caretInc;
    command.shiftsCaret = false;
  }

  @Override
  public void customizeDocumentCommand(final IDocument document, final DocumentCommand command) {
    super.customizeDocumentCommand(document, command);
    if (command.text.equals("(")) {
      command.text = "()";
      configureCaret(command, 1);
    } else if (command.text.equals("[")) {
      command.text = "[]";
      configureCaret(command, 1);
    } else if (command.text.equals("'")) {
      command.text = "''";
      configureCaret(command, 1);
    } else if (command.text.equals("\"")) {
      command.text = "\"\"";
      configureCaret(command, 1);
    } else if (command.text.equals("{")) {
      command.text = "{}";
      configureCaret(command, 1);
    }
  }

}
