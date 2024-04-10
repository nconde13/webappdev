package org.humber.student.exceptions;

public class CustomerValidationException extends RuntimeException {

    private final ErrorCode errorCode;

    public CustomerValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
