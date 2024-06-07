package com.example.pokemonapp.repository;

import com.example.pokemonapp.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrationRepository  extends CrudRepository<User,Long> {
   List<User> findByEmail(String email);


}
