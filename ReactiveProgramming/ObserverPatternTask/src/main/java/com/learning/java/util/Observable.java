package com.learning.java.util;

public interface Observable {
	
	void register(Observer observer);

	void unregister(Observer obj);
	
	void notifyObservers();
}
