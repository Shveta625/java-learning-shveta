package com.java.learning.annotations.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.java.learning.annotations.CrossDocumentNameConstraint;
import com.java.learning.documents.Documents;

/**
 * Implementation to validate cross document name constraint
 * 
 * @author shvetap
 *
 */
public class CrossDocumentNameConstraintImpl implements ConstraintValidator<CrossDocumentNameConstraint, Documents> {

	@Override
	public boolean isValid(Documents documents, ConstraintValidatorContext arg1) {
		boolean valid = false;
		String aadharName = documents.getAadhar().getFullname();
		String bankStatementName = documents.getBankStatement().getCustomerName();
		String panCardName = documents.getPanCard().getFullname();
		if (aadharName != null && bankStatementName != null && panCardName != null
				&& aadharName.equalsIgnoreCase(bankStatementName) && aadharName.equalsIgnoreCase(panCardName)) {
			valid = true;
		}
		return valid;
	}

}
