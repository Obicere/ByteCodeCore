package org.obicere.bytecode.core.objects.code.instruction;

import org.javacore.code.instruction.IConst_3;
import org.javacore.code.instruction.Instructions;

/**
 * @author Obicere
 */
public class DefaultIConst_3 extends AbstractInstruction implements IConst_3 {

    public static final String MNEMONIC = "iconst_3";

    public static final IConst_3 INSTANCE = new DefaultIConst_3();

    private DefaultIConst_3() {
    }

    @Override
    public String getMnemonic() {
        return MNEMONIC;
    }

    @Override
    public int getOpCode() {
        return Instructions.OPCODE_ICONST_3;
    }
}
