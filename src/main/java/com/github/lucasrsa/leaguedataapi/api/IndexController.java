package com.github.lucasrsa.leaguedataapi.api;

import com.github.lucasrsa.leaguedataapi.domain.DataService;
import com.github.lucasrsa.leaguedataapi.domain.dto.StandingDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TeamDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class IndexController {

    @Autowired
    private final DataService dataService;

    @GetMapping(path = {"tournament", "tournaments"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentDTO> getTournamentList() {
        return dataService.getTournamentList();
    }

    @GetMapping(path = {"tournament", "tournaments"}, params = "year", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentDTO> getTournamentList(@RequestParam int year) {
        return dataService.getTournamentList(year);
    }

    @GetMapping(path = {"tournament", "tournaments"}, params = "tag", produces = MediaType.APPLICATION_JSON_VALUE)
    public TournamentDTO getTournament(@RequestParam String tag) {
        return dataService.getTournament(tag);
    }

    @GetMapping(path = {"team", "teams"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeamDTO> getTeamList() {
        return dataService.getTeamList();
    }

    @GetMapping(path = {"team", "teams"}, params = "tag", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeamDTO> getTeamList(@RequestParam String tag) {
        return dataService.getTeamList(tag);
    }

    @GetMapping(path = {"team", "teams"}, params = {"tag", "region"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamDTO getTeam(@RequestParam String tag, @RequestParam String region) {
        return dataService.getTeam(tag, region);
    }

    @GetMapping(path = {"standing", "standings"}, params = {"team"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public StandingDTO getTeamStanding(@RequestParam String team) {
        return dataService.getTeamStanding(team);
    }

    @GetMapping(path = {"standing", "standings"}, params = {"team", "region"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public StandingDTO getTeamStanding(@RequestParam String team, @RequestParam String region) {
        return dataService.getTeamStanding(team, region);
    }

}
