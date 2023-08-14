package dev.yojanpardo.pokemon.domain;

import lombok.Data;

@Data
public class PokemonAbility {
    private Boolean isHidden;
    private Integer slot;
    private Item ability;
}
