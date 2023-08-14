package dev.yojanpardo.pokemon.application.port.out;

import dev.yojanpardo.pokemon.domain.Pokemon;

import java.util.List;
import java.util.Map;

public interface LoadPokemonPort {
    List<Pokemon> loadAllPokemons();
    List<Pokemon> loadAllPokemons(Map<String, String> params);
}
