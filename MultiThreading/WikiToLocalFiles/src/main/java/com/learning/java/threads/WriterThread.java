package com.learning.java.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.util.PropertiesLoader;

/**
 * Writes to local
 * 
 * @author shvetap
 *
 */
public class WriterThread implements Runnable {

	String title;
	String data;

	public WriterThread(String title, String data) {
		super();
		this.title = title;
		this.data = data;
	}

	@Override
	public void run() {
		Logger logger = Logger.getLogger(WriterThread.class.getName());
		try {
			Files.write(
					Paths.get(PropertiesLoader.getInstance().getProperty("outputDirectory") + "/" + title.replaceAll("/", "|") + ".txt"),
					data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}

	}

}
