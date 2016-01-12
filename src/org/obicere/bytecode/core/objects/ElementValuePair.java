package org.obicere.bytecode.core.objects;

import org.obicere.bytecode.viewer.dom.DocumentBuilder;

/**
 * @author Obicere
 */
public class ElementValuePair extends ByteCodeElement {

    private final int          elementNameIndex;
    private final ElementValue value;

    public ElementValuePair(final int elementNameIndex, final ElementValue value) {

        if (value == null) {
            throw new NullPointerException("value is not defined.");
        }

        this.elementNameIndex = elementNameIndex;
        this.value = value;
    }

    public int getElementNameIndex() {
        return elementNameIndex;
    }

    public ElementValue getValue() {
        return value;
    }

    @Override
    public void model(final DocumentBuilder builder){
        final ConstantPool constantPool = builder.getConstantPool();
        builder.add(constantPool.getAsString(elementNameIndex));
        builder.add(" = ");
        value.model(builder);
    }

}