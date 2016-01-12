package org.obicere.bytecode.core.objects.instruction;

import org.obicere.bytecode.viewer.dom.DocumentBuilder;
import org.obicere.bytecode.viewer.dom.Modeler;

/**
 * @author Obicere
 */
public class aload extends Instruction implements Modeler {

    private static final String MNEMONIC = "aload";
    private static final int    OPCODE   = 0x19;

    private final int index;

    public aload(final int index) {
        super(MNEMONIC, OPCODE);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public void model(final DocumentBuilder builder) {
        super.model(builder);
        builder.tab();
        builder.add(index);
    }

}