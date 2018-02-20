package com.learning.java.threads;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Reader Thread
 * 
 * @author shvetap
 *
 */
public final class ReaderThread implements Callable<List<String>> {

	File file;
	public ReaderThread(File file) {
		super();
		this.file = file;
	}

	@Override
	public List<String> call() throws Exception {
		List<String> words=new ArrayList<>();
		Pattern pattern = Pattern.compile("^[A-Za-z]*$");
			List<String> lines = readLines(file);
			lines.parallelStream().forEach(line -> {
				Arrays.asList(line.trim().split(" ")).stream().forEach(word->{
					if(pattern.matcher(word).matches()) {
						words.add(word);
					}
				});
			});
		return words;
	}

	/**
	 * Read lines from file
	 * 
	 * @param file
	 *            file from which lines are to be read
	 * @return list of lines
	 */
	private List<String> readLines(File file) {
		Logger logger = Logger.getLogger(ReaderThread.class.getName());
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(file.toPath());

		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
		return lines;
	}

}
