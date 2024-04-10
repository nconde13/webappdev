package org.humber.student.controllers;

import io.swagger.v3.oas.annotations.Hidden;
import org.humber.student.dto.UserDto;
import org.humber.student.services.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Hidden
public class UserController {

    private final ApplicationUserDetailsService applicationUserDetailsService;

    @Autowired
    public UserController(ApplicationUserDetailsService applicationUserDetailsService) {
        this.applicationUserDetailsService = applicationUserDetailsService;
    }

    @PostMapping
    public boolean createUser(@RequestBody UserDto userDto) {
        return applicationUserDetailsService.registerUser(userDto);
    }
}
