package io.kch.sda.spring.security16.common;

import org.springframework.validation.FieldError;

public class FieldWithErrorMessage {
    private final String fieldName;
    private final String errorMessage;

    FieldWithErrorMessage(FieldError fieldError) {
        this.fieldName = fieldError.getField();
        this.errorMessage = fieldError.getDefaultMessage();
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
