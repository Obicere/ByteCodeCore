package org.obicere.bytecode.core.objects;

/**
 * @author Obicere
 */
public class ClassFile extends ByteCodeElement {

    public static final String IDENTIFIER = "ClassFile";

    private final int minorVersion;

    private final int majorVersion;

    private final ConstantPool constantPool;

    private final int accessFlags;

    private final int thisClass;

    private final int superClass;

    private final int[] interfaces;

    private final Field[] fields;

    private final Method[] methods;

    private final Attribute[] attributes;

    private final AttributeSet attributeSet;

    public ClassFile(final int minorVersion, final int majorVersion, final ConstantPool constantPool, final int accessFlags, final int thisClass, final int superClass, final int[] interfaces, final Field[] fields, final Method[] methods, final Attribute[] attributes) {
        this.minorVersion = minorVersion;
        this.majorVersion = majorVersion;
        this.constantPool = constantPool;
        this.accessFlags = accessFlags;
        this.thisClass = thisClass;
        this.superClass = superClass;
        this.interfaces = interfaces;
        this.fields = fields;
        this.methods = methods;
        this.attributes = attributes;
        this.attributeSet = new AttributeSet(attributes);
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public ConstantPool getConstantPool() {
        return constantPool;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public int getSuperClass() {
        return superClass;
    }

    public String getSuperName() {
        return constantPool.getAsString(superClass);
    }

    public int getThisClass() {
        return thisClass;
    }

    public String getName() {
        return constantPool.getAsString(thisClass);
    }

    public int[] getInterfaces() {
        return interfaces;
    }

    public String getInterface(final int index) {
        return constantPool.getAsString(index);
    }

    public Field[] getFields() {
        return fields;
    }

    public Method[] getMethods() {
        return methods;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public AttributeSet getAttributeSet() {
        return attributeSet;
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }
}