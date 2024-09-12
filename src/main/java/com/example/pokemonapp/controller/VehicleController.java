package com.example.pokemonapp.controller;

import com.example.pokemonapp.dto.VehicleDto;
import com.example.pokemonapp.entities.Vehiculo;
import com.example.pokemonapp.exceptions.CustomException;
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
            return new ResponseEntity<>( vehicleService.getVehicles(), HttpStatus.OK);
        }catch (Exception e){
            // Return a suitable error response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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



}
