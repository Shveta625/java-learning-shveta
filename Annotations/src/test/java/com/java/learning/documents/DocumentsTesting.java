package com.java.learning.documents;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.learning.framework.Validator;

/**
 * Class testing annotations associated with {@link Documents}
 * 
 * @author shvetap
 *
 */
public class DocumentsTesting {

	List<String> violations;
	Validator validator;
	private Aadhar aadhar;
	private PanCard panCard;
	private BankStatement bankStatement;

	@Before
	public void setUp() {
		validator = new Validator();
		aadhar = new Aadhar();
		aadhar.setFullname("Firstname LastName");

		panCard = new PanCard();
		panCard.setFullname("Firstname");

		bankStatement = new BankStatement();
		bankStatement.setCustomerName("Firstname LastName");
	}

	@Test
	public void testNameConstraint() {
		Documents documents = new Documents(aadhar, bankStatement, panCard);
		violations = validator.validate(documents);
		assertEquals(1, violations.size());
	}

}
