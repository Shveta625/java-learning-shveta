package com.tbc.playarea.javalearning.tasks.refactor.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.tbc.playarea.javalearning.tasks.refactor.Book;
import com.tbc.playarea.javalearning.tasks.refactor.ChildrenBook;

public class ChildrenBookTest {

	static final String BOOK_NAME = "The Jungle Book";

	@Test
	public void testChildrenBookCreation() {
		Date date = new Date();
		Book book = new ChildrenBook.ChildrenBookBuilder(BOOK_NAME).setReleaseDate(date).build();
		assertNotNull("ChildrenBook creation failed", book);
		assertTrue("ChildrenBook name incorrect", BOOK_NAME.equals(book.getTitle()));
	}

}
