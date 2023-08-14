package dev.yojanpardo.pokemon.adapter.out.web;

import dev.yojanpardo.pokemon.domain.Pokemon;
import org.springframework.stereotype.Component;

@Component
public class PokemonMapperImpl implements PokemonMapper {


    @Override
    public Pokemon webResponseToDomain(PokemonWeb pokemonWeb) {
        final String[] urlChunks = pokemonWeb.getUrl().split("/");
        final Integer pokemonId = Integer.parseInt(urlChunks[urlChunks.length - 1]);
        return Pokemon.builder()
                .id(pokemonId)
                .name(pokemonWeb.getName())
                .build();
    }
}
