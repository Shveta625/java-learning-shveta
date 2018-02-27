package com.learning.java.observables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.learning.java.exception.UnregisteredObserverException;
import com.learning.java.util.Content;
import com.learning.java.util.ContentType;
import com.learning.java.util.Observable;
import com.learning.java.util.Observer;

public abstract class BlogSection implements Observable {

	protected String name;
	private Map<Observer, List<ContentType>> observers = new HashMap<>();
	private Map<Content<?>, ContentType> contentMap = new HashMap<>();

	protected BlogSection(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers();
	}

	public Map<Content<?>, ContentType> getContentMap() {
		return contentMap;
	}

	public void addToContentMap(ContentType contentType, Content<?> content) {
		this.contentMap.put(content, contentType);
		notifyObserversByContentType(contentType);
	}

	@Override
	public void register(Observer observer) {

		if (observer == null) {
			throw new UnregisteredObserverException();
		}
		observers.put(observer, Arrays.asList(ContentType.values()));
	}

	public void registerByContentType(Observer observer, ContentType contentType) {
		if (observers.containsKey(observer)) {
			observers.get(observer).add(contentType);
		} else {
			List<ContentType> contentTypes = new ArrayList<>();
			contentTypes.add(contentType);
			observers.put(observer, contentTypes);
		}
	}

	@Override
	public void unregister(Observer observer) {
		observers.remove(observer);
	}

	public void unregisterByContentType(Observer observer, ContentType contentType) {
		if (observers.containsKey(observer) && observers.get(observer).contains(contentType)) {
			observers.get(observer).remove(contentType);
		} else {
			throw new UnregisteredObserverException();
		}

	}

	@Override
	public void notifyObservers() {
		for (Entry<Observer, List<ContentType>> observer : observers.entrySet()) {
			observer.getKey().update(this);
		}
	}

	public void notifyObserversByContentType(ContentType contentType) {
		for (Entry<Observer, List<ContentType>> observer : observers.entrySet()) {
			if (observer.getValue().contains((contentType))) {
				observer.getKey().update(this);
			}
		}
	}

}
