package org.obicere.bytecode.core.reader.attribute;

import org.javacore.Identifier;
import org.javacore.annotation.Annotation;
import org.javacore.attribute.RuntimeInvisibleParameterAnnotationsAttribute;
import org.obicere.bytecode.core.objects.attribute.DefaultRuntimeInvisibleParameterAnnotationsAttribute;
import org.obicere.bytecode.core.reader.Reader;
import org.obicere.bytecode.core.util.ByteCodeReader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class RuntimeInvisibleParameterAnnotationsAttributeReader implements Reader<RuntimeInvisibleParameterAnnotationsAttribute> {

    @Override
    public RuntimeInvisibleParameterAnnotationsAttribute read(final ByteCodeReader input) throws IOException {
        // read name and discard
        input.readShort();
        // read length and discard
        input.readInt();
        final int numParameters = input.readUnsignedByte();
        final Annotation[][] annotations = new Annotation[numParameters][];

        for (int i = 0; i < numParameters; i++) {
            final int numAnnotations = input.readUnsignedShort();
            annotations[i] = new Annotation[numAnnotations];
            for (int j = 0; j < numAnnotations; j++) {
                annotations[i][j] = input.read(Identifier.ANNOTATION);
            }
        }
        return new DefaultRuntimeInvisibleParameterAnnotationsAttribute(annotations);
    }
}
