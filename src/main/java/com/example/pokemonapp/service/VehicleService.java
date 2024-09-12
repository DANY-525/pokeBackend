package com.example.pokemonapp.service;

import com.example.pokemonapp.dto.VehicleDto;
import com.example.pokemonapp.entities.Vehiculo;
import com.example.pokemonapp.exceptions.CustomException;
import com.example.pokemonapp.exceptions.VehicleNotFoundException;
import com.example.pokemonapp.exceptions.VehicleServiceException;
import com.example.pokemonapp.repository.VehicleRepository;
import jakarta.transaction.Transactional;
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


    @Transactional
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
    @Transactional
    public Vehiculo updateVehicle(Long id, VehicleDto vehicleDto) {
        try {
            // Fetch the existing vehicle by ID
            Vehiculo existingVehicle = vehicleRepository.findById(id)
                    .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with ID: " + id));

            // Update the fields of the existing vehicle
            existingVehicle.setPlaca(vehicleDto.getPlaca());
            existingVehicle.setFechaTechno(vehicleDto.getFechaTechno());
            existingVehicle.setFechaSoat(vehicleDto.getFechaSoat());
            existingVehicle.setTipo(vehicleDto.getTipo());
            existingVehicle.setUbicacion(vehicleDto.getUbicacion());

            // Save the updated vehicle
            return vehicleRepository.save(existingVehicle);
        } catch (Exception e) {
            // Log and rethrow the exception
            // logger.error("Error updating vehicle", e);
            throw new VehicleServiceException("Failed to update vehicle", e);
        }
    }

    @Transactional
    public void deleteVehicle(Long id) {
        try {
            if (!vehicleRepository.existsById(id)) {
                throw new VehicleNotFoundException("Vehicle not found with ID: " + id);
            }
            vehicleRepository.deleteById(id);
        } catch (Exception e) {
            // Log the exception (optional)
            // logger.error("Error deleting vehicle", e);
            throw new VehicleServiceException("Failed to delete vehicle", e);
        }
    }




}
