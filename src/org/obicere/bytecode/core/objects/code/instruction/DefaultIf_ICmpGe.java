package org.obicere.bytecode.core.objects.code.instruction;

import org.javacore.code.block.label.Label;
import org.javacore.code.instruction.If_ICmpGe;
import org.javacore.code.instruction.Instructions;

/**
 * @author Obicere
 */
public class DefaultIf_ICmpGe extends AbstractInstruction implements If_ICmpGe {

    public static final String MNEMONIC = "if_icmpge";

    private final Label label;

    public DefaultIf_ICmpGe(final Label label) {
        this.label = label;
    }

    @Override
    public int getLength(final int pc) {
        return 3;
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
        return Instructions.OPCODE_IF_ICMPGE;
    }
}
