package com.tbc.playarea.javalearning.tasks.refactor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.tbc.playarea.javalearning.tasks.refactor.Book;
import com.tbc.playarea.javalearning.tasks.refactor.FictionBook;

public class FictionBookTest {

	static final String BOOK_NAME = "Twilight";

	@Test
	public void testFictionBookCreation() {
		Date date = new Date();
		Book book = new FictionBook.FictionBookBuilder(BOOK_NAME).setReleaseDate(date).build();
		assertNotNull("FictionBook creation failed", book);
		assertTrue("FictionBook name incorrect", BOOK_NAME.equals(book.getTitle()));
	}

}
