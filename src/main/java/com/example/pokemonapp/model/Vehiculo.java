package com.example.pokemonapp.model;

import java.util.Date;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehiculo {
    private  String numeroPlaca;
    private String tipo;
    private Date fechaSoat;
    private Date fechaTechno;
    private String ubicacion;
}
