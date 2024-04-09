package org.humber.student.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "order")
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "tracking_id")
    private TrackingEntity tracking;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;
}
