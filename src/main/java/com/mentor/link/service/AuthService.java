package com.mentor.link.service;

import com.mentor.link.api.auth.model.LoginRequest;
import com.mentor.link.api.auth.model.RegistrationRequest;
import com.mentor.link.persistence.model.User;
import com.mentor.link.persistence.UserRepository;
import com.mentor.link.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registration(RegistrationRequest registrationRequest) {
        final Optional<User> userCandidate = userRepository.findByEmail(registrationRequest.getEmail());

        if (userCandidate.isPresent()) {
            throw new RuntimeException("User is already exists.");
        } else {
            final User user = new User();
            user.setName(registrationRequest.getName());
            user.setEmail(registrationRequest.getEmail());
            user.setPassword(registrationRequest.getPassword());

            return userRepository.save(user);
        }
    }

    public User login(LoginRequest loginRequest) {
        final Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

        if (user.isPresent()) return user.get();
        else throw new UserNotFoundException();
    }
}
