package com.github.lucasrsa.leaguedataapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
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

    @OneToOne(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Schedule schedule;

    private HashMap<Team, Standing> standings;

    private HashMap<Team, HashMap<Team, Standing>> headToHeads;

    private void processSchedule() {
        standings = new HashMap<>();
        headToHeads = new HashMap<>();
        teams.forEach(team -> {
            standings.put(team, new Standing());
            HashMap<Team, Standing> h2h = new HashMap<>();
            teams.forEach(t -> {
                if (!team.equals(t)) {
                    h2h.put(t, new Standing());
                }
            });
            headToHeads.put(team, h2h);
        });
    }

    public void addMatch(Match match) {
        schedule.addMatch(match);
        standings = null;
        headToHeads = null;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public Standing getTeamStanding(Team team) {
        if (!teams.contains(team)) {
            throw new EntityNotFoundException();
        }
        if (standings == null) {
            processSchedule();
        }
        return standings.get(team);
    }

    public Standing getTeamHeadToHead(Team t1, Team t2) {
        if (!teams.contains(t1) || !teams.contains(t2)) {
            throw new EntityNotFoundException();
        }
        if (headToHeads == null) {
            processSchedule();
        }
        return headToHeads.get(t1).get(t2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament tournament = (Tournament) o;
        return id == tournament.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
