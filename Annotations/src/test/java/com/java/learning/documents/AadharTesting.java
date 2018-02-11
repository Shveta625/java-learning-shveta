package com.java.learning.documents;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

/**
 * Class testing annotations associated with {@link Aadhar}
 * 
 * @author shvetap
 *
 */
public class AadharTesting {

	private Validator validator;
	private Aadhar aadhar;

	@Before
	public void setUp(){
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		aadhar = new Aadhar();
		aadhar.setFullname("Firstname LastName");
		aadhar.setGender("Female");
		aadhar.setAddress("ABC, XYZCity");;
		aadhar.setDob(new Date());
	}

	@Test
	public void testEmptyAadhar() {
		Aadhar dummyAadhar=new Aadhar();
		Set<ConstraintViolation<Aadhar>> violations = validator.validate(dummyAadhar);	
        assertEquals(5, violations.size());
	}
	
	@Test
	public void testCharacterOnlyConstraintInAadhar() {
		aadhar.setFullname("123ABC");
		Set<ConstraintViolation<Aadhar>> violations = validator.validate(aadhar);	
        assertEquals(1, violations.size());
	}	
	
}
