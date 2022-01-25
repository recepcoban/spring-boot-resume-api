package com.rcoban.resume.api.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class ErrorResponse {

    private final int httpStatusCode;
    private final String httpStatusName;
    private final String messageType;
    private final String messageCode;
    private final String messageText;
    private String stackTrace;
    private List<ValidationError> errors;

    public void addValidationError(String field, String message) {
        if (Objects.isNull(errors)) {
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }

    @Data
    private static class ValidationError {
        private final String field;
        private final String message;
    }

}
