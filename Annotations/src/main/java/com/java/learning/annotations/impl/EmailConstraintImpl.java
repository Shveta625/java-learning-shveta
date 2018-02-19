package com.java.learning.annotations.impl;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java.learning.framework.Constraint;

/**
 * Implementation to validate email constraint
 * 
 * @author shvetap
 *
 */
public class EmailConstraintImpl implements Constraint {

	@Override
	public String message() {
		return "Invalid email id";
	}

	@Override
	public boolean isValid(Object email, Field field) {
		final Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		boolean valid = false;
		if (email != null && email instanceof String) {
			Matcher matcher = emailRegex.matcher(email.toString());
			valid = matcher.find();
		}
		return valid;
	}

}
