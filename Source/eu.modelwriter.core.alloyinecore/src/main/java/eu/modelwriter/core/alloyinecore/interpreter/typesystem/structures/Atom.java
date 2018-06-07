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

import eu.modelwriter.core.alloyinecore.structure.base.Element;

import java.util.Objects;

public class Atom {

    private static int ATOM_COUNT = 0;

    private int id;
    private String name;
    private AtomType type;

    private Element<?> object;

    public Atom(String name, AtomType type) {
        this.id = ATOM_COUNT++;
        this.name = name;
        this.type = type;
    }

    public void setObject(Element<?> object) {
        this.object = object;
    }

    public Element<?> getObject() {
        return object;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getAtomCount() {
        return ATOM_COUNT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AtomType getType() {
        return type;
    }

    public void setType(AtomType type) {
        this.type = type;
    }

    public boolean sameName(Atom other) {
        return this.getName().equals(other.getName());
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj
                || (obj instanceof Atom
                        && ((Atom) obj).name.equals(this.name)
                        && ((Atom) obj).type.equals(this.type));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return name;
    }

    public enum AtomType {
        OBJECT, STRING, ENUM, INTEGER, BIG_INTEGER, BIG_DECIMAL, BOOLEAN, CLASS;
    }
}
