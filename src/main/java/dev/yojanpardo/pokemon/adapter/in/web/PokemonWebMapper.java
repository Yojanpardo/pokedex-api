package dev.yojanpardo.pokemon.adapter.in.web;

import dev.yojanpardo.pokemon.domain.Pokemon;

import java.util.List;
import java.util.Map;

public interface PokemonWebMapper {
    PokemonListResponse.Pokemon pokemonToWebResponse(Pokemon pokemon);
    PokemonListResponse pokemonListToPokemonListResponse(List<Pokemon> pokemons, Map<String, String> params);
}
