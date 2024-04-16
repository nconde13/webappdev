package org.humber.student.controllers;

import lombok.extern.slf4j.Slf4j;
import org.humber.student.domain.Restaurant;
import org.humber.student.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
        return ResponseEntity.ok(restaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long restaurantId, @RequestBody Restaurant restaurant) {
        // Set the restaurantId from path variable
        restaurant.setRestaurantId(restaurantId);
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long restaurantId) {
        boolean deleted = restaurantService.deleteRestaurant(restaurantId);
        log.info("Deleted restaurant with id= {} {}", restaurantId, deleted);
        if (deleted) {
            return ResponseEntity.ok("Restaurant deleted successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurant not found.");
    }
}
