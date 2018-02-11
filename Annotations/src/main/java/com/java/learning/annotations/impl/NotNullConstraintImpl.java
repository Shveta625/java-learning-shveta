package com.java.learning.annotations.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.java.learning.annotations.NotNullConstraint;

/**
 * Implementation to validate not null constraint
 * 
 * @author shvetap
 *
 */
public class NotNullConstraintImpl implements ConstraintValidator<NotNullConstraint, Object> {

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext arg1) {
		return obj != null;
	}

}
