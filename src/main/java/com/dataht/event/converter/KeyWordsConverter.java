package com.dataht.event.converter;

import com.dataht.event.model.jsonb.KeyWords;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Convert
public class KeyWordsConverter
        implements AttributeConverter<List<KeyWords>, String>{
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<KeyWords> attribute) {
        return null;
    }

    @Override
    public List<KeyWords> convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return Collections.emptyList();
        }
        try {
            return mapper.readValue(dbData, new TypeReference<List<KeyWords>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
