package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericElementTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.structure.base.ISource;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EParameterSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    return new HashSet<>();
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._colon));
      } else if (lastToken instanceof EGenericElementTypeContext) {
        // parameter type
        // parser assumes that Context is finished, but completion continues.
        final EOperationContext fullContext = (EOperationContext) AIECompletionUtil.createInstance()
            .getFullContext(context.getParent());
        if (fullContext != null) {
          if (fullContext.current instanceof ISource) {
            final Set<AIECompletionProposal> targetProposals =
                AIECompletionUtil.createInstance().getTargetProposals(fullContext.current);
            if (targetProposals.stream()
                .noneMatch(t -> t.getReplacementString().equals(lastToken.getText()))
                && !spFactory.eGenericElementTypeSP().getStartSuggestions()
                .contains(lastToken.getText())) {
              suggestions.addAll(targetProposals);
            }
          }
        }
        suggestions.addAll(spFactory.multiplicitySP().getStartSuggestions());
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
      } else if (lastToken instanceof EMultiplicityContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._static)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._operation));
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        // parameter type
        final EOperationContext fullContext = (EOperationContext) AIECompletionUtil.createInstance()
            .getFullContext(context.getParent());
        if (fullContext != null) {
          if (fullContext.current instanceof ISource) {
            final Set<AIECompletionProposal> targetProposals =
                AIECompletionUtil.createInstance().getTargetProposals(fullContext.current);
            suggestions.addAll(targetProposals);
          }
        }
        suggestions.addAll(spFactory.eGenericElementTypeSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._ordered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notOrdered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._unique));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notUnique));
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._ordered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notOrdered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._unique));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notUnique));
      } else if (lastToken.getText().equals(CompletionTokens._ordered)
          || lastToken.getText().equals(CompletionTokens._notOrdered)
          || lastToken.getText().equals(CompletionTokens._unique)
          || lastToken.getText().equals(CompletionTokens._notUnique)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._comma));
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
    return context instanceof EParameterContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eTypedElementSP());
    addParent(spFactory.eOperationSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.eGenericElementTypeSP());
    addChild(spFactory.multiplicitySP());
    addChild(spFactory.eAnnotationSP());
  }

}
