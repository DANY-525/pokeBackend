package com.example.pokemonapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Table(name="TransportationMode",schema = "pokemon")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_seq")
    @SequenceGenerator(name = "vehiculo_seq", sequenceName = "pokemon.transportationmode_seq", allocationSize = 1)
    private Long id;
    @Column(name="numero_placa")
    private String  placa;
    @Column(name="tipo")
    private String  tipo;
    @Column(name="fecha_soat")
    private Date  fechaSoat;
    @Column(name="fecha_tecno")
    private Date fechaTechno;
    @Column(name="ubicacion")
    private String  ubicacion;
}
