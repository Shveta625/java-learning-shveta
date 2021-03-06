package com.learning.java.main;

import java.io.File;

import com.learning.java.threads.ReaderThread;
import com.learning.java.util.PropertiesLoader;

/**
 * Converts CSV to .txt file
 * @author shvetap
 *
 */
public class CSVToText {
	public static void main(String[] args) throws InterruptedException {
		
		PropertiesLoader propertiesLoader=PropertiesLoader.getInstance();
		createDirectory(propertiesLoader.getProperty("OUTPUT_DIRECTORY"));		
		Thread thread = new Thread(new ReaderThread(propertiesLoader.getProperty("FILE_TO_READ")));
		thread.start();
		thread.join();
	}

	/**
	 * Creates directory on current path
	 */
	private static void createDirectory(String directoryName) {
		File file = new File(directoryName);
		file.mkdir();
	}

}