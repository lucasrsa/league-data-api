package com.github.lucasrsa.leaguedataapi.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandingTest {
    private Standing standing;

    @BeforeEach
    void setUp() {
        standing = new Standing();
    }

    @Test
    void win() {
        standing.win();
        assertEquals(1, standing.getGames());
        assertEquals(1, standing.getWins());
    }

    @Test
    void lose() {
        standing.lose();
        assertEquals(1, standing.getGames());
        assertEquals(1, standing.getLosses());
    }

    @Test
    void getWinPercentage() {
        standing.win();
        standing.lose();
        assertEquals(50., standing.getWinPercentage());
    }

    @Test
    void getWinPercentageNoGames() {
        assertEquals(0., standing.getWinPercentage());
    }

    @Test
    void getGames() {
        assertEquals(0, standing.getGames());
    }

    @Test
    void getWins() {
        assertEquals(0, standing.getWins());
    }

    @Test
    void getLosses() {
        assertEquals(0, standing.getLosses());
    }

    @Test
    void setGames() {
        int games = 10;
        standing.setGames(games);
        assertEquals(games, standing.getGames());
    }

    @Test
    void setWins() {
        int wins = 10;
        standing.setWins(wins);
        assertEquals(wins, standing.getWins());
    }

    @Test
    void setLosses() {
        int losses = 10;
        standing.setLosses(losses);
        assertEquals(losses, standing.getLosses());
    }
}