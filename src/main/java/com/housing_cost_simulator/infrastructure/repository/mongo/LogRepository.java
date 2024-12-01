package com.housing_cost_simulator.infrastructure.repository.mongo;

import com.housing_cost_simulator.domain.model.entities.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {

}
