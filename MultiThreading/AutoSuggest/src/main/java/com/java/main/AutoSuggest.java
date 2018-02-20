package com.java.main;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.java.datastructure.TrieNode;
import com.learning.java.util.FileUtil;
import com.learning.java.util.PropertiesLoader;

/**
 * Auto Suggest
 * 
 * @author shvetap
 *
 */
public class AutoSuggest {

	private static Properties properties = (new PropertiesLoader()).loadProperties();

	public static void main(String[] args) {
		FileUtil.createDirectory(properties.getProperty("outputDirectory"));
		List<File> files = Arrays.asList((FileUtil.readDirectory(properties.getProperty("dirToRead"))));
		List<String> words = FileUtil.readWords(files);
		TrieNode trie = createTrie(words);
		List<String> suggestions = findSuggestions(trie, args[0]);
		FileUtil.writeToOutputFile(suggestions,properties.getProperty("outputDirectory") + "/" + "AutoSuggest.txt");
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
