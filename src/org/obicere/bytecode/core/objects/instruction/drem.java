package org.obicere.bytecode.core.objects.instruction;

import org.obicere.bytecode.core.reader.instruction.InstructionReader;

/**
 * @author Obicere
 */
public class drem extends Instruction {

    public static final String IDENTIFIER = "drem";

    @Override
    public String getMnemonic() {
        return IDENTIFIER;
    }

    @Override
    public byte getOpcode() {
        return InstructionReader.OPCODE_DREM;
    }

}
