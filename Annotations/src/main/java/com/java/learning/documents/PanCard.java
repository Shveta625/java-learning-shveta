package com.java.learning.documents;

import java.util.Date;

import com.java.learning.annotations.CharacterOnlyConstraint;
import com.java.learning.annotations.LengthConstraint;
import com.java.learning.annotations.NotNullConstraint;

/**
 * Class representing Pan card
 * 
 * @author shvetap
 *
 */
public class PanCard {
	
	@NotNullConstraint
	@CharacterOnlyConstraint
	public String fullname;

	@NotNullConstraint
	@CharacterOnlyConstraint
	public String fatherName;
	
	@NotNullConstraint
	@LengthConstraint(value=10)
	public String panNumber;

	@NotNullConstraint
	public String issuedBy;

	@NotNullConstraint
	public Date dob;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
