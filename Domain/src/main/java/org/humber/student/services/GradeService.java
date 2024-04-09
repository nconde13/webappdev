package org.humber.student.services;

import org.humber.student.domain.Grade;

public interface GradeService {

    Grade createGrade(Grade grade);

    boolean deleteGrade(Long gradeId);

    Grade updateGrade(Grade grade);

    Grade getGrade(Long gradeId);
}
