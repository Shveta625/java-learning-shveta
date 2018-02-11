package com.java.learning.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.java.learning.annotations.impl.CrossDocumentNameConstraintImpl;

/**
 * Annotation for cross document name constraint.
 * 
 * @author shvetap
 *
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CrossDocumentNameConstraintImpl.class)
public @interface CrossDocumentNameConstraint {
	String message() default "Name must be same in all docuemnts";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
