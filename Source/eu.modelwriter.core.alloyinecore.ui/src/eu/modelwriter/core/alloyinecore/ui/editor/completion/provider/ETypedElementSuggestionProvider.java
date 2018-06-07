package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypedElementContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class ETypedElementSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        spFactory.eOperationSP().getStartSuggestions());
    startSuggestions.addAll(
        spFactory.eParameterSP().getStartSuggestions());
    startSuggestions.addAll(spFactory.eStructuralFeatureSP()
        .getStartSuggestions());
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions.addAll(getParentProviderSuggestions(context, lastToken));
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof ETypedElementContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eNamedElementSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.eOperationSP());
    addChild(spFactory.eParameterSP());
    addChild(spFactory.eStructuralFeatureSP());
  }

}
