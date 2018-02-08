package com.tbc.playarea.javalearning.tasks.refactor;

import java.io.Serializable;
import java.util.Date;

/**
 * Simple Book class representing Book data and methods.
 * 
 * @author shvetap
 * 
 */
public abstract class Book implements Serializable {

	private static final long serialVersionUID = -7348792584072115788L;
	private Date releaseDate;

	private long id;
	private String title;

	public Book(final BookBuilder<?> bookBuilder) {
		super();
		this.title = bookBuilder.title;
		this.releaseDate = bookBuilder.releaseDate;
	}

	public String getTitle() {
		return title;
	}

	/**
	 * To get rent price
	 * 
	 * @param daysRented
	 *            Number of days book rented for
	 * @return rent price corresponding book and number of days it has been rented
	 *         for
	 */
	protected abstract double fetchRentPrice(int daysRented);

	/**
	 * To fetch rent price
	 * 
	 * @param daysRented
	 *            Number of days for which book has been rented
	 * @return Rental points
	 */
	protected abstract int fetchRentalPoints(int daysRented);

	/**
	 * Builder class for Book
	 * 
	 * @author shvetap
	 *
	 * @param <T>
	 *            class extending Book
	 */
	public abstract static class BookBuilder<T extends Book> {
		protected Date releaseDate;
		protected String title;

		public BookBuilder(String title) {
			super();
			this.title = title;
		}

		public BookBuilder<T> setReleaseDate(Date releaseDate) {
			this.releaseDate = releaseDate;
			return this;
		}

		public abstract T build();

	}

}
