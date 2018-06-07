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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericsTree extends ParameterParser {

    List<GenericsTree> subTrees;

    public GenericsTree(String type) {
        super(type);

        subTrees = new ArrayList<>();

        getParameters().forEach(parameter -> {
            subTrees.add(new GenericsTree(parameter));
        });
    }

    public GenericsTree replace(String old_, String new_) {

        String mainType = getMainType();

        if (getExtendsType() == null && getSuperType() == null) {
            mainType = mainType.replace(old_, new_);
        }
        else if (getExtendsType() != null) {
            mainType = "? extends " + new ParameterParser(getExtendsType()).getMainType().replace(old_, new_);
        }
        else if (getSuperType() != null) {
            mainType = "? super " + new ParameterParser(getSuperType()).getMainType().replace(old_, new_);
        }

        List<GenericsTree> subTrees = this.subTrees.stream().map(e -> e.replace(old_, new_)).collect(Collectors.toList());

        return new GenericsTree(ParameterParser.createName(mainType, subTrees.stream()
                        .map(ParameterParser::getType)
                        .collect(Collectors.toList())));
    }

}
