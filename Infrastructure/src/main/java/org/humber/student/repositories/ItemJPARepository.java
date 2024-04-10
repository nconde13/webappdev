package org.humber.student.repositories;

import org.humber.student.repositories.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemJPARepository extends JpaRepository<ItemEntity, String> {

    @Query("SELECT g FROM ItemEntity g WHERE g.restaurant.restaurantId = :restaurantId")
    List<ItemEntity> findAllByRestaurant(Long restaurantId);
}
