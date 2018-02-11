package com.java.learning.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.java.learning.annotations.impl.CharacterOnlyConstraintImpl;

/**
 * Annotation for character only constraint.
 * 
 * @author shvetap
 *
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CharacterOnlyConstraintImpl.class)
public @interface CharacterOnlyConstraint {
	String message() default "Empty string or anything else than characters not allowed";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}