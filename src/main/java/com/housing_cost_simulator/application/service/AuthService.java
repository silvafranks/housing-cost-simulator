package com.housing_cost_simulator.application.service;

import com.housing_cost_simulator.domain.exception.UnauthorizedException;
import com.housing_cost_simulator.entrypoint.dto.LoginRequest;
import com.housing_cost_simulator.entrypoint.dto.TokenResponse;
import com.housing_cost_simulator.shared.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    public TokenResponse authenticate(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtUtil.generateToken(authentication.getName());

            return new TokenResponse("Login successful", token);

        } catch (
              AuthenticationException e) {
            throw new UnauthorizedException("Invalid username or password" + e);
        }
    }
}
