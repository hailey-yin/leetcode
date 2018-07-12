package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by haileyyin on 6/27/18.
 */
public class GroupShiftedStrings {
    /*
    Consider acf and pru. Now notice the differnce between each characters.
    acf = 0->2->3, and pru = 0->2->3. So these two form same group. So in this case, you can simply use integers ASCII difference to form key.

    Now consider corner case, az and ba, where az = 0->25 and ba = 0->-1. When it goes negative, just make it positive(rotate or mod equivalent) by adding 26. So it becomes, ba = 0->25, which forms same group.

    Space: O(n), n is length of String array
    Time: O(n*m), n is the same as above, m is the average length of string element in array.
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strings) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        char[] chars = s.toCharArray();
        String key = "";
        for(int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i-1];
            key += diff < 0 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }
    /*
    primitive way
    first put all strings into a hashmap with key == string, value == whether is has been classified
    for each string, we test all 26 ways of shifting, if they exists in the hashset.

    inefficient
    Time: O(n*26m) where k is the maximum length of the strings
    Space: O(n)
    */
    public List<List<String>> groupStrings1(String[] strings) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            hm.put(strings[i], hm.getOrDefault(strings[i],0)+1);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            List<String> cur = new ArrayList<>();
            if (hm.get(strings[i]) > 0) {
                cur.add(strings[i]);
                hm.put(strings[i], hm.get(strings[i])-1);
                for (int j = 1; j <= 26; j++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < strings[i].length(); k++) {
                        int ascii = strings[i].charAt(k) + j;
                        if (ascii > 122)
                            ascii -= 26;
                        sb.append(Character.toString ((char) ascii));
                    }

                    while (hm.containsKey(sb.toString()) && hm.get(sb.toString()) > 0){
                        cur.add(sb.toString());
                        hm.put(sb.toString(), hm.get(sb.toString())-1);
                    }
                }
                if (cur.size() > 0)
                    res.add(cur);
            }
        }
        return res;
    }
}
