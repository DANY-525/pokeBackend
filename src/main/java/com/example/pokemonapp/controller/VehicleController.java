package com.example.pokemonapp.controller;

import com.example.pokemonapp.dto.VehicleDto;
import com.example.pokemonapp.entities.Vehiculo;
import com.example.pokemonapp.exceptions.CustomException;
import com.example.pokemonapp.exceptions.VehicleNotFoundException;
import com.example.pokemonapp.exceptions.VehicleServiceException;
import com.example.pokemonapp.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")

public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Vehiculo>> getVehicles (){
        try {
            Iterable<Vehiculo> vehicles = vehicleService.getVehicles();
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (CustomException e) {
            // Log the error (optional)
            // logger.error("Error retrieving vehicles", e);
            // Respond with a meaningful error message and status code
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Log the error (optional)
            // logger.error("Unexpected error", e);
            // Respond with a generic error message and status code
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto){
        try {
            Vehiculo vehiculo = vehicleService.addVehicle(vehicleDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(vehiculo);
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> updateVehicle(@PathVariable("id") Long id, @RequestBody VehicleDto vehicleDto) {
        try {
            Vehiculo updatedVehicle = vehicleService.updateVehicle(id, vehicleDto);
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        } catch (VehicleNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (VehicleServiceException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable("id") Long id) {
        try {
            vehicleService.deleteVehicle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (VehicleNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (VehicleServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
