package org.obicere.bytecode.core.reader;

import org.obicere.bytecode.core.objects.TypeArgumentTarget;
import org.obicere.bytecode.core.util.IndexedDataInputStream;

import java.io.IOException;

/**
 * @author Obicere
 */
public class TypeArgumentTargetReader implements Reader<TypeArgumentTarget> {
    @Override
    public TypeArgumentTarget read(final IndexedDataInputStream input) throws IOException {
        final int targetType = input.readUnsignedByte();
        final int offset = input.readUnsignedShort();
        final int typeArgumentIndex = input.readUnsignedByte();
        return new TypeArgumentTarget(targetType, offset, typeArgumentIndex);
    }
}