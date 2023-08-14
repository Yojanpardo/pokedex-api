package dev.yojanpardo.pokemon.application.port.in;

import dev.yojanpardo.pokemon.domain.Pokemon;

import java.util.List;
import java.util.Map;

public interface GetPokemonsUseCase {
    List<Pokemon> getPokemons();
    List<Pokemon> getPokemons(Map<String, String> params);
}
