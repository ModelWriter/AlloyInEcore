package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumLiteralContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EEnumLiteralSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._literal));
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.addAll(spFactory.templateSignatureSP()
            .getStartSuggestions());
        suggestions.add(new AIECompletionProposal(CompletionTokens._equals));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof EAnnotationContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightCurly));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (((TerminalNode) lastToken).getSymbol().getType() == AlloyInEcoreLexer.INT) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._rightCurly)
          || lastToken.getText().equals(CompletionTokens._semicolon)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EEnumLiteralContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eEnumSP());
    addParent(spFactory.eNamedElementSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.eAnnotationSP());
  }

}
