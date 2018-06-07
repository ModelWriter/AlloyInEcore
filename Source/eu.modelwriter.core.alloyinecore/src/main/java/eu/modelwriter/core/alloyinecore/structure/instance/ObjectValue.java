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

package eu.modelwriter.core.alloyinecore.structure.instance;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EObjectValueContext;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;

public final class ObjectValue extends Element<EObjectValueContext> {
    public ObjectValue(EObjectValueContext context) {
        super(context);
    }

    public Object getObject() {
        Instance instance = this.getOwner(Instance.class);
        String text = this.getContext().pathName().getText();
        String[] splits = text.replaceAll("@", "").split("::");
        Object object = instance.getRootObject();
        for (String split : splits) {
            String name = split;
            int index = 0;
            if (split.contains(".")) {
                name = split.substring(0, split.indexOf("."));
                index = Integer.parseInt(split.substring(split.indexOf(".") + 1));
            }
            object = findObject(object, name, index);
            if (object == null) break;
        }
        return object;
    }

    private Object findObject(Object start, String name, int index) {
        Slot slot = start.getSlots().stream().filter(s -> s.getLabel().equals(name)).findFirst().orElse(null);
        if (slot != null) {
            return slot.getOwnedElements(Object.class).get(index);
        }
        return null;
    }

    @Override
    public <T> T accept(IVisitor<? extends T> visitor) {
        return visitor.visitObjectValue(this);
    }
}
