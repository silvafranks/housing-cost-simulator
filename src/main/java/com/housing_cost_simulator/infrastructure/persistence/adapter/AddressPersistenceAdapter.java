package com.housing_cost_simulator.infrastructure.persistence.adapter;

import com.housing_cost_simulator.domain.model.entities.Address;
import com.housing_cost_simulator.infrastructure.persistence.AddressPersistence;
import com.housing_cost_simulator.infrastructure.repository.mysql.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AddressPersistenceAdapter implements AddressPersistence {

    private final AddressRepository addressRepository;

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
}
