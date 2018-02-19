package com.java.learning.annotations.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.java.learning.annotations.LengthConstraint;
import com.java.learning.framework.Constraint;

/**
 * Implementation to validate length constraint
 * 
 * @author shvetap
 *
 */
public final class LengthConstraintImpl implements Constraint {

	
	@Override
	public String message() {
		return "Invalid length";
	}
	
	@Override
	public boolean isValid(Object obj,Field field) {
		LengthConstraint lengthConstraint = null;
		boolean valid = false;
		for (Annotation annotation : field.getAnnotations()) {
			if (annotation.annotationType() == LengthConstraint.class) {
				lengthConstraint = (LengthConstraint) annotation;
			}
		}
		if (obj instanceof String && lengthConstraint != null) {
			valid = (obj.toString().length() == lengthConstraint.value());
		}
		return valid;
	}
}
