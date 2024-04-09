package org.humber.student.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payment {
    private Long paymentId;
    private double orderAmount; // (In dollars and cents) 11.29, 17.35, 34.70...
    private String paymentType; // CREDIT, DEBIT, GIFT CARD
}
