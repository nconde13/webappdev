package org.humber.student.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.humber.student.dto.UserDto;
import org.humber.student.repositories.UserJPARepository;
import org.humber.student.repositories.entities.UserEntity;
import org.humber.student.services.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApplicationUserDetailsServiceImpl implements ApplicationUserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserJPARepository userJPARepository;

    @Autowired
    public ApplicationUserDetailsServiceImpl(PasswordEncoder passwordEncoder, UserJPARepository userJPARepository) {
        this.passwordEncoder = passwordEncoder;
        this.userJPARepository = userJPARepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userJPARepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRoles().split(","))
                .build();
    }

    @Override
    public boolean registerUser(UserDto userDto) {
        try{
            if(userJPARepository.existsByUsername(userDto.getUsername())){
                log.info("User already exists");
                return false;
            }
            UserEntity user = new UserEntity();
            user.setUsername(userDto.getUsername());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setRoles(userDto.getRoles());
            userJPARepository.save(user);
            return true;
        } catch (Exception e){
            log.error("Error registering user ", e);
        }
        return false;
    }
}