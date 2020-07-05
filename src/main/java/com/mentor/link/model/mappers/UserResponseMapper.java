package com.mentor.link.model.mappers;

import com.mentor.link.model.User;
import com.mentor.link.model.UserResponse;
import com.mentor.link.utils.Mapper;

public class UserResponseMapper implements Mapper<User, UserResponse> {

    @Override
    public UserResponse map(User fromData) {
        return new UserResponse(fromData.getId(), fromData.getName(), fromData.getEmail());
    }
}
