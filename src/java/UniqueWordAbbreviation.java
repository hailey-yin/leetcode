package java;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by haileyyin on 7/19/18.
 */
public class UniqueWordAbbreviation {
    HashMap<String, HashSet<String>> hm = new HashMap<>();

    public UniqueWordAbbreviation(String[] dictionary) {
        for (String str : dictionary) {
            if (str.length() == 0) {
                continue;
            }
            String abb = getAbb(str);
            HashSet<String> hs = hm.getOrDefault(abb, new HashSet<>());
            hs.add(str);
            hm.put(abb, hs);
        }
    }

    public boolean isUnique(String word) {
        String abb = getAbb(word);
        if (!hm.containsKey(abb)) {
            return true;
        }
        HashSet<String> hs = hm.get(abb);
        if (hs.size() == 1 && hs.contains(word)) {
            return true;
        }
        return false;
    }

    private String getAbb(String str) {
        if (str.length() == 0) {
            return "";
        }
        String abb = str.charAt(0) + "";
        if (str.length() > 2) {
            abb += str.length() - 2;
        }
        if (str.length() != 1) {
            abb += str.charAt(str.length() - 1);
        }
        return abb;
    }
}
