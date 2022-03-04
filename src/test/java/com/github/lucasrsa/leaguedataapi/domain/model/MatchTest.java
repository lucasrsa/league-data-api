package com.github.lucasrsa.leaguedataapi.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    private Match match;
    private final long id = 10L;
    private final Date date = new Date();
    private final Team team1 = new Team();
    private final Team team2 = new Team();

    @BeforeEach
    void setUp() {
        match = new Match();
        team2.setId(team1.getId() + 1);
    }

    @Test
    void allArgsConstructor() {
        assertNotEquals(match, new Match(
                id,
                date,
                team1,
                team2,
                team1
        ));
    }

    @Test
    void getLoserNoWinner() {
        match.setBlueTeam(team1);
        match.setRedTeam(team2);
        assertNull(match.getLoser());
    }

    @Test
    void getLoserWinnerTeam1() {
        match.setBlueTeam(team1);
        match.setRedTeam(team2);
        match.setWinner(team1);
        assertEquals(team2, match.getLoser());
    }

    @Test
    void getLoserWinnerTeam2() {
        match.setBlueTeam(team1);
        match.setRedTeam(team2);
        match.setWinner(team2);
        assertEquals(team1, match.getLoser());
    }

    @Test
    void setWinner() {
        match.setBlueTeam(team1);
        match.setRedTeam(team2);
        match.setWinner(team1);
        assertEquals(team1, match.getWinner());
    }

    @Test
    void getId() {
        assertEquals(0L, match.getId());
    }

    @Test
    void getDate() {
        assertNull(match.getDate());
    }

    @Test
    void getBlueTeam() {
        assertNull(match.getBlueTeam());
    }

    @Test
    void getRedTeam() {
        assertNull(match.getRedTeam());
    }

    @Test
    void getWinner() {
        assertNull(match.getWinner());
    }

    @Test
    void setId() {
        match.setId(id);
        assertEquals(id, match.getId());
    }

    @Test
    void setDate() {
        match.setDate(date);
        assertEquals(date, match.getDate());
    }

    @Test
    void setBlueTeam() {
        match.setBlueTeam(team1);
        assertEquals(team1, match.getBlueTeam());
    }

    @Test
    void setRedTeam() {
        match.setRedTeam(team2);
        assertEquals(team2, match.getRedTeam());
    }
}