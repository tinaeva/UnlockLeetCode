package com.leetcode.solutions;

import com.leetcode.common.classes.TrieNode;

import java.util.List;
import java.util.ArrayList;


class _648 {
	public static void main(String[] args) {
		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		String sentence = "the cattle was rattled by the battery";
		System.out.println("the shorter version is: " + replaceWords(dict, sentence));
	}
	private static String replaceWords(List<String> dict, String sentence) {
		String[] words = sentence.split("\\s+");
		TrieNode trie = buildTrie(dict);
		return replaceWords(words, trie);
	}
	private static String replaceWords(String[] words, TrieNode trie) {
		if(words == null || words.length == 0 || trie == null) return null;
		StringBuilder sb = new StringBuilder();
		for(String word: words) {
			sb.append(findShortestReplacement(word, trie) + " ");
		}
		return sb.substring(0, sb.length() - 1);
	}
	private static String findShortestReplacement(String word, TrieNode trie) {
		if(word == null || word.length() == 0 || trie == null) return null;
		StringBuilder sb = new StringBuilder();
		TrieNode temp = trie;
		for(char c: word.toCharArray()) {
			sb.append(c);
			if(temp.children[c - 'a'] == null) return word;
			temp = temp.children[c - 'a'];
			if(temp.isWord) return sb.toString();
		}
		return word;
	}
	private static TrieNode buildTrie(List<String> dict) {
		if(dict == null || dict.size() == 0) return null;
		TrieNode root = new TrieNode();
		for(String word: dict) {
			TrieNode temp = root;
			for(char c: word.toCharArray()) {
				if(temp.children[c - 'a'] == null) temp.children[c - 'a'] = new TrieNode();
				temp = temp.children[c - 'a'];
			}
			temp.isWord = true;
		}
		return root;
	}
}
