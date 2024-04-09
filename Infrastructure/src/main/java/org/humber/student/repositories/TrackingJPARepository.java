package org.humber.student.repositories;

import org.humber.student.repositories.entities.TrackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingJPARepository extends JpaRepository<TrackingEntity, Long> {

}
