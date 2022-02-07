package com.github.lucasrsa.leaguedataapi.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TournamentTest {
    private final Tournament tournamentA1 = new Tournament("A", "Tournament A1", "Region 1", 2022, 1);
    private final Tournament tournamentA2 = new Tournament("A", "Tournament A2", "Region 2", 2022, 1);
    private final Tournament tournamentB1 = new Tournament("B", "Tournament B1", "Region 1", 2022, 1);
    private final Tournament tournamentB2 = new Tournament("B", "Tournament B2", "Region 2", 2022, 1);
    private final Tournament tournamentC1 = new Tournament("C", "Tournament C1", "Region 1", 2022, 2);
    private final Tournament tournamentC2 = new Tournament("C", "Tournament C2", "Region 2", 2023, 1);

    @Test
    public void sameTagsSameRegionTest() {
        Assertions.assertEquals(tournamentA1, new Tournament("A", "Different Name", "Region 1", 2022, 1));
    }

    @Test
    public void differentTagsDifferentRegionTest() {
        Assertions.assertNotEquals(tournamentA1, tournamentB2);
    }

    @Test
    public void differentTagsSameRegionTest() {
        Assertions.assertNotEquals(tournamentA1, tournamentB1);
    }

    @Test
    public void sameTagsDifferentRegionTest() {
        Assertions.assertNotEquals(tournamentA1, tournamentA2);
    }

    @Test
    public void hashCodeTest() {
        Assertions.assertEquals(tournamentA1.hashCode(), new Tournament("A", "Different Name", "Region 1", 2022, 1).hashCode());
    }

}