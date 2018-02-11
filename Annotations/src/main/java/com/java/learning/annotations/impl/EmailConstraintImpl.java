package com.java.learning.annotations.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.java.learning.annotations.EmailValidityConstraint;

/**
 * Implementation to validate email constraint
 * 
 * @author shvetap
 *
 */
public class EmailConstraintImpl implements ConstraintValidator<EmailValidityConstraint, String> {

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		final Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		boolean valid=false;
		if (email != null) {
			Matcher matcher = emailRegex.matcher(email);
			valid= matcher.find();
		}
		return valid;
	}

}
