package org.humber.student.services.impl;

import org.humber.student.domain.Student;
import org.humber.student.exceptions.StudentValidationException;
import org.humber.student.services.StudentJPAService;
import org.humber.student.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentServiceImplTest {

    @Mock
    private StudentJPAService studentJPAService;
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentServiceImpl(studentJPAService, Arrays.asList(new StudentIdValidation(), new StudentNameValidation()));
    }

    @Test
    public void test_create_a_student_with_invalid_student_name() {
        // Given
        Student studentStub = new Student();
        studentStub.setName(null);

        //WHEN THEN
        // Use assertThrows to catch the exception thrown by createStudent method
        StudentValidationException exception = assertThrows(StudentValidationException.class, () -> {
            studentService.createStudent(studentStub);
        });

        assertEquals("Invalid student name", exception.getMessage());
    }


    @Test
    public void test_create_a_student_with_valid_student_name() {
        // Given
        Student studentStub = new Student();
        studentStub.setName("John");

        when(studentJPAService.saveStudent(studentStub)).thenReturn(studentStub);

        //WHEN
        // Use assertDoesNotThrow to check if the createStudent method does not throw any exception
        Student student = studentService.createStudent(studentStub);

        //THEN
        assertNotNull(student);
    }
}
