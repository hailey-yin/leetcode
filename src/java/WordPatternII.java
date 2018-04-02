package java;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by haileyyin on 3/29/18.
 */
public class WordPatternII {
    /*
    枚举 backtracking，通过哈希表和hashset来节约时间

    we can use a hash set to avoid duplicate matches, if character a matches string "red", then character b cannot be used to match "red".

    time:
    space: O(m+n)
     */
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        return isMatched(pattern, 0, str, 0, hm, hs);
    }

    private boolean isMatched(String pattern, int i, String str, int j, HashMap<Character, String> hm, HashSet<String> hs){
        if(i==pattern.length()&&j==str.length())
            return true;
        if(i==pattern.length()||j==str.length())
            return false;
        // get current pattern character
        char c = pattern.charAt(i);
        // if the pattern character exists
        if(hm.containsKey(c)){
            String temp = hm.get(c);
            // then check if we can use it to match str[i...i+s.length()]
            if(!str.startsWith(temp, j)){
                return false;
            }
            // if it can match, great, continue to match the rest
            return isMatched(pattern, i+1, str, j+temp.length(), hm, hs);
        }
        // pattern character does not exist in the map
        for(int k=j; k<str.length(); k++){
            String tempWord = str.substring(j, k+1);
            if(hs.contains(tempWord))
                continue;
            // create or update it
            hm.put(c, tempWord);
            hs.add(tempWord);
            // continue to match the rest
            if(isMatched(pattern, i+1, str, j+tempWord.length(), hm, hs))
                return true;
            // backtracking
            hm.remove(c);
            hs.remove(tempWord);
        }
        // we've tried our best but still no luck
        return false;
    }
}
