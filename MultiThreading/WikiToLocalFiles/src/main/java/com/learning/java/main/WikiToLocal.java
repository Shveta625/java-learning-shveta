package com.learning.java.main;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.learning.java.threads.ReaderThread;
import com.learning.java.threads.WriterThread;
import com.learning.java.util.DirectoryReader;
import com.learning.java.util.FileReader;
import com.learning.java.util.PropertiesLoader;

/**
 * Copy data from Wiki to local
 * 
 * @author shvetap
 *
 */
public class WikiToLocal {

	private static PropertiesLoader propertiesLoader=PropertiesLoader.getInstance();
	public static void main(String[] args) {

		createDirectory();
		List<File> files = Arrays.asList((new DirectoryReader(propertiesLoader.getProperty("dirToRead"))).readDirectory());
		startThreads(files);

	}

	/**
	 * Creates a directory.
	 */
	private static void createDirectory() {
		File file = new File(propertiesLoader.getProperty("outputDirectory"));
		file.mkdir();
	}

	/**
	 * Start reader threads for words in files whose words are to be read
	 */
	private static void startThreads(List<File> files) {
		Logger logger = Logger.getLogger(ReaderThread.class.getName());
		files.parallelStream().forEach(file->{
			List<String> words = getWordsFromFile(file);
			words.parallelStream().forEach(searchWord -> {
				if (searchWord != null && !searchWord.isEmpty()) {
					FutureTask<String> futureTask = new FutureTask<>(new ReaderThread(searchWord));
					Thread readerThread = new Thread(futureTask);
					readerThread.start();
					try {
						Thread writerThread = new Thread(new WriterThread(searchWord, futureTask.get()));
						writerThread.start();
					} catch (InterruptedException | ExecutionException e) {
						logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
					}
				}
			});
		});
	}

	private static List<String> getWordsFromFile(File file) {
		String wordSeparator = propertiesLoader.getProperty(file.getName().replaceAll(" ", "") + ".separator");
		int wordPosition = Integer.parseInt(propertiesLoader.getProperty(file.getName().replaceAll(" ", "") + ".position"));
		FileReader fileReader = new FileReader.FileReaderBuilder(file).setWordSeperator(wordSeparator)
				.setWordPosition(wordPosition).build();
		return fileReader.read();

	}

}
