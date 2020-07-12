package com.mentor.link.service;

import com.mentor.link.auth.AuthenticationContext;
import com.mentor.link.persistence.UserSearchFilterRepository;
import com.mentor.link.persistence.model.User;
import com.mentor.link.persistence.model.UserSearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSearchFilterService {

    private final UserSearchFilterRepository userSearchFilterRepository;

    @Autowired
    public UserSearchFilterService(UserSearchFilterRepository userSearchFilterRepository) {
        this.userSearchFilterRepository = userSearchFilterRepository;
    }

    public UserSearchFilter getFilter() {
        final User user = AuthenticationContext.getUser();
        return user.getUserSearchFilter();
    }

    public UserSearchFilter saveFilter(UserSearchFilter filter) {
        final User user = AuthenticationContext.getUser();
        filter.setId(user.getId());
        return userSearchFilterRepository.save(filter);
    }
}
