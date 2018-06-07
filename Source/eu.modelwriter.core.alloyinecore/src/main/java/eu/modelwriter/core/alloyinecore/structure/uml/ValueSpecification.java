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
 * A value specification is the specification of a (possibly empty) set of instances, including both objects and data values.
 * <b>Description:</b>
 * <p>
 * ValueSpecification is an abstract metaclass used to identify a value or values in a model. It may reference an
 * instance or it may be an expression denoting an instance or instances when evaluated.
 * <p>
 * <b>Semantics:</b>
 * <p>
 * A value specification yields zero or more values. It is required that the type and number of values is suitable for
 * the context where the value specification is used.
 */
public interface ValueSpecification extends Element {

    /**
     *
     * @return
     */
    default Constraint owningConstraint() {return this.owner() instanceof Constraint ? (Constraint) this.owner() : null ;}

    /**
     * If this value specification is an operand, the owning expression.
     * @see Element#owner
     * @return {@code  expression: Expression[0..1] {subsets Element::owner}}
     */
    default Expression expression(){return this.owner() instanceof Expression ? (Expression) this.owner() : null ;}
}
