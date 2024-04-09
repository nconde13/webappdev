package org.humber.student.exceptions;

public enum ErrorCode {
    INVALID_STUDENT_ID("Invalid student id"),
    INVALID_STUDENT_NAME("Invalid student name"),
    INVALID_CUSTOMER_ID("Invalid customer id"),
    INVALID_CUSTOMER_NAME("Invalid customer name"),
    INVALID_RESTAURANT_ID("Invalid restaurant id"),
    INVALID_RESTAURANT_NAME("Invalid restaurant name");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
