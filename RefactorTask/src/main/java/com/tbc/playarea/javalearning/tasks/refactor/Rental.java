/**
 * 
 */
package com.tbc.playarea.javalearning.tasks.refactor;

import java.io.Serializable;

/**
 * Represent a customer renting a book.
 * 
 * @author shvetap
 * 
 */
public class Rental implements Serializable {

	private static final long serialVersionUID = 1256869448913370768L;

	private Book book;

	private int daysRented;

	public Rental(Book book, int daysRented) {
		super();
		this.book = book;
		this.daysRented = daysRented;
	}

	public double fetchRentalPrice() {
		return book.fetchRentPrice(daysRented);
	}

	public int fetchRentalPoints() {
		return book.fetchRentalPoints(daysRented);
	}
	
	public String getTitle() {
		return book.getTitle();
	}

}
