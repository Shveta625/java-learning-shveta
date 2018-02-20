package com.java.learning.enumgetter.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnumFinder {
	Logger logger = Logger.getLogger(EnumFinder.class.getName());

	public <T, E> E findEnum(Class<E> enumClas, T val) {

		E[] enumConstants = enumClas.getEnumConstants();
		for (E constant : enumConstants) {
			Method[] methods = constant.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (method.getReturnType().isAssignableFrom(val.getClass()) && method.getParameterCount() == 0) {
					try {
						if (method.invoke(constant).equals(val)) {
							return constant;
						}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
					}
				}
			}
		}
		return null;
	}
}
