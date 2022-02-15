package com.github.lucasrsa.leaguedataapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(nullable = false)
    protected String tag;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String region;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int sequence;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY)
    private Set<Team> teams;

    @OneToOne(mappedBy = "tournament", fetch = FetchType.LAZY)
    private Schedule schedule;

    private final HashMap<Team, Standing> standings = new HashMap<>();

}
