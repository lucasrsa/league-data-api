package com.github.lucasrsa.leaguedataapi.db.repository;

import com.github.lucasrsa.leaguedataapi.domain.model.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {
}
