package com.example.corebase.infrastructure.exception;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception ex) {
        Gson gson = new Gson();
        if (ex instanceof BadRequestCustomException) {
            logger.error(gson.toJson(ex.getMessage()) + " BadRequestCustomException");
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        } else if (ex instanceof NoSuchElementException) {
            return ResponseEntity.notFound().build();
        } else {
            logger.error(gson.toJson(ex.getMessage()) + " INTERNAL_SERVER_ERROR", ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
