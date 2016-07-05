package com.chris.leetcode;

class TrieNode {
    // Initialize your data structure here.
    public TrieNode() {
        val = ' ';
        children = new TrieNode[26];
        feq = 0;
    }
    
    public TrieNode(char val){
    	this.val = val;
    	children = new TrieNode[26];
    	feq = 0;
    }
    public char val;
    public TrieNode[] children;
    public int feq;
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	if (word.isEmpty()) return;
        TrieNode node = root;
        for (char c : word.toCharArray()){
        	int k = c - 'a';
        	if (node.children[k] == null){
        		node.children[k] = new TrieNode(c);
        	}
            node = node.children[k];
        }
        node.feq++;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return walk(word) > 0;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return walk(prefix) >= 0;
    }
    
    private int walk(String word){
    	if (word.isEmpty()) return -1;
        TrieNode node = root;
        for (char c : word.toCharArray()){
        	int k = c - 'a';
            if (node.children[k] == null) return -1;
            else node = node.children[k];
        }
        return node.feq;
    }
}
