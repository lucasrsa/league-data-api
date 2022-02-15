package com.github.lucasrsa.leaguedataapi.db;

import com.github.lucasrsa.leaguedataapi.domain.model.Tournament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    List<Tournament> findAll();

    List<Tournament> findByTag(String tag);

    List<Tournament> findByYear(int year);

    List<Tournament> findByTagAndYear(String tag, int year);

}
