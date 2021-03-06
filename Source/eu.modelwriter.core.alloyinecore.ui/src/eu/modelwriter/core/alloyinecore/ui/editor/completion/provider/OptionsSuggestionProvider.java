package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionsContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class OptionsSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._options));
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof OptionContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._comma));
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightCurly));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._options)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)
          || lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.addAll(
            spFactory.optionSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._rightCurly)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof OptionsContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.modelSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.optionSP());
  }

}
