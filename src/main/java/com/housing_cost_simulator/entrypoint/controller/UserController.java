package com.housing_cost_simulator.entrypoint.controller;

import com.housing_cost_simulator.application.service.UserService;
import com.housing_cost_simulator.entrypoint.dto.RegisterUserRequest;
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
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "Authenticate", description = "Authenticate service")
public class UserController {

    private final UserService userService;

    @Operation(description = "Register user")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "User created"),
          @ApiResponse(responseCode = "422", description = "Successfully")
    })
    @PostMapping("/register")
    public ResponseEntity<Void> findUserByEmail(@RequestBody RegisterUserRequest userRequest) {
        userService.registerUser(userRequest);
        return ResponseEntity.status(201).build();
    }
}
