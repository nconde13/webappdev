package org.humber.student.domain;

import lombok.*;

@Data
@Builder
public class Order {
    private Long id;
    private Long trackingId; // Tracking.java
    private Long paymentId; // Payment.java
    private Long userId; // User.java
    private int rating;
    private String review;
}