package java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by haileyyin on 7/8/18.
 */
public class SortCharactersByFrequency {
    /*
    using a HashMap to keep record of the occurence for each character
    then put the elements in HashMap in a list and sort by value
    Time: O(nlogn)
    Space: O(n)
    */
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = hm.getOrDefault(s.charAt(i), 0);
            hm.put(s.charAt(i), count + 1);
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(hm.entrySet());
        list.sort(Map.Entry.comparingByValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry:list) {
            int count = entry.getValue();
            while (count > 0) {
                sb.insert(0, entry.getKey());
                count--;
            }
        }
        return sb.toString();
    }
}
