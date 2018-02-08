package com.tbc.playarea.javalearning.tasks.refactor;

/**
 * Book of non-fiction genre
 * 
 * @author shvetap
 *
 */
public class NonFictionBook extends Book {

	private static final long serialVersionUID = 930709972132715753L;

	public NonFictionBook(NonFictionBookBuilder nonFictionBookBuilder) {
		super(nonFictionBookBuilder);
	}

	@Override
	protected int fetchRentalPoints(int daysRented) {
		return 1;
	}

	@Override
	protected double fetchRentPrice(int daysRented) {
		return daysRented * 3.0;
	}

	public static class NonFictionBookBuilder extends Book.BookBuilder<NonFictionBook> {

		public NonFictionBookBuilder(String title) {
			super(title);
		}

		public NonFictionBook build() {
			return new NonFictionBook(this);
		}

	}
}
