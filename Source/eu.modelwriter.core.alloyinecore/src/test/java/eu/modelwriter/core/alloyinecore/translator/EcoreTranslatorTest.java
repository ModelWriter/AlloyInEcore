/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore.translator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EcoreTranslatorTest {

    private EcoreTranslator translator;

    @Before
    public void before() {
        translator = new EcoreTranslator();
    }

    @Test
    public void translatorTest() throws NullPointerException, IOException {
        String actual = translator.translate("./src/test/resources/EcoreTranslator/Test.ecore");
        String expected = getString("./src/test/resources/EcoreTranslator/Test.recore");
        assertEquals((expected), (actual));
    }

    @Test
    public void packageTranslate() throws IOException {
        String actual = translator.translate("./src/test/resources/EcoreTranslator/PackageTest.ecore");
        String expected = getString("./src/test/resources/EcoreTranslator/PackageTest.recore");
        assertEquals((expected), (actual));
    }

    @Test
    public void classifierTranslate() throws IOException {
        String actual = translator.translate("./src/test/resources/EcoreTranslator/ClassifierTest.ecore");
        String expected = getString("./src/test/resources/EcoreTranslator/ClassifierTest.recore");
        assertEquals((expected), (actual));
    }

    @Test
    public void attributeTranslate() throws IOException {
        String actual = translator.translate("./src/test/resources/EcoreTranslator/AttrTest.ecore");
        String expected = getString("./src/test/resources/EcoreTranslator/AttrTest.recore");
        assertEquals((expected), (actual));
    }

    @Test
    public void referenceTranslate() throws IOException {
        String actual = translator.translate("./src/test/resources/EcoreTranslator/ReferenceTest.ecore");
        String expected = getString("./src/test/resources/EcoreTranslator/ReferenceTest.recore");
        assertEquals((expected), (actual));
    }

    @Test
    public void operationTranslate() throws IOException {
        String actual = translator.translate("./src/test/resources/EcoreTranslator/OperationTest.ecore");
        String expected = getString("./src/test/resources/EcoreTranslator/OperationTest.recore");
        assertEquals((expected), (actual));
    }

    @Test
    public void annotationTranslate() throws IOException {
        String actual = translator.translate("./src/test/resources/EcoreTranslator/AnnotationTest.ecore");
        String expected = getString("./src/test/resources/EcoreTranslator/AnnotationTest.recore");
        assertEquals((expected), (actual));
    }

    @Test
    public void genericsTranslate() throws IOException {
        String actual = translator.translate("./src/test/resources/EcoreTranslator/GenericsTest.ecore");
        String expected = getString("./src/test/resources/EcoreTranslator/GenericsTest.recore");
        assertEquals((expected), (actual));
    }

    @Test
    public void ecoreTranslate() throws IOException {
        String actual = translator.translate("./src/test/resources/EcoreTranslator/Ecore.ecore");
        String expected = getString("./src/test/resources/EcoreTranslator/Ecore.recore");
        assertEquals((expected), (actual));
    }

    private String getString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
    }

    private void writeString(String fileName, String content) {
        try {
            Files.write(Paths.get(fileName), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final static String whitespace_chars = "" /* dummy empty string for homogeneity */
            + "\\u0009" // CHARACTER TABULATION
            + "\\u000A" // LINE FEED (LF)
            + "\\u000B" // LINE TABULATION
            + "\\u000C" // FORM FEED (FF)
            + "\\u000D" // CARRIAGE RETURN (CR)
            + "\\u0020" // SPACE
            + "\\u0085" // NEXT LINE (NEL)
            + "\\u00A0" // NO-BREAK SPACE
            + "\\u1680" // OGHAM SPACE MARK
            + "\\u180E" // MONGOLIAN VOWEL SEPARATOR
            + "\\u2000" // EN QUAD
            + "\\u2001" // EM QUAD
            + "\\u2002" // EN SPACE
            + "\\u2003" // EM SPACE
            + "\\u2004" // THREE-PER-EM SPACE
            + "\\u2005" // FOUR-PER-EM SPACE
            + "\\u2006" // SIX-PER-EM SPACE
            + "\\u2007" // FIGURE SPACE
            + "\\u2008" // PUNCTUATION SPACE
            + "\\u2009" // THIN SPACE
            + "\\u200A" // HAIR SPACE
            + "\\u2028" // LINE SEPARATOR
            + "\\u2029" // PARAGRAPH SEPARATOR
            + "\\u202F" // NARROW NO-BREAK SPACE
            + "\\u205F" // MEDIUM MATHEMATICAL SPACE
            + "\\u3000" // IDEOGRAPHIC SPACE
            ;
    /* A \s that actually works for Java’s native character set: Unicode */
    private final static String whitespace_charclass = "[" + whitespace_chars + "]";

    public static String removeAllWhiteSpaces(final String str) {
        return str.replaceAll(whitespace_charclass, "");
    }

}
