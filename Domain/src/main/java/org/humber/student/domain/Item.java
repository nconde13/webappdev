package org.humber.student.domain;

import lombok.*;

@Data
@Builder
public class Item {
    private Long itemId;
    private Long restaurantId; // Restaurant.java
    public String itemName;
    public double itemCost;
}
