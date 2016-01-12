package org.obicere.bytecode.core.reader.instruction;

import org.obicere.bytecode.core.objects.instruction.astore_2;
import org.obicere.bytecode.core.util.IndexedDataInputStream;
import org.obicere.bytecode.core.reader.Reader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class astore_2Reader implements Reader<astore_2> {

    @Override
    public astore_2 read(final IndexedDataInputStream input) throws IOException {
        return new astore_2();
    }
}