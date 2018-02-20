package com.java.learning.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.java.learning.util.AnnotationImplementationMapping;

/**
 * Class to validate objects
 * 
 * @author shvetap
 *
 */
public class Validator {

	Logger logger = Logger.getLogger(Validator.class.getName());

	/**
	 * Validates object
	 * 
	 * @param object
	 *            object to be validated
	 * @return List of validations violated
	 */
	public List<String> validate(Object object) {
		Field[] fields = object.getClass().getFields();
		List<String> violations = new ArrayList<>();
		for (Annotation annotation : object.getClass().getAnnotations()) {
			violations.addAll(getViolations(annotation, object, null));
		}
		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				try {
					violations.addAll(getViolations(annotation, field.get(object), field));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
				}
			}
		}
		return violations;
	}

	/**
	 * To get violations
	 * 
	 * @param annotation
	 *            {@link Annotation}
	 * @param obj
	 *            object against which violations are to be found
	 * @param field
	 *            field corresponding annotation
	 * @return list of violations
	 */
	private List<String> getViolations(Annotation annotation, Object obj, Field field) {
		List<String> violations = new ArrayList<>();
		try {
			Constraint annotaionImpl = AnnotationImplementationMapping
					.getAnnotaionImplemention(annotation.annotationType()).newInstance();
			if (annotaionImpl != null && !annotaionImpl.isValid(obj, field)) {
				violations.add(annotaionImpl.message());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
		return violations;

	}
}
