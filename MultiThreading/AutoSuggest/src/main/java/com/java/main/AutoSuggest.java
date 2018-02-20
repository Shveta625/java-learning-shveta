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

/**
 * Auto Suggest
 * 
 * @author shvetap
 *
 */
public class AutoSuggest {

	private static Properties properties = (new PropertiesLoader()).loadProperties();
	static Logger logger = Logger.getLogger(AutoSuggest.class.getName());

	public static void main(String[] args) {
		createDirectory();
		List<File> files = Arrays.asList((new DirectoryReader(properties.getProperty("dirToRead"))).readDirectory());
		List<String> words = readWords(files);
		TrieNode trie = createTrie(words);
		List<String> suggestions = findSuggestions(trie, args[0]);
		writeToOutputFile(suggestions);
	}

	/**
	 * Write to output file
	 * 
	 * @param suggestions
	 *            Suggestions to be written
	 */
	private static void writeToOutputFile(List<String> suggestions) {
		try {
			Files.write(Paths.get(properties.getProperty("outputDirectory") + "/" + "AutoSuggest.txt"), suggestions);
		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}

	/**
	 * Read words from files
	 * 
	 * @param files
	 */
	private static List<String> readWords(List<File> files) {
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
	 * Find possible suggestions
	 * 
	 * @param trie
	 *            {@link TrieNode}
	 * @param sequence
	 *            sequence entered by user
	 * @return Suggestions corresponding input sequence
	 */
	private static List<String> findSuggestions(TrieNode trie, String sequence) {
		return TrieNode.findBySequence(trie, sequence);
	}

	/**
	 * Creates a directory.
	 */
	private static void createDirectory() {
		File file = new File(properties.getProperty("outputDirectory"));
		file.mkdir();
	}

	/**
	 * Creates trie
	 * 
	 * @param words
	 *            words to be included in trie
	 * @return {@link TrieNode}
	 */
	private static TrieNode createTrie(List<String> words) {
		TrieNode trie = new TrieNode();
		words.parallelStream().forEach(trie::addWord);
		return trie;
	}
}
