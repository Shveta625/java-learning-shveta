package com.learning.java.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.threads.ReaderThread;

/**
 * To read file
 * 
 * @author shvetap
 *
 */
public class FileReader {
	private File file;
	private String wordSeparator;
	private int wordPosition;
	private Charset charset;

	private FileReader(FileReaderBuilder fileReaderBuilder) {
		super();
		this.file = fileReaderBuilder.file;
		this.wordSeparator = fileReaderBuilder.wordSeparator;
		this.wordPosition = fileReaderBuilder.wordPosition;
		this.charset = fileReaderBuilder.charset;
	}

	/**
	 * Builder class for FileReader
	 * 
	 * @author shvetap
	 *
	 */
	public static class FileReaderBuilder {
		private File file;
		private String wordSeparator;
		private int wordPosition;
		private Charset charset;

		public FileReaderBuilder(File file) {
			super();
			this.file = file;
			this.charset = StandardCharsets.UTF_8;
		}

		public FileReaderBuilder setWordSeperator(String wordSeparator) {
			this.wordSeparator = wordSeparator;
			return this;
		}

		public FileReaderBuilder setWordPosition(int wordPosition) {
			this.wordPosition = wordPosition;
			return this;
		}

		public FileReader build() {
			return new FileReader(this);
		}
	}

	/**
	 * Reads file
	 * 
	 * @return words in file
	 */
	public List<String> read() {
		Logger logger = Logger.getLogger(ReaderThread.class.getName());
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(file.toPath(), charset);

		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
		return extractWordList(lines);
	}

	/**
	 * Extract words from lines
	 * 
	 * @param lines
	 *            lines from which words have to be extracted
	 * @return list of words
	 */
	private List<String> extractWordList(List<String> lines) {
		final List<String> wordList =Collections.synchronizedList(new ArrayList<>());
		if ("\n".equals(this.wordSeparator) && wordPosition < 0) {
			wordList.addAll(lines);
		} else {
			if (wordPosition >= 0) {
				lines.stream().parallel().forEach(a -> {
					String[] temp = a.split(this.wordSeparator);
					if (temp.length > wordPosition) {
						wordList.add(temp[this.wordPosition]);
					}
				});
			} else {
				lines.stream().parallel().forEach(a -> wordList.addAll(Arrays.asList(a.split(this.wordSeparator))));

			}
		}

		return wordList;
	}
}
