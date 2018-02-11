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
 * Class testing annotations associated with {@link PanCard}
 * 
 * @author shvetap
 *
 */
public class PanCardTesting {

	private Validator validator;
	private PanCard panCard;

	@Before
	public void setUp(){
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		panCard = new PanCard();
		panCard.setDob(new Date());
		panCard.setFatherName("Fathername Surname");
		panCard.setFullname("Firstname LastName");
		panCard.setIssuedBy("Govt. of XYZ");
		panCard.setPanNumber("12345ABCD0");
	}

	@Test
	public void testEmptyPanCard() {
		PanCard dummyPanCard=new PanCard();
		Set<ConstraintViolation<PanCard>> violations = validator.validate(dummyPanCard);	
        assertEquals(8, violations.size());
	}
	
	@Test
	public void testLengthConstraintInPanCard() {
		panCard.setPanNumber("123456");
		Set<ConstraintViolation<PanCard>> violations = validator.validate(panCard);	
        assertEquals(1, violations.size());
	}
	
	@Test
	public void testCharacterOnlyConstraintInPanCard() {
		panCard.setFullname("123ABC");
		panCard.setFatherName("123Name");
		Set<ConstraintViolation<PanCard>> violations = validator.validate(panCard);	
        assertEquals(2, violations.size());
	}	
		
}
