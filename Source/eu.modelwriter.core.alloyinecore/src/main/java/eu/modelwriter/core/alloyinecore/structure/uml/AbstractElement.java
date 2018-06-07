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

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractElement<C extends ParserRuleContext> implements Element {
    private final C context;
    private Element owner;
    private final List<Element> ownedElement = new ArrayList<>();

    public AbstractElement(C context) { this.context = context; }

    @Override
    public List<Element> ownedElement() {
        return ownedElement;
    }

    public Element owner() {
        return owner;
    }

    public void setOwner(final Element owner) { this.owner = owner; }

    public final <K extends Element> boolean deleteOwnedElement(K child){ return this.ownedElement.remove(child); }

    public <E extends Element> void addOwnedElement(E child) {
        if (child != null) {
            ownedElement.add(child);
            child.setOwner(this);
        }
    }

    @Override
    public int hashCode() { return Objects.hash(this.getContext().getText()); }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj instanceof Element && this.getFullPath().equals(((Element) obj).getFullPath());
    }

    public C getContext() { return context; }

}
