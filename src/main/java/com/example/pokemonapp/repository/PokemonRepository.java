package com.example.pokemonapp.repository;

import com.example.pokemonapp.entities.Pokemons;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemons,Long> {
}
