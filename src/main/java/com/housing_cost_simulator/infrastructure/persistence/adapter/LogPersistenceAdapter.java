package com.housing_cost_simulator.infrastructure.persistence.adapter;

import com.housing_cost_simulator.domain.model.entities.Log;
import com.housing_cost_simulator.entrypoint.dto.PriceWithMoreRecords;
import com.housing_cost_simulator.infrastructure.persistence.LogPersistence;
import com.housing_cost_simulator.entrypoint.dto.UserSearchCountDto;
import com.housing_cost_simulator.infrastructure.repository.mongo.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogPersistenceAdapter implements LogPersistence {

    private final LogRepository logRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void persist(Log log) {
        logRepository.save(log);
    }

    @Override
    public UserSearchCountDto getUserMostSearches() {
        Aggregation aggregation = Aggregation.newAggregation(
              Aggregation.group("user.email")
                    .count().as("count"),

              Aggregation.project("count")
                    .and("user.email").as("email"),

              Aggregation.sort(Sort.by(Sort.Order.desc("count"))),

              Aggregation.limit(1)
        );

        AggregationResults<UserSearchCountDto> results = mongoTemplate.aggregate(aggregation, "log", UserSearchCountDto.class);
        return results.getUniqueMappedResult();
    }

}
