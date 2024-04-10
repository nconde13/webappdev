package org.humber.student.repositories;

import org.humber.student.repositories.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantJPARepository extends JpaRepository<RestaurantEntity, Long> {

}
