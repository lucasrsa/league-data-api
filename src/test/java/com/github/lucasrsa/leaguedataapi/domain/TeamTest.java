package com.github.lucasrsa.leaguedataapi.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TeamTest {
    private final Team teamA1 = new Team("A", "Team A1", "Region 1");
    private final Team teamA2 = new Team("A", "Team A2", "Region 2");
    private final Team teamB1 = new Team("B", "Team B1", "Region 1");
    private final Team teamB2 = new Team("B", "Team B2", "Region 2");

    @Test
    public void sameTagsSameRegionTest() {
        Assertions.assertEquals(teamA1, new Team("A", "Different Name", "Region 1"));
    }

    @Test
    public void differentTagsDifferentRegionTest() {
        Assertions.assertNotEquals(teamA1, teamB2);
    }

    @Test
    public void differentTagsSameRegionTest() {
        Assertions.assertNotEquals(teamA1, teamB1);
    }

    @Test
    public void sameTagsDifferentRegionTest() {
        Assertions.assertNotEquals(teamA1, teamA2);
    }

    @Test
    public void hashCodeTest() {
        Assertions.assertEquals(teamA1.hashCode(), new Team("A", "Different Name", "Region 1").hashCode());
    }

}