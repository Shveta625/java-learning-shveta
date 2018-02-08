package com.learning.java.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.threads.WriterForkJoinThread;

/**
 * Class to load properties file
 * 
 * @author shvetap
 *
 */
public class PropertiesLoader {
	Logger logger = Logger.getLogger(WriterForkJoinThread.class.getName());

	/**
	 * Load properties from property file
	 * 
	 * @return
	 */
	public Properties loadProperties() {
		Properties properties = new Properties();
		try {
			File file = new File(getClass().getResource("/config.properties").toURI());
			FileInputStream fileInput = null;

			fileInput = new FileInputStream(file);
			properties.load(fileInput);
		} catch (IOException | URISyntaxException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
		return properties;
	}

}