package com.mentor.link.service;

import com.mentor.link.model.User;
import com.mentor.link.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = userRepository.getUserByEmail(username);

        if (user.isPresent()) {
            return getUserDetailsByUser(user.get());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserDetails getUserDetailsByUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(email, password, Collections.emptyList());
    }
}