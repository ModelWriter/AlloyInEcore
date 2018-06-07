package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.LowerContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UpperContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EMultiplicitySuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._leftBracket));
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof LowerContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._ellipsis));
        for (final String ct : CompletionTokens._stringBounds) {
          suggestions.add(new AIECompletionProposal(ct));
        }
        for (final String ct : CompletionTokens._isnullable) {
          suggestions.add(new AIECompletionProposal(ct));
        }
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightBracket));
      } else if (lastToken instanceof UpperContext) {
        for (final String ct : CompletionTokens._isnullable) {
          suggestions.add(new AIECompletionProposal(ct));
        }
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightBracket));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._leftBracket)) {
        // lower
      } else if (lastToken.getText().equals(CompletionTokens._ellipsis)) {
        // upper
      } else if (CompletionTokens._stringBounds.contains(lastToken.getText())) {
        for (final String ct : CompletionTokens._isnullable) {
          suggestions.add(new AIECompletionProposal(ct));
        }
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightBracket));
      } else if (CompletionTokens._isnullable.contains(lastToken.getText())) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightBracket));
      } else if (lastToken.getText().equals(CompletionTokens._rightBracket)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EMultiplicityContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eAttributeSP());
    addParent(spFactory.eReferenceSP());
    addParent(spFactory.eOperationSP());
    addParent(spFactory.eParameterSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.lowerSP());
    addChild(spFactory.upperSP());
  }

}
