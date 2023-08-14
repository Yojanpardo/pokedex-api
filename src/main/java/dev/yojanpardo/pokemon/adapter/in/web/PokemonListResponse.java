package dev.yojanpardo.pokemon.adapter.in.web;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PokemonListResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<Pokemon> results;

    @Data
    @Builder
    public static class Pokemon {
        private String name;
        private Integer id;
        private String defaultImg;
    }
}
