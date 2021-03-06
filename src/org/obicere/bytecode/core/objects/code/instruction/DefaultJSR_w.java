package org.obicere.bytecode.core.objects.code.instruction;

import org.javacore.code.block.label.Label;
import org.javacore.code.instruction.JSR_w;
import org.javacore.code.instruction.Instructions;

/**
 * @author Obicere
 */
public class DefaultJSR_w extends AbstractInstruction implements JSR_w {

    public static final String MNEMONIC = "jsr_w";

    private final Label label;

    public DefaultJSR_w(final Label label) {
        this.label = label;
    }

    @Override
    public int getLength(final int pc) {
        return 5;
    }

    @Override
    public Label getBranch() {
        return label;
    }

    @Override
    public String getMnemonic() {
        return MNEMONIC;
    }

    @Override
    public int getOpCode() {
        return Instructions.OPCODE_JSR_W;
    }
}
