package com.java.learning.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.java.learning.annotations.impl.LengthConstraintImpl;

/**
 * Annotation for Length constraint
 * 
 * @author shvetap
 *
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LengthConstraintImpl.class)
public @interface LengthConstraint {

	int value();

	String message() default "Invalid length";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
