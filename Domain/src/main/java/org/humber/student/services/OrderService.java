package org.humber.student.services;

import org.humber.student.domain.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);

    boolean deleteOrder(Long orderId);

    Order updateOrder(Long orderId, Order order); 

    Order getOrder(Long orderId);
    
    List<Order> getOrders(); 
    
    List<Order> getOrdersByUserId(Long userId);
    
    Order save(Order order);
}
