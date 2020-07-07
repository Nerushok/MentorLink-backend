package com.mentor.link.service;

import com.mentor.link.model.User;
import com.mentor.link.repository.user.UserRepository;
import com.mentor.link.utils.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        final Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(UserNotFoundException::new);
    }

    public List<User> findPaginated(int page, int size) {
        final Pageable pageable = PageRequest.of(page, size);
        final Page<User> pagedResult = userRepository.findAll(pageable);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return Collections.emptyList();
        }
    }
}
