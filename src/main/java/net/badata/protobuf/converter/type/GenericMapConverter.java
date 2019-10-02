package net.badata.protobuf.converter.type;

import com.google.protobuf.MapField;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public abstract class GenericMapConverter<K, V, T> implements TypeConverter<Map<K, V>, MapField<K, V>> {

    private final String protoMapFieldName;
    private final Function<Map<K, V>, T> mapProvider;

    protected GenericMapConverter(String protoMapFieldName, Function<Map<K, V>, T> mapProvider) {
        this.protoMapFieldName = protoMapFieldName;
        this.mapProvider = mapProvider;
    }

    @Override
    public Map<K, V> toDomainValue(Object instance) {
        return ((MapField<K, V>) instance).getMap();
    }

    @Override
    public MapField<K, V> toProtobufValue(Object instance) {
        Map<K, V> map = (Map<K, V>) instance;
        return getPrivateField(mapProvider.apply(map));
    }

    private MapField<K, V> getPrivateField(T proto) {
        try {
            Field field = proto.getClass().getDeclaredField(protoMapFieldName);
            field.setAccessible(true);
            return ((MapField<K, V>) field.get(proto));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to convert to a proto map");
        }
    }

}
