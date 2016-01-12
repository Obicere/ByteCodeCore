package org.obicere.bytecode.core.reader.instruction;

import org.obicere.bytecode.core.objects.instruction.dload_2;
import org.obicere.bytecode.core.util.IndexedDataInputStream;
import org.obicere.bytecode.core.reader.Reader;

import java.io.IOException;

/**
 * @author Obicere
 */
public class dload_2Reader implements Reader<dload_2> {

    @Override
    public dload_2 read(final IndexedDataInputStream input) throws IOException {
        return new dload_2();
    }
}