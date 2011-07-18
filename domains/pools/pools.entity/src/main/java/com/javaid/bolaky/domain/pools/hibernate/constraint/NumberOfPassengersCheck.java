package com.javaid.bolaky.domain.pools.hibernate.constraint;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.javaid.bolaky.domain.pools.hibernate.validator.NumberOfPassengersCheckValidator;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = NumberOfPassengersCheckValidator.class)
@Documented
public @interface NumberOfPassengersCheck {

	String message() default "P62";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
