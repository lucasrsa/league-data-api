package com.github.lucasrsa.leaguedataapi.db;

import com.github.lucasrsa.leaguedataapi.domain.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team getFirstByTag(String tag);

    Team getFirstByTagAndRegion(String tag, String region);

    List<Team> findByTag(String tag);

    List<Team> findAll();
}
