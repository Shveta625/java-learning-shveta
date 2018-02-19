package com.java.learning.annotations.impl;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.java.learning.framework.Constraint;

/**
 * Implementation to validate character only constraint
 * 
 * @author shvetap
 *
 */
public class CharacterOnlyConstraintImpl implements Constraint {
	
	@Override
	public String message() {
		return "Empty string or anything else than characters not allowed";
	}

	@Override
	public boolean isValid(Object name, Field field) {
		final Pattern nameRegex = Pattern.compile("^[\\p{L} ]+$");
		boolean valid = false;
		if (name != null && name instanceof String) {
			Matcher matcher = nameRegex.matcher(name.toString());
			valid = matcher.find();
		}
		return valid;
	}

}
