package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.structure.base.ISource;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class ETypeParameterSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    return new HashSet<>();
  }

  @Override
  protected void initParentProviders() {
    parents.add(spFactory.templateSignatureSP());
  }

  @Override
  protected void initChildProviders() {
    children.add(spFactory.unrestrictedNameSP());
    children.add(spFactory.eGenericTypeSP());
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._extends));
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof EGenericTypeContext) {
        // super types
        // parser assumes that Context is finished, but completion continues.
        final ETypeParameterContext fullContext =
            (ETypeParameterContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          if (fullContext.current instanceof ISource) {
            final Set<AIECompletionProposal> targetProposals =
                AIECompletionUtil.createInstance().getTargetProposals(fullContext.current);
            if (targetProposals.stream()
                .noneMatch(t -> t.getReplacementString().equals(lastToken.getText()))) {
              suggestions.addAll(targetProposals);
            }
          }
        }
        suggestions.add(new AIECompletionProposal(CompletionTokens._ampersand));
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._extends)
          || lastToken.getText().equals(CompletionTokens._ampersand)) {
        // super types
        final ETypeParameterContext fullContext =
            (ETypeParameterContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          if (fullContext.current instanceof ISource) {
            final Set<AIECompletionProposal> targetProposals =
                AIECompletionUtil.createInstance().getTargetProposals(fullContext.current);
            suggestions.addAll(targetProposals);
          }
        }
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof ETypeParameterContext;
  }

}
