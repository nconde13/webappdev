package org.humber.student.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "item")
@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    @Column(name = "item_name")
    public String itemName;

    @Column(name = "item_cost")
    public double itemCost;
}
