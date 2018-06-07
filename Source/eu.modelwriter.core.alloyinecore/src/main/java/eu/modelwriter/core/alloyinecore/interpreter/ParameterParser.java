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

import eu.modelwriter.core.alloyinecore.interpreter.typesystem.structures.TypeParameter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParameterParser {
    private StringBuilder sb;
    private String paramString;
    private String type;

    private String mainType;
    private List<String> parameters;
    private List<TypeParameter> typeParameters;
    private String superType;
    private String extendsType;

    private int index;

    public ParameterParser(String type) {
        this.index = 0;
        type = refactorType(type);
        this.type = type;
        this.sb = new StringBuilder();
        this.parameters = new ArrayList<>();
        if (type.contains("<")) {
            this.paramString = type.substring(type.indexOf("<") + 1, type.length() - 1);
            lookFor(',');
        }
        else
            this.paramString = null;

        mainType = type.contains("<") ? type.substring(0, type.indexOf("<")) : type;
        superType = null;
        extendsType = null;

        if (mainType.contains("extends")){
            extendsType = type.substring(type.indexOf(" extends ") + 9);
        }
        else if (mainType.contains("super")){
            superType = type.substring(type.indexOf(" super ") + 7);
        }

        typeParameters = parameters.stream().map(TypeParameter::new).collect(Collectors.toList());
    }

    public static String refactorType(String type) {
        StringBuilder sb = new StringBuilder();

        char[] chars = type.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == ' ' && sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            else if (c == ',' && sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            else  if (c == '<' && sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            else if (c == '>' && sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            else if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',' && c != ' ') {
                sb.append(' ');
            }

            boolean pass = false;

            pass = pass || (sb.length() == 0 && c == ' ');
            pass = pass || (sb.length() > 0 && c == ' ' && sb.charAt(sb.length() - 1) == '<');

            if (!pass) {
                sb.append(c);
            }

            if (c == '?' && i + 1 < chars.length && chars[i + 1] != ' ' && chars[i + 1] != '<' && chars[i + 1] != ',') {
                sb.append(' ');
            }
            else if (i + 1 < chars.length && chars[i + 1] != ' ' && chars[i + 1] != '<' && chars[i + 1] != ',') {
                if (sb.lastIndexOf("? extends") >= 0 && sb.lastIndexOf("? extends") + "? extends".length() == sb.length()) {
                    sb.append(' ');
                }
                else if (sb.lastIndexOf("? super") >= 0 && sb.lastIndexOf("? super") + "? super".length() == sb.length()) {
                    sb.append(' ');
                }
            }

        }

        if (sb.charAt(sb.length() - 1) == ' ')
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private void lookFor(char c){
        for (; index < paramString.length(); index++){
            char current = paramString.charAt(index);

            if (current == ',' && c == ','){
                parameters.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }

            if (Character.isSpaceChar(current) && sb.length() == 0)
                continue;

            sb.append(current);

            if (current == '<'){
                index++;
                lookFor('>');
            }

            if (current == '>' && c == '>'){
                //index++;
                return;
            }
        }
        parameters.add(sb.toString());
    }

    public String getType() {
        return type;
    }

    public String getMainType() {
        return mainType;
    }

    public String getExtendsType() {
        return extendsType;
    }

    public String getSuperType() {
        return superType;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public List<TypeParameter> getTypeParameters() {
        return typeParameters;
    }

    public static String createName(String mainType, List<String> parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append(mainType);
        if (!parameters.isEmpty()) {
            sb.append("<");
            sb.append(parameters.stream().collect(Collectors.joining(", ")));
            sb.append(">");
        }

        return sb.toString();
    }

}
