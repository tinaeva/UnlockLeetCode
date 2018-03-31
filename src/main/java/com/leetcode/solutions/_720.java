package com.leetcode.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class _720 {
	public static void main(String[] args) {
		String[] w1 = {"w","wo","wor","worl", "world"};
		String[] w2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		System.out.println(longestWord1(w1) + " and " + longestWord1(w2));
	}
	
	private static String longestWord(String[] words) {
		TrieNode root = buildTrie(words);
		TrieNode temp = root;
		Arrays.sort(words, (a, b) -> b.length() == a.length()? a.compareTo(b): b.length() - a.length());
		
		for(String w: words) System.out.println(w);
		String res = null;
		int maxLen = 0;
		for(int i = 0; i < words.length; ++i) {
			StringBuilder sb = new StringBuilder();
			temp = root;
			for(char c: words[i].toCharArray()) {
				if(temp.children[c - 'a'] == null || !temp.children[c - 'a'].isWord) break;
				temp = temp.children[c - 'a'];
				sb.append(c);
			}
			if(sb.length() == words[i].length()) return words[i];
		}
		return res;
	}
	
	
	private static TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		TrieNode temp = root;
		for(String s: words) {
			temp = root;
			for(char c: s.toCharArray()) {
				if(temp.children[c - 'a'] == null) 
					temp.children[c - 'a'] = new TrieNode();
				temp = temp.children[c - 'a'];
			}
			temp.isWord = true;
		}
		return root;
	}
	
	private static String longestWord1(String[] words) {
//		Arrays.sort(words, (a,b) -> a.length() == b.length()? a.compareTo(b) : b.length() - a.length());
//        for(String word: words) System.out.println(word);
        Set<String> set = new HashSet<>();
        for(String s: words) set.add(s);
        
        String res = "";
        for(String str: words) {
        	if(str.length() > res.length() || str.length() == res.length() && str.compareTo(res) < 0) {
	        	boolean flag = true;
	            for(int i = 1; i < str.length(); ++i) {
	            	if(!set.contains(str.substring(0, i))) {
	            		flag = false;
	            		break;
	            	}
	            }
	            if(flag) {
	            	res = str;
	            }
        	}
        }
        return res;
    }

}

class TrieNode {
	TrieNode[] children;
	boolean isWord;
	TrieNode() {
		children = new TrieNode[26];
		isWord = false;
	}
	
	public boolean dfs(String word) {
		return dfs(word.substring(0, word.length() - 1));
	}
	
	@Override
	public String toString() {
		return "node";
	}
	
}
