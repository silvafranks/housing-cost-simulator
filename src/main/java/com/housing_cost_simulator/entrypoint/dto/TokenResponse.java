package com.housing_cost_simulator.entrypoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenResponse {
    private String message;
    private String token;
}
