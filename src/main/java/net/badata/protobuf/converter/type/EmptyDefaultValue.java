package net.badata.protobuf.converter.type;

import net.badata.protobuf.converter.inspection.DefaultValue;

public class EmptyDefaultValue implements DefaultValue {

    @Override
    public Object generateValue(Class<?> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

}
