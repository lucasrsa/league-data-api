package com.github.lucasrsa.leaguedataapi.domain.model;

import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String tag;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String region;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Team> teams = new HashSet<>();

    private HashMap<Team, Standing> standings;

    private void processStandings() {
        standings = new HashMap<>();
    }

    public Standing getTeamStanding(Team team) {
        if (standings == null) {
            processStandings();
        }
        return standings.get(team);
    }

}
