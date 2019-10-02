package net.badata.protobuf.converter.type;

import static java.lang.Enum.valueOf;

@SuppressWarnings("unchecked")
public class EnumToEnumConverter<D extends Enum<D>, P extends Enum<P>> implements TypeConverter<D, P> {

    private final P UNSPECIFIED_VALUE;
    private final Class<D> DOMAIN_ENUM_CLASS;
    private final Class<P> PROTO_ENUM_CLASS;

    protected EnumToEnumConverter(P unspecified, Class<D> domainClass, Class<P> protoClass) {
        UNSPECIFIED_VALUE = unspecified;
        DOMAIN_ENUM_CLASS = domainClass;
        PROTO_ENUM_CLASS = protoClass;
    }

    @Override
    public D toDomainValue(Object instance) {
        P proto = (P) instance;
        return proto != UNSPECIFIED_VALUE ? valueOf(DOMAIN_ENUM_CLASS, proto.name()) : null;
    }

    @Override
    public P toProtobufValue(Object instance) {
        return valueOf(PROTO_ENUM_CLASS, ((D) instance).name());
    }

}
