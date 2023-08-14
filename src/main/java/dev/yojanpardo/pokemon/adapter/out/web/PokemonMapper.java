package dev.yojanpardo.pokemon.adapter.out.web;

import dev.yojanpardo.pokemon.domain.Pokemon;

public interface PokemonMapper {
    Pokemon webResponseToDomain(final PokemonWeb pokemonWeb);
}
