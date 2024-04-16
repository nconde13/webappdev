package org.humber.student.services;

import org.humber.student.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}