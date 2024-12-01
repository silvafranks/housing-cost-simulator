package com.housing_cost_simulator.entrypoint.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(description = "Find Adress by CEP")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully")
    })
    @GetMapping("/{cep}")
    public ResponseEntity<AddressDto> findAddress(@PathVariable String cep) {
        return ok(addressService.findAddressByCEP(cep, null));
    }

}
