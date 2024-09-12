package com.example.pokemonapp.exceptions;

public class CustomException extends RuntimeException {
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}