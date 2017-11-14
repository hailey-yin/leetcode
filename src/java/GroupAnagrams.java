package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by haileyyin on 11/13/17.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!hmap.containsKey(key))
                hmap.put(key, new ArrayList<String>());
            hmap.get(key).add(strs[i]);
        }
        return new ArrayList<List<String>>(hmap.values());
    }
}
