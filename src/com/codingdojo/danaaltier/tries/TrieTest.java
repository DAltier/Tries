package com.codingdojo.danaaltier.tries;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("car");
        trie.insertWord("card");
        trie.insertWord("chip");
        trie.insertWord("trie");
        trie.insertWord("try");
        
        System.out.println("------ Is Prefix Valid? ------");
        System.out.println(trie.isPrefixValid("tr"));
        System.out.println(trie.isPrefixValid("chp"));
        
        
        System.out.println("------ Is Word Valid? ------");
        System.out.println(trie.isWordValid("trie"));
        System.out.println(trie.isWordValid("ch"));
        
        
        System.out.println("------ Printing all keys in the trie ------");
        trie.printAllKeys();
    }
}

