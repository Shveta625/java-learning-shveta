package com.java.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TrieNode {
	private static final int NUMBER_OF_ALPHABETS = 26;
	private boolean endOfWord;
	private TrieNode[] children;

	public TrieNode() {
		children = new TrieNode[NUMBER_OF_ALPHABETS];
		endOfWord = false;
	}

	/**
	 * Adds word to trie
	 * 
	 * @param string
	 */
	public void addWord(String string) {
		if (string == null || string == "") {
			return;
		}
		String word = string.toLowerCase();
		TrieNode current = this;
		Pattern pattern = Pattern.compile("^[a-z]*$");
		if (word != null && pattern.matcher(word).matches()) {
			String wordLower = word.toLowerCase();
			int wordLength = wordLower.length();
			for (int i = 0; i < wordLength; i++) {
				int index = wordLower.charAt(i) - 'a';
				if (current.children[index] == null) {
					current.children[index] = new TrieNode();
				}
				current = current.children[index];
			}
			current.endOfWord = true;
		}
	}

	/**
	 * Finds all words starting from a specific sequence
	 * 
	 * @param root
	 *            Root node of trie
	 * @param seq
	 *            Sequence corresponding which words have to be found
	 * @return list of words in trie starting from seq
	 */
	public static List<String> findBySequence(TrieNode root, String seq) {
		TrieNode current = root;
		for (int i = 0; i < seq.length(); i++) {
			if (current != null) {
				current = current.children[seq.charAt(i) - 'a'];
			}
		}
		return findAllFromCurrentNode(current, seq);

	}

	/**
	 * To get all words in Trie
	 * 
	 * @param root
	 *            Root node of trie
	 * @return List of all words in trie
	 */
	public static List<String> getAll(TrieNode root) {
		return findAllFromCurrentNode(root, "");
	}

	/**
	 * Finds all words from current node(node till stringTillCurrent in trie)
	 * @param current
	 * @param stringTillCurrent
	 * @return
	 */
	private static List<String> findAllFromCurrentNode(TrieNode current, String stringTillCurrent) {

		List<String> listOfWords = new ArrayList<>();
		if (current == null) {
			return listOfWords;
		}
		if (current.endOfWord) {
			listOfWords.add(stringTillCurrent);
		}
		for (int i = 0; i < NUMBER_OF_ALPHABETS; i++) {
			TrieNode node = current.children[i];
			if (node != null) {
				listOfWords
						.addAll(findAllFromCurrentNode(node, stringTillCurrent + Character.toString((char) (i + 'a'))));
			}
		}
		return listOfWords;
	}

}
