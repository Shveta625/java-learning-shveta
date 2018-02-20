package com.java.learning.main;

import com.java.learning.services.PageRequestHandler;

/**
 * Least Recently used Cache implementation
 * 
 * @author shvetap
 *
 */
public final class LRU {

	public static void main(String[] pageRequests) throws Exception {
		PageRequestHandler pageRequestHandler = new PageRequestHandler();
		pageRequestHandler.handlePageRequests(pageRequests);
	}
}
