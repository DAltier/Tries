package com.codingdojo.danaaltier.tries;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Trie {
	
	// Attributes
    public Node root;
    
    
    // Constructor
    public Trie() {
        this.root = new Node();
    }
    
    
    // Methods
    public void insertWord(String word) {
        // gets the root node;
        Node currentNode = this.root;
        
        // iterates over every character in the word
        for(int i = 0; i < word.length(); i++) {
            // currentLetter is just the character / letter at the iteration
            Character currentLetter = word.charAt(i);
            // ask if the current letter is in the map of the current node
            Node child = currentNode.children.get(currentLetter);
            if(child == null) {
                child = new Node();
                currentNode.children.put(currentLetter, child); 
            } 
            
            currentNode = child;
        }
        currentNode.isCompleteWord = true;
    }
    
    
    public boolean isPrefixValid(String prefix) {
    	Node node = this.root;
    	for (int i = 0; i < prefix.length(); i++) {
    		Node next = node.children.get(prefix.charAt(i));
    		if (next == null) {
    			return false;
    		}
    		node = next;
    	}
    	return !node.children.isEmpty();
    }
    
    
    public boolean isWordValid(String word) {
    	Node node = this.root;
    	for (int i = 0; i < word.length(); i++) {
    		Node next = node.children.get(word.charAt(i));
    		if (next == null) {
    			return false;
    		}
    		node = next;
    	}
    	return node.isCompleteWord;
    }
    
    
    public void printAllKeys() {
    	Node node = this.root;
    	print(node, 0, new StringBuilder(""));
    }
    
    public void print(Node rootNode,int level, StringBuilder sequence) {
        if(!rootNode.children.isEmpty()){
            Set<Character> keys = rootNode.children.keySet();
            for(Character key : keys) {
            	System.out.println(key);
            }
        }
        Map<Character, Node> children = rootNode.children;
        Iterator<Character> iterator = children.keySet().iterator();
        while (iterator.hasNext()) {
            char character = iterator.next();
            sequence = sequence.insert(level, character); 
            print(children.get(character), level+1, sequence);
            sequence.deleteCharAt(level);
        }
    }
    
}
