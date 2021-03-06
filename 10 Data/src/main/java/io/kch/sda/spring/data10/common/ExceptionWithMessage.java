package io.kch.sda.spring.data10.common;

public class ExceptionWithMessage {
    private final String exceptionName;
    private final String exceptionMessage;

    ExceptionWithMessage(Exception exception) {
        this.exceptionName = exception.getClass().getSimpleName();
        this.exceptionMessage = exception.getMessage();
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
