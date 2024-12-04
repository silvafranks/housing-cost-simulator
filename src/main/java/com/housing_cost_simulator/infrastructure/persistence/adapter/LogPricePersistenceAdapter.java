package com.housing_cost_simulator.infrastructure.persistence.adapter;

import com.housing_cost_simulator.domain.model.entities.LogPrice;
import com.housing_cost_simulator.entrypoint.dto.ProductAndRegistrationQuantity;
import com.housing_cost_simulator.infrastructure.persistence.LogPricePersistence;
import com.housing_cost_simulator.infrastructure.repository.mongo.LogPriceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogPricePersistenceAdapter implements LogPricePersistence {

    private final LogPriceRepository logPriceRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void persist(LogPrice logPrice) {
        logPriceRepository.save(logPrice);
    }

    @Override
    public List<ProductAndRegistrationQuantity> findProductMoreRegistration() {
        Aggregation aggregation = Aggregation.newAggregation(
              Aggregation.group("product.name")
                    .count().as("count"),
              Aggregation.sort(Sort.by(Sort.Direction.DESC, "count"))
        );

        AggregationResults<ProductAndRegistrationQuantity> results = mongoTemplate.aggregate(
              aggregation, "log_price", ProductAndRegistrationQuantity.class);
        return results.getMappedResults();
    }
}
