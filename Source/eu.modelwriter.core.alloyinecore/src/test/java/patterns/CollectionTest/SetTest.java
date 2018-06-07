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

package patterns.CollectionTest;import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *  With Sets, the standard utility methods addAll(), retainAll(), containsAll() now give you fully functioning
 *  mathematical set operations.
 *  To make a set union of x and y, call x.addAll(y).
 *  To make the intersection of sets x and y, call x.retainAll(y).
 *  To test if x is a subset of y, call y.containsAll(x).
 */
public class SetTest {
    public static void main(final String[] args) {
        // Create a Set of Integer objects
        Set<Integer> nums = new HashSet<>();

        // Add the numbers 1..10
        for (int i=1; i<=10; i++) {
            nums.add(i);
        }

        // Add 1, 4, 9, 16, 25
        // Since it's a Set, only the add() of 16 and 25 do anything.
        for (int i=1; i<=5; i++) {
            nums.add(i * i);
        }

        System.out.print("Did addition of a duplicate item change the state?(2) : ");
        System.out.println(nums.add(2));

        System.out.print("Did addition of a duplicate item change the state?(-1) : ");
        System.out.println(nums.add(-1));

        System.out.print("Did addition of null change the state?(null) : ");
        System.out.println(nums.add(null));

        // Foreach works on a Set.
        System.out.print("foreach test:\t[");
        for (Integer num: nums) {
            System.out.print(num + " ");
        }
        System.out.println("]");

        // Iterator works on a set.
        // (the values will appear in some random order for a HashSet
        // as we have here)
        System.out.print("Iterator test:\t[");
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            Integer val = it.next();
            System.out.print(val + " ");
        }
        System.out.println("]");

        // Other Collection utilties work
        System.out.println("Subset Test:\t");
        System.out.println(nums.contains(9)); // true
        System.out.println(nums.containsAll(Arrays.asList(1, 2, 3))); // true

        // addAll() is essentially a mathematical union operation.
        // Change nums to the union with the set {16, 17}
        System.out.print("Union Test:\t");
        nums.addAll(Arrays.asList(16, 17));
        System.out.println(nums);

        System.out.print("Intersection Test:\t");
        nums.retainAll(Arrays.asList(16, 17, 18));
        System.out.println(nums);

        // Accessing by index number DOES NOT work
        // (index numbers are List feature only)
        // int val2 = nums.get(0); //NO does not compile

    }
}
