package com.tbc.playarea.javalearning.tasks.refactor;

import java.util.Date;

/**
 * Book of genre Children
 * @author shvetap
 *
 */
public class ChildrenBook extends Book{

	private static final long serialVersionUID = 3755216325591454727L;

	public ChildrenBook(String title, int bookCategory) {
		super(title, bookCategory);
	}
	
	public ChildrenBook(final String title, final int bookCategory, final Date releaseDate) {
		super(title, bookCategory, releaseDate);
	}
	
	public int fetchRentalPoints(int daysRented) {
		return 1;
	}

	public double getBasePrice() {
		return 1.5;
	}

	public int getThresholdDays() {
		return 3;
	}

	public double getMultiplyingFactor() {
		return 2;
	}

}
