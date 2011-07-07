package com.javaid.bolaky.carpool.service.hibernate.constraint;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.javaid.bolaky.carpool.service.hibernate.validator.TravelDaysValidator;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = TravelDaysValidator.class)
@Documented
public @interface TravelDays {

	String message() default "S200";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
