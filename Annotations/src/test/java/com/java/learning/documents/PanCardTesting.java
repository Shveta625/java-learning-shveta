package com.java.learning.documents;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.learning.framework.Validator;

/**
 * Class testing annotations associated with {@link PanCard}
 * 
 * @author shvetap
 *
 */
public class PanCardTesting {

	private PanCard panCard;
	List<String> violations;
	Validator validator;

	@Before
	public void setUp() {
		validator = new Validator();
		panCard = new PanCard();
		panCard.setDob(new Date());
		panCard.setFatherName("Fathername Surname");
		panCard.setFullname("Firstname LastName");
		panCard.setIssuedBy("Govt. of XYZ");
		panCard.setPanNumber("12345ABCD0");
	}

	@Test
	public void testEmptyPanCard() {
		PanCard dummyPanCard = new PanCard();
		violations = validator.validate(dummyPanCard);
		assertEquals(8, violations.size());
	}

	@Test
	public void testLengthConstraintInPanCard() {
		panCard.setPanNumber("123456");
		violations = validator.validate(panCard);
		assertEquals(1, violations.size());
	}

	@Test
	public void testCharacterOnlyConstraintInPanCard() {
		panCard.setFullname("123ABC");
		panCard.setFatherName("123Name");
		violations = validator.validate(panCard);
		assertEquals(2, violations.size());
	}

}
