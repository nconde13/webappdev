package org.humber.student.services.impl;

import org.humber.student.domain.User;
import org.humber.student.repositories.UserJPARepository;
import org.humber.student.services.UserJPAService;
import org.humber.student.transformers.UserEntityTransformer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserJPAServiceImpl implements UserJPAService {

    private final UserJPARepository userJPARepository;

    public UserJPAServiceImpl(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return userJPARepository.findByUsername(username).map(UserEntityTransformer::transformToUser);
    }
}