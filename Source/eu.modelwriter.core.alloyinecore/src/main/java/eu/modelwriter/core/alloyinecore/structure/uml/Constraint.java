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
 * A constraint is a condition or restriction expressed in natural language text or in a machine readable language for
 * the purpose of declaring some of the semantics of an element.
 * <b>Description:</b>
 * <p>
 * Constraint contains a ValueSpecification that specifies additional semantics for one or more elements. Certain kinds
 * of constraints (such as an association “xor” constraint) are predefined in UML, others may be user-defined. A
 * user-defined Constraint is described using a specified language, whose syntax and interpretation is a tool
 * responsibility. One predefined language for writing constraints is OCL. In some situations, a programming language
 * such as Java may be appropriate for expressing a constraint. In other situations natural language may be used.
 * <p>
 * Constraint is a condition (a Boolean expression) that restricts the extension of the associated element beyond what
 * is imposed by the other language constructs applied to the element.
 * <p>
 * Constraint contains an optional name,
 * although they are commonly unnamed.
 * <p>
 * <b>Semantics:</b>
 * <p>
 * A Constraint represents additional semantic information attached to the constrained elements. A constraint is an
 * assertion that indicates a restriction that must be satisfied by a correct design of the system. The constrained
 * elements are those elements required to evaluate the constraint specification. In addition, the context of the
 * Constraint may be accessed, and may be used as the namespace for interpreting names used in the specification.
 * For example, in OCL ‘self’ is used to refer to the context element.
 * <p>
 * Constraints are often expressed as a text string in some language. If a formal language such as OCL is used, then tools
 * may be able to verify some aspects of the constraints.
 * <p>
 * In general there are many possible kinds of owners for a Constraint. The only restriction is that the owning element
 * must have access to the constrainedElements.
 * <p>
 * The owner of the Constraint will determine when the constraint specification is evaluated. For example, this allows
 * an Operation to specify if a Constraint represents a precondition or a postcondition.
 */
public interface Constraint extends PackageableElement {

    /**
     * A condition that must be true when evaluated in order for the constraint to be satisfied.
     * <p>
     * <b>Constraints:</b>
     * <p> [1] The value specification for a constraint must evaluate to a Boolean value.
     * <p> {@code Cannot be expressed in OCL.}
     * <p> [2] Evaluating the value specification for a constraint must not have side effects.
     * <p> {@code Cannot be expressed in OCL.}
     * <p> [3] A constraint cannot be applied to itself.
     * <p> {@code not constrainedElement->includes(self)}
     * @see Element#ownedElement
     * @return {@code specification: ValueSpecification[1] {subsets Element::ownedElement}}
     */
    default ValueSpecification specification() {return this.getOwnedElement(ValueSpecification.class);}

    /**
     * Specifies the Namespace that is the context for evaluating this constraint.
     * @see NamedElement#namespace
     * @return {@code context: Namespace [0..1] {subsets NamedElement::namespace}}
     */
    Namespace context();

    /**
     * The ordered set of Elements referenced by this Constraint
     * @return {@code constrainedElement: Element[*] {ordered}}
     */
    List<Element> constraintElement();

}
