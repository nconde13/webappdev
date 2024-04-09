package org.humber.student.services.impl;

import org.humber.student.domain.Restaurant;
import org.humber.student.exceptions.RestaurantValidationException;
import org.humber.student.services.RestaurantJPAService;
import org.humber.student.services.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RestaurantServiceImplTest {

    @Mock
    private RestaurantJPAService restaurantJPAService;
    private RestaurantService restaurantService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        restaurantService = new RestaurantServiceImpl(restaurantJPAService, Arrays.asList(new RestaurantIdValidation(), new RestaurantNameValidation()));
    }

    @Test
    public void test_create_a_restaurant_with_invalid_restaurant_name() {
        // Given
        Restaurant restaurantStub = new Restaurant();
        restaurantStub.setName(null);

        //WHEN THEN
        // Use assertThrows to catch the exception thrown by createStudent method
        RestaurantValidationException exception = assertThrows(RestaurantValidationException.class, () -> {
            restaurantService.createRestaurant(restaurantStub);
        });

        assertEquals("Invalid restaurant name", exception.getMessage());
    }


    @Test
    public void test_create_a_restaurant_with_valid_restaurant_name() {
        // Given
        Restaurant restaurantStub = new Restaurant();
        restaurantStub.setName("KFC");

        when(restaurantJPAService.saveRestaurant(restaurantStub)).thenReturn(restaurantStub);

        //WHEN
        // Use assertDoesNotThrow to check if the createStudent method does not throw any exception
        Restaurant restaurant = restaurantService.createRestaurant(restaurantStub);

        //THEN
        assertNotNull(restaurant);
    }
}
