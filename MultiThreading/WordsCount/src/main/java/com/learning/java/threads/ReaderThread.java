package com.learning.java.threads;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Reader Thread
 * 
 * @author shvetap
 *
 */
public final class ReaderThread implements Callable<ConcurrentMap<String, Long>> {

	List<File> files;
	ConcurrentHashMap<String, Long> wordCount = new ConcurrentHashMap<>();

	public ReaderThread(List<File> files) {
		super();
		this.files = files;
	}

	@Override
	public ConcurrentMap<String, Long> call() throws Exception {
		Pattern pattern = Pattern.compile("^[A-Za-z]*$");
		files.parallelStream().forEach(file -> {
			List<String> lines = readLines(file);
			lines.parallelStream().forEach(line -> {
				List<String> words = new ArrayList<>();
				Arrays.asList(line.trim().replaceAll(" +", " ").split(" ")).stream().forEach(word->{
					if(pattern.matcher(word).matches()) {
						words.add(word);
					}
				});
				words.forEach(word -> {
					if (wordCount.containsKey(word)) {
						wordCount.put(word, wordCount.get(word) + 1);
					} else {
						wordCount.put(word, (long) 1);
					}
				});
			});
		});
		return wordCount;

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
