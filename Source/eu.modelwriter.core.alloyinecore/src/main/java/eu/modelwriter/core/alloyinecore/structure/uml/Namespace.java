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

/**
 * A namespace is an element in a model that contains a set of named elements that can be identified by name.
 * <p> A namespace is a named element that can own other named elements. Each named element may be owned by at most one
 * namespace. A namespace provides a means for identifying named elements by name. Named elements can be identified by
 * name in a namespace either by being directly owned by the namespace or by being introduced into the namespace by
 * other means (e.g., importing or inheriting). </p>
 *
 * <p> A namespace has the ability to import either individual members or all members of a package, thereby making it
 * possible to refer to those named elements without qualification in the importing namespace. In the case of conflicts,
 * it is necessary to use qualified names or aliases to disambiguate the referenced elements. </p>
 *
 * <p> A namespace provides a container for named elements. It provides a means for resolving composite names, such as
 * name1::name2::name3. The member association identifies all named elements in a namespace called N that can be
 * referred to by a composite name of the form N::<x>. Note that this is different from all of the names that can be
 * referred to unqualified within N, because that set also includes all unhidden members of enclosing namespaces. Named
 * elements may appear within a namespace according to rules that specify how one named element is distinguishable from
 * another. The default rule is that two elements are distinguishable if they have unrelated types, or related types but
 * different names. This rule may be overridden for particular cases, such as operations that are distinguished by their
 * signature. </p>
 */
public interface Namespace extends NamedElement {

    /**
     * A collection of NamedElements owned by the Namespace.
     *
     * @see Element#ownedElement
     * @see Namespace#member
     * @return {@code /ownedMember: NamedElement[*] {subsets Element::ownedElement and Namespace::member}}
     */
    default List<NamedElement> ownedMember()  { return this.getOwnedElements(NamedElement.class); }

    /**
     * References the ElementImports owned by the Namespace.
     *
     * @see Element#ownedElement
     * @return {@code elementImport: ElementImport[*] {subsets Element::ownedElement}}
     */
    default List<ElementImport> elementImport() { return this.getOwnedElements(ElementImport.class); }

    /**
     * References the PackageImports owned by the Namespace.
     *
     * @see Element#ownedElement
     * @return {@code packageImport: PackageImport[*] subsets Element::ownedElement}}
     */
    default List<PackageImport> packageImport() { return this.getOwnedElements(PackageImport.class); }

    /**
     *
     * @see Namespace#ownedMember
     * @return {@code ownedRule : Constraint [*] {subsets Namespace::ownedMember}}
     */
    default List<Constraint> ownedRule() { return this.getOwnedElements(Constraint.class); }

    //TODO provide a default implementation
    /**
     * References the PackageableElements that are members of this Namespace as a result of either PackageImports or
     * ElementImports. The importedMember property is derived from the ElementImports and the PackageImports.
     * <p>
     * <b>Constraints:</b>
     * <pre>
     *     self.importedMember->includesAll(self.importMembers(self.elementImport.importedElement.asSet()
     *          ->union(self.packageImport.importedPackage->collect(p | p.visibleMembers()))))
     * </pre>
     *
     * @see Namespace#member
     * @return {@code /importedMember: PackageableElement[*] {subsets Namespace::member}}
     */
    List<PackageableElement> importedMember();

    /**
     * A collection of NamedElements identifiable within the Namespace, either by being owned or by being introduced by
     * importing or inheritance. This is a derived union.
     *
     * @return /member: NamedElement[*]
     */
    List<NamedElement> member();

    //TODO provide a default implementation
    /**
     * The query getNamesOfMember() gives a set of all of the names that a member would have in a Namespace. In general
     * a member can have multiple names in a Namespace if it is imported more than once with different aliases. Those
     * semantics are specified by overriding the getNamesOfMember operation. The specification here simply returns a set
     * containing a single name, or the empty set if no name.
     * <pre>
     * {@code {getNamesOfMember =
     *          if member->includes(element)
     *              then Set{}->including(element.name)
     *              else Set{}
     *          endif;}}
     * </pre>
     */
    List<String> getNamesOfMember(NamedElement element);

    //TODO provide a default implementation
    /**
     * The query importMembers() defines which of a set of PackageableElements are actually imported into the namespace.
     * This excludes hidden ones, i.e., those which have names that conflict with names of owned members, and also
     * excludes elements that would have the same name when imported.
     * <pre>
     *     importMembers
     *          = self.excludeCollisions(imps)->select(imp | self.ownedMember->
     *              forAll(mem | mem.imp.isDistinguishableFrom(mem, self)));
     * </pre>
     * @return Namespace::importMembers(imps: Set(PackageableElement)): Set(PackageableElement)
     */
    List<PackageableElement> importMembers(List<PackageableElement> imps);

    //TODO provide a default implementation
    /**
     * The query excludeCollisions() excludes from a set of PackageableElements any that would not be distinguishable
     * from each other in this namespace.
     * <pre>
     *     excludeCollisions
     *          = imps->reject(imp1 | imps.exists(imp2 | not imp1.isDistinguishableFrom(imp2, self)));
     * </pre>
     * @param imps a set of PackageableElements
     * @return Namespace::excludeCollisions(imps: Set(PackageableElements)): Set(PackageableElements)
     */
    List<PackageableElement>  excludeCollisions(List<PackageableElement> imps);
}
