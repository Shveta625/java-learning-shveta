package com.java.learning.annotations.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.java.learning.annotations.CharacterOnlyConstraint;

/**
 * Implementation to validate character only constraint
 * 
 * @author shvetap
 *
 */
public class CharacterOnlyConstraintImpl implements ConstraintValidator<CharacterOnlyConstraint, String> {

	@Override
	public boolean isValid(String name, ConstraintValidatorContext arg1) {
		final Pattern nameRegex = Pattern.compile("^[\\p{L} ]+$");
		boolean valid = false;
		if (name != null) {
			Matcher matcher = nameRegex.matcher(name);
			valid = matcher.find();
		}
		return valid;
	}

}
