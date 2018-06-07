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
 * An opaque expression is an uninterpreted textual statement that denotes a (possibly empty) set of values when
 * evaluated in a context.
 * <b>Description:</b>
 * <p>
 * An opaque expression contains language-specific text strings used to describe a value or values, and an optional
 * specification of the languages.
 * <p>
 * One predefined language for specifying expressions is OCL. * Natural language or programming languages may also
 * be used.
 * <p>
 * <b>Semantics:</b>
 * <p>
 * The expression body may consist of a sequence of text strings – each in a different language – representing
 * alternative representations of the same content. When multiple language strings are provided, the language of each
 * separate string is determined by its corresponding entry in the “language” attribute (by sequence order).
 * The interpretation of the text strings is language specific. Languages are matched to body strings by order.
 * If the languages are unspecified, it might be implicit from the expression bodies or the context.
 * <p>
 * It is assumed that a linguistic analyzer for the specified languages will evaluate the bodies. The time at which
 * the bodies will be evaluated is not specified.
 * <p>
 * <b>Notation:</b>
 * An opaque expression is displayed as text string in particular languages. The syntax of the strings are the
 * responsibility of a tool and linguistic analyzers for the language. An opaque expression is displayed as a part of
 * the notation for its containing element.
 * <p>
 */
public interface OpaqueExpression extends ValueSpecification {
    /**
     * The text of the expression, possibly in multiple languages.
     * @return {@code body: String[0..*] {nonunique, ordered} }
     */
    List<String> body();

    /**
     * Specifies the languages in which the expression is stated. The interpretation of the expression body depends on
     * the language. If languages are unspecified, it might be implicit from the expression body or the context.
     * Languages are matched to body strings by order.
     * @return {@code language: String[0..*] {ordered}}
     */
    List<String> language();
}
