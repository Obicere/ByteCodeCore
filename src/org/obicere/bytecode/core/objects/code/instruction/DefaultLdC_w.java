package org.obicere.bytecode.core.objects.code.instruction;

import org.javacore.code.instruction.LdC_w;
import org.javacore.constant.Constant;
import org.javacore.code.instruction.Instructions;

/**
 * @author Obicere
 */
public class DefaultLdC_w extends AbstractInstruction implements LdC_w {

    public static final String MNEMONIC = "ldc_w";

    private final Constant constant;

    public DefaultLdC_w(final Constant constant) {
        this.constant = constant;
    }

    @Override
    public int getLength(final int pc) {
        return 3;
    }

    @Override
    public Constant getConstant() {
        return constant;
    }

    @Override
    public String getMnemonic() {
        return MNEMONIC;
    }

    @Override
    public int getOpCode() {
        return Instructions.OPCODE_LDC_W;
    }
}
