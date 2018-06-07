package eu.modelwriter.core.alloyinecore.ui.editor.completion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;

public class AIECompletionProcessor implements IContentAssistProcessor {

  private final List<Character> activationCharsAsList =
      new ArrayList<>(Arrays.asList('#', ':', '=', ',', '.', '&', '@'));
  private final char[] activationChars = new char[] {'#', ':', '=', ',', '.', '&', '@'};

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<>();

    final IDocument document = viewer.getDocument();

    final AIECompletionUtil completionUtil = new AIECompletionUtil(document, offset);

    Set<AIECompletionProposal> completionWords;
    try {
      completionWords = completionUtil.getProposals().stream().map(p -> (AIECompletionProposal) p)
          .collect(Collectors.toSet());
    } catch (final BadLocationException e1) {
      return new ICompletionProposal[0];
    }

    Character c = null;
    try {
      c = document.getChar(offset - 1);
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }


    if (Character.isAlphabetic(c) || activationCharsAsList.contains(c)) {
      String lastBrokenText = completionUtil.getLastBrokenText();

      if (lastBrokenText == null) {
        int index = offset - 1;
        StringBuilder sb = new StringBuilder();
        while (Character.isAlphabetic(c) || activationCharsAsList.contains(c)) {
          try {
            sb.append(c);
            c = document.getChar(--index);
          } catch (final BadLocationException e) {
            e.printStackTrace();
          }
        }
        sb = sb.reverse();
        lastBrokenText = sb.toString();
      }

      int replacementLength = lastBrokenText != null ? lastBrokenText.length() : 0;

      if (replacementLength > 0) {
        if (!(replacementLength > 1) && !Character.isAlphabetic(lastBrokenText.charAt(0))) {
          replacementLength--;
        } else {
          String regex = "(\\S*)";
          for (final char ch : lastBrokenText.toCharArray()) {
            regex += "(" + ch + ")" + "(\\S*)";
          }
          final Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
          completionWords =
              completionWords.stream().filter(cp -> p.matcher(cp.getReplacementString()).find())
              .collect(Collectors.toSet());
        }
      }

      for (final AIECompletionProposal cp : completionWords) {
        cp.setReplacementOffset(offset - replacementLength);
        cp.setReplacementLength(replacementLength);
        cp.setCursorPosition(cp.getReplacementString().length());
        proposals.add(cp);
      }
    } else {
      for (final AIECompletionProposal cp : completionWords) {
        cp.setReplacementOffset(offset);
        cp.setReplacementLength(0);
        cp.setCursorPosition(cp.getReplacementString().length());
        proposals.add(cp);
      }
    }

    final ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
    proposals.toArray(result);
    return result;
  }

  @Override
  public char[] getCompletionProposalAutoActivationCharacters() {
    return activationChars;
  }

  private final IContextInformation[] NO_CONTEXTS = {};

  @Override
  public IContextInformation[] computeContextInformation(final ITextViewer viewer,
      final int offset) {
    return NO_CONTEXTS;
  }

  @Override
  public char[] getContextInformationAutoActivationCharacters() {
    return null;
  }

  @Override
  public String getErrorMessage() {
    return "No suggestions available.";
  }

  @Override
  public IContextInformationValidator getContextInformationValidator() {
    return new ContextInformationValidator(this);
  }
}
