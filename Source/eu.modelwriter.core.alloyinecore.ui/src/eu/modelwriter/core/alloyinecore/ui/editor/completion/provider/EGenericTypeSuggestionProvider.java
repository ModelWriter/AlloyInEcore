package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeArgumentContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PathNameContext;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.INavigable;
import eu.modelwriter.core.alloyinecore.structure.base.ISource;
import eu.modelwriter.core.alloyinecore.structure.base.ITarget;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.Classifier;
import eu.modelwriter.core.alloyinecore.structure.model.GenericType;
import eu.modelwriter.core.alloyinecore.structure.model.TypeParameter;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EGenericTypeSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<ICompletionProposal> getStartSuggestions() {
    final Set<ICompletionProposal> startSuggestions = new HashSet<>();
    startSuggestions.addAll(spFactory.pathNameSP().getStartSuggestions());
    return startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    parents.add(spFactory.eGenericExceptionSP());
    parents.add(spFactory.eGenericSuperTypeSP());
    parents.add(spFactory.eTypeParameterSP());
    parents.add(spFactory.eGenericTypeArgumentSP());
    parents.add(spFactory.eGenericElementTypeSP());
    parents.add(spFactory.eGenericWildcardSP());
  }

  @Override
  protected void initChildProviders() {
    children.add(spFactory.pathNameSP());
    children.add(spFactory.eGenericTypeArgumentSP());
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof PathNameContext) {
        suggestions.add(new AIECompletionProposal(CompletionTokens._leftArrow));
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof EGenericTypeArgumentContext) {
        // super type
        final EGenericTypeContext fullContext =
            (EGenericTypeContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          final GenericType genericType = (GenericType) fullContext.current;
          if (genericType instanceof INavigable) {
            final Element<?> owner = genericType.getOwner(Classifier.class);
            // get referenced element of generic type as target.
            final ITarget element = ((INavigable) genericType).getTarget();
            if (element instanceof ISource) {
              // getting type parameter targets of element
              ((ISource) element).getTargets().forEach(t -> {
                if (t instanceof TypeParameter) {
                  // getting generic types of each type parameter
                  ((TypeParameter) t).getOwnedElements(GenericType.class).forEach(gt -> {
                    // getting referenced elements of each generic type
                    final ITarget target = ((INavigable) gt).getTarget();
                    suggestions
                    .add(AIECompletionUtil.createInstance().createCompletionProposalForElement(
                        target.getRelativeSegment(owner), null, null, target.asElement()));
                    if (target instanceof Class) {
                      // getting subclasses of each referenced element.
                      ((Class) target).getAllSubTypes().forEach(st -> {
                        suggestions.add(
                            AIECompletionUtil.createInstance().createCompletionProposalForElement(
                                st.getRelativeSegment(owner), null, null, st.asElement()));
                      });
                    }
                  });
                }
              });
            }
          }
        }
        suggestions.add(new AIECompletionProposal(CompletionTokens._comma));
        suggestions.add(new AIECompletionProposal(CompletionTokens._rightArrow));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._leftArrow)
          || lastToken.getText().equals(CompletionTokens._comma)) {
        // super type
        final EGenericTypeContext fullContext =
            (EGenericTypeContext) AIECompletionUtil.createInstance().getFullContext(context);
        if (fullContext != null) {
          final GenericType genericType = (GenericType) fullContext.current;
          if (genericType instanceof INavigable) {
            final Element<?> owner = genericType.getOwner(Classifier.class);
            // get referenced element of generic type as target.
            final ITarget element = ((INavigable) genericType).getTarget();
            if (element instanceof ISource) {
              // getting type parameter targets of element
              ((ISource) element).getTargets().forEach(t -> {
                if (t instanceof TypeParameter) {
                  // getting generic types of each type parameter
                  ((TypeParameter) t).getOwnedElements(GenericType.class).forEach(gt -> {
                    // getting referenced elements of each generic type
                    final ITarget target = ((INavigable) gt).getTarget();
                    suggestions
                    .add(AIECompletionUtil.createInstance().createCompletionProposalForElement(
                        target.getRelativeSegment(owner), null, null, target.asElement()));
                    if (target instanceof Class) {
                      // getting subclasses of each referenced element.
                      ((Class) target).getAllSubTypes().forEach(st -> {
                        suggestions.add(
                            AIECompletionUtil.createInstance().createCompletionProposalForElement(
                                st.getRelativeSegment(owner), null, null, st.asElement()));
                      });
                    }
                  });
                }
              });
            }
          }
        }
      } else if (lastToken.getText().equals(CompletionTokens._rightArrow)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EGenericTypeContext;
  }

}
