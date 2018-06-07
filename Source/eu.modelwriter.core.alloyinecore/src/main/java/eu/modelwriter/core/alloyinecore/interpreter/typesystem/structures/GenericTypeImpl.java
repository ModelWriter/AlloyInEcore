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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericTypeImpl extends Type {

    private GenericTypeTemplate genericTypeTemplate;
    private List<Type> types;

    public GenericTypeImpl(GenericTypeTemplate genericTypeTemplate, boolean abstract_, List<Type> types) {
        super(genericTypeTemplate.getMainName(), abstract_);
        setAbstract_(abstract_);
        this.genericTypeTemplate = genericTypeTemplate;
        this.types = types;
        genericTypeTemplate.addSubType(this);
        setElement(genericTypeTemplate.getElement());
    }

    public List<Type> getTypes() {
        return types;
    }

    public GenericTypeTemplate getGenericTypeTemplate() {
        return genericTypeTemplate;
    }

    @Override
    public String getName() {
        return getFullName();
    }

    @Override
    public String getFullName() {
        return GenericTypeImpl.createName(genericTypeTemplate, types);
    }

    public static String createName(GenericTypeTemplate genericTypeTemplate, List<Type> types) {
        StringBuilder sb = new StringBuilder();
        sb.append(genericTypeTemplate.getName());
        sb.append("<");
        sb.append(types.stream().map(Type::getName).collect(Collectors.joining(", ")));
        sb.append(">");
        return sb.toString();
    }
}
