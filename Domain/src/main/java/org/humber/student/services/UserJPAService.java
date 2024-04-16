package org.humber.student.services;


import org.humber.student.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJPAService {
    Optional<User> findByUsername(String username);
}