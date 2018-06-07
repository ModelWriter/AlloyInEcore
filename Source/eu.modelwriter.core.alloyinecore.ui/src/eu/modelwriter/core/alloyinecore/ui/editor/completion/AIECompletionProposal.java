package eu.modelwriter.core.alloyinecore.ui.editor.completion;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jface.internal.text.html.BrowserInformationControlInput;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.BoldStylerProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension4;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension5;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension6;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension7;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

public class AIECompletionProposal implements ICompletionProposal, ICompletionProposalExtension3,
ICompletionProposalExtension5, ICompletionProposalExtension6, ICompletionProposalExtension7,
ICompletionProposalExtension, ICompletionProposalExtension2, ICompletionProposalExtension4 {

  private StyledString fDisplayString;
  private final String fReplacementString;
  private int fReplacementOffset;
  private int fReplacementLength;
  private int fCursorPosition;
  private final Image fImage;
  private final IContextInformation fContextInformation;
  private final String fAdditionalProposalInfo;
  private boolean fIsValidated;
  private int fPatternMatchRule;

  public AIECompletionProposal(final String replacementString) {
    this(replacementString, null, null, null, null);
  }

  public AIECompletionProposal(final String replacementString, final Image image,
      final String displayString, final IContextInformation contextInformation,
      final String additionalProposalInfo) {

    fReplacementString = replacementString;
    fImage = image;
    setDisplayString(displayString != null ? displayString : replacementString);
    fContextInformation = contextInformation;
    fAdditionalProposalInfo = additionalProposalInfo;
  }

  @Override
  public void apply(final IDocument document) {
    try {
      document.replace(fReplacementOffset, fReplacementLength, fReplacementString);
    } catch (final BadLocationException x) {
      // ignore
    }
  }

  @Override
  public Point getSelection(final IDocument document) {
    // if (!fIsValidated) {
    // return null;
    // }
    return new Point(getReplacementOffset() + getCursorPosition(), 0);
  }

  @Override
  public IContextInformation getContextInformation() {
    return fContextInformation;
  }

  @Override
  public Image getImage() {
    return fImage;
  }

  @Override
  public String getDisplayString() {
    if (fDisplayString != null) {
      return fDisplayString.getString();
    }
    return "";
  }

  @Override
  public String getAdditionalProposalInfo() {
    final Object info = getAdditionalProposalInfo(new NullProgressMonitor());
    return info == null ? null : info.toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if (this.getClass().isInstance(obj)
        && ((AIECompletionProposal) obj).getReplacementString().equals(getReplacementString())) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return getReplacementString().hashCode();
  }

  @Override
  public IInformationControlCreator getInformationControlCreator() {
    return new IInformationControlCreator() {
      @Override
      public IInformationControl createInformationControl(final Shell parent) {
        return new DefaultInformationControl(parent);
      }
    };
  }

  @Override
  public CharSequence getPrefixCompletionText(final IDocument document,
      final int completionOffset) {
    if (!isCamelCaseMatching()) {
      return getReplacementString();
    }

    final String prefix = getPrefix(document, completionOffset);
    return getCamelCaseCompound(prefix, getReplacementString());
  }

  @Override
  public int getPrefixCompletionStart(final IDocument document, final int completionOffset) {
    return getReplacementOffset();
  }

  @SuppressWarnings("restriction")
  @Override
  public Object getAdditionalProposalInfo(final IProgressMonitor monitor) {
    if (fDisplayString.getString().equals(getReplacementString())) {
      return fAdditionalProposalInfo;
    } else {
      return new BrowserInformationControlInput(null) {

        @Override
        public String getInputName() {
          return getDisplayString();
        }

        @Override
        public Object getInputElement() {
          return getDisplayString();
        }

        @Override
        public String getHtml() {
          return getReplacementString();
        }
      };
    }
  }

  @Override
  public StyledString getStyledDisplayString() {
    return fDisplayString;
  }

  @Override
  public StyledString getStyledDisplayString(final IDocument document, final int offset,
      final BoldStylerProvider boldStylerProvider) {
    final StyledString styledDisplayString = new StyledString();
    styledDisplayString.append(getStyledDisplayString());

    final String pattern = getPatternToEmphasizeMatch(document, offset);
    if (pattern != null && pattern.length() > 0) {
      final String displayString = styledDisplayString.getString();
      final int patternMatchRule = getPatternMatchRule(pattern, displayString);
      final int[] matchingRegions =
          SearchPattern.getMatchingRegions(pattern, displayString, patternMatchRule);
      AIECompletionProposal.markMatchingRegions(styledDisplayString, 0, matchingRegions,
          boldStylerProvider.getBoldStyler());
    }
    return styledDisplayString;
  }

  @Override
  public boolean isAutoInsertable() {
    return true;
  }

  @Override
  public void apply(final ITextViewer viewer, final char trigger, final int stateMask,
      final int offset) {
    apply(viewer.getDocument(), trigger, offset);
  }

  @Override
  public void selected(final ITextViewer viewer, final boolean smartToggle) {
    // TODO Auto-generated method stub

  }

  @Override
  public void unselected(final ITextViewer viewer) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean validate(final IDocument document, final int offset, final DocumentEvent event) {

    if (!isOffsetValid(offset)) {
      return fIsValidated = false;
    }

    fIsValidated = isValidPrefix(getPrefix(document, offset));

    if (fIsValidated && event != null) {
      // adapt replacement range to document change
      final int delta = (event.fText == null ? 0 : event.fText.length()) - event.fLength;
      final int newLength = Math.max(getReplacementLength() + delta, 0);
      setReplacementLength(newLength);
    }

    return fIsValidated;
  }

  @Override
  public void apply(final IDocument document, final char trigger, final int offset) {
    apply(document);
  }

  @Override
  public boolean isValidFor(final IDocument document, final int offset) {
    return validate(document, offset, null);
  }

  @Override
  public char[] getTriggerCharacters() {
    return null;
  }

  @Override
  public int getContextInformationPosition() {
    if (getContextInformation() == null) {
      return getReplacementOffset() - 1;
    }
    return getReplacementOffset() + getCursorPosition();
  }

  public int getReplacementLength() {
    return fReplacementLength;
  }

  public String getReplacementString() {
    return fReplacementString;
  }

  public void setReplacementOffset(final int replacementOffset) {
    fReplacementOffset = replacementOffset;
  }

  public void setReplacementLength(final int replacementLength) {
    fReplacementLength = replacementLength;
  }

  public void setCursorPosition(final int cursorPosition) {
    fCursorPosition = cursorPosition;
  }

  protected boolean isCamelCaseMatching() {
    return false;
  }

  protected String getPrefix(final IDocument document, final int offset) {
    try {
      final int length = offset - getReplacementOffset();
      if (length > 0) {
        return document.get(getReplacementOffset(), length);
      }
    } catch (final BadLocationException x) {
    }
    return "";
  }

  public int getReplacementOffset() {
    return fReplacementOffset;
  }

  protected final String getCamelCaseCompound(final String prefix, final String string) {
    if (prefix.length() > string.length()) {
      return string;
    }

    // a normal prefix - no camel case logic at all
    final String start = string.substring(0, prefix.length());
    if (start.equalsIgnoreCase(prefix)) {
      return string;
    }

    final char[] patternChars = prefix.toCharArray();
    final char[] stringChars = string.toCharArray();

    for (int i = 1; i <= stringChars.length; i++) {
      if (CharOperation.camelCaseMatch(patternChars, 0, patternChars.length, stringChars, 0, i)) {
        return prefix + string.substring(i);
      }
    }

    // Not a camel case match at all.
    // This should not happen -> stay with the default behavior
    return string;
  }

  protected int getCursorPosition() {
    return fCursorPosition;
  }

  protected boolean isValidPrefix(final String pattern) {
    return isPrefix(pattern, TextProcessor.deprocess(getDisplayString()));
  }

  protected boolean isPrefix(final String pattern, final String string) {
    if (pattern == null || string == null || pattern.length() > string.length()) {
      return false;
    }
    fPatternMatchRule = getPatternMatchRule(pattern, string);
    return fPatternMatchRule != -1;
  }

  protected int getPatternMatchRule(final String pattern, final String string) {
    String start;
    try {
      start = string.substring(0, pattern.length());
    } catch (final StringIndexOutOfBoundsException e) {
      return -1;
    }
    if (start.equalsIgnoreCase(pattern)) {
      return SearchPattern.R_PREFIX_MATCH;
    } else if (isCamelCaseMatching()
        && CharOperation.camelCaseMatch(pattern.toCharArray(), string.toCharArray())) {
      return SearchPattern.R_CAMELCASE_MATCH;
    } else if (isSubstringMatching()
        && CharOperation.substringMatch(pattern.toCharArray(), string.toCharArray())) {
      return SearchPattern.R_SUBSTRING_MATCH;
    } else {
      return -1;
    }
  }

  protected boolean isSubstringMatching() {
    return true;
  }

  protected boolean isOffsetValid(final int offset) {
    return getReplacementOffset() <= offset;
  }

  protected void setDisplayString(final String string) {
    fDisplayString = new StyledString(string);
  }

  protected String getPatternToEmphasizeMatch(final IDocument document, final int offset) {
    final int start = getPrefixCompletionStart(document, offset);
    final int patternLength = offset - start;
    String pattern = null;
    try {
      pattern = document.get(start, patternLength);
    } catch (final BadLocationException e) {
      // return null
    }
    return pattern;
  }

  public static void markMatchingRegions(final StyledString styledString, final int index,
      final int[] matchingRegions, final Styler styler) {
    if (matchingRegions != null) {
      int offset = -1;
      int length = 0;
      for (int i = 0; i + 1 < matchingRegions.length; i = i + 2) {
        if (offset == -1) {
          offset = index + matchingRegions[i];
        }

        // Concatenate adjacent regions
        if (i + 2 < matchingRegions.length
            && matchingRegions[i] + matchingRegions[i + 1] == matchingRegions[i + 2]) {
          length = length + matchingRegions[i + 1];
        } else {
          styledString.setStyle(offset, length + matchingRegions[i + 1], styler);
          offset = -1;
          length = 0;
        }
      }
    }
  }

  @Override
  public String toString() {
    return fReplacementString;
  }
}
