package io.kch.sda.spring.jpa16.common;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors {
    private final List<FieldWithErrorMessage> validationErrors;

    ValidationErrors(Errors errors) {
        validationErrors = new ArrayList<>(errors.getErrorCount());
        for (FieldError fieldError : errors.getFieldErrors()) {
            validationErrors.add(new FieldWithErrorMessage(fieldError));
        }
    }

    public List<FieldWithErrorMessage> getValidationErrors() {
        return validationErrors;
    }
}
