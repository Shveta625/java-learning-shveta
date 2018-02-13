package com.learning.java.observables;

import java.util.Map;

import com.learning.java.temp.Content;
import com.learning.java.temp.ContentType;

public class Article implements BlogSection {

	private String name;
	private Map<ContentType, Content> contentMap;
	public Article(String name, Map<ContentType, Content> contentMap) {
		super();
		this.name = name;
		this.contentMap = contentMap;
	}
}
