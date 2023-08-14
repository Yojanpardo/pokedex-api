package dev.yojanpardo.pokemon.application.domain.service;

import dev.yojanpardo.pokemon.application.port.in.GetPokemonsUseCase;
import dev.yojanpardo.pokemon.application.port.out.LoadPokemonPort;
import dev.yojanpardo.pokemon.domain.Pokemon;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PokemonService implements GetPokemonsUseCase {
    private final LoadPokemonPort loadPokemonPort;

    @Override
    public List<Pokemon> getPokemons() {
        return loadPokemonPort.loadAllPokemons();
    }

    @Override
    public List<Pokemon> getPokemons(Map<String, String> params) {
        return loadPokemonPort.loadAllPokemons(params);
    }
}
