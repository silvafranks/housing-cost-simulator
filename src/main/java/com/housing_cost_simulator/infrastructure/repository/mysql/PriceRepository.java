package com.housing_cost_simulator.infrastructure.repository.mysql;

import com.housing_cost_simulator.domain.model.entities.Price;
import com.housing_cost_simulator.domain.persistence.PricePersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
