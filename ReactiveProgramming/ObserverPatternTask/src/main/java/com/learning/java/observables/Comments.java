package com.learning.java.observables;

import java.util.Map;

import com.learning.java.temp.Content;
import com.learning.java.temp.ContentType;

public class Comments implements BlogSection{


	private String name;
	private Map<ContentType, Content> contentMap;
}
