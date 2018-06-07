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
 * <p><b>Relationship [Abstract Class]</b>
 * <p><b>Description:</b>
 * <p> Relationship is an abstract concept that specifies some kind of relationship between Elements.
 * <p><b>Semantics:</b>
 * <p> A Relationship is an Element that specifies some kind of relationship between other Elements. Descendants of
 * Relationship provide semantics appropriate to the concept they represent.
 */
public interface Relationship extends Element {
    /**
     * Specifies the elements related by the Relationship.
     * @return /relatedElement: Element[1..*] {union} {opposite A_relatedElement_relationship::relationship}
     */
    List<Element> relatedElement();
}
