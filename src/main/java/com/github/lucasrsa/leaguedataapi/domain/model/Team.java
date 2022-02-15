package com.github.lucasrsa.leaguedataapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(nullable = false)
    protected String tag;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String region;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tournament tournament;

}
