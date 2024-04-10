package org.humber.student.services.impl;

import org.humber.student.domain.Customer;
import org.humber.student.repositories.CustomerJPARepository;
import org.humber.student.repositories.entities.CustomerEntity;
import org.humber.student.services.CustomerJPAService;
import org.humber.student.transformers.CustomerEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.humber.student.transformers.CustomerEntityTransformer.transformToCustomer;
import static org.humber.student.transformers.CustomerEntityTransformer.transformToCustomerEntity;

@Service
public class CustomerJPAServiceImpl implements CustomerJPAService {

    private final CustomerJPARepository customerJPARepository;

    @Autowired
    public CustomerJPAServiceImpl(CustomerJPARepository customerJPARepository) {
        this.customerJPARepository = customerJPARepository;
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerJPARepository.findById(customerId)
                .map(CustomerEntityTransformer::transformToCustomer)
                .orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return Optional.of(customerJPARepository.findAll())
                .map(CustomerEntityTransformer::transformToCustomers)
                .orElse(null);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        CustomerEntity customerEntity = transformToCustomerEntity(customer);
        CustomerEntity savedEntity = customerJPARepository.save(customerEntity);
        return transformToCustomer(savedEntity);
    }

    @Override
    public boolean deleteCustomer(Long customerId) {
        Optional<CustomerEntity> customerEntity = customerJPARepository.findById(customerId);
        if (customerEntity.isEmpty()) {
            return false;
        }
        customerJPARepository.delete(customerEntity.get());
        return true;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return saveCustomer(customer);
    }
}
