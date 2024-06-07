package com.example.pokemonapp.dto;
import lombok.*;
import java.util.Date;
@Getter
@Setter
@Builder

public class Vehicle {
    private int id;
    private String color;
    private int model;
    private int type;
    private String linea;
    private Date enrollDate;
}
