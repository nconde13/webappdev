package org.humber.student.services.impl;

import org.humber.student.domain.User;
import org.humber.student.services.UserJPAService;
import org.humber.student.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserJPAService userJPAService;

    @Autowired
    public UserServiceImpl(UserJPAService userJPAService) {
        this.userJPAService = userJPAService;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userJPAService.findByUsername(username);
    }
}