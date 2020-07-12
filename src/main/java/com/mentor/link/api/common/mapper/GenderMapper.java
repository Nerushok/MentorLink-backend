package com.mentor.link.api.common.mapper;

import com.mentor.link.persistence.model.Gender;
import org.mapstruct.Mapper;
import org.springframework.lang.Nullable;

@Mapper
public abstract class GenderMapper {

    @Nullable
    Gender intToGender(Integer integer) {
        return Gender.fromCode(integer);
    }

    Integer genderToInt(Gender gender) {
        return gender.getCode();
    }
}
