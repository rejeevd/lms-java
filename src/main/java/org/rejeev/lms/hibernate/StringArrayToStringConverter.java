package org.rejeev.lms.hibernate;

import jakarta.persistence.AttributeConverter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringArrayToStringConverter implements AttributeConverter<List<String>,String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if(attribute == null || attribute.isEmpty()) return null;
        else return StringUtils.join(attribute,",");
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) return Collections.emptyList();
        else return Arrays.asList(dbData.split(","));
    }
}
