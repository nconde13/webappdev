package org.humber.student.services.impl;

import org.humber.student.domain.Customer;
import org.humber.student.exceptions.CustomerValidationException;
import org.humber.student.services.CustomerJPAService;
import org.humber.student.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {

    @Mock
    private CustomerJPAService customerJPAService;
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerServiceImpl(customerJPAService, Arrays.asList(new CustomerIdValidation(), new CustomerNameValidation()));
    }

    @Test
    public void test_create_a_student_with_invalid_student_name() {
        // Given
        Customer customerStub = new Customer();
        customerStub.setName(null);

        //WHEN THEN
        // Use assertThrows to catch the exception thrown by createStudent method
        CustomerValidationException exception = assertThrows(CustomerValidationException.class, () -> {
            customerService.createCustomer(customerStub);
        });

        assertEquals("Invalid customer name", exception.getMessage());
    }


    @Test
    public void test_create_a_customer_with_valid_customer_name() {
        // Given
        Customer customerStub = new Customer();
        customerStub.setName("John");

        when(customerJPAService.saveCustomer(customerStub)).thenReturn(customerStub);

        //WHEN
        // Use assertDoesNotThrow to check if the createStudent method does not throw any exception
        Customer customer = customerService.createCustomer(customerStub);

        //THEN
        assertNotNull(customer);
    }
}
