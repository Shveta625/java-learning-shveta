package com.tbc.playarea.javalearning.tasks.refactor;

import java.io.Serializable;
import java.util.Date;

/**
 * Simple Book class representing Book data and methods.
 * 
 * @author chandrashekarv
 *
 */
public abstract class Book implements Serializable {

	private static final long serialVersionUID = -7348792584072115788L;
	private Date releaseDate;

	private long id;
	private String title;
	private int bookCategory;

	public Book(final String title, final int bookCategory, final Date releaseDate) {
		super();
		this.title = title;
		this.bookCategory = bookCategory;
		this.releaseDate = releaseDate;
	}

	public Book(final String title, final int bookCategory) {
		super();
		this.title = title;
		this.bookCategory = bookCategory;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(int bookCategory) {
		this.bookCategory = bookCategory;
	}

	/**
	 * To get rent price
	 * 
	 * @param daysRented
	 *            Number of days book rented for
	 * @return rent price corresponding book and number of days it has been rented
	 *         for
	 */
	public double fetchRentPrice(int daysRented) {
		double amt = getBasePrice();
		int thresholdDays = getThresholdDays();
		if (daysRented > thresholdDays) {
			amt += (daysRented - thresholdDays) * getMultiplyingFactor();
		}
		return amt;
	}

	/**
	 * To get Base Rent price
	 * 
	 * @return base rent
	 */
	public abstract double getBasePrice();

	/**
	 * To get number of days for which rent is fixed
	 * 
	 * @return threshold days
	 */
	public abstract int getThresholdDays();

	/**
	 * Multiplying factor for increasing rent
	 * 
	 * @return multiplying factor
	 */
	public abstract double getMultiplyingFactor();

	/**
	 * To fetch rent price
	 * 
	 * @param daysRented
	 *            Number of days for which book has been rented
	 * @return Rental points
	 */
	public abstract int fetchRentalPoints(int daysRented);

}
