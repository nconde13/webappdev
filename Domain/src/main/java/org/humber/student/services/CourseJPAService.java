package org.humber.student.services;

import org.humber.student.domain.Course;

import java.util.Optional;

public interface CourseJPAService {

    Course save(Course course);

    boolean deleteById(Long courseId);

    Optional<Course> findById(Long courseId);
}
