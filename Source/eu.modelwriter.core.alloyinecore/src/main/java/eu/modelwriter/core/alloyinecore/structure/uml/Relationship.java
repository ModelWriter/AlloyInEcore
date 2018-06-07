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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <b>Description:</b>
 * <p>
 * Relationship is an abstract concept that specifies some kind of relationship between elements. A relationship
 * references one or more related elements. Relationship is an abstract metaclass.
 * <p>
 * <b>Semantics: </b>
 * <p>
 * Relationship has no specific semantics. The various subclasses of Relationship will add semantics appropriate to the
 * concept they represent.
 * <p>
 * <b>Notation: </b>
 * <p>
 * There is no general notation for a Relationship. The specific subclasses of Relationship will define their own
 * notation. In most cases the notation is a variation on a line drawn between the related elements.
 */
public interface Relationship extends Element {

    /**
     * Specifies the elements related by the Relationship. This is a derived union.
     *
     * @return /relatedElement: Element [1..*]
     */
    List<Element> relatedElement();

    default <E extends Element> void addRelatedElement(E element){
        relatedElement().add(element);
    }

    default <E extends Element> List<E> relatedElement(Class<E> type) {
        List<E> elements = new ArrayList<>();
        for (Element e : relatedElement())
            if (type.isInstance(e)) elements.add(type.cast(e));
        return elements;
    }

    default <E extends Element> E relatedElementFirstOrNull(Class<E> type) {
        Optional<Element> optional = this.relatedElement().stream().filter(type::isInstance).findFirst();
        return optional.map(type::cast).orElse(null);
    }
}
