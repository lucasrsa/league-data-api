package com.github.lucasrsa.leaguedataapi.api;

import com.github.lucasrsa.leaguedataapi.db.TeamRepository;
import com.github.lucasrsa.leaguedataapi.db.TournamentRepository;
import com.github.lucasrsa.leaguedataapi.domain.DataService;
import com.github.lucasrsa.leaguedataapi.domain.dto.StandingDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TeamDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
import com.github.lucasrsa.leaguedataapi.domain.model.Standing;
import com.github.lucasrsa.leaguedataapi.domain.model.Team;
import com.github.lucasrsa.leaguedataapi.domain.model.Tournament;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class IndexController {

    @Autowired
    private final DataService dataService;

    @Autowired
    private final TournamentRepository tournamentRepository;

    @Autowired
    private final TeamRepository teamRepository;

    @PostMapping(path = "test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String test(@RequestBody Team team) {
        System.out.println("hit");
        return "ok";
    }

    @GetMapping(path = "tournaments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentDTO> getTournamentList() {
        return dataService.getTournamentList();
    }

    @GetMapping(path = "tournaments", params = "region", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TournamentDTO> getTournamentList(@RequestParam String region) {
        return dataService.getTournamentList(region);
    }

    @GetMapping(path = "tournament", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TournamentDTO> getTournament(@RequestParam long id) {
        TournamentDTO tournament = dataService.getTournament(id);
        return tournament != null ? ResponseEntity.ok(tournament) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "tournament", params = "tag", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TournamentDTO> getTournament(@RequestParam String tag) {
        TournamentDTO tournament = dataService.getTournament(tag);
        return tournament != null ? ResponseEntity.ok(tournament) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "tournament", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TournamentDTO> postTournament(@RequestBody TournamentDTO tournamentDTO) {
        TournamentDTO tournament = dataService.updateTournament(tournamentDTO);
        return tournament != null ? ResponseEntity.ok(tournament) : ResponseEntity.internalServerError().build();
    }

    @GetMapping(path = "teams", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeamDTO> getTeamList() {
        return dataService.getTeamList();
    }

    @GetMapping(path = "teams", params = "tournament", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TeamDTO> getTeamList(@RequestParam long tournament) {
        return dataService.getTeamList(tournament);
    }

    @GetMapping(path = "team", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamDTO> getTeam(@RequestParam long id) {
        TeamDTO team = dataService.getTeam(id);
        return team != null ? ResponseEntity.ok(team) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "team", params = "tag", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamDTO> getTeam(@RequestParam String tag) {
        TeamDTO team = dataService.getTeam(tag);
        return team != null ? ResponseEntity.ok(team) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "team", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeamDTO> postTournament(@RequestBody TeamDTO teamDTO) {
        TeamDTO team = dataService.updateTeam(teamDTO);
        return team != null ? ResponseEntity.ok(team) : ResponseEntity.internalServerError().build();
    }

//    @GetMapping(path = {"standing", "standings"}, params = {"team"}, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<StandingDTO> getTeamStanding(@RequestParam String team) {
//        StandingDTO standing = dataService.getTeamStanding(team);
//        return standing != null ? ResponseEntity.ok(standing) : ResponseEntity.notFound().build();
//    }
//
//    @GetMapping(path = {"standing", "standings"}, params = {"team", "region"}, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<StandingDTO> getTeamStanding(@RequestParam String team, @RequestParam String region) {
//        StandingDTO standing = dataService.getTeamStanding(team, region);
//        return standing != null ? ResponseEntity.ok(standing) : ResponseEntity.notFound().build();
//    }

}
