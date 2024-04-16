package org.humber.student.services.impl;

import org.humber.student.domain.Order;
import org.humber.student.repositories.OrderJPARepository;
import org.humber.student.repositories.entities.TrackingEntity;
import org.humber.student.services.OrderJPAService;
import org.humber.student.transformers.OrderEntityTransformer;
import org.humber.student.transformers.TrackingEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderJPAServiceImpl implements OrderJPAService {
    
    private final OrderJPARepository orderJPARepository;

    @Autowired
    public OrderJPAServiceImpl(OrderJPARepository orderJPARepository) {
        this.orderJPARepository = orderJPARepository;
    }

    @Override
    public Optional<Order> findById(Long id) {
       return orderJPARepository.findById(id).map(
               OrderEntityTransformer::transformToOrder
       ); 
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderJPARepository.findByUser_Id(userId).stream().map(
                OrderEntityTransformer::transformToOrder
        ).toList();
    }

    @Override
    public Order save(Order order) {
        var currentEntity = orderJPARepository.findById(order.getId()).get();
        return OrderEntityTransformer.transformToOrder(
               orderJPARepository.save(
                       OrderEntityTransformer.transformToOrderEntity(order, currentEntity)
               )
       ); 
    }
}