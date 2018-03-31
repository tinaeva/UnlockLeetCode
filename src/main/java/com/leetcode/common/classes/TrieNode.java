package com.leetcode.common.classes;

public class TrieNode {
	public TrieNode[] children;
	public boolean isWord;
	
	public TrieNode() {
		this.children = new TrieNode[26];
		this.isWord = false;
	}
/*
	public TrieNode[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	*/
	
}