package com.java.learning.util;

import com.java.learning.annotations.CharacterOnlyConstraint;
import com.java.learning.annotations.CrossDocumentNameConstraint;
import com.java.learning.annotations.EmailValidityConstraint;
import com.java.learning.annotations.LengthConstraint;
import com.java.learning.annotations.NotNullConstraint;
import com.java.learning.annotations.impl.CharacterOnlyConstraintImpl;
import com.java.learning.annotations.impl.CrossDocumentNameConstraintImpl;
import com.java.learning.annotations.impl.EmailConstraintImpl;
import com.java.learning.annotations.impl.LengthConstraintImpl;
import com.java.learning.annotations.impl.NotNullConstraintImpl;
import com.java.learning.framework.Constraint;

/**
 * Annotation and its corresponding implementation mapping class.
 * 
 * @author shvetap
 *
 */
public final class AnnotationImplementationMapping {

	/**
	 * Private constructor to avoid instantiation of class
	 */
	private AnnotationImplementationMapping() {

	}

	/**
	 * get implementation class corresponding annotation
	 * 
	 * @param annotaion
	 *            annotation corresponding which implementation class has to be
	 *            found
	 * @return implementation class
	 */
	public static Class<? extends Constraint> getAnnotaionImplemention(Class<?> annotaion) {
		Class<? extends Constraint> impl = null;
		if (annotaion == CharacterOnlyConstraint.class) {
			impl = CharacterOnlyConstraintImpl.class;
		} else if (annotaion == CrossDocumentNameConstraint.class) {
			impl = CrossDocumentNameConstraintImpl.class;
		} else if (annotaion == EmailValidityConstraint.class) {
			impl = EmailConstraintImpl.class;
		} else if (annotaion == LengthConstraint.class) {
			impl = LengthConstraintImpl.class;
		} else if (annotaion == NotNullConstraint.class) {
			impl = NotNullConstraintImpl.class;
		}
		return impl;
	}
}
