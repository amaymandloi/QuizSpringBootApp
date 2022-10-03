package com.yash.validation;

import java.lang.annotation.Target;

import javax.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Payload;
@Constraint(validatedBy=UserIdConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdConstraint {

	String message() default "User Id already exists";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
	
}
