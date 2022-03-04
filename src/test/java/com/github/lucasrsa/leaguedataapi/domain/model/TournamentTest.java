package com.github.lucasrsa.leaguedataapi.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {
    private Tournament tournament;
    private final long id = 10L;
    private final String tag = "TAG";
    private final String name = "Name";
    private final String region = "REGION";
    private final Set<Team> teamSet = new HashSet<>();
    private final Schedule schedule = new Schedule(0, new ArrayList<>(), null);
    private final HashMap<Team, Standing> standings = new HashMap<>();
    private final HashMap<Team, HashMap<Team, Standing>> headToHeads = new HashMap<>();
    private final Match match = new Match();
    private final Team team = new Team();
    private final Team team2 = new Team();

    @BeforeEach
    void setUp() {
        tournament = new Tournament();
        team2.setId(2);
    }

    @Test
    void allArgsConstructor() {
        assertNotEquals(tournament, new Tournament(
                id,
                tag,
                name,
                region,
                teamSet,
                schedule,
                standings,
                headToHeads
        ));
    }

    @Test
    void testHashCode() {
        assertEquals(Objects.hash(tournament.getId()), tournament.hashCode());
    }

    @Test
    void addMatch() {
        tournament.setSchedule(schedule);
        tournament.addMatch(match);
        assertEquals(1, tournament.getSchedule().getMatches().size());
    }

    @Test
    void addMatchNoSchedule() {
        assertThrows(NullPointerException.class, () -> tournament.addMatch(match));
    }

    @Test
    void getTeamStanding() {
        tournament.addTeam(team);
        assertEquals(0, tournament.getTeamStanding(team).getGames());
    }

    @Test
    void getTeamStandingNoTeam() {
        assertThrows(EntityNotFoundException.class, () -> tournament.getTeamStanding(team));
    }

    @Test
    void getTeamHeadToHead() {
        tournament.addTeam(team);
        tournament.addTeam(team2);
        assertEquals(0, tournament.getTeamHeadToHead(team, team2).getGames());
    }

    @Test
    void getTeamHeadToHeadNoTeam() {
        assertThrows(EntityNotFoundException.class, () -> tournament.getTeamHeadToHead(team, team2));
    }

    @Test
    void getTeamHeadToHeadNoTeam1() {
        tournament.addTeam(team2);
        assertThrows(EntityNotFoundException.class, () -> tournament.getTeamHeadToHead(team, team2));
    }

    @Test
    void getTeamHeadToHeadNoTeam2() {
        tournament.addTeam(team);
        assertThrows(EntityNotFoundException.class, () -> tournament.getTeamHeadToHead(team, team2));
    }

    @Test
    void getId() {
        assertEquals(0L, tournament.getId());
    }

    @Test
    void getTag() {
        assertNull(tournament.getTag());
    }

    @Test
    void getName() {
        assertNull(tournament.getName());
    }

    @Test
    void getRegion() {
        assertNull(tournament.getRegion());
    }

    @Test
    void getTeams() {
        assertEquals(0, tournament.getTeams().size());
    }

    @Test
    void getSchedule() {
        assertNull(tournament.getSchedule());
    }

    @Test
    void getStandings() {
        assertNull(tournament.getStandings());
    }

    @Test
    void getHeadToHeads() {
        assertNull(tournament.getHeadToHeads());
    }

    @Test
    void setId() {
        tournament.setId(id);
        assertEquals(id, tournament.getId());
    }

    @Test
    void setTag() {
        tournament.setTag(tag);
        assertEquals(tag, tournament.getTag());
    }

    @Test
    void setName() {
        tournament.setName(name);
        assertEquals(name, tournament.getName());
    }

    @Test
    void setRegion() {
        tournament.setRegion(region);
        assertEquals(region, tournament.getRegion());
    }

    @Test
    void setTeams() {
        tournament.setTeams(teamSet);
        assertEquals(teamSet, tournament.getTeams());
    }

    @Test
    void setSchedule() {
        tournament.setSchedule(schedule);
        assertEquals(schedule, tournament.getSchedule());
    }

    @Test
    void setStandings() {
        tournament.setStandings(standings);
        assertEquals(standings, tournament.getStandings());
    }

    @Test
    void setHeadToHeads() {
        tournament.setHeadToHeads(headToHeads);
        assertEquals(headToHeads, tournament.getHeadToHeads());
    }
}