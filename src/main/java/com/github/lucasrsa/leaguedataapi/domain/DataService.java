package com.github.lucasrsa.leaguedataapi.domain;

import com.github.lucasrsa.leaguedataapi.db.MatchRepository;
import com.github.lucasrsa.leaguedataapi.db.ScheduleRepository;
import com.github.lucasrsa.leaguedataapi.db.TeamRepository;
import com.github.lucasrsa.leaguedataapi.db.TournamentRepository;
import com.github.lucasrsa.leaguedataapi.domain.dto.TeamDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
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

    public List<TournamentDTO> getTournamentList(String region) {
        return tournamentRepository.findByRegion(region).stream().map(TournamentDTO::new).collect(Collectors.toList());
    }

    public TournamentDTO getTournament(long id) {
        return new TournamentDTO(tournamentRepository.getById(id));
    }

    public TournamentDTO getTournament(String tag) {
        return new TournamentDTO(tournamentRepository.getFirstByTag(tag));
    }

    public TournamentDTO updateTournament(TournamentDTO tournamentDTO) {
        Tournament tournament;
        if (tournamentDTO.getId() != null) {
            tournament = tournamentRepository.getById(tournamentDTO.getId());
        } else {
            tournament = new Tournament();
        }
        if (tournamentDTO.getTag() != null) {
            tournament.setTag(tournamentDTO.getTag());
        }
        if (tournamentDTO.getName() != null) {
            tournament.setName(tournamentDTO.getName());
        }
        if (tournamentDTO.getRegion() != null) {
            tournament.setRegion(tournamentDTO.getRegion());
        }
        if (tournamentDTO.getTeams() != null) {
            tournament.setTeams(tournamentDTO.getTeams().stream().map(teamRepository::getById).collect(Collectors.toSet()));
        }
        return new TournamentDTO(tournamentRepository.save(tournament));
    }

    public List<TeamDTO> getTeamList() {
        return teamRepository.findAll().stream().map(TeamDTO::new).collect(Collectors.toList());
    }

    public List<TeamDTO> getTeamList(long tournament) {
        return teamRepository.findByTournament(tournamentRepository.getById(tournament)).stream().map(TeamDTO::new).collect(Collectors.toList());
    }

    public TeamDTO getTeam(long id) {
        Team team = teamRepository.getById(id);
        return team != null ? new TeamDTO(team) : null;
    }

    public TeamDTO getTeam(String tag) {
        Team team = teamRepository.getFirstByTag(tag);
        return team != null ? new TeamDTO(team) : null;
    }

    public TeamDTO updateTeam(TeamDTO teamDTO) {
        if (teamDTO.getTournamentId() == null) {
            return null;
        }
        Team team;
        Tournament tournament = tournamentRepository.getById(teamDTO.getTournamentId());
        if (teamDTO.getId() != null) {
            team = teamRepository.getById(teamDTO.getId());
        }
        return teamDTO;
    }

//    public StandingDTO getTeamStanding(String tag) {
//        Team team = teamRepository.getFirstByTag(tag);
//        return team != null ? new StandingDTO(team.getTournament().getTeamStanding(team)) : null;
//    }
//
//    public StandingDTO getTeamStanding(String tag, String region) {
//        Team team = teamRepository.getFirstByTagAndRegion(tag, region);
//        return team != null ? new StandingDTO(team.getTournament().getTeamStanding(team)) : null;
//    }

}
