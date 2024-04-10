package org.humber.student.services;

import org.humber.student.domain.Customer;
import java.util.List;

public interface CustomerJPAService {
    Customer getCustomerById(Long customerId);

    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);

    boolean deleteCustomer(Long customerId);

    Customer updateCustomer(Customer customer);
}
