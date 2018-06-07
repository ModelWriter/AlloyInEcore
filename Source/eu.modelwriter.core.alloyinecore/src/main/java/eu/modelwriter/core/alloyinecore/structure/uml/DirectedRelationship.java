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

package eu.modelwriter.core.alloyinecore.structure.uml;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <b>Description:</b>
 * <p>
 * A directed relationship represents a relationship between a collection of source model elements and a collection of
 * target model elements. A directed relationship references one or more source elements and one or more target
 * elements. DirectedRelationship is an abstract metaclass.
 * <p>
 * <b>Semantics: </b>
 * <p>
 * DirectedRelationship has no specific semantics. The various subclasses of DirectedRelationship will add semantics
 * appropriate to the concept they represent.
 * <p>
 * <b>Notation: </b>
 * <p>
 * There is no general notation for a DirectedRelationship. The specific subclasses of DirectedRelationship will
 * define their own notation. In most cases the notation is a variation on a line drawn from the source(s) to the
 * target(s).
 *
 */
public interface DirectedRelationship extends Relationship {

    /**
     * Specifies the sources of the DirectedRelationship. This is a derived union.
     * <p>
     * @see Relationship#relatedElement
     * @return {@code /source: Element[1..*] {subsets Relationship::relatedElement}}
     */
    List<Element> source();

    /**
     * Specifies the targets of the DirectedRelationship. This is a derived union.
     * <p>
     * @see Relationship#relatedElement
     * @return {@code /source: Element[1..*] {subsets Relationship::relatedElement}}
     */
    List<Element> target();

    @Override
    default List<Element> relatedElement(){
        return Stream.concat(source().stream(), target().stream()).collect(Collectors.toList());
    }
}
