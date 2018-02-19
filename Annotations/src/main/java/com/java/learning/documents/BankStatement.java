package com.java.learning.documents;

import java.util.List;

import com.java.learning.annotations.CharacterOnlyConstraint;
import com.java.learning.annotations.EmailValidityConstraint;
import com.java.learning.annotations.LengthConstraint;
import com.java.learning.annotations.NotNullConstraint;

/**
 * Class representing BankStatement
 * 
 * @author shvetap
 *
 */
public class BankStatement {
	
	@NotNullConstraint
	@LengthConstraint(value = 12)
	public String accountNumber;
	
	@NotNullConstraint
	@CharacterOnlyConstraint
	public String customerName;
	
	@NotNullConstraint
	public String address;
	
	@NotNullConstraint
	@LengthConstraint(value = 10)
	public String mobileNumber;
	
	@EmailValidityConstraint
	public String email;
	
	public List<Transaction> transactions;
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
