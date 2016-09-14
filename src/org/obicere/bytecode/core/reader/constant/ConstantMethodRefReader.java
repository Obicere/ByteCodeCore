package org.obicere.bytecode.core.reader.constant;

import org.obicere.bytecode.core.objects.constant.ConstantMethodRef;
import org.obicere.bytecode.core.reader.Reader;
import org.obicere.bytecode.core.util.ByteCodeReader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class ConstantMethodRefReader implements Reader<ConstantMethodRef> {
    @Override
    public ConstantMethodRef read(final ByteCodeReader input) throws IOException {
        return new ConstantMethodRef(input.getConstantPool(), input.readUnsignedShort(), input.readUnsignedShort());
    }
}