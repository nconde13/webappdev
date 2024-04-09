package org.humber.student.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {
    private Long courseId;
    private String courseName;
    private String courseDescription;
}
