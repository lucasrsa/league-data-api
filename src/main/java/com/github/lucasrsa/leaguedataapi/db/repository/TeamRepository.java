package com.github.lucasrsa.leaguedataapi.db.repository;

import com.github.lucasrsa.leaguedataapi.domain.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team getFirstByTagAndRegion(String tag, String region);

    List<Team> findFirstByTag(String tag);

    List<Team> findAll();
}
