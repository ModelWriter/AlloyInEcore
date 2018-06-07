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
 * <p><b>DirectedRelationship [Abstract Class]</b>
 * <p><b>Description:</b>
 * <p> A DirectedRelationship represents a relationship between a collection of source model Elements and a collection
 * of target model Elements.
 * <p><b>Semantics:</b>
 * <p> A DirectedRelationship represents a Relationship between a collection of source model elements and a collection
 * of target model elements. A DirectedRelationship is said to be directed from the source elements to the target
 * elements.
 */
public interface DirectedRelationship {

    /**
     * Specifies the source Element(s) of the DirectedRelationship.
     * @see Relationship#relatedElement() Relationship::relatedElement
     * @return /source: Element[1..*] {union, subsets Relationship::relatedElement} {opposite
     * A_source_directedRelationship::directedRelationship}
     */
    List<Element> source();

    /**
     * Specifies the target Element(s) of the DirectedRelationship.
     * @see Relationship#relatedElement() Relationship::relatedElement
     * @return /target: Element[1..*] {union, subsets Relationship::relatedElement} {opposite
     * A_target_directedRelationship::directedRelationship}
     */
    List<Element> target();

}
