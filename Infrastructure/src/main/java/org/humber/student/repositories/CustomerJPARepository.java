package org.humber.student.repositories;

import org.humber.student.repositories.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJPARepository extends JpaRepository<CustomerEntity, Long> {

}
