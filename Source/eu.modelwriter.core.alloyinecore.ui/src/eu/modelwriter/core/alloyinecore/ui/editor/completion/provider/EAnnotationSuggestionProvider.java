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
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDetailContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementRefContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EAnnotationSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._annotation));
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof EDetailContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._comma));
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightParenthesis));
      } else if (lastToken instanceof EAnnotationContext
          || lastToken instanceof EModelElementContext
          || lastToken instanceof EModelElementRefContext) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.eModelElementSP()
            .getStartSuggestions());
        suggestions.addAll(spFactory.eModelElementRefSP()
            .getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._annotation)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._singleQuote));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftParenthesis));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftParenthesis));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken.getText().equals(CompletionTokens._leftParenthesis)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._singleQuote));
      } else if (lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._singleQuote));
      } else if (lastToken.getText().equals(CompletionTokens._rightParenthesis)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.eModelElementSP()
            .getStartSuggestions());
        suggestions.addAll(spFactory.eModelElementRefSP()
            .getStartSuggestions());
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
    return context instanceof EAnnotationContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.ePackageSP());
    addParent(spFactory.eClassSP());
    addParent(spFactory.eAttributeSP());
    addParent(spFactory.eReferenceSP());
    addParent(spFactory.eOperationSP());
    addParent(spFactory.eParameterSP());
    addParent(spFactory.eDatatypeSP());
    addParent(spFactory.eEnumSP());
    addParent(spFactory.eEnumliteralSP());
    addParent(spFactory.eAnnotationSP());
    addParent(spFactory.eModelElementSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.eDetailSP());
    addChild(spFactory.eAnnotationSP());
    addChild(spFactory.eModelElementSP());
    addChild(spFactory.eModelElementRefSP());
  }

}
