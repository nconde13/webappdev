package org.humber.student.repositories;

import org.humber.student.repositories.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJPARepository extends JpaRepository<CourseEntity, Long> {

}
