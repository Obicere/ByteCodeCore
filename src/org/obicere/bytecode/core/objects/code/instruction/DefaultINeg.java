package org.obicere.bytecode.core.objects.code.instruction;

import org.javacore.code.instruction.INeg;
import org.javacore.code.instruction.Instructions;

/**
 * @author Obicere
 */
public class DefaultINeg extends AbstractInstruction implements INeg {

    public static final String MNEMONIC = "ineg";

    public static final INeg INSTANCE = new DefaultINeg();

    private DefaultINeg() {
    }

    @Override
    public String getMnemonic() {
        return MNEMONIC;
    }

    @Override
    public int getOpCode() {
        return Instructions.OPCODE_INEG;
    }
}
