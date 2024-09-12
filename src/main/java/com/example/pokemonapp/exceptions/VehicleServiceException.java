package com.example.pokemonapp.exceptions;

public class VehicleServiceException extends  RuntimeException {
    public VehicleServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
