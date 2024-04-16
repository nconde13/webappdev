package org.humber.student.services.impl;

import org.humber.student.domain.Order;
import org.humber.student.services.OrderJPAService;
import org.humber.student.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    
    private final OrderJPAService orderJPAService;
    
    @Autowired
    public OrderServiceImpl(OrderJPAService orderJPAService) {
        this.orderJPAService = orderJPAService;
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        return false;
    }

    @Override
    public Order updateOrder(Order order) {
       return orderJPAService.save(order); 
    }

    @Override
    public Order getOrder(Long orderId) {
       return orderJPAService.findById(orderId).orElse(null); 
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderJPAService.findByUserId(userId);
    }

    @Override
    public Order save(Order order) {
       return orderJPAService.save(order); 
    }
}