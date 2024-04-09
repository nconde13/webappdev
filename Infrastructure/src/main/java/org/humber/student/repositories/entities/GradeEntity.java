package org.humber.student.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "grade")
@Entity
public class GradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long gradeId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;

    @Column(name = "midterm_percentage")
    private double midtermPercentage;

    @Column(name = "final_percentage")
    private double finalPercentage;
}
