package com.example.pokemonapp.dto;
import lombok.*;
import java.util.Date;
@Getter
@Setter
@Builder

public class VehicleDto {

  private String  placa;
  private String  tipo;
  private Date  fechaSoat;
  private Date  fechaTechno;
  private String  ubicacion;
}
