package com.mentor.link.repository.user;

import com.mentor.link.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("userRepository")
public class UserRepositoryIml implements UserRepository {

    private List<User> users = new ArrayList();

    @Override
    public Optional<User> getUserById(UUID id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }
}
