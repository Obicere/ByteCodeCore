package org.obicere.bytecode.core.objects;

import org.javacore.JCField;
import org.javacore.attribute.Attribute;
import org.obicere.bytecode.core.objects.attribute.AttributeSet;
import org.obicere.bytecode.core.util.ByteCodeReader;

/**
 * @author Obicere
 */
public class DefaultJCField implements JCField {

    private int accessFlags;

    private String name;

    private String typeName;

    private AttributeSet attributeSet;

    public DefaultJCField(final ByteCodeReader reader) {
        reader.enterParent(this);

        reader.exitParent(this);
    }

    public DefaultJCField(final int accessFlags, final String name, final String type, final AttributeSet attributeSet) {
        this.accessFlags = accessFlags;
        this.name = name;
        this.typeName = type;
        this.attributeSet = attributeSet;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public String getName() {
        return name;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public Attribute[] getAttributes() {
        return new Attribute[0];
    }
}
