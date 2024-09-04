package com.example.pokemonapp.controller;

import com.example.pokemonapp.dto.VehicleDto;
import com.example.pokemonapp.entities.Vehiculo;
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
        return  new ResponseEntity<>( vehicleService.getVehicles(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Vehiculo> addVehicle(@RequestBody VehicleDto vehicleDto){
        Vehiculo vehicleEntity = new Vehiculo();
        vehicleEntity.setTipo(vehicleDto.getTipo());
        vehicleEntity.setPlaca(vehicleDto.getPlaca());
        vehicleEntity.setUbicacion(vehicleDto.getUbicacion().toString());
        vehicleEntity.setFechaTechno(vehicleDto.getFechaTechno().toString());
         return  new ResponseEntity<>(vehicleService.addVehicle(vehicleEntity),HttpStatus.OK);
    }


}
