package com.github.lucasrsa.leaguedataapi.api;

import com.github.lucasrsa.leaguedataapi.domain.DataService;
import com.github.lucasrsa.leaguedataapi.domain.dto.StandingDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TeamDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TournamentDTO> getTournament(@RequestParam String tag) {
        TournamentDTO tournament = dataService.getTournament(tag);
        return tournament != null ? ResponseEntity.ok(tournament) : ResponseEntity.notFound().build();
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
    public ResponseEntity<TeamDTO> getTeam(@RequestParam String tag, @RequestParam String region) {
        TeamDTO team = dataService.getTeam(tag, region);
        return team != null ? ResponseEntity.ok(team) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = {"standing", "standings"}, params = {"team"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandingDTO> getTeamStanding(@RequestParam String team) {
        StandingDTO standing = dataService.getTeamStanding(team);
        return standing != null ? ResponseEntity.ok(standing) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = {"standing", "standings"}, params = {"team", "region"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandingDTO> getTeamStanding(@RequestParam String team, @RequestParam String region) {
        StandingDTO standing = dataService.getTeamStanding(team, region);
        return standing != null ? ResponseEntity.ok(standing) : ResponseEntity.notFound().build();
    }

}
