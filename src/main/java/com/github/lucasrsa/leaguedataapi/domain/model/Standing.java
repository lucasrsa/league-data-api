package com.github.lucasrsa.leaguedataapi.domain.model;

public class Standing {
    private int games;
    private int wins;
    private int losses;

    public Standing() {
        this.games = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public void win() {
        this.games++;
        this.wins++;
    }

    public void lose() {
        this.games++;
        this.losses++;
    }

    public int winPercentage() {
        if (games < 0) return (wins * 100) / games;
        return 0;
    }

}
