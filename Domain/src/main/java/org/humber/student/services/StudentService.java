package org.humber.student.services;

import org.humber.student.domain.Student;

public interface StudentService {

    Student createStudent(Student student);

    boolean deleteStudent(Long studentId);

    Student updateStudent(Student student);

    Student getStudent(Long studentId);

}
