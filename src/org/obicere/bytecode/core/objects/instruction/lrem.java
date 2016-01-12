package org.obicere.bytecode.core.objects.instruction;

/**
 * @author Obicere
 */
public class lrem extends Instruction {

    private static final String MNEMONIC = "lrem";
    private static final int    OPCODE   = 0x71;

    public lrem() {
        super(MNEMONIC, OPCODE);
    }
}