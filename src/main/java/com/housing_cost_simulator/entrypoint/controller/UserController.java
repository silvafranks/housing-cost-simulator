package com.housing_cost_simulator.entrypoint.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.housing_cost_simulator.application.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    @GetMapping("/{email}")
    public ResponseEntity<?> buscarConfigDg(@PathVariable String email) {
        System.out.println("HELLO WORLD");
        return ok(userService.findUserByEmail(email));
    }
}
