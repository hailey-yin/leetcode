package java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by haileyyin on 3/30/18.
 */
public class PalindromePermutationII {
    /*
    backtracking
    space: O(n)
    */
    public List<String> generatePalindromes(String s) {
        List<String> res = new LinkedList<>();
        String mid = "";
        List<Character> list = new LinkedList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        int odd = 0;
        // step 1. build character count map and count odds
        for(int i=0; i<s.length(); i++) {
            int count = hm.getOrDefault(s.charAt(i), 0);
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
            odd += hm.get(s.charAt(i))%2==0? -1:1;
        }
        // cannot form any palindromic string
        if(odd>1)
            return res;
        // step 2. add half count of each character to list
        for(Map.Entry<Character, Integer> entry:hm.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0)
                mid += key;
            for(int i=0; i<val/2; i++){
                list.add(key);
            }
        }
        // step 3. generate all the permutations
        backtracking(list, res, new StringBuilder(), new boolean[list.size()], mid);
        return res;
    }

    private void backtracking(List<Character> list, List<String> res, StringBuilder sb, boolean[] used, String mid){
        if (sb.length() == list.size()) {
            // form the palindromic string
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

            if (!used[i]) {
                used[i] = true; sb.append(list.get(i));
                // recursion
                backtracking(list, res, sb, used, mid);
                // backtracking
                used[i] = false; sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
