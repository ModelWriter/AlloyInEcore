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

/**
 * A named element represents elements with names.
 * <p>
 * Elements with names are instances of NamedElement.
 */
public interface NamedElement extends Element, IVisibility {

    /**
     * The name of the NamedElement. The name for a named element is optional. If specified, then any valid string,
     * including the empty string, may be used.
     * @return name: String [0..1]
     */
    String name();

    /**
     * The Namespace that owns this NamedElement.
     * @return namespace: NamedElement [0..1]
     */
    default NamedElement namespace(){ return (NamedElement) owner();}

    /**
     * A name which allows the NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed
     * from the names of the containing namespaces starting at the root of the hierarchy and ending with the name of the
     * NamedElement itself. This is a derived attribute.
     * <p>
     * <b>Constraints:</b>
     * <p>
     * [1] If there is no name, or one of the containing namespaces has no name, there is no qualified name.
     * <pre>
     *     (self.name->isEmpty() or self.allNamespaces()->select(ns | ns.name->isEmpty())->notEmpty())
     *          implies self.qualifiedName->isEmpty()
     * </pre>
     * <p>
     * [2] When there is a name, and all of the containing namespaces have a name, the qualified name is constructed
     * from the names of the containing namespaces.
     * <pre>
     *     (self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty()) implies
     *          self.qualifiedName = self.allNamespaces()->iterate( ns : Namespace; result: String = self.name |
     *              ns.name->union(self.separator())->union(result))
     * </pre>
     * @return /qualifiedName: String [0..1]
     */
    default String getQualifiedName(){
        String name = this.segment();
        for (Element parent = this.owner(); parent != null; parent = parent.owner()) {
            name = parent.segment() + name;
        }
        return name;
    }

    /**
     * The query separator() gives the string that is used to separate names when constructing a qualified name.
     * @return NamedElement::separator(): String;
     */
    default String separator() { return "::"; }

    default String segment(){ return separator() + this.name();}

    /**
     * The query allNamespaces() gives the sequence of namespaces in which the NamedElement is nested, working outwards.
     * <pre>
     *     allNamespaces =
     *          if self.namespace->isEmpty() then Sequence{}
     *          else self.namespace.allNamespaces()->prepend(self.namespace)
     *          endif
     * </pre>
     * @return NamedElement::allNamespaces(): Sequence(Namespace)
     */
    default List<Namespace> allNamespaces(){
        List<Namespace> namespaces = new ArrayList<>();
        for (NamedElement owner = this.namespace(); owner != null; owner = owner.namespace()) {
            namespaces.add((Namespace) owner);
        }
        return namespaces;
    }

    //TODO provide a default implementation
    /**
     * The query isDistinguishableFrom() determines whether two NamedElements may logically co-exist within a Namespace.
     * By default, two named elements are distinguishable if (a) they have unrelated types or (b) they have related
     * types but different names.
     * <pre>
     *     isDistinguishable =
     *          if self.oclIsKindOf(n.oclType) or n.oclIsKindOf(self.oclType)
     *          then ns.getNamesOfMember(self)->intersection(ns.getNamesOfMember(n))->isEmpty()
     *          else true
     *          endif;
     * </pre>
     * @param n NamedElement
     * @param ns Namespace
     * @return NamedElement::isDistinguishableFrom(n:NamedElement, ns: Namespace): Boolean
     */
    boolean isDistinguishableFrom(NamedElement n, Namespace ns);
}
