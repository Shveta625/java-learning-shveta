package com.java.learning.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.java.learning.annotations.impl.EmailConstraintImpl;

/**
 * Annotation for email validation.
 * @author shvetap
 *
 */
@Target( {ElementType.FIELD})
@Retention( RetentionPolicy.RUNTIME)
@Constraint( validatedBy = EmailConstraintImpl.class)
public @interface EmailValidityConstraint {
  String message() default 
      "Invalid email id";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}