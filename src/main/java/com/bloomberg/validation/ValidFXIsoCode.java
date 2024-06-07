package com.bloomberg.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FXIsoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFXIsoCode {
    String message() default "Invalid from_currency_iso_code format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
