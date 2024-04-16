package org.humber.student.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Long id;
    private String username;
    private String password;
    private String roles;
}