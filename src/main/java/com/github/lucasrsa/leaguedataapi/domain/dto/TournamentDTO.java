package com.github.lucasrsa.leaguedataapi.domain.dto;

import com.github.lucasrsa.leaguedataapi.domain.Tournament;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TournamentDTO {
    private final String tag;
    private final String name;
    private final String region;
    private final int year;
    private final int order;

    public TournamentDTO(Tournament tournament) {
        this.tag = tournament.getTag();
        this.name = tournament.getName();
        this.region = tournament.getRegion();
        this.year = tournament.getYear();
        this.order = tournament.getOrder();
    }
}
