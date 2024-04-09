package org.humber.student.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.humber.student.domain.Student;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.StudentValidationException;
import org.humber.student.services.StudentJPAService;
import org.humber.student.services.StudentService;
import org.humber.student.services.StudentValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentJPAService studentJpaService;
    private final List<StudentValidationService> validationServices;

    @Autowired
    public StudentServiceImpl(StudentJPAService studentJpaService, List<StudentValidationService> validationService) {
        this.studentJpaService = studentJpaService;
        this.validationServices = validationService;
    }

    @Override
    public Student createStudent(Student student) {
        log.info("In method createStudent, validating student= {}", student);
        for (StudentValidationService validationService : validationServices) {
            if (validationService instanceof StudentIdValidation) {
                log.info("Skipping StudentIdValidation for new Student");
                continue;
            }
            validationService.validateStudent(student);
        }
        log.info("Saving student");
        return studentJpaService.saveStudent(student);
    }

    @Override
    public boolean deleteStudent(Long studentId) {
        log.info("Deleting student");
        return studentJpaService.deleteStudent(studentId);
    }

    @Override
    public Student updateStudent(Student student) {
        log.info("In method updateStudent, validating student= {}", student);
        for (StudentValidationService validationService : validationServices) {
            validationService.validateStudent(student);
        }
        log.info("Updating student");
        return studentJpaService.updateStudent(student);
    }

    @Override
    public Student getStudent(Long studentId) {
        log.info("Getting student for id= {}", studentId);
        if (studentId == null) {
            System.err.println("Student id is null");
            throw new StudentValidationException(ErrorCode.INVALID_STUDENT_ID);
        }
        return studentJpaService.getStudentById(studentId);
    }
}
