package com.java.learning.enumgetter.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to find enum instance corresponding the input.
 * 
 * @author shvetap
 *
 */
public class EnumFinder {
	Logger logger = Logger.getLogger(EnumFinder.class.getName());

	/**
	 * Finds enum instance
	 * 
	 * @param enumClas
	 *            class to be checked for enum instance
	 * @param value
	 *            value corresponding which enum instance has to be found
	 * @return enum instance
	 */
	public <T, E> E findEnum(Class<E> enumClas, T value) {

		E[] enumConstants = enumClas.getEnumConstants();
		for (E constant : enumConstants) {
			Method[] methods = constant.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (method.getReturnType().isAssignableFrom(value.getClass()) && method.getParameterCount() == 0) {
					try {
						if (method.invoke(constant).equals(value)) {
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
