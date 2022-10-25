package org.rejeev.lms.hibernate;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collections;

@Converter
public class LongArrayToStringConverter implements AttributeConverter<List<Long>,String> {
    @Override
    public String convertToDatabaseColumn(List<Long> attribute) {
        if(attribute == null || attribute.isEmpty()) return null;
        else return StringUtils.join(attribute,",");
    }

    @Override
    public List<Long> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) return Collections.emptyList();

        try (Stream<String> stream = Arrays.stream(dbData.split(","))) {
            return stream.map(Long::parseLong).collect(Collectors.toList());
        }
    }
}