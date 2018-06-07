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

package eu.modelwriter.core.alloyinecore.interpreter;

import kodkod.ast.Formula;
import org.antlr.v4.runtime.Token;

/**
 * Created by harun on 10/16/17.
 */
public class FormulaInfo {

    private Formula formula;
    private Token token;

    private int line = -1;
    private int firstIndex = -1;
    private int lastIndex = -1;
    private int firstIndexInLine = -1;
    private int lastIndexInLine = -1;

    private String description;

    public FormulaInfo(Formula formula, Token token) {
        this.formula = formula;
        this.token = token;
        description = formula.toString();
    }

    public FormulaInfo(Formula formula, Token token, String description) {
        this.formula = formula;
        this.token = token;
        this.description = description;
    }

    public Formula getFormula() {
        return formula;
    }

    public int getFirstIndex() {
        return firstIndex >= 0 ? firstIndex : token.getStartIndex();
    }

    public int getLastIndex() {
        return lastIndex >= 0 ? lastIndex : token.getStopIndex();
    }

    public int getLine() {
        return line >= 0 ? line : token.getLine();
    }

    public int getFirstIndexInLine() {
        return firstIndexInLine >= 0 ? firstIndexInLine : token.getCharPositionInLine();
    }

    public int getLastIndexInLine() {
        return lastIndexInLine >= 0 ? lastIndexInLine : token.getCharPositionInLine() + getLength();
    }

    public int getLength() {
        return getLastIndex() - getFirstIndex() + 1;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCustomLine(int line) {
        this.line = line;
    }

    public void setCustomFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public void setCustomLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public void setCustomFirstIndexInLine(int firstIndexInLine) {
        this.firstIndexInLine = firstIndexInLine;
    }

    public void setCustomLastIndexInLine(int lastIndexInLine) {
        this.lastIndexInLine = lastIndexInLine;
    }

    @Override
    public String toString() {
        return description;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof FormulaInfo && this.getFormula().equals(((FormulaInfo) obj).getFormula());
    }

    @Override
    public int hashCode() {
        return getFormula().hashCode();
    }
}
