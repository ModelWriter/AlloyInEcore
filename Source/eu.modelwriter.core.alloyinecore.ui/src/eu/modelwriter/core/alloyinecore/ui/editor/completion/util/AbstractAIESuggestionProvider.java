package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public abstract class AbstractAIESuggestionProvider implements AIESuggestionProvider {

  protected List<AIESuggestionProvider> children;
  protected List<AIESuggestionProvider> parents;
  protected Set<ICompletionProposal> suggestions;
  protected List<String> allPossibleTokens;

  protected final AIESuggestionProviderFactory spFactory;

  public AbstractAIESuggestionProvider() {
    spFactory = new AIESuggestionProviderFactory();
  }

  @Override
  public Set<ICompletionProposal> getSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions = new HashSet<>();
    if (isCompatibleWithContext(context)) {
      initRelatedProviders();
      computeSuggestions(context, lastToken);
    }
    return suggestions;
  }

  private void initRelatedProviders() {
    children = new ArrayList<>();
    parents = new ArrayList<>();
    initParentProviders();
    initChildProviders();
  }

  public void addParent(final AIESuggestionProvider parent) {
    parents.add(parent);
  }

  public void addChild(final AIESuggestionProvider child) {
    children.add(child);
  }

  protected Set<ICompletionProposal> getChildProviderSuggestions(final ParserRuleContext context,
      final ParseTree lastToken) {
    final Set<ICompletionProposal> suggestions = new HashSet<>();
    for (final ParseTree childContext : context.children) {
      if (childContext instanceof ParserRuleContext) {
        for (final AIESuggestionProvider childProvider : children) {
          suggestions
          .addAll(childProvider.getSuggestions((ParserRuleContext) childContext, lastToken));
        }
      }
    }
    return suggestions;
  }

  protected Set<ICompletionProposal> getParentProviderSuggestions(ParserRuleContext context,
      ParseTree lastToken) {
    final Set<ICompletionProposal> suggestions = new HashSet<>();
    lastToken = context;
    context = context.getParent();
    for (final AIESuggestionProvider parentProvider : parents) {
      suggestions.addAll(parentProvider.getSuggestions(context, lastToken));
    }
    return suggestions;
  }

  protected abstract void initParentProviders();

  protected abstract void initChildProviders();

  protected abstract void computeSuggestions(ParserRuleContext context, ParseTree lastToken);

  protected abstract boolean isCompatibleWithContext(ParserRuleContext context);
}
