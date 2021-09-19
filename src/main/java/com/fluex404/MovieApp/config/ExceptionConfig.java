package com.fluex404.MovieApp.config;

import com.fluex404.MovieApp.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<String> exception(CustomException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus());
    }
}
