package com.housing_cost_simulator.infrastructure.repository.mongo;

import com.housing_cost_simulator.domain.model.entities.LogPrice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogPriceRepository extends MongoRepository<LogPrice, String> {

}
