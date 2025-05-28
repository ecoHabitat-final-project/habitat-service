package com.ecohabitat.habitat_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HabitatNotFoundException.class)
    public ResponseEntity<String> handleHabitatNotFound(HabitatNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(HabitatsNotFoundException.class)
    public ResponseEntity<String> handleHabitatsNotFound(HabitatsNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
