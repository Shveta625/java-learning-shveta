package com.tbc.playarea.javalearning.tasks.refactor;

import java.util.Date;

/**
 * Book of non-fiction genre
 * @author shvetap
 *
 */
public class NonFictionBook extends Book{

	private static final long serialVersionUID = 930709972132715753L;

	public NonFictionBook(String title, int bookCategory) {
		super(title, bookCategory);
	}
	
	public NonFictionBook(final String title, final int bookCategory, final Date releaseDate) {
		super(title, bookCategory, releaseDate);
	}
	public int fetchRentalPoints(int daysRented) {
		return 1;
	}

	@Override
	public double getBasePrice() {
		return 0;
	}

	@Override
	public int getThresholdDays() {
		return 0;
	}

	@Override
	public double getMultiplyingFactor() {
		return 3;
	}

}
