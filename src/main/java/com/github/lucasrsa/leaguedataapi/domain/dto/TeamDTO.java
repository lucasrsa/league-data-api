package com.github.lucasrsa.leaguedataapi.domain.dto;

import com.github.lucasrsa.leaguedataapi.domain.model.Team;
import com.github.lucasrsa.leaguedataapi.domain.model.Tournament;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamDTO {
    private final Long id;
    private final String tag;
    private final String name;
    private final Long tournamentId;

    public TeamDTO(Team team) {
        this.id = team.getId();
        this.tag = team.getTag();
        this.name = team.getName();
        this.tournamentId = team.getTournament().getId();
    }
}
