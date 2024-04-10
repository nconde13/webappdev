package org.humber.student.exceptions;

public class RestaurantValidationException extends RuntimeException {

    private final ErrorCode errorCode;

    public RestaurantValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
