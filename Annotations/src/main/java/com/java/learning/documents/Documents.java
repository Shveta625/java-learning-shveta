package com.java.learning.documents;

import com.java.learning.annotations.CrossDocumentNameConstraint;

/**
 * Class representing Documents
 * 
 * @author shvetap
 *
 */
@CrossDocumentNameConstraint
public class Documents {

	public Aadhar aadhar;
	public BankStatement bankStatement;
	public PanCard panCard;
	public Aadhar getAadhar() {
		return aadhar;
	}
	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	public BankStatement getBankStatement() {
		return bankStatement;
	}
	public void setBankStatement(BankStatement bankStatement) {
		this.bankStatement = bankStatement;
	}
	public PanCard getPanCard() {
		return panCard;
	}
	public void setPanCard(PanCard panCard) {
		this.panCard = panCard;
	}
	public Documents(Aadhar aadhar, BankStatement bankStatement, PanCard panCard) {
		super();
		this.aadhar = aadhar;
		this.bankStatement = bankStatement;
		this.panCard = panCard;
	}
	
	
}
