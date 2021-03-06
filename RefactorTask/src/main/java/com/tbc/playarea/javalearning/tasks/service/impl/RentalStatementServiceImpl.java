package com.tbc.playarea.javalearning.tasks.service.impl;

import java.util.Iterator;
import java.util.List;

import com.tbc.playarea.javalearning.tasks.refactor.Rental;
import com.tbc.playarea.javalearning.tasks.service.StatementService;

public abstract class RentalStatementServiceImpl implements StatementService<Rental> {

	protected StringBuilder result;

	@Override
	public void generateStatement(List<Rental> rentals, String name) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentalsItr = rentals.listIterator();
		result = new StringBuilder("Rental Record for " + name + "\n");

		while (rentalsItr.hasNext()) {
			Rental rental = rentalsItr.next();

			double thisAmount = rental.fetchRentalPrice();

			frequentRenterPoints += rental.fetchRentalPoints();

			// show figures for this rental
			result.append("\t").append(rental.getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
			totalAmount += thisAmount;
		}

		result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
		result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
	}

}
