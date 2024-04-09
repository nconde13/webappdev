package org.humber.student.services;

import org.humber.student.domain.Order;

public interface OrderService {
    Order createOrder(Order order);

    boolean deleteOrder(Long orderId);

    Order updateOrder(Order order);

    Order getOrder(Long orderId);
}
