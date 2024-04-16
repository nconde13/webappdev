package org.humber.student.repositories;

import org.humber.student.repositories.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderJPARepository extends JpaRepository<OrderEntity, Long> {

    @Query("SELECT g FROM OrderEntity g WHERE g.customer.customerId = :customerId")
    List<OrderEntity> findAllByOrder(Long customerId);

    List<OrderEntity> findByUser_Id(Long userId);
}