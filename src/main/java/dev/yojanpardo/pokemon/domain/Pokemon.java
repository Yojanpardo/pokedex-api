package dev.yojanpardo.pokemon.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class Pokemon {
    private Integer id;
    private String name;
    private Integer baseExperience;
    private Integer height;
    private Boolean isDefault;
    private Integer order;
    private Integer weight;
    private String locationAreaEncounters;
    private List<PokemonAbility> abilities;
    private List<Item> forms;
    private List<PokemonGameIndices> gameIndices;
    private List<PokemonHeldItem> pokemonHeldItems;
    private List<PokemonMove> moves;
    private Item species;
    private Map<String, String> sprites;
    private List<PokemonStat> stats;
    private List<PokemonType> types;
    private List<PokemonPastType> pastTypes;
}
