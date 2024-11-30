package com.housing_cost_simulator.application.validator;

import java.util.regex.Pattern;


public class EmailValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean isValid(String email) {
        if (email == null || email.isEmpty()) {
            // TODO THROW EXCEPTION
            return false;
        }

        return EMAIL_PATTERN.matcher(email).matches();
    }

}
