package org.humber.student.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;
}
