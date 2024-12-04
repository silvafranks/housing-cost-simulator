package com.housing_cost_simulator.entrypoint.controller;

import com.housing_cost_simulator.application.dto.PriceDto;
import com.housing_cost_simulator.application.dto.ProductDto;
import com.housing_cost_simulator.application.service.PriceService;
import com.housing_cost_simulator.application.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "Product", description = "Product CRUD")
public class ProductController {

    private final ProductService productService;

    @Operation(description = "Find Product By name")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully")
    })
    @GetMapping("/{name}")
    public ResponseEntity<ProductDto> findByProductName(@PathVariable String name) {

        return ResponseEntity.ok(productService.findByProductName(name));
    }
    @Operation(description = "Find Product By name")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully")
    })
    @PostMapping("/create")
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
        return ResponseEntity.status(201).build();
    }

}
