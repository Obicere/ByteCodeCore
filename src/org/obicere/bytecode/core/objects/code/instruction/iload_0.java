package org.obicere.bytecode.core.objects.code.instruction;

import org.obicere.bytecode.core.reader.code.instruction.InstructionReader;

/**
 * @author Obicere
 */
public class iload_0 extends Instruction {

    public static final String IDENTIFIER = "iload_0";

    public static final iload_0 INSTANCE = new iload_0();

    private iload_0() {
    }

    @Override
    public String getMnemonic() {
        return IDENTIFIER;
    }

    @Override
    public byte getOpcode() {
        return InstructionReader.OPCODE_ILOAD_0;
    }
}