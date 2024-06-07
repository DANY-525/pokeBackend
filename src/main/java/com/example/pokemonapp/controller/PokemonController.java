package com.example.pokemonapp.controller;

import com.example.pokemonapp.dto.Vehicle;
import com.example.pokemonapp.entities.Pokemons;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.service.PokemonService;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/pokemon")

public class PokemonController {
    private final PokemonService pokemonService;
    @PostMapping
    public ResponseEntity<Pokemons>  savePokemon (@RequestBody Pokemon pok){
         return  new ResponseEntity<>(pokemonService.addPokemons(Pokemons.builder().name(pok.getName()).url(pok.getUrl()).build()),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Iterable<Pokemons>> getPokemons(){
        return new ResponseEntity<>(pokemonService.getPokemons(),HttpStatus.OK);
    }
}
