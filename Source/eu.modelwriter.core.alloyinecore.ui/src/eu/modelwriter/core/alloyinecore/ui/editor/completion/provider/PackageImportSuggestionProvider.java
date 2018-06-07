package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;;

public class PackageImportSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._import));
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (context instanceof IdentifierContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._colon));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._import)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._singleQuote));
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._singleQuote));
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
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
    return context instanceof PackageImportContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.modelSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.indentifierSP());
  }

}
