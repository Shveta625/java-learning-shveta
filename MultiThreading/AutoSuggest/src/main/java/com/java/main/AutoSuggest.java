package com.java.main;

import java.io.File;
import java.util.Arrays;
import java.util.List;

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

	private static PropertiesLoader propertiesLoader=PropertiesLoader.getInstance();

	public static void main(String[] args) {
		FileUtil.createDirectory(propertiesLoader.getProperty("outputDirectory"));
		List<File> files = Arrays.asList((FileUtil.readDirectory(propertiesLoader.getProperty("dirToRead"))));
		List<String> words = FileUtil.readWords(files);
		TrieNode trie = createTrie(words);
		List<String> suggestions = findSuggestions(trie, args[0]);
		FileUtil.writeToOutputFile(suggestions,propertiesLoader.getProperty("outputDirectory") + "/" + "AutoSuggest.txt");
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
