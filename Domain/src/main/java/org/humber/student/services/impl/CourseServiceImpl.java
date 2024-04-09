package org.humber.student.services.impl;

import org.humber.student.domain.Course;
import org.humber.student.services.CourseJPAService;
import org.humber.student.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseJPAService courseJPAService;

    @Autowired
    public CourseServiceImpl(CourseJPAService courseJPAService) {
        this.courseJPAService = courseJPAService;
    }

    @Override
    public Course createCourse(Course course) {
        return courseJPAService.save(course);
    }

    @Override
    public boolean deleteCourse(Long courseId) {
        return courseJPAService.deleteById(courseId);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseJPAService.save(course);
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseJPAService.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
    }
}
