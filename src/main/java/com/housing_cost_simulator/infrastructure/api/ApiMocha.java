package com.housing_cost_simulator.infrastructure.api;

import com.housing_cost_simulator.infrastructure.api.dto.AddressResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
      name = "apiMocha",
      url = "https://cep-mock.free.beeceptor.com"
)
public interface ApiMocha {

    @GetMapping("/teste/{cep}")
    AddressResponseDto getAddress(@PathVariable("cep") String cep);
}
