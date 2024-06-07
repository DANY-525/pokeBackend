package com.example.pokemonapp.controller;

import com.example.pokemonapp.dto.Vehicle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class VehicleController {

    @GetMapping
    public ResponseEntity<Vehicle>  getVehicles (@RequestBody Vehicle vehicle){
         Vehicle vh =   Vehicle.builder().id(vehicle.getId()).model(vehicle.getModel()).linea(vehicle.getLinea()).color(vehicle.getColor()).enrollDate(vehicle.getEnrollDate()).type(vehicle.getType()).build();
        return  new ResponseEntity<>(vh, HttpStatus.OK);
    }



}
