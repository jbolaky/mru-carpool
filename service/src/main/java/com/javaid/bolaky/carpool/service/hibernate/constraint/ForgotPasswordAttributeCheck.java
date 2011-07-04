package com.javaid.bolaky.carpool.service.hibernate.constraint;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.javaid.bolaky.carpool.service.hibernate.validator.ForgotPasswordAttributeCheckValidator;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = ForgotPasswordAttributeCheckValidator.class)
@Documented
public @interface ForgotPasswordAttributeCheck {

	String message() default "S90";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
