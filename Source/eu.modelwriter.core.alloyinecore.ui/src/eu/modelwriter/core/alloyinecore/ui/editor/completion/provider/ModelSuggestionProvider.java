package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModelContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionsContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class ModelSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions
    .addAll(spFactory.optionsSP().getStartSuggestions());
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._model));
    startSuggestions.addAll(
        spFactory.packageImportSP().getStartSuggestions());
    startSuggestions.addAll(
        spFactory.ePackageSP().getStartSuggestions());
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (context == null) {
        suggestions.addAll(getStartSuggestions());
      } else if (lastToken instanceof OptionsContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._model));
        suggestions.addAll(spFactory.packageImportSP()
            .getStartSuggestions());
        suggestions.addAll(
            spFactory.ePackageSP().getStartSuggestions());
      } else if (lastToken instanceof IdentifierContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof PackageImportContext) {
        suggestions.addAll(spFactory.packageImportSP()
            .getStartSuggestions());
        suggestions.addAll(
            spFactory.ePackageSP().getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._semicolon)) {
        suggestions.addAll(spFactory.packageImportSP()
            .getStartSuggestions());
        suggestions.addAll(
            spFactory.ePackageSP().getStartSuggestions());
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof ModelContext || context == null;
  }

  @Override
  protected void initParentProviders() {

  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.optionsSP());
    addChild(spFactory.indentifierSP());
    addChild(spFactory.packageImportSP());
    addChild(spFactory.ePackageSP());
  }

}
