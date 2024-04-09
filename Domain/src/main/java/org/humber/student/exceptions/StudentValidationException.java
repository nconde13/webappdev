package org.humber.student.exceptions;

public class StudentValidationException extends RuntimeException {

    private final ErrorCode errorCode;

    public StudentValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
