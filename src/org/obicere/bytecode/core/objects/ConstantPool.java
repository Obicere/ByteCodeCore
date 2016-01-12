package org.obicere.bytecode.core.objects;

import org.obicere.bytecode.viewer.dom.DocumentBuilder;

/**
 * @author Obicere
 */
public class ConstantPool extends ByteCodeElement {

    private final Constant[] constants;

    public ConstantPool(final Constant[] constants) {
        this.constants = constants;
    }

    public Constant get(final int index) {
        if(index >= constants.length) {
            return null;
        }
        return constants[index];
    }

    public String getAsString(final int index) {
        final Constant constant = get(index);
        if (constant == null) {
            return "<null entry>";
        }
        return constant.toString(this);
    }

    public Constant[] getConstants() {
        return constants;
    }

    @Override
    public String getIdentifier() {
        return "constantPool";
    }

    private static final int MAX_NAME_LENGTH = 11;

    @Override
    public void model(final DocumentBuilder builder) {

        builder.add("Constant Pool:");
        builder.indent();
        builder.openCollapsibleBlock();
        //builder.newLine();

        // start at i=1 to avoid the always-null and never used constant
        for (int i = 1; i < constants.length; i++) {

            final Constant constant = constants[i];
            if (constant == null) {
                // maybe move this to a ConstantNull class with a modeler there?
                builder.addKeyword("null");
            } else {
                final String type = constant.getName();
                builder.addKeyword(type);
                builder.padTabbed(type.length(), MAX_NAME_LENGTH);
                constant.model(builder);
            }
            builder.newLine();
        }
        builder.unindent();
        builder.closeBlock();
        builder.newLine();
    }
}