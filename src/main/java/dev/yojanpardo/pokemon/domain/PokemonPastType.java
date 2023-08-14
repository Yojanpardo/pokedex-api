package dev.yojanpardo.pokemon.domain;

import lombok.Data;

import java.util.List;

@Data
public class PokemonPastType {
    private Item generation;
    private List<PokemonType> types;
}
