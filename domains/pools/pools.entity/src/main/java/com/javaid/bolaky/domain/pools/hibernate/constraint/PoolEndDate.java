package com.javaid.bolaky.domain.pools.hibernate.constraint;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.javaid.bolaky.domain.pools.hibernate.validator.PoolEndDateValidator;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = PoolEndDateValidator.class)
@Documented
public @interface PoolEndDate {

	String message() default "P172";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
