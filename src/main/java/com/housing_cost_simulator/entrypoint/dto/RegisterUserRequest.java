package com.housing_cost_simulator.entrypoint.dto;

import lombok.Data;

@Data
public class RegisterUserRequest {

    private String email;

    private String password;

    private String role;

    private String cep;

}
