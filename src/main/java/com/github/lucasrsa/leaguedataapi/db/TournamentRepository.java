package com.github.lucasrsa.leaguedataapi.db;

import com.github.lucasrsa.leaguedataapi.domain.model.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    List<Tournament> findAll();

    Tournament getById(long id);

    Tournament getFirstByTag(String tag);

    List<Tournament> findByRegion(String region);

}
