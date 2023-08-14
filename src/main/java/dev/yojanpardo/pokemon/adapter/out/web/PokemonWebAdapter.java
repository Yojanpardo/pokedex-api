package dev.yojanpardo.pokemon.adapter.out.web;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import dev.yojanpardo.common.http.HttpCustomClient;
import dev.yojanpardo.configuration.PokemonUrlConfiguration;
import dev.yojanpardo.pokemon.application.port.out.LoadPokemonPort;
import dev.yojanpardo.pokemon.domain.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PokemonWebAdapter implements LoadPokemonPort {

    private static final String GET = "GET";

    private final HttpCustomClient http;
    private final PokemonUrlConfiguration pokemonUrlConfiguration;
    private final PokemonMapper pokemonMapper;

    @Override
    public List<Pokemon> loadAllPokemons() {
        return loadAllPokemons(Map.of("limit", "20", "offset", "20"));
    }

    @Override
    public List<Pokemon> loadAllPokemons(final Map<String, String> params) {
        final String url = buildHttpUrl(params);
        final Request request = new Request. Builder()
                .url(url)
                .method(GET, null)
                .build();

        return http.executeRequest(request, PokemonListResponse.class)
                .getResults()
                .stream()
                .map(pokemonMapper::webResponseToDomain)
                .collect(Collectors.toList());
    }

    private String buildHttpUrl(final Map<String, String> params) {
        final HttpUrl.Builder urlBuilder = HttpUrl.parse(pokemonUrlConfiguration.getPokeApiUrl()).newBuilder();
        params.forEach(urlBuilder::addQueryParameter);
        return urlBuilder.build().toString();
    }
}
