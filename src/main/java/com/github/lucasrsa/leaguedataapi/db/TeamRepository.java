package com.github.lucasrsa.leaguedataapi.db;

import com.github.lucasrsa.leaguedataapi.domain.model.Team;
import com.github.lucasrsa.leaguedataapi.domain.model.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team getById(long id);

    Team getFirstByTag(String tag);

    List<Team> findAll();

    List<Team> findByTournament(Tournament tournament);

}
