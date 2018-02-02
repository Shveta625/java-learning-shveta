package com.tbc.playarea.javalearning.tasks.refactor;

import java.util.Date;

/**
 * Book of Fiction genre
 * @author shvetap
 *
 */
public class FictionBook extends Book{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1785377855167357658L;

	public FictionBook(String title, int bookCategory) {
		super(title, bookCategory);
	}
	
	public FictionBook(final String title, final int bookCategory, final Date releaseDate) {
		super(title, bookCategory, releaseDate);
	}

	public int fetchRentalPoints(int daysRented) {
		return 2;
	}

	@Override
	public double getBasePrice() {
		return 2;
	}

	@Override
	public int getThresholdDays() {
		return 2;
	}

	@Override
	public double getMultiplyingFactor() {
		return 1.5;
	}

}
