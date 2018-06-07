package eu.modelwriter.core.alloyinecore.typechecking;

import org.antlr.v4.runtime.Token;

import javax.tools.Diagnostic;
import java.util.HashSet;
import java.util.Set;

public class Trace {
    private Set<Token> tokens;
    private String fileName;
    private int lineNumber, startOffset, endOffset;

    public Trace(String fileName, int lineNumber, int startOffset, int endOffset) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        tokens = new HashSet<>();
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public Set<Token> getTokens() {
        return tokens;
    }

    public boolean overlaps(Diagnostic diagnostic) {
        int start = (int) (diagnostic.getStartPosition() - 1);
        int stop = (int) (diagnostic.getEndPosition() - 1);
        return ((JavaSourceFromString) diagnostic.getSource()).getRawName().equals(fileName) &&
                offsetOverlaps(start, stop) && diagnostic.getLineNumber() - 1 == lineNumber;
    }

    public boolean offsetOverlaps(int start, int stop) {
        return (start >= startOffset && stop <= endOffset) || (startOffset >= start && endOffset <= stop);
    }
}
