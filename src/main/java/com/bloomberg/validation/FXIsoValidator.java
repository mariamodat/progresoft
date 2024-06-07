package com.bloomberg.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class FXIsoValidator implements ConstraintValidator<ValidFXIsoCode, String> {

    @Override
    public void initialize(ValidFXIsoCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }
        return Pattern.matches("^[A-Z]{3}$", s);
    }

}
