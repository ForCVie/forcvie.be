package com.example.corebase.infrastructure.exception;

import com.example.corebase.infrastructure.constant.StatusExceptionConstants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestCustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    private int status;

    public BadRequestCustomException() {
    }

    public BadRequestCustomException(String message, StatusExceptionConstants status) {
        this.message = message;
        this.status = status.getStatus();
    }

    public BadRequestCustomException(String message) {
        this.message = message;
        this.status = StatusExceptionConstants.ERROR_BAD_REQUEST.getStatus();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
