package com.mentor.link.api;

import com.mentor.link.Constants;
import com.mentor.link.api.common.mapper.UserResponseMapper;
import com.mentor.link.api.common.model.UserResponse;
import com.mentor.link.persistence.model.User;
import com.mentor.link.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(Constants.API_V1 + "users")
@RestController
public class UserController {

    private final UserService userService;

    private final UserResponseMapper userResponseMapper = UserResponseMapper.INSTANCE;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable("userId") Long userId) {
        final User user = userService.getUserById(userId);
        return userResponseMapper.userToUserResponse(user);
    }

    @GetMapping(params = {"page", "size"})
    public List<UserResponse> getUsers(@RequestParam("page") int page,
                                       @RequestParam("size") int size) {
        final List<User> users = userService.findPaginated(page, size);
        return userResponseMapper.userToUserResponse(users);
    }
}
