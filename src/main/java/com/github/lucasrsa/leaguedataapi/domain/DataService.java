package com.github.lucasrsa.leaguedataapi.domain;

import com.github.lucasrsa.leaguedataapi.db.MatchRepository;
import com.github.lucasrsa.leaguedataapi.db.ScheduleRepository;
import com.github.lucasrsa.leaguedataapi.db.TeamRepository;
import com.github.lucasrsa.leaguedataapi.db.TournamentRepository;
import com.github.lucasrsa.leaguedataapi.domain.dto.StandingDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TeamDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
import com.github.lucasrsa.leaguedataapi.domain.model.Standing;
import com.github.lucasrsa.leaguedataapi.domain.model.Team;
import com.github.lucasrsa.leaguedataapi.domain.model.Tournament;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataService {

    @Autowired
    private final TournamentRepository tournamentRepository;

    @Autowired
    private final TeamRepository teamRepository;

    @Autowired
    private final MatchRepository matchRepository;

    @Autowired
    private final ScheduleRepository scheduleRepository;

    public List<TournamentDTO> getTournamentList() {
        return tournamentRepository.findAll().stream().map(TournamentDTO::new).collect(Collectors.toList());
    }

    public List<TournamentDTO> getTournamentList(int year) {
        return tournamentRepository.findByYear(year).stream().map(TournamentDTO::new).collect(Collectors.toList());
    }

    public TournamentDTO getTournament(String tag) {
        List<Tournament> tournamentList = tournamentRepository.findByTag(tag);
        tournamentList.sort(Tournament::compareTo);
        return !tournamentList.isEmpty() ? new TournamentDTO(tournamentList.get(tournamentList.size() - 1)) : null;
    }

    public TournamentDTO getTournament(String tag, int year) {
        List<Tournament> tournamentList = tournamentRepository.findByTagAndYear(tag, year);
        tournamentList.sort(Tournament::compareTo);
        return !tournamentList.isEmpty() ? new TournamentDTO(tournamentList.get(tournamentList.size() - 1)) : null;
    }

    public List<TournamentDTO> getTournamentList(String tag) {
        return tournamentRepository.findByTag(tag).stream().map(TournamentDTO::new).collect(Collectors.toList());
    }

    public List<TournamentDTO> getTournamentList(String tag, int year) {
        return tournamentRepository.findByTagAndYear(tag, year).stream().map(TournamentDTO::new).collect(Collectors.toList());
    }

    public List<TeamDTO> getTeamList() {
        return teamRepository.findAll().stream().map(TeamDTO::new).collect(Collectors.toList());
    }

    public List<TeamDTO> getTeamList(String tag) {
        return teamRepository.findByTag(tag).stream().map(TeamDTO::new).collect(Collectors.toList());
    }

    public TeamDTO getTeam(String tag, String region) {
        return new TeamDTO(teamRepository.getFirstByTagAndRegion(tag, region));
    }

    public StandingDTO getTeamStanding(String tag) {
        Team team = teamRepository.getFirstByTag(tag);
        return team != null ? new StandingDTO(team.getTournament().getTeamStanding(team)) : null;
    }

    public StandingDTO getTeamStanding(String tag, String region) {
        Team team = teamRepository.getFirstByTagAndRegion(tag, region);
        return team != null ? new StandingDTO(team.getTournament().getTeamStanding(team)) : null;
    }

}
