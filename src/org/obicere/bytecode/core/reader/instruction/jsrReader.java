package org.obicere.bytecode.core.reader.instruction;

import org.obicere.bytecode.core.objects.instruction.jsr;
import org.obicere.bytecode.core.util.IndexedDataInputStream;
import org.obicere.bytecode.core.reader.Reader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class jsrReader implements Reader<jsr> {

    @Override
    public jsr read(final IndexedDataInputStream input) throws IOException {
        return new jsr(input.readUnsignedByte(), input.readUnsignedByte());
    }
}