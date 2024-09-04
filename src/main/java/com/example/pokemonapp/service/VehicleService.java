package com.example.pokemonapp.service;

import com.example.pokemonapp.entities.Vehiculo;
import com.example.pokemonapp.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service

@AllArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public Iterable<Vehiculo>  getVehicles(){
     return vehicleRepository.findAll();
  }


  public Vehiculo addVehicle(Vehiculo vehiculo){
       return vehicleRepository.save(vehiculo);
  }

}
