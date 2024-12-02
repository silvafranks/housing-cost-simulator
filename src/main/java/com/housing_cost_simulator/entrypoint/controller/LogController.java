package com.housing_cost_simulator.entrypoint.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.housing_cost_simulator.application.dto.AddressDto;
import com.housing_cost_simulator.application.dto.UserDto;
import com.housing_cost_simulator.application.service.LogService;
import com.housing_cost_simulator.entrypoint.dto.UserSearchCountDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
@Tag(name = "non-relational logs", description = "Insights from non-relational logs")
public class LogController {

    private final LogService logService;

    @Operation(description = "Search for users with the most searches")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully"),
          @ApiResponse(responseCode = "403", description = "Unauthorized")
    })
    @GetMapping("user-most-searches")
    public ResponseEntity<UserSearchCountDto> findAddress() {
        //@PathVariable String CEP
        return ok(logService.getUserMostSearches());
    }
}
