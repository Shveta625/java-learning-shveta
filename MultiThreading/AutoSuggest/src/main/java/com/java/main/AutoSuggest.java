package com.java.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.java.datastructure.TrieNode;
import com.learning.java.threads.ReaderThread;
import com.learning.java.util.DirectoryReader;
import com.learning.java.util.PropertiesLoader;

public class AutoSuggest {

	private static Properties properties = (new PropertiesLoader()).loadProperties();
	static TrieNode trie = new TrieNode();
	static List<String> words = new ArrayList<>();

	public static void main(String[] args) {
		createDirectory();
		List<File> files = Arrays.asList((new DirectoryReader(properties.getProperty("dirToRead"))).readDirectory());
		startThreads(files);
		createTrie(words);
		try {
			Files.write(Paths.get(properties.getProperty("outputDirectory") + "/" + "AutoSuggest.txt"),
					findSuggestions(args[0]));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Start reader and writer threads
	 * 
	 * @param files
	 */
	private static void startThreads(List<File> files) {
		Logger logger = Logger.getLogger(AutoSuggest.class.getName());
		FutureTask<List<String>> futureTask = new FutureTask<>(new ReaderThread(files));
		Thread reader = new Thread(futureTask);
		reader.start();
		try {
			words = futureTask.get();
			createTrie(words);
		} catch (InterruptedException | ExecutionException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}

	private static List<String> findSuggestions(String sequence) {
		return TrieNode.findBySequence(trie, sequence);
	}

	/**
	 * Creates a directory.
	 */
	private static void createDirectory() {
		File file = new File(properties.getProperty("outputDirectory"));
		file.mkdir();
	}

	private static TrieNode createTrie(List<String> words) {
		words.parallelStream().forEach(word -> {
			trie.addWord(word);
		});
		return trie;
	}
}
