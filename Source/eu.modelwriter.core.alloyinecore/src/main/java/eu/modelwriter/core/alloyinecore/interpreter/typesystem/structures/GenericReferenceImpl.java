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

public class GenericReferenceImpl extends Reference {

    private Type referencedType;
    private GenericReference genericReference;

    public GenericReferenceImpl(Type ownerType, GenericReference genericReference, Type referencedType) {
        super(genericReference.getName(), ownerType);
        this.referencedType = referencedType;
        this.genericReference = genericReference;
        genericReference.addSubReference(this);
    }

    public Type getReferencedType() {
        return referencedType;
    }

    public void setReferencedType(Type referencedType) {
        this.referencedType = referencedType;
    }

    public void setGenericReference(GenericReference genericReference) {
        this.genericReference = genericReference;
    }

    public GenericReference getGenericReference() {
        return genericReference;
    }

    @Override
    public String getFullName() {
        return createName(getOwnerType(), getName(), getReferencedType());
    }

    public static String createName(Type ownerType, String name, Type referencedType) {
        return ownerType.getFullName() + "::" + name + " -> " + referencedType.getFullName();
    }
}
