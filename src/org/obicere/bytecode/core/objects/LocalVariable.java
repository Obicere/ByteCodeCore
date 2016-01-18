package org.obicere.bytecode.core.objects;

/**
 * @author Obicere
 */
public class LocalVariable extends ByteCodeElement {

    public static final String IDENTIFIER = "LocalVariable";

    private final int startPC;
    private final int length;
    private final int nameIndex;
    private final int descriptorIndex;
    private final int index;

    public LocalVariable(final int startPC, final int length, final int nameIndex, final int descriptorIndex, final int index) {
        this.startPC = startPC;
        this.length = length;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.index = index;
    }

    public int getStartPC() {
        return startPC;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public int getIntervalLength() {
        return length;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }
}
