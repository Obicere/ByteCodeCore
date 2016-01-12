package org.obicere.bytecode.core.objects.instruction;

import org.obicere.bytecode.viewer.dom.DocumentBuilder;

/**
 * @author Obicere
 */
public class sipush extends Instruction {

    private static final String MNEMONIC = "sipush";
    private static final int    OPCODE   = 0x11;

    private final int byte1;
    private final int byte2;

    public sipush(final int byte1, final int byte2) {
        super(MNEMONIC, OPCODE);
        this.byte1 = byte1;
        this.byte2 = byte2;
    }

    public int getByte1(){
        return byte1;
    }

    public int getByte2(){
        return byte2;
    }

    public int getValue(){
        return (byte1 << 8) | byte2;
    }

    @Override
    public void model(final DocumentBuilder builder) {
        super.model(builder);
        builder.tab();
        builder.add((short) getValue());
    }
}