package com.github.lucasrsa.leaguedataapi.db;

import com.github.lucasrsa.leaguedataapi.domain.model.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
