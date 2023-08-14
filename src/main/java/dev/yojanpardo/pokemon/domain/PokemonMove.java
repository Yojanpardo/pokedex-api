package dev.yojanpardo.pokemon.domain;

import lombok.Data;

import java.util.List;

@Data
public class PokemonMove {
    private Item move;
    private List<VersionGroupDetail> versionGroupDetails;

    @Data
    public static class VersionGroupDetail {
        private Integer levelLearnedAt;
        private Item versionGroup;
        private Item moveLearnMethod;
    }
}
