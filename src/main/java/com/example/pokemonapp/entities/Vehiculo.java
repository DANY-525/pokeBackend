package com.example.pokemonapp.entities;

import jakarta.persistence.*;

@Table(name="vehiculos",schema = "pokemon")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="numero_placa")
    private String  placa;

    @Column(name="tipo")
    private String  tipo;
    @Column(name="fecha_soat")
    private String  fechaSoat;
    @Column(name="fecha_techno")
    private String  fechaSoat;
    @Column(name="ubicacion")
    private String  ubicacion;
}
