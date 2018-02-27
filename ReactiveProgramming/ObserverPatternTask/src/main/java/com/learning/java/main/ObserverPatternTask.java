package com.learning.java.main;

import java.io.File;

import com.learning.java.observables.Article;
import com.learning.java.observables.Blog;
import com.learning.java.observers.Feed;
import com.learning.java.observers.Notifier;
import com.learning.java.util.Content;
import com.learning.java.util.ContentType;
import com.learning.java.util.Observer;

public class ObserverPatternTask {

	public static void main(String[] args) {
		Blog blog=new Blog();
		Article article=new Article("First World War");
		
		Observer feed=new Feed();
		Observer notifier1=new Notifier();
		
		blog.register(feed);
		blog.addBlogSection(article);
		article.registerByContentType(notifier1, ContentType.ATTACHMENT);
		article.addToContentMap(ContentType.ATTACHMENT, new Content<File>(new File("")));
		article.addToContentMap(ContentType.TEXT, new Content<String>(""));
	}
}
