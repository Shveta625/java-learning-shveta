package com.java.learning.framework;

import java.lang.reflect.Field;

/**
 * Constraint interface to be implemented by all interfaces
 * 
 * @author shvetap
 *
 */
public interface Constraint {
	/**
	 * To get message corresponding constraint violation
	 * 
	 * @return message corresponding constraint violation
	 */
	public String message();

	/**
	 * Validate object
	 * 
	 * @param obj
	 *            object to be validated
	 * @param field
	 *            field against which object has to be violated
	 * @return true if valid, false otherwise
	 */
	public boolean isValid(Object obj, Field field);
}
