package java;

import java.util.*;

/**
 * Created by haileyyin on 6/15/18.
 */
public class WordBreakII {
    /*
    DFS
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for (String word:wordDict) {
            set.add(word);
        }
        return DFS(s, set, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
    /*
    recursion: Time Limit Exceeded
     */
    HashSet<String> set = new HashSet<>();
    public List<String> wordBreak2(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        List<String> res = new ArrayList<>();
        helper(s, new StringBuilder(), res);
        return res;
    }
    private void helper(String s, StringBuilder sb, List<String> res) {
        if (s.length() == 0) {
            String temp = sb.toString();
            res.add(temp.substring(0, temp.length()-1));
        }
        for (int i = 1; i <= s.length(); i++) {
            if (!set.contains(s.substring(0,i))) {
                continue;
            } else {
                sb.append(s.substring(0,i));
                sb.append(" ");
                helper(s.substring(i), sb, res);
                sb.delete(sb.length()-i-1, sb.length());
            }
        }
    }
}
