package com.ecohabitat.habitat_service.exceptions;

public class HabitatNotFoundException extends RuntimeException {
    public HabitatNotFoundException(String message) {
        super(message);
    }
}
