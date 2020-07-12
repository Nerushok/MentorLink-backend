package com.mentor.link.api.common.mapper;

import com.mentor.link.api.filter.model.UserSearchFilterDto;
import com.mentor.link.persistence.model.UserSearchFilter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = GenderMapper.class)
public interface UserSearchFilterMapper {

    UserSearchFilterMapper INSTANCE = Mappers.getMapper(UserSearchFilterMapper.class);

    UserSearchFilterDto userSearchFilterToDto(UserSearchFilter filter);

    @Mapping(target = "user", ignore = true)
    UserSearchFilter userSearchFilterToEntity(UserSearchFilterDto filter);
}
