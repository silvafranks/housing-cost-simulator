package com.housing_cost_simulator.application.validator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmailValidatorTest {

    @Test
    void shouldReturnTrueWhenEmailIsValid() {
        String email = "valid.email@example.com";
        assertTrue(EmailValidator.isValid(email));
    }

}