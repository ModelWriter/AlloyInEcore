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

package eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures;

import java.util.Objects;

public class Pair<T> {

    private T o1;
    private T o2;

    private Pair(T o1, T o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public static<T> Pair<T> of(T o1, T o2) {
        return new Pair<>(o1, o2);
    }

    public T getFirst() {
        return o1;
    }

    public T getSecond() {
        return o2;
    }

    public void setFirst(T atom1) {
        this.o1 = atom1;
    }

    public void setSecond(T atom2) {
        this.o2 = atom2;
    }

    @Override
    public String toString() {
        return o1 + " - " + o2;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof Pair && getFirst().equals(((Pair) obj).getFirst()) && getSecond().equals(((Pair) obj).getSecond()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(o1, o2);
    }
}
