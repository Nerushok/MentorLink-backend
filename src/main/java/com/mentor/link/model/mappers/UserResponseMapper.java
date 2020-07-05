package com.mentor.link.model.mappers;

import com.mentor.link.model.User;
import com.mentor.link.model.UserResponse;
import com.mentor.link.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements Mapper<User, UserResponse> {

    @Override
    public UserResponse map(User fromData) {
        return new UserResponse(fromData.getId(), fromData.getName(), fromData.getEmail());
    }
}
