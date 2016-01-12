package org.obicere.bytecode.core.objects;

import org.obicere.bytecode.core.reader.ConstantReader;

/**
 * @author Obicere
 */
public class ConstantInterfaceMethodRef extends MethodRef {

    public static final String IDENTIFIER = "MethodRef";

    private static final String NAME = "InterfaceMethodRef";

    public ConstantInterfaceMethodRef(final int classIndex, final int nameAndTypeIndex) {
        super(ConstantReader.CONSTANT_INTERFACE_METHOD_REF, classIndex, nameAndTypeIndex);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }
}