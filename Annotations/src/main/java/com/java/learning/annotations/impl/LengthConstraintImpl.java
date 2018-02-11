package com.java.learning.annotations.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.java.learning.annotations.LengthConstraint;
/**
 * Implementation to validate length constraint
 * 
 * @author shvetap
 *
 */
public class LengthConstraintImpl implements ConstraintValidator<LengthConstraint, String> {

	int value;

	@Override
	public void initialize(LengthConstraint lengthConstraint) {
		this.value = lengthConstraint.value();
	}

	@Override
	public boolean isValid(String string, ConstraintValidatorContext arg1) {
		boolean valid = false;
		if (string != null) {
			valid = (string.length() == this.value);
		}
		return valid;
	}
}
