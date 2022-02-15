package com.github.lucasrsa.leaguedataapi.domain.dto;

import com.github.lucasrsa.leaguedataapi.domain.model.Team;
import com.github.lucasrsa.leaguedataapi.domain.model.Tournament;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamDTO {
    private final String tag;
    private final String name;
    private final String region;

    public TeamDTO(Team team) {
        this.tag = team.getTag();
        this.name = team.getName();
        this.region = team.getRegion();
    }
}
