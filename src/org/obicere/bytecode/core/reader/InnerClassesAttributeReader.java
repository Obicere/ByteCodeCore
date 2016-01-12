package org.obicere.bytecode.core.reader;

import org.obicere.bytecode.core.objects.InnerClass;
import org.obicere.bytecode.core.objects.InnerClassesAttribute;
import org.obicere.bytecode.core.util.IndexedDataInputStream;

import java.io.IOException;

/**
 * @author Obicere
 */
public class InnerClassesAttributeReader implements Reader<InnerClassesAttribute> {

    private final InnerClassReader innerClass = new InnerClassReader();

    @Override
    public InnerClassesAttribute read(final IndexedDataInputStream input) throws IOException {
        final int numberOfClasses = input.readUnsignedShort();
        final InnerClass[] classes = new InnerClass[numberOfClasses];
        for (int i = 0; i < numberOfClasses; i++) {
            final int startIndex = input.getLogicalIndex();
            final InnerClass cls = innerClass.read(input);
            final int endIndex = input.getLogicalIndex();
            cls.setBounds(startIndex, endIndex);

            classes[i] = cls;

        }
        return new InnerClassesAttribute(classes);
    }
}