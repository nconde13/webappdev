package org.humber.student.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "course")
@Entity
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_description")
    private String courseDescription;
}
