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

package RecursiveDataTypes.Immutablelists.Client;

import RecursiveDataTypes.Immutablelists.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nil = List.empty();
        List<Integer> x = nil.cons(2).cons(1).cons(0);
        System.out.println(x);
        System.out.println("size: " + x.size());
        List<Integer> y = x.rest().cons(4);
        System.out.println(y);
        System.out.println("size: " + y.size());
        System.out.println("y contains 1? " + y.contains(1));
        System.out.println("y contains 5? " + y.contains(5));
        List<Integer> z = x.append(y);
        System.out.println(z);
        System.out.println("size: " + z.size());
        System.out.println(z.reverse());
    }
}
