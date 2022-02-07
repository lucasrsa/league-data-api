package com.github.lucasrsa.leaguedataapi.domain;

import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
import com.github.lucasrsa.leaguedataapi.utils.FileUtils;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {
    private List<Tournament> tournaments;

    public DataService() {
        this.tournaments = new ArrayList<>();
        loadData();
    }

    @SneakyThrows
    private void loadData() {
        tournaments = FileUtils.loadTournaments();
        tournaments.forEach(t -> {
            try {
                FileUtils.loadTeams(t);
                FileUtils.loadSchedule(t);
            } catch (IOException ignored) {
            }
        });
    }

    public List<TournamentDTO> getTournaments() {
        return tournaments.stream().map(TournamentDTO::new).collect(Collectors.toList());
    }

    public List<Team> getTeams() {
        return tournaments.stream().flatMap(t -> t.getTeams().values().stream()).collect(Collectors.toList());
    }

    public Team getTeam(String tag) {
        for (Tournament t : tournaments) {
            Team team = t.getTeam(tag);
            if (team != null)
                return team;
        }
        return null;
    }

}
