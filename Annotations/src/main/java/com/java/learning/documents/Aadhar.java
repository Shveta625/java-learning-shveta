package com.java.learning.documents;

import java.util.Date;

import com.java.learning.annotations.CharacterOnlyConstraint;
import com.java.learning.annotations.NotNullConstraint;

/**
 * Class representing Aadhar
 * 
 * @author shvetap
 *
 */
public class Aadhar {

	@NotNullConstraint
	@CharacterOnlyConstraint
	public String fullname;

	@NotNullConstraint
	public String gender;

	@NotNullConstraint
	public String address;

	@NotNullConstraint
	public Date dob;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
