package com.mentor.link.persistence.model.converter;

import com.mentor.link.persistence.model.Gender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Gender attribute) {
        if (attribute == null) {
            return null;
        }

        return attribute.getCode();
    }

    @Override
    public Gender convertToEntityAttribute(Integer dbData) {
        return Gender.fromCode(dbData);
    }
}
