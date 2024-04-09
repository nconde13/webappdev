package org.humber.student.services;

import org.humber.student.domain.Course;

public interface CourseService {

    Course createCourse(Course course);

    boolean deleteCourse(Long courseId);

    Course updateCourse(Course course);

    Course getCourse(Long courseId);
}
