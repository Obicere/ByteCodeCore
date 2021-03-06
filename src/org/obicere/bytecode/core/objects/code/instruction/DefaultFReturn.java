package org.obicere.bytecode.core.objects.code.instruction;

import org.javacore.code.instruction.FReturn;
import org.javacore.code.instruction.Instructions;

/**
 * @author Obicere
 */
public class DefaultFReturn extends AbstractInstruction implements FReturn {

    public static final String MNEMONIC = "freturn";

    public static final FReturn INSTANCE = new DefaultFReturn();

    private DefaultFReturn() {
    }

    @Override
    public String getMnemonic() {
        return MNEMONIC;
    }

    @Override
    public int getOpCode() {
        return Instructions.OPCODE_FRETURN;
    }
}
