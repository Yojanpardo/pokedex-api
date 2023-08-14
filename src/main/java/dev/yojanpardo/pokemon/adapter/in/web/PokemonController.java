package dev.yojanpardo.pokemon.adapter.in.web;

import dev.yojanpardo.pokemon.application.port.in.GetPokemonsUseCase;
import dev.yojanpardo.pokemon.domain.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final GetPokemonsUseCase getPokemonsUseCase;
    private final PokemonWebMapper mapper;

    @GetMapping
    public ResponseEntity<PokemonListResponse> getAllPokemons(@RequestParam(required = false) Map<String, String> params){
        final List<Pokemon> pokemons = Objects.nonNull(params)
                ? getPokemonsUseCase.getPokemons(params)
                : getPokemonsUseCase.getPokemons();

        return ResponseEntity.ok(mapper.pokemonListToPokemonListResponse(pokemons, params));
    }
}
