package org.obicere.bytecode.core.reader.annotation.target;

import org.javacore.annotation.target.CatchTarget;
import org.obicere.bytecode.core.objects.annotation.target.DefaultCatchTarget;
import org.obicere.bytecode.core.reader.Reader;
import org.obicere.bytecode.core.util.ByteCodeReader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class CatchTargetReader implements Reader<CatchTarget> {

    @Override
    public CatchTarget read(final ByteCodeReader input) throws IOException {
        final int targetType = input.readUnsignedByte();
        final int exceptionTableIndex = input.readUnsignedShort();
        return new DefaultCatchTarget(targetType, exceptionTableIndex);
    }
}
