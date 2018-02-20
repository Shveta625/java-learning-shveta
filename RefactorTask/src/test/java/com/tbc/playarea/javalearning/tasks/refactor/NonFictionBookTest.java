package com.tbc.playarea.javalearning.tasks.refactor.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.tbc.playarea.javalearning.tasks.refactor.Book;
import com.tbc.playarea.javalearning.tasks.refactor.NonFictionBook;

public class NonFictionBookTest {

	static final String BOOK_NAME = "Wings of fire";

	@Test
	public void testNonFictionBookCreation() {
		Date date = new Date();
		Book book = new NonFictionBook.NonFictionBookBuilder(BOOK_NAME).setReleaseDate(date).build();
		assertNotNull("NonFictionBook creation failed", book);
		assertTrue("NonFictionBook name incorrect", BOOK_NAME.equals(book.getTitle()));
	}

}
