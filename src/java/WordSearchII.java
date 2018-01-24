package java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 1/11/18.
 */
public class WordSearchII {
    /*
    lazy way
     */
    public List<String> findWords(char[][] board, String[] words) {
        Arrays.sort(words);
        List<String> ans = new LinkedList<>();
        for(int i=0; i<words.length; i++){
            if((i==0||(i>0&&words[i]!=words[i-1])) && exist(board, words[i]))
                ans.add(words[i]);
        }
        return ans;
    }

    /*
    recursion
    */
    private boolean exist(char[][] board, String word) {
        for(int i=0 ; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(exist(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int x, int y, int idx){
        if(idx==word.length())
            return true;
        if(x<0 || x>board.length-1 || y<0 || y>board[0].length-1 || board[x][y]!=word.charAt(idx))
            return false;
        board[x][y] = '*';
        boolean flag = exist(board, word, x-1, y, idx+1)
                || exist(board, word, x, y-1, idx+1)
                || exist(board, word, x+1, y, idx+1)
                || exist(board, word, x, y+1, idx+1);
        board[x][y] = word.charAt(idx);
        return flag;
    }

    /*
    update: backtracking + trienode
     */
    public List<String> findWords2(char[][] board, String[] words) {
        List<String> ans = new LinkedList<>();
        TrieNode root = buildTrie(words);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                backtracking(board, i, j, root, ans);
            }
        }
        return ans;
    }

    private void backtracking(char[][] board, int i, int j, TrieNode root, List<String> ans){
        char c = board[i][j];
        if(c=='#' || root.children[c-'a']==null)
            return;
        root = root.children[c-'a'];
        if(root.word!=null){
            ans.add(root.word);
            root.word = null;
        }
        board[i][j]='#';
        if(i>0)
            backtracking(board, i-1, j, root, ans);
        if(j>0)
            backtracking(board, i, j-1, root, ans);
        if(i<board.length-1)
            backtracking(board, i+1, j, root, ans);
        if(j<board[0].length-1)
            backtracking(board, i, j+1, root, ans);
        board[i][j]=c;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(int i=0; i<words.length; i++){
            TrieNode node = root;
            for(int j=0; j<words[i].length(); j++){
                char c = words[i].charAt(j);
                int index = c - 'a';
                if(node.children[index]==null)
                    node.children[index] = new TrieNode();
                node = node.children[index];
            }
            node.word = words[i];
        }
        return root;
    }

    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
}
