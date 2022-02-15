package com.github.lucasrsa.leaguedataapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashMap;
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

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int sequence = 0;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY)
    private Set<Team> teams;

    @OneToOne(mappedBy = "tournament", fetch = FetchType.LAZY)
    private Schedule schedule;

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

    public int compareTo(Object o) {
        if (this == o) return 0;
        if (this.equals(o)) return 0;
        Tournament that = (Tournament) o;
        if (this.year != that.getYear()) return Integer.compare(this.year, that.getYear());
        return Integer.compare(this.sequence, that.getSequence());
    }

}
