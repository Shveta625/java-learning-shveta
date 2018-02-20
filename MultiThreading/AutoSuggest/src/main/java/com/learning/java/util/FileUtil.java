package com.learning.java.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.threads.ReaderThread;

/**
 * To read directory
 * 
 * @author shvetap
 *
 */
public final class FileUtil {

	/**
	 * Private constructor to avoid instantiation
	 */
	private FileUtil() {

	}

	private static Logger logger = Logger.getLogger(FileUtil.class.getName());

	/**
	 * Reads directory
	 * 
	 * @param dirToRead
	 *            directory to read
	 * @return {@link File} array
	 */
	public static File[] readDirectory(String dirToRead) {
		File[] files = null;
		File dir = new File(
				Paths.get(Paths.get(System.getProperty("user.dir")).getParent().toString() + "/" + dirToRead).toUri());
		files = dir.listFiles();
		return files;
	}

	/**
	 * 
	 * Write to output file
	 * 
	 * @param suggestions
	 *            Suggestions to be written
	 * @param outputFilePath
	 *            output file path
	 */
	public static void writeToOutputFile(List<String> suggestions, String outputFilePath) {
		try {
			Files.write(Paths.get(outputFilePath), suggestions);
		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}

	/**
	 * Read words from files
	 * 
	 * @param files
	 */
	public static List<String> readWords(List<File> files) {
		List<String> words = new ArrayList<>();
		files.parallelStream().forEach(file -> {
			FutureTask<List<String>> futureTask = new FutureTask<>(new ReaderThread(file));
			Thread reader = new Thread(futureTask);
			reader.start();
			try {
				words.addAll(futureTask.get());
			} catch (InterruptedException | ExecutionException e) {
				logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
			}
		});
		return words;
	}

	/**
	 * Creates a directory.
	 * 
	 * @param directory
	 *            name of directory
	 */
	public static void createDirectory(String directory) {
		File file = new File(directory);
		file.mkdir();
	}

}
