package com.example.pokemonapp.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {

    private String name;
    private String url;

}