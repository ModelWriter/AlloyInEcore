package eu.modelwriter.core.alloyinecore.ui.editor.scanner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;

import eu.modelwriter.core.alloyinecore.ui.editor.AIEKeywords;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IAIEColorConstants;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IColorManager;

public class AIECodeScanner extends RuleBasedScanner {

  protected IToken defaultToken;
  protected IToken keyword;
  protected IToken stringToken;
  protected IToken singlelineToken;
  protected IToken multilineToken;
  protected IToken aieKeyword;
  protected IToken scopeTokens;

  public AIECodeScanner(final IColorManager manager) {
    defaultToken = new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_DEFAULT)));
    aieKeyword = new Token(
        new TextAttribute(manager.getColor(IAIEColorConstants.AIE_KEYWORD), null, SWT.ITALIC));
    keyword =
        new Token(new TextAttribute(manager.getColor(IAIEColorConstants.KEYWORD), null, SWT.BOLD));
    stringToken = new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_STRING)));
    singlelineToken =
        new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_SINGLE_LINE_COMMENT)));
    multilineToken =
        new Token(new TextAttribute(manager.getColor(IAIEColorConstants.AIE_MULTI_LINE_COMMENT)));
    scopeTokens = new Token(
        new TextAttribute(manager.getColor(IAIEColorConstants.AIE_SCOPE), null, SWT.BOLD));
    configureRules();
  }

  public void configureRules() {
    final List<IRule> rules = new ArrayList<IRule>();
    rules.addAll(getCommentRules());
    final WordRule keywordRule = new WordRule(new IWordDetector() {

      @Override
      public boolean isWordPart(final char c) {
        return Character.isLetter(c);
      }

      @Override
      public boolean isWordStart(final char c) {
        return Character.isLetter(c);
      }
    }, defaultToken);

    AIEKeywords.ALL_BUT_AIE.forEach(k -> {
      keywordRule.addWord(k, keyword);
    });

    for (int i = 0; i < AIEKeywords.AIE.length; i++) {
      keywordRule.addWord(AIEKeywords.AIE[i], aieKeyword);
    }
    rules.add(keywordRule);

    rules.add(new SingleLineRule("[", "]", scopeTokens) {
      @Override
      protected boolean sequenceDetected(ICharacterScanner scanner, char[] sequence,
          boolean eofAllowed) {
        int c = scanner.read();
        if (sequence[0] == '[') {
          if (!Character.isDigit(c)) {
            scanner.unread();
            return false;
          }
        } else if (sequence[0] == ']') {
          scanner.unread();
        }
        int ctr = 0;
        while (scanner.getColumn() > 0) {
          scanner.unread();
          ctr++;
        }
        char[] chars = new char[ctr];
        int i = 0;
        while (ctr != 0) {
          chars[i] = ((char) scanner.read());
          ctr--;
          i++;
        }
        String str = new String(chars);
        if (!(str.contains("class") || str.contains("interface")))
          return false;
        return super.sequenceDetected(scanner, sequence, eofAllowed);
      }
    });

    final IRule[] result = new IRule[rules.size()];
    rules.toArray(result);
    setRules(result);
  }

  protected List<IRule> getCommentRules() {
    final List<IRule> rules = new ArrayList<IRule>();

    rules.add(new MultiLineRule("\"", "\"", stringToken, '\\'));
    rules.add(new MultiLineRule("'", "'", stringToken, '\\'));

    // Add rules for multi-line comments.
    rules.add(new MultiLineRule("/*", "*/", multilineToken));
    // Add rule for single line comments.
    rules.add(new EndOfLineRule("--", singlelineToken));

    // whitespace rule for skipping whitespaces.
    rules.add(new WhitespaceRule(new IWhitespaceDetector() {

      @Override
      public boolean isWhitespace(final char c) {
        return Character.isWhitespace(c);
      }

    }));
    return rules;
  }
}
