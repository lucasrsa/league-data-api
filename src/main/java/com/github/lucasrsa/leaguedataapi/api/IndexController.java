package com.github.lucasrsa.leaguedataapi.api;

import com.github.lucasrsa.leaguedataapi.domain.DataService;
import com.github.lucasrsa.leaguedataapi.domain.Team;
import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class IndexController {
    @Autowired
    DataService dataService;

    @GetMapping(value = {"/tournament", "/tournaments"})
    public List<TournamentDTO> getTournament() {
        return dataService.getTournaments();
    }

    @GetMapping(value = {"/team", "/teams"})
    public List<Team> getTeams() {
        return dataService.getTeams();
    }

    @GetMapping("/team/{tag}")
    public Team getTeam(@PathVariable("tag") String tag) {
        return dataService.getTeam(tag);
    }

}
