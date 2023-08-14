package dev.yojanpardo.pokemon.adapter.out.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonListResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<PokemonWeb> results;
}
