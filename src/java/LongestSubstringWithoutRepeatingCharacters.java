package java;

import java.util.HashMap;

/**
 * Created by haileyyin on 11/3/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int end=0; end<s.length(); end++){
            if(hmap.containsKey(chars[end])){
                start = Math.max(start,hmap.get(chars[end])+1);
            }
            hmap.put(chars[end],end);
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}
