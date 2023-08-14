package dev.yojanpardo.pokemon.domain;

import lombok.Data;

@Data
public class PokemonStat {
    private Integer baseStat;
    private Integer effort;
    private Item stat;
}
