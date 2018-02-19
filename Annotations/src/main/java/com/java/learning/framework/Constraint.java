package com.java.learning.framework;

import java.lang.reflect.Field;

public interface Constraint {
	public String message();

	public boolean isValid(Object obj, Field field);
}
