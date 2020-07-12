package com.mentor.link.service;

import com.mentor.link.auth.AuthUserDetails;
import com.mentor.link.persistence.UserRepository;
import com.mentor.link.persistence.model.User;
import com.mentor.link.service.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = userRepository.findByEmail(username);

        if (user.isPresent()) {
            return new AuthUserDetails(user.get());
        } else {
            throw new UserNotFoundException();
        }
    }

    public UserDetails getUserDetailsByUser(User user) {
        return new AuthUserDetails(user);
    }
}
