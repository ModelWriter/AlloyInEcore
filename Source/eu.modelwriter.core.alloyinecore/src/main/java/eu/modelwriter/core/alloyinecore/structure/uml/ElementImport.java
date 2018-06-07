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
 * <p>
 * <b>Description:</b>
 * <p>
 * An element import identifies an element in another package, and allows the element to be referenced using its name
 * without a qualifier.
 * <p>
 * An element import is defined as a directed relationship between an importing namespace and a packageable element.
 * The name of the packageable element or its alias is to be added to the namespace of the importing namespace.
 * It is also possible to control whether the imported element can be further imported.
 * <p>
 * <b>Semantics:</b>
 * <p>
 * An element import adds the name of a packageable element from a package to the importing namespace. It works by
 * reference, which means that it is not possible to add features to the element import itself, but it is possible to
 * modify the referenced element in the namespace from which it was imported. An element import is used to selectively
 * import individual elements without relying on a package import.
 * <p>
 * In case of a nameclash with an outer name (an element that is defined in an enclosing namespace is available using
 * its unqualified name in enclosed namespaces) in the importing namespace, the outer name is hidden by an element
 * import, and the unqualified name refers to the imported element. The outer name can be accessed using its qualified
 * name.
 * <p>
 * If more than one element with the same name would be imported to a namespace as a consequence of element imports or
 * package imports, the elements are not added to the importing namespace and the names of those elements must be
 * qualified in order to be used in that namespace. If the name of an imported element is the same as the name of an
 * element owned by the importing namespace, that element is not added to the importing namespace and the name of that
 * element must be qualified in order to be used. If the name of an imported element is the same as the name of an
 * element owned by the importing namespace, the name of the imported element must be qualified in order to be used and
 * is not added to the importing namespace.
 * <p>
 * An imported element can be further imported by other namespaces using either element or package imports.
 * <p>
 * The visibility of the ElementImport may be either the same or more restricted than that of the imported element.
 * <p>
 * <b>Notation:</b>
 * <p>
 * An element import is shown using a dashed arrow with an open arrowhead from the importing namespace to the imported
 * element. The keyword «import» is shown near the dashed arrow if the visibility is public, otherwise the keyword
 * «access» is shown to indicate private visibility.
 * <p>
 * If an element import has an alias, this is used in lieu of the name of the imported element. The aliased name may
 * be shown after or below the keyword «import».
 */
public interface ElementImport extends DirectedRelationship, IVisibility {

    /**
     * Specifies the visibility of the imported PackageableElement within the importing Package. The default visibility
     * is the same as that of the imported element. If the imported element does not have a visibility, it is possible
     * to add visibility to the element import; default value is public.
     * <p>
     * <b>Constraints:</b>
     * <p>[1] The visibility of an ElementImport is either public or private.
     * <pre>
     *     self.visibility = #public or self.visibility = #private
     * </pre>
     * <p>[2] An importedElement has either public visibility or no visibility at all.
     * <pre>
     *     self.importedElement.visibility.notEmpty() implies self.importedElement.visibility = #public
     * </pre>
     * @return visibility: VisibilityKind
     */
    @Override
    Visibility getVisibility();

    /**
     * Specifies the name that should be added to the namespace of the importing Package in lieu of the name of the
     * imported PackagableElement. The aliased name must not clash with any other member name in the importing Package.
     * By default, no alias is used.
     * @return alias: String [0..1]
     */
    String alias();

    /**
     * Specifies the PackageableElement whose name is to be added to a Namespace.
     * <p>
     * @see DirectedRelationship#target
     * @return {@code importedElement: PackageableElement[1] {subsets DirectedRelationship::target} }
     */
    default PackageableElement importedElement() { return (PackageableElement) this.target().stream().findFirst().orElse(null);}

    /**
     * Specifies the Namespace that imports a PackageableElement from another Package.
     * <p>
     * @see DirectedRelationship#source
     * @see Element#owner
     * @return {@code importingNamespace: Namespace[1] subsets {DirectedRelationship::source and Element::owner}}
     */
    default Namespace importingNamespace() { return (Namespace) this.owner();}

    /**
     * The query getName() returns the name under which the imported PackageableElement will be known in the
     * importing namespace.
     * <pre>
     *  getName =
     *      if self.alias->notEmpty() then
     *      self.alias
     *      else
     *      self.importedElement.name
     *      endif
     * </pre>
     * @return ElementImport::getName(): String
     */
    default String getName(){
        return (!alias().isEmpty()) ? alias() : importedElement().name();
    }
}
