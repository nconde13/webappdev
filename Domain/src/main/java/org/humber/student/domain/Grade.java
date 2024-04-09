package org.humber.student.domain;

import lombok.*;

@Data
@Builder
public class Grade {
    private Long gradeId;
    private Long courseId;
    private String courseName;
    private double midtermPercentage;
    private double finalPercentage;
}
