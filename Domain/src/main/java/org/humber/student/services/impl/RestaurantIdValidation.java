package org.humber.student.services.impl;

import lombok.NonNull;
import org.humber.student.domain.Restaurant;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.RestaurantValidationException;
import org.humber.student.services.RestaurantValidationService;
import org.springframework.stereotype.Component;

@Component
public class RestaurantIdValidation implements RestaurantValidationService {
    @Override
    public void validateRestaurant(@NonNull Restaurant restaurant) {
        if(restaurant.getRestaurantId() == null) {
            System.err.println("Restaurant id is null");
            throw new RestaurantValidationException(ErrorCode.INVALID_RESTAURANT_ID);
        }
    }
}
