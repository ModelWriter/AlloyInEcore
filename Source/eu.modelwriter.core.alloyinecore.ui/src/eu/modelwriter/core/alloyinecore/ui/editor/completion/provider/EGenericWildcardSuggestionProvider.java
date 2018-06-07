package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericWildcardContext;
import eu.modelwriter.core.alloyinecore.structure.base.ITarget;
import eu.modelwriter.core.alloyinecore.structure.model.Classifier;
import eu.modelwriter.core.alloyinecore.structure.model.GenericWildcard;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EGenericWildcardSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._question));
    return startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    parents.add(spFactory.eGenericTypeArgumentSP());
  }

  @Override
  protected void initChildProviders() {
    children.add(spFactory.eGenericTypeSP());
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof EGenericTypeContext) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._question)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._extends));
        suggestions.add(new AIECompletionProposal(CompletionTokens._super));
      } else if (lastToken.getText().equals(CompletionTokens._extends)
          || lastToken.getText().equals(CompletionTokens._super)) {
        // referenced generic type
        final EGenericWildcardContext fullContext =
            (EGenericWildcardContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          final GenericWildcard genericWildcard = fullContext.current;
          final Model model = genericWildcard.getOwner(Model.class);
          model.getAllOwnedElements().stream().filter(e -> e instanceof ITarget)
              .filter(t -> t instanceof Classifier)
          .map(ITarget.class::cast).forEach(t -> {
            final AIECompletionProposal targetProposal =
                AIECompletionUtil.createInstance().createCompletionProposalForElement(
                    t.getRelativeSegment(genericWildcard), null, null, genericWildcard);
            suggestions.add(targetProposal);
          });;
        }
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EGenericWildcardContext;
  }

}
