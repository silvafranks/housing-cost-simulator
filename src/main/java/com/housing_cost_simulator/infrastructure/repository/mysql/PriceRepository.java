package com.housing_cost_simulator.infrastructure.repository.mysql;

import com.housing_cost_simulator.domain.model.entities.Price;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("select p from Price p where p.product.name = ?1")
    List<Price> findByProduct_Name(String name);
}
