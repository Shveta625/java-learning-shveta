package com.java.learning.services;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.java.learning.collections.Cache;
import com.java.learning.exceptions.IllegalPageRequest;
import com.java.learning.util.PropertiesLoader;

/**
 * Page Request Handler
 * 
 * @author shvetap
 *
 */
public final class PageRequestHandler {
	Properties properties = new PropertiesLoader().loadProperties();
	int cachesize = Integer.parseInt(properties.getProperty("chacheSize"));
	Logger logger = Logger.getLogger(PageRequestHandler.class.getName());
	Cache cache1 = new Cache(cachesize);

	/**
	 * handles page requests
	 * 
	 * @param pageRequests
	 *            requested pages
	 * @throws IllegalPageRequest
	 *             Exception if page requested is invalid
	 */
	public void handlePageRequests(String[] pageRequests) throws IllegalPageRequest {
		for (String pageReq : pageRequests) {
			try {
				cache1.add(Integer.parseInt(pageReq));
				logCacheState();
			} catch (NumberFormatException e) {
				throw new IllegalPageRequest("PageRequests must be integer only");
			}
		}
	}

	/**
	 * Logs present cache state
	 */
	private void logCacheState() {
		String cacheState = cache1.toString();
		logger.log(Level.INFO, cacheState);
	}
}
