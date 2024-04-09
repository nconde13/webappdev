package org.humber.student.services.impl;

import org.humber.student.domain.Course;
import org.humber.student.repositories.CourseJPARepository;
import org.humber.student.repositories.entities.CourseEntity;
import org.humber.student.services.CourseJPAService;
import org.humber.student.transformers.CourseEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.humber.student.transformers.CourseEntityTransformer.transformToCourse;
import static org.humber.student.transformers.CourseEntityTransformer.transformToCourseEntity;

@Service
public class CourseJPAServiceImpl implements CourseJPAService {

    private final CourseJPARepository courseJPARepository;

    @Autowired
    public CourseJPAServiceImpl(CourseJPARepository courseJPARepository) {
        this.courseJPARepository = courseJPARepository;
    }

    @Override
    public Course save(Course course) {
        CourseEntity courseEntity = courseJPARepository.save(transformToCourseEntity(course));
        return transformToCourse(courseEntity);
    }

    @Override
    public boolean deleteById(Long courseId) {
        Course course = this.findById(courseId).orElse(null);
        if(course != null) {
            courseJPARepository.deleteById(courseId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Course> findById(Long courseId) {
        return courseJPARepository.findById(courseId).map(CourseEntityTransformer::transformToCourse);
    }
}
