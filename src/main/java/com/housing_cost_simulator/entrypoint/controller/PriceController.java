package com.housing_cost_simulator.entrypoint.controller;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
@Tag(name = "non-relational logs", description = "Insights from non-relational logs")
public class PriceController {

    private final PriceService priceService;

    @Operation(description = "Create a new price")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Successfully created")
    })
    @PostMapping("/create")
    public ResponseEntity<Void> createPrice(@RequestBody PriceDto priceDto) {
        priceService.createPrice(priceDto);
        return ResponseEntity.status(201).build();
    }

}
