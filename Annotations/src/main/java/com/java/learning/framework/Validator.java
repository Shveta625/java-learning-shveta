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
		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				try {
					Constraint annotaionImpl = AnnotationImplementationMapping
							.getAnnotaionImplemention(annotation.annotationType()).newInstance();
					if (annotaionImpl != null && !annotaionImpl.isValid(field.get(object), field)) {
						violations.add(annotaionImpl.message());
					}
				} catch (IllegalArgumentException | IllegalAccessException | InstantiationException e) {
					e.printStackTrace();
				}
			}
		}
		return violations;
	}
}
