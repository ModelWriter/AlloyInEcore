package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.FormulaContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PreconditionContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class PreconditionSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._precondition));
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._requires));
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof IdentifierContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftParenthesis));
        suggestions.add(new AIECompletionProposal(CompletionTokens._colon));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof FormulaContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._precondition)
          || lastToken.getText().equals(CompletionTokens._requires)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._colon));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken.getText().equals(CompletionTokens._leftParenthesis)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._doubleQuote));
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.DOUBLE_QUOTED_STRING) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightParenthesis));
      } else if (lastToken.getText().equals(CompletionTokens._rightParenthesis)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._colon));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        suggestions.addAll(
            spFactory.formulaSP().getStartSuggestions());
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken.getText().equals(CompletionTokens._semicolon)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof PreconditionContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eOperationSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.indentifierSP());
    addChild(spFactory.formulaSP());
  }

}
