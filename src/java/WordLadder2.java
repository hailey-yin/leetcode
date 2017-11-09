package java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by haileyyin on 11/8/17.
 */
public class WordLadder2 {
    /*
        dfs
        Time Limit Exceeded
         */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        HashSet<String> notVisited = new HashSet<>(wordList);
        if(notVisited.contains(beginWord)){
            notVisited.remove(beginWord);
        }
        List<String> curr = new LinkedList<>();
        curr.add(beginWord);
        helper(beginWord, endWord, notVisited, curr, res);
        return res;
    }

    private void helper(String beginWord, String endWord, HashSet<String> notVisited, List<String> curr, List<List<String>> res){
        if(beginWord.equals(endWord)){
            if(res.size()==0 || res.get(0).size()==curr.size()){
                res.add(new LinkedList<>(curr));
            } else if(res.get(0).size()>curr.size()){
                res.clear();
                res.add(new LinkedList<>(curr));
            }
        } else if(res.size()==0 || curr.size()<res.get(0).size()){
            for(int i=0; i<beginWord.length(); i++){
                char[] wordUnit = beginWord.toCharArray();
                for(char j='a'; j<='z'; j++){
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if(notVisited.contains(temp)){
                        curr.add(temp);
                        notVisited.remove(temp);
                        helper(temp, endWord, notVisited, curr, res);
                        notVisited.add(temp);
                        curr.remove(curr.size()-1);
                    }
                }
            }
        }
    }public String longestPalindrome(String s) {

    }
}
