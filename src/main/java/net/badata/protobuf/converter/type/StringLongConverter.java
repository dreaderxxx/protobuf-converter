package net.badata.protobuf.converter.type;

public class StringLongConverter implements TypeConverter<Long, String> {

    @Override
    public Long toDomainValue(Object instance) {
        if (instance instanceof String) {
            return Long.valueOf((String) instance);
        }
        return null;
    }

    @Override
    public String toProtobufValue(Object instance) {
        if (instance instanceof Long) {
            return instance.toString();
        }
        return "";
    }

}
