/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tubes_SDA;

import java.util.ArrayList;

/**
 *
 * @author Sumit Ghosh - GFG
 */
public class Trie {
    public TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    void insert(ArrayList<String> key) 
    { 
        int level; 
        int length = key.size();
        int index; 
       
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.get(level).charAt(0)-'1';
            if (pCrawl.children[index] == null) 
                pCrawl.children[index] = new TrieNode(); 
       
            pCrawl = pCrawl.children[index]; 
        } 
       
        // mark last node as leaf 
        pCrawl.isEndOfNumberSet = true; 
    }
    
    boolean search(ArrayList<String> key) 
    { 
        int level; 
        int length = key.size(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.get(level).charAt(0)-'1'; 
       
            if (pCrawl.children[index] == null) 
                return false; 
       
            pCrawl = pCrawl.children[index]; 
        } 
        
        pCrawl.support++;
        return (pCrawl != null && pCrawl.isEndOfNumberSet); 
    }
    
    int getSupport(ArrayList<String> key)
    {
        int level; 
        int length = key.size(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.get(level).charAt(0)-'1'; 
       
            if (pCrawl.children[index] == null) 
                return 0;
       
            pCrawl = pCrawl.children[index]; 
        } 
        
        return (pCrawl.support); 
    }
    
    void PrintPassedThreshold (ArrayList<String> key, int Treeshold){
        int level; 
        int length = key.size(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++){ 
            index = key.get(level).charAt(0)-'1'; 
            if (pCrawl.children[index] == null)
                System.out.println("NULL");
            pCrawl = pCrawl.children[index]; 
        }
        if(pCrawl.support > Treeshold)
            System.out.println(key + " Dengan Support = " + pCrawl.support);
    }
    
    void PrintAllDataSupport (ArrayList<String> key){
        int level; 
        int length = key.size(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++){ 
            index = key.get(level).charAt(0)-'1'; 
            if (pCrawl.children[index] == null)
                System.out.println("NULL");
            pCrawl = pCrawl.children[index]; 
        }
        if(pCrawl.support > 0)
            System.out.println(key + " Dengan Support = " + pCrawl.support);
    }
}