package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.BodyContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericElementTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericExceptionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PostconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PreconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.structure.base.ISource;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EOperationSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.addAll(spFactory.visibilityKindSP().getStartSuggestions());
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._static));
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._operation));
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._static));
        suggestions.add(new AIECompletionProposal(CompletionTokens._operation));
      } else if (lastToken instanceof TemplateSignatureContext) {
        // operation name
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftParenthesis));
      } else if (lastToken instanceof EParameterContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._comma));
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightParenthesis));
      } else if (lastToken instanceof EGenericElementTypeContext) {
        // operation return type
        // parser assumes that Context is finished, but completion continues.
        final EOperationContext fullContext =
            (EOperationContext) AIECompletionUtil.createInstance().getFullContext(context);
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
        suggestions.add(new AIECompletionProposal(CompletionTokens._throws));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof EMultiplicityContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._throws));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof EGenericExceptionContext) {
        // exception type
        // parser assumes that Context is finished, but completion continues.
        final EOperationContext fullContext =
            (EOperationContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          if (fullContext.current instanceof ISource) {
            final Set<AIECompletionProposal> targetProposals =
                AIECompletionUtil.createInstance().getTargetProposals(fullContext.current);
            suggestions.addAll(targetProposals);
          }
        }
        suggestions.add(new AIECompletionProposal(CompletionTokens._comma));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof EAnnotationContext || lastToken instanceof PreconditionContext
          || lastToken instanceof BodyContext || lastToken instanceof PostconditionContext) {
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.preconditionSP().getStartSuggestions());
        suggestions.addAll(spFactory.bodySP().getStartSuggestions());
        suggestions.addAll(spFactory.postconditionSP().getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._static)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._operation));
      } else if (lastToken.getText().equals(CompletionTokens._operation)) {
        suggestions.addAll(spFactory.templateSignatureSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._leftParenthesis)) {
        suggestions.addAll(spFactory.eParameterSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._rightParenthesis)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._colon));
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        // operation return type
        final EOperationContext fullContext =
            (EOperationContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          if (fullContext.current instanceof ISource) {
            final Set<AIECompletionProposal> targetProposals =
                AIECompletionUtil.createInstance().getTargetProposals(fullContext.current);
            suggestions.addAll(targetProposals);
          }
        }
        suggestions.addAll(spFactory.eGenericElementTypeSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._throws)) {
        // exception type
        final EOperationContext fullContext =
            (EOperationContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          if (fullContext.current instanceof ISource) {
            final Set<AIECompletionProposal> targetProposals =
                AIECompletionUtil.createInstance().getTargetProposals(fullContext.current);
            suggestions.addAll(targetProposals);
          }
        }
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._ordered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notOrdered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._unique));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notUnique));
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.preconditionSP().getStartSuggestions());
        suggestions.addAll(spFactory.bodySP().getStartSuggestions());
        suggestions.addAll(spFactory.postconditionSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.addAll(spFactory.eParameterSP().getStartSuggestions());
        // exception types
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
    return context instanceof EOperationContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eTypedElementSP());
    addParent(spFactory.eClassSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.visibilityKindSP());
    addChild(spFactory.templateSignatureSP());
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.eParameterSP());
    addChild(spFactory.eGenericElementTypeSP());
    addChild(spFactory.multiplicitySP());
    addChild(spFactory.eGenericExceptionSP());
    addChild(spFactory.eAnnotationSP());
    addChild(spFactory.preconditionSP());
    addChild(spFactory.bodySP());
    addChild(spFactory.postconditionSP());
  }

}
