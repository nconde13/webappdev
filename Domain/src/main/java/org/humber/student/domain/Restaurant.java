package org.humber.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private Long restaurantId;
    public String name;
    public Address address;
    public String cuisineType; // Mexican, Indian, Chinese, etc.
}
