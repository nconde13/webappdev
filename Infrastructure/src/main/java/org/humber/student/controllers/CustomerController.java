package org.humber.student.controllers;

import lombok.extern.slf4j.Slf4j;
import org.humber.student.domain.Customer;
import org.humber.student.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        // Set the customerId from path variable
        customer.setCustomerId(customerId);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        boolean deleted = customerService.deleteCustomer(customerId);
        log.info("Deleted customer with id= {} {}", customerId, deleted);
        if (deleted) {
            return "Customer deleted successfully!";
        }
        return "Customer not found.";
    }
}
