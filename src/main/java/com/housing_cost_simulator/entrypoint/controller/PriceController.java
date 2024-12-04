package com.housing_cost_simulator.entrypoint.controller;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/price")
@RequiredArgsConstructor
@Tag(name = "Values on prices", description = "EndPoints on prices")
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

    @Operation(description = "Find Firts Price By Neighbourhood")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully"),
          @ApiResponse(responseCode = "204", description = "No content")
    })
    @GetMapping("/firt-neighbourhood/{productName}")
    public ResponseEntity<Map<String, PriceDto>> findPriceByNeighbourhood(@PathVariable String productName) {
        return ResponseEntity.ok(priceService.findPriceByNeighbourhood(productName));
    }

    @Operation(description = "Search for the product with the lowest price")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully"),
          @ApiResponse(responseCode = "204", description = "No content")
    })
    @GetMapping("/lowest-price/{productName}")
    public PriceDto findLowestPriceProduct(@PathVariable String productName) {
        return priceService.findLowestPriceProduct(productName);
    }

    @Operation(description = "Demand for the most expensive product")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully"),
          @ApiResponse(responseCode = "204", description = "No content")
    })
    @GetMapping("/most-expensive/{productName}")
    public PriceDto findMostExpensiveProduct(@PathVariable String productName) {
        return priceService.findMostExpensiveProduct(productName);
    }
}
