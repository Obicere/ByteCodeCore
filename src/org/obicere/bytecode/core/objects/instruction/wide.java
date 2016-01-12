package org.obicere.bytecode.core.objects.instruction;

import org.obicere.bytecode.viewer.dom.DocumentBuilder;
import org.obicere.bytecode.core.reader.instruction.InstructionReader;

/**
 * @author Obicere
 */
public class wide extends Instruction {

    private static final String MNEMONIC = "wide";
    private static final int    OPCODE   = 0xc4;

    private final int instruction;

    private final int indexbyte1;
    private final int indexbyte2;

    private final int constbyte1;
    private final int constbyte2;

    public wide(final int instruction, final int indexbyte1, final int indexbyte2) {
        super(MNEMONIC, OPCODE);
        this.instruction = instruction;
        this.indexbyte1 = indexbyte1;
        this.indexbyte2 = indexbyte2;
        this.constbyte1 = 0;
        this.constbyte2 = 0;
    }

    public wide(final int instruction, final int indexbyte1, final int indexbyte2, final int constbyte1, final int constbyte2) {
        super(MNEMONIC, OPCODE);
        this.instruction = instruction;
        this.indexbyte1 = indexbyte1;
        this.indexbyte2 = indexbyte2;
        this.constbyte1 = constbyte1;
        this.constbyte2 = constbyte2;
    }

    public int getIndexbyte1() {
        return indexbyte1;
    }

    public int getIndexbyte2() {
        return indexbyte2;
    }

    public int getIndex() {
        return (indexbyte1 << 8) | indexbyte2;
    }

    public int getConstbyte1() {
        return constbyte1;
    }

    public int getConstbyte2() {
        return constbyte2;
    }

    public int getConst() {
        return (constbyte1 << 8) | constbyte2;
    }

    public int getInstruction() {
        return instruction;
    }

    @Override
    public void model(final DocumentBuilder builder) {
        super.model(builder);
        builder.tab();
        builder.addKeyword(getInstructionName());
        builder.tab();
        builder.add(getIndex());
        if (instruction == InstructionReader.OPCODE_IINC) {
            builder.tab();
            builder.add(getConst());
        }
    }

    private String getInstructionName(){
        switch (instruction){
            case InstructionReader.OPCODE_IINC:
                return "iinc";
            case InstructionReader.OPCODE_ILOAD:
                return "iload";
            case InstructionReader.OPCODE_FLOAD:
                return "fload";
            case InstructionReader.OPCODE_ALOAD:
                return "aload";
            case InstructionReader.OPCODE_LLOAD:
                return "lload";
            case InstructionReader.OPCODE_DLOAD:
                return "dload";
            case InstructionReader.OPCODE_ISTORE:
                return "istore";
            case InstructionReader.OPCODE_FSTORE:
                return "fstore";
            case InstructionReader.OPCODE_ASTORE:
                return "astore";
            case InstructionReader.OPCODE_LSTORE:
                return "lstore";
            case InstructionReader.OPCODE_DSTORE:
                return "dstore";
            case InstructionReader.OPCODE_RET:
                return "ret";
            default:
                throw new AssertionError("illegal operand for wide: " + instruction);

        }
    }
}