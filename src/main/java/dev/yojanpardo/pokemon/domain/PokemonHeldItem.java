package dev.yojanpardo.pokemon.domain;

import lombok.Data;

import java.util.List;

@Data
public class PokemonHeldItem {
    private Item item;
    private List<VersionDetail> versionDetail;

    @Data
    public static class VersionDetail {
        private Integer rarity;
        private Item version;
    }
}
