package org.humber.student.transformers;

import org.humber.student.domain.Course;
import org.humber.student.repositories.entities.CourseEntity;

import java.util.List;

public final class CourseEntityTransformer {
    public static Course transformToCourse(CourseEntity courseEntity) {
        return Course.builder()
                .courseId(courseEntity.getCourseId())
                .courseName(courseEntity.getCourseName())
                .courseDescription(courseEntity.getCourseDescription())
                .build();
    }

    public static CourseEntity transformToCourseEntity(Course course) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(course.getCourseId());
        courseEntity.setCourseName(course.getCourseName());
        courseEntity.setCourseDescription(course.getCourseDescription());
        return courseEntity;
    }
}
