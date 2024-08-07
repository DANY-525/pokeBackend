package com.example.pokemonapp.controller;

import com.example.pokemonapp.dto.Vehicle;
import com.example.pokemonapp.entities.Vehiculo;
import com.example.pokemonapp.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Vehicle")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<Iterable<Vehiculo>> getVehicles (){
        return  new ResponseEntity<>( vehicleService.getVehicles(), HttpStatus.OK);
    }









}
