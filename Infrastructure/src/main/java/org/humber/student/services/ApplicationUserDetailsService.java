package org.humber.student.services;

import org.humber.student.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ApplicationUserDetailsService extends UserDetailsService {

    boolean registerUser(UserDto userDto);
}
