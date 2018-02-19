package com.java.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TrieNode {
	static final int NUMBER_OF_ALPHABETS = 26;
	boolean endOfWord;
	public TrieNode[] children;
	static List<String> listOfWords;

	public TrieNode() {
		children = new TrieNode[NUMBER_OF_ALPHABETS];
		endOfWord = false;
	}

	public void addWord(String string) {
		if(string==null || string=="") {
			return;
		}
		String word=string.toLowerCase();
		TrieNode current=this;
		Pattern pattern = Pattern.compile("^[a-z]*$");
		if (word!=null && pattern.matcher(word).matches()) {
			String wordLower = word.toLowerCase();
			int wordLength = wordLower.length();
			for (int i = 0; i < wordLength; i++) {
				int index=wordLower.charAt(i) - 'a';
				if(current.children[index]==null) {
					current.children[index] = new TrieNode();
				}
				current=current.children[index] ;
			}
			current.endOfWord = true;
		}
	}

	public static List<String> findBySequence(TrieNode root, String seq) {
		listOfWords=new ArrayList<>();
		TrieNode current = root;
		for(int i=0;i<seq.length();i++) {
			if(current!=null) {
			current=current.children[seq.charAt(i) - 'a'];
			}
		}
		findAllFromCurrentNode(current, seq);
		return listOfWords;
		
	}
	
	private static void findAllFromCurrentNode(TrieNode current, String stringTillCurrent) {
		if(current==null) {
			return;
		}
		if (current.endOfWord) {
			listOfWords.add(stringTillCurrent);
		}
		boolean allEmpty=true;
		for (int i = 0; i < NUMBER_OF_ALPHABETS; i++) {
			TrieNode node = current.children[i];
			if (node != null) {
				allEmpty=false;
				findAllFromCurrentNode(node, stringTillCurrent+Character.toString((char) (i + 'a')));
			}
		}
		if(allEmpty) {
			return;
		}
	}

}