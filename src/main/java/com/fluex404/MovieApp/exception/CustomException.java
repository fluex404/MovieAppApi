package com.fluex404.MovieApp.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {
    private HttpStatus status;
    private String message;

    public CustomException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
