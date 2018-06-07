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

package RecursiveDataTypes.Immutablelists;

/**
 *
 */
class Cons<E> implements List<E> {
    private final E e;
    private final List<E> rest;

    private int size = 0;

    public Cons(E e, List<E> rest) {
        this.e = e;
        this.rest = rest;
    }

    @Override
    public List<E> cons(E e) {
        return new Cons<>(e, this);
    }

    @Override
    public E first() {
        return e;
    }

    @Override
    public List<E> rest() {
        return rest;
    }

    @Override
    public int size() {
        if (size == 0) size = 1 + rest.size();
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E e) {
        return this.e.equals(e) || rest.contains(e);
    }

    @Override
    public List<E> append(List<E> list) {
        return new Cons<>(e, rest.append(list));
    }

    @Override
    public List<E> reverse() {
        return rest.reverse().append(new Cons<>(e, List.empty()));
    }

    @Override
    public String toString() {
        return List.print(this);
    }
}
