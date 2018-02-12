package com.learning.java.main;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.threads.ReaderThread;
import com.learning.java.threads.WriterThread;
import com.learning.java.util.DirectoryReader;
import com.learning.java.util.PropertiesLoader;

/**
 * Class giving words and their corresponding count.
 * 
 * @author shvetap
 *
 */
public final class WordCount {

	private static Properties properties = (new PropertiesLoader()).loadProperties();

	public static void main(String[] args) {
		createDirectory();
		List<File> files = Arrays.asList((new DirectoryReader(properties.getProperty("dirToRead"))).readDirectory());
		startThreads(files);

	}

	/**
	 * Start reader and writer threads
	 * 
	 * @param files
	 */
	private static void startThreads(List<File> files) {
		Logger logger = Logger.getLogger(WordCount.class.getName());
		ConcurrentMap<String, Long> wordCount = new ConcurrentHashMap<>();
		FutureTask<ConcurrentMap<String, Long>> futureTask = new FutureTask<>(new ReaderThread(files));
		Thread reader = new Thread(futureTask);
		reader.start();
		try {
			wordCount = futureTask.get();
			reader.join();
			Thread writer = new Thread(new WriterThread(wordCount));
			writer.start();
		} catch (InterruptedException | ExecutionException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}

	/**
	 * Creates a directory.
	 */
	private static void createDirectory() {
		File file = new File(properties.getProperty("outputDirectory"));
		file.mkdir();
	}

}
