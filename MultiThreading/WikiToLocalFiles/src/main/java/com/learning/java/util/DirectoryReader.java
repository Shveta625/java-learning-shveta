package com.learning.java.util;

import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.threads.ReaderThread;

/**
 * To read directory
 * 
 * @author shvetap
 *
 */
public class DirectoryReader {

	String dirToRead;

	public DirectoryReader(String dirToRead) {
		super();
		this.dirToRead = dirToRead;
	}

	public File[] readDirectory() {
		Logger logger = Logger.getLogger(ReaderThread.class.getName());
		File[] files = null;
		try {
			File dir = new File(getClass().getResource("/" + dirToRead).toURI());
			files = dir.listFiles();
		} catch (URISyntaxException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
		return files;
	}
}
