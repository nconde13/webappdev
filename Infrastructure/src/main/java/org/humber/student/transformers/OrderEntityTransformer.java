package org.humber.student.transformers;


import org.humber.student.domain.Order;
import org.humber.student.repositories.entities.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class OrderEntityTransformer {

    private OrderEntityTransformer() {
    }

    public static Order transformToOrder(OrderEntity orderEntity) {
        return Order.builder()
                .orderId(orderEntity.getOrderId())
                .trackingId(orderEntity.getTracking().getTrackingId())
                .paymentId(orderEntity.getPayment().getPaymentId())
                .build();
    }

    public static List<Order> transformToOrders(List<OrderEntity> orderEntities) {
        if(orderEntities == null){
            return null;
        }
        return orderEntities.stream()
                .map(OrderEntityTransformer::transformToOrder)
                .collect(Collectors.toList());
    }
}
