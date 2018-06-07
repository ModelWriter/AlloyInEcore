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

import java.util.*;
import java.util.stream.Collectors;

public class GenericTypeTemplate extends Type {

    private List<TypeParameter> typeParameters;
    private boolean abstractImpl;

    private Map<GenericTypeTemplate, Map<TypeParameter, TypeParameter>> equalParameters;

    public GenericTypeTemplate(String name, boolean abstract_, List<TypeParameter> typeParameters) {
        super(name, true);
        this.typeParameters = new ArrayList<>(typeParameters);
        this.equalParameters = new HashMap<>();
        this.typeParameters.forEach(t -> t.setOwnerType(this));
        this.abstractImpl = abstract_;
    }

    public boolean isAbstractImpl() {
        return abstractImpl;
    }

    public List<TypeParameter> getTypeParameters() {
        return typeParameters;
    }

    @Override
    public String getFullName() {
        return createName(super.getName(), typeParameters);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public static String createName(String shortName, List<TypeParameter> typeParameters) {
        StringBuilder sb = new StringBuilder();
        sb.append(shortName);
        sb.append("<");
        sb.append(typeParameters.stream().map(TypeParameter::getName).collect(Collectors.joining(", ")));
        sb.append(">");

        return sb.toString();
    }

    public void addEqualParameter(GenericTypeTemplate otherType, TypeParameter thisTypeParameter, TypeParameter otherTypeParameter) {
        equalParameters.computeIfAbsent(otherType, e -> new HashMap<>()).put(thisTypeParameter, otherTypeParameter);
    }

    public TypeParameter getEqualParameter(GenericTypeTemplate otherType, TypeParameter thisTypeParameter) {
        return equalParameters.getOrDefault(otherType, Collections.emptyMap()).get(thisTypeParameter);
    }

}
