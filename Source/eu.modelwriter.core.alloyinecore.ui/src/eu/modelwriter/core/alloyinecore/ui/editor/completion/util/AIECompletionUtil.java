package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModelContext;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.ISource;
import eu.modelwriter.core.alloyinecore.structure.base.ITarget;
import eu.modelwriter.core.alloyinecore.structure.model.IVisibility;
import eu.modelwriter.core.alloyinecore.structure.model.Model;
import eu.modelwriter.core.alloyinecore.ui.Activator;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.AIECompletionProposal;
import eu.modelwriter.core.alloyinecore.ui.editor.document.AIEDocument;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;

public class AIECompletionUtil {
  private static IDocument document;
  private static int offset;
  private static int minDistance;
  private static ParseTree closerNode;
  private static ParseTree lastNode;
  private static boolean isOppositeCompletion;

  private AlloyInEcoreLexer cutDocLexer;
  private CommonTokenStream cutDocTokens;
  private AlloyInEcoreParser cutDocParser;

  public AIECompletionUtil() {
    this(AIECompletionUtil.document, AIECompletionUtil.offset);
  }

  public AIECompletionUtil(final IDocument document, final int offset) {
    AIECompletionUtil.document = document;
    AIECompletionUtil.offset = offset;
    AIECompletionUtil.minDistance = Integer.MAX_VALUE;
    AIECompletionUtil.closerNode = null;
    AIECompletionUtil.lastNode = null;
  }

  public Set<ICompletionProposal> getProposals() throws BadLocationException {
    cutDocLexer = new AlloyInEcoreLexer(
        new ANTLRInputStream(AIECompletionUtil.document.get(0, AIECompletionUtil.offset)));
    cutDocTokens = new CommonTokenStream(cutDocLexer);
    cutDocParser = new AlloyInEcoreParser(cutDocTokens);

    final ModelContext cutModelCtx = cutDocParser.model(null);

    findCloserNode(cutModelCtx);

    if (AIECompletionUtil.closerNode == null) {
      AIECompletionUtil.closerNode = cutModelCtx;
    }

    final ParserRuleContext parentOfCloserNode =
        (ParserRuleContext) AIECompletionUtil.closerNode.getParent();

    if (parentOfCloserNode instanceof EReferenceContext
        && AIECompletionUtil.closerNode instanceof TerminalNode
        && AIECompletionUtil.closerNode.getText().equals(CompletionTokens._sharp)) {
      AIECompletionUtil.isOppositeCompletion = true;
    } else {
      AIECompletionUtil.isOppositeCompletion = false;
    }

    final SuggestionDetector suggestionDetector = new SuggestionDetector(AIECompletionUtil.document,
        AIECompletionUtil.offset, parentOfCloserNode, AIECompletionUtil.closerNode);

    final Set<ICompletionProposal> allProposals = suggestionDetector.detect();

    return allProposals;
  }

  public String getLastBrokenText() {
    return AIECompletionUtil.lastNode != null ? AIECompletionUtil.lastNode.getText() : null;
  }

  private void findCloserNode(final ParseTree root) {
    if (root instanceof ParserRuleContext) {
      if (((ParserRuleContext) root).getStart().getStartIndex() <= AIECompletionUtil.offset) {
        final int distance =
            AIECompletionUtil.offset - ((ParserRuleContext) root).getStart().getStartIndex();
        if (distance <= AIECompletionUtil.minDistance
            && ((ParserRuleContext) root).getStart().getType() != Recognizer.EOF) {
          AIECompletionUtil.minDistance = distance;
          AIECompletionUtil.closerNode = root;
        }
        if (root.getChildCount() > 0) {
          final List<ParseTree> ownedElements = ((ParserRuleContext) root).children;
          for (int i = 0; i < ownedElements.size(); i++) {
            final ParseTree element = ownedElements.get(i);
            findCloserNode(element);
          }
        }
      }
    } else if (root instanceof TerminalNode) {
      if (((TerminalNode) root).getSymbol().getStartIndex() <= AIECompletionUtil.offset) {
        final int distance =
            AIECompletionUtil.offset - ((TerminalNode) root).getSymbol().getStartIndex();
        if (distance <= AIECompletionUtil.minDistance) {
          AIECompletionUtil.minDistance = distance;
          if (!(root instanceof ErrorNode)) {
            AIECompletionUtil.closerNode = root;
          } else {
            AIECompletionUtil.lastNode = root;
          }
        }
      }
    }
  }

