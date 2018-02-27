package com.learning.java.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.util.PropertiesLoader;

/**
 * Writes words and their respective counts to a file
 * 
 * @author shvetap
 *
 */
public final class WriterThread implements Runnable {


	ConcurrentMap<String, Long> map;

	public WriterThread(ConcurrentMap<String, Long> map) {
		super();
		this.map = map;
	}

	@Override
	public void run() {
		Logger logger = Logger.getLogger(WriterThread.class.getName());

		try {
			Files.write(Paths.get(PropertiesLoader.getInstance().getProperty("outputDirectory") + "/" + "WordCount.txt"),
					() -> map.entrySet().stream().<CharSequence>map(e -> e.getKey() + " " + e.getValue()).iterator());

		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}

	}

}
