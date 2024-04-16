package org.humber.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String roles = "USER"; //sets default role to USER
}