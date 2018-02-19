package com.java.learning.annotations.impl;

import java.lang.reflect.Field;

import com.java.learning.documents.Documents;
import com.java.learning.framework.Constraint;

/**
 * Implementation to validate cross document name constraint
 * 
 * @author shvetap
 *
 */
public class CrossDocumentNameConstraintImpl implements Constraint {

	@Override
	public String message() {
		return "Name must be same in all docuemnts";
	}

	@Override
	public boolean isValid(Object docs, Field field) {
		boolean valid = false;
		if (docs instanceof Documents) {
			Documents documents;
			try {
				documents = (Documents) docs;

				String aadharName = documents.getAadhar().getFullname();
				String bankStatementName = documents.getBankStatement().getCustomerName();
				String panCardName = documents.getPanCard().getFullname();
				if (aadharName != null && bankStatementName != null && panCardName != null
						&& aadharName.equalsIgnoreCase(bankStatementName) && aadharName.equalsIgnoreCase(panCardName)) {
					valid = true;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return valid;
	}

}
