package com.learning.java.beans;

import java.util.Date;

public class AadharCard {

		public AadharCard(String fullname, String gender, String address, Date dob) {
		super();
		this.fullname = fullname;
		this.gender = gender;
		this.address = address;
		this.dob = dob;
	}

		private String fullname;
		
		private String gender;
		
		private String address;
		
		private Date dob;
}
