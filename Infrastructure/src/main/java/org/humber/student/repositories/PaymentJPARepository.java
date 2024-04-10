package org.humber.student.repositories;

import org.humber.student.repositories.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJPARepository extends JpaRepository<PaymentEntity, Long> {

}