  public ParserRuleContext getFullContext(final ParserRuleContext cutCtx) {
    try {
      Model model = EditorUtils.parseDocument(AIECompletionUtil.document,
          URI.createPlatformResourceURI(
              ((AIEDocument) AIECompletionUtil.document).getiFile().getFullPath().toString(), true),
          new BaseErrorListener());

      if (AIECompletionUtil.isOppositeCompletion) {
        final String newContent = deleteSharpAtOffset();
        model = EditorUtils.parseString(newContent,
            URI.createPlatformResourceURI(
                ((AIEDocument) AIECompletionUtil.document).getiFile().getFullPath().toString(),
                true),
            new BaseErrorListener());
      }

      return findFullContext(model.getContext(), cutCtx);
    } catch (final Exception e) {
      return null;
    }
  }

  private String deleteSharpAtOffset() {
    final String content = AIECompletionUtil.document.get();
    final String contentThroughTheOffset = content.substring(0, AIECompletionUtil.offset);
    final int sharpIndex = contentThroughTheOffset.lastIndexOf(CompletionTokens._sharp);
    final String beforeSharp = content.substring(0, sharpIndex);
    final String afterSharp = content.substring(sharpIndex + 1, content.length());
    final String newContent = beforeSharp + afterSharp;
    return newContent;
  }

  private ParserRuleContext findFullContext(final ParserRuleContext fullCtx,
      final ParserRuleContext cutCtx) {
    if (fullCtx.getClass().equals(cutCtx.getClass())) {
      try {
        final Field currentElementFieldcutCtx = cutCtx.getClass().getField("current");
        final Field currentElementFieldFullCtx = fullCtx.getClass().getField("current");
        if (currentElementFieldcutCtx != null && currentElementFieldFullCtx != null) {
          final Element<?> cutCtxElement = (Element<?>) currentElementFieldcutCtx.get(cutCtx);
          final Element<?> fullCtxElement = (Element<?>) currentElementFieldFullCtx.get(fullCtx);
          if (cutCtxElement.getFullLocation().equals(fullCtxElement.getFullLocation())) {
            return fullCtx;
          }
        }
      } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
          | IllegalAccessException e) {
        e.printStackTrace();
      }
    } else {
      for (final ParseTree child : fullCtx.children) {
        if (child instanceof ParserRuleContext) {
          final ParserRuleContext context = findFullContext((ParserRuleContext) child, cutCtx);
          if (context != null) {
            return context;
          }
        }
      }
    }
    return null;
  }

  public Image getProposalImage(final Element<?> element) {
    Image image = Activator.getDefault().getImageRegistry().get(element.getClass().getSimpleName());
    if (element instanceof IVisibility) {
      final ImageDescriptor visibilityImgDesc = Activator.getDefault().getImageRegistry()
          .getDescriptor(((IVisibility) element).getVisibility().name().toString());
      final DecorationOverlayIcon doi =
          new DecorationOverlayIcon(image, visibilityImgDesc, IDecoration.BOTTOM_RIGHT);
      image = doi.createImage();
    }
    return image;
  }

  public Image getProposalImage(final String key) {
    return Activator.getDefault().getImageRegistry().get(key);
  }

  public String getLastSegmentOfPathName(final String pathName) {
    if (pathName == null) {
      return null;
    }
    return pathName.substring(pathName.lastIndexOf(CompletionTokens._doubleColon) != -1
        ? pathName.lastIndexOf(CompletionTokens._doubleColon) + 2 : 0);
  }

  public AIECompletionProposal createCompletionProposalForElement(final String replacementString,
      final String displayString, final String additionalInfo, final Element<?> element) {
    return new AIECompletionProposal(replacementString, getProposalImage(element),
        displayString != null ? displayString : getLastSegmentOfPathName(replacementString), null,
            additionalInfo);
  }

  public Set<AIECompletionProposal> getTargetProposals(final ISource element) {
    final Set<AIECompletionProposal> suggestions = new HashSet<>();
    for (final ITarget target : getTargets(element)) {
      final String pathName = target.getRelativeSegment((Element<?>) element);
      final AIECompletionProposal proposal =
          createCompletionProposalForElement(pathName, null, null, (Element<?>) target);
      suggestions.add(proposal);
    }
    return suggestions;
  }

  public Set<AIECompletionProposal> getTargetProposals(final ISource element, final Class<?> type) {
    final Set<AIECompletionProposal> suggestions = new HashSet<>();
    for (final ITarget target : getTargets(element, type)) {
      if (target.getClass().equals(type)) {
        final String pathName = target.getRelativeSegment((Element<?>) element);
        final AIECompletionProposal proposal =
            createCompletionProposalForElement(pathName, null, null, (Element<?>) target);
        suggestions.add(proposal);
      }
    }
    return suggestions;
  }

  private List<ITarget> getTargets(final ISource element) {
    return element.getTargets().stream().map(ITarget.class::cast).collect(Collectors.toList());
  }

  private List<ITarget> getTargets(final ISource element, final Class<?> type) {
    return getTargets(element).stream().filter(t -> t.getClass().equals(type))
        .collect(Collectors.toList());
  }

  public static AIECompletionUtil createInstance() {
    return new AIECompletionUtil();
  }
}
