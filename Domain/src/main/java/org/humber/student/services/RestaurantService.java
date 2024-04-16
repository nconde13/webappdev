package org.humber.student.services;

import org.humber.student.domain.Restaurant;

import java.util.List;  

public interface RestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);

    boolean deleteRestaurant(Long restaurantId);

    Restaurant updateRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(Long restaurantId);

    List<Restaurant> getAllRestaurants();  
}
