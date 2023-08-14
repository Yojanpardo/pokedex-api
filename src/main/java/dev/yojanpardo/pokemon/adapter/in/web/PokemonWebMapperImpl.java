package dev.yojanpardo.pokemon.adapter.in.web;

import dev.yojanpardo.pokemon.domain.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PokemonWebMapperImpl implements PokemonWebMapper {

    @Value("${pokeapi.img-artwork-url}")
    private String imgArtworkUrl;

    @Value("${pokeapi.navigation-url}")
    private String navigationUrl;

    @Override
    public PokemonListResponse.Pokemon pokemonToWebResponse(Pokemon pokemon) {
        return PokemonListResponse.Pokemon.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .defaultImg(imgArtworkUrl.formatted(pokemon.getId()))
                .build();
    }

    @Override
    public PokemonListResponse pokemonListToPokemonListResponse(List<Pokemon> pokemons, Map<String, String> params) {

        return PokemonListResponse.builder()
                .results(pokemons.stream()
                        .map(this::pokemonToWebResponse)
                        .collect(Collectors.toList()))
                .count(pokemons.size())
                .next(buildNext(params))
                .previous(buildPrevious(params))
                .build();
    }


    private String buildPrevious(Map<String, String> params) {
        final int offset = Integer.parseInt(params.get("offset")) - Integer.parseInt(params.get("limit"));
        return offset < 0
                ? null
                : navigationUrl.formatted(params.get("limit"), offset);
    }

    private String buildNext(Map<String, String> params) {
        final Integer offset = Integer.parseInt(params.get("offset")) + Integer.parseInt(params.get("limit"));
        return navigationUrl.formatted(params.get("limit"), offset);
    }
}
