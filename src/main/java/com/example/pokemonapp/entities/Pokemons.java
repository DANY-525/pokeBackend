package com.example.pokemonapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name="pokemons",schema = "pokemon")
public class Pokemons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="url")
    private String url;
}
