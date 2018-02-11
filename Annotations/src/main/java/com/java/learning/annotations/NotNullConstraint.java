package com.java.learning.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.java.learning.annotations.impl.NotNullConstraintImpl;

/**
 * Not null constraint
 * 
 * @author shvetap
 *
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotNullConstraintImpl.class)
public @interface NotNullConstraint {
	String message() default "Value cannot be null";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}