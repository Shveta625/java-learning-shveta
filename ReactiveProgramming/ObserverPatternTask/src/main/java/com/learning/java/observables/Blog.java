package com.learning.java.observables;

import java.util.ArrayList;
import java.util.List;

import com.learning.java.util.Observable;
import com.learning.java.util.Observer;

public class Blog implements Observable {

	List<BlogSection> blogSections = new ArrayList<>();
	List<Observer> observers = new ArrayList<>();

	@Override
	public void register(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void unregister(Observer observer) {
		if (observers.contains(observer)) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
	
	public void addBlogSection(BlogSection blogSection) {
		blogSections.add(blogSection);
		notifyObservers();
	}

}
