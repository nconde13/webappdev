package org.humber.student.transformers;


import org.humber.student.domain.Grade;
import org.humber.student.repositories.entities.GradeEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class GradeEntityTransformer {

    private GradeEntityTransformer() {
    }

    public static Grade transformToGrade(GradeEntity gradeEntity) {
        return Grade.builder()
                .gradeId(gradeEntity.getGradeId())
                .courseId(gradeEntity.getCourse().getCourseId())
                .courseName(gradeEntity.getCourse().getCourseName())
                .midtermPercentage(gradeEntity.getMidtermPercentage())
                .finalPercentage(gradeEntity.getFinalPercentage())
                .build();
    }

    public static List<Grade> transformToGrades(List<GradeEntity> gradeEntities) {
        if(gradeEntities == null){
            return null;
        }
        return gradeEntities.stream()
                .map(GradeEntityTransformer::transformToGrade)
                .collect(Collectors.toList());
    }
}
