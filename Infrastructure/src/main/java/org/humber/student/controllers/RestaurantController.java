package org.humber.student.controllers;

import lombok.extern.slf4j.Slf4j;
import org.humber.student.domain.Restaurant;
import org.humber.student.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
    }

    @GetMapping("/{restaurantId}")
    public Restaurant getRestaurant(@PathVariable Long restaurantId) {
        return restaurantService.getRestaurant(restaurantId);
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long restaurantId, @RequestBody Restaurant restaurant) {
        // Set the restaurantId from path variable
        restaurant.setRestaurantId(restaurantId);
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/{restaurantId}")
    public String deleteRestaurant(@PathVariable Long restaurantId) {
        boolean deleted = restaurantService.deleteRestaurant(restaurantId);
        log.info("Deleted restaurant with id= {} {}", restaurantId, deleted);
        if (deleted) {
            return "Restaurant deleted successfully!";
        }
        return "Restaurant not found.";
    }
}
