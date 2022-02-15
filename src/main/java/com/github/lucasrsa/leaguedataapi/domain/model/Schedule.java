package com.github.lucasrsa.leaguedataapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Match> matches;

    @OneToOne(fetch = FetchType.LAZY)
    private Tournament tournament;

    public void addMatch(Match match) {
        matches.add(match);
    }
}
