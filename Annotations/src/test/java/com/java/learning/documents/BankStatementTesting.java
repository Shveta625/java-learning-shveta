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
 * Class testing annotations associated with {@link BankStatement}
 * 
 * @author shvetap
 *
 */
public class BankStatementTesting {

	private Validator validator;
	private BankStatement bankStatement;

	@Before
	public void setUp(){
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
		bankStatement = new BankStatement();
		bankStatement.setAccountNumber("123456789012");
		bankStatement.setAddress("ABC, XYZCity");
		bankStatement.setCustomerName("Firstname LastName");
		bankStatement.setEmail("abc@xyz.com");
		bankStatement.setMobileNumber("0987654321");
	}

	@Test
	public void testEmptyBankStatement() {
		BankStatement dummyBankStatement=new BankStatement();
		Set<ConstraintViolation<BankStatement>> violations = validator.validate(dummyBankStatement);	
        assertEquals(8, violations.size());
	}
	
	@Test
	public void testLengthConstraintInBankStatement() {
		bankStatement.setAccountNumber("123456");
		bankStatement.setMobileNumber("123");
		Set<ConstraintViolation<BankStatement>> violations = validator.validate(bankStatement);	
        assertEquals(2, violations.size());
	}
	
	@Test
	public void testCharacterOnlyConstraintInBankStatement() {
		bankStatement.setCustomerName("123ABC");
		Set<ConstraintViolation<BankStatement>> violations = validator.validate(bankStatement);	
        assertEquals(1, violations.size());
	}	
	
	@Test
	public void testEmailValidityConstraintInBankStatement() {
		bankStatement.setEmail("email");
		Set<ConstraintViolation<BankStatement>> violations = validator.validate(bankStatement);	
        assertEquals(1, violations.size());
	}
	
}
