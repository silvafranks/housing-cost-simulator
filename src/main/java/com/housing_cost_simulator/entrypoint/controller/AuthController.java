package com.housing_cost_simulator.entrypoint.controller;

import com.housing_cost_simulator.application.service.AuthService;
import com.housing_cost_simulator.entrypoint.dto.LoginRequest;
import com.housing_cost_simulator.entrypoint.dto.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authenticate", description = "Authenticate service")
public class AuthController {

    private final AuthService authService;

    @Operation(description = "login")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Auth Successfully"),
          @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.authenticate(loginRequest);
    }
}