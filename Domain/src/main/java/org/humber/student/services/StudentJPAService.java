package org.humber.student.services;

import org.humber.student.domain.Student;

import java.util.List;

public interface StudentJPAService {

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    boolean deleteStudent(Long studentId);

    Student updateStudent(Student student);
}
