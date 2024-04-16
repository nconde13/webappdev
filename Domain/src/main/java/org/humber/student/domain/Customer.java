package org.humber.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long customerId;
    private String name;
    private String email;
    private String phone;
    private Address address;
    private List<Order> orders;
}
