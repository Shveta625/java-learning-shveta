package com.java.learning.annotations.impl;

import java.lang.reflect.Field;

import com.java.learning.framework.Constraint;

/**
 * Implementation to validate not null constraint
 * 
 * @author shvetap
 *
 */
public class NotNullConstraintImpl implements Constraint{

	
	@Override
	public String message() {
		return "Value cannot be null";
	}
	
	
	@Override
	public boolean isValid(Object obj, Field field) {
		return obj != null;
	}

}
