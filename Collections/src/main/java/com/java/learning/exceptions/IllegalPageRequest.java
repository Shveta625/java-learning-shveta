package com.java.learning.exceptions;

/**
 * Exception if page request is invalid
 * 
 * @author shvetap
 *
 */
public class IllegalPageRequest extends Exception {

	private static final long serialVersionUID = 3011617731953834949L;

	public IllegalPageRequest(String message) {
		super(message);
	}
}
