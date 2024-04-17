package org.humber.student.transformers;


import org.humber.student.domain.Order;
import org.humber.student.repositories.OrderJPARepository;
import org.humber.student.repositories.TrackingJPARepository;
import org.humber.student.repositories.entities.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public final class OrderEntityTransformer {
    
    private TrackingJPARepository trackingJPARepository;

    private OrderEntityTransformer(TrackingJPARepository trackingJPARepository) {
        this.trackingJPARepository = trackingJPARepository;
    }

    public static Order transformToOrder(OrderEntity orderEntity) {
        return Order.builder()
                .id(orderEntity.getId())
                .trackingId(orderEntity.getTracking().getTrackingId())
                .paymentId(orderEntity.getPayment().getPaymentId())
                .userId(orderEntity.getUser().getId())
                .rating(orderEntity.getRating())
                .review(orderEntity.getReview())
                .build();
    }

    public static List<Order> transformToOrders(List<OrderEntity> orderEntities) {
        if(orderEntities == null){
            return Collections.emptyList();
        }
        return orderEntities.stream()
                .map(OrderEntityTransformer::transformToOrder)
                .toList();
    }
    
    public static OrderEntity transformToOrderEntity(Order order, OrderEntity currentEntity) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setTracking(currentEntity.getTracking());
        orderEntity.setPayment(currentEntity.getPayment());
        orderEntity.setUser(currentEntity.getUser());
        orderEntity.setRating(order.getRating());
        orderEntity.setReview(order.getReview());
        return orderEntity;
    }
}
