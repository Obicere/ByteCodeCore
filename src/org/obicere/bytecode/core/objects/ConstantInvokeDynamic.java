package org.obicere.bytecode.core.objects;

import org.obicere.bytecode.viewer.dom.DocumentBuilder;
import org.obicere.bytecode.core.reader.ConstantReader;

/**
 * @author Obicere
 */
public class ConstantInvokeDynamic extends Constant {

    public static final String IDENTIFIER = "ConstantInvokeDynamic";

    private static final String NAME = "InvokeDynamic";

    private final int bootstrapMethodAttrIndex;

    private final int nameAndTypeIndex;

    public ConstantInvokeDynamic(final int bootstrapMethodAttrIndex, final int nameAndTypeIndex) {
        super(ConstantReader.CONSTANT_INVOKE_DYNAMIC);
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public int getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String toString(final ConstantPool constantPool) {
        return constantPool.getAsString(nameAndTypeIndex) + " " + bootstrapMethodAttrIndex;
    }

    @Override
    public void modelValue(final DocumentBuilder builder) {
        final ConstantPool constantPool = builder.getConstantPool();
        builder.indent();

        BootstrapMethodsAttribute bootstrapMethodsAttribute = null;
        for (final Attribute attribute : builder.getClassFile().getAttributes()) {
            if (attribute instanceof BootstrapMethodsAttribute) {
                bootstrapMethodsAttribute = (BootstrapMethodsAttribute) attribute;
                break;
            }
        }

        if (bootstrapMethodsAttribute != null) {
            final BootstrapMethod method = bootstrapMethodsAttribute.getBootstrapMethods()[bootstrapMethodAttrIndex];
            final int bootstrapMethodRef = method.getBootstrapMethodRef();
            constantPool.get(bootstrapMethodRef).modelValue(builder);

        } else {
            builder.add(bootstrapMethodAttrIndex);
        }
        builder.newLine();

        constantPool.get(nameAndTypeIndex).modelValue(builder);

        builder.unindent();
    }
}