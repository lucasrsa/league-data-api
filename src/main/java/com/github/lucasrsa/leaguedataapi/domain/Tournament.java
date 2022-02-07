package com.github.lucasrsa.leaguedataapi.domain;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Objects;

@Getter
public class Tournament extends Tagged {
    private final int year;
    private final int order;
    private final HashMap<String, Team> teams;
    private final Schedule schedule;
    private final HashMap<String, Standing> standings;

    public Tournament(@NonNull String tag, @NonNull String name, @NonNull String region, int year, int order) {
        super(tag, name, region);
        this.year = year;
        this.order = order;
        this.teams = new HashMap<>();
        this.schedule = new Schedule();
        this.standings = new HashMap<>();
    }

    public void addTeam(String tag, String name) {
        addTeam(new Team(tag, name, region));
    }

    public void addTeam(Team team) {
        this.teams.put(team.getTag(), team);
        this.standings.put(team.getTag(), new Standing());
    }

    public Team getTeam(String tag) {
        return teams.get(tag.toUpperCase());
    }

    public void addMatch(Match match) {
        schedule.addMatch(match);
        if (match.getWinner() != null) {
            standings.get(match.getWinner().getTag()).win();
            standings.get(match.getLoser().getTag()).lose();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tournament that = (Tournament) o;
        return year == that.year && order == that.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), year, order);
    }
}
