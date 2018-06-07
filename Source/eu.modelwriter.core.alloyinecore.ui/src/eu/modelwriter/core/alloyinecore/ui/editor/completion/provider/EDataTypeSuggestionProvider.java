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
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EDataTypeSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        spFactory.visibilityKindSP().getStartSuggestions());
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._primitive));
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._datatype));
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._primitive));
        suggestions.add(new AIECompletionProposal(CompletionTokens._datatype));
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.addAll(spFactory.templateSignatureSP()
            .getStartSuggestions());
        suggestions.add(new AIECompletionProposal(CompletionTokens._colon));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof TemplateSignatureContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._colon));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof EAnnotationContext || lastToken instanceof InvariantContext) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.invariantSP().getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._primitive)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._datatype));
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._singleQuote));
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._serializable));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notSerializable));
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.invariantSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._serializable)
          || lastToken.getText().equals(CompletionTokens._notSerializable)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightCurly));
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
    return context instanceof EDataTypeContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eClassifierSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.visibilityKindSP());
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.templateSignatureSP());
    addChild(spFactory.eAnnotationSP());
    addChild(spFactory.invariantSP());
  }

}
