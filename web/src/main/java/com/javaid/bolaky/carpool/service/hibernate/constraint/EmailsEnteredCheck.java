package com.javaid.bolaky.carpool.service.hibernate.constraint;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.javaid.bolaky.carpool.service.hibernate.validator.EmailsEnteredValidator;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = EmailsEnteredValidator.class)
@Documented
public @interface EmailsEnteredCheck {

	String message() default "S27";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
