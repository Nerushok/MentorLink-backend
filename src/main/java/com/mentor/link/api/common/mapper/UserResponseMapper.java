package com.mentor.link.api.common.mapper;

import com.mentor.link.api.auth.model.RegistrationRequest;
import com.mentor.link.api.common.model.UserResponse;
import com.mentor.link.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = GenderMapper.class)
public interface UserResponseMapper {

    UserResponseMapper INSTANCE = Mappers.getMapper(UserResponseMapper.class);

    UserResponse userToUserResponse(User user);

    List<UserResponse> userToUserResponse(List<User> users);

    @Mapping(target = "userSearchFilter", ignore = true)
    @Mapping(target = "id", ignore = true)
    User registrationRequestToUser(RegistrationRequest registrationRequest);
}
