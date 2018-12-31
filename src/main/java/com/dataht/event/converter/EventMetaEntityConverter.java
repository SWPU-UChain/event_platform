package com.dataht.event.converter;

import com.dataht.event.model.jsonb.EventMetaEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;

@Converter
public class EventMetaEntityConverter
        implements AttributeConverter<EventMetaEntity, String> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(EventMetaEntity attribute) {
        return null;
    }

    @Override
    public EventMetaEntity convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return new EventMetaEntity();
        }
        try {
            return mapper.readValue(dbData, EventMetaEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
