package org.humber.student.domain;

import lombok.*;

@Data
@Builder
public class Order {
    private Long orderId;
    private Long trackingId; // Tracking.java
    private Long paymentId; // Payment.java
}
