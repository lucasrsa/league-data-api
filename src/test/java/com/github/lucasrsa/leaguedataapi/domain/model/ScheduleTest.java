package com.github.lucasrsa.leaguedataapi.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    private Schedule schedule;
    private final long id = 10L;
    private final List<Match> matches = new ArrayList<>();
    private final Tournament tournament = new Tournament();
    private final Match match = new Match();

    @BeforeEach
    void setUp() {
        schedule = new Schedule();
    }

    @Test
    void allArgsConstructor() {
        assertNotEquals(schedule, new Schedule(
                id,
                matches,
                tournament
        ));
    }

    @Test
    void addMatch() {
        schedule.addMatch(match);
        assertEquals(1, schedule.getMatches().size());
    }

    @Test
    void getMatches() {
        assertNotNull(schedule.getMatches());
    }

    @Test
    void getMatchesByYear() {
        assertNotNull(schedule.getMatches(2022));
    }

    @Test
    void getId() {
        assertEquals(0L, schedule.getId());
    }

    @Test
    void getTournament() {
        assertNull(schedule.getTournament());
    }

    @Test
    void getCalendar() {
        assertNotNull(schedule.getCalendar());
    }

    @Test
    void setId() {
        schedule.setId(id);
        assertEquals(id, schedule.getId());
    }

    @Test
    void setMatches() {
        schedule.setMatches(matches);
        assertEquals(matches, schedule.getMatches());
    }

    @Test
    void setTournament() {
        schedule.setTournament(tournament);
        assertEquals(tournament, schedule.getTournament());
    }
}