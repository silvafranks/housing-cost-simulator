package com.housing_cost_simulator.infrastructure.security;

import com.housing_cost_simulator.infrastructure.repository.mysql.UserRepository;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.housing_cost_simulator.domain.model.entities.User user = userRepository.findByEmail(email)
              .orElseThrow(() -> new UsernameNotFoundException("User not found with username: "));

        return User.builder()
              .username(user.getEmail())
              .password(user.getPassword())
              .authorities(user.getRole())
              .build();
    }
}
