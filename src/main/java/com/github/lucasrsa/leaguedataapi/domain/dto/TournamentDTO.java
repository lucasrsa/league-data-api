package com.github.lucasrsa.leaguedataapi.domain.dto;

import com.github.lucasrsa.leaguedataapi.domain.model.Tournament;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class TournamentDTO {
    private final Long id;
    private final String tag;
    private final String name;
    private final String region;
    private final Set<TeamDTO> teams;

    public TournamentDTO(Tournament tournament) {
        this.id = tournament.getId();
        this.tag = tournament.getTag();
        this.name = tournament.getName();
        this.region = tournament.getRegion();
        this.teams = tournament.getTeams().stream().map(TeamDTO::new).collect(Collectors.toSet());
    }
}
