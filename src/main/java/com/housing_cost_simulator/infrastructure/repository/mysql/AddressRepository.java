package com.housing_cost_simulator.infrastructure.repository.mysql;

import com.housing_cost_simulator.domain.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
