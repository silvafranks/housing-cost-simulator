package com.housing_cost_simulator.entrypoint.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{cep}")
    public ResponseEntity<AddressDto> findAddress(@PathVariable String cep) {
        //@PathVariable String CEP
        return ok(addressService.findAddressByCEP(cep));
    }

}
