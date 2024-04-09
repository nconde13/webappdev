package org.humber.student.services.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.humber.student.domain.Customer;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.CustomerValidationException;
import org.humber.student.services.CustomerValidationService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class CustomerNameValidation implements CustomerValidationService {
    @Override
    public void validateCustomer(@NonNull Customer customer) {
        if (customer.getName() == null || !StringUtils.hasLength(customer.getName().trim())) {
            log.error("Customer name is null");
            throw new CustomerValidationException(ErrorCode.INVALID_CUSTOMER_NAME);
        }
    }
}
