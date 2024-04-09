package org.humber.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long studentId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Address address;
    private String program;
    private String semester;
    private List<Grade> grades;
}
