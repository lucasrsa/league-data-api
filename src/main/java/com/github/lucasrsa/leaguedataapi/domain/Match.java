package com.github.lucasrsa.leaguedataapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Match {
    @NonNull
    private final Team blueTeam;
    @NonNull
    private final Team redTeam;
    private Team winner;

    public Match(@NonNull Team blueTeam, @NonNull Team redTeam) {
        this.blueTeam = blueTeam;
        this.redTeam = redTeam;
        this.winner = null;
    }

    public Team getLoser() {
        return blueTeam.equals(winner) ? redTeam
                : redTeam.equals(winner) ? blueTeam
                : null;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
