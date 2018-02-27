package com.learning.java.exception;

public class UnregisteredObserverException extends RuntimeException {

	private static final long serialVersionUID = -6123692518194318377L;
	private static final String MESSAGE = "Observer not registered";

	public UnregisteredObserverException() {
		super(MESSAGE);
	}

}
