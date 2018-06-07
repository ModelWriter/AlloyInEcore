package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public class SuggestionDetector {
  private final List<AIESuggestionProvider> suggestionProviders;

  private final IDocument document;
  private final int offset;
  private final ParserRuleContext parentOfCloserNode;
  private final ParseTree closerNode;

  private final AIESuggestionProviderFactory spFactory;

  public SuggestionDetector(final IDocument document, final int offset,
      final ParserRuleContext parentOfCloserNode, final ParseTree closerNode) {
    this.document = document;
    this.offset = offset;
    this.parentOfCloserNode = parentOfCloserNode;
    this.closerNode = closerNode;
    suggestionProviders = new ArrayList<>();

    spFactory = new AIESuggestionProviderFactory();
    initSuggestionProviders();
  }

  private void initSuggestionProviders() {
    suggestionProviders
    .addAll(spFactory.allSuggestionProviders());
  }

  public Set<ICompletionProposal> detect() {
    final Set<ICompletionProposal> suggestions = new HashSet<>();
    for (final AIESuggestionProvider suggestionProvider : suggestionProviders) {
      suggestions.addAll(suggestionProvider.getSuggestions(parentOfCloserNode, closerNode));
    }
    return suggestions;
  }
}
