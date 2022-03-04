package com.github.lucasrsa.leaguedataapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Match> matches = new ArrayList<>();

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Tournament tournament;

    private final Calendar calendar = new GregorianCalendar();

    public void addMatch(Match match) {
        matches.add(match);
    }

    public List<Match> getMatches(int year) {
        Date start;
        Date end;
        try {
            start = new SimpleDateFormat("yyyy").parse(String.valueOf(year));
            end = new SimpleDateFormat("yyyy").parse(String.valueOf(year + 1));
        } catch (ParseException e) {
            return List.of();
        }
        return matches.stream().filter(match -> match.getDate().after(start) && match.getDate().before(end)).collect(Collectors.toList());
    }
}
