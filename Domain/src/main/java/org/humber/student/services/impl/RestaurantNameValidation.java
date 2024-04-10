package org.humber.student.services.impl;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.humber.student.domain.Restaurant;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.RestaurantValidationException;
import org.humber.student.services.RestaurantValidationService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class RestaurantNameValidation implements RestaurantValidationService {
    @Override
    public void validateRestaurant(@NonNull Restaurant restaurant) {
        if (restaurant.getName() == null || !StringUtils.hasLength(restaurant.getName().trim())) {
            log.error("Restaurant name is null");
            throw new RestaurantValidationException(ErrorCode.INVALID_RESTAURANT_NAME);
        }
    }
}
