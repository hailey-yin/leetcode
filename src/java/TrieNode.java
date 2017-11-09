package java;

/**
 * Created by haileyyin on 11/8/17.
 */
public class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public void TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
}
