package org.humber.student.services;

import org.humber.student.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderJPAService{
    Optional<Order> findById(Long id);
    List<Order> findByUserId(Long userId);
    List<Order> findAll(); 
    Order save(Order order);
    void delete(Order order);
}
