package java;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by haileyyin on 7/13/18.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashSet<Character> hs = new HashSet<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int[] idx = new int[2];
        int cur = 0;
        for (int i = 0; i < t.length(); i++) {
            int count = hm.getOrDefault(t.charAt(i), 0);
            hm.put(t.charAt(i), count+1);
            hs.add(t.charAt(i));
        }
        int le = 0, ri = 0;
        while (ri < s.length() || hs.isEmpty()) {
            if (hs.isEmpty()) {  // all characters in t is in current window
                while (le < ri && !hm.containsKey(s.charAt(le))) {
                    le++;
                    cur--;
                }
                if (cur < min) {
                    min = cur;
                    idx[0] = le;
                    idx[1] = ri;
                }
                hm.put(s.charAt(le), hm.get(s.charAt(le))+1);
                if (hm.get(s.charAt(le)) > 0){
                    hs.add(s.charAt(le));
                }
                le++;
                cur--;
                while (le < ri && !hm.containsKey(s.charAt(le))) {
                    le++;
                    cur--;
                }
            } else {
                while (ri < s.length() - 1 && !hm.containsKey(s.charAt(ri))) {
                    ri++;
                    cur++;
                }
                if (hm.containsKey(s.charAt(ri))) {
                    hm.put(s.charAt(ri), hm.get(s.charAt(ri))-1);
                    if (hm.get(s.charAt(ri)) <= 0) {
                        hs.remove(s.charAt(ri));
                    }
                }
                if (ri < s.length()) {
                    ri++;
                    cur++;
                }

            }
        }
        return s.substring(idx[0], idx[1]);
    }

}
