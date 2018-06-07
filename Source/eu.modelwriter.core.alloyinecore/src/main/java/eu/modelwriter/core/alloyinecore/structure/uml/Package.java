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
 * <b>Description:</b>
 * <p>
 * A package is used to group elements, and provides a namespace for the grouped elements. A package is a namespace for
 * its members, and may contain other packages. Only packageable elements can be owned members of a package. By virtue
 * of being a namespace, a package can import either individual members of other packages, or all the members of other
 * packages.
 * <p>
 * <b>Semantics:</b>
 * <p>
 * A package is a namespace and is also a packageable element that can be contained in other packages. The elements that
 * can be referred to using non-qualified names within a package are owned elements, imported elements, and elements in
 * enclosing (outer) namespaces. Owned and imported elements may each have a visibility that determines whether they are
 * available outside the package.
 * <p>
 * A package owns its owned members, with the implication that if a package is removed from a model, so are the elements
 * owned by the package.
 * <p>
 * The public contents of a package are always accessible outside the package through the use of qualified names.
 */
public interface Package extends Namespace, PackageableElement {

    /**
     * References the owned members that are Packages.
     * <p>
     * @see Namespace#ownedMember()
     * @return {@code /nestedPackage: Package[*] {subsets Namespace::ownedMember} }
     */
    default List<Package> nestedPackage() {return this.getOwnedElements(Package.class);}

    /**
     * References the owning package of a package.
     * <p>
     * @see NamedElement#namespace()
     * @return {@code nestingPackage: Package[0..1] {subsets NamedElement::namespace}}
     */
    default Package nestingPackage() { return (Package) this.namespace();}

    /**
     * Specifies the members that are owned by this Package
     * <p>
     * @see Namespace#ownedMember()
     * @return {@code packagedElement: PackageableElement[*] {subsets Namespace::ownedMember}}
     */
    default List<PackageableElement> packagedElement() {return this.getOwnedElements(PackageableElement.class);}

    /**
     * References the owned members that are Types.
     * <p>
     * @see Package#packagedElement()
     * @return {@code ownedType: Type[*] {subsets Package::packagedElement}}
     */
    default List<Type> ownedType() { return this.getOwnedElements(Type.class);}

}
