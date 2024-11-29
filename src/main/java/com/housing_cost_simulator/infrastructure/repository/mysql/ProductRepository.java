package com.housing_cost_simulator.infrastructure.repository.mysql;

import com.housing_cost_simulator.domain.model.entities.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     Optional<Product> findByName(String name);
}
