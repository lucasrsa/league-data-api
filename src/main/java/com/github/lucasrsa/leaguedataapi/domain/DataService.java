package com.github.lucasrsa.leaguedataapi.domain;

import com.github.lucasrsa.leaguedataapi.db.repository.MatchRepository;
import com.github.lucasrsa.leaguedataapi.db.repository.ScheduleRepository;
import com.github.lucasrsa.leaguedataapi.db.repository.TeamRepository;
import com.github.lucasrsa.leaguedataapi.db.repository.TournamentRepository;
import com.github.lucasrsa.leaguedataapi.domain.dto.TeamDTO;
import com.github.lucasrsa.leaguedataapi.domain.dto.TournamentDTO;
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

    public List<TournamentDTO> getTournaments(){
        return tournamentRepository.findAll().stream().map(TournamentDTO::new).collect(Collectors.toList());
    }

    public List<TournamentDTO> getTournaments(Long year){
        return tournamentRepository.findByYear(year).stream().map(TournamentDTO::new).collect(Collectors.toList());
    }

    public TournamentDTO getTournament(String tag){
        return new TournamentDTO(tournamentRepository.getFirstByTag(tag));
    }

    public List<TeamDTO> getTeams(){
        return teamRepository.findAll().stream().map(TeamDTO::new).collect(Collectors.toList());
    }

    public List<TeamDTO> getTeams(String tag){
        return teamRepository.findAll().stream().map(TeamDTO::new).collect(Collectors.toList());
    }

    public TeamDTO getTeam(String tag, String region){
        return new TeamDTO(teamRepository.getFirstByTagAndRegion(tag, region));
    }

}
