package com.algo.data_structure.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            //set leaf node
            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] data = new String[]{"bananas", "ban", "ana"};
        for (String s : data) {
            trie.insert(s);
        }

        String[] input = new String[]{"bananas", "ba", "ana"};
        for (String s : input) {
            String exists = trie.search(s) ? "exists" : "doesn't exist";
            System.out.printf("Input: %s %s\n", s, exists);
        }
    }
}
