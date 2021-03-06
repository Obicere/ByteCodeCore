package org.obicere.bytecode.core.objects.code.instruction;

import org.javacore.code.instruction.Return;
import org.javacore.code.instruction.Instructions;

/**
 * @author Obicere
 */
public class DefaultReturn extends AbstractInstruction implements Return {

    public static final String MNEMONIC = "return";

    public static final Return INSTANCE = new DefaultReturn();

    private DefaultReturn() {
    }

    @Override
    public String getMnemonic() {
        return MNEMONIC;
    }

    @Override
    public int getOpCode() {
        return Instructions.OPCODE_RETURN;
    }
}
