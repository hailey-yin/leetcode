package java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by haileyyin on 2/4/18.
 */
public class FindAllAnagramsinaString {
    /*
    sliding window: two pointers and map
    */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if(s.length()<p.length() || p==null)
            return res;
        int start = 0;
        int end = 0;
        int count = p.length();
        char[] cs = s.toCharArray();
        int[] map = new int[256];
        for(char c:p.toCharArray())
            map[c]++;
        while(end<s.length()){
            if(map[cs[end]]>=1)
                count--;
            map[cs[end]]--;
            end++;
            if(count==0)
                res.add(start);
            if(end-start==p.length()){
                if(map[cs[start]]>=0)
                    count++;
                map[cs[start]]++;
                start++;
            }

        }
        return res;
    }
    /*
    sliding window: two pointers and hashmap
    */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if(s.length()<p.length() || p==null)
            return res;
        Map<Character, Integer> map = new HashMap<>();
        for(char c:p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int start = 0;
        int end = 0;
        int counter =  map.size();
        while(end<s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            while(counter == 0){
                char tempc = s.charAt(start);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-start == p.length()){
                    res.add(start);
                }
                start++;
            }

        }
        return res;
    }
}
