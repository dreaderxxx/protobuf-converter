package net.badata.protobuf.converter.type;

import com.google.protobuf.Timestamp;
import net.badata.protobuf.converter.inspection.NullValueInspector;

public class TimestampNullValueInspector implements NullValueInspector {

    @Override
    public boolean isNull(Object value) {
        return Timestamp.getDefaultInstance() == value;
    }

}
