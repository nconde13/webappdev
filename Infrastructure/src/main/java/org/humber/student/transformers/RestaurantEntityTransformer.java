package org.humber.student.transformers;

import org.humber.student.domain.Address;
import org.humber.student.domain.Restaurant;
import org.humber.student.repositories.entities.RestaurantEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class RestaurantEntityTransformer {

    private RestaurantEntityTransformer() {
    }

    public static RestaurantEntity transformToRestaurantEntity(Restaurant restaurant) {
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setRestaurantId(restaurant.getRestaurantId());
        restaurantEntity.setName(restaurant.getName());
        restaurantEntity.setCuisineType(restaurant.getCuisineType());
        setAddress(restaurant, restaurantEntity);
        return restaurantEntity;
    }

    private static void setAddress(Restaurant restaurant, RestaurantEntity restaurantEntity) {
        if (restaurant.getAddress() == null) {
            return;
        }
        restaurantEntity.setStreet(restaurant.getAddress().getStreet());
        restaurantEntity.setCity(restaurant.getAddress().getCity());
        restaurantEntity.setProvince(restaurant.getAddress().getProvince());
        restaurantEntity.setPostalCode(restaurant.getAddress().getPostalCode());
        restaurantEntity.setCountry(restaurant.getAddress().getCountry());
    }

    public static Restaurant transformToRestaurant(RestaurantEntity restaurantEntity) {
        return Restaurant.builder()
                .restaurantId(restaurantEntity.getRestaurantId())
                .name(restaurantEntity.getName())
                .cuisineType(restaurantEntity.getCuisineType())
                .address(transformToAddress(restaurantEntity))
                .build();
    }

    private static Address transformToAddress(RestaurantEntity restaurantEntity) {
        return Address.builder()
                .street(restaurantEntity.getStreet())
                .city(restaurantEntity.getCity())
                .province(restaurantEntity.getProvince())
                .postalCode(restaurantEntity.getPostalCode())
                .country(restaurantEntity.getCountry())
                .build();
    }

    public static List<Restaurant> transformToRestaurants(List<RestaurantEntity> entities) {
        return entities.stream()
                .map(RestaurantEntityTransformer::transformToRestaurant)
                .collect(Collectors.toList());
    }
}
