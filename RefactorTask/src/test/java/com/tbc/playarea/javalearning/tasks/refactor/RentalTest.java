package com.tbc.playarea.javalearning.tasks.refactor.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tbc.playarea.javalearning.tasks.refactor.Book;
import com.tbc.playarea.javalearning.tasks.refactor.NonFictionBook;
import com.tbc.playarea.javalearning.tasks.refactor.Rental;

public class RentalTest {

	Book book = new NonFictionBook.NonFictionBookBuilder("Wings of fire").build();

	@Test
	public void testRentalBeanCreation() {
		Rental rental = new Rental(book, 10);
		assertNotNull("Rental bean creation failed", rental);
	}

	@Test
	public void testFetchRentalPrice() {
		Rental rental = new Rental(book, 10);
		assertTrue("Incorrect rental price.", rental.fetchRentalPrice() == 30);
	}

	@Test
	public void testFetchRentalPoints() {
		Rental rental = new Rental(book, 10);
		assertTrue("Incorrect rental price.", rental.fetchRentalPoints() == 1);
	}
	
	@Test
	public void testGetTitile() {
		Rental rental = new Rental(book, 10);
		assertTrue("Incorrect title.", "Wings of fire".equals(rental.getTitle()));
	}
}
