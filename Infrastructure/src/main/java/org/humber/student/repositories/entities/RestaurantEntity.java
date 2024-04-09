package org.humber.student.repositories.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "name")
    public String name;

    @Column(name = "street")
    public String street;

    @Column(name = "city")
    public String city;

    @Column(name = "province")
    public String province;

    @Column(name = "postal_code")
    public String postalCode;

    @Column(name = "country")
    public String country;

    @Column(name = "cuisine_type")
    public String cuisineType;

}
