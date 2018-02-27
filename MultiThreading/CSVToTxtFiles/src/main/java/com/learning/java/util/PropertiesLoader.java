package com.learning.java.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to load properties file
 * 
 * @author shvetap
 *
 */
public final class PropertiesLoader {

	private static PropertiesLoader instance = null;
	Logger logger = Logger.getLogger(PropertiesLoader.class.getName());
	private static Properties properties=new Properties();

	private PropertiesLoader() {
		try {
			File file = new File(getClass().getResource("/config.properties").toURI());
			FileInputStream fileInput = null;

			fileInput = new FileInputStream(file);
			properties.load(fileInput);
		} catch (IOException | URISyntaxException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}

	public static synchronized PropertiesLoader getInstance() {
		if (instance == null)
			instance = new PropertiesLoader();
		return instance;
	}

	public String getProperty(String propKey) {
		return properties.getProperty(propKey);
	}

}
