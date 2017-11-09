package java;

/**
 * Created by haileyyin on 11/8/17.
 */
public class AddandSearchWord {
    /** Initialize your data structure here. */
    private TrieNode root;

    public AddandSearchWord() {
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
        if(character != '.'){
            int childrenIdx = character-'a';
            if(root.children[childrenIdx] != null){
                return helper(root.children[childrenIdx], word, index+1);
            } else {
                return false;
            }
        } else {
            boolean res = false;
            for(int i=0; i<26; i++){
                if(root.children[i]!=null){
                    res = res || helper(root.children[i], word, index+1);
                }
            }
            return res;
        }
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */