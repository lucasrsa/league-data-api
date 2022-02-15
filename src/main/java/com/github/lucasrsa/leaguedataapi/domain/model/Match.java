package com.github.lucasrsa.leaguedataapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Team blueTeam;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Team redTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team winner;

    public Team getLoser() {
        return blueTeam.equals(winner) ? redTeam
                : redTeam.equals(winner) ? blueTeam
                : null;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
