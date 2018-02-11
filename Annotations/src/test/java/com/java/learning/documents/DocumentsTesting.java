package com.java.learning.documents;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

/**
 * Class testing annotations associated with {@link Documents}
 * 
 * @author shvetap
 *
 */
public class DocumentsTesting {

	private Validator validator;
	private Aadhar aadhar;
	private PanCard panCard;
	private BankStatement bankStatement;

	@Before
	public void setUp(){
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		aadhar = new Aadhar();
		aadhar.setFullname("Firstname LastName");
		
		panCard = new PanCard();
		panCard.setFullname("Firstname");
		

		bankStatement = new BankStatement();
		bankStatement.setCustomerName("Firstname LastName");
	}

	@Test
	public void testNameConstraint() {
		Documents documents=new Documents(aadhar, bankStatement, panCard);
		Set<ConstraintViolation<Documents>> violations = validator.validate(documents);	
        assertEquals(1, violations.size());
	}
	
}
