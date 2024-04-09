package org.humber.student.services;

import org.humber.student.domain.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);

    boolean deletePayment(Long paymentId);

    Payment updatePayment(Payment payment);

    Payment getPayment(Long paymentId);
}
