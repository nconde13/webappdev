package org.humber.student.services.impl;

import lombok.NonNull;
import org.humber.student.domain.Customer;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.CustomerValidationException;
import org.humber.student.services.CustomerValidationService;
import org.springframework.stereotype.Component;

@Component
public class CustomerIdValidation implements CustomerValidationService {
    @Override
    public void validateCustomer(@NonNull Customer customer) {
        if(customer.getCustomerId() == null) {
            System.err.println("Customer id is null");
            throw new CustomerValidationException(ErrorCode.INVALID_CUSTOMER_ID);
        }
    }
}
