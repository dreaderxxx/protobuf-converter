package net.badata.protobuf.converter.type;

import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;

public class TimestampLongConverter implements TypeConverter<Long, Timestamp> {
    @Override
    public Long toDomainValue(Object instance) {
        if (instance instanceof Timestamp) {
            return Timestamps.toMillis((Timestamp) instance);
        }
        return null;
    }

    @Override
    public Timestamp toProtobufValue(Object instance) {
        if (instance instanceof Long) {
            return Timestamps.fromMillis((Long) instance);
        }
        return null;
    }
}