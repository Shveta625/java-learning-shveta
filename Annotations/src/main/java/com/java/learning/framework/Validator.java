package com.java.learning.framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.java.learning.util.AnnotationImplementationMapping;

public class Validator {

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
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					e1.printStackTrace();
				}
			}
		}
		return violations;
	}

	private List<String> getViolations(Annotation annotation, Object obj, Field field) {
		List<String> violations = new ArrayList<>();
		try {
			Constraint annotaionImpl = AnnotationImplementationMapping
					.getAnnotaionImplemention(annotation.annotationType()).newInstance();
			if (annotaionImpl != null && !annotaionImpl.isValid(obj, field)) {
				violations.add(annotaionImpl.message());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return violations;

	}
}
