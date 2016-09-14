package org.obicere.bytecode.core.reader.code.instruction;

import org.obicere.bytecode.core.objects.code.instruction.freturn;
import org.obicere.bytecode.core.reader.Reader;
import org.obicere.bytecode.core.util.ByteCodeReader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class freturnReader implements Reader<freturn> {

    @Override
    public freturn read(final ByteCodeReader input) throws IOException {
        return freturn.INSTANCE;
    }
}