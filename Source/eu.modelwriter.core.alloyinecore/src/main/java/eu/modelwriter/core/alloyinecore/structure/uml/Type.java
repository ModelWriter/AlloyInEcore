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
 * A type is a named element that is used as the type for a typed element.
 * A type constrains the values represented by a typed element.
 * A type serves as a constraint on the range of values represented by a typed element. Type is an abstract metaclass.
 * <p>
 * <b>Semantics: </b>
 * <p>
 * Type is the abstract class that represents the general notion of the type of a typed element and constrains the set
 * of values that the typed element may refer to.
 * A type represents a set of values. A typed element that has this type is constrained to represent values within this set.
 * <p>
 * <b>Notation: </b>
 * <p>
 * As an abstract class, it has no notion.
 */
public interface Type extends NamedElement, PackageableElement {

    /**
     * Specifies the owning package of this classifier, if any.
     *
     * {@code {subsets NamedElement::namespace}}
     * @return package: Package [0..1]
     */
    default Package owningPackage(){ return (Package) this.namespace();}

}
