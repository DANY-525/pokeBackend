package com.example.pokemonapp.exceptions;

public class VehicleNotFoundException extends  RuntimeException {
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
