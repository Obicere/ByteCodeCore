package org.obicere.bytecode.core.reader;

import org.obicere.bytecode.core.objects.EmptyTarget;
import org.obicere.bytecode.core.util.IndexedDataInputStream;

import java.io.IOException;

/**
 * @author Obicere
 */
public class EmptyTargetReader implements Reader<EmptyTarget> {
    @Override
    public EmptyTarget read(final IndexedDataInputStream input) throws IOException {
        return new EmptyTarget(input.readUnsignedByte());
    }
}