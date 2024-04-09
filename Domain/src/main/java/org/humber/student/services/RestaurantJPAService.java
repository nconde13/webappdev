package org.humber.student.services;

import org.humber.student.domain.Restaurant;

import java.util.List;

public interface RestaurantJPAService {
    Restaurant getRestaurantById(Long restaurantId);

    List<Restaurant> getAllRestaurants();

    Restaurant saveRestaurant(Restaurant restaurant);

    boolean deleteRestaurant(Long restaurantId);

    Restaurant updateRestaurant(Restaurant restaurant);
}
