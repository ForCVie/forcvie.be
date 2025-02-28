package com.example.corebase.infrastructure.constant;

public enum StatusExceptionConstants {

    ERROR_BAD_REQUEST(400),
    ERROR_UNKNOWN(404);

    private int status;

    StatusExceptionConstants(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
