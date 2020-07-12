package com.mentor.link.persistence;

import com.mentor.link.persistence.model.UserSearchFilter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSearchFilterRepository extends CrudRepository<UserSearchFilter, Long> {
}