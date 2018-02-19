package com.java.learning.documents;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.learning.framework.Validator;

/**
 * Class testing annotations associated with {@link BankStatement}
 * 
 * @author shvetap
 *
 */
public class BankStatementTesting {

	private BankStatement bankStatement;
	List<String> violations;
	Validator validator;

	@Before
	public void setUp(){
		validator=new Validator();
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
		violations = validator.validate(dummyBankStatement);	
        assertEquals(8, violations.size());
	}
	
	@Test
	public void testLengthConstraintInBankStatement() {
		bankStatement.setAccountNumber("123456");
		bankStatement.setMobileNumber("123");
		violations = validator.validate(bankStatement);	
        assertEquals(2, violations.size());
	}
	
	@Test
	public void testCharacterOnlyConstraintInBankStatement() {
		bankStatement.setCustomerName("123ABC");
		violations = validator.validate(bankStatement);	
        assertEquals(1, violations.size());
	}	
	
	@Test
	public void testEmailValidityConstraintInBankStatement() {
		bankStatement.setEmail("email");
		violations = validator.validate(bankStatement);	
        assertEquals(1, violations.size());
	}
	
}
