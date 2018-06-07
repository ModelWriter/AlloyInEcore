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

package RecursiveDataTypes.BooleanFormulas;
@SuppressWarnings("unused")
public class Formula1 {
    // datatype definition:
    //    Formula = Var(name:String) 
    //              + Not(f:Formula)
    //              + And(left:Formula, right:Formula)
    //              + Or(left:Formula, right:Formula)
        
    public interface Formula {
    }
    
    public static class Var implements Formula{
        private final String name;
        public Var(String name) { this.name = name; }
    }

    public static class And implements Formula{
        private final Formula left, right;
        public And(Formula left, Formula right) { this.left = left; this.right = right; }
    }

    public static class Or implements Formula{
        private final Formula left, right;
        public Or(Formula left, Formula right) { this.left = left; this.right = right; }
    }

    public static class Not implements Formula{
        private final Formula f;
        public Not(Formula f) { this.f = f; }
    }

    
}