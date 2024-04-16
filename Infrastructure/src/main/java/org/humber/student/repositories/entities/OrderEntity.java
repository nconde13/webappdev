package org.humber.student.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Table(name = "orders")
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "tracking_id")
    private TrackingEntity tracking;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Min(0)
    @Max(5)
    @Column(nullable = false)
    private int rating;
    
    @Column(name = "review")
    private String review;
}