package com.mentor.link.repository.user;

import com.mentor.link.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> getUserById(UUID id);

    Optional<User> getUserByEmail(String email);

    User addUser(User user);
}
