package java;

/**
 * Created by haileyyin on 11/8/17.
 */
public class ImplementTrie {
    /** Initialize your data structure here. */
    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            int childrenIdx = word.charAt(i)-'a';
            if(node.children[childrenIdx]==null){
                node.children[childrenIdx] = new TrieNode();
            }
            node = node.children[childrenIdx];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word, 0);
    }

    private boolean helper(TrieNode root, String word, int index){
        if(index==word.length()){
            return root.isWord;
        }
        char character = word.charAt(index);
        int childrenIdx = character-'a';
        if(root.children[childrenIdx] != null){
            return helper(root.children[childrenIdx], word, index+1);
        } else {
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++){
            char character = prefix.charAt(i);
            int childrenIdx = character - 'a';
            if(node.children[childrenIdx] != null) {
                node = node.children[childrenIdx];
            } else {
                return false;
            }
        }
        return false;
    }
}
