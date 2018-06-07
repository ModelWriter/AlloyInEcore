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

package eu.modelwriter.core.alloyinecore.structure.model;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.structure.base.*;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.eclipse.emf.ecore.EClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Class extends Classifier<EClass, EClassContext> implements IVisibility, ISource, ITarget {

    public Class(EClass eClass, EClassContext context) {
        super(eClass, context);
    }

    @Override
    public Visibility getVisibility() {
        Visibility visibility = Visibility.PACKAGE;
        if (getContext().visibility != null) {
            String text = getContext().visibility.getText();
            try {
                visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
            } catch (IllegalArgumentException e) {
                visibility = Visibility.PACKAGE;
            }
        }
        return visibility;
    }

    @Override
    protected String getName() {
        if (this.getContext().name != null)
            return ":" + this.getContext().name.getText();
        else
            return super.getName();
    }

    @Override
    public Token getToken() {
        if (getContext().name != null)
            return getContext().name.start;
        else
            return super.getToken();
    }

    @Override
    public String getSegment() {
        return getContext().name != null ? getContext().name.getText() : ITarget.super.getSegment();
    }

    @Override
    public String getLabel() {
        int start;
        int stop;
        if (getContext().name != null) {
            start = getContext().name.start.getStartIndex();
            stop = getContext().name.stop.getStopIndex();
        } else {
            start = getContext().start.getStartIndex();
            stop = getContext().stop.getStopIndex();
        }

        if (getContext().templateSignature != null) {
            stop = getContext().templateSignature.stop.getStopIndex();
        }
        return Element.getNormalizedText(getContext(), start, stop);
    }

    @Override
    public String getSuffix() {
        if (!getContext().eSuperTypes.isEmpty()) {
            return ": " + String.join(", ", this.getContext().eGenericSuperType().stream().map(RuleContext::getText).collect(Collectors.toList()));
        } else {
            return "";
        }
    }

    @Override
    public int getLine() {
        if (getContext().name != null)
            return getContext().name.start.getLine();
        else return super.getLine();
    }

    @Override
    public int getStart() {
        if (getContext().name != null)
            return getContext().name.start.getStartIndex();
        else return super.getLine();
    }

    @Override
    public int getStop() {
        if (getContext().name != null)
            return getContext().name.start.getStopIndex();
        else return super.getLine();
    }

    public boolean isAbstract() {
        return getContext().isAbstract != null;
    }

    @Override
    public <T> T accept(IVisitor<? extends T> visitor) {
        return visitor.visitClass(this);
    }

    @Override
    public List<ISegment> getTargets() {
        // class can reference to
        return ISource.super.getTargets().stream()
                // other classes as super-type
                .filter(e -> e instanceof Class ||
                        // and its own type parameters
                        (e instanceof TypeParameter && e.getOwner().equals(this)))
                .collect(Collectors.toList());
    }

    public List<Class> getSuperTypes() {
        List<Class> superTypes = new ArrayList<>();
        getOwnedElements(GenericSuperType.class).forEach(gst -> {
            superTypes.add(((Class) ((INavigable) gst).getTarget()));
        });
        return superTypes;
    }

    public List<Class> getAllSuperTypes() {
        List<Class> allSuperTypes = new ArrayList<>();
        for (Class st : getSuperTypes()) {
            allSuperTypes.add(st);
            allSuperTypes.addAll(st.getAllSuperTypes());
        }
        return allSuperTypes;
    }

    public List<Class> getSubTypes() {
        List<Class> subTypes = new ArrayList<>();
        getSources().forEach(s -> {
            if (s instanceof Class) {
                if (((Class) s).getSuperTypes().contains(this)) {
                    subTypes.add((Class) s);
                }
            }
        });
        return subTypes;
    }

    public List<Class> getAllSubTypes() {
        List<Class> allSubTypes = new ArrayList<>();
        for (Class st : getSubTypes()) {
            allSubTypes.add(st);
            allSubTypes.addAll(st.getAllSubTypes());
        }
        return allSubTypes;
    }

    public boolean hasScope() {
        return this.getContext().lowerScope != null;
    }

    public int getLowerScope() {
        try {
            String text = this.getContext().lowerScope.getText();
            int i = Integer.parseInt(text);
            if (this.getContext().lowerIncluded == null)
                i++;
            if (i >= 0) return i;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {
        }
        return 0;
    }

    public int getUpperScope() {
        try {
            String text = this.getContext().upperScope.getText();
            int i = Integer.parseInt(text);
            if (this.getContext().upperIncluded == null)
                i--;
            int lower = getLowerScope();
            if (i > lower) return i;
            else return lower;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {
        }
        return getLowerScope();
    }

}
