package org.humber.student.services.impl;

import org.humber.student.domain.Order;
import org.humber.student.repositories.OrderJPARepository;
import org.humber.student.repositories.entities.OrderEntity;
import org.humber.student.services.OrderJPAService;
import org.humber.student.transformers.OrderEntityTransformer;
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
       return orderJPARepository.findById(id).map(OrderEntityTransformer::transformToOrder); 
    }

    @Override
    public List<Order> findByUserId(Long userId) {
        return orderJPARepository.findByUser_Id(userId).stream().map(OrderEntityTransformer::transformToOrder).toList();
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity;
        if (order.getId() != null) {
            orderEntity = orderJPARepository.findById(order.getId())
                    .map(existingOrderEntity -> OrderEntityTransformer.transformToOrderEntity(order, existingOrderEntity))
                    .orElseThrow(() -> new RuntimeException("Order not found with id: " + order.getId()));
        } else {
            orderEntity = OrderEntityTransformer.transformToOrderEntity(order, new OrderEntity());
        }

        return OrderEntityTransformer.transformToOrder(orderJPARepository.save(orderEntity));
    }

    @Override
    public void delete(Order order) {
        OrderEntity orderEntity = orderJPARepository.findById(order.getId())
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + order.getId()));
        orderJPARepository.delete(orderEntity);
    }

    @Override
    public List<Order> findAll() {
        return orderJPARepository.findAll().stream().map(OrderEntityTransformer::transformToOrder).toList();
    }
}
