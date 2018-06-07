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

/**
 * <p><b>TemplateSignature [Class]</b>
 * <p><b>Description:</b>
 * <p> A Template Signature bundles the set of formal TemplateParameters for a template.
 * <p><b>Semantics:</b>
 * <p> A TemplateableElement is an Element that can optionally be defined as a template and bound to other templates.
 * A template is a TemplateableElement that is parameterized using a TemplateSignature. Such a template can be used to
 * generate other model Elements using TemplateBinding relationships.
 *
 * A template cannot be used in the same manner as a non-template Element of the same kind (e.g., a template Class
 * cannot be used as the type of a TypedElement). The template Element can only be used to generate bound Elements or
 * as part of the specification of another template (e.g., a template Class may specialize another template Class).

 * <p><b>Constraints:</b>
 * <p>[1] own_elements: Parameters must own the ParameterableElements they parameter or those ParameterableElements
 * must be owned by the TemplateableElement being templated.
 * <pre>
 * inv own_elements: template.ownedElement->includesAll(parameter.parameteredElement->asSet() -
 * parameter.ownedParameteredElement->asSet())
 * </pre>
 * <p>[2] unique_parameters: The names of the parameters of a TemplateSignature are unique.
 * <pre>
 * inv: parameter->forAll( p1, p2 | (p1 <> p2 and
 * p1.parameteredElement.oclIsKindOf(NamedElement) and p2.parameteredElement.oclIsKindOf(NamedElement) ) implies
 * p1.parameteredElement.oclAsType(NamedElement).name <> p2.parameteredElement.oclAsType(NamedElement).name)
 * </pre>
 */
public interface TemplateSignature extends Element {
}
