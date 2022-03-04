package com.github.lucasrsa.leaguedataapi.domain.dto;

import com.github.lucasrsa.leaguedataapi.domain.model.Standing;
import com.github.lucasrsa.leaguedataapi.domain.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class StandingDTO {
    private final int games;
    private final int wins;
    private final int losses;
    private final double winPercentage;

    public StandingDTO(Standing standing) {
        this.games = standing.getGames();
        this.wins = standing.getWins();
        this.losses = standing.getLosses();
        this.winPercentage = standing.getWinPercentage();
    }
}
