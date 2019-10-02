package net.badata.protobuf.converter.type;

public class LowerCaseConverter implements TypeConverter<String, String> {

    @Override
    public String toDomainValue(Object instance) {
        return ((String) instance).toLowerCase();
    }

    @Override
    public String toProtobufValue(Object instance) {
        return ((String) instance).toLowerCase();
    }

}
