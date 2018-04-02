package java;

import java.util.HashSet;

/**
 * Created by haileyyin on 3/30/18.
 */
public class PalindromePermutation {
    /*
        "aab"->"aba"
        */
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> hs = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
            } else {
                hs.add(s.charAt(i));
            }
        }

        return hs.size()==0 || hs.size()==1;
    }
}
