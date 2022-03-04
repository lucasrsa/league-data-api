package com.github.lucasrsa.leaguedataapi.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    private Team team;
    private final long id = 10L;
    private final String tag = "TAG";
    private final String name = "Name";
    private final Tournament tournament = new Tournament();

    @BeforeEach
    void setUp() {
        team = new Team();
    }

    @Test
    void allArgsConstructor() {
        assertNotEquals(team, new Team(
                id,
                tag,
                name,
                tournament
        ));
    }

    @Test
    void testHashCode() {
        assertEquals(Objects.hash(team.getId()), team.hashCode());
    }

    @Test
    void getId() {
        assertEquals(0L, team.getId());
    }

    @Test
    void getTag() {
        assertNull(team.getTag());
    }

    @Test
    void getName() {
        assertNull(team.getName());
    }

    @Test
    void getTournament() {
        assertNull(team.getTournament());
    }

    @Test
    void setId() {
        team.setId(id);
        assertEquals(id, team.getId());
    }

    @Test
    void setTag() {
        team.setTag(tag);
        assertEquals(tag, team.getTag());
    }

    @Test
    void setName() {
        team.setName(name);
        assertEquals(name, team.getName());
    }

    @Test
    void setTournament() {
        team.setTournament(tournament);
        assertEquals(tournament, team.getTournament());
    }
}