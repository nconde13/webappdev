package org.humber.student.transformers;

import org.humber.student.domain.Payment;
import org.humber.student.repositories.entities.PaymentEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class PaymentEntityTransformer {

    private PaymentEntityTransformer() {
    }

    public static Payment transformToPayment(PaymentEntity paymentEntity) {
        return Payment.builder()
                .paymentId(paymentEntity.getPaymentId())
                .orderAmount(paymentEntity.getOrderAmount())
                .paymentType(paymentEntity.getPaymentType())
                .build();
    }

    public static PaymentEntity transformToPaymentEntity(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentId(payment.getPaymentId());
        paymentEntity.setOrderAmount(payment.getOrderAmount());
        paymentEntity.setPaymentType(payment.getPaymentType());
        return paymentEntity;
    }

    public static List<Payment> transformToPayments(List<PaymentEntity> paymentEntities) {
        return paymentEntities.stream()
                .map(PaymentEntityTransformer::transformToPayment)
                .collect(Collectors.toList());
    }

    public static List<PaymentEntity> transformToPaymentEntities(List<Payment> payments) {
        return payments.stream()
                .map(PaymentEntityTransformer::transformToPaymentEntity)
                .collect(Collectors.toList());
    }
}
