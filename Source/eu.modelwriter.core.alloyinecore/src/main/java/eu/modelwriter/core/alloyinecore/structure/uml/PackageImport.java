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

/**
 * <b>Description:</b>
 * <p>
 * A package import is a relationship that allows the use of unqualified names to refer to package members from
 * other namespaces. A package import is defined as a directed relationship that identifies a package whose members
 * are to be imported by a namespace.
 * <p>
 * <b>Semantics:</b>
 * <p>
 * A package import is a relationship between an importing namespace and a package, indicating that the
 * importing namespace adds the names of the members of the package to its own namespace. Conceptually, a package
 * import is equivalent to having an element import to each individual member of the imported namespace, unless there is
 * already a separately-defined element import.
 * <p>
 * <b>Notation:</b>
 * <p>
 * A package import is shown using a dashed arrow with an open arrowhead from the importing package to the imported
 * package. A keyword is shown near the dashed arrow to identify which kind of package import that is intended. The
 * predefined keywords are «import» for a public package import, and «access» for a private package import.
 */
public interface PackageImport extends DirectedRelationship, IVisibility {

    /**
     * Specifies the visibility of the imported PackageableElements within the importing Namespace, i.e., whether
     * imported elements will in turn be visible to other packages that use that importingPackage as an importedPackage.
     * If the PackageImport is public, the imported elements will be visible outside the package, while if it is
     * private they will not. By default, the value of visibility is public.
     * <p>
     * <b>Constraints:</b>
     * <p>[1] The visibility of a PackageImport is either public or private.
     * <pre>
     *     self.visibility = #public or self.visibility = #private
     * </pre>
     * @return visibility: VisibilityKind
     */
    @Override
    Visibility getVisibility();

    /**
     * Specifies the Package whose members are imported into a Namespace.
     * @see DirectedRelationship#target
     * @return {@code importedElement: PackageableElement[1] {subsets DirectedRelationship::target}}
     */
    Package importedPackage();

    /**
     * Specifies the Namespace that imports the members from a Package.
     * @see DirectedRelationship#source
     * @see Element#owner
     * @return {@code importingNamespace: Namespace[1] {subsets DirectedRelationship::source and Element::owner}}
     */
    default Namespace importingNamespace() { return (Namespace) this.owner();}

}
