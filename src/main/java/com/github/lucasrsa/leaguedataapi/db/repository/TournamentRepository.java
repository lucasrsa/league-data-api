package com.github.lucasrsa.leaguedataapi.db.repository;

import com.github.lucasrsa.leaguedataapi.domain.model.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    Tournament getFirstByTag(String tag);

    List<Tournament> findByYear(Long year);

    List<Tournament> findAll();

}
