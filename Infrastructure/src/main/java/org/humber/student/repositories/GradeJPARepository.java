package org.humber.student.repositories;

import org.humber.student.repositories.entities.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeJPARepository extends JpaRepository<GradeEntity, String> {

    @Query("SELECT g FROM GradeEntity g WHERE g.student.studentId = :studentId")
    List<GradeEntity> findAllByStudent(Long studentId);
}
