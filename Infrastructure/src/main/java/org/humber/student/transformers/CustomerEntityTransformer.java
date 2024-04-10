package org.humber.student.transformers;

import org.humber.student.domain.Address;
import org.humber.student.domain.Customer;
import org.humber.student.repositories.entities.CustomerEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.humber.student.transformers.OrderEntityTransformer.transformToOrders;

public final class CustomerEntityTransformer {

    private CustomerEntityTransformer() {
    }

    public static CustomerEntity transformToCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerId(customer.getCustomerId());
        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhone(customer.getPhone());
        setAddress(customer, customerEntity);
        return customerEntity;
    }

    private static void setAddress(Customer customer, CustomerEntity customerEntity) {
        if (customer.getAddress() == null) {
            return;
        }
        customerEntity.setStreet(customer.getAddress().getStreet());
        customerEntity.setCity(customer.getAddress().getCity());
        customerEntity.setProvince(customer.getAddress().getProvince());
        customerEntity.setPostalCode(customer.getAddress().getPostalCode());
        customerEntity.setCountry(customer.getAddress().getCountry());
    }

    public static Customer transformToCustomer(CustomerEntity customerEntity) {
        return Customer.builder()
                .customerId(customerEntity.getCustomerId())
                .name(customerEntity.getName())
                .email(customerEntity.getEmail())
                .phone(customerEntity.getPhone())
                .address(transformToAddress(customerEntity))
                .orders(transformToOrders(customerEntity.getOrders()))
                .build();
    }

    private static Address transformToAddress(CustomerEntity customerEntity) {
        return Address.builder()
                .street(customerEntity.getStreet())
                .city(customerEntity.getCity())
                .province(customerEntity.getProvince())
                .postalCode(customerEntity.getPostalCode())
                .country(customerEntity.getCountry())
                .build();
    }

    public static List<Customer> transformToCustomers(List<CustomerEntity> entities) {
        return entities.stream()
                .map(CustomerEntityTransformer::transformToCustomer)
                .collect(Collectors.toList());
    }
}
