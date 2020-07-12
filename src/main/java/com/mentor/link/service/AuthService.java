package com.mentor.link.service;

import com.mentor.link.api.auth.model.LoginRequest;
import com.mentor.link.persistence.UserRepository;
import com.mentor.link.persistence.model.User;
import com.mentor.link.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registration(User user) {
        final Optional<User> userCandidate = userRepository.findByEmail(user.getEmail());

        if (userCandidate.isPresent()) {
            throw new RuntimeException("User is already exists.");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }

    public User login(LoginRequest loginRequest) {
        final Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

        if (user.isPresent()) return user.get();
        else throw new UserNotFoundException();
    }
}
