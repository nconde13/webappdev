package org.humber.student.repositories;

import org.humber.student.repositories.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJPARepository extends JpaRepository<StudentEntity, Long> {

}
