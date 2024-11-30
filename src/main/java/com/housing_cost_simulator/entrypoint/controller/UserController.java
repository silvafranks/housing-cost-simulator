package com.housing_cost_simulator.entrypoint.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.housing_cost_simulator.application.service.UserService;
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
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(description = "Search user by email!")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Successfully")
    })
    @GetMapping("/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        System.out.println("HELLO WORLD");
        return ok(userService.findUserByEmail(email));
    }
}
