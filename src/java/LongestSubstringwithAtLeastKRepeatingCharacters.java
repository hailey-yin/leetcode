package java;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by haileyyin on 4/3/18.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
    /*
    递归（Recursion）/ 分治法（Divide and Conquer）
    统计原始字符串s中各字符的出现次数，统计其中出现次数少于k次的字符，得到数组filters。
    若filters为空数组，则直接返回s的长度。
    以filters为分隔符，将s拆分为若干子串，分别递归计算各子串的结果，返回最大值。 sliding window
     */
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (counter.containsKey(c)) {
                counter.put(c, counter.get(c) + 1);
            } else {
                counter.put(c, 1);
            }
        }
        HashSet<Character> splitSet = new HashSet<Character>();
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                splitSet.add(c);
            }
        }
        if (splitSet.isEmpty()) {
            return s.length();
        }
        int max = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (splitSet.contains(c)) {
                if (j != i) {
                    max = Math.max(max, longestSubstring(s.substring(i, j), k));
                }
                i = j + 1;
            }
            j++;
        }
        if (i != j)
            max = Math.max(max, longestSubstring(s.substring(i, j), k));
        return max;
    }
}
