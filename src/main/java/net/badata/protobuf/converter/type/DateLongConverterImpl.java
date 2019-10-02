/*
 * Copyright (C) 2016  BAData Creative Studio
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package net.badata.protobuf.converter.type;

import java.util.Date;

/**
 * Converts domain {@link Date Date} field value to protobuf {@link Long Long} field value.
 */
public class DateLongConverterImpl implements TypeConverter<Date, Long> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Date toDomainValue(final Object instance) {
        return new Date((Long) instance);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long toProtobufValue(final Object instance) {
        return ((Date) instance).getTime();
    }
}
