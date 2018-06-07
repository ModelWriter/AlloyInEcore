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
 * An element is a constituent of a model.
 * <p>
 * Element is an abstract metaclass with no superclass. It is used as the common superclass for all metaclasses.
 * <p>
 * Subclasses of Element provide semantics appropriate to the concept they represent. An element can own comments. The
 * comments for an Element add no semantics but may represent information useful to the reader of the model.
 */
public interface Element {

    /**
     * The Elements owned by this element. This is a derived union.
     * <p>
     * The derived ownedElement association is subsetted (directly or indirectly) by all composed association ends in
     * the metamodel. Thus ownedElement provides a convenient way to access all the elements that are directly owned
     * by an Element.
     * @return /ownedElement: Element[*]
     */
    List<Element> ownedElement();

    /**
     * The Element that owns this element. This is a derived union.
     * <p>
     * <b>Constraints:</b>
     * <p>[1] An element may not directly or indirectly own itself.
     * <pre>
     *     not self.allOwnedElements()->includes(self)
     * </pre>
     *
     * [2] Elements that must be owned must have an owner.
     * <pre>
     *     self.mustBeOwned() implies owner->notEmpty()
     * </pre>
     * @return /owner: Element[0..1]
     */
    Element owner();

    /**
     * @see Element#ownedElement()
     * @return {@code /ownedComment: Comment[*] {subsets Element::ownedElement}}
     */
    default List<Comment> ownedComment(){ return this.getOwnedElements(Comment.class); }

    //TODO check this recursion whether it works
    /**
     * The query allOwnedElements() gives all of the direct and indirect owned elements of an element.
     * <pre>
     *      allOwnedElements =
     *          ownedElement->union(ownedElement->collect(e | e.allOwnedElements()))
     * </pre>
     * @return Element::allOwnedElements(): Set(Element)
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
     * The query mustBeOwned() indicates whether elements of this type must have an owner. Subclasses of Element that
     * do not require an owner must override this operation.
     *
     * @return Element::mustBeOwned() : Boolean
     */
    default boolean mustBeOwned(){
        return true;
    }



    default <E extends Element> List<E> getOwnedElements(Class<E> type) {
        List<E> elements = new ArrayList<>();
        for (Element e : ownedElement())
            if (type.isInstance(e)) elements.add(type.cast(e));
        return elements;
    }

    default <E extends Element> E getOwnedElement(Class<E> type) {
        Optional<Element> optional = this.ownedElement().stream().filter(type::isInstance).findFirst();
        return optional.map(type::cast).orElse(null);
    }

    void setOwner(final Element owner);

    <E extends Element> void addOwnedElement(E child);

    default  <E extends Element> void addOwnedElements(final E... child) {
        for (E aChild : child) {
            addOwnedElement(aChild);
        }
    }

    default <E extends Element> void addOwnedElements(final List<E> children) {
        for (E child : children) {
            addOwnedElement(child);
        }
    }

    default String segment() {
        return "::" + this.getClass().getSimpleName() + "." + this.hashCode();
    }

    default String getFullPath() {
        String name = this.segment();
        for (Element parent = this.owner(); parent != null; parent = parent.owner()) {
            name = parent.segment() + name;
        }
        return name;
    }

    <E extends Element> boolean deleteOwnedElement(E child);

}
