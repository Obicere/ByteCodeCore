package org.obicere.bytecode.core.reader.code.instruction;

import org.javacore.JavaCore;
import org.javacore.code.instruction.InstanceOf;
import org.javacore.constant.ConstantClass;
import org.javacore.type.Type;
import org.obicere.bytecode.core.objects.code.instruction.DefaultInstanceOf;
import org.obicere.bytecode.core.reader.Reader;
import org.obicere.bytecode.core.util.ByteCodeReader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class InstanceOfReader implements Reader<InstanceOf> {

    @Override
    public InstanceOf read(final ByteCodeReader input) throws IOException {
        final ConstantClass classConstant = input.readConstant();
        final Type type = JavaCore.getType(classConstant.getName());
        return new DefaultInstanceOf(type);
    }
}