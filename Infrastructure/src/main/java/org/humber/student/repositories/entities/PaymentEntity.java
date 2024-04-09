package org.humber.student.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "payment")
@Entity
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "order_amount")
    private double orderAmount;

    @Column(name = "payment_type")
    private String paymentType;
}
