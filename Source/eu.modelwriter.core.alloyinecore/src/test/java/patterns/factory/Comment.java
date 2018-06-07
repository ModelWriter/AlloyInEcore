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

package patterns.factory;

import java.util.List;

/**
 * <p><b>Comment [Class]</b>
 * <p><b>Description:</b>
 * <p> A Comment is a textual annotation that can be attached to a set of Elements.
 * <p><b>Semantics:</b>
 * <p> Every kind of Element may own Comments. The ownedComments for an Element add no semantics but may represent
 * information useful to the reader of the model.
 */
public interface Comment extends Element {
    /**
     * Specifies a string that is the comment.
     * @return body: String[0..1]
     */
    String body();

    /**
     * References the Element(s) being commented.
     * @return annotatedElement: Element[0..*] {opposite A_annotatedElement_comment::comment)}
     */
    List<Element> annotatedElement();

    default void speak () {
        System.out.println("I'm an concrete comment!");
    }
}
