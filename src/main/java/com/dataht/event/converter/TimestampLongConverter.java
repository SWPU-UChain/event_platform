package com.dataht.event.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;

@Converter
public class TimestampLongConverter implements AttributeConverter<Long, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(Long millTime) {
        return millTime == null ? null : new Timestamp(millTime);
    }

    @Override
    public Long convertToEntityAttribute(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.getTime();
    }
}
