package com.example.pokemonapp.service;

import com.example.pokemonapp.dto.VehicleDto;
import com.example.pokemonapp.entities.Vehiculo;
import com.example.pokemonapp.exceptions.CustomException;
import com.example.pokemonapp.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

@Service

@AllArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public Iterable<Vehiculo>  getVehicles(){
     return vehicleRepository.findAll();
  }


  public Vehiculo addVehicle(VehicleDto vehicleDto){
   try {
          return vehicleRepository.save(
                  Vehiculo.builder()
                          .placa(vehicleDto.getPlaca())
                          .fechaTechno(vehicleDto.getFechaTechno())
                          .fechaSoat(vehicleDto.getFechaSoat())
                          .tipo(vehicleDto.getTipo())
                          .ubicacion(vehicleDto.getUbicacion())
                          .build()
          );
      } catch (DataIntegrityViolationException e) {
          // Handle integrity constraint violations, such as duplicate entries
          throw new CustomException("Data integrity violation: " + e.getMessage(), e);
      } catch (ConstraintViolationException e) {
          // Handle specific constraint violations
          throw new CustomException("Constraint violation: " + e.getMessage(), e);
      } catch (JpaSystemException e) {
          // Handle system-related issues with JPA
          throw new CustomException("JPA system error: " + e.getMessage(), e);
      } catch (Exception e) {
          // Handle other exceptions
          throw new CustomException("An unexpected error occurred: " + e.getMessage(), e);
      }
  }

}
