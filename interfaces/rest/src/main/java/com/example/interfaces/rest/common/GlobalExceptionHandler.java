package com.example.interfaces.rest.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handle(IllegalArgumentException ex) { return new ApiErrorResponse("BAD_REQUEST", ex.getMessage()); }

    public record ApiErrorResponse(String code, String message) {}
}
