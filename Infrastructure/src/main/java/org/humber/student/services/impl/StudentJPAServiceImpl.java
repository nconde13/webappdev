package org.humber.student.services.impl;

import org.humber.student.domain.Student;
import org.humber.student.repositories.StudentJPARepository;
import org.humber.student.repositories.entities.StudentEntity;
import org.humber.student.services.StudentJPAService;
import org.humber.student.transformers.StudentEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.humber.student.transformers.StudentEntityTransformer.transformToStudent;
import static org.humber.student.transformers.StudentEntityTransformer.transformToStudentEntity;

@Service
public class StudentJPAServiceImpl implements StudentJPAService {

    private final StudentJPARepository studentJPARepository;

    @Autowired
    public StudentJPAServiceImpl(StudentJPARepository studentJPARepository) {
        this.studentJPARepository = studentJPARepository;
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentJPARepository.findById(studentId)
                .map(StudentEntityTransformer::transformToStudent)
                .orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return Optional.of(studentJPARepository.findAll())
                .map(StudentEntityTransformer::transformToStudents)
                .orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        StudentEntity studentEntity = transformToStudentEntity(student);
        StudentEntity savedEntity = studentJPARepository.save(studentEntity);
        return transformToStudent(savedEntity);
    }

    @Override
    public boolean deleteStudent(Long studentId) {
        Optional<StudentEntity> studentEntity = studentJPARepository.findById(studentId);
        if (studentEntity.isEmpty()) {
            return false;
        }
        studentJPARepository.delete(studentEntity.get());
        return true;
    }

    @Override
    public Student updateStudent(Student student) {
        return saveStudent(student);
    }
}
