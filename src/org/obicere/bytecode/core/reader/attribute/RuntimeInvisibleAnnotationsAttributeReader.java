package org.obicere.bytecode.core.reader.attribute;

import org.obicere.bytecode.core.objects.annotation.Annotation;
import org.obicere.bytecode.core.objects.attribute.RuntimeInvisibleAnnotationsAttribute;
import org.obicere.bytecode.core.reader.Reader;
import org.obicere.bytecode.core.reader.annotation.AnnotationReader;
import org.obicere.bytecode.core.util.ByteCodeReader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class RuntimeInvisibleAnnotationsAttributeReader implements Reader<RuntimeInvisibleAnnotationsAttribute> {

    private final AnnotationReader annotation;

    public RuntimeInvisibleAnnotationsAttributeReader(final AnnotationReader annotation) {
        this.annotation = annotation;
    }

    @Override
    public RuntimeInvisibleAnnotationsAttribute read(final ByteCodeReader input) throws IOException {
        // read length and discard
        input.readInt();
        final int numAnnotations = input.readUnsignedShort();
        final Annotation[] annotations = new Annotation[numAnnotations];

        for (int i = 0; i < numAnnotations; i++) {
            annotations[i] = annotation.read(input);
        }
        return new RuntimeInvisibleAnnotationsAttribute(annotations);
    }
}