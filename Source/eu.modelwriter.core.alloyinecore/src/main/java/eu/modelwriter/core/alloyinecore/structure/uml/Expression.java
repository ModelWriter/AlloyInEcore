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
 * An expression is a structured tree of symbols that denotes a (possibly empty) set of values when evaluated in a context.
 * <b>Description:</b>
 * <p>
 * An expression represents a node in an expression tree, which may be non-terminal or terminal. It defines a symbol,
 * and has a possibly empty sequence of operands that are value specifications.
 * <p>
 * <b>Semantics:</b>
 * <p>
 * An expression represents a node in an expression tree. If there is no operand, it represents a terminal node.
 * If there are operands, it represents an operator applied to those operands. In either case there is a symbol
 * associated with the node. The interpretation of this symbol depends on the context of the expression.
 */
public interface Expression extends ValueSpecification {

    /**
     * Specifies a sequence of operands.
     * @see Element#ownedElement
     * @return {@code operand: ValueSpecification[*] {subsets Element::ownedElement}}
     */
    default List<ValueSpecification> operand() {return this.getOwnedElements(ValueSpecification.class);}

    /**
     * Specifies a sequence of operands.
     * @return {@code symbol: String[1] {subsets Element::ownedElement}}
     */
    String symbol();
}
