package com.tbc.playarea.javalearning.tasks.refactor;

/**
 * Book of genre Children
 * 
 * @author shvetap
 *
 */
public class ChildrenBook extends Book {

	private static final long serialVersionUID = 3755216325591454727L;

	public ChildrenBook(ChildrenBookBuilder childrenBookBuilder) {
		super(childrenBookBuilder);

	}

	@Override
	protected int fetchRentalPoints(int daysRented) {
		return 1;
	}

	@Override
	protected double fetchRentPrice(int daysRented) {
		double amt = 1.5;
		int thresholdDays = 3;
		if (daysRented > thresholdDays) {
			amt += (daysRented - thresholdDays) * 2;
		}
		return amt;
	}

	/**
	 * Builder class for ChildrenBook
	 * 
	 * @author shvetap
	 *
	 */
	public static class ChildrenBookBuilder extends Book.BookBuilder<ChildrenBook> {

		public ChildrenBookBuilder(String title) {
			super(title);
		}

		public ChildrenBook build() {
			return new ChildrenBook(this);
		}

	}

}
