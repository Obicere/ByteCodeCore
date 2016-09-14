package org.obicere.bytecode.core.reader.attribute;

import org.obicere.bytecode.core.objects.attribute.SyntheticAttribute;
import org.obicere.bytecode.core.reader.Reader;
import org.obicere.bytecode.core.util.ByteCodeReader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class SyntheticAttributeReader implements Reader<SyntheticAttribute> {

    @Override
    public SyntheticAttribute read(final ByteCodeReader input) throws IOException {
        // read length and discard
        input.readInt();
        return SyntheticAttribute.getInstance();
    }
}