package org.humber.student.services;

import org.humber.student.domain.Payment;

import java.util.Optional;

public interface PaymentJPAService {
    Payment save(Payment payment);

    boolean deleteById(Long paymentId);

    Optional<Payment> findById(Long paymentId);
}
