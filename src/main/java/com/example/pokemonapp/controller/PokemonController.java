package com.example.pokemonapp.controller;

import com.example.pokemonapp.entities.Pokemons;
import com.example.pokemonapp.model.Pokemon;
import com.example.pokemonapp.service.PokemonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController

@RequestMapping("/pokemon")

public class PokemonController {
    private final PokemonService pokemonService;
    private final WebClient webClient;
    private static final Logger log = LoggerFactory.getLogger(PokemonController.class);

    public PokemonController(WebClient.Builder webClientBuilder,PokemonService pokemonService) {
        this.webClient = webClientBuilder.baseUrl("https://pokeapi.co/api/v2").build();
        this.pokemonService = pokemonService;
    }

    @PostMapping
    public ResponseEntity<Pokemons>  savePokemon (@RequestBody Pokemon pok){
         return  new ResponseEntity<>(pokemonService.addPokemons(Pokemons.builder().name(pok.getName()).url(pok.getUrl()).build()),HttpStatus.OK);
    }
    @GetMapping("/getPokemonsExternal")
    public ResponseEntity<Iterable<Pokemons>> getPokemons(){
        return new ResponseEntity<>(pokemonService.getPokemons(),HttpStatus.OK);
    }

    @GetMapping
    public Mono<String> getPokemon() {

            return webClient.get()
                        .uri("/")
                        .retrieve()
                        .bodyToMono(String.class);

    }

    public static class PokemonApiResponse {
        private int count;
        private String next;
        private String previous;
        private List<Pokemon> results;

        // Getters and setters

        public static class Pokemon {
            private String name;
            private String url;

            // Getters and setters
        }

        // Getters and setters
    }
}
