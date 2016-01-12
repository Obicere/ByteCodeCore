package org.obicere.bytecode.core.objects;

/**
 * @author Obicere
 */
public class LocalVariableTypeTableAttribute extends Attribute {

    private final LocalVariableType[] localVariableTypeTable;

    public LocalVariableTypeTableAttribute(final LocalVariableType[] localVariableTypeTable) {

        if (localVariableTypeTable == null) {
            throw new NullPointerException("local variable type table not defined.");
        }

        this.localVariableTypeTable = localVariableTypeTable;
    }

    public LocalVariableType[] getLocalVariableTypeTable() {
        return localVariableTypeTable;
    }

}