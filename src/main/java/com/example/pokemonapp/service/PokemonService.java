package com.example.pokemonapp.service;

import com.example.pokemonapp.entities.Pokemons;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.repository.PokemonRepository;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final WebClient webClient;



    public Pokemons addPokemons(Pokemons pokemons){

        return pokemonRepository.save(pokemons);

    }


    public Iterable<Pokemons> getPokemons(){
         return pokemonRepository.findAll();
    }




}
