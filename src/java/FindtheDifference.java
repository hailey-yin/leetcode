package java;

import java.util.HashMap;

/**
 * Created by haileyyin on 3/20/18.
 */
public class FindtheDifference {
    /*
    hashtable
    time: O(m+n)
    space: O(m)
    */
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int count = hs.getOrDefault(c, 0);
            hs.put(c, count+1);
        }
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(hs.containsKey(c) && hs.get(c)>0){
                hs.put(c, hs.get(c)-1);
            } else {
                return c;
            }
        }
        return '?';
    }
    /*
    bit manipulation
     It’s because of the properties of XOR.
     If we have two strings, “ab” and “abc”, then c = (a XOR b) XOR (a XOR b XOR c).
     One of XOR properties is a XOR b = b XOR a. So c = (a XOR a) XOR (b XOR b) XOR c.
     */
    public char findTheDifference2(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }
        return c;
    }
}
