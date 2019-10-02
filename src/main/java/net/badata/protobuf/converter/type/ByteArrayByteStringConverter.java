package net.badata.protobuf.converter.type;

import com.google.protobuf.ByteString;

public class ByteArrayByteStringConverter implements TypeConverter<byte[], ByteString> {

    @Override
    public byte[] toDomainValue(Object instance) {
        return instance != null ? ((ByteString) instance).toByteArray() : new byte[0];
    }

    @Override
    public ByteString toProtobufValue(Object instance) {
        return ByteString.copyFrom((byte[]) instance);
    }

}
