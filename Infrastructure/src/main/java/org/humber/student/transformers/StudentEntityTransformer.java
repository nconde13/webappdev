package org.humber.student.transformers;

import org.humber.student.domain.Address;
import org.humber.student.domain.Student;
import org.humber.student.repositories.entities.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.humber.student.transformers.GradeEntityTransformer.transformToGrades;

public final class StudentEntityTransformer {

    private StudentEntityTransformer() {
    }

    public static StudentEntity transformToStudentEntity(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(student.getStudentId());
        studentEntity.setName(student.getName());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setPhone(student.getPhone());
        setAddress(student, studentEntity);
        studentEntity.setProgram(student.getProgram());
        studentEntity.setSemester(student.getSemester());
        return studentEntity;
    }

    private static void setAddress(Student student, StudentEntity studentEntity) {
        if (student.getAddress() == null) {
            return;
        }
        studentEntity.setStreet(student.getAddress().getStreet());
        studentEntity.setCity(student.getAddress().getCity());
        studentEntity.setProvince(student.getAddress().getProvince());
        studentEntity.setPostalCode(student.getAddress().getPostalCode());
        studentEntity.setCountry(student.getAddress().getCountry());
    }

    public static Student transformToStudent(StudentEntity studentEntity) {
        return Student.builder()
                .studentId(studentEntity.getStudentId())
                .name(studentEntity.getName())
                .email(studentEntity.getEmail())
                .phone(studentEntity.getPhone())
                .address(transformToAddress(studentEntity))
                .program(studentEntity.getProgram())
                .semester(studentEntity.getSemester())
                .grades(transformToGrades(studentEntity.getGrades()))
                .build();
    }

    private static Address transformToAddress(StudentEntity studentEntity) {
        return Address.builder()
                .street(studentEntity.getStreet())
                .city(studentEntity.getCity())
                .province(studentEntity.getProvince())
                .postalCode(studentEntity.getPostalCode())
                .country(studentEntity.getCountry())
                .build();
    }

    public static List<Student> transformToStudents(List<StudentEntity> entities) {
        return entities.stream()
                .map(StudentEntityTransformer::transformToStudent)
                .collect(Collectors.toList());
    }
}
