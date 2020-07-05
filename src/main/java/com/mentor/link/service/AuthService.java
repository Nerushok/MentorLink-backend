package com.mentor.link.service;

import com.mentor.link.model.LoginRequest;
import com.mentor.link.model.RegistrationRequest;
import com.mentor.link.model.User;
import com.mentor.link.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registration(RegistrationRequest registrationRequest) {
        final Optional<User> userCandidate = userRepository.getUserByEmail(registrationRequest.getEmail());

        if (userCandidate.isPresent()) {
            throw new RuntimeException("User is already exists.");
        } else {
            final User user = new User(
                    UUID.randomUUID(),
                    registrationRequest.getName(),
                    registrationRequest.getEmail(),
                    registrationRequest.getPassword()
            );

            return userRepository.addUser(user);
        }
    }

    public User login(LoginRequest loginRequest) {
        final Optional<User> user = userRepository.getUserByEmail(loginRequest.getEmail());

        if (user.isPresent()) return user.get();
        else throw new UsernameNotFoundException("User isn't exist.");
    }
}
