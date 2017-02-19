package io.kch.sda.spring.unit06.common;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Object handleExceptionWithErrors(Exception exception, Errors errors) {
        if (errors.hasErrors()) {
            return new ValidationErrors(errors);
        }

        return new ExceptionWithMessage(exception);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ExceptionWithMessage handleException(RuntimeException exception) {
        return new ExceptionWithMessage(exception);
    }

}
