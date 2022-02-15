package com.github.lucasrsa.leaguedataapi.api;

import com.github.lucasrsa.leaguedataapi.domain.DataService;
import com.github.lucasrsa.leaguedataapi.domain.dto.TeamDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class IndexController {

    @Autowired
    private final DataService dataService;

    @GetMapping(path = {"tournament", "tournaments"})
    public List<TournamentDTO> getTournaments() {
        return dataService.getTournaments();
    }

    @GetMapping(path = {"tournament", "tournaments"}, params = "year")
    public List<TournamentDTO> getTournaments(@RequestParam Long year) {
        return dataService.getTournaments(year);
    }

    @GetMapping(path = {"tournament", "tournaments"}, params = "tag")
    public TournamentDTO getTournament(@RequestParam String tag) {
        return dataService.getTournament(tag);
    }

    @GetMapping(path = {"team", "teams"})
    public List<TeamDTO> getTeams() {
        return dataService.getTeams();
    }

    @GetMapping(path = {"team", "teams"}, params = "tag")
    public List<TeamDTO> getTeams(@RequestParam String tag) {
        return dataService.getTeams(tag);
    }

    @GetMapping(path = {"team", "teams"}, params = {"tag", "region"})
    public TeamDTO getTeam(@RequestParam String tag, @RequestParam String region) {
        return dataService.getTeam(tag, region);
    }

}
