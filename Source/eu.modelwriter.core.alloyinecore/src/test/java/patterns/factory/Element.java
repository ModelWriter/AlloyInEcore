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

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p><b>Element [Abstract Class]</b>
 * <p><b>Description:</b>
 * <p>An Element is a constituent of a model. As such, it has the capability of owning other Elements.
 * <p><b>Semantics:</b>
 * An element is a constituent of a model.  Descendants of Element provide semantics appropriate
 * to the concept they represent.
 * <p>Every Element has the inherent capability of owning other Elements. When an Element is removed from a model, all
 * its {@code ownedElements} are also necessarily removed from the model. The abstract syntax for each kind of Element
 * specifies what other kind of Elements it may own. Every Element in a model must be owned by exactly one other Element
 * of that model, with the exception of the top-level Packages of the model.
 * <p><b>Constraints:</b>
 * <p>[1] An element may not directly or indirectly own itself.
 * <pre>
 *     not self.allOwnedElements()->includes(self)
 * </pre>
 * <p>[2] Elements that must be owned must have an owner.
 * <pre>
 *     self.mustBeOwned() implies owner->notEmpty()
 * </pre>
 */
public interface Element {

    default void speak () {
        System.out.println("I'm an abstract element");
    }

    /**
     * The Comments owned by this Element.
     * @see Element#ownedElement() Element::ownedElement
     * @return ♦ {@code ownedComment: Comment[*] {subsets Element::ownedElement}}
     */
    List<Comment> ownedComment();

    /**
     * The Elements owned by this Element.
     * @see Element#owner() Element::owner
     * @return ♦ {@code /ownedElement: Element[*] {union} {opposite Element::owner} }
     */
    List<Element> ownedElement();

    /**
     * The Element that owns this Element.
     * @see Element#ownedElement() Element::ownedElement
     * @return {@code /owner: Element[0..1] {union} {opposite Element::ownedElement} }
     */
    Element owner();


    //TODO check this recursion whether it works
    /**
     * The query allOwnedElements() gives all of the direct and indirect owned elements of an element.
     * <pre>
     * body: ownedElement->union(ownedElement->collect(e | e.allOwnedElements()))->asSet()
     * </pre>
     * @return allOwnedElements(): Element[0..*]
     */
    default List<Element> allOwnedElements(){
        List<Element> elements = new ArrayList<>();
        if (!this.ownedElement().isEmpty()) {
            elements.addAll(this.ownedElement());
            for (Element e : ownedElement()) {
                elements.addAll(e.allOwnedElements());
            }
        }
        return elements;
    }

    /**
     * The query mustBeOwned() indicates whether Elements of this type must have an owner. Subclasses of Element that do
     * not require an owner must override this operation.
     * <pre>
     * body: true
     * </pre>
     * @return mustBeOwned() : Boolean
     */
    default boolean mustBeOwned(){
        return true;
    }

    default <E extends Element> List<E> ownedElement(Class<E> type) {
        List<E> elements = new ArrayList<>();
        for (Element e : this.ownedElement())
            if (type.isInstance(e)) elements.add(type.cast(e));
        return elements;
    }

    default  <E extends Element> void addOwnedElement(final E... child) {
        for (E aChild : child) {
            this.ownedElement().add(aChild);
        }
    }

    default <E extends Element> void addOwnedElement(final List<E> children) {
        for (E child : children) {
            this.ownedElement().add(child);
        }
    }

}
