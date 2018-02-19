package com.java.learning.documents;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.java.learning.framework.Validator;

/**
 * Class testing annotations associated with {@link Aadhar}
 * 
 * @author shvetap
 *
 */
public class AadharTesting {

	private Aadhar aadhar;
	List<String> violations;
	Validator validator;

	@Before
	public void setUp(){
		validator=new Validator();
		aadhar = new Aadhar();
		aadhar.setFullname("Firstname LastName");
		aadhar.setGender("Female");
		aadhar.setAddress("ABC, XYZCity");;
		aadhar.setDob(new Date());
	}

	@Test
	public void testEmptyAadhar() {
		Aadhar dummyAadhar=new Aadhar();
		violations=validator.validate(dummyAadhar);
        assertEquals(5, violations.size());
	}
	
	@Test
	public void testCharacterOnlyConstraintInAadhar() {
		aadhar.setFullname("123ABC");
		violations=validator.validate(aadhar);
        assertEquals(1, violations.size());
	}	
	
}
