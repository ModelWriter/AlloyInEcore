package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.DerivationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericElementTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InitialContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.ISource;
import eu.modelwriter.core.alloyinecore.structure.base.ITarget;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EReferenceSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.addAll(spFactory.visibilityKindSP().getStartSuggestions());
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._static));
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._model));
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._ghost));
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._transient));
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._volatile));
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._readonly));
    startSuggestions.add(new AIECompletionProposal(CompletionTokens._property));
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._static));
        suggestions.add(new AIECompletionProposal(CompletionTokens._model));
        suggestions.add(new AIECompletionProposal(CompletionTokens._ghost));
        suggestions.add(new AIECompletionProposal(CompletionTokens._transient));
        suggestions.add(new AIECompletionProposal(CompletionTokens._volatile));
        suggestions.add(new AIECompletionProposal(CompletionTokens._readonly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._property));
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._sharp));
        suggestions.add(new AIECompletionProposal(CompletionTokens._colon));
      } else if (lastToken instanceof EGenericElementTypeContext) {
        // reference type
        // parser assumes that Context is finished, but completion continues.
        final EReferenceContext fullContext =
            (EReferenceContext) AIECompletionUtil.createInstance().getFullContext(context);
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
        suggestions.add(new AIECompletionProposal(CompletionTokens._equals));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof EMultiplicityContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._equals));
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken instanceof EAnnotationContext) {
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.derivationSP().getStartSuggestions());
        suggestions.addAll(spFactory.initialSP().getStartSuggestions());
      } else if (lastToken instanceof DerivationContext || lastToken instanceof InitialContext) {
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._static)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._model));
        suggestions.add(new AIECompletionProposal(CompletionTokens._ghost));
        suggestions.add(new AIECompletionProposal(CompletionTokens._transient));
        suggestions.add(new AIECompletionProposal(CompletionTokens._volatile));
        suggestions.add(new AIECompletionProposal(CompletionTokens._readonly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._property));
      } else if (lastToken.getText().equals(CompletionTokens._model)
          || lastToken.getText().equals(CompletionTokens._ghost)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._transient));
        suggestions.add(new AIECompletionProposal(CompletionTokens._volatile));
        suggestions.add(new AIECompletionProposal(CompletionTokens._readonly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._property));
      } else if (lastToken.getText().equals(CompletionTokens._transient)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._volatile));
        suggestions.add(new AIECompletionProposal(CompletionTokens._readonly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._property));
      } else if (lastToken.getText().equals(CompletionTokens._volatile)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._readonly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._property));
      } else if (lastToken.getText().equals(CompletionTokens._readonly)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._property));
      } else if (lastToken.getText().equals(CompletionTokens._property)) {
        // property name
      } else if (lastToken.getText().equals(CompletionTokens._sharp)) {
        // opposite type
        final EReferenceContext fullContext =
            (EReferenceContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          final List<Element<?>> opposites = fullContext.current.getOpposites().stream()
              .map(s -> (Element<?>) s).collect(Collectors.toList());
          for (final Element<?> opposite : opposites) {
            suggestions.add(AIECompletionUtil.createInstance().createCompletionProposalForElement(
                opposite.getLabel(), opposite.getLabel(),
                ((ITarget) opposite).getRelativeSegment(fullContext.current), opposite));
          }
        }
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        // reference type
        final EReferenceContext fullContext =
            (EReferenceContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          if (fullContext.current instanceof ISource) {
            final Set<AIECompletionProposal> targetProposals =
                AIECompletionUtil.createInstance().getTargetProposals(fullContext.current);
            suggestions.addAll(targetProposals);
          }
        }
      } else if (lastToken.getText().equals(CompletionTokens._equals)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._singleQuote));
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftCurly));
        suggestions.add(new AIECompletionProposal(CompletionTokens._semicolon));
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._key));
        suggestions.add(new AIECompletionProposal(CompletionTokens._composes));
        suggestions.add(new AIECompletionProposal(CompletionTokens._acyclic));
        suggestions.add(new AIECompletionProposal(CompletionTokens._transitive));
        suggestions.add(new AIECompletionProposal(CompletionTokens._reflexive));
        suggestions.add(new AIECompletionProposal(CompletionTokens._irreflexive));
        suggestions.add(new AIECompletionProposal(CompletionTokens._symmetric));
        suggestions.add(new AIECompletionProposal(CompletionTokens._asymmetric));
        suggestions.add(new AIECompletionProposal(CompletionTokens._antisymmetric));
        suggestions.add(new AIECompletionProposal(CompletionTokens._total));
        suggestions.add(new AIECompletionProposal(CompletionTokens._functional));
        suggestions.add(new AIECompletionProposal(CompletionTokens._surjective));
        suggestions.add(new AIECompletionProposal(CompletionTokens._injective));
        suggestions.add(new AIECompletionProposal(CompletionTokens._bijective));
        suggestions.add(new AIECompletionProposal(CompletionTokens._complete));
        suggestions.add(new AIECompletionProposal(CompletionTokens._bijection));
        suggestions.add(new AIECompletionProposal(CompletionTokens._preorder));
        suggestions.add(new AIECompletionProposal(CompletionTokens._equivalence));
        suggestions.add(new AIECompletionProposal(CompletionTokens._partialorder));
        suggestions.add(new AIECompletionProposal(CompletionTokens._totalorder));
        suggestions.add(new AIECompletionProposal(CompletionTokens._derived));
        suggestions.add(new AIECompletionProposal(CompletionTokens._ordered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notOrdered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._unique));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notUnique));
        suggestions.add(new AIECompletionProposal(CompletionTokens._resolve));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notResolve));
        suggestions.add(new AIECompletionProposal(CompletionTokens._unsettable));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notUnsettable));
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.derivationSP().getStartSuggestions());
        suggestions.addAll(spFactory.initialSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._composes));
        suggestions.add(new AIECompletionProposal(CompletionTokens._acyclic));
        suggestions.add(new AIECompletionProposal(CompletionTokens._transitive));
        suggestions.add(new AIECompletionProposal(CompletionTokens._reflexive));
        suggestions.add(new AIECompletionProposal(CompletionTokens._irreflexive));
        suggestions.add(new AIECompletionProposal(CompletionTokens._symmetric));
        suggestions.add(new AIECompletionProposal(CompletionTokens._asymmetric));
        suggestions.add(new AIECompletionProposal(CompletionTokens._antisymmetric));
        suggestions.add(new AIECompletionProposal(CompletionTokens._total));
        suggestions.add(new AIECompletionProposal(CompletionTokens._functional));
        suggestions.add(new AIECompletionProposal(CompletionTokens._surjective));
        suggestions.add(new AIECompletionProposal(CompletionTokens._injective));
        suggestions.add(new AIECompletionProposal(CompletionTokens._bijective));
        suggestions.add(new AIECompletionProposal(CompletionTokens._complete));
        suggestions.add(new AIECompletionProposal(CompletionTokens._bijection));
        suggestions.add(new AIECompletionProposal(CompletionTokens._preorder));
        suggestions.add(new AIECompletionProposal(CompletionTokens._equivalence));
        suggestions.add(new AIECompletionProposal(CompletionTokens._partialorder));
        suggestions.add(new AIECompletionProposal(CompletionTokens._totalorder));
        suggestions.add(new AIECompletionProposal(CompletionTokens._derived));
        suggestions.add(new AIECompletionProposal(CompletionTokens._ordered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notOrdered));
        suggestions.add(new AIECompletionProposal(CompletionTokens._unique));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notUnique));
        suggestions.add(new AIECompletionProposal(CompletionTokens._resolve));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notResolve));
        suggestions.add(new AIECompletionProposal(CompletionTokens._unsettable));
        suggestions.add(new AIECompletionProposal(CompletionTokens._notUnsettable));
      } else if (lastToken.getText().equals(CompletionTokens._composes)
          || lastToken.getText().equals(CompletionTokens._acyclic)
          || lastToken.getText().equals(CompletionTokens._transitive)
          || lastToken.getText().equals(CompletionTokens._reflexive)
          || lastToken.getText().equals(CompletionTokens._irreflexive)
          || lastToken.getText().equals(CompletionTokens._symmetric)
          || lastToken.getText().equals(CompletionTokens._asymmetric)
          || lastToken.getText().equals(CompletionTokens._antisymmetric)
          || lastToken.getText().equals(CompletionTokens._total)
          || lastToken.getText().equals(CompletionTokens._functional)
          || lastToken.getText().equals(CompletionTokens._surjective)
          || lastToken.getText().equals(CompletionTokens._injective)
          || lastToken.getText().equals(CompletionTokens._bijective)
          || lastToken.getText().equals(CompletionTokens._complete)
          || lastToken.getText().equals(CompletionTokens._bijection)
          || lastToken.getText().equals(CompletionTokens._preorder)
          || lastToken.getText().equals(CompletionTokens._equivalence)
          || lastToken.getText().equals(CompletionTokens._partialorder)
          || lastToken.getText().equals(CompletionTokens._totalorder)
          || lastToken.getText().equals(CompletionTokens._derived)
          || lastToken.getText().equals(CompletionTokens._ordered)
          || lastToken.getText().equals(CompletionTokens._notOrdered)
          || lastToken.getText().equals(CompletionTokens._unique)
          || lastToken.getText().equals(CompletionTokens._notUnique)
          || lastToken.getText().equals(CompletionTokens._resolve)
          || lastToken.getText().equals(CompletionTokens._notResolve)
          || lastToken.getText().equals(CompletionTokens._unsettable)
          || lastToken.getText().equals(CompletionTokens._notUnsettable)) {
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
    return context instanceof EReferenceContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eStructuralFeatureSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.visibilityKindSP());
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.eGenericElementTypeSP());
    addChild(spFactory.multiplicitySP());
    addChild(spFactory.eAnnotationSP());
    addChild(spFactory.derivationSP());
    addChild(spFactory.initialSP());
  }

}
