package com.tbc.playarea.javalearning.tasks.refactor;

/**
 * Book of Fiction genre
 * 
 * @author shvetap
 *
 */
public class FictionBook extends Book {

	private static final long serialVersionUID = -1785377855167357658L;

	public FictionBook(FictionBookBuilder fictionBookBuilder) {
		super(fictionBookBuilder);
	}

	@Override
	protected int fetchRentalPoints(int daysRented) {
		return 2;
	}

	@Override
	protected double fetchRentPrice(int daysRented) {
		double amt = 2;
		int thresholdDays = 2;
		if (daysRented > thresholdDays) {
			amt += (daysRented - thresholdDays) * 1.5;
		}
		return amt;
	}

	/**
	 * Builder class for FictionBook
	 * @author shvetap
	 *
	 */
	public static class FictionBookBuilder extends Book.BookBuilder<FictionBook> {

		public FictionBookBuilder(String title) {
			super(title);
		}

		public FictionBook build() {
			return new FictionBook(this);
		}

	}
}
