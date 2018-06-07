package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public interface AIESuggestionProvider {
  Set<ICompletionProposal> getSuggestions(ParserRuleContext context, ParseTree lastToken);

  Set<ICompletionProposal> getStartSuggestions();
}
