package com.example.pokemonapp.service;

import com.example.pokemonapp.entities.Pokemons;
import com.example.pokemonapp.repository.PokemonRepository;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final WebClient.Builder webClientBuilder;


    public Pokemons addPokemons(Pokemons pokemons){

        return pokemonRepository.save(pokemons);

    }


}
