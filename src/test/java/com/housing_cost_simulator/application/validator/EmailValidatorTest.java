package com.housing_cost_simulator.application.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.housing_cost_simulator.application.validator.adapter.EmailValidatorAdapter;
import com.housing_cost_simulator.domain.exception.UnprocessableEntityException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmailValidatorTest {

    EmailValidator emailValidator = new EmailValidatorAdapter();

    @Test
    void shouldThrowExceptionWhenEmailIsNull() {
        UnprocessableEntityException exception = assertThrows(UnprocessableEntityException.class,
              () -> emailValidator.isValid(null));

        assertEquals("Incorrect email format!", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailIsEmpty() {
        UnprocessableEntityException exception = assertThrows(UnprocessableEntityException.class,
              () -> emailValidator.isValid(""));

        assertEquals("Incorrect email format!", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {
        String invalidEmail = "invalid-email";
        UnprocessableEntityException exception = assertThrows(UnprocessableEntityException.class,
              () -> emailValidator.isValid(invalidEmail));

        assertEquals("Incorrect email format!", exception.getMessage());
    }

    @Test
    void shouldNotThrowExceptionWhenEmailIsValid() {
        String validEmail = "test@example.com";
        assertDoesNotThrow(() -> emailValidator.isValid(validEmail));
    }

}